import spock.lang.*
import geb.*
import geb.spock.*
import org.openqa.selenium.Keys

class TinglysningDKSoegSpec extends GebReportingSpec {

    def "Naviger til Foresp\u00F8rgsel side"() {
        when:
        to TinglysningStartSide

        and:
        forespoerglink.click()

        then:
        at ForespoergselSide

        when:
        forespoergTingbogenLink.click()

        then:
        at ForespoergselTingbogenSide

        when:
        $("form").find("input", name: "content:center:tingbogen:postnummer").value("3500")

//      and:
//      Keys.chord(Keys.TAB)

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