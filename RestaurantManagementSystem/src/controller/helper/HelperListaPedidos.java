
package controller.helper;

import view.ListaPedidos;

/**
 * @author yanri
 */
public class HelperListaPedidos {
    private final ListaPedidos view;

    public HelperListaPedidos(ListaPedidos view) {
        this.view = view;
    }

    public void exit() {
        view.dispose();
    }
    
}
