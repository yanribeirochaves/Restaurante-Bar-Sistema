package model;

/**
 * @author yanri
 */
public class User {
    private int id;
    private String username;
    private String key;
    private int idTable;
    private int idAccesLevel;//verifica no banco os ids correspondentes ao nivel de acesso

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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getIdTable() {
        return idTable;
    }

    public void setIdTable(int idTable) {
        this.idTable = idTable;
    }

    public int getIdAccesLevel() {
        return idAccesLevel;
    }

    public void setIdAccesLevel(int idAccesLevel) {
        this.idAccesLevel = idAccesLevel;
    }
    
    
}
