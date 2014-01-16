package tinglysning

import geb.Page

class VisdokumentSide extends Page {
  static at = { $("h1").text() == "Tingbogen" }
}