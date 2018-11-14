package impl;
import core.*;
import java.awt.*;
import java.awt.image.*;
public class SimpleIconResizer implements IconResizer
{
	public Icon resize(Icon icon,int width,int height)
	{
		BufferedImage bi = icon.getImage();
		Image im  = bi.getScaledInstance(width,height,BufferedImage.SCALE_SMOOTH);
		BufferedImage bi2 = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		Graphics g = bi2.getGraphics();
		g.drawImage(im,0,0,null);
		Icon erg = Factory.getIcon();
		erg.setSize(width,height);
		for (int i=0;i<width;i++)
		{
			for (int j=0;j<height;j++)
			{
				int rgb = bi2.getRGB(i,j);
				Color c = new Color(rgb);
				Pixel pixel = Factory.getPixel();
				pixel.setX(i);
				pixel.setY(j);
				pixel.setColor(c);
				erg.setPixel(pixel);
			}
		}
		return erg;
	}
}
