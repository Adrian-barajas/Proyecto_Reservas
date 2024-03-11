import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Administrador implements App {
    private static final String CONTRASENA_ADMINISTRADOR = "admin";
    static List<Departamento> departamentos = new ArrayList<>();

    public Administrador() {
        departamentos = new ArrayList<>();
    }

    public boolean comprobarContrasena(String contrasena) {
        return CONTRASENA_ADMINISTRADOR.equals(contrasena);
    }

    public void agregarDepartamento(String codigo, String nombre) {
        for (Departamento departamento : departamentos) {
            if (departamento.getCodigo().equals(codigo)) {
                System.out.println("El código de departamento ya existe");
                return;
            }
        }
        Departamento departamento = new Departamento(codigo, nombre);
        departamentos.add(departamento); // Agrega el departamento a la lista estática
    }

    public void eliminarDepartamento(String codigo) {
        Departamento departamentoEliminar = null;
        for (Departamento departamento : departamentos) {
            if (departamento.getCodigo().equals(codigo)) {
                departamentoEliminar = departamento;
                break;
            }
        }
        if (departamentoEliminar != null) {
            departamentos.remove(departamentoEliminar);
            System.out.println("Departamento eliminado: " + departamentoEliminar.getNombre());
        } else {
            System.out.println("No se encontró ningún departamento con el código: " + codigo);
        }
    }

    public void listarDepartamentos() {
        System.out.println("Lista de departamentos:");
        for (Departamento departamento : departamentos) {
            System.out.println(departamento);
        }
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
            for (Reserva reserva : departamento.getReservas()) {
                reservas.addAll(reserva.getReservas());
            }
        }
        return reservas;
    }

    @Override
    public void loginAdministrador() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la contraseña de administrador: ");
        String password = scanner.nextLine();
        if (!comprobarContrasena(password)) {
            System.out.println("Contraseña incorrecta. Volviendo al menú principal.");
            Menu();
        } else {
            System.out.println("Bienvenido, administrador.");
            mostrarMenuAdministrador();

        }
    }

    @Override
    public void loginDepartamento() {
        Scanner scanner = new Scanner(System.in);
        String codigo;

        do {
            System.out.print("Ingrese el código de departamento (debe tener tres letras): ");
            codigo = scanner.nextLine().toUpperCase();
            if (codigo.length() != 3) {
                System.out.println("El código de departamento debe tener exactamente tres letras.");
            }
        } while (codigo.length() != 3);

        boolean departamentoEncontrado = false;
        for (Departamento dep : departamentos) {
            if (dep.getCodigo().equalsIgnoreCase(codigo)) {
                departamentoEncontrado = true;
                System.out.println("Bienvenido, departamento " + dep.getNombre() + ".");
                mostrarMenuDepartamento();
            }
        }

        if (!departamentoEncontrado) {
            System.out.println("Código de departamento incorrecto. Volviendo al menú principal.");
            Menu();
        }
    }



    public void Menu() {
        Scanner in = new Scanner(System.in);
        int OPCION = 0;

        do {
            System.out.println("Elige una opción:");
            System.out.println("1. Entrar como administrador");
            System.out.println("2. Entrar como departamento");
            System.out.print("Escribe una opción: ");

            if (in.hasNextInt()) {
                OPCION = in.nextInt();
                if (OPCION != 1 && OPCION != 2) {
                    System.out.println("Debes escribir un número correspondiente a una opción válida.");
                    OPCION = 0;
                }
            } else {
                System.out.println("Debes escribir un número correspondiente a una opción válida.");
                in.next();
            }
        } while (OPCION != 1 && OPCION != 2);

        if (OPCION == 1) {
            loginAdministrador();
        } else {
            loginDepartamento();
        }
    }

    public void mostrarMenuAdministrador() {
        Scanner in = new Scanner(System.in);

        System.out.println("Menu de administrador:");
        System.out.println("1. Agregar departamento " +
                "\n2. Eliminar departamento" +
                "\n3. Listar departamentos" +
                "\n4. Listar salas" +
                "\n5. Listar reservas" +
                "\n6. Cerrar sesión");

        int opcion = 0;

        do {
            System.out.println("Seleccione una opción");
            while (!in.hasNextInt()) {
                System.out.println("Por favor, ingrese solo un número válido entre 1 y 6.");
                in.next();
            }

            opcion = in.nextInt();
            in.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Escribe el código de departamento");
                    String codigo = in.nextLine();
                    if (codigo.length() != 3) {
                        System.out.println("El código de departamento debe tener solo 3 letras");
                    } else {
                        System.out.println("Escribe el nombre de departamento");
                        String nombre = in.nextLine();
                        agregarDepartamento(codigo, nombre);
                    }
                    break;
                case 2:
                    System.out.println("Escribe el código de departamento que deseas eliminar: ");
                    String codEliminar = in.nextLine();
                    eliminarDepartamento(codEliminar);
                    break;
                case 3:
                    listarDepartamentos();
                    break;
                case 4:
                    System.out.println(listaSala());
                    break;
                case 5:
                    System.out.println(listaReserva());
                    break;
                case 6:
                    System.out.println("Cerrando sesión del administrador");
                    Menu();
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        } while (opcion != 6);
    }
    public void mostrarMenuDepartamento() {
        Scanner in = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("Menú de departamento:");
            System.out.println("1. Agregar Reserva");
            System.out.println("2. Eliminar Reserva");
            System.out.println("3. Listar Reservas");
            System.out.println("4. Cerrar Sesión");
            System.out.print("Seleccione una opción: ");

            opcion = in.nextInt();
            in.nextLine(); // Consumir la nueva línea después de leer el número

            switch (opcion) {
                case 1:
                    // Lógica para agregar reserva
                    break;
                case 2:
                    // Lógica para eliminar reserva
                    break;
                case 3:
                    listaReserva();
                    break;
                case 4:
                    System.out.println("Cerrando sesión del departamento.");
                    return; // Salir del método y volver al menú principal
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } while (opcion != 4);
    }
}