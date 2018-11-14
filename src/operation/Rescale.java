package operation;
import core.*;
import java.awt.*;
public class Rescale implements Operation
{
	public String getName()
	{
		return "Rescale";
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
		Protokol.write("Rescale:operate:start");
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
				q.setColor(rescale(p.getColor()));
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
		Rescale erg = new Rescale();
		return erg;
	}
	private Color rescale(Color c)
	{
		int r = rescale(c.getRed());
		int g = rescale(c.getGreen());
		int b = rescale(c.getBlue());		
		Color erg = new Color(r,g,b);
		return erg;
	}
	private int rescale(int i)
	{
		double di = (double) i;
		double de = Parameter.gain * di + Parameter.bias;
		int erg = (int) de;
		if (erg < 0)
		{
			erg = 0;
		}
		else
		{
			if (erg > 255)
			{
				erg = 255;
			}
		}
		return erg;
	}
}
