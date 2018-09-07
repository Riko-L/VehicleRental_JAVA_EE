# VehicleRental_JAVA_EE


# Campus numérique - Partie Alternance - Module JAVA/JEE

# 1.  Objectifs
*	Renforcer les compétences acquises lors du premier module Java, et valider les compétences non validées
*	Apprendre les bases du Framework JEE
*	compétences JEE:
	*	Utilisation d'une Servlet
	*	Créer une page JSP
	*	Contrôler les données d'un formulaire
	*	Utilisation de la JSTL
	*	Utilisation de EL
	*	Utilisation de JDBC
	*	Sécuriser l'accès à l'application via l'authentification
	*	Savoir mettre en oeuvre des javaBeans

# 2  Contraintes
*	Eclipse
*	Tomcat
*	MySQL

# 3.  Sujet - Location de véhicule
Dans le cadre de l’automatisation et de l’informatisation de ses process, la société VehicleRental cherche à développer un système permettant la gestion de leur flotte de véhicule ainsi que de permettre à leurs clients de réserver un véhicule en ligne. Vous êtes en charge de la conception ainsi que de la réalisation de ce système. Dans ce but un premier intervenant a déjà réalisé le recueil des besoins et défini les différentes use cases. Il a également choisi la technologie pour la réalisation du projet et mis en place l’architecture applicative. Ainsi la société VehicleRental recherche un développeur JAVA, avec de bonnes notions du framework JEE. Débutants acceptés :) .

Après un entretien pour le poste que vous avez réussi avec brio (félicitations), vous convenez avec le client de développer son application en utilisant la méthode agile. Il est donc convenu de réaliser le projet en 6 itérations. Cependant les délais étant un peu court les deux dernières représentent le ‘nice-to-have’. Pour chaque itérations, le client vous a fourni le use à développer ainsi que les différentes règles métiers à respecter.

Le précédent intervenant a déjà mis en place l’architecture du code et réaliser un POC (proof of concept) validant ses choix. Ce POC réalise l’affichage de liste des clients. Il pourrait être utile de vous en inspirer pour réaliser les prochaines itérations.

# 4.  Modalités

Le projet s'effectue en binome. Chaque binome sera en charge de rendre un seul livrable.
Le but est de trouver une manière efficace de se répartir le travail pour permettre de réaliser chaque use case.

# 5.  Spécifications

# Itération 1 : Lister les véhicules

## Travail à réaliser :
VehiculeRental a acquis un nombre important de véhicule pour pouvoir disposer d’une flotte convenable. Leur besoin le plus urgent est donc de pouvoir afficher la liste de tous les véhicules qu’ils possèdent.
## Règles métiers :
*	Un véhicule est représenté par une immatriculation unique
*	Il possède une marque, un modèle et une couleur
*	Un véhicule dispose d’un prix de réservation qui permet de couvrir les frais de dossier et le nettoyage du véhicule
*	Il dispose également d’un tarif kilométrique permettant de couvrir l’usure du véhicule
*	Un nombre de chevaux fiscaux

## Livrable attendu :
Une simple démonstration du use case suffit

# Itération 2 : Réserver un véhicule

## Travail à réaliser :

VehiculeRental souhaite dans un second temps disposer du use case permettant à un client de réserver une voiture.

## Règles métiers :
### Client
*	Un client est défini par nom, un prénom
*	Il est important de pouvoir de posséder la date de naissance du client ainsi que la date d’obtention de son permis de conduire pour savoir quel sera le prix de l’assurance
*	Le numéro de permis du client est enregistré afin de pouvoir être fournis aux autorités si un problème devait survenir.
### Réservation
*	Une réservation est une association entre un client et un véhicule
*	Une réservation a toujours une date de début et une date de fin
*	Un client ne peut réserver qu’un seul véhicule à la fois
*	Le véhicule souhaité par le client doit être disponible entre la date de début et la date de fin
*	Un client doit au moins avoir 18 ans et posséder le permis de conduire pour réserver un véhicule
*	Un conducteur de moins de 21 ans ne peut pas louer un véhicule possédant 8 chevaux fiscaux ou plus
*	Un conducteur entre 21 et 25 ans ne peut louer que des véhicules de moins de 13 chevaux fiscaux.
*	Lors de la réservation, le client doit estimer le nombre de km qu’il compte faire. Le prix de location est calculé en fonction de cette estimation. Bien entendu si cette estimation est dépassée ou surestimé un réajustement est effectué lors du rendu de véhicule
*	Le prix d’une location est le suivant : prix de base + prix au km * nb de km

## Livrables attendus :

