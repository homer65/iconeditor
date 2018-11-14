package operation;
import core.*;
import java.awt.*;
public class FillBox implements Operation
{
	private Pixel p1 = null;
	private Pixel p2 = null;
	private Color c = null;
	public String getName()
	{
		return "FillBox";
	}
	public String getStatus()
	{
		int ip = 0;
		int ic = 0;
		if (p1 != null) ip++;
		if (p2 != null) ip++;
		if (c != null) ic++;
		String erg = ic + ":" + ip;
		return erg;
	}
	public Icon operate(Icon icon) 
	{
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
		for (int ix=0;ix<dx;ix++)
		{
			for (int iy=0;iy<dy;iy++)
			{
				int tx = x1 + ix;
				int ty = y1 + iy;
				Pixel temp = icon.getPixel(tx,ty);
				temp.setColor(c);
				icon.setPixel(temp);
			}
		}
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
		if (c == null) erg = false;
		return erg;
	}
	public void pushColor(Color c) 
	{
		this.c = c;
	}
	public void pushPixel(Pixel p) 
	{
		p2 = p1;
		p1 = p;		
	}
	public Operation copy()
	{
		FillBox erg = new FillBox();
		erg.p1 = p1.copy();
		erg.p2 = p2.copy();
		erg.c = c;
		return erg;
	}

}
