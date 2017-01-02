package test.date;

import java.time.LocalDate;
import static java.time.DayOfWeek.*;
import static java.time.temporal.TemporalAdjusters.*;

public class TestLocalDate {
	
	public static void main(String[] args) {
		
		LocalDate now,bDate,nowPlusMonth,nextTues;
		now = LocalDate.now();
		System.out.println("Now:"+now);
		bDate = LocalDate.of(1995, 3, 23);
		System.out.println("Old Date:"+bDate);
		System.out.println("Old Before now ? "+bDate.isBefore(now));
		System.out.println("Bissextile ? "+now.isLeapYear());
		System.out.println("Aujourd'hui nous sommes "+now.getDayOfWeek());
		
		nowPlusMonth = now.plusMonths(1);
		System.out.println("Dans un mois ce sera le "+nowPlusMonth);
		nextTues = now.with(next(TUESDAY));
		System.out.println("Mardi prochain "+nextTues);
		
		
		
		
	}

}
