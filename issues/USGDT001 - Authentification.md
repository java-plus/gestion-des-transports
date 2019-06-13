En tant qu'employé (tous profils confondus), je souhaite pouvoir m'authentifier afin de pouvoir accéder aux fonctionnalités de l'application.

# Critères d'acceptation :

* [ ] L'application donne accès à une page d'authentification
* [ ] La page d'authentification est accessible via le chemin _/connexion_.
* [ ] La page d'authentification contient un logo (proposé par le développeur)
* [ ] La page d'authentification contient le titre GDT - Gestion Du Transport
* [ ] La page d'authentification les champs Email et Mot de passe
* [ ] Le bouton "Se connecter" permet de valider les informations saisies
* [ ] Si les informations saisies ne permettent pas d'authentifier l'utilisateur, le message d'erreur "Vos informations d'authentification sont invalides.".
* [ ] En cas d'authentification avec succès
  * [ ] Si l'employé a le profil _COLLABORATEUR_ (profil par défaut), il est redirigé vers la page par défaut des collaborateurs
  * [ ] Si l'employé a le profil _CHAUFFEUR_:
    * Une fenêtre modale s'affiche l'invitant à choisir un profil entre _COLLABORATEUR_ et _CHAUFFEUR_.
    * L'utilisateur est redirigé ensuite vers la page par défaut du profil sélectionné.
  * [ ] Si l'employé a le profil _ADMINISTRATEUR_ : 
    * Une fenêtre modale s'affiche l'invitant à choisir un profil entre _COLLABORATEUR_, _CHAUFFEUR_ et _ADMINISTRATEUR_. 
    * L'utilisateur est redirigé ensuite vers la page par défaut du profil sélectionné.
* [ ] Les chemins de l'application sont sécurisés :
  * _/collaborateur/**_ : accessible pour tout utilisateur connecté
  * _/chauffeur/**_ : accessible pour tout chauffeur et administrateur
  * _/administrateur/**_ : accessible pour tout administrateur.
  
![](https://github.com/DiginamicFormation/ressources-atelier/raw/master/gestion-du-transport/tous.connexion.png)
![](https://github.com/DiginamicFormation/ressources-atelier/raw/master/gestion-du-transport/tous.connexion.erreur.png)
![](https://github.com/DiginamicFormation/ressources-atelier/raw/master/gestion-du-transport/tous.connexion.choixprofil.png)
