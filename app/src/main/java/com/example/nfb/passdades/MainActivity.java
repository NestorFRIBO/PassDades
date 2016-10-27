package com.example.nfb.passdades;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.security.acl.Group;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_TEXT = 1;
    EditText NOM;
    TextView Ocu;
    Button Env;
    RadioButton Mascle;
    RadioButton Femella;
    TextView Msg;
    TextView Nm;
    TextView Sx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Env = (Button) findViewById(R.id.Enviar);
        NOM = (EditText) findViewById(R.id.Text);
        Ocu = (TextView) findViewById(R.id.Oculto);
        Mascle = (RadioButton) findViewById(R.id.M);
        Femella = (RadioButton) findViewById(R.id.F);
        Msg = (TextView) findViewById(R.id.Dades);
        Nm = (TextView) findViewById(R.id.Nom);
        Sx = (TextView) findViewById(R.id.Sexe);

        if (savedInstanceState != null) {
            String msg = savedInstanceState.getString("inf");
            String msg2 = savedInstanceState.getString("msg");
            Ocu.setText(msg);
            NOM.setText(msg2);

        }



        Env.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String nombre = NOM.getText().toString();

                if (!nombre.matches("")) {

                    Intent i = new Intent(getApplicationContext(),SubAct.class);
                    Bundle b = new Bundle();
                    b.putString("nom", NOM.getText().toString());
                    i.putExtras(b);
                    startActivityForResult(i, REQUEST_TEXT);

                } else {
                    Toast.makeText(getApplicationContext(), "Escriu un nom", Toast.LENGTH_SHORT).show();
                }
            }


        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {

                Ocu.setVisibility(TextView.VISIBLE);
                NOM.setEnabled(false);
                Mascle.setEnabled(false);
                Femella.setEnabled(false);
                Env.setEnabled(false);
                Msg.setEnabled(false);
                Sx.setEnabled(false);
                Nm.setEnabled(false);


                Bundle extras = data.getExtras();

                int Year = extras.getInt("Edad");



            if (Year < 18) Ocu.setText("Ja eres major de edat");
            if ((Year >= 18) && (Year < 25)) Ocu.setText("Estas en la flor de la vida");
            if (Year >= 25) Ocu.setText("Ai, ai, ai...");
        }
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {

        Ocu = (TextView) findViewById(R.id.Oculto);
        outState.putString("inf",Ocu.getText().toString());
        NOM = (EditText) findViewById(R.id.Text);
        outState.putString("msg",NOM.getText().toString());
        super.onSaveInstanceState(outState);
    }
}

