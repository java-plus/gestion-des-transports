En tant que collaborateur, je souhaite réserver une place dans un covoiturage pour effectuer un déplacement professionnel.

# Critères d'acceptation

## Page Réserver un covoiturage

![](https://github.com/DiginamicFormation/ressources-atelier/raw/master/gestion-du-transport/collab.reservations.reserver.covoiturage.png)

* [ ] La page de réservation d'un covoiturage est accessible via le chemin _/collaborateur/reservations/creer_.
* [ ] La rubrique "Covoiturage" est repliable (dépliée par défaut)
* [ ] Les saisies des adresses sont assistées.
* [ ] Seules les adresses reconnues par l'assistant sont prises en compte.
* [ ] Par défaut, aucun covoiturage est listé.
* [ ] Tant que l'utilisateur n'a pas saisi le lieu de départ, aucun covoiturage est listé.
* [ ] Une fois, le lieu de départ rempli, la liste des covoiturages correspondante aux critères s'affiche.
 * [ ] Les covoiturages n'ayant plus de places disponibles sont affichés et les boutons _Réserver_ ne sont pas accessibles pour cette catégorie.
* [ ] Un clic sur le bouton _Réserver_ affiche une fenêtre modale de confirmation du covoiturage.
* [ ] Le lien _Retour à la liste_ rediririge l'utilisateur vers la page de liste des réservations.
* [ ] Les rubriques _Durée du trajet_ et _Distance_ sont automatiquement mises à jour à chaque fois que les adresses sont modifiées.

## Fenêtre de confirmation

![](https://github.com/DiginamicFormation/ressources-atelier/raw/master/gestion-du-transport/collab.reservations.reserver.covoiturage.confirmation.png)

* [ ] La fenêtre de confirmation contient les informations du covoiturage
* [ ] Un clic sur le bouton _Annuler_, ferme la fenêtre modale
* [ ] Un clic sur le bouton _Confirmer_, réserve un place dans le covoiturage.
  * La réservation est sauvegardée en base de données
  * Le nombre de places disponibles est décrémenté.
  * La fenêtre modale est fermée
  * L'utilisateur est rediririgé vers la page de liste des réservations.
  