package br.unicamp.dynamicshape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Exercicio extends AppCompatActivity {
    TextView tvTempo,tvNome,tvDescricao,tvQuantasVezes,tvSessoes;
    Button btnComecar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio);

        Intent intent = getIntent();
        Bundle parametros = intent.getExtras();

        tvTempo        = findViewById(R.id.tvTempo);
        tvNome         = findViewById(R.id.tvNome);
        //tvDescricao    = findViewById(R.id.tvDescricao);
        tvQuantasVezes = findViewById(R.id.tvQuantasVezes);
        tvSessoes      = findViewById(R.id.tvSessoes);

        String nome = parametros.getString("chaveNome");
        Integer qtdVezes = Integer.parseInt(parametros.getString("chaveQuantas"));
        Integer sessoes = Integer.parseInt(parametros.getString("chaveSessoes"));
        tvNome.setText(nome);
        //tvDescricao.setText(parametros.getString("chaveNome"));
        tvQuantasVezes.setText(tvQuantasVezes.getText() + qtdVezes.toString());
        tvSessoes.setText(tvSessoes.getText() + sessoes.toString());

        Usuario usuario = (Usuario) getIntent().getSerializableExtra("usuario");
        intent.putExtra("usuario", usuario);

        btnComecar = findViewById(R.id.btnComecar);



        btnComecar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CountDownTimer((30000 * qtdVezes) * sessoes, 1000) {
                    public void onTick(long millisUntilFinished) {

                        NumberFormat f = new DecimalFormat("00");
                        long hour = (millisUntilFinished / 3600000) % 24;
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        tvTempo.setText(f.format(hour) + ":" + f.format(min) + ":" + f.format(sec));
                    }
                    public void onFinish() {
                        tvTempo.setText("00:00:00");
                        tvTempo.setTextColor(Color.parseColor("#00F000"));
                        Toast.makeText(Exercicio.this, "Concluído", Toast.LENGTH_SHORT).show();
                    }
                }.start();
            }
        });
    }
}