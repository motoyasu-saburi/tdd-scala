package money

class Franc(var amount: Int) extends Money {
  def times(multiplier: Int): Franc ={
    new Franc(amount * multiplier)
  }
}
