package money

import org.scalatest._

class MoneyTest extends FunSpec with Matchers {

  testMultiplication()
  testFrancMultiplication()
  testEquality()

  def testMultiplication(): Unit ={
    describe("Moneyは") {
      it("正しく合計値が何度でも計算できる") {
        val five: Money = Dollar(5)
        Dollar(10) shouldEqual five.times(2)
        Dollar(15) shouldEqual five.times(3)
      }
      it("別のMoneyと等価である") {
        Dollar(5) shouldEqual Dollar(5)
      }
    }
  }

  def testFrancMultiplication(): Unit ={
    describe("Francは") {
      it("正しく乗算できる") {
        val five:Franc = Franc(5)
        five.times(2) shouldEqual Franc(10)
        five.times(3) shouldEqual Franc(15)
      }
    }
  }

  def testEquality(): Unit = {
    describe("Moneyは"){
      it("別々の通貨を同額か、正しく比較できる"){
        Dollar(5) shouldEqual Dollar(5)
        Dollar(5) should not be Dollar(10)
        Franc(10) shouldEqual Franc(10)
        Franc(15) should not be Franc(20)
        Franc(5) should not be Dollar(5)
      }
    }
  }

}


