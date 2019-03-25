package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti != null);
    }

    @Test
    public void saldoOnOikeinAlussa() {

        assertEquals(10, kortti.saldo());
    }

    @Test
    public void saldoNouseeOikeinRahaaLadatessa() {
        kortti.lataaRahaa(3);

        assertEquals(13, kortti.saldo());
    }

    @Test
    public void saldoVaheneeOkein() {
        kortti.otaRahaa(5);

        assertEquals(5, kortti.saldo());
    }

    @Test
    public void saldoEiMuutuJosEiTarpeeksi() {
        kortti.otaRahaa(11);

        assertEquals(10, kortti.saldo());
    }

    @Test
    public void tililtaVoiOttaaSaldonVerran() {
        kortti.otaRahaa(10);

        assertEquals(0, kortti.saldo());
    }

    @Test
    public void otaRahaaPalauttaaTrueJosRiittaa() {

        assertEquals(true, kortti.otaRahaa(1));
    }

    @Test
    public void otaRahaaPalauttaaFalseJosEiRiita() {

        assertEquals(false, kortti.otaRahaa(11));
    }

    @Test
    public void toStringPalauttaaOikeanTulosteen() {

        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test 
    public void toinenToStringTesti(){
        Maksukortti vaihtoehtoKortti= new Maksukortti(105);
        
        assertEquals("saldo: 1.05", vaihtoehtoKortti.toString());
        
    }
}
