package money

import org.scalatest._
import org.scalatest.matchers._
import org.scalatest.FunSuite

class MoneyTest extends FunSpecLike {

  describe("Moneyは") {
    it("正しく合計値が何度でも計算できる") {
      val five: Dollar = new Dollar(5)
      val product: Dollar = five.times(2)
      assert(10 == product.amount)

      val newProduct = five.times(3)
      assert(15 == newProduct.amount)
    }
    it("別のMoneyと等価である") {
      assert(new Dollar(5) equals new Dollar(5))
    }
  }


}

class Dollar(var amount: Int) {
  def times(multiplier: Int): Dollar ={
    new Dollar(amount * multiplier)
  }

  def equals(dollar: Dollar): Boolean = {
    amount == dollar.amount
  }
}
