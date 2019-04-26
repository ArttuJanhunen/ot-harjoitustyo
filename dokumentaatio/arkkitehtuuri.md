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

# Sekvenssikaavio
![Sekvenssikaavio](https://github.com/ArttuJanhunen/ot-harjoitustyo/blob/master/dokumentaatio/sekvenssikaavio.png)
