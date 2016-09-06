package com.norbitltd.spoiwo.examples.gettingstarted

import com.norbitltd.spoiwo.model._
import org.joda.time.LocalDate
import com.norbitltd.spoiwo.natures.xlsx.Model2XlsxConversions._
import com.norbitltd.spoiwo.model.enums.CellFill

object GettingStartedExample {

  val headerStyle =
    CellStyle(fillPattern = CellFill.Solid, fillForegroundColor = Color.AquaMarine, fillBackgroundColor = Color.AquaMarine, font = Font(bold = true))

  val gettingStartedSheet = Sheet(name = "Some serious stuff")
    .withRows(
      Row(style = headerStyle).withCellValues("NAME", "BIRTH DATE", "DIED AGED", "FEMALE"),
      Row().withCellValues("Marie Curie", new LocalDate(1867, 11, 7), 66, true),
      Row().withCellValues("Albert Einstein", new LocalDate(1879, 3, 14), 76, false),
      Row().withCellValues("Erwin Shrodinger", new LocalDate(1887, 8, 12), 73, false)
    )
    .withColumns(
      Column(index = 0, style = CellStyle(font = Font(bold = true)), autoSized = true)
    )
    .withDropDowns(
      DropDown(List("11", "12", "13"), new CellRange((7,7),(1,1))),
      DropDown(List("21", "22", "23"), new CellRange((8,8),(1,1))),
      DropDown(List("31", "32", "33"), new CellRange((9,9),(1,1)))
    )


  def main(args: Array[String]) {
    gettingStartedSheet.saveAsXlsx(Utils.returnOrAskForSaveLocation(args))
  }
}
