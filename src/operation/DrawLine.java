package operation;
import core.*;
import java.awt.*;
public class DrawLine implements Operation
{
	private Pixel p1 = null;
	private Pixel p2 = null;
	private Color c = null;
	public String getName()
	{
		return "DrawLine";
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
		int dx = x2 - x1;
		int dy = y2 - y1;
		int adx = dx;
		int vdx = 1;
		if (adx < 0)
		{
			adx = -adx;
			vdx = -1;
		}
		int ady = dy;
		int vdy = 1;
		if (ady < 0)
		{
			ady = -ady;
			vdy = -1;
		}
		if (dx == 0)
		{
			int tx = x1;
			if (y1 > y2)
			{
				int y = y1;
				y1 = y2;
				y2 = y;
			}
			for (int iy=0;iy<ady+1;iy++)
			{
				int ty = y1 + iy;
				Pixel temp = icon.getPixel(tx,ty);
				temp.setColor(c);
				icon.setPixel(temp);
			}
		}
		else if (dy == 0)
		{
			int ty = y1;
			if (x1 > x2)
			{
				int x = x1;
				x1 = x2;
				x2 = x;
			}
			for (int ix=0;ix<adx+1;ix++)
			{
				int tx = x1 + ix;
				Pixel temp = icon.getPixel(tx,ty);
				temp.setColor(c);
				icon.setPixel(temp);
			}
		}
		else
		{
			double ddx = (double) dx;
			double ddy = (double) dy;
			if (adx > ady)
			{
				double s = ddy / ddx;
				for (int ix=0;ix<adx+1;ix++)
				{
					int tx = x1 + vdx * ix;
					double dty = y1 + s * vdx * ix;
					int ty = (int) Math.round(dty);
					Pixel temp = icon.getPixel(tx,ty);
					temp.setColor(c);
					icon.setPixel(temp);
				}
			}
			else
			{
				double s = ddx / ddy;
				for (int iy=0;iy<ady+1;iy++)
				{
					int ty = y1 + vdy * iy;
					double dtx = x1 + s * vdy * iy;
					int tx = (int) Math.round(dtx);
					Pixel temp = icon.getPixel(tx,ty);
					temp.setColor(c);
					icon.setPixel(temp);
				}
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
		DrawLine erg = new DrawLine();
		erg.p1 = p1.copy();
		erg.p2 = p2.copy();
		erg.c = c;
		return erg;
	}

}
