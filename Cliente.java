
package app;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {

    private List<Pedido> pedidos;

    public Cliente(String nombre, String email, String telefono) {
        super(nombre, email, telefono);
        this.pedidos = new ArrayList<>();
    }
    
    public void realizarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }
    
    public List<Pedido> getPedidos() {
        return pedidos;
    }

    @Override
    public String toString() {
        return "Cliente: " + getNombre() + " | Pedidos: " + pedidos.size();
    }
}