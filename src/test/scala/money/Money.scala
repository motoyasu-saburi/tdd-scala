package money

abstract class Money {
  protected var amount: Int

  override def equals(obj: Any): Boolean = {
    val money: Money = obj.asInstanceOf[Money]
    amount == money.amount
  }
}
