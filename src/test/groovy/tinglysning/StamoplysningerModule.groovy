package tinglysning

import geb.Module

/**
 * Created by Brian on 18/01/14.
 */
class StamoplysningerModule extends Module {

    static content = {
         overskrift {$("a", text: "Stamoplysninger")}
         data {overskrift.closest(".accordion-group").find("dl")}

         ejendomstype {data.find("dt", text: "Ejendomstype").next()}
    }
}
