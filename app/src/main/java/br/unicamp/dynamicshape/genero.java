package br.unicamp.dynamicshape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class genero extends AppCompatActivity {

    ImageView seta;
    Button btnFeminino,btnMasculino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genero);

        seta = findViewById(R.id.imgSeta);
        btnFeminino = findViewById(R.id.btnFeminino);
        btnMasculino = findViewById(R.id.btnMasculino);

        Intent intent = getIntent();
        Bundle parametros = intent.getExtras();

        //falta getter and setter fazendo cagada
        String email = parametros.getString("chaveEmail");
        String nome = parametros.getString("chaveNome");
        String senha = parametros.getString("chaveSenha");
        String idade = parametros.getString("chaveIdade");

        System.out.println("Email:" + email);

        btnFeminino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(genero.this,PesoAltura.class);
                parametros.putString("chaveFeminino",btnFeminino.getText().toString());

                intent.putExtras(parametros);
                startActivity(intent);

            }
        });
        btnMasculino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(genero.this,PesoAltura.class);
                parametros.putString("chaveMasculino",btnMasculino.getText().toString());

                intent.putExtras(parametros);
                startActivity(intent);
            }
        });
        seta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(genero.this,Cadastro.class);
                startActivity(intent);
            }
        });
    }
}