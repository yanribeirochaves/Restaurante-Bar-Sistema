
package controller;

import controller.helper.HelperListaPedidos;
import view.ListaPedidos;
import view.MenuPrincipal;

/**
 * @author yanri
 */
public class ControllerListaPedidos {
    private final HelperListaPedidos helper;
    
    public ControllerListaPedidos(ListaPedidos view) {
        helper = new HelperListaPedidos(view);
    }

    public void voltarMenuPrincipal() {
        MenuPrincipal viewMenuPrincipal = new MenuPrincipal();
        viewMenuPrincipal.setVisible(true);
        helper.exit();
    }
    
    
}
