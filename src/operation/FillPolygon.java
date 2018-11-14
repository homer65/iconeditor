package operation;
import core.*;
import java.awt.*;
import java.util.*;
public class FillPolygon implements Operation
{
	private ArrayList<Pixel> alp = new ArrayList<Pixel>();
	private Color c = null;
	public String getName()
	{
		return "FillPolygon";
	}
	public String getStatus()
	{
		int ip = alp.size();
		int ic = 0;
		if (c != null) ic++;
		String erg = ic + ":" + ip;
		return erg;
	}
	public Icon operate(Icon icon) 
	{
		int width = icon.getSize().width;
		int height = icon.getSize().height;
		for (int i=0;i<width;i++)
		{
			for (int j=0;j<height;j++)
			{
				Pixel test = icon.getPixel(i,j);
				if (isInPolygon(test))
				{
					test.setColor(c);
					icon.setPixel(test);
				}
			}
		}
		return icon;
	}
	public void reset()
	{
		alp = new ArrayList<Pixel>();
		c = null;
	}
	public boolean isReady() 
	{
		boolean erg = true;
		if (c == null) erg = false;
		return erg;
	}
	public void pushColor(Color c) 
	{
		if (alp.size() > 2)
		{
			this.c = c;
			Protokol.write("FillPolygon:pushColor" + c);
		}
	}
	public void pushPixel(Pixel p) 
	{
		alp.add(p);		
		Protokol.write("FillPolygon:pushPixel" + p);
	}
	public Operation copy()
	{
		FillPolygon erg = new FillPolygon();
		erg.c = c;
		erg.alp = new ArrayList<Pixel>();
		for (int i=0;i<alp.size();i++)
		{
			Pixel p = alp.get(i);
			erg.alp.add(p.copy());
		}
		return erg;
	}
	public boolean isInPolygon(Pixel p)
	{
		boolean erg = false;
		int x = p.getX();
		int y = p.getY();
		Punkt tp = new Punkt(x,y);
		for (int i=0;i<alp.size();i++)
		{
			int j = i + 1;
			if (j == alp.size()) j = 0;
			Pixel p1 = alp.get(i);
			Pixel p2 = alp.get(j);
			int x1 = p1.getX();
			int x2 = p2.getX();
			int y1 = p1.getY();
			int y2 = p2.getY();
			Punkt pu1 = new Punkt(x1,y1);
			Punkt pu2 = new Punkt(x2,y2);
			Strecke st = new Strecke(tp,pu1,pu2);
			try
			{
				if (st.wirdGeschnitten())
				{
					//Protokol.write("FillPolygon:isInPolygon:wirdGeschnitten:");
					//Protokol.write(p.toString());
					if (erg) erg = false;
					else erg = true;
				}
			}
			catch (Exception e)
			{
				Protokol.write("FillPolygon:isInPolygon:Exception:");
				Protokol.write(e.toString());
			}
		}
		return erg;
	}
}
