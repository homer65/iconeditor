package impl;
import java.io.*;
import javax.swing.*;
import core.*;
public class SimpleFileChooser implements FileChooser 
{
	public File getReadFile() 
	{
		File erg = null;
		JFileChooser fc = new JFileChooser();
		int rc = fc.showOpenDialog(null);
		if (rc == JFileChooser.APPROVE_OPTION)
		{
			erg = fc.getSelectedFile();
		}
		return erg;
	}
	public File getWriteFile() 
	{
		File erg = null;
		JFileChooser fc = new JFileChooser();
		int rc = fc.showSaveDialog(null);
		if (rc == JFileChooser.APPROVE_OPTION)
		{
			erg = fc.getSelectedFile();
		}
		return erg;
	}
}
