package tinglysning

import geb.Page

class BetalingSide extends Page {
  static at = { $("h1").next().text() == "Betaling" }
}