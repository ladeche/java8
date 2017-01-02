package test.streams;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class DifferenceStreamCollection {

	public static void main(String[] args) {
	    // Iterator approach
	    List<Integer> partsList = Arrays.asList(5,6,7,8,3,9,5,6,4,11);
	    Iterator<Integer> partsIterator = partsList.iterator();
	    while(partsIterator.hasNext()) {
	       Integer part = partsIterator.next();
	       if(part >= 6.0f) {
	          System.out.println(part);
	       }
	    }

	    // Stream approach
	    Stream<Integer> partsStream = partsList.stream();
	    Predicate<Integer> pricePredicate = p -> p >= 6.0f;
	    partsStream.filter(pricePredicate).
	       forEach(System.out::println);
	}

}
