package operation;
import core.*;
import java.awt.*;
public class ShiftIcon implements Operation
{
	private Pixel p1 = null;
	public String getName()
	{
		return "ShiftIcon";
	}
	public String getStatus()
	{
		int ip = 0;
		int ic = 0;
		if (p1 != null) ip++;
		String erg = ic + ":" + ip;
		return erg;
	}
	public Icon operate(Icon icon) 
	{
		int dx = p1.getX();
		int dy = p1.getY();
		int width = icon.getSize().width;
		int height = icon.getSize().height;
		Icon erg = Factory.getIcon();
		erg.setSize(width,height);
		for (int i=0;i<width;i++)
		{
			for (int j=0;j<height;j++)
			{
				int nx = i + dx;
				if (nx >= width) nx = nx - width;
				int ny = j + dy;
				if (ny >= height) ny = ny - height;
				Pixel p = icon.getPixel(nx,ny);
				Pixel np = p.copy();
				np.setX(i);
				np.setY(j);
				erg.setPixel(np);
			}
		}
		return erg;
	}
	public void reset()
	{
		p1 = null;
	}
	public boolean isReady() 
	{
		boolean erg = true;
		if (p1 == null) erg = false;
		return erg;
	}
	public void pushColor(Color c) 
	{
		
	}
	public void pushPixel(Pixel p) 
	{
		p1 = p;		
	}
	public Operation copy()
	{
		ShiftIcon erg = new ShiftIcon();
		erg.p1 = p1.copy();
		return erg;
	}
}
