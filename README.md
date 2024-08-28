# Gestion Centre d'Appel WeHelp

## Description

WeHelp est une application Spring Boot qui permet de gérer les opérations d'un centre d'appels. L'application offre des fonctionnalités complètes pour la gestion des clients, des agents, des réclamations et des tickets, avec une interface administrateur pour la gestion avancée des agents et des clients. Le système utilise une base de données Oracle pour stocker les informations et fournit des fonctionnalités de reporting pour les réclamations.

## Fonctionnalités

- **Authentification des Utilisateurs :** Connexion sécurisée pour les clients, agents et administrateurs.
- **Gestion des Clients :** Les clients peuvent se connecter, soumettre des réclamations, et gérer leurs informations personnelles.
- **Gestion des Agents :** Les agents peuvent se connecter, gérer leur profil, et traiter les réclamations en cours.
- **Gestion des Administrateurs :** Les administrateurs peuvent ajouter, modifier et supprimer des agents, consulter les listes de clients et de réclamations, et générer des rapports statistiques.
- **Gestion des Réclamations :** Les réclamations peuvent être créées par les clients, suivies et traitées par les agents, avec des détails sur la date, la description et le statut.
- **Gestion des Tickets :** Les tickets sont créés pour suivre les réclamations et peuvent être modifiés ou clôturés par les agents.
- **Reporting :** Génération de rapports sur les réclamations soumises, résolues, en attente, etc.

## Diagramme de Classe

Le diagramme de classe de l'application modélise les différentes entités et leurs relations, notamment les classes `Client`, `Agent`, `Admin`, `Reclamation`, et `Ticket`.

## Structure du Projet

- **`src/main/java/com/example/sprinprojet`** : Contient les classes Java, y compris les modèles, les contrôleurs, les services, et les repositories.
- **`src/main/resources`** : Contient les fichiers de configuration, y compris `application.properties`.

## Prérequis

- **Java 17** ou plus récent
- **Maven 3.8.1** ou plus récent
- **Spring Boot 3.0.0** ou plus récent
- **Base de données :** Oracle

## Installation

1. Clonez le dépôt du projet :
   ```bash
   git clone https://github.com/salma-lam/gestion-centre-d-appel.git
