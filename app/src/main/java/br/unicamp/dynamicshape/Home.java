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
        Progresso();
        Intent intent = getIntent();
        Bundle parametros = intent.getExtras();

        Usuario usuario = (Usuario) getIntent().getSerializableExtra("usuario");
        System.err.println("Email: " + usuario.getEmail());
        System.err.println("Senha: " + usuario.getSenha());

        Service service = RetrofitConfig.getRetrofitInstance().create(Service.class);
        Call<Usuario> call = service.getUsuarioByEmail(usuario.getEmail());


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
    private void Progresso(){
        progressBar = findViewById(R.id.progressBar);
        textView = findViewById(R.id.tvDias);
        handler = new Handler();
        new Thread(new Runnable() {
            public void run() {
                while (Status < 365) { //usuario.getTempo + 30
                    Status += 1;
                    /* Atualize a barra de progresso */
                    handler.post(new Runnable() {
                        public void run() {
                            progressBar.setMax(365);
                            progressBar.setProgress(Status);
                            /* Mostra em formato de números o resultado no textView*/
                            textView.setText(Status+"/"+ progressBar.getMax());
                        }
                    });
                    try {
                        /* Determina a velocidade 100 milissegundos.
                         Um valor baixo, mostra a barra muito rápida,
                         mas um valor alto mostra a barra muito lenta*/
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}