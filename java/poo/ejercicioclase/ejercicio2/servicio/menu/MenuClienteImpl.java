package poo.ejercicioclase.ejercicio2.servicio.menu;

import poo.ejercicioclase.ejercicio2.entrada.InputConsoleService;
import poo.ejercicioclase.ejercicio2.enums.EstadoPedido;

import java.lang.reflect.Array;

public class MenuClienteImpl implements MenuCliente {
    @Override
    public EstadoPedido obtenerNombreEstadoPedido() {
        EstadoPedido ep;
        System.out.print("Estado del pedido:\n1. PENDIENTE.\n2. PAGADO.\n.3. ENVIADO.\n4. ENTREGADO.\n");
        System.out.print("opcion: ");
        int opcion = 0;

        boolean ok = Boolean.TRUE;
        do {
            try {
                System.out.print("Estado del pedido:\n1. PENDIENTE.\n2. PAGADO.\n3. ENVIADO.\n4. ENTREGADO.\n0. TODOS.\n");
                System.out.print("opcion: ");
                opcion = Integer.parseInt(InputConsoleService.getScanner().nextLine());
                ok = Boolean.FALSE;
            } catch (NumberFormatException e) {
                System.out.println("\nValor ingresado invalido.");
            }
        } while (ok);

        switch (opcion) {
            case 1:
                ep = EstadoPedido.PENDIENTE;
                break;
            case 2:
                ep = EstadoPedido.PAGADO;
                break;
            case 3:
                ep = EstadoPedido.ENVIADO;
                break;
            case 4:
                ep = EstadoPedido.ENTREGADO;
            default:
                ep = null;
                break;
        }
        return ep;
    }
}
