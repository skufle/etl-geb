package tinglysning

import geb.Module

/**
 * Denne klasse repræsenterer en række i søgeresultat tabellen for ejendomssøgning
 */
class EjendomRow extends Module {
   static content = {
     celle {$("td", it)}
     vedroerende {celle(0).text()}
     vejnavn {celle(1).text()}
     husnummer {celle(2).text()}
     postnummer {celle(3).text()}
     by {celle(4).text()}
     videreLink {celle(5).find("a")}
   }
}
