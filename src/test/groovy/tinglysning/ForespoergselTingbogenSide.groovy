import geb.*

class ForespoergselTingbogenSide extends ForespoergselSide {

	// Mærkelig kode i tinglysning.dk, har 2 nestede H1 tags hvor den yderste er tom...
    static at = { $("h1").next().text() == "Tingbogen - forespørg i fast ejendom" }

/*
    static content = {
        forespoergTingbogenLink { $("a", text: "Tingbogen") }
    }
*/
}