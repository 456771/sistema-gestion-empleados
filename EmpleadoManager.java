import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmpleadoManager {
    private ArrayList<Empleado> empleados;
    private static final String ARCHIVO_DATOS = "empleados.dat";

    public EmpleadoManager() {
        empleados = new ArrayList<>();
        cargarDatos();
    }

    public boolean agregarEmpleado(Empleado empleado) {
        if (existeId(empleado.getId())) {
            return false;
        }
        empleados.add(empleado);
        guardarDatos();
        return true;
    }

    public boolean existeId(int id) {
        return empleados.stream().anyMatch(e -> e.getId() == id);
    }

    public List<Empleado> buscarEmpleados(String criterio) {
        String criterioBusqueda = criterio.toLowerCase();
        return empleados.stream()
            .filter(e -> 
                String.valueOf(e.getId()).contains(criterioBusqueda) ||
                e.getNombre().toLowerCase().contains(criterioBusqueda) ||
                e.getPuesto().toLowerCase().contains(criterioBusqueda))
            .collect(Collectors.toList());
    }

    public boolean actualizarEmpleado(int id, String nombre, String puesto, double salario) {
        for (Empleado emp : empleados) {
            if (emp.getId() == id) {
                emp.setNombre(nombre);
                emp.setPuesto(puesto);
                emp.setSalario(salario);
                guardarDatos();
                return true;
            }
        }
        return false;
    }

    public boolean eliminarEmpleado(int id) {
        boolean removido = empleados.removeIf(e -> e.getId() == id);
        if (removido) {
            guardarDatos();
        }
        return removido;
    }

    public ArrayList<Empleado> obtenerTodos() {
        return empleados;
    }

    private void guardarDatos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(ARCHIVO_DATOS))) {
            oos.writeObject(empleados);
        } catch (IOException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private void cargarDatos() {
        File archivo = new File(ARCHIVO_DATOS);
        if (archivo.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(ARCHIVO_DATOS))) {
                empleados = (ArrayList<Empleado>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error al cargar los datos: " + e.getMessage());
                empleados = new ArrayList<>();
            }
        }
    }
}
