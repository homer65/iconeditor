package impl;
import core.*;
public class SimpleUndoManager implements UndoManager
{
	private int max  = 1000;
	private Operation[] ops = new Operation[max];
	private int top = 0;
	private int pos = 0;
	private Icon icon = null;
	public void init(Icon icon) 
	{
		this.icon = icon.copy();
		ops = new Operation[max];
		top = 0;
		pos = 0;
	}
	public void push(Operation op) 
	{
		ops[pos] = op.copy();
		pos++;
		top = pos;
	}
	public Icon redo() 
	{
		Icon erg = null;
		if (icon != null)
		{
			if (pos < top)
			{
				pos++;
				erg = icon.copy();
				for (int i=0;i<pos;i++)
				{
					Operation op = ops[i];
					erg = op.operate(erg);
				}
			}
		}
		return erg;
	}
	public Icon undo() 
	{
		Icon erg = null;
		if (pos > 0)
		{
			pos--;
			erg = icon.copy();
			for (int i=0;i<pos;i++)
			{
				Operation op = ops[i];
				erg = op.operate(erg);
			}
		}
		return erg;
	}
}
