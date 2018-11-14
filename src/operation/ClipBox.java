package operation;
import core.*;
import java.awt.*;
public class ClipBox implements Operation
{
	private Pixel p1 = null;
	private Pixel p2 = null;
	public String getName()
	{
		return "ClipBox";
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
		Protokol.write("ClipBox:operate:gestartet");
		Icon erg = Factory.getIcon();
		int x1 = p1.getX();
		int y1 = p1.getY();
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
		int dx = x2 - x1 + 1;
		int dy = y2 - y1 + 1;
		erg.setSize(dx,dy);
		Protokol.write("ClipBox:operate:x1:" + x1 + ":y1:" + y1);
		Protokol.write("ClipBox:operate:dx:" + dx + ":dy:" + dy);
		for (int ix=0;ix<dx;ix++)
		{
			for (int iy=0;iy<dy;iy++)
			{
				int tx = x1 + ix;
				int ty = y1 + iy;
				Pixel temp = icon.getPixel(tx,ty);
				temp.setX(ix);
				temp.setY(iy);
				erg.setPixel(temp);
			}
		}
		return erg;
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
		ClipBox erg = new ClipBox();
		erg.p1 = p1.copy();
		erg.p2 = p2.copy();
		return erg;
	}

}
