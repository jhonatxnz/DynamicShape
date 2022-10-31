package br.unicamp.dynamicshape;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastroExercicio extends AppCompatActivity {
    ImageView seta;
    Button btnAdicionar;
    EditText edtNome,edtQuantVezes,edtSessoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_exercicio);
        seta = findViewById(R.id.imgSeta);
        edtNome = findViewById(R.id.edtNome);
        seta = findViewById(R.id.imgSeta);
        edtQuantVezes = findViewById(R.id.edtQuantVezes);
        edtSessoes = findViewById(R.id.edtSessoes);
        btnAdicionar = findViewById(R.id.btnAdicionar);
        Intent intent = getIntent();

        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtNome.getText().length() != 0){
                    Exercicioo exerc = new Exercicioo("dsad",edtNome.getText().toString(),Integer.parseInt(edtQuantVezes.getText().toString()),Integer.parseInt(edtSessoes.getText().toString()),1,1);
                    incluirExercicio(exerc);
                }else{
                    Toast.makeText(CadastroExercicio.this, "Preencha todos o nome do exercicio", Toast.LENGTH_LONG).show();
                }

            }
        });
        seta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CadastroExercicio.this,Exercicios.class);
                startActivity(intent);
            }
        });
    }
    private void incluirExercicio(Exercicioo exercicioo) {
        Service service = RetrofitConfig.getRetrofitInstance().create(Service.class);
        Call<Exercicioo> call = service.incluirExercicio(exercicioo);

        call.enqueue(new Callback<Exercicioo>() {
            @Override
            public void onResponse(Call<Exercicioo> call, Response<Exercicioo> response) {
                if(response.isSuccessful()){
                    Toast.makeText(CadastroExercicio.this, "Incluiu exercício!", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(CadastroExercicio.this, "Erro na inclusão", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Exercicioo> call, Throwable t) {
                Toast.makeText(CadastroExercicio.this, "Ocorre um erro de requisição no Node: " + t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}