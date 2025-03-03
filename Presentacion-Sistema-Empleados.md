# Sistema de Gestión de Empleados
## Presentación del Proyecto

---

### Estructura de la Aplicación

```mermaid
classDiagram
    class Empleado {
        -int id
        -String nombre
        -String puesto
        -double salario
        +getId()
        +getNombre()
        +getPuesto()
        +getSalario()
        +mostrarInformacion()
    }
    
    class EmpleadoManager {
        -ArrayList<Empleado> empleados
        +agregarEmpleado()
        +buscarEmpleados()
        +actualizarEmpleado()
        +eliminarEmpleado()
        -guardarDatos()
        -cargarDatos()
    }
    
    class Main {
        -Scanner scanner
        -EmpleadoManager manager
        +main()
        -mostrarMenu()
        -agregarEmpleado()
        -actualizarEmpleado()
    }
    
    Main --> EmpleadoManager
    EmpleadoManager --> Empleado
```

---

### Conceptos Aplicados

1. **Programación Orientada a Objetos**
   - Encapsulación
   - Clases y Objetos
   - Métodos y Atributos

2. **Gestión de Datos**
   - Serialización
   - Persistencia
   - Validación

3. **Diseño de Software**
   - Separación de Responsabilidades
   - Patrón Manager
   - Interfaz de Usuario

---

### Métodos Principales

#### Clase Empleado
- Constructor
- Getters y Setters
- mostrarInformacion()

#### Clase EmpleadoManager
- CRUD Operations
  * Create (agregarEmpleado)
  * Read (buscarEmpleados)
  * Update (actualizarEmpleado)
  * Delete (eliminarEmpleado)
- Persistencia de Datos
  * guardarDatos()
  * cargarDatos()

---

### Flujo de la Aplicación

```mermaid
flowchart TD
    A[Inicio] --> B[Mostrar Menú]
    B --> C{Selección Usuario}
    C -->|1| D[Agregar Empleado]
    C -->|2| E[Mostrar Empleados]
    C -->|3| F[Buscar Empleados]
    C -->|4| G[Actualizar Empleado]
    C -->|5| H[Eliminar Empleado]
    C -->|6| I[Salir]
    D --> J[Validar Datos]
    J -->|Éxito| K[Guardar en Archivo]
    J -->|Error| B
    E --> B
    F --> B
    G --> L[Verificar ID]
    L -->|Existe| M[Actualizar Datos]
    L -->|No Existe| B
    H --> N[Confirmar Eliminación]
    N --> B
    I --> O[Fin]
```

---

### Características Destacadas

1. **Validación de Datos**
   - Control de tipos de datos
   - Verificación de ID únicos
   - Manejo de errores

2. **Persistencia**
   - Almacenamiento en archivo
   - Recuperación automática
   - Serialización de objetos

3. **Interfaz de Usuario**
   - Menú interactivo
   - Feedback claro
   - Opciones intuitivas

---

### Pruebas y Resultados

- **Operaciones CRUD**
  * Creación exitosa de empleados
  * Búsqueda por diferentes criterios
  * Actualización de datos
  * Eliminación segura

- **Manejo de Errores**
  * Validación de entradas
  * Mensajes informativos
  * Recuperación de errores

---

### Conclusiones

- Sistema robusto y funcional
- Código mantenible y organizado
- Implementación de mejores prácticas
- Base para futuras mejoras
