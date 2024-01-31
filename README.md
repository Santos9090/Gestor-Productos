# Proyecto Java con Springboot y Proyecto Angular

## Index
1. Introduccion
2. Requisitos del sistema
3. Configuración y Despliegue
4. Arquitectura y Diseño del Software


## Introduccion

Estamos ante un programa de gestion de productos, que pretende facilitar y asegurar la utilizacion de una base de datos en servidor, para todo tipo de usuarios. Es decir que pretende ser una aplicacion sencilla donde gestionar datos. Y ademas evitar que el usuario pueda errar y borrar datos o Bases de datos completas realizando peticiones SQL directamente.

Por tanto se a optado por una arquitectura Cliente-Servidor, donde el servidor esta hecho en Java con el FrameWork de Spring, y el cliente es una pagina web de angular.

## Requisitos del Sistema

Para ejecutar tanto el proyecto Java como el de Angular, es necesario contar con las siguientes herramientas instaladas en la versión más reciente:

- **Java (JRE):**
  - Descarga e instala el Java Runtime Environment (JRE) desde [este enlace](https://www.java.com/es/download/ie_manual.jsp).

- **Node.js:**
  - Descarga e instala Node.js desde [este enlace](https://nodejs.org/).

- **Angular CLI (Interfaz de Línea de Comandos de Angular):**
  - Sigue el tutorial proporcionado [aquí](https://www.freecodecamp.org/espanol/news/como-instalar-angular-en-windows/) para instalar Angular CLI.

Asegúrate de tener estas herramientas instaladas correctamente antes de proceder con la ejecución del sistema.

## Requisitos del Sistema

Para ejecutar tanto el proyecto Java como el de Angular, es necesario contar con las siguientes herramientas instaladas en la versión más reciente:

- **Java (JRE):**
  - Descarga e instala el Java Runtime Environment (JRE) desde [este enlace](https://www.java.com/es/download/ie_manual.jsp).

- **Node.js:**
  - Descarga e instala Node.js desde [este enlace](https://nodejs.org/).

- **Angular CLI (Interfaz de Línea de Comandos de Angular):**
  - Sigue el tutorial proporcionado [aquí](https://www.freecodecamp.org/espanol/news/como-instalar-angular-en-windows/) para instalar Angular CLI.

Asegúrate de tener estas herramientas instaladas correctamente antes de proceder con la ejecución del sistema.

---

## Configuración y Despliegue

### Configuración del Sistema

Antes de iniciar el despliegue, asegúrate de haber configurado adecuadamente el entorno de desarrollo y haber cumplido con los requisitos del sistema mencionados anteriormente.

1. **Configuración del Servidor Java:**
   - Asegúrate de que el servidor Java esté correctamente configurado con las dependencias necesarias.
   - Verifica que no haya conflictos de puertos y que el servidor esté listo para recibir conexiones.

2. **Configuración del Proyecto Angular:**
   - Navega hasta el directorio de tu proyecto Angular.
   - Asegúrate de haber instalado las dependencias utilizando el comando:
     ```bash
     npm install
     ```

### Despliegue del Sistema

Una vez que todo esté configurado, procede con el despliegue del sistema en la misma máquina.

1. Abre una terminal o línea de comandos.

2. Navega hasta el directorio donde se encuentra tu proyecto Java.

3. Y ejecutalo con los comandos de java.

4. Repite el paso 2 y 3 pero con el proyecto de angular.(Usando comandos de angular)

## Arquitectura y Diseño del Software

### Diagrama de clases
------------------------------------ src

--------------------------------- main

------------------ java

------------- com.UD4

---- Angular

--- config

-- WebConfig.java

--- ProductosController.java

---- Persistence

--- entitys

-- ProductosEntity.java

--- repositorys

-- ProductosJPA.java

-- ProductosRepository.java

----Ud4Application.java

------------------ resouces

------------- Visual(Proyecto angular)

------------- aplication.propierties

--------------------------------- test








