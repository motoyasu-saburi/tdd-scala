package money

class Dollar(var amount:Int) extends Money {
  def times(multiplier: Int): Dollar ={
    new Dollar(amount * multiplier)
  }
}
