# Ejercicios de Playwright con Java

Trabajo práctico de Validación y Verificación utilizando **Java, JUnit, Gradle y Playwright** para automatizar pruebas sobre páginas web.

## Estado actual del trabajo

Actualmente se encuentran realizados los **Ejercicios 1 al 6**.

Los **Ejercicios 7 y 8** se agregarán posteriormente cuando sean desarrollados y probados.

## Qué se realizó

- Navegación a sitios web con `navigate()`.
- Localización de elementos con `locator()`.
- Escritura en campos con `fill()`.
- Clics con `click()`.
- Verificaciones con assertions de JUnit.
- Pruebas de login correcto e incorrecto.
- Uso de `LoginPage` y `DashboardPage` para organizar las acciones de las pantallas.
- Uso de `BaseTest` para preparar y cerrar el navegador en cada prueba.
- Generación de videos como evidencia de ejecución.

## Ejercicios realizados

- **Ejercicio 1:** navegación a una página web.
- **Ejercicio 2:** verificación de información de la página.
- **Ejercicio 3:** interacción mediante clic sobre un elemento.
- **Ejercicio 4:** localización de un campo y escritura con `fill()`.
- **Ejercicio 5:** inicio de sesión correcto y verificación del acceso al área segura.
- **Ejercicio 6:** inicio de sesión incorrecto y verificación del mensaje de error.

## Estructura principal

- `src/test/java/tests` → contiene `BaseTest` y los ejercicios.
- `src/test/java/pages` → contiene `LoginPage` y `DashboardPage`.
- `evidencias/videos` → contiene los videos generados durante las pruebas.

## Próximos pasos

Agregar y documentar:

- Ejercicio 7
- Ejercicio 8

## Autor

Carlos de la Madrid  
Tecnicatura en Desarrollo de Software