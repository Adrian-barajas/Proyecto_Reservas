import java.util.ArrayList;
import java.util.List;

public class Sala {
    public String codigo;
    public String nombre;
    public Departamento departamento;
    public List<Reserva> reservas;

    public Sala(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.reservas = new ArrayList<>();
    }

    public List<Reserva> getReservas() {
        return reservas;
    }


    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void addReserva(Reserva reserva) {
        if (!this.reservas.contains(reserva)) {
            this.reservas.add(reserva);
        } else {
            System.out.println("La reserva ya existe en la sala.");
        }
    }

    public void removeReserva(Reserva reserva) {
        if (this.reservas.contains(reserva)) {
            this.reservas.remove(reserva);
        } else {
            System.out.println("La reserva no existe en la sala.");
        }
    }
    public Reserva getReservaPorCodigo(String codigoReserva) {
        for (Reserva reserva : reservas) {
            if (reserva.getCodigo().equals(codigoReserva)) {
                return reserva;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Sala, " +
                "codigo es '" + codigo + '\'' +
                ", nombre es '" + nombre + '\'' ;
    }
}
