/**
 * @MainActivity
 * @author Team10, 10.10.2018
 * @version 1.0
 */
package com.example.sienestajan_askelmittari;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Luo muuttujia, joihin syötetään myöhemmin tietoja. Lisäksi luo SharedPreferences-tiedoston.
 */
public class Tiedot extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    int paiva;
    int askeleet;
    int askeleetYht;

    /**
     * Hakee SharedPreferences arvoja.
     * Asettaa tekstiin päivän numeron.
     * Hakee kaikkia askeleita SharedPreferencesta muuttujaan.
     * @param savedInstanceState Bundle tallennetuille tiedoille.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(MainActivity.TAG,"Create");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiedot);

        sharedPreferences = getSharedPreferences(MainActivity.TAG, MODE_PRIVATE);
        paiva = sharedPreferences.getInt("Paiva", 1);
        TextView tv = findViewById(R.id.paivaView);
        tv.setText(String.valueOf(paiva) + ".");
        askeleetYht = sharedPreferences.getInt("AskeleetYht", 0);
        }

    /**
     * Asettaa napin painalluksella uuden päivän ja tallentaa syötetyn luvun ja päivän SharedPreferences-tiedostoon.
     * @param v näyttää metodin napille.
     */
    public void setPaiva(View v) {
        TextView tv = findViewById(R.id.paivaView);
        EditText editText = findViewById(R.id.editText);

        askeleet = Integer.parseInt(editText.getText().toString());
        ListaView.getInstance().addComponent(paiva, ". Päivä");
        askeleetYht = askeleetYht + askeleet;

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(String.valueOf(paiva)+"i", askeleet);
        paiva++;
        tv.setText(String.valueOf(paiva) + ".");
        editText.setText("");
        editor.putInt("Askeleet", askeleet);
        editor.putInt("AskeleetYht", askeleetYht);
        editor.putInt("Paiva", paiva);
        editor.putInt(String.valueOf(paiva), paiva);
        editor.commit();

    }

    /**
     * Resetoi kaikki tiedot SharedPreferences-tiedostosta ja asettaa päivän numeroksi 1.
     * @param v näyttää metodin  napille.
     */
    public void onResetPressed(View v) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();

        ListaView.getInstance().removeComponent();
        TextView tv = findViewById(R.id.paivaView);
        paiva = 1;
        tv.setText(String.valueOf(paiva) + ".");

    }
}
