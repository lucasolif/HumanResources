package view;

import javax.swing.JFrame;
import jdbc.Conexao;
import view.cadastros.PessoasForm;
import view.calculadoras.CalculadoraDiariaForm;


public class Home extends javax.swing.JFrame {
    
    public Home() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelHome = new javax.swing.JDesktopPane();
        menuBarra = new javax.swing.JMenuBar();
        cadastros = new javax.swing.JMenu();
        pessoasEmpresa = new javax.swing.JMenuItem();
        financeiro = new javax.swing.JMenu();
        relatorios = new javax.swing.JMenu();
        ferramentas = new javax.swing.JMenu();
        calculadoras = new javax.swing.JMenu();
        calculadoraDiarias = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1366, 768));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setName("Home"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        painelHome.setBackground(new java.awt.Color(204, 204, 204));
        painelHome.setAutoscrolls(true);

        javax.swing.GroupLayout painelHomeLayout = new javax.swing.GroupLayout(painelHome);
        painelHome.setLayout(painelHomeLayout);
        painelHomeLayout.setHorizontalGroup(
            painelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        painelHomeLayout.setVerticalGroup(
            painelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        menuBarra.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        menuBarra.setName(""); // NOI18N

        cadastros.setText("Cadastros");

        pessoasEmpresa.setText("Pessoas/Empresas");
        pessoasEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pessoasEmpresaActionPerformed(evt);
            }
        });
        cadastros.add(pessoasEmpresa);

        menuBarra.add(cadastros);

        financeiro.setText("Financeiro");
        financeiro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuBarra.add(financeiro);

        relatorios.setText("Relatórios");
        menuBarra.add(relatorios);

        ferramentas.setText("Ferramentas");

        calculadoras.setText("Calculadoras");

        calculadoraDiarias.setText("Calculadora Diárias");
        calculadoraDiarias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculadoraDiariasActionPerformed(evt);
            }
        });
        calculadoras.add(calculadoraDiarias);

        ferramentas.add(calculadoras);

        menuBarra.add(ferramentas);

        setJMenuBar(menuBarra);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelHome)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelHome)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        //Fechar as conexões quando o programa for fechado
        Conexao conexao = new Conexao();
        conexao.closeDataSource();
    }//GEN-LAST:event_formWindowClosed

    private void calculadoraDiariasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculadoraDiariasActionPerformed
        CalculadoraDiariaForm calcDiaria = new CalculadoraDiariaForm();
        painelHome.add(calcDiaria);
        calcDiaria.setVisible(true);
        calcDiaria.setPosicao(); //Chama função para centraliza a tela, quando ela for aberta
    }//GEN-LAST:event_calculadoraDiariasActionPerformed

    private void pessoasEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pessoasEmpresaActionPerformed
        PessoasForm pessoaForm = new PessoasForm();
        painelHome.add(pessoaForm);
        pessoaForm.setVisible(true);
        pessoaForm.setPosicao(); //Chama função para centraliza a tela, quando ela for aberta
    }//GEN-LAST:event_pessoasEmpresaActionPerformed
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu cadastros;
    private javax.swing.JMenuItem calculadoraDiarias;
    private javax.swing.JMenu calculadoras;
    private javax.swing.JMenu ferramentas;
    private javax.swing.JMenu financeiro;
    private javax.swing.JMenuBar menuBarra;
    public javax.swing.JDesktopPane painelHome;
    private javax.swing.JMenuItem pessoasEmpresa;
    private javax.swing.JMenu relatorios;
    // End of variables declaration//GEN-END:variables
}
