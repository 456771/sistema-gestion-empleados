# Sistema de Gestión de Empleados

Sistema de gestión de empleados desarrollado en Java que permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) y mantiene persistencia de datos.

## Funcionalidades

- Agregar nuevos empleados
- Mostrar lista de empleados
- Buscar empleados por ID, nombre o puesto
- Actualizar información de empleados
- Eliminar empleados
- Persistencia de datos en archivo

## Estructura del Proyecto

- `Main.java`: Punto de entrada de la aplicación y manejo de la interfaz de usuario
- `Empleado.java`: Clase que define la estructura de datos de un empleado
- `EmpleadoManager.java`: Clase que maneja la lógica de negocio y persistencia de datos

## Requisitos

- Java 17 o superior
- Compilador Java (javac)

## Uso

1. Compile los archivos Java:
```bash
javac *.java
```

2. Ejecute la aplicación:
```bash
java Main
```

## Almacenamiento de Datos

Los datos se almacenan en un archivo `empleados.dat` en el directorio del proyecto.
