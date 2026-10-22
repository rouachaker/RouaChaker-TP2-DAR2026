# TP2 - Activité 2-1

## Développement d'applications réparties

### Objectif

Cette activité consiste à améliorer une application Client/Serveur TCP
afin de permettre l'échange de chaînes de caractères représentant
des opérations arithmétiques complètes.

Le client envoie l'opération au serveur.

Le serveur reçoit l'opération, effectue le calcul et renvoie le résultat.

Le client reçoit ensuite le résultat et l'affiche.

## Étape 1 : Lancement du serveur

Le serveur est lancé avant le client et se met en attente d'une connexion.

![](cap/serv-att.png)

## Étape 2 : Connexion du client

Le client établit une connexion TCP avec le serveur.

![](cap/client-cnct.png)

## Étape 3 : Envoi de l'opération

Le client saisit une opération telle que :

55 * 25

L'opération est ensuite envoyée au serveur.

![](cap/3.png)

## Étape 4 : Traitement par le serveur

Le serveur reçoit l'opération, réalise le calcul et renvoie le résultat.

Exemple :

55 * 25 = 1375

![Console du client](cap/4.png)
## Étape 5 : Réception du résultat

Le client reçoit le résultat envoyé par le serveur et l'affiche.

![Console du client](cap/reponsa.png)

## Tests

Multiplication :
55 * 25 = 1375
![](cap/reponsa.png)

Addition :
10 + 20 = 30
![](cap/add.png)

Soustraction :
50 - 15 = 35
![](cap/soust.png)

Division :
100 / 4 = 25.0
![](cap/div.png)

## Conclusion

Cette activité nous a permis de manipuler les sockets TCP en Java
ainsi que les flux de traitement de chaînes de caractères avec
BufferedReader et PrintWriter.