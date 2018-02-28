# SIR : TPOPOWER - Servlet

Avant de tester le projet, vous devez lancer le fichier 'run-hsqldb-server.bat' (ou .sh sur linux et mac). Cela permet de lancer une base de donnée.
Vous pouvez aussi changer dans la classe '' le 'dev' par 'mysql' afin d'utiliser votre propre base de donnée mysql, dont les informations de configuration sont à spécifié dans le fichier 'persistence.xml'

Vous pouvez ensuite lancer le service Java à l'aide de maven. Il vous suffit de lancer tomcat7:run 

Le service est disponible sur localhost:8090

Pour tester le projet, importé comme projet Maven dans votre IDE préféré 

# Api routes

Ressource utillisé : application/json
URI de base : "localhost:8090/"


| Methode     | URL | Action   |
| :------- | ----: | :---: |
| GET    | /person  |  renvoi toute les personnes   |
| GET    | /person/{id}  |  renvoi la personne associé à l'id passé en paramètre   |
| POST    | /person  |  créer une nouvelle personne  |
| DELETE    | /person/{id}  |  supprimé la personne associé à l'id passé en paramètre   |
| GET    | /home  |  renvoie tout les maisons   |
| GET    | /home/{id}  |  renvoie la maison associé à l'id passé en paramètre   |
| POST    | /home  |  créer une maison  |


## Parameter for POST requests :

 ### /person : 
 
 - nom : String
 - prenom : String
 - email  : String


 ### /home : 
 
 - taille : Integer
 - nbP : Integer