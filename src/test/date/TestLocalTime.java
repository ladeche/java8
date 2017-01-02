package test.date;

import static java.time.temporal.ChronoUnit.*;

import java.time.LocalDate;
import java.time.LocalTime;

public class TestLocalTime {

	public static void main(String[] args) {

		LocalTime now,nowPlus,nowHrsMins, lunch, bedTime;
		
		now=LocalTime.now();
		System.out.println("Now : "+now);
		
		nowPlus = now.plusHours(1).plusMinutes(15);
		System.out.println("Dans 1h15 :"+nowPlus);
		
		nowHrsMins = now.truncatedTo(MINUTES);
		System.out.println("A la minute près : "+nowHrsMins);
		System.out.println("It is the "+now.toSecondOfDay()/60+" th minute");
		
		lunch = LocalTime.of(12, 30);
		System.out.println("Is lunch in my future ? "+lunch.isAfter(now));
		
		long minsToLunch = now.until(lunch, MINUTES);
		bedTime =LocalTime.of(23, 15);
		
		System.out.println("Lunch in "+minsToLunch+" minutes");
		System.out.println("BedTime in "+now.until(bedTime, HOURS)+" hours");
		

	}

}
