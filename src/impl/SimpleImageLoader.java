package impl;
import net.sf.image4j.codec.ico.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import core.*;
public class SimpleImageLoader implements ImageLoader
{
	public void write(File file,String typ,BufferedImage img)
	{
		boolean toImageIO = false;
		if (typ.equals("png")) toImageIO = true;
		if (typ.equals("gif")) toImageIO = true;
		if (typ.equals("jpg")) toImageIO = true;
		if (typ.equals("jpeg")) toImageIO = true;
		if (toImageIO)
		{
			try
			{
				ImageIO.write(img,typ,file);
			}
			catch (Exception e)
			{
				Protokol.write("SimpleImageLoader:write:toImageIO:Exception:");
				Protokol.write(file.getAbsolutePath());
				Protokol.write(e.toString());
			}
		}
		else
		{
			if (typ.equals("ico"))
			{
				try
				{
					ICOEncoder.write(img,file);
				}
				catch (Exception e)
				{
					Protokol.write("SimpleImageLoader:write:toIco:Exception");
					Protokol.write(file.getAbsolutePath());
					Protokol.write(e.toString());
				}
			}
			else
			{
				String msg = "SimpleImageLoader:write:Unsupported Typ:" + typ;
				Protokol.write(msg);
				JOptionPane.showMessageDialog(null,msg,"",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	public BufferedImage load(File file, String typ) 
	{
		BufferedImage erg = null;
		if (typ.equals("png")) erg = loadByImageIO(file);
		else if (typ.equals("gif")) erg = loadByImageIO(file);
		else if (typ.equals("jpg")) erg = loadByImageIO(file);
		else if (typ.equals("jpeg")) erg = loadByImageIO(file);
		else if (typ.equals("ico")) erg = loadByImage4j(file);
		else
		{
			Protokol.write("SimpleImageLoader:load:Unsupported Typ:" + typ);
		}
		return erg;
	}
	public BufferedImage loadByImage4j(File file)
	{
		BufferedImage erg = null;
		try
		{
			List<BufferedImage> images = ICODecoder.read(file);
			int n = images.size();
			Protokol.write("SimpleImageLoader:loadByImage4j: " + n + " Images");
			for (int i=0;i<n;i++)
			{
				erg = images.get(i);
			}
		}
		catch (Exception e)
		{
			Protokol.write("SimpleImageLoader:loadByImage4j:Exception:");
			Protokol.write(e.toString());
		}
		return erg;
	}
	public BufferedImage loadByImageIO(File file)
	{
		BufferedImage erg = null;
		try
		{
			erg = ImageIO.read(file);
		}
		catch (Exception e)
		{
			Protokol.write("SimpleImageLoader:loadByImageIO:Exception:");
			Protokol.write(e.toString());
		}
		return erg;
	}
}
