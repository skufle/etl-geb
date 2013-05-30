/*
	This is the Geb configuration file.
	
	See: http://www.gebish.org/manual/current/configuration.html
*/

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.ie.InternetExplorerDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver

waiting {
  timeout = 2
}

environments {

  // kør med “./gradlew chromeTest”
  // See: http://code.google.com/p/selenium/wiki/ChromeDriver
  chrome {
    System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/win/chromedriver.exe")
    // System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver2_mac32_0.8/chromedriver")
    driver = { new ChromeDriver() }
  }

  // kør med “./gradlew firefoxTest”
  // See: http://code.google.com/p/selenium/wiki/FirefoxDriver
  firefox {
    driver = { new FirefoxDriver() }
  }

  // kør med “./gradlew ieTest”
  // See: http://code.google.com/p/selenium/wiki/InternetExplorerDriver
  ie {
    System.setProperty('webdriver.ie.driver', "src/test/resources/drivers/win/IEDriverServer.exe")
    driver = { new InternetExplorerDriver() }
  }

  // kør med “./gradlew remoteTest”
  // See: http://code.google.com/p/selenium/wiki/RemoteWebDriver
  // Husk at sætte GEB_SAUCE_LABS_USER og GEB_SAUCE_LABS_ACCESS_PASSWORD inden afvikling
  remote {
    def username = System.getenv("GEB_SAUCE_LABS_USER")
    assert username
    def accessKey = System.getenv("GEB_SAUCE_LABS_ACCESS_PASSWORD")
    assert accessKey

    def url = new URL("http://$username:$accessKey@ondemand.saucelabs.com:80/wd/hub")

    DesiredCapabilities capabilities = DesiredCapabilities.firefox()
    capabilities.setCapability("version", "17")
    capabilities.setCapability("platform", "Windows 2012")

/* Deres Safari OSX hoster lidt...
    DesiredCapabilities capabilities = DesiredCapabilities.safari()
    capabilities.setCapability("version", "6")
    capabilities.setCapability("platform", "OS X 10.8")
*/
    driver = { new RemoteWebDriver(url, capabilities) }
  }
}

// Afvikling af alle tests, kør:  “./gradlew test”