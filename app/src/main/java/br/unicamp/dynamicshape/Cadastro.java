package br.unicamp.dynamicshape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Cadastro extends AppCompatActivity {

    EditText edtEmail,edtNome,edtSenha,edtIdade;
    TextView tvLogin;
    Button btnAvancar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        edtEmail = findViewById(R.id.edtEmail);
        edtNome = findViewById(R.id.edtNome);
        edtSenha = findViewById(R.id.edtSenha);
        edtIdade = findViewById(R.id.edtIdade);
        tvLogin = findViewById(R.id.tvLogin);
        btnAvancar = findViewById(R.id.btnAvancar);

        btnAvancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cadastro.this,genero.class);
                Bundle parametros = new Bundle();

                parametros.putString("chaveEmail",edtEmail.getText().toString());
                parametros.putString("chaveNome",edtNome.getText().toString());
                parametros.putString("chaveSenha",edtSenha.getText().toString());
                parametros.putString("chaveIdade",edtIdade.getText().toString());

                intent.putExtras(parametros);
                startActivity(intent);
            }
        });
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cadastro.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}