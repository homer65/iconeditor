package operation;
import core.*;
import java.awt.*;
import java.io.File;
public class InsertImage implements Operation
{
	private Pixel p1 = null;
	private Icon insert = null;
	public String getName()
	{
		return "InsertImage";
	}
	public String getStatus()
	{
		int ip = 0;
		if (p1 != null) ip++;
		String erg =  ":" + ip;
		return erg;
	}
	public Icon operate(Icon icon) 
	{
		int x1 = p1.getX();
		int y1 = p1.getY();
		if (insert != null)
		{
			int dx = insert.getSize().width;
			int dy = insert.getSize().height;
			int rx = icon.getSize().width;
			int ry = icon.getSize().height;
			for (int ix=0;ix<dx;ix++)
			{
				for (int iy=0;iy<dy;iy++)
				{
					int tx = x1 + ix;
					int ty = y1 + iy;
					Pixel temp = insert.getPixel(ix,iy);
					if (tx < rx)
					{
						if (ty < ry)
						{
							temp.setX(tx);
							temp.setY(ty);
							Color c = temp.getColor();
							int r = c.getRed();
							int g = c.getGreen();
							int b = c.getBlue();
							boolean use = true;
							if (r == 0)
							{
								if (g == 0)
								{
									if (b == 0)
									{
										use = false;
									}
								}
							}
							if (use)
							{
								icon.setPixel(temp);
							}
						}
					}
				}
			}
		}
		else
		{
			Protokol.write("InsertImage:operate:Kein Icon zum inserten");
		}
		return icon;
	}
	public void reset()
	{
		p1 = null;
	}
	public boolean isReady() 
	{
		boolean erg = true;
		if (p1 == null) erg = false;
		return erg;
	}
	public void pushColor(Color c) 
	{
		FileChooser fc = Factory.getFileChooser();
		File file = fc.getReadFile();
		if (file != null)
		{
			Icon temp = Factory.getIcon();
			temp.readFromFile(file);
			insert = temp;
		}
	}
	public void pushPixel(Pixel p) 
	{
		p1 = p;		
	}
	public Operation copy()
	{
		InsertImage erg = new InsertImage();
		erg.p1 = p1.copy();
		if (insert != null)
		{	
			erg.insert = insert.copy();
		}
		return erg;
	}

}
