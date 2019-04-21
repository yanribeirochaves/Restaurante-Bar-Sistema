package controller.helper;

import view.ListaMesas;

/**
 * @author yanri
 */
public class HelperListaMesas {

    private final ListaMesas view;
    public HelperListaMesas(ListaMesas view) {
        this.view = view;
    }
    
    public void exit(){
        view.dispose();
    }
    
}
