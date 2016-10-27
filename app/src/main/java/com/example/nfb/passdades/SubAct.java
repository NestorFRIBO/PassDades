package com.example.nfb.passdades;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SubAct extends AppCompatActivity {

    TextView Texto;
    Button Cont;
    EditText Edat;
    TextView Ocult;
     final int REQUEST_TEXT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);


        Texto = (TextView) findViewById(R.id.Rellenar);
        Cont = (Button) findViewById(R.id.Continuar);
        Edat = (EditText) findViewById(R.id.Edat);
        Ocult = (TextView) findViewById(R.id.Oculto);

        Bundle extras = getIntent().getExtras();
        String xnom = extras.getString("nom");


        Texto.setText("Hola " + xnom + ", indicans la teua edat");

            Cont.setOnClickListener(new View.OnClickListener() {
            Intent i = new Intent(SubAct.this, MainActivity.class);

            @Override
            public void onClick(View v) {

            String nombre = Edat.getText().toString();
            if (!nombre.matches("")) {

                    Bundle b = new Bundle();
                    b.putInt ("Edad", Integer.parseInt(Edat.getText().toString()));
                    i.putExtras(b);
                    setResult(RESULT_OK, i);
                    finish();
            } else {
                Toast.makeText(getApplicationContext(), "Escriu l'edat", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}

