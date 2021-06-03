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
| :-----:| :---: |
| select | select |
| select | select |
| SELECT a, b, SUM( c ) FROM tab1 GROUP BY a, b GROUPING SETS ( (a, b), a, b, ( ) ) | |

