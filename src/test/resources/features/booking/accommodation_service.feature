# language: es
Necesidad del negocio: Creación de un servicio completo de alojamiento
  Como usuario, quiero utilizar el servicio de reservas, para buscar mi mejor opción de alojamiento

  Antecedentes: Ingresar a la pestaña de Stays
    Dado que Camila se encuentra en la opción de Stays

  @Regression
  Escenario: [YP-001] Validar ingreso de los datos para la búsqueda de alojamiento
    Cuando ella ingresa los datos para la búsqueda de su alojamiento "city", "dateStart", "dateEnd" y "ageChildren"
    Entonces deberá visualizar la lista de resultados de alojamientos disponibles

  @Regression
  Escenario: [YP-002] - Validar la selección de resultados de alojamiento
    Cuando ella seleccione la opción de alojamiento que desea
    Entonces podrá elegir y reservar su habitación

  @Regression
  Esquema del escenario: [YP-003] - Validar el formulario de información del cliente
    Dado que Camila se encuentra en la pantalla de ingreso de información del cliente
    Cuando ella ingresa sus datos personales en el formulario
    Entonces podrá validar el resumen de su reserva su precio total "<Price>", fecha de inicio "<Check-in>" y fecha fin "<Check-Out>"
    Ejemplos:
      | Price    | Check-in        | Check-Out       |
      | US$6,909 | Tue Feb 14 2023 | Tue Feb 28 2023 |

  @Regression
  Esquema del escenario: [YP-004] - Validar el medio de pago y finalización de la reserva
    Dado que Camila se encuentra en la pantalla de selección de medio de pago
    Cuando ella ingrese el número de su tarjeta "<cardNumber>" y la fecha de expedición "<expirationDate>"
    Entonces ella finalizará correctamente su reserva
    Ejemplos:
      | cardNumber       | expirationDate |
      | 4093550009809819 | 01/27          |