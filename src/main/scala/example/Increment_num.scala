package example

object Main extends App {

  val strAry = io.StdIn.readLine()
  println(Increment.increment_num(strAry))
}

object Increment{
  def increment_num(str: String):Int = {
    //import scala.util.control.Exception._
    val num = try{ str.toInt+1 } catch { case e:Exception => 0 }
    return num
    //catching(classOf[NumberFormatException]) opt str.toInt
  }
}
