En tant qu'administrateur, je souhaite pouvoir accéder à la liste des véhicules de société afin de pouvoir les visualiser.

# Critères d'acceptation

![](https://github.com/DiginamicFormation/ressources-atelier/raw/master/gestion-du-transport/admin.vehicules.liste.png)

* [ ] La page de liste de véhicules est accessible via le chemin _/admin/vehicules/_.
* [ ] Pour chaque véhicule, les informations suivantes sont affichées :
  * Immatriculation
  * Marque
  * Modèle
  * Catégorie
* [ ] Il est possible de filtrer la liste par _Immatriculation_ ou par _marque_.
* [ ] Un clic sur le bouton _Ajouter un véhicule_ ouvre une fenêtre modale d'ajout d'un nouveau véhicule.

![](https://github.com/DiginamicFormation/ressources-atelier/raw/master/gestion-du-transport/admin.vehicules.liste.ajouter.png)

* [ ] Tous les véhicules de la société ont été immatriculés après 2009. Le format de l'immatriculation attendue est donc XX-NNN-XX (sept caractères alphanumériques : deux lettres, trois chiffres et deux lettres, les trois parties étant séparées par des tirets).
* [ ] Tous les champs sont obligatoires.
* [ ] Le bouton _Ajouter_ n'est actif que si tous les champs ont un format attendu.
* [ ] Le champ _Photo_ représente une URL accessible en ligne.
* [ ] Le champ _Categorie_ correspond au segment automobile européen : 
  * Micro-urbaines
  * Mini-citadines
  * Citadines polyvalentes
  * Compactes
  * Berlines Taille S
  * Berlines Taille M
  * Berlines Taille L
  * SUV, Tout-terrains et Pick-up
