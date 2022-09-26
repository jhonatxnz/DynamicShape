package br.unicamp.dynamicshape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class PesoAltura extends AppCompatActivity {

    ImageView seta;
    EditText edtPeso,edtAltura;
    Button btnAvancar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peso_altura);

        seta = findViewById(R.id.imgSeta);
        edtPeso = findViewById(R.id.edtPesoo);
        edtAltura = findViewById(R.id.edtAltura);
        btnAvancar = findViewById(R.id.btnAvancar);

        Intent intent = getIntent();
        Bundle parametros = intent.getExtras();

        btnAvancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PesoAltura.this,Objetivo.class);
                Bundle parametros = new Bundle();
                parametros.putString("chavePeso",edtPeso.getText().toString());
                parametros.putString("chaveAltura",edtAltura.getText().toString());

                intent.putExtras(parametros);
                startActivity(intent);
            }
        });
        seta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PesoAltura.this, Genero.class);
                startActivity(intent);
            }
        });
    }
}