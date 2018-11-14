package operation;
public class Punkt 
{
	private int x = 0;
	private int y = 0;
	private boolean isTest = false;
	public Punkt(int x,int y)
	{
		this.x = x;
		this.y = y;
	}
	public void setTest()
	{
		isTest = true;
	}
	public double getX()
	{
		double erg = (double) x;
		if (isTest) erg = -3;
		return erg;
	}
	public double getY()
	{
		double erg = (double) y;
		if (isTest) erg = -Math.PI;
		return erg;
	}
	public static boolean xIstGleich(Punkt p1,Punkt p2)
	{
		boolean erg = false;
		if (p1.isTest & p2.isTest) erg = true;
		else if (p1.isTest) erg = false;
		else if (p2.isTest) erg = false;
		else if (p1.x == p2.x) erg = true;
		return erg;
	}
}
