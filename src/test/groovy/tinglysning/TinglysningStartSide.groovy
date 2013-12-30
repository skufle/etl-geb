package tinglysning

import geb.*

class TinglysningStartSide extends Page {
	static url = "https://www.tinglysning.dk"
    static at = { title == "Digital Tinglysning" }
    static content = {
        forespoerglink { $("a", text: "Forespørg") }
      // CSS3 udgave: .menulist > li:nth-child(3) > a:nth-child(1) !!!
    }

}