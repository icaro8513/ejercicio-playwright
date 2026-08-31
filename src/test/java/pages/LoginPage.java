package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {

    private static final String URL =
            "https://the-internet.herokuapp.com/login";

    private final Page page;
    private final Locator campoUsuario;
    private final Locator campoContrasena;
    private final Locator botonLogin;
    private final Locator mensaje;

    public LoginPage(Page page) {
        this.page = page;
        this.campoUsuario = page.locator("#username");
        this.campoContrasena = page.locator("#password");
        this.botonLogin = page.locator("button[type='submit']");
        this.mensaje = page.locator("#flash");
    }

    public void navegar() {
        page.navigate(URL);
    }

    public void iniciarSesion(String usuario, String contrasena) {
        campoUsuario.fill(usuario);
        campoContrasena.fill(contrasena);
        botonLogin.click();
    }

    public String obtenerMensaje() {
        return mensaje.textContent().trim();
    }
}