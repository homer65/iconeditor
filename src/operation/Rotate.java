package operation;
import core.*;
import java.awt.*;
public class Rotate implements Operation
{
	public String getName()
	{
		return "Rotate";
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
		Protokol.write("Rotate:operate:start");
		int width = icon.getSize().width;
		int height = icon.getSize().height;
		Icon erg = Factory.getIcon();
		erg.setSize(height,width);
		for (int i=0;i<width;i++)
		{
			for (int j=0;j<height;j++)
			{
				Pixel p = icon.getPixel(i,j);
				Pixel q = Factory.getPixel();
				q.setX(height - j - 1);
				q.setY(i);
				q.setColor(p.getColor());
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
		Rotate erg = new Rotate();
		return erg;
	}

}
