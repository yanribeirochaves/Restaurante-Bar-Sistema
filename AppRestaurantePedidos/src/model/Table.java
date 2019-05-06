package model;

/**
 * @author yanri
 */
public class Table {
    private int idTable;
    private boolean statusTable;
    private boolean statusWaitingOrder;

    public int getIdTable() {
        return idTable;
    }

    public void setIdTable(int idTable) {
        this.idTable = idTable;
    }

    public boolean isStatusTable() {
        return statusTable;
    }

    public void setStatusTable(boolean statusTable) {
        this.statusTable = statusTable;
    }
    
    public boolean isStatusWaitingOrder() {
        return statusWaitingOrder;
    }

    public void setStatusWaitingOrder(boolean statusWaitingOrder) {
        this.statusWaitingOrder = statusWaitingOrder;
    }
    
    public String getStatusTable(){
        if(isStatusTable()){
            return "Mesa ocupada";
        }
        else{
            return "Mesa aberta";
        }
    }
    
    public String getStatusWaitingOrder(){
        if(isStatusWaitingOrder()){
            return "Aguardando Entrega de Pedido";
        }
        else{
            return "Nenhum pedido na fila";
        }
    }
    @Override
    public String toString(){
        return getIdTable() + "";
    }
}
