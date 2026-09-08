package tests;

import org.junit.jupiter.api.Test;

public class Ejercicio03Test extends BaseTest {

    @Test
    void hacerClickEnLink() {

        // 1. Navegamos a la página inicial.
        page.navigate("https://www.mercadolibre.com.ar/");

        // 2. Buscamos el enlace por el texto visible
        // y hacemos clic sobre él.
        page.getByText("More information...").click();
    }
}
