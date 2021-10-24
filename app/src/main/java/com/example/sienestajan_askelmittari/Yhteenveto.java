/**
 * @MainActivity
 * @author Team10, 10.10.2018
 * @version 1.0
 */
package com.example.sienestajan_askelmittari;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Luo SharedPreferences-tiedoston.
 */
public class Yhteenveto extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    TextView paivat, askeleet, askeleetPer, miinusTavoite, tv;
    int keskimaara, paivatYht, tavoite, askeleita, tavoitteeseenNum, neg;

    /**
     * Hakee TextView tietoja layoutista ja hakee muuttujia SharedPreferences-tiedostosta.
     * Asettaa tekseihin tietoja SharedPreferences-tiedostosta ja laskee haluttavia tietoja.
     * @param savedInstanceState Bundle tallennetuille tiedoille.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yhteenveto);

        paivat = findViewById(R.id.textView3);
        askeleet = findViewById(R.id.textView4);
        askeleetPer = findViewById(R.id.textView5);
        miinusTavoite = findViewById(R.id.textView6);
        tv = findViewById(R.id.textView9);
        sharedPreferences = getSharedPreferences(MainActivity.TAG, MODE_PRIVATE);

        keskimaara = sharedPreferences.getInt("AskeleetYht", 0) / (sharedPreferences.getInt("Paiva", 2)-1);
        paivatYht =sharedPreferences.getInt("Paiva", 1) -1;
        tavoite = sharedPreferences.getInt("Tavoite", 0);
        askeleita = sharedPreferences.getInt("AskeleetYht", 0);
        tavoitteeseenNum = (tavoite * paivatYht) - (askeleita);
        neg = -1;

        paivat.setText("Päivät: " + String.valueOf((sharedPreferences.getInt("Paiva", 0)) - 1));
        askeleet.setText("Askeleet yhteensä: " + String.valueOf(sharedPreferences.getInt("AskeleetYht", 0)));
        askeleetPer.setText("Askeleita keskimäärin päivässä: " + String.valueOf(keskimaara));

        if (tavoitteeseenNum < 0) {
            tavoitteeseenNum = tavoitteeseenNum * neg;
            miinusTavoite.setText("Mahtavaa! Ylitit tavoitteesi " + String.valueOf(tavoitteeseenNum) + " askeleella!");

        } else if (tavoitteeseenNum == 0) {
            miinusTavoite.setText("Mahtavaa! Pääsit tavoitteeseen!");

        } else {
            miinusTavoite.setText("Olet " + String.valueOf(tavoitteeseenNum) + " askeleen päässä tavoitteestasi.");
        }


        if (paivatYht == 0 && tavoite == 0) {
            paivat.setText("");
            askeleet.setText("");
            askeleetPer.setText("");
            miinusTavoite.setText("");
            tv.setText("Tietoja ei ole vielä syötetty.");

        } else if (paivatYht == 0) {
            paivat.setText("");
            askeleet.setText("");
            askeleetPer.setText("");
            miinusTavoite.setText("");
            tv.setText("Päiviä ei ole vielä syötetty." + "\n" + "Tavoite: " + String.valueOf(tavoite));

        } else if (tavoite == 0) {
            miinusTavoite.setText("Et ole vielä asettanut tavoitetta tai tavoite on 0");
        }

    }


}
