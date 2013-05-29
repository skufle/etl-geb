package tinglysning

import geb.*

class ForespoergselTingbogenResultaterSide extends Page {

	// Mærkelig kode i tinglysning.dk gør at vi er nødt til bruge .next(), har 2 nestede H1 tags hvor den yderste er tom...
  static at = { $("h1").next().text() == "Søgeresultater" }

  static content = {
    // .tail skipper rækken med overskrifter
    ejendomme {moduleList EjendomRow, $("table.af_table_content tbody tr").tail() }
  }
}