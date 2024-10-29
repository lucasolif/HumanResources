
package dao;

import jdbc.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Pessoa;
import model.Endereco;
import model.TipoCadastro;
import view.ferramentas.Ferramentas;

public class PessoaDao {
    private Ferramentas conversor = new Ferramentas();
    private Connection conexao = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    //Método para adicionar pessoa
    public void adicionar(Pessoa pessoa){

        try{
            conexao = Conexao.getDataSource().getConnection();
            
            String sql = "INSERT INTO Pessoas (NomeRazao,NomeFantasia,CPFCNPJ,InscricaoEstadual,InscricaoMunicipal,TipoCadastro,Sexo,Celular,Telefone,Email,Logradouro,Numero,Bairro,Cidade,Estado,CEP,Complemento,DataCadastro,Ativo)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,GETDATE(),?)";
            ps = conexao.prepareStatement(sql);

            ps.setString(1, pessoa.getNomeRazaoSocial());
            ps.setString(2, pessoa.getNomeFantasia());
            ps.setString(3, pessoa.getCpfCnpj());
            ps.setObject(4, pessoa.getInscricaoEstadual());
            ps.setObject(5, pessoa.getInscricaoMunicipal());
            ps.setInt(6, pessoa.getTipoCadastro().getCodigo());
            ps.setObject(7, pessoa.getSexo());
            ps.setString(8, pessoa.getCelular());
            ps.setObject(9, pessoa.getTelefone());
            ps.setString(10, pessoa.getEmail());
            ps.setString(11, pessoa.getEndereco().getLogradouro());
            ps.setInt(12, pessoa.getEndereco().getNumero());
            ps.setString(13, pessoa.getEndereco().getBairro());
            ps.setString(14, pessoa.getEndereco().getCidade());
            ps.setString(15, pessoa.getEndereco().getEstado());
            ps.setString(16, pessoa.getEndereco().getCep());
            ps.setString(17, pessoa.getEndereco().getComplemento());
            ps.setInt(18, pessoa.getAtivo());
            ps.execute();
           
            JOptionPane.showMessageDialog(null, "Pessoa cadastrada com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch (SQLException ex) {
            //Se ocorrer um erro, fazer rollback da transa��o
            if(conexao != null){
                try{
                    conexao.rollback();
                }catch(SQLException e){
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erro ao tentar efetuar o rollback", "Erro 013", JOptionPane.ERROR_MESSAGE);
                }
            }
            
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar a pessoa", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conex�o com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }

    }
    
    //Método para consultar pessoa e listar na tabela
    public List<Pessoa> consultar(String busca){

        String sql = null;
        List<Pessoa> listaPessoas = new ArrayList<>();

        sql = "SELECT TP.Descricao AS NomeTipoCadastro, * From Pessoas AS P "
        + "INNER JOIN TipoCadastro As TP On TP.Codigo = P.TipoCadastro "
        + "WHERE (? IS NULL OR Codigo LIKE ?) OR (? IS NULL OR NomeRazao LIKE ?) OR (? IS NULL OR NomeFantasia LIKE ?)";
        
        try{
            conexao = Conexao.getDataSource().getConnection();            
            ps = conexao.prepareStatement(sql);
            
            if (busca != null) {
                ps.setString(1,  "%" + busca + "%");
                ps.setString(2,  "%" + busca + "%");
                ps.setString(3,  "%" + busca + "%");
                ps.setString(4,  "%" + busca + "%");
                ps.setString(5,  "%" + busca + "%");
                ps.setString(6,  "%" + busca + "%");
            } else {
                ps.setNull(1, java.sql.Types.INTEGER);
                ps.setNull(2, java.sql.Types.INTEGER);
                ps.setNull(3, java.sql.Types.INTEGER);
                ps.setNull(4, java.sql.Types.INTEGER);
                ps.setNull(5, java.sql.Types.INTEGER);
                ps.setNull(6, java.sql.Types.INTEGER);
            }

            rs = ps.executeQuery();

            while(rs.next()){
                Pessoa pessoa = new Pessoa();
                Endereco endereco = new Endereco();
                TipoCadastro tpCadastro = new TipoCadastro();
                tpCadastro.setCodigo(rs.getInt("TipoCadastro"));
                tpCadastro.setDescricao(rs.getString("NomeTipoCadastro"));              
                pessoa.setTipoCadastro(tpCadastro);
                pessoa.setCodPessoa(rs.getInt("Codigo"));
                pessoa.setNomeRazaoSocial(rs.getString("NomeRazao"));
                pessoa.setNomeFantasia(rs.getString("NomeFantasia"));
                pessoa.setCpfCnpj(rs.getString("CPFCNPJ"));
                pessoa.setInscricaoEstadual(rs.getString("InscricaoEstadual"));
                pessoa.setInscricaoMunicipal(rs.getString("InscricaoMunicipal"));
                pessoa.setSexo(rs.getString("Sexo"));
                pessoa.setCelular(rs.getString("Celular"));
                pessoa.setTelefone(rs.getString("Telefone"));
                pessoa.setEmail(rs.getString("Email"));
                endereco.setLogradouro(rs.getString("Logradouro"));
                endereco.setNumero(rs.getInt("Numero"));
                endereco.setBairro(rs.getString("Bairro"));
                endereco.setCidade(rs.getString("Cidade"));
                endereco.setEstado(rs.getString("Estado"));
                endereco.setCep(rs.getString("CEP"));
                endereco.setComplemento(rs.getString("Complemento"));
                pessoa.setAtivo(rs.getInt("Ativo"));
                pessoa.setEndereco(endereco);
                
                listaPessoas.add(pessoa);
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar a conta de resultado", "Erro 001", JOptionPane.ERROR_MESSAGE);
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

        return listaPessoas;  
    }
    
    //Alterar o cadastro das pessoas
    public void alterar(Pessoa pessoa){

        try{ 
            conexao = Conexao.getDataSource().getConnection();
            
            String sql = "UPDATE Pessoas SET NomeRazao=?,NomeFantasia=?,CPFCNPJ=?,InscricaoEstadual=?,InscricaoMunicipal=?,TipoCadastro=?,Sexo=?,Celular=?,Telefone=?,Email=?,Logradouro=?,Numero=?,Bairro=?,Cidade=?,Estado=?,CEP=?,Complemento=?,Ativo=?" + " WHERE Codigo=?";
            ps = conexao.prepareStatement(sql);
            
            ps.setString(1, pessoa.getNomeRazaoSocial());
            ps.setString(2, pessoa.getNomeFantasia());
            ps.setString(3, pessoa.getCpfCnpj());
            ps.setString(4, pessoa.getInscricaoEstadual());
            ps.setString(5, pessoa.getInscricaoMunicipal());
            ps.setInt(6, pessoa.getTipoCadastro().getCodigo());
            ps.setString(7, pessoa.getSexo());
            ps.setString(8, pessoa.getCelular());
            ps.setString(9, pessoa.getTelefone());
            ps.setString(10, pessoa.getEmail());
            ps.setString(11, pessoa.getEndereco().getLogradouro());
            ps.setInt(12, pessoa.getEndereco().getNumero());
            ps.setString(13, pessoa.getEndereco().getBairro());
            ps.setString(14, pessoa.getEndereco().getCidade());
            ps.setString(15, pessoa.getEndereco().getEstado());
            ps.setString(16, pessoa.getEndereco().getCep());
            ps.setString(17, pessoa.getEndereco().getComplemento());
            ps.setInt(18, pessoa.getAtivo());
            ps.setInt(19, pessoa.getCodPessoa());
            ps.executeUpdate();
 
            JOptionPane.showMessageDialog(null, "Pessoa "+pessoa.getNomeFantasia()+" alterado com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch (SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao alterar a pessoa "+pessoa.getNomeFantasia(), "Erro 001", JOptionPane.ERROR_MESSAGE);
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
    
    //Remover o cadastro das pessoas
    public void remover(Integer codigo){

        try{       
            conexao = Conexao.getDataSource().getConnection();
            
            String sql = "DELETE FROM Pessoas WHERE Codigo=?";
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.executeUpdate();
           
            JOptionPane.showMessageDialog(null, "Pessoa excluída com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir o cadastro da pessoa "+codigo, "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conex�o com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public List<TipoCadastro> tpCadastro(){
        
        String sql = "SELECT * FROM TipoCadastro";  
        List<TipoCadastro> listTpCadastro = new ArrayList<>();
 
        try{
            conexao = Conexao.getDataSource().getConnection();
            
            ps = conexao.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()){
                TipoCadastro tpCadastro = new TipoCadastro();
                tpCadastro.setCodigo(rs.getInt("Codigo"));
                tpCadastro.setDescricao(rs.getString("Descricao"));

                listTpCadastro.add(tpCadastro);
            }

            ps.execute();
          
        }catch(SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar carregar os tipos de cadastro", "Erro 001", JOptionPane.ERROR_MESSAGE);
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

        return listTpCadastro;
    }
    
}
