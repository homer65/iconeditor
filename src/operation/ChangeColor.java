package operation;
import core.*;
import java.awt.*;
public class ChangeColor implements Operation
{
	private Pixel p = null;
	private Color c = null;
	public String getName()
	{
		return "ChangeColor";
	}
	public String getStatus()
	{
		int ip = 0;
		int ic = 0;
		if (p != null) ip++;
		if (c != null) ic++;
		String erg = ic + ":" + ip;
		return erg;
	}
	public Icon operate(Icon icon) 
	{
		Color pc = p.getColor();
		int width = icon.getSize().width;
		int height = icon.getSize().height;
		for (int i=0;i<width;i++)
		{
			for (int j=0;j<height;j++)
			{
				Pixel test = icon.getPixel(i,j);
				Color tc = test.getColor();
				if (distance(pc,tc) < Parameter.colorDistance)
				{
					test.setColor(c);
					icon.setPixel(test);
				}
			}
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
		p = null;
	}
	public boolean isReady() 
	{
		boolean erg = true;
		if (p == null) erg = false;
		if (c == null) erg = false;
		return erg;
	}
	public void pushColor(Color c) 
	{
		this.c = c;
	}
	public void pushPixel(Pixel p) 
	{
		this.p = p;
	}
	public Operation copy()
	{
		ChangeColor erg = new ChangeColor();
		erg.p = p.copy();
		erg.c = c;
		return erg;
	}

}
