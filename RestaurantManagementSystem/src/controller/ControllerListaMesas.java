package controller;

import controller.helper.HelperListaMesas;
import view.ListaMesas;
import view.MenuPrincipal;

/**
 * @author yanri
 */
public class ControllerListaMesas {

    private final HelperListaMesas helper;
    public ControllerListaMesas(ListaMesas view) {
        helper = new HelperListaMesas(view);
    }
    
    public void voltaMenuPrincipa(){
        MenuPrincipal viewMenuPrincipal = new MenuPrincipal();
        viewMenuPrincipal.setVisible(true);
        helper.exit();
        
    }
    
}
