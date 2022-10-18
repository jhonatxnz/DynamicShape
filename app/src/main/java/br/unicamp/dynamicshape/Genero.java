package br.unicamp.dynamicshape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Genero extends AppCompatActivity {

    ImageView seta;
    Button btnFeminino,btnMasculino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genero);

        seta = findViewById(R.id.imgSeta);
        btnFeminino = findViewById(R.id.btnFeminino);
        btnMasculino = findViewById(R.id.btnMasculino);

        //Intent intent = getIntent();
        //Bundle parametros = intent.getExtras();


        Usuario usuario = (Usuario) getIntent().getSerializableExtra("usuario");

        btnFeminino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Genero.this,PesoAltura.class);
                usuario.setGenero(2); // Rever
                //parametros.putString("chaveFeminino",btnFeminino.getText().toString());

                intent.putExtra("usuario", usuario);
                startActivity(intent);

            }
        });
        btnMasculino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Genero.this,PesoAltura.class);
                usuario.setGenero(1); // Rever
                //parametros.putString("chaveFeminino",btnFeminino.getText().toString());

                intent.putExtra("usuario", usuario);
                System.err.println("Genero"+ usuario.getGenero());
                startActivity(intent);
            }
        });
        seta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Genero.this,Cadastro.class);
                startActivity(intent);
            }
        });
    }
}