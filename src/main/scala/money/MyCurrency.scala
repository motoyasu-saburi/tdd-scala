package money

sealed trait MyCurrency

/**
 * 通貨を生成する
 */
object MyCurrency {
  /* 通過の定義 */
  def apply(amount: Int)(implicit currencyUnit: MyCurrencyUnit): Money = {
    currencyUnit match {
      case MyCurrencyUnit.USD => Dollar(amount)
      case MyCurrencyUnit.CHF => Franc(amount)
    }
  }

}

