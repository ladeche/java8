package test.optional;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class TestOptional {

	public static void main(String[] args) {

		System.out.println("Test avec 2 options");
		Object o = null;
		Object p = "p";
		Object r = Optional.ofNullable( o ).orElse( p );
		System.out.println( r );   // p
		
		System.out.println("Test avec >2 options");
		o = null;
		p = null;
		Object q = "q";

		Optional<Object> s = Stream.of( o, p, q ).filter( Objects::nonNull ).findFirst();
		System.out.println( s.orElse(null) );   // p
		
		Integer x=null;
		String y = "toto"; 
		System.out.println(x);
		System.out.println(String.valueOf(x));
		System.out.println(Optional.ofNullable(String.valueOf(x)).orElse("Z"));
		Object u=Stream.of( x,y ).filter( Objects::nonNull ).findFirst().get();
		System.out.println(u);

	}
}
