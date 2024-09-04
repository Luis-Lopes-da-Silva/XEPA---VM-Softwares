/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static View.Login_GUI.senha;
import static View.Login_GUI.usuario;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JOptionPane;


public class Funcionalidades_DAO {
  
    public static int conts;
    public static int qtde = Integer.parseInt (View.Caixa_GUI.qtde_pro.getText());
    public static double preco = Double.parseDouble (View.Caixa_GUI.unit_pro.getText());
    public static double total_pro;
    public static double total;
    public static String nomeP = View.Caixa_GUI.nome_pro.getText();
    public static String cpfC = View.Caixa_GUI.cpf_cli.getText();
    public static String nomeC = View.Caixa_GUI.nome_cli.getText();
    public static String[] opcoes = {"Pix", "Débito", "Crédito", "Dinheiro"};
    
        public static void totalizar_funcao(){
       
        conts = conts + 1;
        total_pro = qtde * preco;
        View.Caixa_GUI.total_pro.setText(String.valueOf(total_pro));
        
        
        if(conts > 1){
        total_pro = 0;
        total_pro = qtde * preco;
        View.Caixa_GUI.total_pro.setText(String.valueOf(total_pro));
        }
        
        
    }
    public static void totalizar2_funcao(){
    
        total = total + total_pro;
        View.Caixa_GUI.total_TXT.setText(String.valueOf(total));
        total_pro = 0;
        
    
    }
    
    public static void finalizar_funcao() throws DocumentException, FileNotFoundException, IOException{
        
        int escolha = JOptionPane.showOptionDialog(
            null,
            "Escolha uma forma de pagamento:",
            "Opções de Pagamento",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.PLAIN_MESSAGE,
            null,
            opcoes,
            opcoes[0]
        );

        if (escolha >= 0) {
            JOptionPane.showMessageDialog(null, "Você escolheu: " + opcoes[escolha]);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma opção selecionada.");
        }
        
        Document doc = null;
        OutputStream os = null;

        try {

            
            
            //cria o documento tamanho A4, margens de 2,54cm
            doc = new Document(PageSize.A4, 72, 72, 72, 72);

            //cria a stream de saída
            os = new FileOutputStream("C:\\Users\\user\\Downloads\\TESTE4\\NotaFiscalXEPA.pdf");

            //associa a stream de saída ao
            PdfWriter.getInstance(doc, os);

            //abre o documento
            doc.open();
            
            //adiciona o texto ao PDF
            
            Paragraph par1 = new Paragraph("                              NOTA FISCAL                           ");
            Paragraph par2 = new Paragraph("                                                                     ");
	    Paragraph par3 = new Paragraph("Cliente:       "+nomeC+"    CPF: "+cpfC+"                            ");
            Paragraph par4 = new Paragraph("                                                                     ");
            Paragraph par5 = new Paragraph("Produtos:      "+nomeP+"                                             ");
            Paragraph par6 = new Paragraph("                                                                     ");
            Paragraph par7 = new Paragraph("Valor Unit.:   "+preco+"    Qtde:  "+qtde+"                          ");    
            Paragraph par8 = new Paragraph("                                                                     ");
            Paragraph par9 = new Paragraph("Valor Total pago:   "+total+"                                        "); 
            Paragraph par10 = new Paragraph("Método de pagamento:   "+opcoes[escolha]+"                                        ");
            Paragraph par11 = new Paragraph("                                                                    ");    
             
            doc.add(par1);
	    doc.add(par2);		
            doc.add(par3);
            doc.add(par4);
            doc.add(par5);
            doc.add(par6);
            doc.add(par7);
            doc.add(par8);
	    doc.add(par9);		
            doc.add(par10);
            doc.add(par11);
    
      
} finally {

            if (doc != null) {

                //fechamento do documento
                doc.close();
            }

            if (os != null) {
                //fechamento da stream de saída
                os.close();
            }
        }
                Desktop.getDesktop().open(new File("NotaFiscalXEPA.pdf"));
    }
    
}
