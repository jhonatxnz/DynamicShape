package br.unicamp.dynamicshape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Cadastro extends AppCompatActivity {

    EditText edtEmail,edtNome,edtSenha,edtIdade;
    TextView tvLogin;
    Button btnAvancar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        edtEmail   = findViewById(R.id.edtEmail);
        edtNome    = findViewById(R.id.edtNome);
        edtSenha   = findViewById(R.id.edtSenha);
        edtIdade   = findViewById(R.id.edtIdade);
        tvLogin    = findViewById(R.id.tvLogin);
        btnAvancar = findViewById(R.id.btnAvancar);

        btnAvancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cadastro.this, Genero.class);

                if(edtEmail.getText().length()      == 0 ||
                        edtNome.getText().length()  == 0 ||
                        edtSenha.getText().length() == 0 ||
                        edtIdade.getText().length() == 0){
                    Toast.makeText(Cadastro.this, "Campos vazios", Toast.LENGTH_LONG).show();
                }else{
                    Usuario usuario = new Usuario();
                    usuario.setEmail(edtEmail.getText().toString());
                    usuario.setNome(edtNome.getText().toString());
                    usuario.setSenha(edtSenha.getText().toString());
                    usuario.setIdade(Integer.parseInt(edtIdade.getText().toString()));

                    intent.putExtra("usuario", usuario);
                    startActivity(intent);
                }
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