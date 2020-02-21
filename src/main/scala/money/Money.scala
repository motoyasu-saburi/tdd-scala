package money

sealed abstract class Money {
  val currencyUnit: MyCurrencyUnit

  def times(multiplier: Int): Money
  def currency():String

}

case class Dollar(amount: Int) extends Money {
  val currencyUnit: MyCurrencyUnit = MyCurrencyUnit.USD

  override def times(multiplier: Int): Money =
    Dollar(this.amount * multiplier)

  override def currency(): String = "USD"
}

case class Franc(amount: Int) extends Money {
  val currencyUnit: MyCurrencyUnit = MyCurrencyUnit.CHF

  override def times(multiplier: Int): Money =
    Franc(this.amount * multiplier)

  override def currency(): String = "CHF"
}
