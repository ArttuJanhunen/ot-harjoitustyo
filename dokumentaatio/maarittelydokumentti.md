# Muistipeli

Sovellus on nimensä mukaisesti muistipeli. Pelissä siis on erilaisia objekteja, joilla on pari.
Käyttäjä eli pelaaja pelaa muistipeliä valitsemalla yksittäisiä objekteja, aina kaksi objektia vuorolla.
Jos objektit ovat toistensa parit, ne merkitään löydetyiksi. Tätä jatketaan,
kunnes pelilaudalla olevat kortit ovat kaikki löydetty.

Käyttäjäroolia sovelluksessa varsinaisesti ole, pelin jälkeen käyttäjä voi tallentaa tuloksensa
nimimerkin kera pistetaulukkoon.

Toiminnallisuudet: 

* Yksinpeli
	* Peli aikaa vastaan, aika talletetaan nimimerkin kera tulostaulukkoon
* Kaksinpeli
	* Pelaajat pelaavat vuorollaan
	* Voittaja on eniten pisteitä kerännyt, kun pelilauta on tyhjä
	* Pisteitä ei talleteta taulukkoon
* Pelitavat
	* Sanat objekteina
* Rajoitteet
	* Pistetaulukko tallennetaan paikalliseen muistiin tekstitiedostoon
	* Sovellus toimii linux-pohjaisilla järjestelmillä
* Jatkokehitysideoita
	* Kuvakortteja objektipareina
	* Vaikeustason nosto objektiparien määrää kasvattamalla
	* Pelitapana objektiparit, jotka ovat laskutoimituksia. Pareja ovat saman vastauksen saavat laskut

