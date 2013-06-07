package tinglysning

import geb.spock.GebReportingSpec

class TinglysningDKSoegSpec extends GebReportingSpec {

    def "Naviger til Forespoergsel side og fremsoeg ejendommen Mosevej 16"() {

        given: "Naviger til startsiden"
        to TinglysningStartSide

        expect: "Jeg er på startsiden"
        at TinglysningStartSide

        when: "Klik på forespørg tab"
        forespoerglink.click()

        then: "Jeg er på forespørgselsiden"
        waitFor {at ForespoergselSide}

        when: "Klik på forespørg tingbogen"
        forespoergTingbogenLink.click()

        then: "Jeg er på forespørg tingbogen side"
        waitFor {at ForespoergselTingbogenSide}

        when: "Indtast postnummer"
        postnummer.value("3500")

        and: "Vent på AJAX kaldet oversættes til et postdistrikt"
        waitFor {postdistrikt.text() == "Værløse"}

        and: {
            vejkode.value("Mosevej")
            husnr.value("16")
        }

        and: "Klik på søg"
        soegLink.click()
        /*
          // Måske kan modifiers hives ud via Webdriver configuration objektet,
          // da de varierer fra platform til platform og fra browser til browser.
          Keys.chord(Keys.CONTROL, Keys.ALT, "s");
         */

        then: "Vent på resultatet"
        waitFor {at ForespoergselTingbogenResultaterSide}

        and: "Forvent een ejendom"
        ejendomme.size() == 1

        and: "Vedrørende min ejendom"
        ejendomme[0].vedroerende == "Ll. Værløse By, Værløse, 2fi"

        when: "Klik på Videre"
        ejendomme[0].videreLink.click()

        then: "Vent på betalingside"
        waitFor {at BetalingSide}
    }
}