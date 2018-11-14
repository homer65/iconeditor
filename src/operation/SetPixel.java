package operation;
import core.*;
import java.awt.*;
public class SetPixel implements Operation
{
	private Pixel pixel = null;
	private Color c = null;
	public String getName()
	{
		return "SetPixel";
	}
	public String getStatus()
	{
		int ip = 0;
		int ic = 0;
		if (pixel != null) ip++;
		if (c != null) ic++;
		String erg = ic + ":" + ip;
		return erg;
	}
	public Icon operate(Icon icon) 
	{
		if (pixel == null) Protokol.write("SetPixel:operate:pixel is null");
		if (c == null) Protokol.write("SetPixel:operate:c is null");
		pixel.setColor(c);
		icon.setPixel(pixel);
		return icon;
	}
	public void reset()
	{
		pixel = null;
	}
	public boolean isReady() 
	{
		boolean erg = true;
		if (pixel == null) erg = false;
		if (c == null) erg = false;
		return erg;
	}
	public void pushColor(Color c) 
	{
		this.c = c;
	}
	public void pushPixel(Pixel p) 
	{
		this.pixel = p;		
	}
	public Operation copy()
	{
		SetPixel erg = new SetPixel();
		erg.pixel = pixel.copy();
		erg.c = c;
		return erg;
	}

}
