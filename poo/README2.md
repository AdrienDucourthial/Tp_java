## Exercice 1 - Location de voitures
Le but de cet exercice est de créer un ensemble de classes permettant de gérer une agence de location de voitures.

Les tests JUnit de cet exercice sont `RentalTest.java.md`.

1. Ecrire une classe `Car` dans le package tp.poo.rental, correspondant à un véhicule qui pourra être loué. Un vehicule est décrit par un modèle (une chaine de caractères) ainsi qu'une année de fabrication.
Par exemple, une Ford Mustang sera créer de cette façon:

```Java
Car mustang = new Car("ford mustang", 2014)
```

3. Modifier la classe `Car` pour que le code suivant affiche
```Java
System.out.println(mustang);
```

**le texte "ford mustang 2014"**

3. Créer une classe `CarRental` (toujours dans le package tp.poo.rental) qui stocke l'ensemble des véhicules qui peuvent être louées dans une liste.
La classe `CarRental` possède une add qui permet d'ajouter un véhicule dans la liste.
Faire en sorte que la liste ne puisse pas contenir null en utilisant `Objects.requireNonNull()`
4. Ecrire une méthode `remove` qui permet de retirer un véhicule de la liste.
Que faire si le véhicule n'a pas au préalablement été ajouté ?
Vérifier que le test carRentalAddRemove et valide. Si non, expliquer quel est le problème et corrigé le.
5. L'affichage d'une instance de la classe `CarRental` devra afficher l'ensemble des véhicules de la liste, séparés par des retours à la ligne (sans retour à la ligne final !), Ecrire le code correspondant.
6. Ecrire une méthode `toSell` qui ne prend pas de paramètre et renvoie une liste contenant les véhicules que le loueur de véhicule doit vendre sachant qu'un loueur de véhicule vend ceux-ci dès qu'ils ont au moins deux ans (compris).
Note: l'année courante s'obtient avec le code suivant:
```Java
int currentYear = LocalDate.now().getYear();
```

7. L'application que vous developpez doit aussi être vendu en Egypte où malheureusement, il n'est pas rare de ne pas trouver d'essence. Pour éviter de mettre la clé sous la porte, les loueurs de voiture ont trouvé une solution de secours en louant aussi des chameaux.
Modifier le code de votre application pour permettre de louer non plus uniquement des véhicules mais aussi des chameaux, sachant qu'un chameau possède juste une date de naissance et son affichage est "camel" suivi d'un espace et de sa date de naissance.
Par exemple, le code suivant devra fonctionné
```Java
8. CarRental rental = new CarRental();
rental.add(new Car("ford mustang", 2014));
rental.add(new Camel(2010));
```


La méthode `toSell` renverra une liste constituée de véhicules et de chameaux.
En terme de design, faite en sorte que si plus tard l'ont doivent ajouter une classe `SpaceShuttle` pour gérer les navettes spaciales, alors il ne soit pas nécessaire de remodifier la classe `CarRental`.
8. Si vous ne l'avez pas déjà fait, modifier votre code pour que la date de fabrication d'un véhicule et de naissance d'un chameau corresponde à un seul et même champ partagé par les classes `Car` et `Camel`.
9. En fait, si une voiture n'est pas gardé plus de 2 ans, dans le cas des chameaux, ceux-ci sont gardés 5 ans et pas 2 car contrairement aux véhicules, il n'est pas facile pour un client de faire la différence entre un jeune chameau et un chameau plus si jeune que cela.
Modifier votre code pour que les chameaux ne soit considéré à vendre qu'au bout de 5 ans (compris).
Attention, l'hypothétique introduction de la classe `SpaceShuttle` que l'on devra garder par exemple 10 ans devra aussi se faire sans modifier la classe `CarRental`.
10. Enfin, écrire dans la classe `CarRental`, une méthode `findACarByModel` qui permet de trouver un véhicule à partir de son modèle passé en paramètre. Cette méthode retourne un objet de type Optional pour prendre en compte le cas où il n'existe pas de véhicule du modèle demandé.
11. Si il vous reste un peu de temps, vou pouvez ré-écrire les méthodes `toString`, `toSell` et `findACarByModel` et utilisant l'API  [java.util.stream](https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html).