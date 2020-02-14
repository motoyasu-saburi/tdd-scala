package money

sealed trait Money {
  def times(multiplier: Int): Money
}
//
//abstract class Money {
//  protected var amount: Int
//
//  override def equals(obj: Any): Boolean = {
//    val money: Money = obj.asInstanceOf[Money]
//    amount == money.amount && getClass().equals(money.getClass())
//  }
//}

case class Dollar(amount: Int) extends Money {
  override def times(multiplier: Int): Dollar = Dollar(amount * multiplier)
}
case class Franc(amount: Int) extends Money {
  override def times(multiplier: Int): Franc = Franc(amount * multiplier)
}
