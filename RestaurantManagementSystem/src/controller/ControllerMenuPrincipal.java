package controller;
import view.ListaMesas;
import view.ListaPedidos;
import view.MenuPrincipal;

/**
 * @author yanri
 */
public class ControllerMenuPrincipal {
    private final MenuPrincipal view;
        
    public ControllerMenuPrincipal(MenuPrincipal view) {
        this.view = view;
    }

    public void abrirTelaPedidos() {
        ListaPedidos viewPedidos = new ListaPedidos();
        viewPedidos.setVisible(true);
        view.dispose();
    }

    public void abrirTelaMesas() {
        ListaMesas viewMesas = new ListaMesas();
        viewMesas.setVisible(true);
        view.dispose();
    }
    
}
