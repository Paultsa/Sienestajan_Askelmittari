/**
 * @author Team10 10.10.2018
 * @version 1.0
 */
package com.example.sienestajan_askelmittari;


import java.util.ArrayList;
import java.util.List;

/**
 * Singleton, jossa lista.
 * Luo listan ensimmäistä kertaa.
 */
class ListaView {
    private List<ListComponents> paivat;
    private static final ListaView ourInstance = new ListaView();

    /**
     * @return palauttaa Singletonin instanssina.
     */
    public static ListaView getInstance() {
        return ourInstance;
    }

    /**
     * Määrittää listasta ArrayListin.
     */
    private ListaView() {
        paivat = new ArrayList<>();
    }

    /**
     * Lisää listalle uuden komponentin.
     *
     * @param i     päivän arvo, joka riippuu siitä, mikä päivä on kyseessä.
     * @param vakio vakio on pysyvä teksit ". Päiviä"
     */
    public void addComponent(int i, String vakio) {
        paivat.add(new ListComponents(i, vakio));

    }

    /**
     * Tyhjentää listan.
     */
    public void removeComponent() {
        paivat.clear();
    }

    /**
     * Käyttää listan komponentteja toisesta luokasta (ListComponents)
     *
     * @return palauttaa listan.
     */
    public List<ListComponents> getPaivat() {
        return paivat;
    }
}

