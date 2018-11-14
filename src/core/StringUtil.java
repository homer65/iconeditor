package core;
public class StringUtil 
{
	public static StringPaar parse(String satz)
	{
		StringPaar erg = null;
		satz = entkommentiere(satz);
		if (satz != null)
		{
			String key = "";
			String value = "";
			boolean ok = false;
			int l = satz.length();
			for (int i=0;i<l;i++)
			{
				String ch = satz.substring(i,i+1);
				if (ch.equals("="))
				{
					ok = true;
				}
				else
				{
					if (ok)
					{
						value += ch;
					}
					else
					{
						key += ch;
					}
				}
			}
			if (ok)
			{
				erg = new StringPaar();
				erg.setKey(key.trim());
				erg.setValue(value.trim());
			}
			else
			{
				erg = new StringPaar();
				erg.setKey(key.trim());
				erg.setValue(null);
			}
		}
		return erg;
	}
	public static String entkommentiere(String satz)
	{
		String erg = null;
		if (satz != null)
		{
			erg = "";
			int l = satz.length();
			for (int i=0;i<l;i++)
			{
				String ch = satz.substring(i,i+1);
				if (ch.equals("#")) break;
				else erg += ch;
			}
		}
		return erg;
	}
}
