package tests;

import org.junit.jupiter.api.Test;
import pages.DashboardPage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Heredamos de BaseTest la preparación del navegador
// y el guardado de evidencias al finalizar.
public class Ejercicio05Test extends BaseTest {

    @Test
    void realizarLoginCompleto() {

        // 1. Creamos el objeto que permite manejar el formulario.
        // "page" es la pestaña preparada por BaseTest.
        LoginPage loginPage = new LoginPage(page);

        // 2. Abrimos la página de inicio de sesión.
        loginPage.navegar();

        // 3. Completamos los datos y enviamos el formulario
        // mediante el método que ya usa nuestro LoginTest.
        loginPage.iniciarSesion(
                "tomsmith",
                "SuperSecretPassword!"
        );

        // 4. Creamos el objeto que representa la página de destino.
        // Seguimos trabajando con la misma pestaña.
        DashboardPage dashboardPage = new DashboardPage(page);

        // 5. Verificamos que el área privada esté visible.
        assertTrue(dashboardPage.estaVisible());

        // 6. Comparamos el título esperado con el obtenido.
        assertEquals(
                "Secure Area",
                dashboardPage.obtenerTitulo()
        );

        // 7. Verificamos el mensaje de ingreso exitoso.
        assertTrue(
                dashboardPage.obtenerMensaje()
                        .contains("You logged into a secure area!")
        );
    }
}