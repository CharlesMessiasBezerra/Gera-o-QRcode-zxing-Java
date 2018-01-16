
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.ByteMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.util.Hashtable;

public class QRCode {

    public static String create(String textodoCodigo, String caminho) throws IOException, WriterException {

        //String nameImagem = Global.getRandom(10) + ".png";
    	String nameImagem = "teste.png";

        caminho += "\\" + nameImagem;
        int tam = 200;
        String tipoArquivo = "jpg";
        File myFile = new File(caminho);
        Hashtable hintMap = new Hashtable();
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        ByteMatrix byteMatrix = qrCodeWriter.encode(textodoCodigo, BarcodeFormat.QR_CODE, tam, tam, hintMap);
        int tamanho = byteMatrix.getWidth();
        BufferedImage image = new BufferedImage(tamanho, tamanho,
                BufferedImage.TYPE_INT_RGB);
        image.createGraphics();

        Graphics2D graphics = (Graphics2D) image.getGraphics();
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, tamanho, tamanho);
        graphics.setColor(Color.WHITE);

        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                if (byteMatrix.get(i, j) != 0) {
                    graphics.fillRect(i, j, 1, 1);
                }
            }
        }
        ImageIO.write(image, tipoArquivo, myFile);
        return caminho;
    }
}
