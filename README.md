# SmartWater
Sistema de adquisición para medidores domiciliarios de agua

El código está diseñado para obtener datos de un dispositivo adquisidor de datos basado en Arduino UNO.  El firmware del adquisidor está en https://github.com/kokidure/FirmwareMedidorAgua 

El sistema tiene las siguientes funcionalidades:
- Conexión a un dispositivo adquisidor por puerto serial
- Obtención de datos del dispositivo
- Almacenamiento de los datos en una Base de Datos
- Consulta e impresión de datos desde la Base de Datos

Se incluye también el código de creación de la Base de Datos en SQL.
