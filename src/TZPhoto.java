import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TZPhoto {

    final static String outPath = "C:\\ANNA\\work\\2019\\april\\tzcb\\out\\production\\tzcb\\Sample.jpg";

    public static void main(String[] args) throws IOException {
        String filePath = args[0];
        String dWidth = args[1];
        String dHeight = args[2];

        BufferedImage  colorimage = ImageIO.read(new File(filePath));
        BufferedImage grayscale = convertjpg(Integer.parseInt(dWidth),Integer.parseInt(dHeight), colorimage);

        File outputfile = new File(outPath);
        FileOutputStream fos = new FileOutputStream(outputfile);
        ImageIO.write(grayscale, "jpg", outputfile);
        fos.flush();
        fos.close();
        System.out.println("The black-white image is displayed in the folder at: " + outPath);
    }


     public static BufferedImage convertjpg (Integer dWidth, Integer dHeight, BufferedImage  colourImage) {
        BufferedImage blackAndWhiteImage = new BufferedImage(
                dWidth.intValue(),
                dHeight.intValue(),
                BufferedImage.TYPE_BYTE_BINARY);
        Graphics2D graphics = blackAndWhiteImage.createGraphics();
         graphics.drawImage(colourImage, 0, 0, null);

        return blackAndWhiteImage;
    }
}
