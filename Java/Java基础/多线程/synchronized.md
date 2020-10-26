# synchronized
今天我们来学习一下synchronized，跟之前一样，我们要先知道为什么需要synchronized？
它有什么特点？应用场景是什么？底层原理是什么？
## 为什么需要synchronized
## synchronized特点
+ 是可重入锁
+ 锁升级的设计  
偏向锁 --> 自旋锁（轻量级锁） --> 重量级锁  
## CAS 和 ABA问题

## synchronized代码演示
详见
## 参考  
通过一个故事理解可重入锁的机制   
https://www.cnblogs.com/gxyandwmm/p/9387833.html  
让你彻底理解Synchronized  
https://www.jianshu.com/p/d53bf830fa09