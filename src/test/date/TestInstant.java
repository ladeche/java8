package test.date;

import java.time.Instant;

public class TestInstant {

	public static void main(String[] args) throws InterruptedException {
		
		Instant now = Instant.now();
		Thread.sleep(0,500000);
		Instant later = Instant.now();
		System.out.println(now);
		System.out.println(later);
		

	}

}
