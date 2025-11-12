package test.java.playwrightTraditional;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExampleTest extends BasePlaywrightTest {

  @Test
  void shouldOpenDePaulSite() {
    page.navigate("https://www.depaul.edu");
    String title = page.title();
    System.out.println("Page title: " + title);
    assertTrue(title.contains("DePaul") || title.contains("University"));
  }
}
