package operation;
import core.Icon;
import core.Pixel;
import core.Operation;
import core.Protokol;
import core.Parameter;
import core.Factory;
import core.TextImage;
import java.awt.*;
import java.awt.image.BufferedImage;
public class InsertText implements Operation
{
	private Color c = null;
	private Pixel p1 = null;
	private Icon insert = null;
	public String getName()
	{
		return "InsertText";
	}
	public String getStatus()
	{
		int ip = 0;
		int ic = 0;
		if (p1 != null) ip++;
		if (c != null) ic++;
		String erg =  ic + ":" + ip;
		return erg;
	}
	public Icon operate(Icon icon) 
	{
		TextImage ti = Factory.getTextImage();
		int n = 0;
		try 
		{
			n = new Integer(Parameter.textsize).intValue();
		}
		catch (Exception e)
		{
			Protokol.write("InsertText:operate:textize not numeric:" + Parameter.textsize);
		}
		ti.setText(Parameter.text,n,c);
		BufferedImage bi = ti.getImage();
		int tw = ti.getTextWidth();
		int th = ti.getTextHeight();
		int w = bi.getWidth();
		int h = bi.getHeight();
		Protokol.write("InsertText:operate:Metrics:");
		Protokol.write("tw:" + tw + ":w:" + w + ":th:" + th + ":h:" + h);
		insert = Factory.getIcon();
		insert.buildFromImage(bi);
		int x1 = p1.getX();
		int y1 = p1.getY();
		if (insert != null)
		{
			int dx = insert.getSize().width;
			int dy = insert.getSize().height;
			int rx = icon.getSize().width;
			int ry = icon.getSize().height;
			for (int ix=0;ix<dx;ix++)
			{
				for (int iy=0;iy<dy;iy++)
				{
					int tx = x1 + ix;
					int ty = y1 + iy;
					Pixel temp = insert.getPixel(ix,iy);
					if (tx < rx)
					{
						if (ty < ry)
						{
							temp.setX(tx);
							temp.setY(ty);
							Color c = temp.getColor();
							int r = c.getRed();
							int g = c.getGreen();
							int b = c.getBlue();
							boolean use = true;
							if (r == 0)
							{
								if (g == 0)
								{
									if (b == 0)
									{
										use = false;
									}
								}
							}
							if (use)
							{
								icon.setPixel(temp);
							}
						}
					}
				}
			}
		}
		else
		{
			Protokol.write("InsertImage:operate:Kein Icon zum inserten");
		}
		return icon;
	}
	public void reset()
	{
		p1 = null;
		c = null;
	}
	public boolean isReady() 
	{
		boolean erg = true;
		if (p1 == null) erg = false;
		if (c == null) erg = false;
		return erg;
	}
	public void pushColor(Color c) 
	{
		this.c = c;
	}
	public void pushPixel(Pixel p) 
	{
		p1 = p;	
	}
	public Operation copy()
	{
		InsertText erg = new InsertText();
		erg.p1 = p1.copy();
		if (insert != null)
		{	
			erg.insert = insert.copy();
		}
		return erg;
	}

}
