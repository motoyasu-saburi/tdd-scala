package money

import org.scalatest._
import org.scalatest.matchers._
import org.scalatest.FunSuite

class MoneyTest extends FunSpecLike {

  def testMulttiplication(): Unit ={
    describe("Moneyは") {
      it("正しく合計値が何度でも計算できる") {
        val five: Dollar = new Dollar(5)
        assert(new Dollar(10) == five.times(2))
        assert(new Dollar(15) == five.times(3))
      }
      it("別のMoneyと等価である") {
        assert(new Dollar(5) equals new Dollar(5))
      }
    }
  }

  def testFrancMultiplication(): Unit ={
    val five:Franc = new Franc(5)
    assert(new Franc(10) equals five.times(2))
    assert(new Franc(15) equals five.times(3))
  }

}


