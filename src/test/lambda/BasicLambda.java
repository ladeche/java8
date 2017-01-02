package test.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;


public class BasicLambda {
	
	public static int square (int num) {
		return num*num;
	}
	
    public static void main(String[] args) {
    	List<Integer> list = Arrays.asList(1,2,3,4,5);
    	
    	System.out.println("Classique : ");
    	// Méthode classique 
    	for (Integer integer : list) {
    		System.out.println(integer);
		}
    	for (Integer integer : list) {
    		System.out.println(square(integer));
		}    	

    	// Lambda
    	System.out.println("Lambda : ");
    	list.forEach((Integer element) -> System.out.println(element));
    	list.forEach((Integer element) -> System.out.println(element*element));

    	// Traduction compilateur 
    	System.out.println("Traduction compilateur : ");
        list.forEach(new Consumer() {
            @Override
            public void accept(Object element) {
               System.out.println(element);
            }
         });
    	
 	}

}
