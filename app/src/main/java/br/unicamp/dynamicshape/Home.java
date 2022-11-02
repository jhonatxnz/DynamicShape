package br.unicamp.dynamicshape;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Handler;
import android.widget.ProgressBar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home extends AppCompatActivity {

    ImageView imgExercicios;
    Button btnMes;
    TextView tvSair;
    TextView tvDias;
    //Progress bar variaveis
    private ProgressBar progressBar;
    private TextView textView;
    private int Status = 0;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent intent     = getIntent();
        Bundle parametros = intent.getExtras();

        Usuario usuario = (Usuario) getIntent().getSerializableExtra("usuario");
        intent.putExtra("usuario", usuario);

        Service service = RetrofitConfig.getRetrofitInstance().create(Service.class);
        Call<Usuario> call = service.getUsuarioByEmail(usuario.getEmail());
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                System.err.println("Nome: " + response.body().getNome());
                Progresso(response.body().getTempo());
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {

            }
        });

        imgExercicios = findViewById(R.id.imgExercicios);
        btnMes        = findViewById(R.id.btnMes);
        tvSair        = findViewById(R.id.tvSair);
        tvDias        = findViewById(R.id.tvDias);

        imgExercicios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this,Exercicios.class);
                intent.putExtra("usuario", usuario);
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
                intent.putExtra("usuario", usuario);
                startActivity(intent);
            }
        });
    }
    private void Logout(){
        Intent intent = new Intent(Home.this,MainActivity.class);
        startActivity(intent);

    }
    private void Progresso(int dias){
        progressBar = findViewById(R.id.progressBar);
        textView    = findViewById(R.id.tvDias);
        handler     = new Handler();

        Date date            = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd");
        Status               = Integer.parseInt(sdf.format(date));

        new Thread(new Runnable() {
            public void run() {
                while (Status < dias * 30) { //usuario.getTempo + 30

                    handler.post(new Runnable() {
                        public void run() {
                            progressBar.setMax(dias * 30);
                            progressBar.setProgress(Status);

                            textView.setText(Status+"/"+ progressBar.getMax());
                        }
                    });
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}