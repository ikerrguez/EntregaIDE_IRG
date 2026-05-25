package app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private int id;
    private LocalDate fechaPedido;
    private EstadoPedido estado;
    private Cliente cliente;
    private Repartidor repartidor;
    private List<Producto> productos;

    public Pedido(int id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.fechaPedido = LocalDate.now();
        this.estado = EstadoPedido.PENDIENTE;
        this.productos = new ArrayList<>();
    }

    public void añadirProducto(Producto producto) {

        for (Producto p : productos) {

            if (p.getNombre().equalsIgnoreCase(producto.getNombre())) {

                System.out.println("No se permiten productos duplicados.");
                return;
            }
        }

        productos.add(producto);

        System.out.println("Producto añadido correctamente.");
    }

    public double calcularTotal() {

        double total = 0;

        for (Producto p : productos) {
            total += p.getPrecio();
        }

        return total;
    }

    public void asignarRepartidor(Repartidor repartidor) {

        if (productos.isEmpty()) {

            System.out.println("No se puede asignar un repartidor sin productos.");
            return;
        }

        if (!repartidor.isDisponible()) {

            System.out.println("El repartidor no está disponible.");
            return;
        }

        this.repartidor = repartidor;

        estado = EstadoPedido.EN_REPARTO;

        repartidor.setOcupado();

        repartidor.agregarPedidoAsignado(this);

        System.out.println("Repartidor asignado correctamente.");
    }

    public void entregarPedido() {

        if (estado != EstadoPedido.EN_REPARTO) {

            System.out.println("El pedido no está en reparto.");
            return;
        }

        estado = EstadoPedido.ENTREGADO;

        if (repartidor != null) {
            repartidor.setDisponible();
        }

        System.out.println("Pedido entregado correctamente.");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Repartidor getRepartidor() {
        return repartidor;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        String listaProductos = "";
        for (Producto p : productos) {
            listaProductos += "\n- " + p;
        }
        return "Pedido " + id +
                " | Estado: " + estado +
                " | Cliente: " + cliente.getNombre() +
                " | Total: " +  calcularTotal() + "€" +
                "\nProductos: " + listaProductos;
    }
}