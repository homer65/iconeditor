package operation;
import core.*;
import gui.*;
import java.awt.*;
public class Lupe implements Operation,IconListener
{
	private int dx = 0;
	private int dy = 0;
	private int x1 = 0;
	private int y1 = 0;
	private Pixel p1 = null;
	private Pixel p2 = null;
	private Icon temp = Factory.getIcon();
	private Icon icon = null;
	public String getName()
	{
		return "Lupe";
	}
	public String getStatus()
	{
		int ip = 0;
		int ic = 0;
		if (p1 != null) ip++;
		if (p2 != null) ip++;
		String erg = ic + ":" + ip;
		return erg;
	}
	public Icon operate(Icon icon) 
	{
		Protokol.write("Lupe:operate:gestartet");
		this.icon = icon;
		x1 = p1.getX();
		y1 = p1.getY();
		int x2 = p2.getX();
		int y2 = p2.getY();
		if (x1 > x2) 
		{
			int x = x1;
			x1 = x2;
			x2 = x;
		}
		if (y1 > y2)
		{
			int y = y1;
			y1 = y2;
			y2 = y;
		}
		dx = x2 - x1 + 1;
		dy = y2 - y1 + 1;
		temp = Factory.getIcon();
		temp.setSize(dx,dy);
		for (int ix=0;ix<dx;ix++)
		{
			for (int iy=0;iy<dy;iy++)
			{
				int tx = x1 + ix;
				int ty = y1 + iy;
				Pixel tp = icon.getPixel(tx,ty);
				tp.setX(ix);
				tp.setY(iy);
				temp.setPixel(tp);
			}
		}
		IconEditor ie = new IconEditor();
		ie.addIconListener(this);
		ie.setIcon(temp);
		ie.anzeigen();
		Protokol.write("Lupe:operate:beendet");
		return icon;
	}
	public void reset()
	{
		p1 = null;
		p2 = null;
	}
	public boolean isReady() 
	{
		boolean erg = true;
		if (p1 == null) erg = false;
		if (p2 == null) erg = false;
		return erg;
	}
	public void pushColor(Color c) 
	{
		
	}
	public void pushPixel(Pixel p) 
	{
		p2 = p1;
		p1 = p;		
	}
	public Operation copy()
	{
		Lupe erg = new Lupe();
		erg.p1 = p1.copy();
		erg.p2 = p2.copy();
		return erg;
	}
	@Override
	public void done(Icon cicon) 
	{
		Protokol.write("Lupe:done:gestartet");
		temp = cicon.copy();	
		try
		{
			if (temp != null)
			{
				IconResizer ir = Factory.getIconResizer();
				temp = ir.resize(temp,dx,dy);
				for (int ix=0;ix<dx;ix++)
				{
					for (int iy=0;iy<dy;iy++)
					{
						int tx = x1 + ix;
						int ty = y1 + iy;
						Pixel tp = temp.getPixel(ix,iy);
						tp.setX(tx);
						tp.setY(ty);
						Color c = tp.getColor();
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
							icon.setPixel(tp);
						}
					}
				}
			}
		}
		catch (Exception e)
		{
			Protokol.write("Lupe:done:Exception:");
			Protokol.write(e.toString());
		}
	}
}
