package test.date;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TestTimeZones {

	public static void main(String[] args) {
		
		ZoneId zny = ZoneId.of("America/New_York");
		ZoneId zpa = ZoneId.of("Europe/Paris");
		ZoneId zto = ZoneId.of("Asia/Tokyo");

		LocalDateTime departure = LocalDateTime.of(2017,1,5,14,10,30);
		ZonedDateTime departNy = ZonedDateTime.of(departure,zny);
		ZonedDateTime departPa = departNy.toOffsetDateTime().atZoneSameInstant(zpa);
		ZonedDateTime departTo = departNy.toOffsetDateTime().atZoneSameInstant(zto);
		System.out.println("=== Flight Start ===");
		System.out.println("NY Time     : "+departNy);
		System.out.println("Paris Time  : "+departPa);
		System.out.println("Tokyo Time  : "+departTo);
		
		ZonedDateTime arrivePa = departNy.plusHours(6).plusMinutes(10).toOffsetDateTime().atZoneSameInstant(zpa);
		System.out.println("=== Flight End ===");
		ZonedDateTime arriveNy = arrivePa.toOffsetDateTime().atZoneSameInstant(zny);

		System.out.println("NY Time     : "+arriveNy);
		System.out.println("Paris Time  : "+arrivePa);
		
		
		
	}

}
