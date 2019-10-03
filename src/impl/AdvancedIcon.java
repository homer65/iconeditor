package impl;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import javax.swing.JOptionPane;
import core.*;
public class AdvancedIcon implements Icon
{
	private int width = Parameter.iconWidth;
	private int height = Parameter.iconHeight;
	private int[][] pixel = null;
	public void buildRandom()
	{
		pixel = new int[width][height];
		int c = 0;
		for (int i=0;i<width;i++)
		{
			for (int j=0;j<height;j++)
			{
				pixel[i][j] = c;
			}
		}
	}
	public void buildFromImage(BufferedImage bimage)
	{
		width = bimage.getWidth();
		height = bimage.getHeight();
		Protokol.write("AdvancedIcon:buildFromImage:width :" + width);
		Protokol.write("AdvancedIcon:buildFromImage:height:" + height);
		pixel = new int[width][height];
		for (int i=0;i<width;i++)
		{
			for (int j=0;j<height;j++)
			{
				pixel[i][j] = bimage.getRGB(i,j);			
			}
		}
	}
	public BufferedImage getImage() 
	{
		BufferedImage erg = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
		for (int i=0;i<width;i++)
		{
			for (int j=0;j<height;j++)
			{
				erg.setRGB(i,j,pixel[i][j]);
			}
		}
		return erg;
	}
	public Pixel getPixel(int x, int y) 
	{
		Pixel p = Factory.getPixel();
		p.setX(x);
		p.setY(y);
		if (x < width)
		{
			if (y < height)
			{
				p.setColor(new Color(pixel[x][y]));
			}
		}
		return p;
	}
	public void readFromFile(File file) 
	{
		IconTypFinder itf = Factory.getIconTypFinder();
		String typ = itf.getTyp(file);
		ImageLoader il = Factory.getImageLoader();
		BufferedImage im = il.load(file,typ);
		if (im != null)
		{
			BufferedImageConverter converter = Factory.getBufferedImageConverter();
			im = converter.convert(im);
			width = im.getWidth();
			height = im.getHeight();
			Protokol.write("AdvancedIcon:readFromFile:width:" + width);
			Protokol.write("AdvancedIcon:readFromFile:height:" + height);
			pixel = new int[width][height];
			for (int i=0;i<width;i++)
			{
				for (int j=0;j<height;j++)
				{
					pixel[i][j] = im.getRGB(i,j);
				}
			}
		}
		else
		{
			String msg = "AdvancedIcon:readFromFile:No Image Loaded";
			Protokol.write(msg);
			JOptionPane.showMessageDialog(null,msg,"",JOptionPane.ERROR_MESSAGE);
		}
	}
	public void setPixel(Pixel p)
	{
		int x = p.getX();
		int y = p.getY();
		Color c = p.getColor();
		pixel[x][y] = c.getRGB();
	}
	public void setSize(int width, int height) 
	{
		this.width = width;
		this.height = height;
		// Protokol.write("AdvancedIcon:setSize:width :" + width);
		// Protokol.write("AdvancedIcon:setSize:height:" + height);
		buildRandom();
	}
	public void writeToFile(File file) 
	{
		IconTypFinder itf = Factory.getIconTypFinder();
		String typ = itf.getTyp(file);
		ImageLoader il = Factory.getImageLoader();
		BufferedImage im = getImage();
		il.write(file,typ,im);
	}
	public Dimension getSize() 
	{
		return new Dimension(width,height);
	}
	public Icon copy() 
	{
		AdvancedIcon erg = new AdvancedIcon();
		erg.width = width;
		erg.height = height;
		if (pixel != null)
		{
			erg.pixel = new int[width][height];
			for (int i=0;i<width;i++)
			{
				for (int j=0;j<height;j++)
				{
					erg.pixel[i][j] = pixel[i][j];
				}
			}
		}
		return erg;
	}
}
