import java.io.Serializable;

public class Empleado implements Serializable {
    private int id;
    private String nombre;
    private String puesto;
    private double salario;

    public Empleado(int id, String nombre, String puesto, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
    }

    // Getters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getPuesto() { return puesto; }
    public double getSalario() { return salario; }

    // Setters
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPuesto(String puesto) { this.puesto = puesto; }
    public void setSalario(double salario) { this.salario = salario; }

    public void mostrarInformacion() {
        System.out.printf("ID: %d, Nombre: %s, Puesto: %s, Salario: $%.2f%n", 
            id, nombre, puesto, salario);
    }
}
