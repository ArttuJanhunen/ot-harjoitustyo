# Ohjelmistotekniikka

# Muistipeli

## Dokumentaatio

[Määrittelydokumentti](https://github.com/ArttuJanhunen/ot-harjoitustyo/blob/master/dokumentaatio/maarittelydokumentti.md)

[Työaikakirjanpito](https://github.com/ArttuJanhunen/ot-harjoitustyo/blob/master/dokumentaatio/tyoaikakirjanpito.md)

[Arkkitehtuuri](https://github.com/ArttuJanhunen/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

[Release](https://github.com/ArttuJanhunen/ot-harjoitustyo/releases)

## Komentorivitoiminnot

### Testit

* Testit: mvn test
* Testikattavuusraportti: mvn jacoco:report
* Checkstyle: mvn jxr:jxr checkstyle:checkstyle 

### Suoritus komentoriviltä

mvn compile exec:java -Dexec.mainClass=com.mycompany.muistipeli.ui.GraphicInterface

### Paketointi jar-tiedostoksi

* mvn package
