# API-Meteo

Une API REST développée avec Spring Boot permettant de récupérer les données météorologiques d'une ville. Elle intègre un système de cache avec **Redis** pour optimiser les performances et limiter les appels à l'API externe.

## 📋 Prérequis

- Java (JDK 17 ou supérieur recommandé)
- Maven
- Docker et Docker Compose

## 🚀 Installation et Lancement

### 1. Démarrer la stack Redis

Pour que le cache fonctionne, vous devez d'abord lancer Redis via Docker. Accédez au dossier `weather_api` (qui contient la configuration Docker) et démarrez le conteneur en arrière-plan :

```bash
cd weather_api
docker compose up -d
```

### 2. Lancer l'application Spring Boot

Revenez à la racine du projet, puis lancez l'application avec le plugin Maven Spring Boot :

```bash
cd ..
mvn spring-boot:run
```

### 3. Tester l'API

Une fois l'application démarrée (par défaut sur le port 8080), vous pouvez tester l'API en interrogeant la météo pour une ville, par exemple Paris. Ouvrez votre navigateur ou utilisez `curl` sur l'URL suivante :

http://localhost:8080/api/weather/Paris

_💡 Note : Lors du premier appel, vous verrez dans les logs `Appel API externe pour : Paris`. Les appels suivants pour la même ville seront instantanés et ne déclencheront pas d'appel externe grâce à la mise en cache Redis !_

### 4. Arrêter l'environnement

Une fois vos tests terminés, vous pouvez arrêter et supprimer le conteneur Redis avec la commande suivante (en vous replaçant dans le dossier `weather_api`) :

```bash
cd weather_api
docker compose down
```
