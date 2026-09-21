package tests;

import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

// Reutilizamos la preparación y las evidencias de BaseTest.
public class Ejercicio06Test extends BaseTest {

    @Test
    void verificarMensajeDeError() {

        // 1. Creamos el objeto que maneja el formulario.
        LoginPage loginPage = new LoginPage(page);

        // 2. Abrimos la página de login.
        loginPage.navegar();

        // 3. Intentamos ingresar con datos incorrectos.
        loginPage.iniciarSesion(
                "usuarioIncorrecto",
                "claveIncorrecta"
        );

        // 4. Leemos el mensaje que devuelve la página.
        String mensajeObtenido = loginPage.obtenerMensaje();

        // 5. Verificamos que informe que el usuario es inválido.
        assertTrue(
                mensajeObtenido.contains("Your username is invalid!"),
                "Se esperaba el aviso de usuario inválido, pero apareció: "
                        + mensajeObtenido
        );
    }
}