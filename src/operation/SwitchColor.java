package operation;
import core.*;
import java.awt.*;
import java.util.*;
public class SwitchColor implements Operation
{
	private Pixel p1 = null;
	private Pixel p2 = null;
	public String getName()
	{
		return "SwitchColor";
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
		Color c1 = p1.getColor();
		Color c2 = p2.getColor();
		ArrayList<Pixel> al1 = new ArrayList<Pixel>();
		ArrayList<Pixel> al2 = new ArrayList<Pixel>();
		int width = icon.getSize().width;
		int height = icon.getSize().height;
		for (int i=0;i<width;i++)
		{
			for (int j=0;j<height;j++)
			{
				Pixel test = icon.getPixel(i,j);
				Color tc = test.getColor();
				if (distance(c1,tc) < Parameter.colorDistance)
				{
					al1.add(test);
				}
				if (distance(c2,tc) < Parameter.colorDistance)
				{
					al2.add(test);
				}
			}
		}
		for (int i=0;i<al1.size();i++)
		{
			Pixel p = al1.get(i);
			p.setColor(c2);
			icon.setPixel(p);
		}
		for (int i=0;i<al2.size();i++)
		{
			Pixel p = al2.get(i);
			p.setColor(c1);
			icon.setPixel(p);
		}
		return icon;
	}
	public int distance(Color c1,Color c2)
	{
		int r1 = c1.getRed();
		int r2 = c2.getRed();
		int g1 = c1.getGreen();
		int g2 = c2.getGreen();
		int b1 = c1.getBlue();
		int b2 = c2.getBlue();
		int erg = ((r1-r2)*(r1-r2)) + ((g1-g2)*(g1-g2)) + ((b1-b2)*(b1-b2));
		// Protokol.write("ChangeColor:distance:" + erg);
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
		SwitchColor erg = new SwitchColor();
		erg.p1 = p1.copy();
		erg.p2 = p2.copy();
		return erg;
	}

}
