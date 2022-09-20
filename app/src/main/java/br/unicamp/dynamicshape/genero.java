package br.unicamp.dynamicshape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class genero extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genero);

        Intent intent = getIntent();
        Bundle parametros = intent.getExtras();

        String email = parametros.getString("chaveEmail");
        String nome = parametros.getString("chaveNome");
        String senha = parametros.getString("chaveSenha");
        String idade = parametros.getString("chaveIdade");

        System.out.println("Email:" + email);
    }
}