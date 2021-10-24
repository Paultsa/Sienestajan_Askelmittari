/**
 * @MainActivity
 * @author Team10, 10.10.2018
 * @version 1.0
 */
package com.example.sienestajan_askelmittari;


import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Ohjelman pääluokka, sisältää navigointisivun ja syöttökentän.
 * yksityinen lukumuuttuja "tavoite"
 * SharedPreferences luodaan ensimmäistä kertaa
 */
public class MainActivity extends AppCompatActivity {
    static final String TAG = "SienestajanAskelmittari";
    SharedPreferences sharedPreferences;
    private int tavoite;

    /**
     * Luo pääaktiviteetin.
     * Hakee SharedPreferences, jos jo olemassa.
     * antaa lukumuuttujalle ensimmäisen arvon SharedPreferenceista, jos on olemassa, muulloin 0.
     * jos ei ole 0, niin luku tulee näkyviin aktiviteettiin.
     * Lisää listalle arvoja SharedPreferenceista, jos löytyy.
     * @param savedInstanceState Bundle tallennetuille tiedoille.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences(TAG, MODE_PRIVATE);
        this.tavoite = sharedPreferences.getInt("Tavoite", 0);

        if (this.tavoite != 0) {
            TextView tv = findViewById(R.id.tavoiteView);
            tv.setText(String.valueOf(sharedPreferences.getInt("Tavoite", 0)));
        }

        int i = 1;
        if (ListaView.getInstance().getPaivat().isEmpty()) {
            while (i < sharedPreferences.getInt("Paiva", 1)) {
                ListaView.getInstance().addComponent(i, ". Päivä");
                i++;
            }
        }
    }

    /**
     * Aloittaa uuden aktiviteetin
     * @param v näyttää metodin layoutin napille.
     */
    public void tiedotPressed(View v) {
        Intent intent = new Intent(this, Tiedot.class);
        startActivity(intent);
    }

    /**
     * Aloittaa uuden aktiviteetin
     * @param v näyttää metodin layoutin napille.
     */
    public void listaPressed(View v) {
        Intent intent = new Intent(this, Lista.class);
        startActivity(intent);
    }

    /**
     * Aloittaa uuden aktiviteetin
     * @param v näyttää metodin layoutin napille.
     */
    public void yhteenvetoPressed(View v) {
        Intent intent = new Intent(this, Yhteenveto.class);
        startActivity(intent);
    }

    /**
     * Asettaa tavoitteen arvon SharedPreference tiedostoon.
     * Tuo tietoja näkyville layouttiin.
     * @param v näyttää metodin layoutin napille.
     */
    public void setTavoite(View v) {
        EditText editText = (EditText) findViewById(R.id.tavoite);
            String tavoiteString = editText.getText().toString();
            this.tavoite = Integer.parseInt(editText.getText().toString());
            TextView tv = findViewById(R.id.tavoiteView);
            tv.setText(tavoiteString);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("Tavoite", this.tavoite);
        editor.commit();
        editText.setText("");
    }

    /**
     *
     * @return palauttaa tavoitteen lukuarvon SharedPreferencesta.
     */
    public int getTavoite() {
        return sharedPreferences.getInt("Tavoite", 0);
    }
}
