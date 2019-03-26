/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ajanhune
 */
public class KassapaateTest {

    private Kassapaate kassa;

    @Before
    public void setUp() {
        kassa = new Kassapaate();
    }

    @Test
    public void luodunKassanSaldoOnOikein() {

        assertEquals(100000, kassa.kassassaRahaa());
    }

    @Test
    public void luodunKassanEdullisetNolla() {

        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void luodunKassanMaukkaatNolla() {

        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }

    @Test
    public void edullisenMaksunOnnistuessaKassanSaldokasvaa() {
        kassa.syoEdullisesti(240);

        assertEquals(100240, kassa.kassassaRahaa());
    }

    @Test
    public void edullisenVaihtoRahaOnOikein() {

        assertEquals(10, kassa.syoEdullisesti(250));
    }

    @Test
    public void maukkaanMaksunOnnistuessaKassanSaldokasvaa() {
        kassa.syoMaukkaasti(400);

        assertEquals(100400, kassa.kassassaRahaa());
    }

    @Test
    public void maukkaanVaihtoRahaOnOikein() {

        assertEquals(100, kassa.syoMaukkaasti(500));
    }

    @Test
    public void edullistenMaarakasvaa() {
        kassa.syoEdullisesti(250);

        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void maukkaidenMaarakasvaa() {
        kassa.syoMaukkaasti(500);

        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }

    @Test
    public void kassanRahamaaraEiMuutuEdullisenEpaonnistuessa() {
        kassa.syoEdullisesti(230);

        assertEquals(100000, kassa.kassassaRahaa());
    }

    @Test
    public void kassanRahamaaraEiMuutuMaukkaanEpaonnistuessa() {
        kassa.syoMaukkaasti(230);

        assertEquals(100000, kassa.kassassaRahaa());
    }

    @Test
    public void vaihtorahatPalautuvatEdullisenEpaonnistuessa() {

        assertEquals(230, kassa.syoEdullisesti(230));
    }

    @Test
    public void vaihtorahatPalautuvatMaukkaanEpaonnistuessa() {

        assertEquals(230, kassa.syoMaukkaasti(230));
    }

    @Test
    public void lounasMaaraEiMuutuEdullisenEpaonnistuessa() {
        kassa.syoEdullisesti(50);

        assertEquals(0, kassa.edullisiaLounaitaMyyty());

    }

    @Test
    public void lounasMaaraEiMuutuMaukkaanEpaonnistuessa() {
        kassa.syoMaukkaasti(50);

        assertEquals(0, kassa.maukkaitaLounaitaMyyty());

    }

    @Test
    public void kortiltaVeloitetaanEdullisenSumma() {
        Maksukortti kortti = new Maksukortti(1000);
        kassa.syoEdullisesti(kortti);

        assertEquals(760, kortti.saldo());

    }

    @Test
    public void kortiltaVeloitetaanMaukkaanSumma() {
        Maksukortti kortti = new Maksukortti(1000);
        kassa.syoMaukkaasti(kortti);

        assertEquals(600, kortti.saldo());

    }

    @Test
    public void edullisenOnnistuessaKortiltaTrue() {
        Maksukortti kortti = new Maksukortti(1000);

        assertEquals(true, kassa.syoEdullisesti(kortti));

    }

    @Test
    public void maukkaanOnnistuessaKortiltaTrue() {
        Maksukortti kortti = new Maksukortti(1000);

        assertEquals(true, kassa.syoMaukkaasti(kortti));

    }

    @Test
    public void edullisenOnnistuessaKortiltaLounasmaaraKasvaa() {
        Maksukortti kortti = new Maksukortti(1000);
        kassa.syoEdullisesti(kortti);

        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void maukkaanOnnistuessaKortiltaLounasmaaraKasvaa() {
        Maksukortti kortti = new Maksukortti(1000);
        kassa.syoMaukkaasti(kortti);

        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }

    @Test
    public void edullisenEpaonnistuessaKortiltaKortinSaldoEiMuutu() {
        Maksukortti kortti = new Maksukortti(230);
        kassa.syoEdullisesti(kortti);

        assertEquals(230, kortti.saldo());
    }

    @Test
    public void maukkaanEpaonnistuessaKortiltaKortinSaldoEiMuutu() {
        Maksukortti kortti = new Maksukortti(230);
        kassa.syoMaukkaasti(kortti);

        assertEquals(230, kortti.saldo());
    }

    @Test
    public void edullisenEpaonnistuessaKortillaLounasmaaraEiKasva() {
        Maksukortti kortti = new Maksukortti(230);
        kassa.syoEdullisesti(kortti);

        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void maukkaanEpaonnistuessaKortillaLounasmaaraEiKasva() {
        Maksukortti kortti = new Maksukortti(230);
        kassa.syoMaukkaasti(kortti);

        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }

    @Test
    public void edullisenEpaonnistuessaKortillaFalse() {
        Maksukortti kortti = new Maksukortti(230);

        assertEquals(false, kassa.syoEdullisesti(kortti));
    }

    @Test
    public void maukkaanEpaonnistuessaKortillaFalse() {
        Maksukortti kortti = new Maksukortti(230);

        assertEquals(false, kassa.syoMaukkaasti(kortti));
    }

    @Test
    public void kassanSaldoEiMuutuKortillaOstaessaEdullinen() {
        Maksukortti kortti = new Maksukortti(1000);
        kassa.syoEdullisesti(kortti);

        assertEquals(100000, kassa.kassassaRahaa());
    }

    @Test
    public void kassanSaldoEiMuutuKortillaOstaessaMaukas() {
        Maksukortti kortti = new Maksukortti(1000);
        kassa.syoMaukkaasti(kortti);

        assertEquals(100000, kassa.kassassaRahaa());
    }

    @Test
    public void korttiaLadatessaKortinSaldoKasvaa() {
        Maksukortti kortti = new Maksukortti(1000);
        kassa.lataaRahaaKortille(kortti, 1000);

        assertEquals(2000, kortti.saldo());
    }

    @Test
    public void korttiaLadatessaKassanSaldoKasvaa() {
        Maksukortti kortti = new Maksukortti(1000);
        kassa.lataaRahaaKortille(kortti, 1000);

        assertEquals(101000, kassa.kassassaRahaa());
    }

    @Test
    public void korttialadatessaNegatiivisellaKortinSaldoEiMuutu() {
        Maksukortti kortti = new Maksukortti(1000);
        kassa.lataaRahaaKortille(kortti, -1000);

        assertEquals(1000, kortti.saldo());
    }

    @Test
    public void korttialadatessaNegatiivisellaKassanSaldoEiMuutu() {
        Maksukortti kortti = new Maksukortti(1000);
        kassa.lataaRahaaKortille(kortti, -1000);

        assertEquals(100000, kassa.kassassaRahaa());
    }

}
