package example

import scala.io.StdIn
import org.apache.spark._
import org.apache.spark.rdd.RDD
import org.apache.spark.streaming._
import org.apache.log4j.Logger
import org.apache.log4j.Level


object Main extends App {

  Logger.getLogger("org").setLevel(Level.OFF)
  Logger.getLogger("akka").setLevel(Level.OFF)
  //val strAry = StdIn.readLine()
  //println(Calc.increment_num(strAry))
  val conf = new SparkConf().setMaster("local[2]").setAppName("NetworkIncrement")
  val ssc = new StreamingContext(conf, Seconds(1))
  val line = ssc.socketTextStream("localhost", 9999)
  line.print()

  line.foreachRDD(rdd=> {
    rdd.collect().foreach(n=>println(Calc.increment_num(n)))
  })

  ssc.start()
  ssc.awaitTermination()
}

object Calc{
  def increment_num(str: String):Int = {
    val num = try{ str.toInt+1 } catch { case e:Exception => 0 }
    return num
  }
}
