package tests;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Ejercicio02Test extends BaseTest {

    @Test
    void verificarTituloPagina() {

        // Abrimos Mercado Libre.
        page.navigate("https://www.mercadolibre.com.ar/");

        // Verificamos que el título contenga "Mercado Libre".
        assertThat(page).hasTitle(
                Pattern.compile(".*Mercado Libre.*")
        );
    }
}
