
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.*;
import java.awt.geom.*;
import java.io.File;
import java.io.IOException;

public class ImageProc
{
    public enum PixelType {

        RED(0),
        GREEN(1),
        BLUE(2),
        ALPHA(3);

        private final int pixelCode;

        PixelType(int pixel_code) {
            this.pixelCode = pixel_code;
        }

        int getValue(int pixel) {

            if (pixel > 0) return -1;

            int newValue;
            switch (this.pixelCode) {
                case 0:
                    newValue = (pixel >> 16) & 0xff;
                    break;
                case 1:
                    newValue = (pixel >> 8) & 0xff;
                    break;
                case 2:
                    newValue = pixel & 0xff;
                    break;
                case 3:
                default:
                    newValue = (pixel >> 24) & 0xff;
                    break;
            }
            return newValue;
        }
    }

    public static void main(String[] args) {
        BufferedImage img = null;
        int[] pixels;
        try {
            img = ImageIO.read(new File("/Users/daniel/Pictures/space.jpg"));
            pixels = img.getRGB(0,0, img.getWidth(), img.getHeight(), null, 0, img.getWidth());
            printPixels(pixels);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int getValueOf() { return 0; }

    public static void printPixels(int[] pixels) {
        PixelType red = PixelType.RED;
        PixelType green = PixelType.GREEN;
        PixelType blue = PixelType.BLUE;
        PixelType alpha = PixelType.ALPHA;

        for (int pixel : pixels ) {
            int A, R, G, B;
            A = alpha.getValue(pixel);
            R = red.getValue(pixel);
            G = green.getValue(pixel);
            B = blue.getValue(pixel);
        }
    }


}
