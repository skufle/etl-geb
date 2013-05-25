import geb.*

class TinglysningStartSide extends Page {
	static url = "https://www.tinglysning.dk"
    static at = { title == "Digital Tinglysning" }
    static content = {
        forespoerglink { $("a", text: "Forespørg") }
    }

}