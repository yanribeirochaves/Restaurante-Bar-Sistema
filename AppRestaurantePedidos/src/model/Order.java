package model;

/**
 * @author yanri
 */

//cada pedido representa um product, mesmo estando em quantity maior que um.
//caso um cliente peça 2 produtos de uma vez, será criado uma lista de pedidos na classe controle da tela do cliente
public class Order {
    private int idOrder;
    private Product product;
    private int quantity;
    private String observation;
    private int idTable;
    private boolean statusOrder;

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public int getIdTable() {
        return idTable;
    }

    public void setIdTable(int idTable) {
        this.idTable = idTable;
    }

    public boolean isStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(boolean statusOrder) {
        this.statusOrder = statusOrder;
    }
    
    @Override
    public String toString(){
        if(isStatusOrder()){
            return "Pedido entregado";
        }
        else{
            return "Pedido pendente";
        }
    }
}
