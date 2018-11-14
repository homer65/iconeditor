package impl;
import java.awt.Dimension;
import core.*;
public class SimplestSizeChooser implements SizeChooser 
{
	public Dimension getSize() 
	{
		return new Dimension(16,16);
	}
}
