# booking-mobile-automation-testing
Este es un proyecto de Automatización Mobile que utiliza Serenity BDD y Appium
para la creación de un framework de automatización que permita probar el apk [BOOKING](https://drive.google.com/file/d/1ruY_5qcqWlsE3-W3rgXpFyyMiO59wFUc/view?usp=sharing)

Este proyecto ha sido desarrollado por [Camila Dimas](https://www.linkedin.com/in/camiladimas/) para mejorar el
desarrollo en pruebas avanzadas de mobile automation.
***

## 🏠 Detalles del Tester

* Name: `Camila Dimas`
* Country: `Colombia`
* City: `Bogotá`
* LinkedIn: [https://www.linkedin.com/in/camiladimas/](https://www.linkedin.com/in/camiladimas/)

***

## 🛠️ Lenguajes & Frameworks

Este proyecto utiliza los siguientes lenguajes y frameworks:

* [Serenity BDD](https://serenity-bdd.github.io/theserenitybook/latest/index.html) como framework de pruebas
  automatizadas.
* [Appium](https://appium.io/) como framework para probar y validar aplicaciones web nativas, híbridas y móviles.
* [Cucumber](https://cucumber.io/) como software de testing BDD que permite elaborar pruebas a partir de AC.


* [Java 17](https://www.oracle.com/co/java/technologies/javase/jdk11-archive-downloads.html) como lenguaje de
  programación.
* [Screen Play](https://serenity-js.org/handbook/thinking-in-serenity-js/screenplay-pattern.html) como el patrón de
  diseño.
* [Gradle](https://gradle.org/) como herramienta de compilación.

***

## 🟢 Pre-requisitos: 🟢

1. Descargar la última versión estable de Java
   JDK [aquí](https://www.oracle.com/co/java/technologies/javase/jdk11-archive-downloads.html)
2. Instalar git desde [aquí](https://git-scm.com)
3. Instalar Gradle Build Tool desde [aquí](https://gradle.org/install/)
4. Instalar Android studio [aquí](https://developer.android.com/studio)
5. Instalar Appium Desktop(Server GUI) [aquí](https://github.com/appium/appium-desktop)
6. Instalar Appium Inspector [aquí](https://github.com/appium/appium-inspector)

**🗒️ Nota**: `build.gradle` tiene toda la configuración del proyecto instalada, ejecutar el siguiente comando para
iniciar todas las tareas (Incluidos los test).

👀 Adicional en su **IDE** de preferencia deberá tener instalados los siguientes plugins:

1. [x] *JUnit*
2. [x] *Cucumber for Java*
3. [x] *Gherkin*
4. [x] *Lombok*

***

### 🚀 Pruebas de Integración continua

> Con GitHub Actions, puedes crear flujos de trabajo de integración continua (IC) directamente en tu repositorio de
> GitHub.

Para este proyecto se hace uso de GitHUb Actions como herramienta para la integración continua del framework de
automatización desarrollado.

La ruta del pipeline se encuentra en: `.github/workflows/automated-testing-integration.yml`

| develop                    | status                                                                                                                                                                                                                                                                                                 |
|----------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Pruebas de integración** | [![automated-testing-integration ST]([![automated-mobile-testing-integration](https://github.com/CAMIDIMAS18/booking-mobile-automation-testing/actions/workflows/automated-testing-integration.yml/badge.svg?branch=develop)](https://github.com/CAMIDIMAS18/booking-mobile-automation-testing/actions/workflows/automated-testing-integration.yml))](https://github.com/CAMIDIMAS18/booking-mobile-automation-testing/actions/workflows/automated-testing-integration.yml) |

**⏱️ Ejecución automatizada**:   
El pipepile se ejecutará periódicamente de forma automática por medio la siguiente 'cron schedule expression':

```yml
on:
schedule:
  - cron: "00 13 * * TUE"
```

**📄️ Generando los reportes de prueba**:  
Con la ejecución del pipepile se generará un artefacto `testing-reports` donde se alojarán los reportes con los
resultados de esa ejecución realizada.

### 🧪 Casos de prueba contemplados

Test diseñados para validar los escenarios **Happy Paths** 😃

***
> **✨ FEATURE**: Booking | Creación de un servicio completo de alojamiento
> - [x] [YP-001] Validar ingreso de los datos para la búsqueda de alojamiento
>
> - [x] [YP-002] - Validar la selección de resultados de alojamiento
>
> - [x] [YP-003] - Validar el formulario de información del cliente
>
> - [x] [YP-004] - Validar el medio de pago y finalización de la reserva
***
Test diseñados para validar los escenarios **UNHappy Paths** 🤡

> **✨ FEATURE**: UnHappy Paths | Funcionamiento del servicio de alojamiento
> - [x] [YP-005] Validar que no se permita buscar un alojamiento sin seleccionar una ciudad de destino
***

## 🏗️ Estructura del proyecto

El proyecto tiene scripts de compilación para Gradle y sigue la estructura la siguiente estructura basada en el patrón
de diseño de Screenplay:

```Gherkin
src
+ main                                  | Source main
+ test                                  |
+ java                                  | Test runners and supporting code
+ co.com.bdb.certificacion              | Package base
+ features                              | Features set
+ {feature_name}                        | Feature name
+ pages                                 | Pages use with webdriver test
+ steps                                 | Utility class for definition steps
+ {feature_name}Definition.java         | Definition class
+ model                                 | DTOs, Pojos, VOs, etc ...
+ utils                                 | General utility class
+ Runners                               | Main class
+ resources                             |
+ features                              | Feature files
          + {feature_name}               | Feature file  specific
{feature_name}.feature                   |
+ serenity.conf                             | Config file for Serenity
serenity.properties                       | General properties Serenity
```

***

## ▶️ Ejecución del proyecto:

1. Descarga el proyecto desde GitHub
    * **Opción 1** (HTTPS): `https://github.com/CAMIDIMAS18/booking-mobile-automation-testing.git`
    * **Opción 2** (SSH): `git@github.com:CAMIDIMAS18/booking-mobile-automation-testing.git`
    * **Opción 3:** Descárgalo como archivo Zip y extráelo

***

2. **CD** en la carpeta `booking-mobile-automation-testing`.
3. Configurar Gradle
    * Ejecute el siguiente comando en el terminal:`./gradlew build`.

***

4. Ejecutar las pruebas en el proyecto
    * **Opción 1**: ejecutar en la ruta del proyecto alguno de los siguientes comandos:

    ```bash
    ./gradlew clean test --info
    ```

    ```bash
    gradle clean test --no-build-cache -Dcucumber.filter.tags="@Regression"
    ```

* **Opción 2**: Ir a las clases de la carpeta **runners** `src/test/java/co/com/booking/runners` y ejecutar
  cada Runner.

***

## 📄 Generación de informes

El informe al detalle con los pasos y resultados de las pruebas que se registrará en la ruta:
`target/site/serenity/index.html`.

Adicional se genera un reporte single page si se desea una revisión de alto nivel sobre los resultados de los test, el
cual se registrará en la ruta:
`target/site/serenity/serenity-summary.html`.

Este comando permitirá generar ambos reportes:

```bash
./gradlew reports
```

***