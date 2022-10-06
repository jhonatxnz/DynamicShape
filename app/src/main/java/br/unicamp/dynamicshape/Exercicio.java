package br.unicamp.dynamicshape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Exercicio extends AppCompatActivity {
    ImageView seta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio);
        Intent intent = getIntent();
        seta = findViewById(R.id.imgSeta);

        seta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Exercicio.this,Home.class);
                startActivity(intent);
            }
        });
    }
}