package br.unicamp.dynamicshape;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtEmail,edtSenha;
    TextView tvCadastrar;
    Button btnAvancar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtEmail = findViewById(R.id.edtEmail);
        edtSenha = findViewById(R.id.edtSenha);
        tvCadastrar = findViewById(R.id.tvCadastrar);
        btnAvancar = findViewById(R.id.btnAvancar);

        btnAvancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,user.class);
                if(edtEmail.getText().toString() == ""||
                   edtSenha.getText().toString()  == ""){
                    Toast.makeText(MainActivity.this, "Campos vazios", Toast.LENGTH_LONG).show();
                }else {
                    startActivity(intent);
                }
            }
        });
        tvCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Cadastro.class);
                startActivity(intent);
            }
        });
    }
}