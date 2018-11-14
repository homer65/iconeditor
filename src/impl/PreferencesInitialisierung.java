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
				Parameter.minIconWidth = new Integer(s).intValue();
			}
			s = prefs.get("iconeditor_maxiconwidth",null);
			if (s != null)
			{
				Parameter.maxIconWidth = new Integer(s).intValue();
			}
			s = prefs.get("iconeditor_miniconheight",null);
			if (s != null)
			{
				Parameter.minIconHeight = new Integer(s).intValue();
			}
			s = prefs.get("iconeditor_maxiconheight",null);
			if (s != null)
			{
				 Parameter.maxIconHeight = new Integer(s).intValue();
			}
			s = prefs.get("iconeditor_iconpanelsize",null);
			if (s != null)
			{
				Parameter.iconPanelSize = new Integer(s).intValue();
			}
			s = prefs.get("iconeditor_colordistance",null);
			if (s != null)
			{
				Parameter.colorDistance = new Integer(s).intValue();
			}
			s = prefs.get("iconeditor_gain",null);
			if (s != null)
			{
				Parameter.gain = new Double(s).doubleValue();
			}
			s = prefs.get("iconeditor_bias",null);
			if (s != null)
			{
				Parameter.bias = new Double(s).doubleValue();
			}
			s = prefs.get("iconeditor_rmax",null);
			if (s != null)
			{
				Parameter.rmax = new Double(s).doubleValue();
			}
			s = prefs.get("iconeditor_rmin",null);
			if (s != null)
			{
				Parameter.rmin = new Double(s).doubleValue();
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
