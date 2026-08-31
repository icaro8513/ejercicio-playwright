package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class DashboardPage {

    private final Page page;
    private final Locator titulo;
    private final Locator mensaje;
    private final Locator botonLogout;

    public DashboardPage(Page page) {
        this.page = page;
        this.titulo = page.locator("h2");
        this.mensaje = page.locator("#flash");
        this.botonLogout = page.locator("a[href='/logout']");
    }

    public boolean estaVisible() {
        return titulo.isVisible();
    }

    public String obtenerTitulo() {
        return titulo.textContent().trim();
    }

    public String obtenerMensaje() {
        return mensaje.textContent().trim();
    }

    public void cerrarSesion() {
        botonLogout.click();
    }
}