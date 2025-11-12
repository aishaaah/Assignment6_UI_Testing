package test.java.playwrightTraditional;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import java.nio.file.Paths;

public class BasePlaywrightTest {
  protected static Playwright playwright;
  protected static Browser browser;
  protected BrowserContext context;
  protected Page page;

  @BeforeAll
  static void setupAll() {
    playwright = Playwright.create();
    browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

  }

  @BeforeEach
  void setup() {
    context = browser.newContext(new Browser.NewContextOptions()
      .setRecordVideoDir(Paths.get("videos/"))
      .setRecordVideoSize(1280, 720));
    page = context.newPage();
  }

  @AfterEach
  void teardown() {
    context.close();
  }

  @AfterAll
  static void teardownAll() {
    browser.close();
    playwright.close();
  }
}
