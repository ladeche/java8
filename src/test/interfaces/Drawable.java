package test.interfaces;

import java.rmi.server.UnicastRemoteObject;

interface Drawable {
	
	// Méthode par défaut
	// Pas besoin de la réimplémenter dans les classes qui utilisent cette interface.
	// De plus contrairement à une méthode abstraite, on peut en ajouter une dans une interface
	// sans que les classes héritantes cassent jusqu'à ce qu'elles l'implémentent.
    public default void draw() {
        System.out.println(
            "The Drawable interface's draw method");
    }
    // Possible d'avoir plusieurs méthodes par défaut
    public default void drawInQuotes() {
        System.out.println(
          "\"The Drawable interface's drawInQuotes method\"");
    }
    // Possible d'avoir plusieurs méthodes par défaut
    public default void drawInSemiColon() {
        System.out.println(
          ":The Drawable interface's drawInQuotes method:");
    }

    // Cette méthode est abstraite et doit être redéfinie dans la classe
    public abstract boolean hasBeenDrawn();
    
    // Méthode statique
    public static String staticMethod () {
    	return "Drawable staticMethod";
    }
    
}