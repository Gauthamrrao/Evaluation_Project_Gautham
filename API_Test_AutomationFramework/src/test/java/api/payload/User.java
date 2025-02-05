package api.payload;



public class User 
{

	private String firstname;
	private String lastname;
	private double totalprice;
	private boolean depositpaid;
	//private Object bookingdates;
	//private Object setcheckin;
	//private Object setcheckout;
	private BookingDates bookingdates;
	private String additionalneeds;
	
    
	
	public String getfirstname()
	{
		return firstname;
	}
	public void setfirstname(String firstname )
	{
		this.firstname=firstname;
	}
	public String getlastname()
	{
		return lastname;
	}
	public void setlastname(String lastname)
	{
		this.lastname=lastname;
	}
	public double totalprice()
	{
		return totalprice;
	}
	public void settotalprice(double totalprice )
	{
		this.totalprice=totalprice;
	}
	public boolean getdepositpaid()
	{
		return depositpaid;
	}
	public void setdepositepaid(boolean depositpaid)
	{
		this.depositpaid=depositpaid;
	}
	
	public BookingDates getbookingdates()
	{
		return bookingdates;
	}
	public void setbookingdates(BookingDates bookingdates)
	{
		this.bookingdates=bookingdates;
	}
	
	
	public String getadditionalneeds()
	{
		return additionalneeds;
	}
	public void setadditionalneeds(String additionalneeds)
	{
		this.additionalneeds=additionalneeds;
	}
	/* @Override
	    public String toString() {
	        return "{" +
	                "\"username\""+":" + "\"" +username + "\"" +
	                ", password\""+":"  + "\"" + password + "\"" +
	                '}';*/
	    
	}
	
	
	
	
	
	
	
	
	
	


