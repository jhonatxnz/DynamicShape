package br.unicamp.dynamicshape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Exercicio extends AppCompatActivity {
    ImageView seta;
    TextView tvTempo;
    Button btnComecar,btnExercicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio);
        Intent intent = getIntent();
        seta = findViewById(R.id.imgSeta);
        btnComecar = findViewById(R.id.btnComecar);
        tvTempo = findViewById(R.id.tvTempo);



        btnComecar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CountDownTimer(10000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long hour = (millisUntilFinished / 3600000) % 24;
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        tvTempo.setText(f.format(hour) + ":" + f.format(min) + ":" + f.format(sec));
                    }
                    // When the task is over it will print 00:00:00 there
                    public void onFinish() {
                        tvTempo.setText("00:00:00");
                        Toast.makeText(Exercicio.this, "Concluído", Toast.LENGTH_SHORT).show();
//                        Bundle parametros = new Bundle();
//                        parametros.putString("chaveCor",tvTempo.getText().toString());
                        Intent intent = new Intent(Exercicio.this,Exercicios.class);
//                        intent.putExtras(parametros);
                        startActivity(intent);

                        tvTempo.setBackgroundResource(R.color.gray);

                    }
                }.start();
            }
        });
        seta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Exercicio.this,Exercicios.class);
                startActivity(intent);
            }
        });
    }
}