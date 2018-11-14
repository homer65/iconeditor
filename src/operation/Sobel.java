package operation;
import core.*;
import java.awt.*;
public class Sobel implements Operation
{
	private double[][]K1 = new double[3][3];
	private double[][]K2 = new double[3][3];
	public Sobel()
	{
		K1[0][0] = -1.0;
		K1[0][1] = 0.0;
		K1[0][2] = +1.0;
		K1[1][0] = -2.0;
		K1[1][1] = 0.0;
		K1[1][2] = +2.0;
		K1[2][0] = -1.0;
		K1[2][1] = 0.0;
		K1[2][2] = +1.0;
		K2[0][0] = +1.0;
		K2[0][1] = +2.0;
		K2[0][2] = +1.0;
		K2[1][0] = 0.0;
		K2[1][1] = 0.0;
		K2[1][2] = 0.0;
		K2[2][0] = -1.0;
		K2[2][1] = -2.0;
		K2[2][2] = -1.0;
		for (int i=0;i<3;i++)
		{
			for (int j=0;j<3;j++)
			{
				K1[i][j] = K1[i][j] / 4.0;
				K2[i][j] = K2[i][j] / 4.0;
			}
		}
	}
	public String getName()
	{
		return "Sobel";
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
		Protokol.write("Sobel:operate:start");
		int width = icon.getSize().width;
		int height = icon.getSize().height;
		Icon erg = Factory.getIcon();
		erg.setSize(width,height);
		for (int i=0;i<width;i++)
		{
			for (int j=0;j<height;j++)
			{
				double s1r = 0.0;
				double s1g = 0.0;
				double s1b = 0.0;
				double s2r = 0.0;
				double s2g = 0.0;
				double s2b = 0.0;
				for (int n=0;n<3;n++)
				{
					for (int m=0;m<3;m++)
					{
						double k1 = K1[n][m];
						double k2 = K2[n][m];
						int ik = i+n-1;
						int jk = j+m-1;
						if (ik < 0) ik = 0;
						if (ik > width-1) ik = width-1;
						if (jk < 0) jk = 0;
						if (jk > height-1) jk = height-1;
						Pixel p = icon.getPixel(ik,jk);
						Color c = p.getColor();
						int r = c.getRed();
						double dr = (double) r;
						int g = c.getGreen();
						double dg = (double) g;
						int b = c.getBlue();
						double db = (double) b;
						s1r = s1r + dr * k1;
						s1g = s1g + dg * k1;
						s1b = s1b + db * k1;
						s2r = s2r + dr * k2;
						s2g = s2g + dg * k2;
						s2b = s2b + db * k2;
					}
				}
				Pixel q = Factory.getPixel();
				q.setX(i);
				q.setY(j);
				double dr = Math.sqrt(s1r*s1r + s2r*s2r);
				double dg = Math.sqrt(s1g*s1g + s2g*s2g);
				double db = Math.sqrt(s1b*s1b + s2b*s2b);
				int ir = (int) dr;
				int ig = (int) dg;
				int ib = (int) db;
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
		Sobel erg = new Sobel();
		return erg;
	}
}
