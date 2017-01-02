package test.interfaces;

// Displayable hérite de Drawable

public interface Displayable extends Drawable {
	// Méthode par défaut
	// Surcharge la méthode de Drawable
    @Override
	public default void draw() {
        System.out.println(
            "The Displayable interface's draw method");
    }
    
    // NB il est aussi possible de surcharger une méthode par défaut d'interface en la rendant abstract
    // Dans ce cas là, la classe d'implémentation doit la déclarer !
    @Override
    public abstract void drawInSemiColon();
}
