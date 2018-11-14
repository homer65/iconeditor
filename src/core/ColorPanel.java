package core;
import java.awt.*;
import javax.swing.*;
public abstract class ColorPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	public abstract void setColor(Color c);
	public abstract Color getColor();
	public abstract void addColorListener(ColorListener listener);
	public abstract void removeColorListener(ColorListener listener);
}
