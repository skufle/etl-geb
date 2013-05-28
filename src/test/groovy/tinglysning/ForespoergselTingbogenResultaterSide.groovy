package tinglysning

/**
 * Created with IntelliJ IDEA.
 * User: Brian
 * Date: 29/05/13
 * Time: 00.03
 */
class ForespoergselTingbogenResultaterSide {
    static at = { $("h1").next().text() == "Søgeresultater" }

    static content = {
        forespoerglink { $("a", text: "Forespørg") }
    }

}
