package test.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Stream;

import javax.swing.text.AttributeSet.CharacterAttribute;

import test.streams.streamcreation.SampleStreamBuilder;

public class StreamCreation {

	public static void main(String[] args) {

		// Méthodes statiques de Stream
		createStaticMethodStream();
		
		// Méthodes de la classe collection
		createCollection();

		// Interface Stream.Builder
		createStreamBuilder();

		// Méthode Builder
		createBuilder();

		// Stream "Infini" (basé sur l'entrée standard)
		//createScanner();
		
		// Méthode Iterate
		createIterate();
		
		// Concaténation de streams
		concatenateStreams();
	}
	
	private static void createStaticMethodStream () {
		Stream<String> stringStream = Stream.of("alpha", "beta", "gamma", "delta");
		stringStream.forEach((s)->System.out.print(s + " "));
		System.out.println();

		stringStream = Stream.of("drop the sword here".split(" "));
		stringStream.forEach((s) -> System.out.println(s));

		Stream<String> partStream = Stream.of(
				new String("Pencil"),
				new String("Eraser"),
				new String("Paper"));
		partStream.forEach((p) -> System.out.println(p));

	}

	private static void createCollection() {
		List list = Arrays.asList(1, 2, 3, 4, 5);
		Stream stream = list.stream();
		stream.forEach(x -> System.out.print(x + " "));
		System.out.println();
	}

	private static void createStreamBuilder() {
		SampleStreamBuilder streamBuilder =	new SampleStreamBuilder();
		streamBuilder.accept("Bob");
		streamBuilder.accept("Sue");
		streamBuilder.accept("Mary");
		Stream<String> stream = streamBuilder.build();
		stream.forEach((s)->System.out.println(s));
	}
	private static void createBuilder() {
		Stream.Builder streamBuilder = Stream.builder();
		streamBuilder.accept("Bobby");
		streamBuilder.accept("Sue-Ellen");
		streamBuilder.accept("Mary-Jane");
		Stream<String> stream = streamBuilder.build();
		stream.forEach((s) -> System.out.println(s));
	}
	private static void createScanner() {
		Scanner scanner = new Scanner(System.in);
		Supplier<String> cliSupplier = () -> {
			return scanner.next();
		};
		// écrit l'entrée suivie d'un backslash et attends l'entrée suivante ...
		Stream.generate(cliSupplier).
		forEach((c) -> System.out.print(c+"\\"));
	}

	private static void createIterate () {
		// Semble ne pas fonctionner correctement : théoriquement incrémente les lettres
		Stream.iterate('a', c -> c++)
			.map(c -> c.toString() + " " + c.toString().toUpperCase())
			.limit(26)
			.forEach(c -> System.out.print(c + " ")
				);	
		System.out.println();
	}

	private static void concatenateStreams() {
	    Stream<Integer> evenStream = Stream.iterate(2, n -> n+2).limit(10);
	    Stream<Integer> oddStream = Stream.iterate(1, n -> n+2).limit(10);
	    Stream<Integer> numbers = Stream.concat(evenStream,oddStream);
	    numbers.forEach(n -> System.out.print(n + " "));
	    System.out.println();
	}
}
