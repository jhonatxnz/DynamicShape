package br.unicamp.dynamicshape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CadastroExercicio extends AppCompatActivity {
    ImageView seta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_exercicio);
        seta = findViewById(R.id.imgSeta);
        Intent intent = getIntent();

        seta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CadastroExercicio.this,Exercicios.class);
                startActivity(intent);
            }
        });
    }
}