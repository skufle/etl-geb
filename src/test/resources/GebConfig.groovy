/*
	This is the Geb configuration file.
	
	See: http://www.gebish.org/manual/current/configuration.html
*/


import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver

waiting {
	timeout = 2
}

environments {
	
	// run via “./gradlew chromeTest”
	// See: http://code.google.com/p/selenium/wiki/ChromeDriver
	chrome {
        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver2_mac32_0.8/chromedriver");
		driver = { new ChromeDriver() }
	}
	
	// run via “./gradlew firefoxTest”
	// See: http://code.google.com/p/selenium/wiki/FirefoxDriver
	firefox {
		driver = { new FirefoxDriver() }
	}

    // run via “./gradlew remoteTest”
    // See: http://code.google.com/p/selenium/wiki/RemoteWebDriver
    remote {
        def username = System.getenv("GEB_SAUCE_LABS_USER")
        assert username
        def accessKey = System.getenv("GEB_SAUCE_LABS_ACCESS_PASSWORD")
        assert accessKey

        def url = new URL("http://$username:$accessKey@ondemand.saucelabs.com:80/wd/hub")
        DesiredCapabilities capabilities = DesiredCapabilities.firefox()
        capabilities.setCapability("version", "17")
        capabilities.setCapability("platform", "Windows 2012")
        driver = { new RemoteWebDriver(url, capabilities) }
    }

}

// To run the tests with all browsers just run “./gradlew test”