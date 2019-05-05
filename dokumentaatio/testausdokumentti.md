# Testausdokumentti

Ohjelmaa on testattu itse pelaamalla ja kokeilemalla erilaisia toimintoja sekä luomalla JUnit-testejä
testaamaan ohjelman toimintaa.

## Testaus

### Sovelluslogiikka

Sovelluslogiikkaa testaavat testit ovat luokissa CardTest, DeckTest, DeckInitiatorTest ja PlayerTest.
Niillä on pyritty simuloimaan kaikki eri toimintahaarat, joita luokkien metodit voivat toteuttaa.

### DAO

PlayerDao-luokkaa testaa testiluokka PlayerDaoTest. Testejä varten luodaan hetkellisesti tekstitiedosto,
joka poistetaan testin lopuksi. 

### Testauskattavuus

Käyttöliittymä poisluettuna sovelluksen testien rivikattavuus on 99% ja haaraumakattavuus 100%
![Testikattavuus](https://github.com/ArttuJanhunen/ot-harjoitustyo/blob/master/dokumentaatio/Testikattavuus.png)

## Järjestelmätestaus

Sovellus on manuaalisesti järjestelmätestattu.

### Asennus

Sovellus toimii Linux-ympäristössä olettaen, että samassa kansiossa sijaitsee myöskin pakkatiedostot
animaldeck.txt ja plantdeck.txt. Huipputulosten lista luodaan kansioon, jossa peli sijaitsee, jos
se ei ole vielä olemassa. 

Sovelluksen toimintaa on myös kokeiltu Windows-ympäristössä. Ääkkösten rikkoutumista lukuunottamatta
sovellus toimi toivotulla tavalla.

## Laatuongelmat

Sovellus ei toimi jos pakkatiedostoja ei ole. Korttien kääntämisessä tarvitaan ylimääräinen painallus
kääntämättömään korttiin ja lopussa tarkastus-nappiin. Tätä koitettiin ratkaista viivetoteutuksella
ilmeisen huonolla menestyksellä.
