package operation;
import core.*;
public class Strecke 
{
	private Punkt tp = null;
	private Punkt p1 = null;
	private Punkt p2 = null;
	private Punkt bp = new Punkt(-3,-3);
	public Strecke(Punkt tp,Punkt p1,Punkt p2)
	{
		bp.setTest();
		this.tp = tp;
		this.p1 = p1;
		this.p2 = p2;
	}
	public boolean wirdGeschnitten() throws Exception
	{
		boolean erg = true;
		//
		double x1 = bp.getX();
		double y1 = bp.getY();
		double x2 = tp.getX() + 0.0005;
		double y2 = tp.getY() + 0.0005;
		double a = (y1 - y2) / (x1 - x2);
		double b = ((y1*x2) - (y2*x1)) / (x2 - x1);
		//
		double p1x = p1.getX();
		double p1y = p1.getY();
		double p2x = p2.getX();
		double p2y = p2.getY();
		//
		if (Punkt.xIstGleich(p1,p2))
		{
			double y_von_p1 = (a*p1x) + b;
			if ((y_von_p1 <= p1y) & (y_von_p1 <= p2y)) erg = false;
			if ((y_von_p1 >= p1y) & (y_von_p1 >= p2y)) erg = false;
			if (erg)
			{
				if (p1x >= x2) erg = false; 
			}
		}
		else
		{
			double c = (p2y - p1y) / (p2x - p1x);
			double d = ((p1y*p2x) - (p2y*p1x)) / (p2x - p1x);
			try
			{
				double xs = (d - b) / (a - c);
				boolean on1 = false;;
				if ((x1 < xs) & (x2 > xs)) on1 = true;
				if ((x1 > xs) & (x2 < xs)) on1 = true;
				boolean on2 = false;
				if ((p1x < xs) & (p2x > xs)) on2 = true;
				if ((p1x > xs) & (p2x < xs)) on2 = true;
				if (!on1) erg = false;
				if (!on2) erg = false;
			}
			catch (Exception e)
			{
				Protokol.write("Strecke:wirdGeschnitten:Exception:");
				Protokol.write(e.toString());
			}
		}
		return erg;
	}
}
