##KUDU初识
官网：https://kudu.apache.org/docs/schema_design.html
###概览
1、列式存储数据库  
2、主从架构 master/server  
3、分布式存储，主要概念：table/tablet(连续的segment)  
4、选举算法：Raft Consensus Algorithm  

###Master and Server
1.负责管理metadata、tablets、tablet servers、Catalog table  
2.和客户端进行交互，管理元数据，将元数据写入Catalog table，并且通知servers创建相应的tablet  
3.master管理的所有数据都在一个tablet上，并且可以共享给任意候选者  
4.server发送心跳给master  

###Column Encoding
1.Plain Encoding  
2.Bitshuffle  
3.Run Length  
4.Dictionary  
5.Prefix  

###Primary Key
1.创建后不能修改
2.不支持自增
3.不支持批量范围更新操作
4.聚簇索引

###Partitioning
1.Range
2.Hash



参考链接：kudu设计原理初探 http://www.nosqlnotes.com/technotes/kudu-design/
