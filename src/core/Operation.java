package core;
import java.awt.*;
public interface Operation 
{
	public void reset();
	public Icon operate(Icon icon);
	public boolean isReady();
	public void pushColor(Color c);
	public void pushPixel(Pixel p);
	public Operation copy();
	public String getName();
	public String getStatus();
}
