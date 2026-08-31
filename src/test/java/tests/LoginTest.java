package tests;

import org.junit.jupiter.api.Test;
import pages.DashboardPage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    void test_loginExitoso() {
        LoginPage loginPage = new LoginPage(page);

        loginPage.navegar();
        loginPage.iniciarSesion(
                "tomsmith",
                "SuperSecretPassword!"
        );

        DashboardPage dashboardPage = new DashboardPage(page);

        assertTrue(dashboardPage.estaVisible());
        assertEquals("Secure Area", dashboardPage.obtenerTitulo());
        assertTrue(
                dashboardPage.obtenerMensaje()
                        .contains("You logged into a secure area!")
        );
    }

    @Test
    void test_loginFallido() {
        LoginPage loginPage = new LoginPage(page);

        loginPage.navegar();
        loginPage.iniciarSesion(
                "usuarioIncorrecto",
                "claveIncorrecta"
        );

        assertTrue(
                loginPage.obtenerMensaje()
                        .contains("Your username is invalid!")
        );
    }
}