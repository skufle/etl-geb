package tinglysning

import geb.*

class ForespoergselSide extends Page {
    static at = { $("h1").text() == "Forespørg" }

    static content = {
        forespoergTingbogenLink { $("a", text: "Tingbogen") }
    }

}