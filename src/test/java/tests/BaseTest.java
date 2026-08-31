package tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    private boolean testFailed;
    private String testName;

    @RegisterExtension
    protected final TestExecutionExceptionHandler failureHandler =
            (extensionContext, throwable) -> {
                testFailed = true;
                throw throwable;
            };

    @BeforeEach
    protected void setUp(TestInfo testInfo) throws Exception {
        testFailed = false;

        testName = testInfo.getTestMethod()
                .map(method -> method.getName())
                .orElse("test");

        playwright = Playwright.create();

        boolean ejecutandoEnCI =
                "true".equalsIgnoreCase(System.getenv("CI"));

        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(ejecutandoEnCI)
                        .setSlowMo(ejecutandoEnCI ? 0 : 300)
        );

        context = browser.newContext();

        context.tracing().start(
                new Tracing.StartOptions()
                        .setScreenshots(true)
                        .setSnapshots(true)
                        .setSources(true)
        );

        page = context.newPage();
    }

    @AfterEach
    protected void tearDown() {
        try {
            if (testFailed && page != null) {
                Path screenshotPath = Paths.get(
                        "build",
                        "artifacts",
                        "screenshots",
                        testName + ".png"
                );

                Files.createDirectories(screenshotPath.getParent());

                page.screenshot(
                        new Page.ScreenshotOptions()
                                .setPath(screenshotPath)
                                .setFullPage(true)
                );

                System.out.println(
                        "Captura guardada en: " + screenshotPath
                );
            }
        } catch (Exception exception) {
            System.err.println(
                    "No se pudo guardar la captura: "
                            + exception.getMessage()
            );
        }

        try {
            if (context != null) {
                Path tracePath = Paths.get(
                        "build",
                        "artifacts",
                        "traces",
                        testName + ".zip"
                );

                Files.createDirectories(tracePath.getParent());

                context.tracing().stop(
                        new Tracing.StopOptions()
                                .setPath(tracePath)
                );

                System.out.println(
                        "Traza guardada en: " + tracePath
                );
            }
        } catch (Exception exception) {
            System.err.println(
                    "No se pudo guardar la traza: "
                            + exception.getMessage()
            );
        }

        if (context != null) {
            context.close();
        }

        if (browser != null) {
            browser.close();
        }

        if (playwright != null) {
            playwright.close();
        }
    }
}