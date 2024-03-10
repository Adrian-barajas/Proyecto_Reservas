import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Crear un administrador
        Administrador admin = new Administrador();

        // Prueba de inicio de sesión de administrador
        admin.loginAdministrador();

        // Agregar algunos departamentos
        admin.addDepar("VAN", "Departamento 1");
        admin.addDepar("002", "Departamento 2");

        // Mostrar lista de departamentos
        System.out.println("Lista de departamentos:");
        System.out.println(admin.ListarDep());

        // Mostrar lista de salas (debería estar vacía ya que no se han agregado salas aún)
        System.out.println("Lista de salas:");
        System.out.println(admin.listaSala());

        // Prueba de cierre de sesión de administrador
        System.out.println("Cerrando sesión del administrador");

        // Crear un departamento
        Departamento departamento = new Departamento("VAN", "Departamento 1");

        // Agregar una sala al departamento
        Sala sala = new Sala("001", "Sala 1");
        departamento.addSala(sala);

        // Mostrar lista de salas en el departamento
        System.out.println("Lista de salas en el departamento:");
        System.out.println(departamento.getSalas());

        // Prueba de inicio de sesión del departamento
        departamento.loginDepartamento();
    }
}
