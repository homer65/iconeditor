package impl;
import java.util.prefs.Preferences;
import core.*;
public class PreferencesInitialisierung implements Initialisierung
{
	private Preferences prefs = Preferences.userRoot();
	public void start()
	{
		Protokol.write("PreferencesInitialisierung:start:" + Parameter.version);
		try
		{
			String s = prefs.get("iconeditor_miniconwidth",null);
			if (s != null)
			{
				Parameter.minIconWidth = Integer.parseInt(s);
			}
			s = prefs.get("iconeditor_maxiconwidth",null);
			if (s != null)
			{
				Parameter.maxIconWidth = Integer.parseInt(s);
			}
			s = prefs.get("iconeditor_miniconheight",null);
			if (s != null)
			{
				Parameter.minIconHeight = Integer.parseInt(s);
			}
			s = prefs.get("iconeditor_maxiconheight",null);
			if (s != null)
			{
				 Parameter.maxIconHeight = Integer.parseInt(s);
			}
			s = prefs.get("iconeditor_iconpanelsize",null);
			if (s != null)
			{
				Parameter.iconPanelSize = Integer.parseInt(s);
			}
			s = prefs.get("iconeditor_colordistance",null);
			if (s != null)
			{
				Parameter.colorDistance = Integer.parseInt(s);
			}
			s = prefs.get("iconeditor_gain",null);
			if (s != null)
			{
				Parameter.gain = Double.parseDouble(s);
			}
			s = prefs.get("iconeditor_bias",null);
			if (s != null)
			{
				Parameter.bias = Double.parseDouble(s);
			}
			s = prefs.get("iconeditor_rmax",null);
			if (s != null)
			{
				Parameter.rmax = Double.parseDouble(s);
			}
			s = prefs.get("iconeditor_rmin",null);
			if (s != null)
			{
				Parameter.rmin = Double.parseDouble(s);
			}
			s = prefs.get("iconeditor_transparency",null);
			if (s != null)
			{
				Parameter.transparency = Integer.parseInt(s);
			}
		}
		catch (Exception e)
		{
			Protokol.write("PreferencesInitialisierung:start:Exception:");
			Protokol.write(e.toString());
		}
		return;
	}
}
