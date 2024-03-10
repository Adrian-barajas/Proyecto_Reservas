import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Departamento extends Administrador{
    public String codigo;
    public String nombre;
    public List<Sala> salas;
    public List<Reserva> reservas;

    public Departamento(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.salas = new ArrayList<>();
        this.reservas = new ArrayList<>(); // Inicialización de la lista de reservas
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

    public void addSala(Sala sala) {
        this.salas.add(sala);
    }

    public void removeSala(Sala sala) {
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

    public Reserva getReserva(String codigoReserva) {
        for (Reserva reserva : reservas) {
            if (reserva.getCodigo().equals(codigoReserva)) {
                return reserva;
            }
        }
        return null;
    }

    public void addReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public void removeReserva(Reserva reserva) {
        reservas.remove(reserva);
    }

    public String toString() {
        return "Departamento, codigo: " + codigo + ", nombre: " + nombre + ", reservas: " + reservas;
    }

    public Sala encontrarSalaPorCodigo(String codigo) {
        for (Sala sala : salas) {
            if (sala.getCodigo().equals(codigo)) {
                return sala;
            }
        }
        return null;
    }

    public void listarReservas() {
        for (Sala sala : salas) {
            System.out.println("Reservas de la sala " + sala.getNombre() + ":");
            for (Reserva reserva : sala.getReservas()) {
                System.out.println(reserva);
            }
        }
    }

    public void addReserva(String salaCodigo, Reserva reserva) {
        Sala sala = encontrarSalaPorCodigo(salaCodigo);
        if (sala != null) {
            sala.addReserva(reserva);
        } else {
            System.out.println("No existe una sala con el código " + salaCodigo);
        }
    }

    public void removeReserva(String salaCodigo, Reserva reserva) {
        Sala sala = encontrarSalaPorCodigo(salaCodigo);
        if (sala != null) {
            sala.removeReserva(reserva);
        } else {
            System.out.println("No existe una sala con el código " + salaCodigo);
        }
    }
}