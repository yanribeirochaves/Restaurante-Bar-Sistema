package model;

import java.util.ArrayList;

/**
 * @author yanri
 */
public class Mesa {
    
   private int idMesa;
   private String nomeClientePrincipal;
   private String rgClientePrincipal;
   private boolean statusMesa;//true para mesa aberta e false para fechada
   private ArrayList<Pedido> listaPedidos;
   
   public void Mesa(int idMesa, String nomeClientePrincipal, String rgClientePrincipal, ArrayList<Pedido> listaPedidos){
       this.idMesa = idMesa;
       this.nomeClientePrincipal = nomeClientePrincipal;
       this.rgClientePrincipal = rgClientePrincipal;
       this.listaPedidos = listaPedidos;
    }
   
   public void Mesa(int idMesa, String nomeClientePrincipal, String rgClientePrincipal){
       this.idMesa = idMesa;
       this.nomeClientePrincipal = nomeClientePrincipal;
       this.rgClientePrincipal = rgClientePrincipal;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public String getNomeClientePrincipal() {
        return nomeClientePrincipal;
    }

    public String getRgClientePrincipal() {
        return rgClientePrincipal;
    }

    public ArrayList<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public void setNomeClientePrincipal(String nomeClientePrincipal) {
        this.nomeClientePrincipal = nomeClientePrincipal;
    }

    public void setRgClientePrincipal(String rgClientePrincipal) {
        this.rgClientePrincipal = rgClientePrincipal;
    }

    public void setListaPedidos(ArrayList<Pedido> listaPedidos) {
        for (Pedido pedido : listaPedidos){
            this.listaPedidos.add(pedido);
        }    
    }
    public void setListaPedidos(Pedido pedido) {
        this.listaPedidos.add(pedido);  
    }

    public boolean isStatusMesa() {
        return statusMesa;
    }

    public void setStatusMesa(boolean statusMesa) {
        this.statusMesa = statusMesa;
    }
    
}
