package impl;
import java.awt.image.BufferedImage;
import core.*;
public class SimpleBufferedImageConverter implements BufferedImageConverter
{
	@Override
	public BufferedImage convert(BufferedImage img) 
	{
		BufferedImage erg = img;
		int typ = img.getType();
		if (typ == BufferedImage.TYPE_INT_RGB) System.out.println("TYPE_INT_RGB");
		if (typ == BufferedImage.TYPE_INT_ARGB) System.out.println("TYPE_INT_ARGB");
		if (typ == BufferedImage.TYPE_3BYTE_BGR) System.out.println("TYPE_3BYTE_BGR");
		if (typ == BufferedImage.TYPE_4BYTE_ABGR) System.out.println("TYPE_4BYTE_ABGR");
		if (typ == BufferedImage.TYPE_4BYTE_ABGR_PRE) System.out.println("TYPE_4BYTE_ABGR_PRE");
		if (typ == BufferedImage.TYPE_BYTE_BINARY) System.out.println("TYPE_BYTE_BINARY");
		if (typ == BufferedImage.TYPE_BYTE_GRAY) System.out.println("TYPE_BYTE_GRAY");
		if (typ == BufferedImage.TYPE_BYTE_INDEXED) System.out.println("TYPE_BYTE_INDEXED");
		if (typ == BufferedImage.TYPE_CUSTOM) System.out.println("TYPE_CUSTOM");
		if (typ == BufferedImage.TYPE_INT_ARGB_PRE) System.out.println("TYPE_INT_ARGB_PRE");
		if (typ == BufferedImage.TYPE_INT_BGR) System.out.println("TYPE_INT_BGR");
		if (typ == BufferedImage.TYPE_USHORT_555_RGB) System.out.println("TYPE_USHORT_555_RGB");
		if (typ == BufferedImage.TYPE_USHORT_565_RGB) System.out.println("TYPE_USHORT_565_RGB");
		if (typ == BufferedImage.TYPE_USHORT_GRAY) System.out.println("TYPE_USHORT_GRAY");
		if (typ != BufferedImage.TYPE_INT_ARGB)
		{
			int height = img.getHeight();
			int width = img.getWidth();
			erg = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
			for (int i=0;i<width;i++)
			{
				for (int j=0;j<height;j++)
				{
					int c = img.getRGB(i,j);
					erg.setRGB(i, j, c);
				}
			}
		}
		return erg;
	}
}
