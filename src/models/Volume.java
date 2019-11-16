package models;

public class Volume {
	private static final String NAME_TEMPLATE = "Volume %d";
	
	private int volNum;
	private int publicationYear;
	

	public String getName()
	{
		return String.format(NAME_TEMPLATE, volNum);
	}
	public int getPublicationYear()
	{
		return publicationYear;
	}
	public void setPublicationYear(int publicationYear)
	{
		this.publicationYear = publicationYear;
	}
	public int getVolNum()
	{
		return volNum;
	}
	public void setVolNum(int volNum)
	{
		this.volNum = volNum;
	}
	
	public String toString() {
		return getName() + " published in " + publicationYear;
	}
}
