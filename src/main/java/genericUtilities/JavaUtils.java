package genericUtilities;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

public class JavaUtils
{
	/**
	 * This method will create random number 
	 * @author Nandan V
	 * @return
	 */
	public int getRandomNumber()
	{
		Random ran = new Random();
		int random = ran.nextInt(1000);
		return random ;
	}
	public String systemDate(long futureMon )
	{
		LocalDate date = LocalDate.now();
		DateTimeFormatter d = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String systemdate = d.format(date);
		return systemdate;
	}
	public String sysDate()
	{
		Date date= new Date();
		SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		String systemDateInFormat = sim.format(date);
		return systemDateInFormat;
	}
	public String futureDateIntermsOfMonths(long FutureMon)
	{
		LocalDate date = LocalDate.now();
		LocalDate future = date.plusMonths(FutureMon);
		DateTimeFormatter d = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String FutureMonth = d.format(future);
		return FutureMonth;
		
	}
	
}
