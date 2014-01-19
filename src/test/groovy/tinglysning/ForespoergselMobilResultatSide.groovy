package tinglysning

import geb.Page

/**
 * Created by Brian on 16/01/14.
 */
class ForespoergselMobilResultatSide extends Page {
    static at = { title.startsWith("Tinglysning - Vis")}

    static content = {
        stamoplysninger(wait: true, required: false) {module StamoplysningerModule}

  }
}
