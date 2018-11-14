package core;
import javax.swing.*;
public abstract class StatusPanel extends JPanel 
{
	private static final long serialVersionUID = 1L;
	public abstract void clicked(Pixel pixel);
	public abstract void moved(Pixel pixel);
}
