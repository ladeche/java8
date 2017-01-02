package test.date;

import java.util.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

/**
 * convertLocalDateTimeToDate : transforme une LocalDateTime J8 and Date (Java historique)
 * convertSQLTimestampToLocalDateTime : transforme un timestamp SQL en LocalDateTime J8
 * dateNormalize : parsing et "normalisation" d'une date au format String en utilisant LocalDate  
 * dateTimeNormalize : parsing et "normalisation" d'une date au format String en utilisant LocalDateTime
 * translateTimestamp : à partir d'un string YYYYMMDDHHmmss, décale dans le temps  
 * @author lued7241
 *
 */

public final class TestDate {

	public static void main(String[] args) {
		String normalizedDate;
		LocalDateTime localDateTime;

		// TESTS DE CONVERSIONS
		convertLocalDateTimeToDate();
		localDateTime = convertSQLTimestampToLocalDateTime(new Timestamp(System.currentTimeMillis()));
		localDateTime = convertSQLTimestampToLocalDateTime(new Timestamp(1321313L));
		//localDateTime = convertSQLTimestampToLocalDateTime(null);

		// TESTS DE PARSING 
		normalizedDate = dateTimeNormalize("2016-12-06 12:30:16", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		normalizedDate = dateTimeNormalize("2016-12-06 12:30", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		normalizedDate = dateTimeNormalize("2016-12-06 12", DateTimeFormatter.ofPattern("yyyy-MM-dd HH"));
		//normalizedDate = DateTimeNormalize("2016-12-06", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		//normalizedDate2 = DateTimeNormalize("2016", DateTimeFormatter.ofPattern("yyyy"));

		normalizedDate = dateNormalize("2016-12-06", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		normalizedDate = dateNormalize("2016-12", DateTimeFormatter.ofPattern("yyyy-MM"));
		//normalizedDate = DateNormalize("2016", DateTimeFormatter.ofPattern("yyyy"));
		
		System.out.println("20160815142314>>>"+translateTimestamp("20160815142314", ChronoUnit.YEARS, 1L));
		System.out.println("20160815142314>>>"+translateTimestamp("20160815142314", ChronoUnit.YEARS, -1L));
		System.out.println("20160815142314>>>"+translateTimestamp("20160815142314", ChronoUnit.MONTHS, 3L));
		System.out.println("20160815142314>>>"+translateTimestamp("20160815142314", ChronoUnit.WEEKS, 2L));
		System.out.println("20160815142314>>>"+translateTimestamp("20160815142314", ChronoUnit.DAYS, 10L));
		System.out.println("20160815142314>>>"+translateTimestamp("20160815142314", ChronoUnit.HOURS, 12L));
		System.out.println("20160815142314>>>"+translateTimestamp("20160815142314", ChronoUnit.MINUTES, 30L));
		System.out.println("20160815142314>>>"+translateTimestamp("20160815142314", ChronoUnit.SECONDS, 10L));
		
	}

	public static void convertLocalDateTimeToDate() {
		LocalDateTime ldt = LocalDateTime.now();
		Date date = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
		System.out.println("==="+ldt.toString()+">>>"+date.toString());
	}
	
	public static LocalDateTime convertSQLTimestampToLocalDateTime (Timestamp ts) {
		System.out.println("==="+ts.toString()+">>>"+ts.toLocalDateTime());
		return ts.toLocalDateTime();
	}
	
	public static String dateNormalize(String inputDate,DateTimeFormatter formatter) {
		System.out.println("==="+inputDate+" ... " + formatter.toString());
		LocalDate localDate=null;
		try {
			localDate = LocalDate.parse(inputDate,formatter);
			System.out.println(localDate.toString());
			System.out.println("Y="+localDate.getYear());
		} catch (Exception e) {
			// never crash, just nullify date
			System.out.println("Exception : "+e.getMessage());
			return null;
		}
		return localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}
	
	public static String dateTimeNormalize(String inputDate,DateTimeFormatter formatter) {
		System.out.println("==="+inputDate+" ... " + formatter.toString());
		LocalDateTime localDateTime=null;
		try {
			localDateTime = LocalDateTime.parse(inputDate,formatter);
			System.out.println(localDateTime.toString());
			System.out.println("Y="+localDateTime.getYear());
		} catch (Exception e) {
			// never crash, just nullify date
			System.out.println("Exception");
			e.printStackTrace();
			//return null;
		}
		return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}
	
	public static String translateTimestamp (String timestamp, TemporalUnit translationUnit, long translationValue) {
		LocalDateTime localDateTime=null;
		localDateTime = LocalDateTime.parse(timestamp,DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
		localDateTime=localDateTime.plus(translationValue,translationUnit);
		return localDateTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));

	}

	

	
}
