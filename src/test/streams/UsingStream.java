package test.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import test.streams.using.Part;

public class UsingStream {

	List<Part> partsList;

	public UsingStream() {
		this.partsList = Arrays.asList(
				new Part("Pencil", 100, 5, 0.15f, 500),
				new Part("Eraser", 200, 3, 0.25f, 250),
				new Part("Paper", 2000, 1, 0.03f, 1200)
				);		
	}

	public static void main(String[] args) {

		UsingStream us = new UsingStream();

		us.forEach();

		us.map();

		us.flatMap();

		us.filter();

		us.match();

		us.collector();

		us.autres();

		us.primitives();
	}

	private void forEach() {
		// forEach *****
		System.out.println("******** forEach");
		Stream<Part> partsStream = partsList.stream();
		// listing
		partsStream.forEach(System.out::println);
		// augmentation du prix
		// partsStream = partsList.stream(); // illégal car le stream est déjà fermé car utilisé dans le forEach précédent

		// Exécution en parallèle => ordre non garanti
		System.out.println("******** forEach(Parallel)");
		partsList.parallelStream().forEach(x ->System.out.println(x));

		// forEachOrdered ******
		System.out.println("******** forEachOrdered");
		partsStream = partsList.stream();
		partsStream.forEachOrdered(System.out::println);		
	}

	private void map() {

		// map *********
		System.out.println("******** map");
		Stream<Part> partsStream = partsList.stream();
		// Définition d'une fonction de mapping (prix + 5%)
		Function<Part, Part> mapper = (Part part) -> {
			Part newPart = new Part(part);
			newPart.setPrice(part.getPrice() * 1.05f);
			return newPart;
		};
		partsStream = partsList.stream();
		partsStream.map(mapper).forEach(System.out::println); // +5% sur le prix + affichage
		// Mais le prix dans la liste d'origine est inchangé : la source du stream est distincte du stream et inchangée
		partsStream = partsList.stream();
		partsStream.forEach(System.out::println);

		System.out.println("******** map(2)");
		partsStream = partsList.stream();
		Integer[] partNumbers = partsStream
				.map(Part::getPartNumber)
				.toArray(Integer[]::new); // extrait la liste d'un attribut dans un tableau
		for(Integer partNumber : partNumbers) {
			System.out.println(partNumber);
		}

		System.out.println("******** mapToInt, mapToDouble, mapToLong (conversion à la volée)");
		partsStream = partsList.stream();
		int total = partsStream
				.mapToInt(p -> (int)(p.getPrice()*p.getQuantity())) // prix (int) * quantité
				.sum(); // somme 
		System.out.println("Total value (int): " + total);

		partsStream = partsList.stream();
		Double totald = partsStream
				.mapToDouble(p -> (double)(p.getPrice()*p.getQuantity())) // prix (int) * quantité
				.sum(); // somme 
		System.out.println("Total value (double): " + totald);
	}

	private void flatMap() {
		// flatMap *********
		System.out.println("******** flatMap (collections imbriquées)");
		List<Float> partsList = Arrays.asList(
				new Part("Pencil", 100, 5, 0.15f, 500).getPrice(),
				new Part("Eraser", 200, 3, 0.25f, 250).getPrice(),
				new Part("Paper", 2000, 1, 0.03f, 1200).getPrice()
				);

		List<List<Float>> mappedParts =
				partsList.stream().
				map(p -> Arrays.asList(p-=p*0.10f, p, p+=p*0.10f)).
				collect(Collectors.toList());
		System.out.println(mappedParts);
	}

	private void filter() {
		// filter *********
		System.out.println("******** filter");
		Stream<Part> partsStream = partsList.stream();
		Predicate<Part> weightPredicate = p -> p.getWeight() >= 3; // filtre des poids >= 3 
		partsStream.filter(weightPredicate).
		forEach(System.out::println);

		System.out.println("******** filter en série");
		partsStream = partsList.stream();
		Predicate<Part> pricePredicate = p -> p.getPrice() >= 0.2f; // filtre des prix >= 0,20 
		partsStream.filter(weightPredicate).filter(pricePredicate).
		forEach(System.out::println);

		// Possible aussi de combiner map et filtre (ex : idem précédent mais en mappant avec une reduc de 10% avant)

	}

	private void match() {
		// match *********
		System.out.println("******** match (renvoie un booléen selon le test effectué)");
		Stream<Part> partsStream = partsList.stream();
		System.out.println(partsStream.allMatch(p -> p.getQuantity()<50));
		partsStream = partsList.stream();
		System.out.println(partsStream.anyMatch(p -> p.getQuantity()<50));
		partsStream = partsList.stream();
		System.out.println(partsStream.noneMatch(p -> p.getQuantity()<50));
		partsStream = partsList.stream();
		System.out.println(partsStream.allMatch(p -> p.getWeight()>50));
		partsStream = partsList.stream();
		System.out.println(partsStream.anyMatch(p -> p.getQuantity()>1000));
		partsStream = partsList.stream();
		System.out.println(partsStream.noneMatch(p -> p.getPrice()>.35f));
	}

	private void collector() {
		// collector *********
		System.out.println("******** collector");
		List<Part> partsList = Arrays.asList(
				new Part("Pencil", 100, 5, 0.15f, 500),
				new Part("Eraser", 200, 3, 0.25f, 250),
				new Part("Pen", 500, 3, 0.35f, 350),
				new Part("Paper", 2000, 1, 0.03f, 1200)
				);
		Stream<Part> partsStream = partsList.stream();
		List<String> partList =
				partsStream.
				map(Part::getName).
				collect(Collectors.toList()); // Le résultat est stocké dans une liste 
		for (String element : partList) {
			System.out.println(element);
		}


	}

	private void autres() {
		// autres *********
		System.out.println("******** findFirst");

		System.out.println("******** findAny");

		System.out.println("******** Optional (isPresent, orElse, orElseGet, ...)");

		System.out.println("******** reduce (action consécutive sur des éléments pour ne donner qu'un résultat)");
		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		Optional<Integer> result = list.stream().
				reduce((n1, n2) -> n1 + n2);
		System.out.println(result.get());

		System.out.println("******** sorted (pour trier)");

		System.out.println("******** distinct (élimine les doublons)");

		System.out.println("******** limit (borne la taille)");

		System.out.println("******** skip (saute les premiers éléments)");

		System.out.println("******** max, min, count");

	}

	private void primitives() {
		// primitives *********
		System.out.println("******** primitives (IntStream, DoubleStream, LongStream)");
		// Version classique sans IntStream (Castings)
		Stream<Part> partsStream = partsList.stream();
		int sumOfWeights = partsStream.mapToInt(
				(Part p) -> p.getWeight()).sum();
		System.out.println("Sum: " + sumOfWeights);

		// Version avec IntStream
		partsStream = partsList.stream();
		IntStream tmpStream = partsStream.mapToInt(
				(Part p) -> p.getWeight());
		System.out.println("Sum: " + tmpStream.sum());

	}

}
