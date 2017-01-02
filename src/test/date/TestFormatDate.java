package test.date;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class TestFormatDate {

	public static void main(String[] args) {
		
		// En français
		for (String mois : DateFormatSymbols.getInstance(Locale.FRENCH).getShortMonths()) {
			System.out.println(mois);
		}
			
		String dateFormat = "yyyy MMM dd";
		LocalDate aDate = null;
		
		boolean validStr = false;
		
		DateTimeFormatter formatter = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern(dateFormat).toFormatter(Locale.FRANCE);
		//DateTimeFormatter formatter = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern(dateFormat).toFormatter(Locale.ENGLISH);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (!validStr) {
			System.out.print("Enter a date : ");
			try {
				String dateEntered = br.readLine();
				System.out.println(dateEntered);
				aDate = LocalDate.parse(dateEntered,formatter);
				validStr=true;
			} catch (IOException | DateTimeParseException ex) {
				validStr=false;
				System.out.println("Date is invalid !"+ex.getMessage());
			}
		}
		
		System.out.println("Date entered was ");
		LocalDate now = LocalDate.now();
		
		Period between;
		if(aDate.isBefore(now)) {
			between = Period.between(aDate, now);
		} else {
			between = Period.between(now, aDate);
		}
		
		int years = between.getYears();
		int months = between.getMonths();
		int days = between.getDays();
		
		System.out.println("There are "+years+" years, "+months+" months, "+days+" days between your date and today.");
		
		
		
		
		
	}
	
}
