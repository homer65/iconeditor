package impl;
import java.awt.Dimension;
import core.*;
public class SimpleSizeChooser implements SizeChooser
{
	private Dimension erg = new Dimension(0,0);
	public Dimension getSize() 
	{
		SizeDialog sd = new SizeDialog(erg);
		sd.setModal(true);
		sd.setVisible(true);
		return erg;
	}
}
