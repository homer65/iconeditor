package core;
import java.awt.image.BufferedImage;
import java.io.File;
public interface ImageLoader 
{
	public BufferedImage load(File file,String typ);
	public void write(File file,String typ,BufferedImage img);
}
