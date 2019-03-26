# Muistipeli

Sovellus on nimensä mukaisesti muistipeli. Pelissä siis on erilaisia objekteja, joilla on pari.
Käyttäjä eli pelaaja pelaa muistipeliä valitsemalla yksittäisiä objekteja, aina kaksi objektia vuorolla.
Jos objektit ovat toistensa parit, pelaaja saa pisteen ja pari poistuu pelilaudalta. Tätä jatketaan,
kunnes pelissä vaadittu tavoite tai aikaraja saavutetaan.

Käyttäjäroolia sovelluksessa varsinaisesti ole, pelaajille voidaan peli ajaksi antaa nimimerkit, jotka
pidetään tallessa pelierän verran, tai talletetaan pistetaulukkoon.

Toiminnallisuudet: 

* Yksinpeli
	* Peli aikarajaa vastaan, pisteet talletetaan nimimerkin kera pistetaulukkoon
* Moninpeli
	* Ilmottautuneiden nimimerkkien verran pelaajia toisiaan vastaan
	* Pelaajat pelaavat vuorollaan
	* Voittaja on eniten pisteitä kerännyt, kun pelilauta on tyhjä
	* Pisteitä ei talleteta taulukkoon
* Pelitavat
	* Sanat objekteina
	* Vaikeustasoa nostaessa esimerkiksi
		* Samoja sanoja erivärisinä objekteina
* Rajoitteet
	* Pistetaulukko tallennetaan paikalliseen muistiin tietokantaan
* Jatkokehitysideoita
	* Kuvakortteja objektipareina
	* Vaikeustason nosto objektiparien määrää kasvattamalla
	* Pelitapana objektiparit, jotka ovat laskutoimituksia. Pareja ovat saman vastauksen saavat laskut

