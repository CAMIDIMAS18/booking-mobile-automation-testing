# language: es
Necesidad del negocio: Búsqueda servicio de alojamiento
  Como usuario, quiero utilizar el servicio de reservas

  Antecedentes: Ingresar a la pestaña de Stays
    Dado que Camila se encuentra en la opción de Stays

  @Regression
  Esquema del escenario: [YP-001] Validar ingreso de los datos para la búsqueda de alojamiento
    Cuando ella ingresa los datos para la búsqueda de su alojamiento
      | ciudad | check start  | check end  | rooms   | adults   | children   | ageChildren   |
      | <city> | <checkStart> | <checkEnd> | <rooms> | <adults> | <children> | <ageChildren> |
    Entonces deberá visualizar los resultados de alojamientos disponibles
    Ejemplos:
      | city  | checkStart       | checkEnd         | rooms | adults | children | ageChildren |
      | Cusco | 14 February 2023 | 28 February 2023 | 1     | 2      | 1        | 5 years old |
