## Enhanced Aggregation, Cube, Grouping and Rollup
hive针对group by做了一些高级的支持，主要的就是  
+ Grouping
+ Cube
+ Rollup

这三个语句其实都是相当于把几个group by的结果进行union操作，只不过规则有细微的区别；
1. with cube就是对group by字段进行排列组合，对所有的组合进行分组聚合计算  
2. rollup的逻辑是group by的字段有级联关系，逐级进行分组聚合计算  
3. grouping set允许用户对group by字段进行自由组合  
具体示例如下：  

| 高级sql | 等价sql |  
| :-----| :--- |
| GROUP BY a, b, c WITH CUBE  | GROUP BY a, b, c GROUPING SETS ( (a, b, c), (a, b), (b, c), (a, c), (a), (b), (c), ( )) |
| GROUP BY a, b, c, WITH ROLLUP | GROUPING SETS ( (a, b, c), (a, b), (a), ( )) |
| SELECT a, b, SUM( c ) FROM tab1 GROUP BY a, b GROUPING SETS ( (a, b), a, b, ( ) ) | SELECT a, b, SUM( c ) FROM tab1 GROUP BY a, b <br> UNION <br> SELECT a, null, SUM( c ) FROM tab1 GROUP BY a, null <br> UNION <br> SELECT null, b, SUM( c ) FROM tab1 GROUP BY null, b <br> UNION <br> SELECT null, null, SUM( c ) FROM tab1|

另外，针对于上面3个表达式，有2个配套使用的表达式：  
1.Grouping function：判断是否字段参与group计算，0表示参与计算，1表示未参与计算  
2.Grouping__ID function：判断哪些字段参与了group计算，主要区分字段本身为NULL和字段不参与计算（置为NULL）；0表示未参与，1表示参与  

###参数调优  
hive.new.job.grouping.set.cardinality  
说明：这个参数决定是否开启新的MR进行分组计算。  
如果设置值为4，如果参与的计算的维度基数大于4，就会新开启一个MR。