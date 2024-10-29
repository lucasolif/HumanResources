
package view.calculadoras;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import view.ferramentas.Ferramentas;


public class CalculadoraDiariaForm extends javax.swing.JInternalFrame {

    Ferramentas ferramentas = new Ferramentas();

    public CalculadoraDiariaForm() {
        initComponents();
        dataDiaria.setText(ferramentas.dataAtualString());
        definirValorHoraExtra();
        //setIconImage(new ImageIcon("C:\\Users\\Lucas Oliveira\\Documents\\Projetos\\CalcDeily\\src\\img/cifrao.png").getImage());
    }
    
    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        totalDiasTrabalhados = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        horasTrabalhadas = new javax.swing.JTextField();
        totalPagarDiaria = new javax.swing.JTextField();
        totalPagarMensal = new javax.swing.JTextField();
        btnLimpar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        dataDiaria = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        btnOk = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaValores = new javax.swing.JTable();
        valorHoraExtra = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        valorHora = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        SaidaAlmoço = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        RetornoAlmoco = new javax.swing.JFormattedTextField();
        SaidaServico = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        EntradaServico = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Calculadora de Diárias");

        totalDiasTrabalhados.setEditable(false);
        totalDiasTrabalhados.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        totalDiasTrabalhados.setForeground(new java.awt.Color(0, 0, 255));
        totalDiasTrabalhados.setText("0");

        jLabel12.setText("Total Pagar:");

