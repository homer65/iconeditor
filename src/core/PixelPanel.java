package core;
import javax.swing.*;
public abstract class PixelPanel extends JPanel 
{
	private static final long serialVersionUID = 1L;
	public abstract void setSize(int i);
	public abstract void setPixel(Pixel p);
	public abstract Pixel getPixel();
	public abstract void addListener(PixelListener ppl);
	public abstract void removeListener(PixelListener ppl);
}
