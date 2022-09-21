package br.unicamp.dynamicshape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Objetivo extends AppCompatActivity {

    ImageView seta,imgEmagrecer,imgGanharMusculo;
    EditText edtDuracao;
    Button btnAvancar;
    String Objetivo = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objetivo);

        seta = findViewById(R.id.imgSeta);
        imgEmagrecer = findViewById(R.id.imgEmagrecer);
        imgGanharMusculo = findViewById(R.id.imgGanharMusculo);
        edtDuracao = findViewById(R.id.edtDuracao);
        btnAvancar = findViewById(R.id.btnAvancar);


        Intent intent = getIntent();
        Bundle parametros = intent.getExtras();

        imgEmagrecer.setOnClickListener(this::onClick);
        imgGanharMusculo.setOnClickListener(this::onClick);

       btnAvancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Objetivo.this,MainActivity.class);
                Bundle parametros = new Bundle();
                parametros.putString("chaveObjetivo",Objetivo);
                imgEmagrecer.isSelected();
                parametros.putString("chaveDuracao",edtDuracao.getText().toString());

                intent.putExtras(parametros);
                startActivity(intent);
            }
        });
        seta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Objetivo.this,PesoAltura.class);
                startActivity(intent);
            }
        });
    }

    private void onClick(View view) {
        switch (view.getId()){
            case R.id.imgEmagrecer:
                Objetivo = "Emagrecer";
                break;
            case R.id.imgGanharMusculo:
                Objetivo = "Ganhar Musculo";
                break;
        }
    }
}