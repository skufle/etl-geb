Dette er et eksempel, der viser hvordan tinglysning kunne web testes med Geb, Spock og Gradle.

Bygget er sat op til at virke med FireFox og Chrome (Webdriver Sauce Labs Work in Progress). 

Konfiguration:  `build.gradle` og `src/test/resources/GebConfig.groovy` filerne.

Følgende kommandoer kan bruges til at launche test med specifikke browsere:

    ./gradlew saucelabsTest
    ./gradlew chromeTest
    ./gradlew firefoxTest

Testene kan afvikles på samtlige understøttede browsere med:

    ./gradlew test
    
Se også: http://fbflex.wordpress.com/2013/03/18/how-to-configure-webdriver-in-grails-for-your-geb-tests/
