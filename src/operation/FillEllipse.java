package operation;
import core.*;
import java.awt.*;
public class FillEllipse implements Operation
{
	private Pixel f1 = null; // Brennpunkt (Focus) 1
	private Pixel f2 = null; // Brennpunkt (Focus) 2
	private Pixel r = null; // Randpunkt 
	private Color c = null;
	public String getName()
	{
		return "FillEllipse";
	}
	public String getStatus()
	{
		int ip = 0;
		int ic = 0;
		if (f1 != null) ip++;
		if (f2 != null) ip++;
		if (r != null) ip++;
		if (c != null) ic++;
		String erg = ic + ":" + ip;
		return erg;
	}
	public Icon operate(Icon icon) 
	{
		Protokol.write("FillEllipse:operate:start");
		int width = icon.getSize().width;
		int height = icon.getSize().height;
		double d1 = getDistance(r,f1);
		double d2 = getDistance(r,f2);
		double d = d1 + d2;
		for (int i=0;i<width;i++)
		{
			for (int j=0;j<height;j++)
			{
				Pixel p = icon.getPixel(i,j);
				double a1 = getDistance(p,f1);
				double a2 = getDistance(p,f2);
				double a = a1 + a2;
				if (a <= d)
				{
					p.setColor(c);
					icon.setPixel(p);
				}
			}
		}
		return icon;
	}
	public double getDistance(Pixel p1,Pixel p2)
	{
		int xp1 = p1.getX();
		int xp2 = p2.getX();
		int yp1 = p1.getY();
		int yp2 = p2.getY();
		int dq = (xp1-xp2) * (xp1-xp2) + (yp1-yp2) * (yp1-yp2);
		double erg = Math.sqrt(dq);
		return erg;
	}
	public void reset()
	{
		f1 = null;
		f2 = null;
		r = null;
	}
	public boolean isReady() 
	{
		boolean erg = true;
		if (f1 == null) erg = false;
		if (f2 == null) erg = false;
		if (r == null) erg = false;
		if (c == null) erg = false;
		return erg;
	}
	public void pushColor(Color c) 
	{
		this.c = c;
	}
	public void pushPixel(Pixel p) 
	{
		f2 = f1;
		f1 = r;
		r = p;
	}
	public Operation copy()
	{
		FillEllipse erg = new FillEllipse();
		erg.f1 = f1.copy();
		erg.f2 = f2.copy();
		erg.r = r.copy();
		erg.c = c;
		return erg;
	}

}
