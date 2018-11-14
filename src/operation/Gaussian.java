package operation;
import core.*;
import java.awt.*;
public class Gaussian implements Operation
{
	private double[][]K = new double[5][5];
	public Gaussian()
	{
		K[0][0] = 1.0;
		K[0][1] = 4.0;
		K[0][2] = 7.0;
		K[0][3] = 4.0;
		K[0][4] = 1.0;
		K[1][0] = 4.0;
		K[1][1] = 16.0;
		K[1][2] = 28.0;
		K[1][3] = 16.0;
		K[1][4] = 4.0;
		K[2][0] = 7.0;
		K[2][1] = 28.0;
		K[2][2] = 49.0;
		K[2][3] = 28.0;
		K[2][4] = 7.0;
		K[3][0] = 4.0;
		K[3][1] = 16.0;
		K[3][2] = 28.0;
		K[3][3] = 16.0;
		K[3][4] = 4.0;
		K[4][0] = 1.0;
		K[4][1] = 4.0;
		K[4][2] = 7.0;
		K[4][3] = 4.0;
		K[4][4] = 1.0;
		for (int i=0;i<5;i++)
		{
			for (int j=0;j<5;j++)
			{
				K[i][j] = K[i][j] / (17.0 * 17.0);
			}
		}
	}
	public String getName()
	{
		return "Gaussian";
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
		Protokol.write("Gaussian:operate:start");
		int width = icon.getSize().width;
		int height = icon.getSize().height;
		Icon erg = Factory.getIcon();
		erg.setSize(width,height);
		for (int i=0;i<width;i++)
		{
			for (int j=0;j<height;j++)
			{
				double sr = 0.0;
				double sg = 0.0;
				double sb = 0.0;
				for (int n=0;n<5;n++)
				{
					for (int m=0;m<5;m++)
					{
						double k = K[n][m];
						int ik = i+n-2;
						int jk = j+m-2;
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
						sr = sr + dr * k;
						sg = sg + dg * k;
						sb = sb + db * k;
					}
				}
				Pixel q = Factory.getPixel();
				q.setX(i);
				q.setY(j);
				int ir = (int) sr;
				int ig = (int) sg;
				int ib = (int) sb;
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
		Gaussian erg = new Gaussian();
		return erg;
	}
}
