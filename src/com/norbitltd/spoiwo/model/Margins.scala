package com.norbitltd.spoiwo.model

object Margins extends Factory {

  private lazy val defaultLeft = 0.0
  private lazy val defaultRight = 0.0
  private lazy val defaultTop = 0.0
  private lazy val defaultBottom = 0.0
  private lazy val defaultHeader = 0.0
  private lazy val defaultFooter = 0.0

  val Default = Margins()

  def apply(top: Double = defaultTop,
            bottom: Double = defaultBottom,
            right: Double = defaultRight,
            left: Double = defaultLeft,
            header: Double = defaultHeader,
            footer: Double = defaultFooter): Margins =
    Margins(
      wrap(top, defaultTop),
      wrap(bottom, defaultBottom),
      wrap(right, defaultRight),
      wrap(left, defaultLeft),
      wrap(header, defaultHeader),
      wrap(footer, defaultFooter)
    )
}

case class Margins private(
                            top: Option[Double],
                            bottom: Option[Double],
                            right: Option[Double],
                            left: Option[Double],
                            header: Option[Double],
                            footer: Option[Double]) {

  def withTop(top: Double) =
    copy(top = Option(top))

  def withBottom(bottom: Double) =
    copy(bottom = Option(bottom))

  def withRight(right: Double) =
    copy(right = Option(right))

  def withLeft(left: Double) =
    copy(left = Option(left))

  def withHeader(header: Double) =
    copy(header = Option(header))

  def withFooter(footer: Double) =
    copy(footer = Option(footer))


}