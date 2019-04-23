package model;

/**
 * @author yanri
 */
public class Usuario {
    private int id;
    private String username;
    private String senha;
    private int idMesa;
    private int idNivelAcesso;//verifica no banco os ids correspondentes ao nivel de acesso

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public int getIdNivelAcesso() {
        return idNivelAcesso;
    }

    public void setIdNivelAcesso(int idNivelAcesso) {
        this.idNivelAcesso = idNivelAcesso;
    }
    
    
}
