package br.unicamp.dynamicshape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Objetivo extends AppCompatActivity {


    ImageView seta,imgEmagrecer,imgGanharMusculo;
    EditText edtDuracao;
    Button btnAvancar;
    Integer Objetivo = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objetivo);

        seta             = findViewById(R.id.imgSeta);
        imgEmagrecer     = findViewById(R.id.imgEmagrecer);
        imgGanharMusculo = findViewById(R.id.imgGanharMusculo);
        edtDuracao       = findViewById(R.id.edtDuracao);
        btnAvancar       = findViewById(R.id.btnAvancar);


        imgEmagrecer.setOnClickListener(this::onClick);
        imgGanharMusculo.setOnClickListener(this::onClick);

        Usuario usuario = (Usuario) getIntent().getSerializableExtra("usuario");

        btnAvancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Objetivo.this,MainActivity.class);
                usuario.setObjetivo(Objetivo);
                usuario.setTempo(Integer.parseInt(edtDuracao.getText().toString()));
                intent.putExtra("usuario", usuario);
                incluirUser(usuario);

                if(edtDuracao.getText().length() == 0 || Objetivo < 0){
                    Toast.makeText(Objetivo.this, "Selecione o objetivo/coloque o tempo", Toast.LENGTH_LONG).show();
                }
                else
                {
                    usuario.setTempo(Integer.parseInt(edtDuracao.getText().toString()));
                    intent.putExtra("usuario", usuario);
                    startActivity(intent);
                }
            }
        });
        seta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Objetivo.this,PesoAltura.class);
                startActivity(intent);
            }
        });
    }

    private void onClick(View view) {
        switch (view.getId()){
            case R.id.imgEmagrecer:
                imgEmagrecer.setBackgroundColor(Color.parseColor("#FF0000"));
                imgGanharMusculo.setBackgroundColor(Color.parseColor("#000000"));
                Objetivo = 2;

                break;
            case R.id.imgGanharMusculo:
                imgGanharMusculo.setBackgroundColor(Color.parseColor("#FF0000"));
                imgEmagrecer.setBackgroundColor(Color.parseColor("#000000"));
                Objetivo = 1;
                break;
        }
    }

    private void incluirUser(Usuario usuario) {
        Service service = RetrofitConfig.getRetrofitInstance().create(Service.class);
        Call<Usuario> call = service.incluirUsuario(usuario);

        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if(response.isSuccessful()){
                    startActivity(new Intent(Objetivo.this, MainActivity.class));
                }
                else{
                    Toast.makeText(Objetivo.this, "Erro na inclusão", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Toast.makeText(Objetivo.this, "Ocorre um erro de requisição no Node: " + t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}