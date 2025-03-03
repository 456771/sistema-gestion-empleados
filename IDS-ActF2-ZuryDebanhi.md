# Sistema de Gestión de Empleados
### IDS - Actividad Final 2

**Alumna:** Zury Debanhi Sanchez Huerta  
**Fecha:** 3 de marzo de 2025  
**Repositorio:** [https://github.com/456771/sistema-gestion-empleados](https://github.com/456771/sistema-gestion-empleados)

## Documentación del Sistema

### 1. Estructura del Proyecto

El proyecto está organizado en tres clases principales:

1. **Empleado.java**
   - Clase que representa la entidad Empleado
   - Implementa Serializable para permitir la persistencia de datos
   - Atributos: id, nombre, puesto, salario
   - Métodos getters y setters
   - Método mostrarInformacion() para visualización de datos

2. **EmpleadoManager.java**
   - Clase que maneja la lógica de negocio
   - Gestiona la persistencia de datos usando serialización
   - Implementa operaciones CRUD:
     * agregarEmpleado()
     * buscarEmpleados()
     * actualizarEmpleado()
     * eliminarEmpleado()
   - Maneja el almacenamiento en archivo (empleados.dat)

3. **Main.java**
   - Punto de entrada de la aplicación
   - Implementa la interfaz de usuario por consola
   - Maneja la interacción con el usuario
   - Valida entradas de datos

### 2. Conceptos Aplicados

1. **Programación Orientada a Objetos**
   - Encapsulación: Atributos privados con getters/setters
   - Clases y Objetos: Estructura modular del código
   - Métodos: Comportamiento definido para cada clase

2. **Manejo de Datos**
   - Serialización de objetos para persistencia
   - ArrayList para almacenamiento en memoria
   - Validación de entradas de usuario

3. **Patrones de Diseño**
   - Patrón Manager para la gestión de datos
   - Separación de responsabilidades (SRP)
   - Interfaz de usuario separada de la lógica de negocio

### 3. Métodos Principales

#### Clase Empleado
```java
public void mostrarInformacion()
// Muestra la información formateada del empleado
```

#### Clase EmpleadoManager
```java
public boolean agregarEmpleado(Empleado empleado)
// Agrega un nuevo empleado si el ID no existe

public List<Empleado> buscarEmpleados(String criterio)
// Busca empleados por ID, nombre o puesto

public boolean actualizarEmpleado(int id, String nombre, String puesto, double salario)
// Actualiza la información de un empleado existente

public boolean eliminarEmpleado(int id)
// Elimina un empleado por su ID
```

#### Clase Main
```java
private static void mostrarMenu()
// Muestra el menú principal de opciones

private static void agregarEmpleado()
// Maneja el proceso de agregar un nuevo empleado

private static void actualizarEmpleado()
// Gestiona la actualización de empleados existentes
```

## Referencias Bibliográficas

1. Oracle. (2024). *Java Documentation*. https://docs.oracle.com/en/java/
2. Gamma, E., Helm, R., Johnson, R., & Vlissides, J. (1994). *Design Patterns: Elements of Reusable Object-Oriented Software*. Addison-Wesley.
3. Bloch, J. (2018). *Effective Java* (3rd ed.). Addison-Wesley Professional.
4. Martin, R. C. (2008). *Clean Code: A Handbook of Agile Software Craftsmanship*. Prentice Hall.
