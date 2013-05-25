import geb.*

class WikipediaPage extends Page {
    static at = { title.contains "Wikipedia" }
}