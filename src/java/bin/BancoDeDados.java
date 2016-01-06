package bin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @author bruno.souza
 */
public class BancoDeDados {
    
    public static final String HOST = "localhost";
    public static final String BASE = "financas";
    public static final String USER = "root";
    public static final String PASS = "senior";
    
    public static Connection getConnection()
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://" + HOST + "/" + BASE, USER, PASS);
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(BancoDeDados.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex, "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
