package core;
public interface UndoManager 
{
	public void init(Icon icon);
	public void push(Operation op);
	public Icon undo();
	public Icon redo();
}
