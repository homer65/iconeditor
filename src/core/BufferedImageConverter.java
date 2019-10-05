package core;
import java.awt.image.BufferedImage;
public interface BufferedImageConverter 
{
	// Erzeugt aus eineem BufferedImage eines vom Typ ARB
	public BufferedImage convert(BufferedImage img);
}
