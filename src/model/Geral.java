package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Scanner;

/*
import classes.Fornecedor;
import classes.Produto;
import classes.Usuario;
*/

/** 
 * Classe com funções genéricas utilizadas ao longo do programa
 * @author Davi
 *
 */
public class Geral {
	
	/**
	 * Função para inicializar objetos padrão
	 */
	/*
	public static void criaObjetosDefault() {
		
		Usuario novoUsuario = new Usuario("1", "Administrador", "adm", true);
		Usuario.cadastrar(novoUsuario);
		
		Fornecedor novoFornecedor = new Fornecedor("1", "Piracanjuba", "88888888", "Rua Argentina");
		Fornecedor.cadastrar(novoFornecedor);
		
		Fornecedor novoFornecedor2 = new Fornecedor("2", "Sadia", "99999999", "Rua Brasil");
		Fornecedor.cadastrar(novoFornecedor2);
		
		Produto novoProduto = new Produto("1", "Queijo", 0.75, "10/10/2022", 1000.00, "1");
		Produto.cadastrar(novoProduto);
		
		Produto novoProduto2 = new Produto("2", "Presunto", 0.5, "10/10/2022", 500.00, "2");
		Produto.cadastrar(novoProduto2);
	}
	*/
	
	/**
	 * Função que retorna a data atual
	 * @return
	 */
	public static String geraDataAtual() {
		
		// Armazena data e hora atual
		LocalDateTime dataHoraAtual = LocalDateTime.now();

		// formata a data
		DateTimeFormatter formataData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
		String dataFormatada = formataData.format(dataHoraAtual);
		
	    return dataFormatada;
	}
	
	/**
	 * Função que retorna a hora atual
	 * @return
	 */
	public static String geraHoraAtual() {
		
		// Armazena data e hora atual
		LocalDateTime dataHoraAtual = LocalDateTime.now();

		// formata a hora
		DateTimeFormatter formataHora = DateTimeFormatter.ofPattern("HH:mm:ss");
		String horaFormatada = formataHora.format(dataHoraAtual);
		
	    return horaFormatada;
	}
	
	/**
	 * Loop com input da data, finalizada apenas quando a data inserida for válida
	 * @return
	 */
	public static String validaData(String entradaData) {
	    LocalDate data = null;
	    String dataFormatada = null;
		
	    DateTimeFormatter dateTimeFormatter = DateTimeFormatter
	    .ofPattern("dd/MM/uuuu");
	    try {
	        data = LocalDate.parse(entradaData, dateTimeFormatter);
	        dataFormatada = dateTimeFormatter.format(data);
	    } catch (DateTimeParseException e) {
	    	dataFormatada = null;
	    }
		
	    return dataFormatada;
	}
	
	/**
	 * Loop com input da hora, finalizada apenas quando a hora inserida for válida
	 * @return
	 */
	public static String validaHora() {
	    LocalTime hora = null;
	    String horaFormatada = null;
	    
	    @SuppressWarnings("resource")
		Scanner entradaHora = new Scanner(System.in);
		
		boolean validaHora = false;
		
		while (validaHora == false) {
		    DateTimeFormatter dateTimeFormatter = DateTimeFormatter
		    .ofPattern("HH:mm:ss")
		    .withResolverStyle(ResolverStyle.STRICT);
		    try {
		    	System.out.println("Digite um horário: ");
				String horaString = entradaHora.nextLine();
		        hora = LocalTime.parse(horaString, dateTimeFormatter);
		        horaFormatada = hora.toString();
		        validaHora = true;
		    } catch (DateTimeParseException e) {
		    	System.out.println("Hora inválida - Utilize o formato hh:mm:ss");
		    }
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
	public static boolean comparaData(String a , String b) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");

        LocalDate c = LocalDate.parse(a,formatter);

        LocalDate d = LocalDate.parse(b,formatter);

        if(c.isAfter(d)) {
            return true;
        }
        return false;
    }
}
