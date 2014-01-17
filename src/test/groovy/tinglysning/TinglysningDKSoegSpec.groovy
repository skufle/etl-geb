package tinglysning

import geb.spock.GebReportingSpec

class TinglysningDKSoegSpec extends GebReportingSpec {

    def "Naviger til Forespoergsel side og fremsoeg ejendommen Tvendagervej 9"() {

        given: "Vi er på startsiden"
        to TinglysningStartSide

        expect: "Jeg er på startsiden"
        at TinglysningStartSide

        when: "Klik på forespørg tab"
        forespoerglink.click()

        then: "Jeg er på forespørgselsiden"
        waitFor {at ForespoergselSide}

        when: "Klik på forespørg tingbogen"
        forespoergTingbogenLink.click()

        then: "Jeg er på mobil sitet"
        waitFor {at ForespoergselMobilSide}

        when:
        adressefelt = "Mosevej 16, 3500"

        and:
        soeg.click()

        then: "Vent på resultatet"
        waitFor {ejendomme.size == 1}

        and: "Det er parnasset (you wish)"
        ejendomme[0].ejendom == "Mosevej 16 3500 Værløse"

        then: "Klik på ejendommen"
        ejendomme[0].ejendomLink.click()

    }




/*

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
        */
/*
          // Måske kan modifiers hives ud via Webdriver configuration objektet,
          // da de varierer fra platform til platform og fra browser til browser.
          Keys.chord(Keys.CONTROL, Keys.ALT, "s");
         *//*


        then: "Vent på resultatet"
        waitFor {at ForespoergselTingbogenResultaterSide}

        and: "Forvent een ejendom"
        ejendomme.size() == 1

        and: "Vedrørende min ejendom"
        ejendomme[0].vedroerende == "Ll. Værløse By, Værløse, 2fi"

        when: "Klik på Videre"
        ejendomme[0].videreLink.click()

        then: "Vent på Vis dokument"
        waitFor {at VisdokumentSide}
*/

}