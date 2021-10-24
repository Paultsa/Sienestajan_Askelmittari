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

public class ListPrint extends AppCompatActivity {
    /**
     * Luo aktiviteetin ja hakee SharedPreferemce-tiedostoa.
     * Joka luonnilla hakee muuttujaa i ja antaa sille arvon, joka sitten tulostuu aktiviteettiin.
     * Jos muuttuja x (Tavoite SharedPreferencesta) on negatiivinen, on tavoite ylitetty, muulloin tavoitteeseen on vielä jäljellä.
     * @param savedInstanceState Bundle tallennetuille tiedoille.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.TAG, MODE_PRIVATE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_print);
        Bundle b = getIntent().getExtras();
        int i = b.getInt("paivaIndex", 1);
        i++;

        ((TextView) findViewById(R.id.nimi)).setText(String.valueOf(sharedPreferences.getInt(String.valueOf(i)+"i", 0)));
        TextView tv =(TextView) findViewById(R.id.textView15);
        int x = (sharedPreferences.getInt("Tavoite" , 0) - (sharedPreferences.getInt(String.valueOf(i)+"i", 0)));
        if (x < 0) {
            x = x * -1;
            tv.setText("Mahtavaa! Ylitit tavoitteesi " + String.valueOf(x) + " askeleella!");
        } else {
            tv.setText("Olet " + String.valueOf(x) + " askeleen päässä tavoitteestasi.");
        }
    }
}