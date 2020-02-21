package money

import org.scalatest._

class MoneyTest extends FunSpec with Matchers {


  describe("Moneyは") {
    it("正しく合計値が何度でも計算できる") {
      implicit val myCurrency: MyCurrencyUnit = MyCurrencyUnit.USD

      val five: Money = MyCurrency(5)
      MyCurrency(10) shouldEqual five.times(2)
      MyCurrency(15) shouldEqual five.times(3)
    }
    it("別のMoneyと等価である") {
      implicit val myCurrency: MyCurrencyUnit = MyCurrencyUnit.USD
      MyCurrency(5) shouldEqual MyCurrency(5)
      MyCurrency(5) should not be MyCurrency(6)
    }
  }


  describe("Francは") {
    it("正しく乗算できる") {
      implicit val myCurrency: MyCurrencyUnit = MyCurrencyUnit.CHF
      val five:Money = MyCurrency(5)
      five.times(2) shouldEqual MyCurrency(10)
      five.times(3) shouldEqual MyCurrency(15)
    }
  }

  describe("Moneyは"){
    it("別々の通貨を同額か、正しく比較できる"){
      MyCurrency(5)(MyCurrencyUnit.USD) shouldEqual MyCurrency(5)(MyCurrencyUnit.USD)
      MyCurrency(5)(MyCurrencyUnit.USD)  should not be MyCurrency(10)(MyCurrencyUnit.USD)
      MyCurrency(10)(MyCurrencyUnit.CHF) shouldEqual MyCurrency(10)(MyCurrencyUnit.CHF)
      MyCurrency(15)(MyCurrencyUnit.CHF) should not be MyCurrency(20)(MyCurrencyUnit.CHF)

      MyCurrency(5)(MyCurrencyUnit.CHF) should not be MyCurrency(5)(MyCurrencyUnit.USD)
    }
  }

  describe("通貨を正しく比較できること"){
    it("国ごとの通貨を比較できること") {
      MyCurrencyUnit.USD shouldEqual
        MyCurrency(1)(MyCurrencyUnit.USD).currencyUnit

      MyCurrencyUnit.CHF shouldEqual
        MyCurrency(1)(MyCurrencyUnit.CHF).currencyUnit
    }
  }

}


