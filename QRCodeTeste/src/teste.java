import java.io.IOException;

import com.google.zxing.WriterException;

public class teste {

	public static void main(String[] args) throws IOException, WriterException {
		
		String caminho ="C:\\QRCode";
		String texto = "http://www.google.com";
		String saida ; 
				
	    QRCode  qrcode = new QRCode();
	    saida = qrcode.create(texto, caminho);
	    
		
	    System.out.println(saida);

	}

}
