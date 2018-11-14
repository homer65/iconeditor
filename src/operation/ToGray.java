package operation;
import core.*;
import java.awt.*;
public class ToGray implements Operation
{
	public String getName()
	{
		return "ToGray";
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
		Protokol.write("ToGray:operate:start");
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
				q.setColor(toGray(p.getColor()));
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
		ToGray erg = new ToGray();
		return erg;
	}
	private Color toGray(Color c)
	{
		int r = c.getRed();
		int g = c.getGreen();
		int b = c.getBlue();	
		int m = (r+g+b)/3;
		Color erg = new Color(m,m,m);
		return erg;
	}
}
