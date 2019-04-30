package model;

/**
 * @author yanri
 */

//cada pedido representa um produto, mesmo estando em quantidade maior que um.
//caso um cliente peça 2 produtos de uma vez, necessário criar uma lista de pedidos na determinada classe
public class Pedido {
    private int idPedido;
    private Produto produto;
    private int quantidade;
    private String observacao;
    private int idMesa;
    private boolean statusPedido;

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public boolean isStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(boolean statusPedido) {
        this.statusPedido = statusPedido;
    }
    
}
