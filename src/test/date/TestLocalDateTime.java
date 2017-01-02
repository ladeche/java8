package test.date;

import static java.time.Month.*;
import static java.time.temporal.ChronoUnit.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TestLocalDateTime {

	public static void main(String[] args) {
		
		LocalDateTime meeting, flight, courseStart,courseEnd;
		
		meeting = LocalDateTime.of(2016, MARCH,31,14,30);
		System.out.println("Meeting at "+meeting);
		
		LocalDate flightDate = LocalDate.of(2017, 01, 10);
		LocalTime flightTime = LocalTime.of(06, 55);
		
		flight = LocalDateTime.of(flightDate,flightTime);
		System.out.println("Flight leave : "+flight);
		
		courseStart = LocalDateTime.of(2017, MARCH,25,9,30);
		courseEnd = courseStart.plusDays(4).plusHours(9);
		System.out.println("Course starts "+courseStart);
		System.out.println("Course ends "+courseEnd);
		
		long courseHours = (courseEnd.getHour() - courseStart.getHour())*(courseStart.until(courseEnd, DAYS));
		System.out.println("Course length "+courseHours+" hours");
		
	}

}
