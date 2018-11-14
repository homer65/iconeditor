package operation;
import core.*;
import math.*;
import java.awt.*;
import org.apache.commons.math3.complex.Complex;
public class FFTHighPass implements Operation
{
	private int n = 0;
	private int m = 0;
	private Complex[][] zr = null;
	private Complex[][] zg = null;
	private Complex[][] zb = null;
	public String getName()
	{
		return "FFTHighPass";
	}
	public String getStatus()
	{
		int ip = 0;
		int ic = 0;
		String erg = ic + ":" + ip;
		return erg;
	}
	public int getNextPower(int i)
	{
		int erg = 2;
		while (erg < i)
		{
			erg = 2 * erg;
		}
		return erg;
	}
	public Icon operate(Icon icon) 
	{
		Protokol.write("FFTHighPass:operate:start");
		long start = System.currentTimeMillis();
		double rmax = Parameter.rmax;
		int width = icon.getSize().width;
		int height = icon.getSize().height;
		n = width;
		m = height;
		int nn = getNextPower(n);
		int mm = getNextPower(m);
		double dnn = (double) nn;
		double dmm = (double) mm;
		dnn = 1.0 / dnn;
		dmm = 1.0 / dmm;
		System.out.println(nn + ":" + mm);
		zr = new Complex[nn][mm];
		zg = new Complex[nn][mm];
		zb = new Complex[nn][mm];
		for (int i=0;i<nn;i++)
		{
			for (int u=0;u<mm;u++)
			{
				zr[i][u] = new Complex(0.0,0.0);
				zg[i][u] = new Complex(0.0,0.0);
				zb[i][u] = new Complex(0.0,0.0);
			}
		}
		for (int i=0;i<n;i++)
		{
			for (int u=0;u<m;u++)
			{
				Pixel p = icon.getPixel(i,u);
				Color c = p.getColor();
				int r = c.getRed();
				int g = c.getGreen();
				int b = c.getBlue();
				double dr = (double) r;
				double dg = (double) g;
				double db = (double) b;
				zr[i][u] = new Complex(dr,0.0);
				zg[i][u] = new Complex(dg,0.0);
				zb[i][u] = new Complex(db,0.0);
			}
		}
		FFT2D.fft(zr);
		FFT2D.fft(zg);
		FFT2D.fft(zb);
		for (int i=0;i<nn;i++)
		{
			for (int u=0;u<mm;u++)
			{
				int xi = i-nn/2;
				int xu = u-mm/2;
				double di = (double) xi;
				double du = (double) xu;
				double dr1 = 2.0 * di * dnn;
				double dr2 = 2.0 * du * dmm;
				double dr = Math.sqrt((dr1*dr1 + dr2*dr2)/2.0);
				double h = 1.0;
				if (dr > rmax) h = 0.0;
				Complex zh = new Complex(h,0.0);
				zr[i][u] = zh.multiply(zr[i][u]);
				zg[i][u] = zh.multiply(zg[i][u]);
				zb[i][u] = zh.multiply(zb[i][u]);
			}
		}
		FFT2D.ifft(zr);
		FFT2D.ifft(zg);
		FFT2D.ifft(zb);
		Icon erg = Factory.getIcon();
		erg.setSize(width,height);
		for (int i=0;i<n;i++)
		{
			for (int u=0;u<m;u++)
			{
				Pixel q = Factory.getPixel();
				q.setX(i);
				q.setY(u);
				double qr = zr[i][u].getReal();
				double qg = zg[i][u].getReal();
				double qb = zb[i][u].getReal();
				int ir = (int) qr;
				int ig = (int) qg;
				int ib = (int) qb;
				if (ir < 0) ir = 0;
				if (ig < 0) ig = 0;
				if (ib < 0) ib = 0;
				if (ir > 255) ir = 255;
				if (ig > 255) ig = 255;
				if (ib > 255) ib = 255;
				Color qc = new Color(ir,ig,ib);
				q.setColor(qc);
				erg.setPixel(q);
			}
		}
		long ende = System.currentTimeMillis();
		long sekunden = (ende - start) / 1000;
		Protokol.write("FFTHighPass:operate:Es dauerte " + sekunden + " Sekunden");
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
		FFTHighPass erg = new FFTHighPass();
		return erg;
	}
}
