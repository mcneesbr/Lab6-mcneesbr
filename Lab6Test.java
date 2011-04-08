import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;

import org.junit.Test;


public class Lab6Test {

	@Test
	public void testEnglish() {
		String testName = "TEST";
		ByteArrayInputStream in = new ByteArrayInputStream(testName.getBytes());
		System.setIn(in);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));

		PrintBalance printer = new PrintBalance("US");
		printer.print();
		String formMoney = NumberFormat.getCurrencyInstance(printer.currentLocale).format(9876543.21);
		
		Date today = new Date();
		String formDate = DateFormat.getDateInstance(DateFormat.LONG, printer.currentLocale).format(today);
		
		String newline = System.getProperty("line.separator");
		String exp = "Hello World" + newline + "Please enter your name" + newline + 
				"I am pleased to meet you TEST" + newline +	"As of : " + formDate + 
				newline + "You owe the school " + formMoney + newline + "Good Bye" + newline;
		
		assertEquals(exp, out.toString());
	}
	
	@Test
	public void testGerman() {
		String testName = "TEST";
		ByteArrayInputStream in = new ByteArrayInputStream(testName.getBytes());
		System.setIn(in);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));

		PrintBalance printer = new PrintBalance("DE");
		printer.print();
		String formMoney = NumberFormat.getCurrencyInstance(printer.currentLocale).format(9876543.21);
		
		Date today = new Date();
		String formDate = DateFormat.getDateInstance(DateFormat.LONG, printer.currentLocale).format(today);
		
		String newline = System.getProperty("line.separator");
		String exp = "Hallo Welt" + newline + "Geben sie ihren namen bitte" + newline + 
				"Ich freue mich, sie kennen zu lernen TEST" + newline +	"Als der : " + formDate + 
				newline + "Sie schulden sie schule " + formMoney + newline + "Auf wiedersehen" + newline;
		
		assertEquals(exp, out.toString());
	}
	
	@Test
	public void testFrench() {
		String testName = "TEST";
		ByteArrayInputStream in = new ByteArrayInputStream(testName.getBytes());
		System.setIn(in);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));

		PrintBalance printer = new PrintBalance("FR");
		printer.print();
		String formMoney = NumberFormat.getCurrencyInstance(printer.currentLocale).format(9876543.21);
		
		Date today = new Date();
		String formDate = DateFormat.getDateInstance(DateFormat.LONG, printer.currentLocale).format(today);
		
		String newline = System.getProperty("line.separator");
		String exp = "Bonjour tout le monde" + newline + "S'il vous plaît entrer votre nom" + newline + 
				"Enchanté de vous recontrer TEST" + newline +	"Du : " + formDate + 
				newline + "Vouz devez l'école " + formMoney + newline + "Au revoir" + newline;
		
		assertEquals(exp, out.toString());
	}

}
