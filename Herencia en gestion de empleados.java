// Clase base: Empleado
// Esta clase define los atributos comunes para todos los empleados.
abstract class Empleado {
    protected String nombre;
    protected int edad;
    protected String cargo;

    // Constructor de la clase base
    public Empleado(String nombre, int edad, String cargo) {
        this.nombre = nombre;
        this.edad = edad;
        this.cargo = cargo;
    }

    // Método para mostrar la información común del empleado
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Cargo: " + cargo);
    }

    // Método abstracto para ser implementado por las subclases
    public abstract void mostrarDetalle();
}

// Clase derivada: EmpleadoGerente
// Esta clase hereda de Empleado y agrega un atributo exclusivo: departamento.
class EmpleadoGerente extends Empleado {
    private String departamento;

    // Constructor de la clase Gerente
    public EmpleadoGerente(String nombre, int edad, String cargo, String departamento) {
        super(nombre, edad, cargo);  // Llamada al constructor de la clase base
        this.departamento = departamento;
    }

    // Sobrescribimos el método mostrarInformacion para incluir el departamento
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();  // Llamamos al método de la clase base
        System.out.println("Departamento: " + departamento);
    }

    // Implementación del método abstracto
    @Override
    public void mostrarDetalle() {
        System.out.println("Gerente de Departamento: " + departamento);
    }
}

// Clase derivada: EmpleadoOperario
// Esta clase hereda de Empleado y agrega un atributo exclusivo: turno.
class EmpleadoOperario extends Empleado {
    private String turno;

    // Constructor de la clase Operario
    public EmpleadoOperario(String nombre, int edad, String cargo, String turno) {
        super(nombre, edad, cargo);  // Llamada al constructor de la clase base
        this.turno = turno;
    }

    // Sobrescribimos el método mostrarInformacion para incluir el turno
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();  // Llamamos al método de la clase base
        System.out.println("Turno: " + turno);
    }

    // Implementación del método abstracto
    @Override
    public void mostrarDetalle() {
        System.out.println("Operario en el turno: " + turno);
    }
}

// Clase derivada: EmpleadoAdministrativo
// Esta clase hereda de Empleado y agrega un atributo exclusivo: area.
class EmpleadoAdministrativo extends Empleado {
    private String area;

    // Constructor de la clase Administrativo
    public EmpleadoAdministrativo(String nombre, int edad, String cargo, String area) {
        super(nombre, edad, cargo);  // Llamada al constructor de la clase base
        this.area = area;
    }

    // Sobrescribimos el método mostrarInformacion para incluir el área
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();  // Llamamos al método de la clase base
        System.out.println("Área: " + area);
    }

    // Implementación del método abstracto
    @Override
    public void mostrarDetalle() {
        System.out.println("Administrativo del área: " + area);
    }
}

// Programa principal: Creación de objetos e instanciación de las subclases
public class Main {
    public static void main(String[] args) {
        // Instanciamos objetos de las subclases con atributos exclusivos
        Empleado gerente = new EmpleadoGerente("Carlos Pérez", 40, "Gerente", "Ventas");
        Empleado operario = new EmpleadoOperario("Ana Gómez", 25, "Operaria", "Mañana");
        Empleado administrativo = new EmpleadoAdministrativo("Luis Díaz", 35, "Administrativo", "Recursos Humanos");

        // Mostramos la información de cada empleado
        System.out.println("Información del Empleado Gerente:");
        gerente.mostrarInformacion();
        gerente.mostrarDetalle();

        System.out.println("\nInformación del Empleado Operario:");
        operario.mostrarInformacion();
        operario.mostrarDetalle();

        System.out.println("\nInformación del Empleado Administrativo:");
        administrativo.mostrarInformacion();
        administrativo.mostrarDetalle();
    }
}