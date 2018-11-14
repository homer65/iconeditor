package test;
import gui.Menu;
import java.awt.*;
import core.*;
public class ColorPanelTest extends Menu implements ColorListener
{
	private static final long serialVersionUID = 1L;
	private ColorPanel cp = Factory.getColorPanel();
	public ColorPanelTest()
	{
		super("ColorPanelTest");
		setContentPane(cp);
		cp.addColorListener(this);
	}
	public void newColor(Color c) 
	{
		Protokol.write(c.toString());
	}
}
