package app;

import java.util.ArrayList;
import java.util.List;

public class Repartidor extends Usuario {

    private String zonaReparto;
    private String estado;
    private List<Pedido> pedidosAsignados;

    public Repartidor(String nombre, String email, String telefono, String zonaReparto) {
        super(nombre, email, telefono);
        this.zonaReparto = zonaReparto;
        this.estado = "Disponible";
        this.pedidosAsignados = new ArrayList<>();
    }

    public boolean isDisponible() {
        return estado.equals("Disponible");
    }

    public void setOcupado() {
        estado = "Ocupado";
    }

    public void setDisponible() {
        estado = "Disponible";
    }

    public void agregarPedidoAsignado(Pedido pedido) {
        pedidosAsignados.add(pedido);
    }

    public String getZonaReparto() {
        return zonaReparto;
    }

    public void setZonaReparto(String zonaReparto) {
        this.zonaReparto = zonaReparto;
    }

    public String getEstado() {
        return estado;
    }

    public List<Pedido> getPedidosAsignados() {
        return pedidosAsignados;
    }


    @Override
    public String toString() {
        return "Repartidor: " + getNombre() +
                " | Estado: " + estado;
    }
}