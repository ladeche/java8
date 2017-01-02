package test.interfaces;

// L'annotation indique au compilateur qu'il ne faut qu'une seule méthode abstraite :
// La méthode fonctionnelle
// Les méthodes equals et compare de Object ne sont pas incluses pour compter le nb de méthode abstraites
@FunctionalInterface
public interface Washable {
	
	// méthode fonctionnelle
	public abstract void Wash();
	
	// pas comptée
	public abstract boolean equals (Object o);
	

}