        horasTrabalhadas.setEditable(false);
        horasTrabalhadas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        totalPagarDiaria.setEditable(false);
        totalPagarDiaria.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        totalPagarMensal.setEditable(false);
        totalPagarMensal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        totalPagarMensal.setForeground(new java.awt.Color(0, 0, 255));
        totalPagarMensal.setText("0.00");

        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-atualizar-16.png"))); // NOI18N
        btnLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-lixeira-16.png"))); // NOI18N
        btnExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        try {
            dataDiaria.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        dataDiaria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dataDiariaKeyPressed(evt);
            }
        });

        jLabel5.setText("Data Diária");

        btnOk.setBackground(new java.awt.Color(0, 204, 0));
        btnOk.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnOk.setText("OK");
        btnOk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        jLabel6.setText("Hrs. Trabalhadas");

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Diárias", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tabelaValores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data Diária", "Dia Semana", "Total Horas Diaria", "Valor Pagar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaValores);
        if (tabelaValores.getColumnModel().getColumnCount() > 0) {
            tabelaValores.getColumnModel().getColumn(0).setResizable(false);
            tabelaValores.getColumnModel().getColumn(0).setPreferredWidth(80);
            tabelaValores.getColumnModel().getColumn(1).setResizable(false);
            tabelaValores.getColumnModel().getColumn(1).setPreferredWidth(300);
            tabelaValores.getColumnModel().getColumn(2).setResizable(false);
            tabelaValores.getColumnModel().getColumn(2).setPreferredWidth(50);
            tabelaValores.getColumnModel().getColumn(3).setResizable(false);
            tabelaValores.getColumnModel().getColumn(3).setPreferredWidth(50);
        }

        valorHoraExtra.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        jLabel7.setText("Valor Hora (R$)");

        valorHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        valorHora.setText("10,00");
        valorHora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                valorHoraKeyPressed(evt);
            }
        });

        jLabel8.setText("Val Hora Extra (R$)");

        try {
            SaidaAlmoço.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel1.setText("Saída");

        jLabel2.setText("Entrada");

        try {
            RetornoAlmoco.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            SaidaServico.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        SaidaServico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SaidaServicoKeyPressed(evt);
            }
        });

        jLabel3.setText("Entrada");

        jLabel4.setText("Saída");

        try {
            EntradaServico.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel9.setText("Total Diária (R$)");

        jLabel10.setText("Total Dias:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(EntradaServico, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(SaidaAlmoço, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(RetornoAlmoco, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(SaidaServico, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(horasTrabalhadas, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(totalPagarDiaria, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOk))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dataDiaria, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(valorHora, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(45, 45, 45)
                                .addComponent(jLabel7)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(valorHoraExtra))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalDiasTrabalhados, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalPagarMensal, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataDiaria, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valorHoraExtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valorHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EntradaServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SaidaAlmoço, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RetornoAlmoco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnOk)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SaidaServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(horasTrabalhadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(totalPagarDiaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9))
                        .addGap(28, 28, 28)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLimpar)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(totalDiasTrabalhados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)
                        .addComponent(totalPagarMensal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparTabela();
        limparFormulário();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        removerDiaria();
        atualizarTotalizadores();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void dataDiariaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dataDiariaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB){
            definirValorHoraExtra();
        }
    }//GEN-LAST:event_dataDiariaKeyPressed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        adicionarDiarias();
        this.EntradaServico.setText("");
        this.SaidaAlmoço.setText("");
        this.RetornoAlmoco.setText("");
        this.SaidaServico.setText("");
        this.horasTrabalhadas.setText("");
        this.totalPagarDiaria.setText("");
        atualizarTotalizadores();
    }//GEN-LAST:event_btnOkActionPerformed

    private void valorHoraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorHoraKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB){
            definirValorHoraExtra();
        }
    }//GEN-LAST:event_valorHoraKeyPressed

    private void SaidaServicoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SaidaServicoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB){
            calcularTotalHorasTrabalhadas();
            calcularValorDiaria();
        }
    }//GEN-LAST:event_SaidaServicoKeyPressed

    public void calcularTotalHorasTrabalhadas(){
        
        LocalTime horaInici = ferramentas.convertendoStringHora(this.EntradaServico.getText());
        LocalTime saidaAlmoco = ferramentas.convertendoStringHora(this.SaidaAlmoço.getText());
        LocalTime retornoAlmoco = ferramentas.convertendoStringHora(this.RetornoAlmoco.getText());
        LocalTime horaSaida = ferramentas.convertendoStringHora(this.SaidaServico.getText());
        
        try {
            
            //Subtraindo as horas da manhã
            long horasTrabalhadaManha = java.time.Duration.between(horaInici, saidaAlmoco).toMinutes();
            
            //Subtraindo as horas da manhã
            long horasTrabalhadaTarde = java.time.Duration.between(retornoAlmoco, horaSaida).toMinutes();
            
            //Somando o total de horas trabalhadas no dia
            long totalHrsTrabalhada = horasTrabalhadaManha + horasTrabalhadaTarde;
            
            //Total de horas e minutos trabalhados.
            long horasTrabalhada = totalHrsTrabalhada / 60;
            long minutosTrabalhado = totalHrsTrabalhada % 60;
            
            //Formatando o total de horas, addvindo dos cálculso acima
            String totalHorasFormatada = ferramentas.convertendoHoraString(LocalTime.of((int) horasTrabalhada, (int) minutosTrabalhado));
            
            //Setando o total de horas e minutos trabalhados
            this.horasTrabalhadas.setText(totalHorasFormatada);

        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar calcular as horas trabalhadas, verifique os dados e tente novamente", "Erro 02", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
    
    public void calcularValorDiaria(){
        
        double valHora = Double.parseDouble(this.valorHora.getText().replace(",", "."));
        double valHoraExtra = Double.parseDouble(this.valorHoraExtra.getText().replace(",", "."));
        double valorPagoMin = valHora/60;
        double valorPagoMinExtra = valHoraExtra/60;
        double valorTotalDiaria = 0;
        
        //Converter a string em horas
        LocalTime totalHorasTrabalhada = ferramentas.convertendoStringHora(this.horasTrabalhadas.getText());       
        //Transforma a hora em minutos
        int minTrabalhado = ferramentas.converterHorasMinutos(totalHorasTrabalhada);
        
        if(minTrabalhado <= 480){
            //Calcular o valor total a pagar
            double valorDiaria = minTrabalhado * valorPagoMin;
            valorTotalDiaria = valorDiaria;
        }else{               
            int tempoExtra = minTrabalhado - 480; //Calcular o tempo extra
            int tempoDiaria = minTrabalhado - tempoExtra; //Calcular o tempo da diaria           
            
            double valorDiaria = tempoDiaria * valorPagoMin;
            double valorHoraExtra = tempoExtra * valorPagoMinExtra;
            
            valorTotalDiaria = valorDiaria + valorHoraExtra;
        }
        
        this.totalPagarDiaria.setText(String.format("%.2f", valorTotalDiaria));
        //Double.toString(valorTotalDiaria)
    }
    
    public void adicionarDiarias(){
        String dataDiaria = this.dataDiaria.getText();
        String horasTraba = this.horasTrabalhadas.getText();
        String totalDiaria = this.totalPagarDiaria.getText();
        String diaSemana = ferramentas.diaSemana(dataDiaria).toUpperCase();
        
        DefaultTableModel model = (DefaultTableModel) tabelaValores.getModel();
        model.addRow(new Object[]{dataDiaria,diaSemana, horasTraba, totalDiaria});
    }
    
    public void atualizarTotalizadores(){
        double totalPagar = 0;        
        int qtdLinhasTabela = tabelaValores.getRowCount();
        
        for(int i = 0; i < qtdLinhasTabela; i++){   
            String valorDiaria = (String) tabelaValores.getModel().getValueAt(i, 3); //Converte o valor da tabela para String
            double totalDiaria = Double.parseDouble(valorDiaria.replace(",", ".")); //Converte a String para um valor Double
            totalPagar += totalDiaria;      
        }  
        
        this.totalDiasTrabalhados.setText(Integer.toString(qtdLinhasTabela));
        this.totalPagarMensal.setText(String.format("%.2f", totalPagar));
    }
    
    public void limparTabela(){
        if(tabelaValores.getRowCount() > 0){
            DefaultTableModel model = (DefaultTableModel) tabelaValores.getModel();
            model.setRowCount(0);
        }  
    }
    
    public void limparFormulário(){
        this.EntradaServico.setText("");
        this.SaidaAlmoço.setText("");
        this.RetornoAlmoco.setText("");
        this.SaidaServico.setText("");
        this.horasTrabalhadas.setText("");
        this.totalPagarDiaria.setText("");
        this.totalDiasTrabalhados.setText("0");
        this.totalPagarMensal.setText("0.00");
    }
    
    public void removerDiaria(){
        int linhaSelec = tabelaValores.getSelectedRow();        
        DefaultTableModel model = (DefaultTableModel) tabelaValores.getModel();        
        model.removeRow(linhaSelec);
    }
    
    public void definirValorHoraExtra(){
        String data = ferramentas.dataAtualString();      
        String diaSemana = ferramentas.diaSemana(data);  
        
        double valorHora = Double.parseDouble(this.valorHora.getText().replace(",", "."));
        double valorHoraExtra = 0;
        System.out.println(diaSemana);
        if(diaSemana.equalsIgnoreCase("domingo")){
            valorHoraExtra = valorHora + (valorHora*0.10);
        }else{
            valorHoraExtra = valorHora + (valorHora*0.5);          
        }
        this.valorHoraExtra.setText(String.format("%.2f", valorHoraExtra).replace(".", ","));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField EntradaServico;
    private javax.swing.JFormattedTextField RetornoAlmoco;
    private javax.swing.JFormattedTextField SaidaAlmoço;
    private javax.swing.JFormattedTextField SaidaServico;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnOk;
    private javax.swing.JFormattedTextField dataDiaria;
    private javax.swing.JTextField horasTrabalhadas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaValores;
    private javax.swing.JTextField totalDiasTrabalhados;
    private javax.swing.JTextField totalPagarDiaria;
    private javax.swing.JTextField totalPagarMensal;
    private javax.swing.JFormattedTextField valorHora;
    private javax.swing.JFormattedTextField valorHoraExtra;
    // End of variables declaration//GEN-END:variables
}
