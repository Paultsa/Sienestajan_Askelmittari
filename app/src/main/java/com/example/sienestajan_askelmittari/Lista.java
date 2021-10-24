/**
 * @MainActivity
 * @author Team10, 10.10.2018
 * @version 1.0
 */
package com.example.sienestajan_askelmittari;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;


public class Lista extends AppCompatActivity {
    /**
     * Luo ArrayAdapterin listaa varten, sekä OnClickListenerin, joka reagoi listan komponenttien painalluksiin.
     * @param savedInstanceState Bundle tallennetuille tiedoille.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        android.widget.ListView lv = findViewById(R.id.ListView);
        lv.setAdapter(new ArrayAdapter<>
                (this,
                        android.R.layout.simple_list_item_1,
                        ListaView.getInstance().getPaivat()));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /**
             *
             * @param adapterView adapterin näkymä
             * @param view näkymä layoutissa
             * @param i muuttuja, jonka arvo muuttuu listan komponentin mukaan.
             * @param l adapterin antama vakiomuuttuja.
             *          Aloittaa uuden aktiviteetin, kun listan komponenttia painaa.
             */
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(MainActivity.TAG, "onItemClick(" + i + ")");
                Intent nextActivity = new Intent(Lista.this, ListPrint.class);
                nextActivity.putExtra("paivaIndex", i);
                startActivity(nextActivity);
            }
        });
    }

}
