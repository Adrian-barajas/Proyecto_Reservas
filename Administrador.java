import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Administrador implements App {
    private static final String CONTRASENA_ADMINISTRADOR = "admin";
    static List<Departamento> departamentos = new ArrayList<>();
    static List<Sala> salas = new ArrayList<>();

    public Administrador() {
        departamentos = new ArrayList<>();
    }

    public boolean comprobarContrasena(String contrasena) {
        return CONTRASENA_ADMINISTRADOR.equals(contrasena);
    }

    public void agregarDepartamento(String codigo, String nombre) {
        for (Departamento departamento : departamentos) {
            if (departamento.getCodigo().equals(codigo)) {
                System.out.println("\n"+"El código de departamento ya existe"+"\n");
                return;
            }
        }
        Departamento departamento = new Departamento(codigo, nombre);
        departamentos.add(departamento);
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
            System.out.println();
        } else {
            System.out.println("No se encontró ningún departamento con el código: " + codigo+"\n");
        }
    }

    public void listarDepartamentos() {
        System.out.println("Lista de departamentos:");
        for (Departamento departamento : departamentos) {
            System.out.println(departamento);
        }
    }

    public List<Sala> listaSala() {
        System.out.println("Lista de salas:");
        for (Sala sala : salas) {
            System.out.println(sala);
        }
        return salas;
    }

    public void agregarSala() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el código de la sala: ");
        String codigoSala = scanner.nextLine().toUpperCase();

        if(codigoSala.length()!=3){
            System.out.println("El código de sala debe tener exactamente tres caracteres.");
            return;
        }
        for (Sala sala : salas) {
            if (sala.getCodigo().equals(codigoSala)) {
                System.out.println("El código de sala ya existe.");
                return;
            }
        }

        System.out.print("Ingrese el nombre de la sala: ");
        String nombreSala = scanner.nextLine();


        Sala nuevaSala = new Sala(codigoSala, nombreSala);
        salas.add(nuevaSala);

        System.out.println("Sala agregada correctamente.");
    }

    public void eliminarSala() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el código de la sala que desea eliminar: ");
        String codigoSalaEliminar = scanner.nextLine().toUpperCase();

        Sala salaEliminar = null;

        for (Sala sala : salas) {
            if (sala.getCodigo().equals(codigoSalaEliminar)) {
                salaEliminar = sala;
                break;
            }
        }

        if (salaEliminar != null) {

            salas.remove(salaEliminar);
            System.out.println("Sala eliminada correctamente.");


            for (Departamento departamento : departamentos) {
                for (Reserva reserva : departamento.getReservas()) {
                    if (reserva.getSalaCodigo().equals(codigoSalaEliminar)) {
                        departamento.getReservas().remove(reserva);
                        break;
                    }
                }
            }
        } else {
            System.out.println("No se encontró ninguna sala con el código proporcionado.");
        }
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

    public void agregarReserva() {
        Scanner in = new Scanner(System.in);

        System.out.print("Ingrese el código de reserva: ");
        String codigoReserva = in.nextLine();

        System.out.print("Ingrese el código del departamento: ");
        String codigoDepartamento = in.nextLine().toUpperCase();

        Departamento departamento = null;
        for (Departamento depto : departamentos) {
            if (depto.getCodigo().equals(codigoDepartamento)) {
                departamento = depto;
                break;
            }
        }

        if (departamento == null) {
            System.out.println("El departamento especificado no existe.");
            return;
        }
    }

    public void eliminarReserva() {
        Scanner in = new Scanner(System.in);

        System.out.print("Ingrese el código de sala de la reserva que desea cancelar: ");
        String codigoSala = in.nextLine().toUpperCase();


        System.out.print("Ingrese el código del departamento: ");
        String codigoDepartamento = in.nextLine().toUpperCase();


        Departamento departamento = null;
        for (Departamento depto : departamentos) {
            if (depto.getCodigo().equals(codigoDepartamento)) {
                departamento = depto;
                break;
            }
        }

        if (departamento == null) {
            System.out.println("El departamento especificado no existe.");
            return;
        }
    }

    @Override
    public void loginAdministrador() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la contraseña de administrador: ");
        String password = scanner.nextLine();
        if (!comprobarContrasena(password)) {
            System.out.println("\n"+"Contraseña incorrecta. Volviendo al menú principal."+"\n");
            Menu();
        } else {
            System.out.println("\n"+"Bienvenido, administrador."+"\n");
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
                System.out.println("\n"+"El código de departamento debe tener exactamente tres letras."+"\n");
            }
        } while (codigo.length() != 3);

        boolean departamentoEncontrado = false;
        for (Departamento dep : departamentos) {
            if (dep.getCodigo().equalsIgnoreCase(codigo)) {
                departamentoEncontrado = true;
                System.out.println("\n"+"Bienvenido, departamento " + dep.getNombre() + ".");
                mostrarMenuDepartamento();
            }
        }

        if (!departamentoEncontrado) {
            System.out.println("\n"+"Código de departamento incorrecto. Volviendo al menú principal."+"\n");
            Menu();
        }
    }



    public void Menu() {
        Scanner in = new Scanner(System.in);
        int OPCION = 0;

        do {
            System.out.println("Elige un usuario:"+"\n");
            System.out.println("1. Entrar como administrador"+"\n"+
                                "2. Entrar como departamento"+"\n"+
                                "3. Salir");
            System.out.print("\n"+"Escribe una opción: ");

            if (in.hasNextInt()) {
                OPCION = in.nextInt();
                if (OPCION != 1 && OPCION != 2 && OPCION!=3) {
                    System.out.println("\n"+"Debes escribir un número correspondiente a una opción válida."+"\n");
                    OPCION = 0;
                }
            } else {
                System.out.println("\n"+"Debes escribir un número correspondiente a una opción válida."+"\n");
                in.next();
            }
            if (OPCION == 1) {
                loginAdministrador();
            } else if(OPCION==2){
                loginDepartamento();
            }else if (OPCION==3) {
                System.out.println("Adios, Hasta pronto");
                break;
            }

        } while (OPCION!=3);
    }

    public void mostrarMenuAdministrador() {
        Scanner in = new Scanner(System.in);

        System.out.println("Menu de administrador:");
        System.out.println("1. Agregar departamento " +
                "\n2. Eliminar departamento" +
                "\n3. Listar departamentos" +
                "\n4. Agregar salas" +
                "\n5. Eleminar salas" +
                "\n6. Listar salas" +
                "\n7. Listar reservas" +
                "\n8. Cerrar sesión");

        int opcion = 0;

        do {
            System.out.println("Seleccione una opción");
            while (!in.hasNextInt()) {
                System.out.println("\n"+"Por favor, ingrese solo un número válido entre 1 y 6."+"\n");
                in.next();
            }

            opcion = in.nextInt();
            in.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Escribe el código de departamento");
                    String codigo = in.nextLine();
                    if (codigo.length() != 3) {
                        System.out.println("\n"+"El código de departamento debe tener solo 3 letras"+"\n");
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
                    agregarSala();
                    break;
                case 5:
                    eliminarSala();
                    break;
                case 6:
                    listaSala();
                    break;
                case 7:
                    System.out.println(listaReserva());
                    break;
                case 8:
                    System.out.println("\n"+"Cerrando sesión del administrador"+"\n");
                default:
                    System.out.println("\n"+"Opción no válida. Inténtelo de nuevo."+"\n");
                    break;
            }
        } while (opcion != 8);
    }
    public void mostrarMenuDepartamento() {
        Scanner in = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\n"+"Menú de departamento:");
            System.out.println("1. Agregar Reserva");
            System.out.println("2. Eliminar Reserva");
            System.out.println("3. Listar Reservas");
            System.out.println("4. Cerrar Sesión");
            System.out.print("Seleccione una opción: ");

            opcion = in.nextInt();
            in.nextLine();

            switch (opcion) {
                case 1:
                    agregarReserva();
                    break;
                case 2:
                    eliminarReserva();
                    break;
                case 3:
                    listaReserva();
                    break;
                case 4:
                    System.out.println("Cerrando sesión del departamento.");
                    return;
                default:
                    System.out.println("\n"+"Opción no válida. Inténtelo de nuevo."+"\n");
            }
        } while (opcion != 4);
    }
}