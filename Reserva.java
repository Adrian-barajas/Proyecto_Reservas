import java.time.LocalDate;
import java.util.List;

public class Reserva {
    private String codigo;
    private String departamentoCodigo;
    private String salaCodigo;
    private LocalDate fecha;
    private int horaInicio;
    private int duracion;
    List<Reserva> reservas;

    public Reserva(String codigo, String departamentoCodigo, String salaCodigo, LocalDate fecha, int horaInicio, int duracion) {
        this.codigo = codigo;
        this.departamentoCodigo = departamentoCodigo;
        this.salaCodigo = salaCodigo;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.duracion = duracion;
    }




    public String getCodigo() {
        return codigo;
    }

    public String getDepartamentoCodigo() {
        return departamentoCodigo;
    }

    public String getSalaCodigo() {
        return salaCodigo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public int getHoraInicio() {
        return horaInicio;
    }
    public List<Reserva> getReservas() {
        return reservas;
    }

    public int getDuracion() {
        return duracion;
    }


    @Override
    public String toString() {
        return "Reserva" +
                "codigo='" + codigo + '\'' +
                ", departamentoCodigo='" + departamentoCodigo + '\'' +
                ", salaCodigo='" + salaCodigo + '\'' +
                ", fecha=" + fecha +
                ", horaInicio=" + horaInicio +
                ", duracion=" + duracion;
    }
}