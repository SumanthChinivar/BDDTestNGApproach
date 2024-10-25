package utilityClasses;

import org.openqa.selenium.WebDriver;

public class ThreadUtility {
	public static ThreadLocal<WebDriver> test = new ThreadLocal<WebDriver>();

	public static WebDriver getTest() {
		return test.get();
	}

	public static void setTest(WebDriver itest) {
		test.set(itest);
	}
}
