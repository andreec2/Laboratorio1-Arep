# TALLER DISEÑO Y ESTRUCTURACIÓN DE APLICACIONES DISTRIBUIDAS EN INTERNET


Este proyecto implementa un servidor web básico en Java que maneja solicitudes RESTful (GET, POST, PUT, DELETE) y retorna los archivos solicitados que conforman la página web. El servidor está diseñado para manejar múltiples conexiones de clientes simultáneamente y realizar operaciones CRUD en objetos JSON en memoria. Cada solicitud es manejada por un hilo separado (ClientHandler), permitiendo la concurrencia. El tema que se escogio para la pagina web es de rem :D. 

![{77378D07-17EE-46F6-9941-1207A993392A}](https://github.com/user-attachments/assets/0d10e85d-2502-4756-9b86-7f727cf55d42)

## Arquitectura
Este proyecto sigue la arquitectura cliente-servidor. Utilizando el estilo arquitectonico de REST, Los clientes envían solicitudes HTTP al servidor, que maneja la lógica de los serviciso REST y devuelve respuestas en formato JSON. El servidor también puede retornar archivos estáticos, como HTML, CSS e imágenes. 

### componentes  
   - **Servidor** : HttpServer maneja las conexiones y enruta las solicitudes a los servicios correspondientes. ClientHandler Gestiona la comunicación con el cliente, procesa la solicitud y decide si debe retornar un archivo estático o delegar la solicitud a un servicio REST.
   - **Servicios REST**: ClientHandler en la clase clientHandler, manejan operaciones CRUD en objetos JSON y consulta a html estaticos guardados en el servidor.
   - **Archivos estáticos**: Almacenados en el directorio public

## Primeros Pasos
Estas instrucciones le permitirán obtener una copia del proyecto en funcionamiento en su máquina local para fines de desarrollo y prueba. 


### Requisitos Previos
Para ejecutar este proyecto, necesitarás tener instalado:

- Java JDK 8 o superior.
- Un IDE de Java como IntelliJ IDEA, Eclipse.
- Maven para manejar las dependencias 
- Un navegador web para interactuar con el servidor.

### Instalación 

1. Tener instalado Git en tu maquina local 
2. Elegir una carpeta en donde guardes tu proyecto
3. abrir la terminal de GIT --> mediante el clik derecho seleccionas Git bash here
4. Clona el repositorio en tu máquina local:
   ```bash
   git clone https://github.com/andreec2/Laboratorio1-Arep.git
   ```
5. Abre el proyecto con tu IDE favorito o navega hasta el directorio del proyecto 
6. Desde la terminal  para compilar el proyecto ejecuta:

   ```bash
   mvn clean install
   ```
7. compila el proyecto  

   ```bash
    mvn clean package
   ```
8. Corra el servidor en la clase httpServer "main"
   Vera que el servidor esta listo y corriendo sobre el puerto 35000
   
9. Puedes Ingresar desde el navegador a  la pagina:
    http://localhost:35000/index.html

10. Puedes interactuar con los endpoints RESTful (/api):
   - POST= http://localhost:35000/post.html

## Ejecutar las pruebas

Se implementaron pruebas unitarias para los métodos de manejo de solicitudes HTTP (GET, POST, PUT, DELETE) en el servidor. Estas pruebas se realizaron utilizando JUnit y Mockito para simular las solicitudes y validar las respuestas.

Para ejecutar las pruebas:  
1. Desde tu IDE, ejecuta las clase AppTest.java o desde la terminal ejecutas:
   ```bash
   mvn test
   ```
![{87FFD62C-2B50-419C-AE5E-D8CE2538F098}](https://github.com/user-attachments/assets/da9c1640-7dfa-44d5-b70d-bf02130bc98d)

2. Prueba para metodo Get

![{FD29DCC4-CDBD-4797-A6B9-F57E79499770}](https://github.com/user-attachments/assets/00d69ae9-c4e1-4088-9a6c-6093511a78e2)


## Built With
* [Maven](https://maven.apache.org/) - Dependency Management


## Authors

* **Andres felipe montes ortiz** - 

