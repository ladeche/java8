package test.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import test.lambda.inferring.ComputableType;
import test.lambda.inferring.DoubleSquare;
import test.lambda.inferring.IntegerSquare;


public class Inferring {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5);

		// Définition des lambdas à la volée
		IntegerSquare integerSquare = x -> x*x;
		DoubleSquare doubleSquare = x -> x*x;
		// Exécution des lambdas
		System.out.println(integerSquare.square(5));
		System.out.println(doubleSquare.square(5));

		// Idem mais plus générique avec 
		// (1) typage explicite
		// (2) typage implicite selon la cible
		ComputableType<Integer> computableInteger;
		computableInteger = (Integer x) -> x*x;
		computableInteger = (x) -> x * x;

		ComputableType<Double> computableDouble;
		computableDouble = (Double x) -> x * x; 
		computableDouble = (x) -> x * x;

		System.out.println(computableDouble.compute(5.0));
	}

}
