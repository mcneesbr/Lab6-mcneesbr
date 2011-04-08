import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;


/**
 * TODO A simple class that needs to be localized
 *
 * @author mohan.
 *         Created Mar 27, 2010.
 */
public class PrintBalance{
	
	private static Locale usLoc = new Locale("en", "US");
	private static Locale frLoc = new Locale("fr", "FR");
	private static Locale deLoc = new Locale("de", "DE");
	public static Locale currentLocale;
	public static String hello, name, greet, date, bill, bye;
	
	public PrintBalance(String locale) {
		if (locale == "US") {
			currentLocale = usLoc;
		} else if (locale == "FR") {
			currentLocale = frLoc;
		} else if (locale == "DE") {
			currentLocale = deLoc;
		}
	}
	
	public static void CreateStrings(ResourceBundle messages, String formDate, String formMoney) {
		hello = messages.getString("helloWorld");
		name = messages.getString("namePrompt");
		greet = messages.getString("greeting");
		date = messages.getString("date") + formDate;
		bill = messages.getString("bill") + formMoney;
		bye = messages.getString("farewell");
		
	}

	
	/**
	 * Simple Java Method that is crying out to be localized.
	 *
	 * @param args
	 */
	public static void print()
	{
		ResourceBundle messages;
		
		messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
	
		Scanner scanInput = new Scanner(System.in);
		
		String formMoney = NumberFormat.getCurrencyInstance(currentLocale).format(9876543.21);
		
		Date today = new Date();
		String formToday = DateFormat.getDateInstance(DateFormat.LONG, currentLocale).format(today);
		
		CreateStrings(messages, formToday, formMoney);
		
		//Greeting
		System.out.println(hello);
		
		//Get User's Name
		System.out.println(name);
		String name = scanInput.nextLine();
		System.out.println(greet + name);
		
		//print today's date, balance and bid goodbye
		System.out.println(date);
		System.out.println(bill);
		System.out.println(bye);
	}
	
	public static void main(String args[]) {
		PrintBalance printer = new PrintBalance("US");
		printer.print();
	}
}