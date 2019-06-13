En tant que collaborateur, je souhaite pouvoir publier une annonce de covoiturage afin de ne pas voyager seul.

# Critères d'acceptation

![](https://github.com/DiginamicFormation/ressources-atelier/raw/master/gestion-du-transport/collab.annonces.publier.png)

* [ ] La page de publication d'un covoiturage est accessible via le chemin _/collaborateur/annonces/creer_.
* [ ] Les saisies des adresses sont assistées.
* [ ] Seules les adresses reconnues par l'assistant sont prises en compte.
* [ ] Le nombre de places disponibles est un nombre compris entre 1 et 20.
* [ ] Les rubriques _Durée du trajet_ et _Distance_ sont automatiquement remplis lorsque les adresses sont saisies et qu'elles sont valides.
* [ ] Les heures sont proposées par dizaine (00, 10, 20, 30, 40, 50).
* [ ] Les messages de validations attendus :
  * L'adresse de départ est une adresse inconnue
  * L'adresse de destination est une adresse inconnue
  * Le nombre de places doit être compris entre 1 et 20.
  * La date et l'heure sont obligatoires
  * La date et l'heure ne peuvent être antérieure à aujourd'hui.
  * La marque est obligatoire.
  * Le modèle est obligatoire.
* [ ] Le bouton _Publier_ n'est actif que lorsque tous les champs sont valides.

![](https://github.com/DiginamicFormation/ressources-atelier/raw/master/gestion-du-transport/collab.annonces.publier.confirmation.png)

* [ ] La fenêtre de confirmation contient les informations du covoiturage
* [ ] Un clic sur le bouton _Annuler_, ferme la fenêtre modale
* [ ] Un clic sur le bouton _Confirmer_, publie l'annonce de covoiturage.
  * La publication est sauvegardée en base de données
  * La fenêtre modale est fermée
  * Les champs du formulaire sont réinitalisés