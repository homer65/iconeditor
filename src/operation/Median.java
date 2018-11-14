package operation;
import core.*;
import java.awt.*;
import java.util.Arrays;
public class Median implements Operation
{
	private int[] tr = new int[9];
	private int[] tg = new int[9];
	private int[] tb = new int[9];
	public String getName()
	{
		return "Median";
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
		Protokol.write("Median:operate:start");
		int width = icon.getSize().width;
		int height = icon.getSize().height;
		Icon erg = Factory.getIcon();
		erg.setSize(width,height);
		for (int i=0;i<width;i++)
		{
			for (int j=0;j<height;j++)
			{
				for (int n=0;n<3;n++)
				{
					for (int m=0;m<3;m++)
					{
						int ik = i+n-1;
						int jk = j+m-1;
						if (ik < 0) ik = 0;
						if (ik > width-1) ik = width-1;
						if (jk < 0) jk = 0;
						if (jk > height-1) jk = height-1;
						Pixel p = icon.getPixel(ik,jk);
						Color c = p.getColor();
						int r = c.getRed();
						int g = c.getGreen();
						int b = c.getBlue();
						tr[n+3*m] = r;
						tg[n+3*m] = g;
						tb[n+3*m] = b;
					}
				}
				Pixel q = Factory.getPixel();
				q.setX(i);
				q.setY(j);
				int ir = getMedian(tr);
				int ig = getMedian(tg);
				int ib = getMedian(tb);
				if (ir < 0) ir = 0;
				if (ig < 0) ig = 0;
				if (ib < 0) ib = 0;
				if (ir > 255) ir = 255;
				if (ig > 255) ig = 255;
				if (ib > 255) ib = 255;
				Color ic = new Color(ir,ig,ib);
				q.setColor(ic);
				erg.setPixel(q);
			}
		}
		return erg;
	}
	public int getMedian(int[] t)
	{
		Arrays.sort(t);
		int erg = t[4];
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
		Median erg = new Median();
		return erg;
	}
}
