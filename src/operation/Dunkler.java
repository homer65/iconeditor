package operation;
import core.*;
import java.awt.*;
public class Dunkler implements Operation
{
	public String getName()
	{
		return "Dunkler";
	}
	public String getStatus()
	{
		int ip = 0;
		int ic = 0;
		String erg = ic + ":" + ip;
		return erg;
	}
	public Icon operate(Icon icon) 
	{
		Protokol.write("Dunkler:operate:start");
		int width = icon.getSize().width;
		int height = icon.getSize().height;
		Icon erg = Factory.getIcon();
		erg.setSize(width,height);
		for (int i=0;i<width;i++)
		{
			for (int j=0;j<height;j++)
			{
				Pixel p = icon.getPixel(i,j);
				Pixel q = Factory.getPixel();
				q.setX(i);
				q.setY(j);
				q.setColor(heller(p.getColor()));
				erg.setPixel(q);
			}
		}
		return erg;
	}
	public void reset()
	{

	}
	public boolean isReady() 
	{
		boolean erg = true;
		return erg;
	}
	public void pushColor(Color c) 
	{

	}
	public void pushPixel(Pixel p) 
	{
	
	}
	public Operation copy()
	{
		Dunkler erg = new Dunkler();
		return erg;
	}
	private Color heller(Color c)
	{
		int r = heller(c.getRed());
		int g = heller(c.getGreen());
		int b = heller(c.getBlue());		
		Color erg = new Color(r,g,b);
		return erg;
	}
	private int heller(int i)
	{
		int di = 21;
		int erg = 0;
		if (i < 0)
		{
			erg = 0;
		}
		else
		{
			if (i > 255)
			{
				erg = 255;
			}
			else
			{
				erg = i - di;
				if (erg < 0) erg = 0;
			}
		}
		return erg;
	}

}
