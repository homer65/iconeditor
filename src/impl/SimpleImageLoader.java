package impl;
import net.sf.image4j.codec.ico.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataFormat;
import javax.imageio.stream.ImageInputStream;
import javax.swing.JOptionPane;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

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
				Protokol.write("SimpleImageLoader:write:" + typ);
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
			readAndDisplayMetadata(file);
		}
		catch (Exception e)
		{
			Protokol.write("SimpleImageLoader:loadByImageIO:Exception:");
			Protokol.write(e.toString());
		}
		return erg;
	}
	private void readAndDisplayMetadata(File file) 
	{
        try 
        {
            ImageInputStream iis = ImageIO.createImageInputStream(file);
            Iterator<ImageReader> readers = ImageIO.getImageReaders(iis);
            if (readers.hasNext()) 
            {
                ImageReader reader = readers.next();
                reader.setInput(iis, true);
                IIOMetadata metadata = reader.getImageMetadata(0);
                String[] names = metadata.getMetadataFormatNames();
                int length = names.length;
                for (int i = 0; i < length; i++) 
                {
                    System.out.println( "Format name: " + names[ i ] );
                    displayMetadata(metadata.getAsTree(names[i]));
                }
            }
        }
        catch (Exception e) {

            e.printStackTrace();
        }
    }
	private void indent(int level) 
	{
        for (int i = 0; i < level; i++) System.out.print("    ");
    }
	private void displayMetadata(Node node)
	{
		displayMetadata(node,0);
	}
    private void displayMetadata(Node node,int level) 
    {
        indent(level);
        System.out.print("<" + node.getNodeName());
        NamedNodeMap map = node.getAttributes();
        if (map != null) 
        {
            int length = map.getLength();
            for (int i = 0; i < length; i++)
            {
                Node attr = map.item(i);
                System.out.print(" " + attr.getNodeName() +
                                 "=\"" + attr.getNodeValue() + "\"");
            }
        }
        Node child = node.getFirstChild();
        if (child == null)
        {
            System.out.println("/>");
            return;
        }
        System.out.println(">");
        while (child != null) 
        {
            displayMetadata(child, level + 1);
            child = child.getNextSibling();
        }
        indent(level);
        System.out.println("</" + node.getNodeName() + ">");
    }
}
