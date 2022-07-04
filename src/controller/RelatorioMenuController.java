package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import model.Fornecedor;
import model.Geral;
import model.Item;
import model.Produto;
import model.Venda;

public class RelatorioMenuController {

	@FXML
    private Button brnEstoqueGeral;

    @FXML
    private Button btnEstoquePorProduto;

    @FXML
    private Button btnEstoquePorValidade;

    @FXML
    private Button btnFornecedorPorProduto;

    @FXML
    private Button btnFornecedoresGeral;

    @FXML
    private Button btnVendasGeral;

    @FXML
    private Button btnVendasPorCategoria;

    @FXML
    private Button btnVendasPorPeriodo;
    
    @FXML
    private Button btnNotaFiscal;
    
    @FXML
    private TextField inputCodigoVenda;

    @FXML
    private Button btnVoltar;

    @FXML
    private TextField inputEstoqueProduto;

    @FXML
    private TextField inputFornecedorProduto;

    @FXML
    private TextField inputVendaCategoria;

    @FXML
    private DatePicker inputVendaDataFinal;

    @FXML
    private DatePicker inputVendaDataInicial;

    @FXML
    private Label msgErro;
    
    /**
     * Gera relatório de Estoque Geral
     * @param event
     */
    @FXML
    void gerarRelatorioEstoqueGeral(ActionEvent event) {
    	
    	Document document = new Document();
	       
		try {

           	PdfWriter.getInstance(document, new FileOutputStream("EstoqueTotal.pdf"));
           	document.open();
           
           	document.add(new Paragraph("Relatório de Estoque Total"));
           	
           	double quantidadeTotal = 0.0;
           
           	for(Produto produto : Produto.getListaProduto()) {
           		
           		String texto = ("| Codigo: "         + produto.getCodigo()+  
				   				"| Nome: "          + produto.getNome() + 
				   				"| Estoque: "    + produto.getEstoque() + " (kg)");
			
           		document.add(new Paragraph(texto));
    			
                quantidadeTotal += produto.getEstoque();
   			}
           	
           	String texto = ("Quantidade Total " + quantidadeTotal);
           	document.add(new Paragraph(texto));
           
       } catch(DocumentException de) {
    	   
           System.err.println(de.getMessage());
           
       } catch(IOException ioe) {
    	   
           System.err.println(ioe.getMessage());
       }
       
       document.close();
       msgErro.setText("");
       msgErro.setText("Relatório gerado");
    	
    }

    /**
     * Gera o relatório de estoque do/dos produto/produtos com o nome igual ao nome digitado pelo usuário
     * @param event
     */
    @FXML
    void gerarRelatorioEstoquePorProduto(ActionEvent event) {
    	
    	Document document = new Document();
    	
    	String produtoInput = inputEstoqueProduto.getText();
    	
    	if (produtoInput != "") {
	       
			try {
	
	           	PdfWriter.getInstance(document, new FileOutputStream("EstoquePorProduto.pdf"));
	           	document.open();
	           
	           	document.add(new Paragraph("Relatório de Estoque por Produto ("  + produtoInput + ")"));
	           
	           	for(Produto produto : Produto.getListaProduto()) {
	           		
	           		if (produto.getNome().equals(produtoInput)) {
		                
		                String texto = ("| Codigo: "         + produto.getCodigo()+  
	         				   			"| Nome: "          + produto.getNome() + 
	         				   			"| Estoque: "    + produto.getEstoque() + " (kg)");
		 				
		 				document.add(new Paragraph(texto));
		                
	           		}
	   			}
	           
	       } catch(DocumentException de) {
	    	   
	           System.err.println(de.getMessage());
	           
	       } catch(IOException ioe) {
	    	   
	           System.err.println(ioe.getMessage());
	       }
	       
	       document.close(); 
	       msgErro.setText("");
	       msgErro.setText("Relatório gerado");
       
       } else {
    	   
	    	msgErro.setText("");
	   		msgErro.setText("Digite a nome do produto para gerar o relatório");
    	   
       }

    }
    
