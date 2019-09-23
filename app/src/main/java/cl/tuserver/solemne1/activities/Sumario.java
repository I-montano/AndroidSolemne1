package cl.tuserver.solemne1.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import cl.tuserver.solemne1.R;
import cl.tuserver.solemne1.enums.PosicionBarrasReactor;

public class Sumario extends AppCompatActivity {
    public TextView tt,tn,ti; //TextViews
    public Button ba; //Botón Actualizar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sumario);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        SensorTemperatura sensorTemperatura=(SensorTemperatura)b.getSerializable("serial");

        //BUTTON
        ba = findViewById(R.id.btnActualizar);
        //Inicializar botón
        initButtonEvents();



        //TEXT VIEWS
        tt = findViewById(R.id.temperatura);
        tn = findViewById(R.id.titulo);
        ti = findViewById(R.id.tvInfoTemp);

        tn.setText(R.string.nombrePlanta);
        tt.setText(Double.toString(sensorTemperatura.getTemperaturaActual()));

        //Cambio de texto y color según el nivel de profundidad y la temperatura
        //SUMERGIDO
        if (PosicionBarrasReactor.getPosicionActual()==PosicionBarrasReactor.SUMERGIDO){
            //BAJA TEMPERATURA
            if(sensorTemperatura.getTemperaturaActual()<35){
                ti.setText("BAJA_TEMPERATURA");
                ti.setTextColor(getResources().getColor(R.color.colorAmarillo));
            }
            //TEMPERATURA NORMAL
            if(sensorTemperatura.getTemperaturaActual()>=35&& sensorTemperatura.getTemperaturaActual()<=55){
                ti.setText("NORMAL");
                ti.setTextColor(getResources().getColor(R.color.colorVerde));
            }
            //ALTA TEMPERATURA
            if(sensorTemperatura.getTemperaturaActual()>55){
                ti.setText("ALTA_TEMPERATURA");
                ti.setTextColor(getResources().getColor(R.color.colorRojo));
            }
        }
        //SEMI-SUMERGIDO
        if (PosicionBarrasReactor.getPosicionActual()==PosicionBarrasReactor.SEMI_SUMERGIDO) {
            //BAJA TEMPERATURA
            if(sensorTemperatura.getTemperaturaActual()<55){
                ti.setText("BAJA_TEMPERATURA");
                ti.setTextColor(getResources().getColor(R.color.colorAmarillo));
            }
            //TEMPERATURA NORMAL
            if(sensorTemperatura.getTemperaturaActual()>=55&& sensorTemperatura.getTemperaturaActual()<=85){
                ti.setText("NORMAL");
                ti.setTextColor(getResources().getColor(R.color.colorVerde));
            }
            //ALTA TEMPERATURA
            if(sensorTemperatura.getTemperaturaActual()>85){
                ti.setText("ALTA_TEMPERATURA");
                ti.setTextColor(getResources().getColor(R.color.colorRojo));
            }
        }
        //SUPERFICIE
        if (PosicionBarrasReactor.getPosicionActual()==PosicionBarrasReactor.SUPERFICIE) {
            //BAJA TEMPERATURA
            if(sensorTemperatura.getTemperaturaActual()<85){
                ti.setText("BAJA_TEMPERATURA");
                ti.setTextColor(getResources().getColor(R.color.colorAmarillo));
            }
            //TEMPERATURA NORMAL
            if(sensorTemperatura.getTemperaturaActual()>85&& sensorTemperatura.getTemperaturaActual()<=99){
                ti.setText("NORMAL");
                ti.setTextColor(getResources().getColor(R.color.colorVerde));
            }
            //ALTA TEMPERATURA
            if(sensorTemperatura.getTemperaturaActual()>99){
                ti.setText("ALTA_TEMPERATURA");
                ti.setTextColor(getResources().getColor(R.color.colorRojo));
                Toast.makeText(getApplicationContext(),"PELIGRO, la temperatura es sobre 100º",Toast.LENGTH_LONG);
            }
        }
    }

    // Métodos del botón.
    private void initButtonEvents() {
        ba.setOnClickListener(v ->
                actualizar()
        );
    }

    private void actualizar(){
        finish();
        startActivity(getIntent());
    }
}

