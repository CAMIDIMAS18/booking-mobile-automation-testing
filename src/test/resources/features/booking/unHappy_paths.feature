# language: es
Necesidad del negocio: Funcionamiento del servicio de alojamiento
  Como usuario, quiero utilizar el servicio de reservas correctamente

  Antecedentes: Ingresar a la pestaña de Stays
    Dado que Camila se encuentra en la opción de Stays

  @Regression @TestException
  Escenario: [YP-005] Validar que no se permita buscar un alojamiento sin seleccionar una ciudad de destino
    Cuando ella seleccione la opción de buscar sin colocar la cuidad de destino
    Entonces deberá visualizar el mensaje de "Please enter your destination"