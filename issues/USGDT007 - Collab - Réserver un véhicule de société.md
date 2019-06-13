En tant que collaborateur, je souhaite réserver un véhicule de société pour effectuer un déplacement professionnel.

# Critères d'acceptation

![](https://github.com/DiginamicFormation/ressources-atelier/raw/master/gestion-du-transport/collab.reservations.reserver.vehicule.societe.png)

* [ ] La page de réservation d'un véhicule de société est accessible via le chemin _/collaborateur/reservations/creer_.
* [ ] La rubrique "Véhicule de société" est repliable (dépliée par défaut)
* [ ] Les véhicules de société sont accessibles l'un après l'autre.
* [ ] les véhicules indisponibles sont affichés mais non accessible à la réservation.

![](https://github.com/DiginamicFormation/ressources-atelier/raw/master/gestion-du-transport/collab.reservations.reserver.vehicule.societe.indispo.png)

* [ ] Le lien _Retour à la liste_ rediririge l'utilisateur vers la page de liste des réservations.
* [ ] Un clic sur le bouton _Réserver_ affiche une fenêtre modale de confirmation du réservation.


![](https://github.com/DiginamicFormation/ressources-atelier/raw/master/gestion-du-transport/collab.reservations.reserver.vehicule.societe.confirmation.png)

* [ ] La fenêtre de confirmation contient les informations du réservation
* [ ] Un clic sur le bouton _Annuler_, ferme la fenêtre modale
* [ ] Un clic sur le bouton _Confirmer_, réserve le véhicule :
  * La réservation est sauvegardée en base de données
  * La fenêtre modale est fermée
  * L'utilisateur est rediririgé vers la page de liste des réservations.
  