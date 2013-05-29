package tinglysning

import geb.*

class ForespoergselSide extends Page {
    static at = { $("h1").text() == "Foresp\u00F8rg" }

    static content = {
        forespoergTingbogenLink { $("a", text: "Tingbogen") }
    }

}