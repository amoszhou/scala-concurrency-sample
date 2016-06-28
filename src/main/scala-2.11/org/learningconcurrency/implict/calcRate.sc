def calcTax(amount: Float)(implicit rate: Float): Float = amount * rate

object SimpleStateSalesTax {
  implicit val rate: Float = 0.05F
}


case class ComplicatedSaleTaxData(
                                   baseRate: Float,
                                   isTaxHoliday: Boolean,
                                   storeId: Int
                                 )


object ComplicatedSaleTax {
  private def extraTaxRateForStore(id: Int): Float = {
    0.0F
  }

  implicit def rate(implicit cstd: ComplicatedSaleTaxData): Float =
    if (cstd.isTaxHoliday) 0.0F
    else cstd.baseRate + extraTaxRateForStore(cstd.storeId)
}


{
  import SimpleStateSalesTax.rate

  val amount = 100F
  println(s"Tax on $amount = ${calcTax(amount)}")

}

{
  import ComplicatedSaleTax.rate

  implicit val myStore = ComplicatedSaleTaxData(0.06F,false,1010)

  val amount = 100F

  println(s"Tax on $amount = ${calcTax(amount)}")
}