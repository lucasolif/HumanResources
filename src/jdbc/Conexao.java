
package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexao {
   
    private static BasicDataSource dataSource;

    //Inicializando a conex�o com o banco de dados
    public static boolean inicializandoBancoDados(Configuracao config) {
        
        boolean conectado = false;
        
        if(dataSource == null){
            dataSource = new BasicDataSource();
            dataSource.setUrl("jdbc:sqlserver://"+config.getServidor()+";databaseName="+config.getBancoDados()+";user="+config.getLogin()+";password="+config.getSenha()+";encrypt=true;trustServerCertificate=true");
            dataSource.setUsername(config.getLogin());
            dataSource.setPassword(config.getSenha());

            // Configura��es adicionais do pool
            dataSource.setInitialSize(5); // N�mero inicial de conex�es no pool
            dataSource.setMaxTotal(10);    // N�mero m�ximo de conex�es no pool
            dataSource.setMinIdle(5);      // N�mero m�nimo de conex�es ociosas no pool
            dataSource.setMaxIdle(10);     // N�mero m�ximo de conex�es ociosas no pool
            dataSource.setMaxWaitMillis(10000); // Tempo m�ximo de espera por uma conex�o
        }
        
        // Valida a conex�o com o banco de dados
        try (Connection conn = dataSource.getConnection()) {
            if (conn != null && !conn.isClosed()) {
                conectado = true;
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao tentar estabelecer a conexão com o banco de dados.", "Concluído", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao tentar estabelecer a conexão�o com o banco de dados.", "Concluído�do", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return conectado;

    }

    //Usa a conex�o
    public static synchronized BasicDataSource getDataSource() {
        if (dataSource == null) {
            throw new IllegalStateException("DataSource não foi inicializado.");
        }
        return dataSource;
    }

    //Fecha a conex�o
    public static void closeDataSource() {
        if (dataSource != null) {
            try {
                dataSource.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }    
}
