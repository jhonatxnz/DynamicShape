package br.unicamp.dynamicshape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home extends AppCompatActivity {

    ImageView imgExercicios;
    Button btnMes;
    TextView tvSair;
    TextView tvDias;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent intent = getIntent();
        Bundle parametros = intent.getExtras();

//        Usuario usuario = (Usuario) getIntent().getSerializableExtra("usuario");
//        System.err.println("Email: " + usuario.getEmail());
//        System.err.println("Senha: " + usuario.getSenha());

        imgExercicios = findViewById(R.id.imgExercicios);
        btnMes = findViewById(R.id.btnMes);
        tvSair = findViewById(R.id.tvSair);
        tvDias = findViewById(R.id.tvDias);

        imgExercicios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this,Exercicios.class);
                startActivity(intent);
            }
        });
        tvSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Logout();
            }
        });
        btnMes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this,Calendario.class);
                startActivity(intent);
            }
        });
    }
    private void Logout(){
        Intent intent = new Intent(Home.this,MainActivity.class);
        startActivity(intent);

    }
}