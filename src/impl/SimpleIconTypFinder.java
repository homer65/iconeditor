package impl;
import java.io.File;
import core.*;
public class SimpleIconTypFinder implements IconTypFinder
{
	public String getTyp(File file) 
	{
		String name = file.getAbsolutePath();
		int n = name.length();
		String erg = "";
		for (int i=0;i<n;i++)
		{
			String ch = name.substring(i,i+1);
			if (ch.equals("."))
			{
				erg = "";
			}
			else
			{
				erg += ch;
			}
		}
		erg = erg.toLowerCase();
		boolean typok = false;
		if (erg.equals("png")) typok = true;
		if (erg.equals("gif")) typok = true;
		if (erg.equals("jpg")) typok = true;
		if (erg.equals("jpeg")) typok = true;
		if (erg.equals("ico")) typok = true;
		if (!typok)
		{
			Typ typ = new Typ();
			TypDialog td = new TypDialog(typ);
			td.setModal(true);
			td.setVisible(true);
			erg = typ.getName();
		}
		return erg;
	}
}
