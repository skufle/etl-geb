package tinglysning
import geb.*

class ForespoergselTingbogenSide extends ForespoergselSide {

	// Mærkelig kode i tinglysning.dk gør at vi er nødt til bruge .next(), har 2 nestede H1 tags hvor den yderste er tom...
    static at = { $("h1").next().text() == "Tingbogen - forespørg i fast ejendom" }

    static content = {
        //postnummer {$("form").find("input", name: "content:center:tingbogen:postnummer")} // CSS3 selector kopierbar direkte fra developer tools.
        postnummer {$("form").find("input", name: endsWith("postnummer"))}
        postdistrikt {$("span", id:"content:center:tingbogen:postdistriktsnavn")}
        vejkode {$("form").find("input", name: endsWith("vejkode"))}
        husnr {$("form").find("input", name: endsWith("husnr"))}
    }
}