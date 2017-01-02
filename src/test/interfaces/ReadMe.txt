1) Ensemble de classes/interfaces exemples pour la nouvelle gestion des interfaces en Java 8.
- méthode par défaut
- méthode abstraite
- méthode statique

Drawable    <---- Person
   ^
   |
   |
Displayable <---- PersonInherit

Il y a des schémas d'héritage plus complexes ("diamant") décrits dans le bouquin "Java 8 New Features : A Practical Heads-Up guide. pp 6-11"


2) Mouse* : Exemple de comparaison classe abstraite/interface en J8
                        Classe abstraite        Interface
Héritage multiple           N                       Y
Constructeur                Y                       N
Etat                        Y                       N
Utilisable avec Lambda ex.  N                       Y

3) Interface fonctionnelle

Voir Washable.
Les interfaces fonctionnelles sont notamment utilisées dans les lambda expressions.