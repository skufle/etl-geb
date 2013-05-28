package tinglysning

import geb.spock.GebReportingSpec
import org.openqa.selenium.Keys

class TinglysningDKSoegSpec extends GebReportingSpec {

    def "Naviger til Foresp\u00F8rgsel side og fremsøg Brians palads"() {

        given: "Naviger til startsiden"
        to TinglysningStartSide

        expect: "Jeg er på startsiden"
        at TinglysningStartSide

        when:
        forespoerglink.click()

        then:
        at ForespoergselSide

        when:
        forespoergTingbogenLink.click()

        then:
        waitFor {at ForespoergselTingbogenSide}

        when:
        postnummer.value("3500")

        and:
        waitFor {postdistrikt.text() == "Værløse"}

        and:
        {
            vejkode.value("Mosevej")
            husnr.value("16")
        }

        and:

        /*
          // Måske kan modifiers hives ud via Webdriver configuration objektet,
          // da de varierer fra platform til platform og fra browser til browser.
          Keys.chord(Keys.CONTROL, Keys.ALT, "s");
         */
        // Keys.chord(Keys.CONTROL, Keys.ALT, "s"); // Måske kan modifiers hives ud via Webdriver configuration objektet,
        // da de varierer fra platform til platform og fra browser til browser.

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