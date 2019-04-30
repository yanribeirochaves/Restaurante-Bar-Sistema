package controller.helper;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Mesa;
import model.Usuario;
import view.MenuGarcom;

/**
 * @author yanri
 */
public class HelperMenuGarcom {

    MenuGarcom view;
    public HelperMenuGarcom(MenuGarcom view) {
        this.view = view;
    }

    public void mensagemBox(String mensagem, String titulo, int tipo) {
        JOptionPane.showMessageDialog(null, mensagem ,titulo,tipo);
    }
    
    //recebe a lista de mesas e carrega no comboBox
    public void carregaMesas(ArrayList<Mesa> listaMesas) {
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel)view.getcBoxMesa().getModel();
        for(Mesa mesa : listaMesas){
            comboBoxModel.addElement(mesa);
        }
    }
    
    public Usuario getUsuario(){
        Usuario usuario = new Usuario();
        usuario.setIdMesa(Integer.parseInt(view.getcBoxMesa().getSelectedItem().toString()));
        usuario.setUsername(view.getTxtUsername());
        usuario.setSenha(view.getTxtSenha());
        usuario.setIdNivelAcesso(3);//nivel de acesso de cliente é 3 no banco
        return usuario;
    }

    public void preencherTabela(ArrayList<Mesa> listaMesas) {
        DefaultTableModel modeloTabela = (DefaultTableModel) view.getTblMesas().getModel();
        modeloTabela.setNumRows(0);
        
        for(Mesa mesa : listaMesas){
            modeloTabela.addRow(new Object[]{
            
            
            
            });
        }
        
    }
    
}
