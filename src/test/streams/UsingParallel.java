package test.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import test.streams.using.Part;

public class UsingParallel {

	List<Part> partsList;

	public UsingParallel () {
		this.partsList = Arrays.asList(
				new Part("Pencil", 100, 5, 0.15f, 200),
				new Part("Eraser", 200, 3, 0.25f, 300),
				new Part("Paper", 2000, 1, 0.03f, 500),
				new Part("Pen", 200, 3, 0.25f, 200),
				new Part("Staple", 3000, 1, 0.01f, 300)
				);

	}

	public static void main(String[] args) {
		UsingParallel up = new UsingParallel();

		System.out.println("*** Séquentiel");
		Stream<Part> partsStream = up.partsList.stream();
		partsStream.filter(
				(p)->p.getWeight()>=3).
		forEach(p -> System.out.println(p));

		System.out.println("*** Parallèle");
		partsStream = up.partsList.stream();
		partsStream.parallel().
		filter((p)->p.getWeight()>=3).
		forEach(p -> System.out.println(p));

		System.out.println("*** Plus complexe (séquentiel) : je classe les objets par poids");
		partsStream = up.partsList.stream();
		Map<Integer, List<Part>> groupByWeight =
				partsStream.collect(
						Collectors.groupingBy(Part::getWeight));
		for(Part part : groupByWeight.get(3)) { // Liste des objets de poids 3
			System.out.println(part);
		}

		System.out.println("*** Plus complexe (parallèle) : je classe les objets par poids");
		partsStream = up.partsList.stream();
		ConcurrentMap<Integer, List<Part>> groupByWeightParallel =
				partsStream.parallel().collect(
						Collectors.groupingByConcurrent(Part::getWeight));
		for (Part part : groupByWeightParallel.get(3)) {
			System.out.println(part);
		}
		
		// Illégal : on cherche à changer liste source du stream (up.partsList.add) 
		// dans le traitement du stream (filter((p)->{ ...) : c'est une interférence
	    /*
	    up.partsList.stream().
	       filter((p)->{
	         up.partsList.add(p);
	         return p.getWeight()>=3;}).
	       forEach(p -> System.out.println(p));
		*/
		
		// Attention aux lambda expressions "stateful" (ie qui dépendent de l'état lors de l'exécution)
		System.out.println("*** Expr. lambda stateful");
	    boolean someCondition = true; // admettons que ce soit défini à l'exécution
		partsStream = up.partsList.stream();
	    partsStream.parallel().
	       filter(p -> {
	         if (someCondition) {
	           return true;
	         } else {
	           return false;
	         }
	       }).
	       forEach(p -> System.out.println(p));
		
	}

}
