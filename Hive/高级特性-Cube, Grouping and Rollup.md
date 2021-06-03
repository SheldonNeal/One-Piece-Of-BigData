## Enhanced Aggregation, Cube, Grouping and Rollup
hive针对group by做了一些高级的支持，主要的就是  
+ Grouping
+ Cube
+ Rollup

这三个语句其实都是相当于把几个group by的结果进行union操作，只不过规则有细微的区别；
1. with cube就是  

