package money

sealed abstract class Money {
  implicit val currencyUnit: MyCurrencyUnit

  def moneyAmount: Int

  def times(multiplier: Int): Money = {
    MyCurrency(this.moneyAmount * multiplier)
  }
}

case class Dollar(private val dollarAmount: Int) extends Money {
  implicit val currencyUnit: MyCurrencyUnit = MyCurrencyUnit.USD
  override def moneyAmount: Int = dollarAmount
}

case class Franc(private val francAmount: Int) extends Money {
  implicit val currencyUnit: MyCurrencyUnit = MyCurrencyUnit.CHF
  override def moneyAmount: Int = francAmount
}