    /**
     * Gera Relatório de Estoque ordenando os produtos pela data de Validade
     * @param event
     */
    @FXML
    void gerarRelatorioEstoquePorValidade(ActionEvent event) {
    	
    	Document document = new Document();
	       
		try {

           	PdfWriter.getInstance(document, new FileOutputStream("EstoqueValidade.pdf"));
           	document.open();
           
           	document.add(new Paragraph("Relatório de Estoque Validade"));
           	
           	Collections.sort(Produto.getListaProduto(), new validadeComparator());
           
           	for(Produto produto : Produto.getListaProduto()) {
    			
                System.out.println("| Codigo: "         + produto.getCodigo()+  
                				   " | Nome: "          + produto.getNome() + 
                				   " | Validade: "      + produto.getValidade() + 
                				   " | Estoque: "    + produto.getEstoque() + " (gramas)");
                
   			}
           
       } catch(DocumentException de) {
    	   
           System.err.println(de.getMessage());
           
       } catch(IOException ioe) {
    	   
           System.err.println(ioe.getMessage());
       }
       
	     document.close();
	     msgErro.setText("");
	     msgErro.setText("Relatório gerado");

    }
    
    /**
     * Gera relatório com todos os Fornecedores
     * @param event
     */
    @FXML
    void gerarRelatorioFornecedoresGeral(ActionEvent event) {
    	
    	Document document = new Document();
	       
		try {

           	PdfWriter.getInstance(document, new FileOutputStream("FornecedoresGeral.pdf"));
           	document.open();
           
           	document.add(new Paragraph("Relatório de Fornecedores"));
   			
   			for (Fornecedor fornecedor : Fornecedor.getListaFornecedor()) {	
   						
				String texto = ("| Codigo: "       + fornecedor.getCodigo()+  
	 				   " | Nome: "      + fornecedor.getNome() +  
	 				   " | CNPJ: "      + fornecedor.getCnpj() +  
	 				   " | Endereço: "  + fornecedor.getEndereco());
				
				document.add(new Paragraph(texto));
   			}
           
       } catch(DocumentException de) {
    	   
           System.err.println(de.getMessage());
           
       } catch(IOException ioe) {
    	   
           System.err.println(ioe.getMessage());
       }
       
       document.close();
       msgErro.setText("");
       msgErro.setText("Relatório gerado");
    	
    }
    
    /**
     * Gera relatório com os fonecedores que fornecem o produto especificado pelo usuário
     * @param event
     */
    @FXML
    void gerarRelatorioFornecedoresPorProduto(ActionEvent event) {
    	
    		Document document = new Document();
    		
    		String produto = inputFornecedorProduto.getText();
	       
    		if (produto == "") {
    		
			try {
	
	           	PdfWriter.getInstance(document, new FileOutputStream("FornecedoresProduto.pdf"));
	           	document.open();
	           
	           	document.add(new Paragraph("Relatório de Fornecedores por Produto"));
	   			
	   			String titulo = "Fornecedores de " + produto + ":";
	   			
	   			document.add(new Paragraph(titulo));
	   			
	   			for(Produto produto1 : Produto.getListaProduto()) {	
	   				
	   				if (produto1.getNome().equals(produto)) {
	   				
	   					String nomeFornecedor = produto1.getNomeFornecedor();
	   						
						String texto = ("Fornecedor: "    + nomeFornecedor);
						
						document.add(new Paragraph(texto));
	   				}
	   			}
	           
	       } catch(DocumentException de) {
	    	   
	           System.err.println(de.getMessage());
	           
	       } catch(IOException ioe) {
	    	   
	           System.err.println(ioe.getMessage());
	       }
	       
	       document.close();
	       msgErro.setText("");
	       msgErro.setText("Relatório gerado");
    		} else {
    			msgErro.setText("Digite um produto para gerar o relatório de Fornecedores por Produto");
    		}

    }
    
