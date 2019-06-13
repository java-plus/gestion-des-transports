En tant qu'administrateur, je souhaite pouvoir gérer le cycle de vie d'un véhicule de société.

# Critères d'acceptation

![](https://github.com/DiginamicFormation/ressources-atelier/raw/master/gestion-du-transport/admin.vehicules.details.cyclevie.png)

* [ ] Le statut du véhicule est désormais visible de la page de details d'un véhicule. Les statuts possibles :
    * EN SERVICE
    * EN REPARATION
    * HORS SERVICE
* [ ] Le bouton _Mettre en réparation_ n'est accessible que si le véhicule est au statut _EN SERVICE_ ou _HORS SERVICE_.
* [ ] Le bouton _Mettre en service_ n'est accessible que si le véhicule est au statut _HORS SERVICE_ ou _EN REPARATION_.
* [ ] Le bouton _Hors service_ n'est accessible que si le véhicule est au statut _EN SERVICE_ ou _EN REPARATION_.
* [ ] Le bouton _Mettre en réparation_ permet de passer le véhicule au statut _EN REPARATION_.
* [ ] Le bouton _Mettre en service_ permet de passer le véhicule au statut _EN SERVICE_.
* [ ] Le bouton _Hors service_ permet de passer le véhicule au statut _HORS SERVICE_.
* [ ] Seules les véhicules ayant le statut _EN SERVICE_ peuvent être réservés.
* [ ] Lorsqu'un véhicule passe à l'état _HORS SERVICE_ ou _EN REPARATION_.
    * [ ] Toutes les réservations en cours associées au véhicule sont annulées
    * [ ] Un email est envoyé aux collaborateurs concernés.


