package core;
import java.awt.Color;
import java.awt.image.BufferedImage;
public interface TextImage 
{
	public void setText(String text,int size,Color color);
	public BufferedImage getImage();
	public int getTextWidth();
	public int getTextHeight();
}
