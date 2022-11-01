package br.unicamp.dynamicshape;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Exercicios extends AppCompatActivity {
    Button btnAvancar,btnAdicionar;
    ArrayList<Peso> list = new ArrayList<>();
    GridView exerciciosGridView;

    public void populateGridView(List<Peso> listaPeso){
        exerciciosGridView = findViewById(R.id.exerciciosGridView);
        exerciciosGridView.setAdapter(new GridViewAdapter(this,listaPeso));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicios);

        Intent intent     = getIntent();
        Bundle parametros = intent.getExtras();
        Usuario usuario   = (Usuario) getIntent().getSerializableExtra("usuario");
        intent.putExtra("usuario", usuario);

        btnAvancar   = findViewById(R.id.btnAvancar);
        btnAdicionar = findViewById(R.id.btnAdicionar);

        Service service = RetrofitConfig.getRetrofitInstance().create(Service.class);

        Call<Usuario> call = service.getUsuarioByEmail(usuario.getEmail());
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if(response.body().getPeso() > 0 && response.body().getPeso()  < 50){
                    Call<ArrayList<Peso>> call2 = service.getExercicio50_150();
                    call2.enqueue(new Callback<ArrayList<Peso>>() {
                        @Override
                        public void onResponse(Call<ArrayList<Peso>> call, Response<ArrayList<Peso>> response) {
                            try {
                                if(response.isSuccessful()){
                                    populateGridView(response.body());
                                    for (Peso peso : response.body()) {
                                        System.out.println(peso.toString());
                                    }
                                }
                                else{
                                    Toast.makeText(Exercicios.this, "Response.isNotSucessul!", Toast.LENGTH_LONG).show();
                                }
                            }catch (Exception err){
                                System.err.println(err.getMessage());
                            }
                        }

                        @Override
                        public void onFailure(Call<ArrayList<Peso>> call, Throwable t) {
                            Toast.makeText(Exercicios.this, "Erro no onFailure", Toast.LENGTH_LONG).show();
                        }
                    });
                } else if(response.body().getPeso() > 50.0 && response.body().getPeso() < 60.0){
                    Call<ArrayList<Peso>> call2 = service.getExercicio60_160();
                    call2.enqueue(new Callback<ArrayList<Peso>>() {
                        @Override
                        public void onResponse(Call<ArrayList<Peso>> call, Response<ArrayList<Peso>> response) {
                            try {
                                if(response.isSuccessful()){
                                    populateGridView(response.body());
                                    for (Peso peso : response.body()) {
                                        System.out.println(peso.toString());
                                    }
                                }
                                else{
                                    Toast.makeText(Exercicios.this, "Response.isNotSucessul!", Toast.LENGTH_LONG).show();
                                }
                            }catch (Exception err){
                                System.err.println(err.getMessage());
                            }
                        }

                        @Override
                        public void onFailure(Call<ArrayList<Peso>> call, Throwable t) {
                            Toast.makeText(Exercicios.this, "Erro no onFailure", Toast.LENGTH_LONG).show();
                        }
                    });
                } else if(response.body().getPeso() > 60.0 && response.body().getPeso() < 70.0){
                    Call<ArrayList<Peso>> call2 = service.getExercicio70_170();
                    call2.enqueue(new Callback<ArrayList<Peso>>() {
                        @Override
                        public void onResponse(Call<ArrayList<Peso>> call, Response<ArrayList<Peso>> response) {
                            try {
                                if(response.isSuccessful()){
                                    populateGridView(response.body());
                                    for (Peso peso : response.body()) {
                                        System.out.println(peso.toString());
                                    }
                                }
                                else{
                                    Toast.makeText(Exercicios.this, "Response.isNotSucessul!", Toast.LENGTH_LONG).show();
                                }
                            }catch (Exception err){
                                System.err.println(err.getMessage());
                            }
                        }

                        @Override
                        public void onFailure(Call<ArrayList<Peso>> call, Throwable t) {
                            Toast.makeText(Exercicios.this, "Erro no onFailure", Toast.LENGTH_LONG).show();
                        }
                    });
                }else{
                    Call<ArrayList<Peso>> call2 = service.getExercicioPadrao();
                    call2.enqueue(new Callback<ArrayList<Peso>>() {
                        @Override
                        public void onResponse(Call<ArrayList<Peso>> call, Response<ArrayList<Peso>> response) {
                            try {
                                if(response.isSuccessful()){
                                    populateGridView(response.body());
                                    for (Peso peso : response.body()) {
                                        System.out.println(peso.toString());
                                    }
                                }
                                else{
                                    Toast.makeText(Exercicios.this, "Response.isNotSucessul!", Toast.LENGTH_LONG).show();
                                }
                            }catch (Exception err){
                                System.err.println(err.getMessage());
                            }
                        }

                        @Override
                        public void onFailure(Call<ArrayList<Peso>> call, Throwable t) {
                            Toast.makeText(Exercicios.this, "Erro no onFailure", Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Toast.makeText(Exercicios.this, "OnFailure do email!", Toast.LENGTH_LONG).show();
            }
        });

        btnAvancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent   = new Intent(Exercicios.this,Home.class);
                Usuario usuario = (Usuario) getIntent().getSerializableExtra("usuario");
                intent.putExtra("usuario", usuario);
                startActivity(intent);
            }
        });

        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Exercicios.this,CadastroExercicio.class);
                startActivity(intent);
            }
        });
    }
}