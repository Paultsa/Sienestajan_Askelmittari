/**
 * @author Team10 10.10.2018
 * @version 1.0
 */
package com.example.sienestajan_askelmittari;

/**
 * Määrittää listan komponenttien vaatimat arvot.
 * Luo päivän muuttujan.
 * Luo vakion, jolle tulee myöhemmin arvo ". Päivä"
 */
public class ListComponents {
    private int paiva;
    private String vakio;

    /**
     *
     * @param paiva hakee päivän arvon ja määrittää sen aikasempaan luotuun muuttujaan.
     * @param vakio hakee vakion arvon ja määrittää sen aikasempaan luotuun muuttujaan.
     */
    public ListComponents(int paiva, String vakio) {
        this.paiva = paiva;
        this.vakio = vakio;
    }

    /**
     *
     * @return palauttaa päivän numero tekstinä ja vakio ". Päivä"
     */
    @Override
    public String toString() {
        return String.valueOf(paiva) + vakio;
    }
}

