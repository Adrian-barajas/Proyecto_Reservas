import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Departamento{
    private String codigo;
    private String nombre;
    private List<Reserva> reservas;
    private List<Sala> salas;

    public Departamento(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.reservas = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }
    public List<Sala> getSalas() {
        return salas;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }
    @Override
    public String toString() {
        return "Departamento{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", reservas=" + reservas +
                '}';
    }
}