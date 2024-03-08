import java.util.ArrayList;
import java.util.List;

public class Departamento {
    public String codigo;
    public String nombre;
    public List<Sala> salas;
    public List<Reserva> reservas;

    public Departamento(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.salas = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void addSala(Sala sala){
        this.salas.add(sala);
    }
    public void removeSala(Sala sala){
        this.salas.remove(sala);
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
    public Reserva getReserva(String codigoReserva){
        for(Reserva reserva:reservas){
            if(reserva.getCodigo().equals(codigoReserva)){
                return reserva;
            }
        }
        return null;
    }
    public void addReserva(Reserva reserva){
        reservas.add(reserva);
    }
    public void removeReserva(Reserva reserva){
        reservas.remove(reserva);
    }
    public String toString(){
        return "Departamento, codigo: " + codigo + ", nombre: " + nombre + ", reservas: " + reservas;
    }
}

