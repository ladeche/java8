package test.interfaces;

class PersonInherit implements Displayable {
	
	// Pas besoin de redéclarer la méthode par défaut de l'interface
	// public void draw()  {}
	
	
	// possibilité de surcharger la méthode par défaut de l'interface
	@Override
	public void drawInQuotes() {
		// pas obligatoire mais possible d'exécuter la "super" méthode de l'interface
		Displayable.super.drawInQuotes();
        System.out.println(
                "\"The PersonInherit Class's drawInQuotes method\"");
	}
	
	@Override
	public void drawInSemiColon() {
	       System.out.println(
	                ":The PersonInherit Class's drawInSemiColon method:");
	}
	
    public boolean hasBeenDrawn() {
    return true;
    }
    
    public static void main(String[] args) {
    	   PersonInherit person = new PersonInherit();
    	   person.draw();
    	   person.drawInQuotes();
    	   person.drawInSemiColon();

    	}


}