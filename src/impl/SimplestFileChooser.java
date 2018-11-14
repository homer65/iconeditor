package impl;
import java.io.File;
import core.*;
public class SimplestFileChooser implements FileChooser 
{
	public File getReadFile() 
	{
		return new File("/home/christian/test.png");
	}
	public File getWriteFile() 
	{
		return new File("/home/christian/test.png");
	}
}
