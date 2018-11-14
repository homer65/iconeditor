package test;
import core.*;
import operation.*;
public class StreckeTest 
{
	public static void main(String[] args)
	{
		Punkt tp = new Punkt(0,-1);
		Punkt p1 = new Punkt(1,0);
		Punkt p2 = new Punkt(1,256);
		Strecke strecke = new Strecke(tp,p1,p2);
		try
		{
			boolean wg = strecke.wirdGeschnitten();
			if (wg) Protokol.write("wird geschnitten");
			else Protokol.write("wird nicht geschnitten");
		}
		catch (Exception e)
		{
			Protokol.write(e.toString());
		}
		
	}
}
