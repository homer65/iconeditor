package core;
public class StringPaar 
{
	private String key = null;
	private String value = null;
	public void setKey(String s)
	{
		key = s;
	}
	public void setValue(String s)
	{
		value = s;
	}
	public String getKey()
	{
		return key;
	}
	public String getValue()
	{
		return value;
	}
	public String toString()
	{
		String erg = key + "<=>" + value;
		return erg;
	}
}
