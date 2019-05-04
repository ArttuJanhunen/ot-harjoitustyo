# Sovelluksen pakkausrakenne
![Pakkausrakenne](https://github.com/ArttuJanhunen/ot-harjoitustyo/blob/master/dokumentaatio/Pakkausrakenne.png)

Pakkauksessa muistipeli.ui sisältää JavaFX -käyttöliittymän, muistipeli.logics sovelluslogiikan ja
muistipeli.dao huipputulosten pysyväistallennuksen

# Luokkakaavio
![Kaavio](https://github.com/ArttuJanhunen/ot-harjoitustyo/blob/master/dokumentaatio/Luokkakaavio.png)

### Sovelluslogiikan kuvaus
Sovelluslogiikkaan kuuluvia luokkia on neljä: Card, Deck, DeckInitiator ja Player. Card toteuttaa
yksittäisen kortin rakenteen, ja Deck vastaa korttien kokonaisuudesta, pakasta. DeckInitiatorin tehtävänä
on toteuttaa pakan alustaminen. Player-luokka on on apuna toteuttamassa huipputuloslistan järjestämistä,
sillä se implementoi Comparable-ominaisuuden aikapohjaisen vertailun mahdollistamiseksi.

### Käyttöliittymän kuvaus
Käyttöliittymässä on omat näkymänsä valikolle, yksinpelille, moninpelille ja huipputuloksille.
Käyttöliittymä löytyy luokasta com.mycompany.muistipeli.ui.GraphicInterface.

Kaikki eri näkymät ovat Scene-olioita. Käyttöliittymä ottaa käyttöönsä kaikki sovelluslogiikan luokat
ja toteuttaa niiden avulla pelin toiminnallisuudet. Käyttöliittymällä on muutama oma metodi, joiden 
avulla saadaan hyödynnettyä sovelluslogiikkaa ja manipuloitua pelin näppäinten tekstejä.

### Sovelluksen pysyväistiedostojen hyödyntäminen
DeckInitiatorille ei erillistä dao-luokkaa ole luotu, sillä kyseinen luokka käyttää vain yhtä
metodia tiedostoja varten. ChooseDeck-metodi lukee annetun tiedoston ja alustaa sen sisällöllä
väliaikaismuistissa olevan listan, josta pakka saa korttinsa. PlayerDao sen sijaan vastaa pelaajien
tietojen lukemisen tiedostosta ja niitten tallettamisen tiedostoon. PlayerDao luo automaattisesti
tiedoston huipputuloksia varten, jos sitä ei jo löydy.

### Tiedostot
Sovelluksen mukana tulee kaksi tiedostoa, animaldeck.txt ja plantdeck.txt. Kummankin sisältönä on
kymmenen sanaa omilla riveillään. Näiden pohjalta DeckInitiator saa alustettua Deck-luokan pakan.
Sovellus luo huipputuloslistan nimeltään highscores.txt. Sen sisään talletettava tieto on väliaikais
-muistista löytyvät pelaajien huipputulokset, jotka talletetaan muodossa pelaajannimimerkki;aika.


# Sekvenssikaavio
![Sekvenssikaavio](https://github.com/ArttuJanhunen/ot-harjoitustyo/blob/master/dokumentaatio/sekvenssikaavio.png)

## Heikkoudet rakenteessa

### Käyttöliittymä
Käyttöliittymä on muutamaa apumetodia lukuunottamatta määritelty kokonaan GraphicInterface-luokan
start -metodissa. Eri Scene-olioiden eriyttäminen esimerkiksi omaan luokkaansa auttaisi jo paljon. 
Myös nappien tilanmuutokset voisi toteuttaa metodeilla. 
