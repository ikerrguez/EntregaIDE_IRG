package app;

import java.util.ArrayList;
import java.util.List;


public class GestorPedido {

    private List<Cliente> clientes;
    private List<Repartidor> repartidores;
    private List<Pedido> pedidos;

    private int contadorId;

    public GestorPedido() {
        this.clientes = new ArrayList<>();
        this.repartidores = new ArrayList<>();
        this.pedidos = new ArrayList<>();
        this.contadorId = 1;
    }


    public void registrarCliente(Cliente cliente) {
        for (Cliente c : clientes) {
            if (c.getEmail().equalsIgnoreCase(cliente.getEmail())) {
                System.out.println("Ya existe un cliente con ese email.");
                return;
            }
        }
        clientes.add(cliente);
        System.out.println("Cliente registrado: " + cliente.getNombre());
    }


    public void registrarRepartidor(Repartidor repartidor) {
        for (Repartidor r : repartidores) {
            if (r.getEmail().equalsIgnoreCase(repartidor.getEmail())) {
                System.out.println("Ya existe un repartidor con ese email.");
                return;
            }
        }
        repartidores.add(repartidor);
        System.out.println("Repartidor registrado: " + repartidor.getNombre());
    }


    public Pedido crearPedido(Cliente cliente) {
        Pedido pedido = new Pedido(contadorId++, cliente);
        pedidos.add(pedido);
        cliente.realizarPedido(pedido);
        return pedido;
    }


    public void asignarRepartidorAutomatico(Pedido pedido) {
        for (Repartidor r : repartidores) {
            if (r.isDisponible()) {
                pedido.asignarRepartidor(r);
                return;
            }
        }
        
        System.out.println("No hay repartidores disponibles en este momento para el pedido " + pedido.getId());
    }

    public void mostrarTodosPedidos() {
        System.out.println("\n===== LISTA DE PEDIDOS =====");
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos registrados.");
        } else {
            for (Pedido p : pedidos) {
                System.out.println(p);
            }
        }
        System.out.println("============================\n");
    }


    public void mostrarClientes() {
        System.out.println("\n===== CLIENTES =====");
        for (Cliente c : clientes) {
            System.out.println(c);
        }
        System.out.println("====================\n");
    }


    public void mostrarRepartidores() {
        System.out.println("\n===== REPARTIDORES =====");
        for (Repartidor r : repartidores) {
            System.out.println(r);
        }
        System.out.println("========================\n");
    }


    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Repartidor> getRepartidores() {
        return repartidores;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
}
