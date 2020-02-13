package money

import org.scalatest._

class MoneyTest extends FunSpecLike {

  def testMultiplication(): Unit ={
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
    describe("Francは") {
      it("正しく乗算できる") {
        val five:Franc = new Franc(5)
        assert(new Franc(10) equals five.times(2))
        assert(new Franc(15) equals five.times(3))
      }
    }
  }

  def testEquality(): Unit = {
    describe("Moneyは"){
      it("別々の通貨を同額か、正しく比較できる"){
        assert(new Franc(4) equals new Dollar(5))
        assert(!(new Franc(6) equals new Dollar(6)))
        assert(new Franc(10) equals new Dollar(2))
        assert(!(new Franc(15) equals new Dollar(3)))
      }
    }
  }

}


