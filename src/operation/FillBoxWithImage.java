package operation;
import core.*;
import java.awt.*;
import java.io.File;
public class FillBoxWithImage implements Operation
{
	private Pixel p1 = null;
	private Pixel p2 = null;
	private Icon insert = null;
	public String getName()
	{
		return "FillBoxWithImage";
	}
	public String getStatus()
	{
		int ip = 0;
		if (p1 != null) ip++;
		if (p2 != null) ip++;
		String erg =  ":" + ip;
		return erg;
	}
	public Icon operate(Icon icon) 
	{
		int x1 = p1.getX();
		int y1 = p1.getY();
		int x2 = p2.getX();
		int y2 = p2.getY();
		if (x1 > x2) 
		{
			int x = x1;
			x1 = x2;
			x2 = x;
		}
		if (y1 > y2)
		{
			int y = y1;
			y1 = y2;
			y2 = y;
		}
		int dx = x2 - x1 + 1;
		int dy = y2 - y1 + 1;
		if (insert != null)
		{
			IconResizer ir = Factory.getIconResizer();
			insert = ir.resize(insert,dx,dy);
			for (int ix=0;ix<dx;ix++)
			{
				for (int iy=0;iy<dy;iy++)
				{
					int tx = x1 + ix;
					int ty = y1 + iy;
					Pixel temp = insert.getPixel(ix,iy);
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
		else
		{
			Protokol.write("FillBoxWithImage:operate:Kein Icon zum inserten");
		}
		return icon;
	}
	public void reset()
	{
		p1 = null;
		p2 = null;
	}
	public boolean isReady() 
	{
		boolean erg = true;
		if (p1 == null) erg = false;
		if (p2 == null) erg = false;
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
		p2 = p1;
		p1 = p;		
	}
	public Operation copy()
	{
		FillBoxWithImage erg = new FillBoxWithImage();
		erg.p1 = p1.copy();
		erg.p2 = p2.copy();
		if (insert != null)
		{	
			erg.insert = insert.copy();
		}
		return erg;
	}

}