    /**
     * Gera relatório de vendas no geral
     * @param event
     */
    @FXML
    void gerarRelatorioVendasGeral(ActionEvent event) {
    	
    	Document document = new Document();
        
        try {

            PdfWriter.getInstance(document, new FileOutputStream("VendasGeral.pdf"));
            document.open();
            
            document.add(new Paragraph("Relatório de Vendas Realizadas no Geral"));
            
            for (Venda venda : Venda.listaVenda) {
    			   
            	String texto = ("Codigo: " + venda.getCodigo() + 
   						" | Cliente: "             + venda.getNomeCliente() +  
	 				    " | Data: "                + venda.getData() +  
	 				    " | Hora: "                + venda.getHora() +  
	 				    " | Preço Total: R$"       + venda.getPrecoTotal() +  
	 				    " | Forma de Pagamento: "  + venda.getFormaPagamento() +
	 				    " | Itens: "               + venda.getListaNomesItensVenda());
       			
       			document.add(new Paragraph(texto));
             }
            
        } catch(DocumentException de) {
     	   
            System.err.println(de.getMessage());
            
        } catch(IOException ioe) {
     	   
            System.err.println(ioe.getMessage());
        }
        
        document.close();
        msgErro.setText("");
		msgErro.setText("Relatório gerado");
    	
    }

    /**
     * Gera relatório apenas com as vendas que possuem itens da categoria digitada pelo usuário
     * @param event
     */
    @FXML
    void gerarRelatorioVendasPorCategoria(ActionEvent event) {
    	
    	Document document = new Document();
    	
    	String categoriaInput = inputVendaCategoria.getText();
    	
    	if (categoriaInput != "") {
	       
	        try {
	
	           PdfWriter.getInstance(document, new FileOutputStream("VendasCategoria.pdf"));
	           document.open();
	           
	           document.add(new Paragraph("Relatório de Vendas Realizadas por Categoria (" + categoriaInput + ")"));
	           
	           for (Venda venda : Venda.listaVenda) {
	        	   
	        	   boolean validaCategoria = false;
	        	   
	        	   ArrayList<Item> listaItens = venda.getListaItensVenda();
	        	   
	        	   for (Item item : listaItens) {
	        		   
	        		   String codigoVenda = item.getCodigo();
	            	   
	            	   String categoria = Item.retornaCategoriasItens(codigoVenda);
	        		   
	        		   if(categoria.equals(categoriaInput)) {
	        			   validaCategoria = true;
	        		   }
	        		   
	        	   }
	        	   
	               if (validaCategoria) {
	   	               
	            	   String texto = ("Codigo: " + venda.getCodigo() + 
		   						" | Cliente: "             + venda.getNomeCliente() +  
			 				    " | Data: "                + venda.getData() +  
			 				    " | Hora: "                + venda.getHora() +  
			 				    " | Preço Total: R$"       + venda.getPrecoTotal() +  
			 				    " | Forma de Pagamento: "  + venda.getFormaPagamento() +
			 				    " | Itens: "               + venda.getListaNomesItensVenda());
	         			
	                     document.add(new Paragraph(texto));
	                     
	               }
	           }
	           
	       } catch(DocumentException de) {
	    	   
	           System.err.println(de.getMessage());
	           
	       } catch(IOException ioe) {
	    	   
	           System.err.println(ioe.getMessage());
	       }
	       
	       document.close();
	       msgErro.setText("");
	       msgErro.setText("Relatório gerado");
	       
    	} else {
    		
    		msgErro.setText("");
    		msgErro.setText("Digite a categoria para gerar o relatório");
    		
    	}
    	
    }
    
