package app;

public class Main {

    public static void main(String[] args) {

        GestorPedido gestor = new GestorPedido();

        Cliente cliente1 = new Cliente("Juan", "juan@gmail.com", "600111222");
        gestor.registrarCliente(cliente1);

        gestor.registrarCliente(new Cliente("Otro", "juan@gmail.com", "600000000"));

        Repartidor repartidor1 = new Repartidor("Pedro", "pedro@gmail.com", "699888777", "Centro");
        gestor.registrarRepartidor(repartidor1);

        Producto producto1 = new Producto("Pizza Barbacoa", 12.50, "Comida");
        Producto producto2 = new Producto("Coca Cola", 2.50, "Bebida");
        Producto producto3 = new Producto("Pizza Barbacoa", 12.50, "Comida");

        Pedido pedido1 = gestor.crearPedido(cliente1);
        pedido1.añadirProducto(producto1);
        pedido1.añadirProducto(producto2);
        pedido1.añadirProducto(producto3);

        System.out.println();

        gestor.asignarRepartidorAutomatico(pedido1);

        System.out.println();

        gestor.mostrarTodosPedidos();

        pedido1.entregarPedido();

        System.out.println();

        pedido1.entregarPedido();

        System.out.println();

        System.out.println("Estado final: " + pedido1.getEstado());
        System.out.println("Repartidor disponible: " + repartidor1.isDisponible());

        System.out.println();

        gestor.mostrarClientes();
        gestor.mostrarRepartidores();
    }
}