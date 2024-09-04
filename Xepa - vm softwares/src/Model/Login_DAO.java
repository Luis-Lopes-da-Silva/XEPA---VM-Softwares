
package Model;

import View.Menu_GUI;
import javax.swing.JOptionPane;


public class Login_DAO {
    public static String sen = "12345";
    public static String usu = "funcionario";
    
    public static String campoU = View.Login_GUI.usuario.getText();
    public static String campoS = View.Login_GUI.senha.getText();
    
    
    public static void entrar_funcao(){
       
        JOptionPane.showMessageDialog(null, "Nome de usuario e senha corretos, abrindo sistema...");
        new Menu_GUI().setVisible(true);
    }
}
