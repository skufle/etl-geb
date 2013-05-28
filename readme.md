Dette er et eksempel, der viser hvordan tinglysning.dk kunne testes på browser drevet vis med Geb, Spock og Gradle.

Kører med GradleWrapper, så den henter selv alle afhængigheder, kræver blot en Java JDK installeret.

Testen er sat op til at afviklevirke med FireFox og Chrome (lokalt) samt mod en Firefox på Windows 8 via Sauce Labs (remote browser farm i skyen).

Konfiguration:  `build.gradle` og `src/test/resources/GebConfig.groovy` filerne.

Følgende kommandoer kan bruges til at launche test med specifikke browsere:

    ./gradlew saucelabsTest
    ./gradlew chromeTest
    ./gradlew firefoxTest

Testene kan afvikles på samtlige understøttede browsere med:

    ./gradlew test
    
Hvis du ønsker at afvikle testen mod Sauce Labs kræver det en valid konto og password sat med environment variablene

 `GEB_SAUCE_LABS_USER=bruger`
 `GEB_SAUCE_LABS_ACCESS_PASSWORD=password`

Se også:

  Spock (Domæne specifik sprog til at skrive tests i) http://code.google.com/p/spock/
  Geb (Automatiseret browser drevet test) http://www.gebish.org/
  Gradle (Bygge-værktøj, tror allerede Ødum kigger lidt på det til at erstatte vores byg af kode) http://www.gradle.org/
  Sauce Labs (Test i skyen, understøtter også browser og os platforme, som vi ikke har til rådighed f.eks. Macs, Linux, iOS etc.) http://saucelabs.com
  http://fbflex.wordpress.com/2013/03/18/how-to-configure-webdriver-in-grails-for-your-geb-tests/
