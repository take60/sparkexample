package example

object Main extends App {

  val strAry = io.StdIn.readLine()
  println(Calc.increment_num(strAry))
}

object Calc{
  def increment_num(str: String):Int = {
    val num = try{ str.toInt+1 } catch { case e:Exception => 0 }
    return num
  }
}
