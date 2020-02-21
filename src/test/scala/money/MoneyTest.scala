package money

import org.scalatest._

class MoneyTest extends FunSpec with Matchers {


  describe("Moneyは") {
    it("正しく合計値が何度でも計算できる") {
      implicit val myCurrency: MyCurrency = MyCurrency.DollarCurrency

      val five: Money = MyCurrency(5)
      MyCurrency(10) shouldEqual five.times(2)
      MyCurrency(15) shouldEqual five.times(3)
    }
    it("別のMoneyと等価である") {
      implicit val myCurrency: MyCurrency = MyCurrency.DollarCurrency
      MyCurrency(5) shouldEqual MyCurrency(5)
      MyCurrency(5) should not be MyCurrency(6)
    }
  }


  describe("Francは") {
    it("正しく乗算できる") {
      implicit val myCurrency: MyCurrency = MyCurrency.FrancCurrency
      val five:Money = MyCurrency(5)
      five.times(2) shouldEqual MyCurrency(10)
      five.times(3) shouldEqual MyCurrency(15)
    }
  }

  describe("Moneyは"){
    it("別々の通貨を同額か、正しく比較できる"){
      MyCurrency(5)(MyCurrency.DollarCurrency) shouldEqual MyCurrency(5)(MyCurrency.DollarCurrency)
      MyCurrency(5)(MyCurrency.DollarCurrency)  should not be MyCurrency(10)(MyCurrency.DollarCurrency)
      MyCurrency(10)(MyCurrency.FrancCurrency) shouldEqual MyCurrency(10)(MyCurrency.FrancCurrency)
      MyCurrency(15)(MyCurrency.FrancCurrency) should not be MyCurrency(20)(MyCurrency.FrancCurrency)

      MyCurrency(5)(MyCurrency.FrancCurrency) should not be MyCurrency(5)(MyCurrency.DollarCurrency)
    }
  }

  describe("通貨を正しく比較できること"){
    it("国ごとの通貨を比較できること") {
      MyCurrencyUnit.USD shouldEqual
        MyCurrency(1)(MyCurrency.DollarCurrency).currencyUnit

      MyCurrencyUnit.CHF shouldEqual
        MyCurrency(1)(MyCurrency.FrancCurrency).currencyUnit


      "CHF" shouldEqual MyCurrency(1)(MyCurrency.FrancCurrency).currency
    }
  }

}


