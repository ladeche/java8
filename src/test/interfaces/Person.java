package test.interfaces;

class Person implements Drawable {
	
	// Pas besoin de redéclarer la méthode par défaut de l'interface
	// public void draw()  {}
	
	
	// possibilité de surcharger la méthode par défaut de l'interface
	@Override
	public void drawInQuotes() {
		// pas obligatoire mais possible d'exécuter la "super" méthode de l'interface
		Drawable.super.drawInQuotes();
        System.out.println(
                "\"The Person Class's drawInQuotes method\"");
	}
	
    public boolean hasBeenDrawn() {
    return true;
    }
    
    public static void main(String[] args) {
    	   Person person = new Person();
    	   person.draw();
    	   person.drawInQuotes();
    	   person.drawInSemiColon();
    	   // Possibilité d'exécuter une méthode statique d'une interface ! => remplace les Helper ?
    	   System.out.println(Drawable.staticMethod());
    	   // Ne fonctionne pas bien que Person implémente Drawable
    	   // System.out.println(Person.staticMethod());
    	   
    	}
}