package money

class Franc(private var amount: Int) {
  def times(multiplier: Int) {
    new Franc(amount * multiplier)
  }

  def equals(franc: Franc): Boolean = {
    amount == franc.amount
  }
}
