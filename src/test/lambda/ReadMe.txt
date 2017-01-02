1) BasicLambda : basiques des lambda
2) Inferring (+package) : inférence du type
3) VariableCapture : subtilités sur le contexte des variables et le multithreading
=> When a lambda expression is evaluated, it uses the context in which it was defined, not where it is being used.
4) MethodReference : différentes possibilités de réutiliser des méthodes existantes pour les utiliser en lambda :
- méthodes statiques
- méthodes d'instance
- constructeurs