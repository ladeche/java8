package test.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import test.lambda.methodreference.*;

public class MethodReference {
    public static void main(String[] args) {
        // *** Utilisation de méthodes statiques *************************************
        List<Integer> list = Arrays.asList(-5, -3, 4);
        // Affiche les carrés
        display(list, MethodReference::square);
        // Affiche les valeurs absolues
        display(list, Math::abs);

        // *** Utilisation de méthodes d'une instance spécifique *************************************
        MethodReference mre = new MethodReference();
        StringConversion conversion;
        conversion = mre::toUpperCase;
        System.out.println(conversion.convert("sample string"));
        
        // *** Utilisation de méthodes d'instance mais d'une instance quelconque *********************
        List<String> names = Arrays.asList("Sam","Betty","Sue","Bob");
        // La méthode compareTo n'est pas statique mais on l'appelle via le nom de la classe et non de l'instance
        Collections.sort(names, String::compareTo);   
        names.forEach(System.out::println);

    
        // *** Utilisation de constructeurs ************************************
        // 1) avec un constructeur simple sans arguments
        SomeClass sc;
        SimpleConstructorInterface<SomeClass> sci;
        // mapping new <-> méthode create() de l'interface SimpleConstructorInterface
        sci = SomeClass::new;
        sc = sci.create();
        System.out.println(sc.getMessage());

        // 2) avec un constructeur spécifique avec arguments
        ConstructorArgumentInterface<SomeClass, String> cai;
        cai = SomeClass::new;
        sc = cai.create("ConstructorArgumentInterface");
        System.out.println(sc.getMessage());

        // 3) encore plus générique avec une liste d'arguments
        ConstructorListArgumentInterface<SomeClass, String> clai;
        clai = SomeClass::<String>new;
        sc = clai.create(new ArrayList<String>());
        List<String> list2;
        list2 = sc.getList();
        System.out.println(list2.size());
        list2.add("First");
        System.out.println(list2.size());
    }

    // La méthode  statique qui servira de référence
    public static int square(int num) {
        return num*num;
    }

    // Méthode acceptant en paramètre une opération
    private static void display(List<Integer> list,
      Computable operation) {
    	System.out.println(operation.getClass().getName());
        for(Integer element : list) {
            System.out.println(operation.compute(element));
        }
    }
    
    // Méthode d'instance qui peut servir de référence
    public String toUpperCase(String input) {
        return input.toUpperCase();
    }
}
