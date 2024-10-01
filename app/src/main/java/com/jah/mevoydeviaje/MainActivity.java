package com.jah.mevoydeviaje;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    RadioGroup rgDestino;
    RadioGroup rgTransporte;
    RadioButton rbParis;
    RadioButton rbLondres;
    RadioButton rbRoma;
    RadioButton rbCoche;
    RadioButton rbTren;
    RadioButton rbAvion;
    Button btnInformacion;
    String mostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rgDestino = findViewById(R.id.rgDestino);
        rgTransporte = findViewById(R.id.rgTransporte);
        rbParis = findViewById(R.id.rbParis);
        rbLondres = findViewById(R.id.rbLondres);
        rbRoma = findViewById(R.id.rbRoma);
        rbCoche = findViewById(R.id.rbCoche);
        rbTren = findViewById(R.id.rbTren);
        rbAvion = findViewById(R.id.rbAvion);
        btnInformacion = findViewById(R.id.btnInformacion);
        mostrar = "";
        rgDestino.setOnCheckedChangeListener((Group, checkedId) -> {
            if(checkedId == -1){
                Log.i("DAM", "Tienes que seleccionar algo");
            }else{
                if(rbParis.isChecked()){
                    if(mostrar.isEmpty()){
                        mostrar += "Me voy a " + rbParis.getText().toString();
                    }else{
                        mostrar += " me voy a " + rbParis.getText().toString();
                    }

                } else if (rbLondres.isChecked()) {
                    if(mostrar.isEmpty()){
                        mostrar += "Me voy a " + rbLondres.getText().toString();
                    }else{
                        mostrar += " me voy a " + rbLondres.getText().toString();
                    }
                }else{
                    if(mostrar.isEmpty()){
                        mostrar += "Me voy a " + rbRoma.getText().toString();
                    }else{
                        mostrar += " me voy a " + rbRoma.getText().toString();
                    }
                }
            }
        });

        rgTransporte.setOnCheckedChangeListener((Group, checkedId) -> {
            if(checkedId == -1){
                Log.i("DAM", "Tienes que seleccionar algo");
            }else{
                if(rbCoche.isChecked()){
                    if(mostrar.isEmpty()){
                        mostrar += "En " + rbCoche.getText().toString();
                    }else{
                        mostrar += " en " + rbCoche.getText().toString();
                    }
                } else if (rbTren.isChecked()) {
                    if(mostrar.isEmpty()){
                        mostrar += "En " + rbTren.getText().toString();
                    }else{
                        mostrar += " en " + rbTren.getText().toString();
                    }

                }else{
                    if(mostrar.isEmpty()){
                        mostrar += "En " + rbAvion.getText().toString();
                    }else{
                        mostrar += " en " + rbAvion.getText().toString();
                    }
                }
            }
        });

        btnInformacion.setOnClickListener(v -> {
            Toast.makeText(this, mostrar, Toast.LENGTH_LONG).show();
            mostrar = "";
        });
    }
}