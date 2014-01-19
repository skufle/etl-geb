package tinglysning

import geb.spock.GebReportingSpec
import org.openqa.selenium.Keys
import spock.lang.Shared
import spock.lang.Unroll

class TinglysningDKSoegSpec extends GebReportingSpec {

    //@Shared ejendommen = "Mosevej 16 3500 Værløse"

    @Unroll
    def "Naviger til Forespoergsel side og fremsoeg ejendommen #resultat"() {

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
        adressefelt = soegestreng

        and:
        adressefelt << Keys.chord(Keys.ENTER) // eller soeg.click()


        then: "Vent på resultatet"
        waitFor {ejendomme.size == antalResultater}

        and: "Det er parnasset"
        waitFor {ejendomme[0].ejendom == resultat}

        when: "Klik på ejendommen"
        ejendomme[0].ejendomLink.click()

        then: "Vi er på resultat siden"
        waitFor {at ForespoergselMobilResultatSide }

        and: "Der er data..."
        waitFor {stamoplysninger.data.present}

        and: "Det er parnasset"
          assert stamoplysninger.overskrift.text() == "Stamoplysninger"
          assert stamoplysninger.data != null
          assert stamoplysninger.ejendomstype != null
          assert "Parcel" == stamoplysninger.ejendomstype.text()

        where:
        soegestreng || antalResultater || resultat
        "Mosevej 16 3500" | 1 | "Mosevej 16 3500 Værløse"
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