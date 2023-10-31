package poo.ejercicioclase.ejercicio2.servicio.pedido;

import poo.ejercicioclase.ejercicio2.Main;
import poo.ejercicioclase.ejercicio2.domain.Carrito;
import poo.ejercicioclase.ejercicio2.domain.Cliente;
import poo.ejercicioclase.ejercicio2.domain.Pedido;
import poo.ejercicioclase.ejercicio2.enums.EstadoPedido;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PedidoServicioImpl implements PedidoServicio {

    @Override
    public void actualizarPedidoAPagado(Carrito carrito) {
        carrito.getPedido().setEstado(EstadoPedido.PAGADO);

        //TODO Mandar esto a carrito Servicio Impl
        Carrito newCart = new Carrito(carrito.getId() + 1, Main.getCarritoEnCurso().getCliente());
        Main.getCarritoEnCurso().getCliente().setCarrito(newCart);
        Main.setCarritoEnCurso(newCart);
    }

    @Override
    public Pedido crearPedido(Carrito carrito, Long idPedido) {

        Pedido pedido = new Pedido();

        if (Objects.isNull(idPedido)) {
            pedido.setId(1L);
        } else {
            pedido.setId(idPedido + 1);
        }

        pedido.setEstado(EstadoPedido.PENDIENTE);
        pedido.setCliente(carrito.getCliente());
        pedido.setCarrito(carrito);

        return pedido;
    }

    @Override
    public List<Pedido> obtenerPedidos(Cliente cliente) {
        // obtener todos los pedidos del cliente
        List<Pedido> pedidos = cliente.getPedidos();
        return pedidos;
    }

    @Override
    public List<Pedido> obtenerPedidos(Cliente cliente, EstadoPedido ep) {
        // obtener todos los pedidos del cliente segun el estado
        List<Pedido> pedidos = new ArrayList<>();
        for (Pedido p : this.obtenerPedidos(cliente)) {
            if (p.getEstado().equals(ep)) {
                pedidos.add(p);
            }
        }
        return pedidos;
    }

    @Override
    public void listarPedidos(List<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("Lista de pedidos vacia.\n");
            return;
        }

        for (Pedido p : pedidos) {
            System.out.println(String.format("ID[%d] %s | %s", p.getId(), p.getCliente().getNombre(), p.getEstado()));
        }
    }
}
