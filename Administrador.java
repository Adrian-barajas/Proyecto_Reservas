import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Administrador {
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
            if(departamento.getCodigo().equals(codigo)){
                System.out.println("El codigo de departamento ya existe");
                return;
            }
        }
        Departamento departamento=new Departamento(codigo,nombre);
        departamentos.add(departamento);
    }
    public void removeDepar(String codigo){
        Departamento DepEleminar= null;
        for(Departamento departamento:departamentos){
            if(departamento.getCodigo().equals(codigo)){
                DepEleminar=departamento;
                break;
            }
        }
        if(DepEleminar!=null){
            departamentos.remove(DepEleminar);
            System.out.println("Departamento ya esta eleminado"+DepEleminar.getNombre());
        }
        else {
            System.out.println("NO existe este departameno con el codigo "+codigo);
        }
    }
    public ArrayList<Departamento> ListarDep(List<Departamento> departamentos){
        return new ArrayList<>(departamentos);
    }
    public List<Sala> listaSala(){
        List<Sala> salas = new ArrayList<>();
        for (Departamento departamento:departamentos){
            salas.addAll(departamento.getSalas());
        }
        return salas;
    }
    public List<Reserva> listaReserva(){
        List<Reserva> reservas=new ArrayList<>();
        for(Departamento departamento:departamentos){
            for(Sala sala:departamento.getSalas()){
               // reservas.addAll(sala.getReservas());
            }
        }
        return reservas;
    }
    public void mostrarMenu(){
        Scanner scanner=new Scanner(System.in);
        String cotrasena;

        do{
            System.out.println("Menu de administardor:");
            System.out.println("1.Adgregar departemeno " +
                    "\n2.Eleminar departamento" +
                    "\n3.Listar departamento" +
                    "\n4.Listar salas" +
                    "\n5.Listar reservas" +
                    "\n6.Cerrar sesion" +
                    "\nEscribe la contrasena de admin");
            cotrasena=scanner.nextLine();
        }while (!comprobarCont(cotrasena));
        int opcion;
        do{
            System.out.println("Selecion una opcion");
            opcion=scanner.nextInt();
            scanner.nextLine();

            switch (opcion){
                case 1:
                    System.out.println("Escribe el codigo de departamento");
                    String codigo=scanner.nextLine();
                    System.out.println("Escribe el nombre de departamento");
                    String nombre=scanner.nextLine();
                    addDepar(codigo,nombre);
                    break;
                case 2:
                    System.out.println("Escribe el codigo de departamento que queres eleminar:");
                    String codEleminar=scanner.nextLine();
                    removeDepar(codEleminar);
                    break;
                case 3:
                    ListarDep(departamentos);
                case 4:
                    listaSala();
                case 5:
                    listaReserva();
                case 6:
                    System.out.println("Estas saliendo ya...");
                    break;
                default:
                    System.out.println("HA ocurriodo un error");
            }
        }while (opcion!=6);
    }
}
