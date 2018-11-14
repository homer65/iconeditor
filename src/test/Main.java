package test;
import core.*;
import gui.*;
public class Main 
{
	public static void main(String[] args)
	{
		Initialisierung ini = Factory.getInitialisierung();
		ini.start();
		IconEditor tm = new IconEditor();
		tm.anzeigen();
	}
}

