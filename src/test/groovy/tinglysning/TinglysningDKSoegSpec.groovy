package tinglysning

import geb.spock.GebReportingSpec
import org.openqa.selenium.Keys

class TinglysningDKSoegSpec extends GebReportingSpec {

    def "Naviger til Foresp\u00F8rgsel side og fremsøg Brians palads"() {

        given: "Naviger til startsiden"
        to TinglysningStartSide

        expect: "Jeg er på startsiden"
        at TinglysningStartSide

        when: "Når vi clicker på forespørg"
        forespoerglink.click()

        then:
        at ForespoergselSide

        when:
        forespoergTingbogenLink.click()

        then:
        waitFor {at ForespoergselTingbogenSide} // Lidt mere tålmodig...

        when: "Vi indtaster postnummmer"
        postnummer.value("3500")

        then: "Vi venter på asynkront svar med postdistrikt (by) "
        waitFor {postdistrikt.text() == "Værløse"} // Vent på Ajax request...

        when:
        { "Det er da her han bor!"
            vejkode.value("Mosevej")
            husnr.value("16")
        }

//        then:
//        soeg.click();

        /*
          // Måske kan modifiers hives ud via Webdriver configuration objektet.
          // De varierer fra platform til platform og fra browser til browser, bruger til bruger...
          Keys.chord(Keys.CONTROL, Keys.ALT, "s");
         */


        then:
        at ForespoergselTingbogenSide


/*
        and:
        firstResultLink.text() == "Wikipedia"

        when:
        firstResultLink.click()

        then:
        waitFor { at WikipediaPage }
*/
    }
}