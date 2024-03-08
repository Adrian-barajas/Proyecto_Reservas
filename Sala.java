import java.util.ArrayList;
import java.util.List;

public class Sala {
    public String codigo;
    public String nombre;
    public Departamento departamento;
    public List<Reserva> reservas;
    public Sala(String codigo, String nombre, Departamento departamento) {
        this.codigo=codigo;
        this.nombre=nombre;
        this.departamento=departamento;
        this.reservas=new ArrayList<>();
    }
    public List<Reserva> getReservas(){
        return reservas;
    }
}
