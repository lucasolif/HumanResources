
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.Conexao;
import model.Usuario;

public class UsuarioDao {
    
    Connection conexao = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void adicionar(Usuario usuario){
             
        try{
            conexao = Conexao.getDataSource().getConnection();
            
            String sql= "INSERT INTO Usuarios (Nome,Email,Celular,Usuario,DataCadastro,Ativo,HashSenha,SaltSenha)VALUES (?,?,?,?,GETDATE(),?,?,?)";
            ps = conexao.prepareStatement(sql);
            ps.setString(1,usuario.getNome());
            ps.setString(2,usuario.getEmail());
            ps.setString(3,usuario.getCelular());
            ps.setString(4,usuario.getLogin());
            ps.setInt(5,usuario.getAtivo()); 
            ps.setString(6,usuario.getHashSenha());
            ps.setString(7,usuario.getSaltSenha());
            ps.execute();
            
            JOptionPane.showMessageDialog(null, "Usuário cadastrada com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar o usuário", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }

    }
    
    public  void alterar(Usuario usuario){
             
        try{                        
            String sql= "UPDATE Usuarios SET Email=?,Celular=?,Ativo=?" + " WHERE Codigo=?";
            
            conexao = Conexao.getDataSource().getConnection(); 
            ps = conexao.prepareStatement(sql);

            ps.setString(1,usuario.getEmail());
            ps.setString(2,usuario.getCelular());
            ps.setInt(3,usuario.getAtivo());
            ps.setInt(4,usuario.getCodigo());
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar o usuário", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }   
    } 
    
    public  List<Usuario> consultar(String usuario){

        String sql = null;
        List<Usuario> listaUsuarios = new ArrayList<>();

        sql = "SELECT * FROM Usuarios "
        + "WHERE (? IS NULL OR Codigo LIKE ?) OR (? IS NULL OR Nome LIKE ?)";
    
        try{
            conexao = Conexao.getDataSource().getConnection();            
            ps = conexao.prepareStatement(sql);
            
            if (usuario != null) {
                ps.setString(1,  "%" + usuario + "%");
                ps.setString(2,  "%" + usuario + "%");
                ps.setString(3,  "%" + usuario + "%");
                ps.setString(4,  "%" + usuario + "%");                
            } else {
                ps.setNull(1, java.sql.Types.INTEGER);
                ps.setNull(2, java.sql.Types.INTEGER);
                ps.setNull(3, java.sql.Types.INTEGER);
                ps.setNull(4, java.sql.Types.INTEGER);                
            }
            
            rs = ps.executeQuery();

            while(rs.next()){
                Usuario user = new Usuario();

                user.setCodigo(rs.getInt("Codigo"));
                user.setNome(rs.getString("Nome"));
                user.setEmail(rs.getString("Email"));
                user.setCelular(rs.getString("Celular"));
                user.setLogin(rs.getString("Usuario"));
                user.setAtivo(rs.getInt("Ativo"));

                listaUsuarios.add(user);
            }
            
            ps.execute();
            
        }catch(SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar o usuário", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }

        return listaUsuarios;
    }
    
    public void remover(int usuario){
        
        String sql = "DELETE FROM Usuarios WHERE Codigo=?";
        
        try{
            conexao = Conexao.getDataSource().getConnection();
            ps = conexao.prepareStatement(sql);
    
            ps.setInt(1, usuario);
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir o Usuário", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

}
