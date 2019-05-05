# Käyttöohjeet


* Lataa tiedosto Muistipeli-1.0-SNAPSHOT.jar ja tekstitiedostot animaldeck.txt ja plantdeck.txt [täältä](https://github.com/ArttuJanhunen/ot-harjoitustyo/releases)
* Varmista, että kaikki kolme tiedostoa löytyvät samasta kansiosta
* Käynnistä sovellus terminaalista komennolla 'java -jar Muistipeli-1.0-SNAPSHOT.jar'
* Sovelluksen käynnistyttyä ensimmäisenä avautuu päävalikko
* Päävalikosta voit navigoida napeilla yksinpeliin, moninpeliin, tuloslistaan tai pakan valintaan
* Yksinpeli
	* Aika alkaa kulumaan, kun näkymä muuttuu pelinäkymäksi
	* Kortteja painamalla ne paljastavat sanan
	* Kun kaksi korttia ovat paljastettuina, ne palaavat piilotetuiksi painamalla kääntämätöntä korttia
	* Jos kortit ovat pari, niiden tekstiksi muuttuu 'löydetty' painamalla kääntämätöntä korttia
	* Viimeinen pari tarkastetaan 'Tarkasta'-napilla, jolloin aika pysähtyy
	* Halutessaan oman nimensä voi lisätä huipputuloslistaan syöttämällä sen alavasemmalle kenttään pelin loputtua ja painamalla nappia 'Tallenna tuloksesi'
	* Nimen on oltava 1-20 merkkiä pitkä
	* Päävalikkoon pääsee takaisin painamalla nappia 'Poistu'
* Moninpeli
	* Vasemmassa alareunassa näkyy kumman pelaajan vuoro on
	* Peli toimii kuten yksinpelikin, kahden käännetyn kortin jälkeen kääntämätöntä korttia painamalla vuoro vaihtuu
	* Viimeinen pari tarkastetaan 'Tarkasta'-napilla
	* Enemmän pisteitä saanut pelaaja voittaa. Tasapeli on myös mahdollinen
	* Valikkoon voi palata napilla 'Poistu'
* Huipputulokset
	* Listassa yksinpelien nopeimmat pelaajat nopeimmasta lähtien
	* 'Takaisin valikkoon'-nappi vie takaisin päävalikkoon
* Pakan valinta 
	* Valikkonäkymässä ylin nappi, 'Takaisin valikkoon' vie päävalikkoon
	* Painamalla nappia 'Eläimet' valitset käyttöön pakan, jossa on eläinten nimiä
	* Painamalla nappia 'Kasvit' valitset käyttöön pakan, jossa on kasvien nimiä
	* Oletusarvoisena pakkana ohjelmaa käynnistettäessä on eläinaiheinen pakka