    /**
     * Gera relatório de Vendas feitas no período digitado pelo usuário
     * @param event
     */
    @FXML
    void gerarRelatorioVendasPorPeriodo(ActionEvent event) {
    	
    	LocalDate dataInicial = inputVendaDataInicial.getValue();
        LocalDate dataFinal = inputVendaDataFinal.getValue();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    	
    	if (dataFinal != null && dataInicial != null) {
    	
			Document document = new Document();
		    
		    try {
		
		        PdfWriter.getInstance(document, new FileOutputStream("VendasPeriodo.pdf"));
		        document.open();
		        
		        document.add(new Paragraph("Relatório de Vendas Realizadas por Período"));
		        
		        if(Geral.comparaData(dataFinal, dataInicial)) {
		     	  
		           for (Venda venda : Venda.listaVenda) {
		        	   
		        	   String dataVendaString = venda.getData();
		        	   
		        	   LocalDate dataVenda = LocalDate.parse(dataVendaString, formatter);
		        	   
		        	   if(Geral.comparaData(dataFinal, dataVenda) && Geral.comparaData(dataVenda, dataInicial)) {
			               
				   			String texto = ("Codigo: " + venda.getCodigo() + 
				   						" | Cliente: "             + venda.getNomeCliente() +  
					 				    " | Data: "                + venda.getData() +  
					 				    " | Hora: "                + venda.getHora() +  
					 				    " | Preço Total: R$"       + venda.getPrecoTotal() +  
					 				    " | Forma de Pagamento: "  + venda.getFormaPagamento() +
					 				    " | Itens: "               + venda.getListaNomesItensVenda());
				   			
			      			document.add(new Paragraph(texto));
		        	   }
		            }
		           
		        	} else {
		        		System.out.println("Sem vendas nesse período");
			   		}
		        
		    } catch(DocumentException de) {
		 	   
		        System.err.println(de.getMessage());
		        
		    } catch(IOException ioe) {
		 	   
		        System.err.println(ioe.getMessage());
		    }
		    
		    document.close();
		    msgErro.setText("");
    		msgErro.setText("Relatório gerado");
		    
    	} else {
    		
    		msgErro.setText("");
    		msgErro.setText("Digite o período para gerar o relatório");
    		
    	}
    	
    }
    
    /**
     * Gera nota fiscal da venda com o código digitado pelo usuário
     * @param event
     */
    @FXML
    void gerarNotaFiscal(ActionEvent event) {
    	
        String codigoVenda = inputCodigoVenda.getText();
        
        boolean validaVenda = Facade.validaVenda(codigoVenda);
    	
    	if (codigoVenda != "" && validaVenda == true) {
    	
			Document document = new Document();
		    
		    try {
		
		        PdfWriter.getInstance(document, new FileOutputStream("NotaFicalVenda(" + codigoVenda + ").pdf"));
		        document.open();
		        
		        document.add(new Paragraph("Nota Fiscal da Venda (" + codigoVenda + ")"));
		        
		        ArrayList<Venda> listaVendas = Venda.getListaVenda();
		        
		        int index = Facade.buscaVenda(codigoVenda);
		        
		        Venda venda = listaVendas.get(index);
		     	  
		        String texto = ("Codigo: " + venda.getCodigo() + 
   						" | Cliente: "             + venda.getNomeCliente() +  
	 				    " | Data: "                + venda.getData() +  
	 				    " | Hora: "                + venda.getHora() +  
	 				    " | Preço Total: R$"       + venda.getPrecoTotal() +  
	 				    " | Forma de Pagamento: "  + venda.getFormaPagamento() +
	 				    " | Itens: "               + venda.getListaNomesItensVenda());
   			
		        document.add(new Paragraph(texto));
		        
		    } catch(DocumentException de) {
		 	   
		        System.err.println(de.getMessage());
		        
		    } catch(IOException ioe) {
		 	   
		        System.err.println(ioe.getMessage());
		    }
		    
		    document.close();
		    msgErro.setText("");
    		msgErro.setText("Nota Fiscal Gerada");
		    
    	} else {
    		
    		msgErro.setText("");
    		msgErro.setText("Digite um código de venda válido");
    		
    	}

    }
    
    /**
     * Volta para a tela de Gerenciamentos
     * @param event
     * @throws IOException
     */
    @FXML
    void voltar(ActionEvent event) throws IOException {
    	Object root = FXMLLoader.load(getClass().getResource("/view/GerenciamentoView.fxml"));
    	Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene((Parent) root);
        stage.setTitle("Menu Relatórios");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

}

/**
 * Classe auxiliar para ordenação das datas de validade
 * @author Davi
 *
 */
class validadeComparator implements Comparator<Produto> {
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
	
	public int compare(Produto a, Produto b) {
	   
	   LocalDate c = LocalDate.parse(a.getValidade(),formatter);
	
	   LocalDate d = LocalDate.parse(b.getValidade(),formatter);
	   
	   {if (c == d)
	           return 0;
	       else if (c.isAfter(d))
	           return 1;
	       else
	           return -1;
	   }
   }
}
