
package view.ferramentas;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;


public class Ferramentas {
    
    //Arredondando o valor para cima se for maior que 0.5 e para baixo se for menos que 0.5
    public double arrendodarValores(double valor){
        BigDecimal bd = new BigDecimal(valor).setScale(2, RoundingMode.HALF_DOWN); 
        double novoValorArredondado = bd.doubleValue();
        
        return novoValorArredondado;
    }
    
    public String convertendoDataStringSql(java.sql.Date data){
        
        try{
            if(data == null){
                return " ";
            }else{
                DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate localDate = data.toLocalDate();

                String dataFormatada = localDate.format(formatoData);

                return dataFormatada;
            }
        } catch (DateTimeParseException e) {
            // Lançando uma exceção se a string estiver em um formato inválido
            throw new IllegalArgumentException("Erro ao tentar converte Date em String", e);
        }
    }
    
    public Date convertendoStringDateSql(String data) {
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            // Converte a string para LocalDate
            LocalDate localDate = LocalDate.parse(data, formatoData);

            // Converte LocalDate para java.sql.Date, usando o método from() e Instant
            return java.sql.Date.valueOf(localDate);
        } catch (DateTimeParseException e) {
            // Lançando uma exceção se a string estiver em um formato inválido
            throw new IllegalArgumentException("Erro ao tentar converter String em Date", e);
        }
    }
      
    public String dataAtualString(){
        LocalDateTime dataAtual = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = dataAtual.format(formato);
        
        return dataFormatada;

    }
       
    public LocalTime convertendoStringHora(String hora){
        
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime horaFormatada = null;

        try {
            //Transforma a String em horas
            horaFormatada = LocalTime.parse(hora, formatoHora);
            
            //Transforma as horas em string
            String horaString = horaFormatada.format(formatoHora);
            
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Formato da hora está incorreto", "Erro 01", JOptionPane.ERROR_MESSAGE);
        }
        
        return horaFormatada;
    }
    
    public String convertendoHoraString(LocalTime hora){
        
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");
        String horaConvertida = null;

        try {  
            //Transforma as horas em string
            horaConvertida = hora.format(formatoHora);
            
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Formato da hora está incorreto", "Erro 01", JOptionPane.ERROR_MESSAGE);
        }
        
        return horaConvertida;
    }
    
    public int converterHorasMinutos(LocalTime horas){
        int totalMinutos = 0;
        
        try {
            // Calcula os minutos totais
            totalMinutos = horas.getHour() * 60 + horas.getMinute();
            
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar calcular o valor a pagar, verifique os dados e tente novamente", "Erro 03", JOptionPane.ERROR_MESSAGE);
        }
        
        return totalMinutos;
    }
    
    public String diaSemana(String data){
        
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String nomeDia = null;

        try {
            // Converte a string para LocalDate
            LocalDate date = LocalDate.parse(data, formatoData);
            
            // Obtém o dia da semana
            DayOfWeek diaDaSemana = date.getDayOfWeek();
            
            // Exibe o resultado em formato textual
            nomeDia = diaDaSemana.getDisplayName(TextStyle.FULL, Locale.getDefault());
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar obter o dia da semana", "Erro 04", JOptionPane.ERROR_MESSAGE);
        }
        
        return nomeDia;
    }
}
