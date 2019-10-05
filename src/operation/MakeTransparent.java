package operation;
import core.*;
import java.awt.*;
public class MakeTransparent implements Operation
{
	private Pixel p = null;
	public String getName()
	{
		return "MakeTransparent";
	}
	public String getStatus()
	{
		int ip = 0;
		if (p != null) ip++;
		String erg = ":" + ip;
		return erg;
	}
	public Icon operate(Icon icon) 
	{
		Color pc = p.getColor();
		int pr = pc.getGreen();
		int pg = pc.getGreen();
		int pb = pc.getBlue();
		int pa = Parameter.transparency;
		Color nc = new Color(pr,pg,pb,pa);
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
					test.setColor(nc);
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
		return erg;
	}
	public void pushColor(Color c) 
	{

	}
	public void pushPixel(Pixel p) 
	{
		this.p = p;
	}
	public Operation copy()
	{
		MakeTransparent erg = new MakeTransparent();
		erg.p = p.copy();
		return erg;
	}

}
