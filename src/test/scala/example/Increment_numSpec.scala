package example

import org.scalatest._

class CalcTest extends FunSpec{
  describe("Test for increment_num") {
    it("Integer"){
      for(i <- -9 to 9) assert(Calc.increment_num(i.toString) === i+1)
    }
    it("Srting"){
      ('a' to 'z').foreach(s=>assert(Calc.increment_num(s.toString) === 0))
    }
    it("Double"){
      List(-0.1,0.5,-9999999.9,9.0).foreach(d=>assert(Calc.increment_num(d.toString) === 0))
    }
    it("Space"){
      assert(Calc.increment_num(" ") === 0)
    }
  }
}

/*
class HelloSpec extends FlatSpec with Matchers {
  "The Hello object" should "say hello" in {
    Calc.increment_num shouldEqual "hello"
  }
}
*/
