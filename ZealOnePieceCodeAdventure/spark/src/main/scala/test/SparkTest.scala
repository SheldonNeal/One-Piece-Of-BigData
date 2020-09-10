package test

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object SparkTest {



  def main(args: Array[String]): Unit = {
    val sc = new SparkContext(new SparkConf().setAppName("").setMaster("local[*]"))
    //屏蔽日志
//    Logger.getLogger("org.apache.spark").setLevel(Level.WARNING)
//    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.OFF)
    sc.setLogLevel("ERROR")
    //日期 用户 年龄





  }



  /**
    * 留存用户的计算
    * 所有用户和活跃用户的总数及平均年龄。(活跃用户指连续两天都有访问记录的用户)
      日期 用户 年龄
      11,test_1,23
      11,test_2,19
      11,test_3,39
      11,test_1,23
      11,test_3,39
      11,test_1,23
      12,test_2,19
      13,test_1,23
    * @param rdd
    */
  def getRemainUsers(rdd: RDD[String]) = {
    rdd.distinct().map(x=>{
      val split = x.split(",")
      val time = split(0)
      val userId = split(1)
      val age = split(2)
      (userId,(time,age))
    }).groupByKey().map(x=>{
      val userId = x._1
      val timeAndAgeList = x._2
    })


  }
  /**
    *  spark实现分组排序
    * @param rdd
    */
  def getTopkValues(rdd: RDD[String]) = {
    val rddGroup =rdd.map(x=>{
      val split = x.split("\t")
      (split(0),split(1))
    }).groupByKey()
    val top3Value = rddGroup.map(value=>{
      val key = value._1
      //      val values = value._2.toList.sortWith(_>_)
      //      val values = value._2.toList.sorted.reverse
      val values = value._2.toList.sortBy(x=>x).reverse
      (key,values.take(3))
    })

    top3Value.foreach(println(_))
  }


}
