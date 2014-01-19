package tinglysning

import geb.*

/**
 * Created by Brian on 16/01/14.
 */
class ForespoergselMobilSide extends Page {
    static url = "https://www.tinglysning.dk/m/#/soeg"
    static at = { title == "Tinglysning - søg"}

    static content = {
       adressefelt { $("#adresse") }
    //   forespoerglink { $("a", text: "Forespørg") }
       soeg { $("form").find("a", text: "Søg") }
       ejendomme {moduleList ResultatListeRow, $("ul.nav-list.resultat-liste")}
  }
}
