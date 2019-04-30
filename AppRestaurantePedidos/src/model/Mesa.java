package model;

/**
 * @author yanri
 */
public class Mesa {
    private int idMesa;
    private boolean statusMesa;

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public boolean isStatusMesa() {
        return statusMesa;
    }

    public void setStatusMesa(boolean statusMesa) {
        this.statusMesa = statusMesa;
    }
    
    @Override
    public String toString(){
        return getIdMesa() + "";
    }
}
