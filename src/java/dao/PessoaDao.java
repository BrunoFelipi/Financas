package dao;
import bin.BancoDeDados;
import ent.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bruno.souza
 */
public class PessoaDao implements Dao <Pessoa> {

    Connection bd = BancoDeDados.getConnection();
    
    public void insert(Pessoa t) throws Exception {
        PreparedStatement ps = bd.prepareStatement("INSERT INTO pessoa VALUES (0,?,?)");
        ps.setObject(1, t.getNome());
        ps.setObject(2, t.getSenha());
        ps.execute();
    }

    public void update(Pessoa t) throws Exception {
        PreparedStatement ps = bd.prepareStatement("UPDATE pessoa SET nome = ?, senha = ? WHERE id = ?");
        ps.setObject(1, t.getNome());
        ps.setObject(2, t.getSenha());
        ps.setObject(3, t.getId());
        ps.execute();
    }

    public List<Pessoa> select() throws Exception {
        PreparedStatement ps = bd.prepareStatement("SELECT * FROM pessoa");
        ResultSet rs = ps.executeQuery();
        ArrayList<Pessoa> lista = new ArrayList<>();
        while(rs.next())
        {
             lista.add(new Pessoa(rs.getInt(1), rs.getString(2), rs.getString(3)));
        }
        return lista;
    }

    public List<Pessoa> selectWhere(String campo, String valor) throws Exception {
        PreparedStatement ps = bd.prepareStatement("SELECT * FROM pessoa WHERE " + campo + " = ?");
        ps.setObject(1, valor);
        ResultSet rs = ps.executeQuery();
        ArrayList<Pessoa> lista = new ArrayList<>();
        while(rs.next())
        {
             lista.add(new Pessoa(rs.getInt(1), rs.getString(2), rs.getString(3)));
        }
        return lista;
    }
  
}