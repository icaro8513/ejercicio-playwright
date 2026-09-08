package tests;

import org.junit.jupiter.api.Test;

public class Ejercicio04Test extends BaseTest {

    @Test
    void escribirEnBuscador() {

        // 1. Abrimos Mercado Libre Argentina.
        page.navigate("https://www.mercadolibre.com.ar/");

        // 2. Localizamos el campo de búsqueda.
        // Mercado Libre identifica el buscador con name="as_word".
        page.locator("input[name='as_word']").fill("notebook gamer");
    }
}