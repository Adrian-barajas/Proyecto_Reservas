import java.time.LocalDate;

public class Reserva {
    private String codigo;
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Reserva(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        // Se omiten las fechas para simplificar, pero puedo agregarlas si es necesario
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Reserva [codigo=" + codigo + ", nombre=" + nombre + "]";
    }
}