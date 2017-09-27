package example

import scala.io.StdIn
import org.apache.spark._
import org.apache.spark.rdd.RDD
import org.apache.spark.streaming._
import org.apache.log4j.Logger
import org.apache.log4j.Level


object Main extends App {
  //Set loglevel off to make result read easily
  Logger.getLogger("org").setLevel(Level.OFF)
  Logger.getLogger("akka").setLevel(Level.OFF)

  //Make stream
  val conf = new SparkConf().setMaster("local[2]").setAppName("NetworkIncrement")
  val ssc = new StreamingContext(conf, Seconds(1))
  val line = ssc.socketTextStream("localhost", 9999)
  line.print()

  //Call increment_num
  line.foreachRDD(rdd=> {
    rdd.collect().foreach(n=>println(Calc.increment_num(n)))
  })

  //Start stream
  ssc.start()
  ssc.awaitTermination()
}

object Calc{
  //Increment input number if it is intger
  //Otherwise, return 0
  def increment_num(str: String):Int = {
    val num = try{ str.toInt+1 } catch { case e:Exception => 0 }
    return num
  }
}
