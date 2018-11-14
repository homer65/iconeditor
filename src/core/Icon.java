package core;
import java.io.*;
import java.awt.*;
import java.awt.image.*;
public interface Icon 
{
	public void setSize(int width,int height);
	public Dimension getSize();
	public void buildRandom();
	public void buildFromImage(BufferedImage image);
	public void setPixel(Pixel pixel);
	public Pixel getPixel(int x,int y);
	public BufferedImage getImage();
	public void readFromFile(File file);
	public void writeToFile(File file);
	public Icon copy();
}
