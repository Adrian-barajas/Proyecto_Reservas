import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Departamento {
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


   /* public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public void eliminarReserva(String codigoReserva) {
        Reserva reservaEliminar = null;
        for (Reserva reserva : reservas) {
            if (reserva.getCodigo().equals(codigoReserva)) {
                reservaEliminar = reserva;
                break;
            }
        }
        if (reservaEliminar != null) {
            reservas.remove(reservaEliminar);
            System.out.println("Reserva eliminada: " + reservaEliminar.getNombre());
        } else {
            System.out.println("No se encontró ninguna reserva con el código: " + codigoReserva);
        }
    }

    */

    public boolean verificarDisponibilidadSala(String fechaReserva, int horaInicio, int duracion) {
        // Verificar disponibilidad de la sala para la reserva en el periodo elegido
        // Lógica para verificar si la sala está disponible en el período elegido
        // Implementa la lógica según tus necesidades, por ejemplo, puedes comprobar si hay reservas en ese periodo
        return true; // Ejemplo: si la sala está disponible
    }

    public String obtenerCodigoSala() {
        // Lógica para obtener el código de la sala, por ejemplo, seleccionar la primera sala disponible
        return salas.get(0).getCodigo(); // Esto asume que las salas están almacenadas en una lista llamada "salas"
    }

    public void agregarReserva(String codigo, LocalDate fechaReserva, int horaInicio, int duracion) {
        // Verificar disponibilidad de la sala
        if (verificarDisponibilidadSala(String.valueOf(fechaReserva), horaInicio, duracion)) {
            // Obtener el código de la sala, dependiendo de tu lógica de implementación
            String codigoSala = obtenerCodigoSala(); // Esta parte necesitas definirla según tu implementación

            // Crear la reserva y agregarla al departamento
            Reserva nuevaReserva = new Reserva(codigo, this.getCodigo(), codigoSala, fechaReserva, horaInicio, duracion); // Se asigna automáticamente al departamento
            reservas.add(nuevaReserva);
            System.out.println("Reserva añadida correctamente.");
        } else {
            System.out.println("La sala no está disponible en el período elegido.");
        }
    }


    public void eliminarReserva(String fechaReserva, int horaInicio) {
        // Buscar la reserva correspondiente en el departamento
        for (Reserva reserva : reservas) {
            if (reserva.getFecha().equals(fechaReserva) && reserva.getHoraInicio() == horaInicio) {
                reservas.remove(reserva);
                System.out.println("Reserva eliminada correctamente.");
                return;
            }
        }
        // Si no se encuentra la reserva correspondiente
        System.out.println("No se encontró ninguna reserva en el período indicado.");
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void listarReservas() {
        System.out.println("Lista de reservas del departamento " + nombre + ":");
        for (Reserva reserva : reservas) {
            System.out.println(reserva);
        }
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