Puisque le système de réservation correspond au use case le plus important aux yeux du client, ce dernier souhaite disposer de diagrammes UML pour valider la solution mise en place. Il vous est demandé de fournir un diagramme de classe ainsi qu’un diagramme de séquence de votre solution.
Naturellement le client souhaite également pouvoir assisté à une démonstration du use case.

# Itération 3 : Diversifier les offres

## Travail à réaliser :
VehicleRental souhaite étendre la gamme de véhicule pouvant être réservé. Ils prévoient ainsi de pouvoir louer différent type de véhicule. Ainsi la flotte comptera à l’avenir en plus des voitures, une gamme de moto ainsi qu’une gamme d’utilitaire. Chaque type de véhicule est régi par des règles différentes.
## Livrables attendus
### Moto

*	Une moto possède une cylindrée exprimée en cm3
*	Le calcul du prix pour une moto est le suivant : cylindrée * 0.001 * prix au km * nb de km + prix de base
### Utilitaire

*	Un utilitaire possède un volume de chargement exprimé en m3
*	Le calcul du prix pour un utilitaire est le suivant : volume * 0.05 * prix au km * nb de km + prix de base
## Livrables attendus :

Le client aimerait pouvoir valider la solution, il lui faudrait dans ce but les diagrammes de classes et de séquence pour cette itération. 
Il faudra également produire une démonstration du use case.

# Itération 4 : Ajout d’un utilisateur agent

## Travail à réaliser :

En plus des clients utilisant le site internet pour réserver des véhicules, VehicleRental dispose d’agents qui peuvent eux même effectuer des opérations sur les réservations. Ce dernier peut également effectuer des remises exceptionnelles sur des locations.
## Règles métiers :

*	L’agent peut créer mais aussi supprimer des réservations
*	Un agent peut appliquer une remise sur une promotion si une des conditions suivantes est respectée :
	*	Le client a déjà effectué au moins 3 réservations
	*	Le client a dépensé 1000 euros ou plus en location
## Livrables attendus :

Le client aimerait pouvoir valider la solution, il lui faudrait dans ce but les diagrammes de classes et de séquence pour cette itération. 
Il faudra également produire une démonstration du use case.

# Itération 5 (optionnelle) : Entretien des voitures

## Travail à réaliser :
Pour maximiser la durée de vie de chaque véhicule VehicleRental souhaite disposer d’une fonctionnalité permettant de vérifier pour chaque véhicule si un entretien doit être effectué sur ce dernier.

## Règles métiers :

L’entretien d’un véhicule rend ce dernier indisponible à la location le temps que ce dernier soit effectué. Le temps varie selon le type d’entretien effectué.
### Moto
*	La chaine des motos doit être retendue tous les 1000 km ou tous les ans. Temps d’indisponibilité : 1 journée
*	Le liquide de frein doit être changé tous les ans. Temps d’indisponibilité : 1 journée
### Utilitaire et voiture
*	La courroie de distribution doit être changée tous les 100 000 Km. Temps d’indisponibilité : 3 journées
*	Les pneus sont changés chaque année. Temps d’indisponibilité : 1 journée
Utilitaire
*	Les suspensions sont changées tous les 2 ans. Temps d’indisponibilité : 2 journées

## Livrables attendus :
Le client aimerait pouvoir valider la solution, il lui faudrait dans ce but les diagrammes de classes et de séquence pour cette itération. 
Il faudra également produire une démonstration du use case.

# Itération 6 : Multi sites

## Travail à réaliser :
VehicleRental prévoit une expansion rapide de son chiffre d’affaire. Ils prévoient donc d’ouvrir plusieurs autres agences en France. Ils souhaiteraient donc que l’application soit capable de gérer la location d’un véhicule dans un site A et le retour de ce dernier dans un site B.
## Règles métiers :
*	Un véhicule loué sur site A et rendu sur un site B ne doit plus être disponible sur le site A et disponible sur le site B
*	Chaque site dispose d’un nombre de place limités. Ainsi un véhicule ne peut être rendu sur un autre site seulement si ce dernier dispose d’assez de place.  

## Livrables attendus :
Le client aimerait pouvoir valider la solution, il lui faudrait dans ce but les diagrammes de classes et de séquence pour cette itération. 
Il faudra également produire une démonstration du use case.

# Ressources

*	Tuto open classroom : https://openclassrooms.com/fr/courses/626954-creez-votre-application-web-avec-java-ee
*	Vidéo : https://www.youtube.com/watch?v=jevdND1NBVs&list=PLepmdz3mDsCpOcLtmn3r8UKfsjGSeDmma&index=1
*	Documentation oracle : https://docs.oracle.com/javaee/5/tutorial/doc/docinfo.html (attention à ne pas se perdre,  tout n’est pas utilisé dans le TP)

