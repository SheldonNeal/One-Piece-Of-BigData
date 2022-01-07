## 配置
1.hive.groupby.orderby.position.alias   

官方解释：https://cwiki.apache.org/confluence/display/Hive/Configuration+Properties#ConfigurationProperties-hive.groupby.orderby.position.alias  

hive.groupby.orderby.position.alias  
Default Value: false  
Whether to enable using Column Position Alias in GROUP BY and ORDER BY clauses of queries.  
将它设置成true之后，我们可以执行类似下面这样的sql语句：  

```
select b.pos,
       regexp_extract(b.rout,'[^A]+$',0) as lastpg,
       count(1) as cnt
from xyzs.odl_httpact_xyzs a 
lateral view json_tuple(substr(a.custom2, 2, length(a.custom2)-2),'op','pos','rout') b as op,pos,rout 
where a.ds='2016-05-15' and a.terminal='xydb_android' and a.appv='1.1.8' and b.op='1' 
group by 1,2
即使用位置符号来表示需要group by的字段，  
否则只能写成

select b.pos,
       regexp_extract(b.rout,'[^A]+$',0) as lastpg,
       count(1) as cnt
from xyzs.odl_httpact_xyzs a 
lateral view json_tuple(substr(a.custom2, 2, length(a.custom2)-2),'op','pos','rout') b as op,pos,rout 
where a.ds='2016-05-15' and a.terminal='xydb_android' and a.appv='1.1.8' and b.op='1' 
group by b.pos,
         regexp_extract(b.rout,'[^A]+$',0)   

对于order by 也同样适用，可以写order by 1,2来代替原始字段.
```
  
2.hive.auto.convert.join和hive.optimize.skewjoin存在冲突，有时会导致执行计划有问题，不能同时开  
待分析原因？