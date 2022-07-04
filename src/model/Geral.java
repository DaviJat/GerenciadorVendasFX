package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

/** 
 * Classe com funções genéricas utilizadas ao longo do programa
 * @author Davi
 *
 */
public class Geral {
	
	/**
	 * Loop com input da hora, finalizada apenas quando a hora inserida for válida
	 * @return
	 */
	public static String validaHora(String entradaHora) {
	    LocalTime hora = null;
	    String horaFormatada = null;
	    
	    DateTimeFormatter dateTimeFormatter = DateTimeFormatter
	    .ofPattern("HH:mm:ss")
	    .withResolverStyle(ResolverStyle.STRICT);
	    try {
	        hora = LocalTime.parse(entradaHora, dateTimeFormatter);
	        horaFormatada = hora.toString();
	    } catch (DateTimeParseException e) {
	    	horaFormatada = null;
	    }
		
	    return horaFormatada;
	}
	
	/**
	 * Loop com o input do preço total, finalizado apenas quando o valor for válido
	 * @return
	 */
	public static double validaDouble(String precoString) {
		double preco = -1;
			
		try{
			preco = Double.parseDouble(precoString);
		}catch(NumberFormatException e){
			preco = -1;
		}
		
		return preco;
	}
	
	/**
	 * Função para comparar datas
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean comparaData(LocalDate a , LocalDate b) {

        if(a.isAfter(b)) {
            return true;
        }
        return false;
    }
}
