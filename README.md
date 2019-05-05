# Ohjelmistotekniikka

# Muistipeli

Muistipeli on peli, jossa pelaaja kääntelee kortteja ja yrittää löytää pareja muistinsa avulla.
Tämä sovellus mukailee pelin ideaa. 

## Dokumentaatio

[Määrittelydokumentti](https://github.com/ArttuJanhunen/ot-harjoitustyo/blob/master/dokumentaatio/maarittelydokumentti.md)

[Työaikakirjanpito](https://github.com/ArttuJanhunen/ot-harjoitustyo/blob/master/dokumentaatio/tyoaikakirjanpito.md)

[Arkkitehtuuri](https://github.com/ArttuJanhunen/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

[Käyttöohjeet](https://github.com/ArttuJanhunen/ot-harjoitustyo/blob/master/dokumentaatio/kayttoohje.md)

[Testausdokumentti](https://github.com/ArttuJanhunen/ot-harjoitustyo/blob/master/dokumentaatio/testausdokumentti.md)

[Release](https://github.com/ArttuJanhunen/ot-harjoitustyo/releases)

## Komentorivitoiminnot

### Testit

* Testit:
```
mvn test
```

* Testikattavuusraportti:
``` 
mvn jacoco:report
```
Kattavuusraporttia saa tarkasteltua avaamalla tiedoston target/site/jacoco/index.html

* Checkstyle:
``` 
mvn jxr:jxr checkstyle:checkstyle 
```
Checkstyle-raporttia saa tarkasteltua avaamalla tiedoston target/site/checkstyle.html

### Suoritus komentoriviltä
```
mvn compile exec:java -Dexec.mainClass=com.mycompany.muistipeli.ui.GraphicInterface
```

### Paketointi jar-tiedostoksi
```
mvn package
```
Generoitu tiedosto löytyy kansiosta 'target' nimellä 'Muistipeli-1.0-SNAPSHOT.jar'

### JavaDoc -raportti
```
mvn javadoc:javadoc
```
JavaDocia saa tarkasteltua avaamalla tiedoston target/site/apidocs/index.html
