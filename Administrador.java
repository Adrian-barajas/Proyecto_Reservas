import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Administrador implements App {
    public static final String contrasena_administrador = "admin";
    public List<Departamento> departamentos;

    public Administrador() {
        departamentos = new ArrayList<>();
    }

    public boolean comprobarCont(String contrasena) {
        return contrasena_administrador.equals(contrasena);
    }

    public void addDepar(String codigo, String nombre) {
        for (Departamento departamento : departamentos) {
            if (departamento.getCodigo().equals(codigo)) {
                System.out.println("El código de departamento ya existe");
                return;
            }
        }
        Departamento departamento = new Departamento(codigo, nombre);
        departamentos.add(departamento); // Agregar el departamento creado a la lista
    }

    public void removeDepar(String codigo) {
        Departamento DepEliminar = null;
        for (Departamento departamento : departamentos) {
            if (departamento.getCodigo().equals(codigo)) {
                DepEliminar = departamento;
                break;
            }
        }
        if (DepEliminar != null) {
            departamentos.remove(DepEliminar);
            System.out.println("Departamento con el nombre " + DepEliminar.getNombre() +
                    " y con el código " + DepEliminar.getCodigo() + " ya está eliminado");
        } else {
            System.out.println("No existe este departamento con el código " + codigo);
        }
    }

    public ArrayList<Departamento> ListarDep() {
        return new ArrayList<>(departamentos);
    }

    public List<Sala> listaSala() {
        List<Sala> salas = new ArrayList<>();
        for (Departamento departamento : departamentos) {
            salas.addAll(departamento.getSalas());
        }
        return salas;
    }

    public List<Reserva> listaReserva() {
        List<Reserva> reservas = new ArrayList<>();
        for (Departamento departamento : departamentos) {
            for (Sala sala : departamento.getSalas()) {
                reservas.addAll(sala.getReservas());
            }
        }
        return reservas;
    }


    @Override
    public void loginAdministrador() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la contraseña de administrador: ");
        String password = scanner.nextLine();
        // Lógica de autenticación del administrador (aquí puedes implementar tu propia lógica)
        if (password.equals(contrasena_administrador)) {
            System.out.println("Bienvenido, administrador.");
        } else {
            System.out.println("Contraseña incorrecta. Volviendo al menú principal.");
        }
    }

    @Override
    public void loginDepartamento() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el código de departamento: ");
        String codigo = scanner.nextLine();

        boolean departamentoEncontrado = false;
        for (Departamento dep : departamentos) {
            if (dep.getCodigo().equals(codigo)) {
                departamentoEncontrado = true;
                System.out.println("Bienvenido, departamento " + dep.getNombre() + ".");
                break;
            }
        }

        if (!departamentoEncontrado) {
            System.out.println("Código de departamento incorrecto. Volviendo al menú principal.");
        }
    }

}