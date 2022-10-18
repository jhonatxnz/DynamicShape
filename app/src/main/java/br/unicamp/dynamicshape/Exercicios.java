package br.unicamp.dynamicshape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Exercicios extends AppCompatActivity {
    Button btnExercicio,btnAvancar,btnAdicionar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicios);

//        Intent intent = getIntent();
//        Bundle parametros = intent.getExtras();
//        String nome = parametros.getString("chaveCor");

        btnExercicio = findViewById(R.id.btnExercicio);
        btnAvancar = findViewById(R.id.btnAvancar);
        btnAdicionar = findViewById(R.id.btnAdicionar);

        btnExercicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Exercicios.this,Exercicio.class);
                startActivity(intent);
            }
        });
        btnAvancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Exercicios.this,Home.class);
                startActivity(intent);
            }
        });
        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Exercicios.this,CadastroExercicio.class);
                startActivity(intent);
            }
        });
    }
}