import java.util.Scanner;
import java.util.List;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static EmpleadoManager manager = new EmpleadoManager();

    public static void main(String[] args) {
        while (true) {
            mostrarMenu();
            if (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Introduce un número.");
                scanner.nextLine(); // Limpiar buffer
                continue;
            }
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1: agregarEmpleado(); break;
                case 2: mostrarEmpleados(); break;
                case 3: buscarEmpleados(); break;
                case 4: actualizarEmpleado(); break;
                case 5: eliminarEmpleado(); break;
                case 6:
                    System.out.println("¡Hasta luego!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n=== Sistema de Gestión de Empleados ===");
        System.out.println("1. Agregar empleado");
        System.out.println("2. Mostrar empleados");
        System.out.println("3. Buscar empleados");
        System.out.println("4. Actualizar empleado");
        System.out.println("5. Eliminar empleado");
        System.out.println("6. Salir");
        System.out.print("Elige una opción: ");
    }

    private static void agregarEmpleado() {
        System.out.println("\n== Agregar Nuevo Empleado ==");
        
        int id = leerEntero("ID: ", "ID inválido. Debe ser un número entero.");
        if (manager.existeId(id)) {
            System.out.println("Error: El ID ya existe en el sistema.");
            return;
        }

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine().trim();
        if (nombre.isEmpty()) {
            System.out.println("Error: El nombre no puede estar vacío.");
            return;
        }

        System.out.print("Puesto: ");
        String puesto = scanner.nextLine().trim();
        if (puesto.isEmpty()) {
            System.out.println("Error: El puesto no puede estar vacío.");
            return;
        }

        double salario = leerDouble("Salario: ", "Salario inválido. Debe ser un número decimal.");
        if (salario <= 0) {
            System.out.println("Error: El salario debe ser mayor que 0.");
            return;
        }

        Empleado nuevoEmpleado = new Empleado(id, nombre, puesto, salario);
        if (manager.agregarEmpleado(nuevoEmpleado)) {
            System.out.println("Empleado agregado con éxito.");
        } else {
            System.out.println("Error al agregar el empleado.");
        }
    }

    private static void mostrarEmpleados() {
        System.out.println("\n== Lista de Empleados ==");
        List<Empleado> empleados = manager.obtenerTodos();
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
            return;
        }
        empleados.forEach(Empleado::mostrarInformacion);
    }

    private static void buscarEmpleados() {
        System.out.println("\n== Buscar Empleados ==");
        System.out.print("Ingrese término de búsqueda (ID, nombre o puesto): ");
        String criterio = scanner.nextLine();
        
        List<Empleado> resultados = manager.buscarEmpleados(criterio);
        if (resultados.isEmpty()) {
            System.out.println("No se encontraron empleados.");
            return;
        }
        System.out.println("\nResultados encontrados:");
        resultados.forEach(Empleado::mostrarInformacion);
    }

    private static void actualizarEmpleado() {
        System.out.println("\n== Actualizar Empleado ==");
        int id = leerEntero("Ingrese ID del empleado a actualizar: ", 
                           "ID inválido. Debe ser un número entero.");
        
        if (!manager.existeId(id)) {
            System.out.println("Error: Empleado no encontrado.");
            return;
        }

        System.out.print("Nuevo nombre (Enter para mantener actual): ");
        String nombre = scanner.nextLine().trim();
        
        System.out.print("Nuevo puesto (Enter para mantener actual): ");
        String puesto = scanner.nextLine().trim();
        
        System.out.print("Nuevo salario (0 para mantener actual): ");
        double salario = leerDouble("", "Salario inválido.");

        // Obtener valores actuales si no se proporcionaron nuevos
        List<Empleado> emp = manager.buscarEmpleados(String.valueOf(id));
        if (!emp.isEmpty()) {
            if (nombre.isEmpty()) nombre = emp.get(0).getNombre();
            if (puesto.isEmpty()) puesto = emp.get(0).getPuesto();
            if (salario == 0) salario = emp.get(0).getSalario();
            
            if (manager.actualizarEmpleado(id, nombre, puesto, salario)) {
                System.out.println("Empleado actualizado con éxito.");
            } else {
                System.out.println("Error al actualizar el empleado.");
            }
        }
    }

    private static void eliminarEmpleado() {
        System.out.println("\n== Eliminar Empleado ==");
        int id = leerEntero("Ingrese ID del empleado a eliminar: ",
                           "ID inválido. Debe ser un número entero.");
        
        if (manager.eliminarEmpleado(id)) {
            System.out.println("Empleado eliminado con éxito.");
        } else {
            System.out.println("Error: Empleado no encontrado.");
        }
    }

    private static int leerEntero(String mensaje, String mensajeError) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(mensajeError);
            }
        }
    }

    private static double leerDouble(String mensaje, String mensajeError) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(mensajeError);
            }
        }
    }
}
