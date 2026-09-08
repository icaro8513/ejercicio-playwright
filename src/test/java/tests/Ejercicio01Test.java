package tests;

import org.junit.jupiter.api.Test;

public class Ejercicio01Test extends BaseTest {

    @Test
    void abrirPaginaWeb() {

        // Le indicamos a la pestaña controlada por Playwright
        // que navegue hacia esta dirección web.
        page.navigate("https://www.mercadolibre.com.ar/");

    }
}