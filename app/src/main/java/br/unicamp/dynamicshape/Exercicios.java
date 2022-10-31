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
    float pesoGlobal = 0;
    float alturaGlobal = 0;
    Button btnExercicio,btnAvancar,btnAdicionar;
    RecyclerView recyclerView;
    ArrayList<Peso> list = new ArrayList<>();
    MeuAdaptador adaptador;
    GridView exerciciosGridView;

    public void populateGridView(List<Peso> listaPeso){
        exerciciosGridView = findViewById(R.id.exerciciosGridView);
        exerciciosGridView.setAdapter(new GridViewAdapter(this,listaPeso));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicios);

        Intent intent = getIntent();
        Bundle parametros = intent.getExtras();

        Usuario usuario = (Usuario) getIntent().getSerializableExtra("usuario");
        intent.putExtra("usuario", usuario);

        // btnExercicio = findViewById(R.id.btnExercicio);
        btnAvancar = findViewById(R.id.btnAvancar);
        btnAdicionar = findViewById(R.id.btnAdicionar);
        // recyclerView = findViewById(R.id.recyclerView);

        // recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Service service = RetrofitConfig.getRetrofitInstance().create(Service.class);

        Call<Usuario> call2 = service.getUsuarioByEmail(usuario.getEmail());
        call2.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
              pesoGlobal   = response.body().getPeso();
              alturaGlobal = response.body().getAltura();
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Toast.makeText(Exercicios.this, "hdjasdjghahjsdgajhdsgjhasgdjhagdsjhgasdjhgasdjh!", Toast.LENGTH_LONG).show();
            }
        });
        System.err.println("EU PRECISO DISSOOOO: " + pesoGlobal);
        //if(pesoGlobal > 0 && pesoGlobal < 50){
            Call<ArrayList<Peso>> call = service.getExercicio50_150();
            call.enqueue(new Callback<ArrayList<Peso>>() {
                @Override
                public void onResponse(Call<ArrayList<Peso>> call, Response<ArrayList<Peso>> response) {
                    try {
                        if(response.isSuccessful()){
                            System.out.println("RESPOSTA: " + response.body());
                            populateGridView(response.body());
                            for (Peso peso : response.body()) {
                                System.out.println(peso.toString());
                            }

//                            adaptador = new MeuAdaptador(list);
//                            recyclerView.setAdapter(adaptador);
//
//                            adaptador.setItemClickListener(new ItemClickListener() {
//                                @Override
//                                public void onItemClick(int position, Peso exercData) {
//
//                                }
//                            });
                        }
                        else{
                            Toast.makeText(Exercicios.this, "blablabla!", Toast.LENGTH_LONG).show();
                        }
                    }catch (Exception err){
                        System.err.println(err.getMessage());
                    }
                }

                @Override
                public void onFailure(Call<ArrayList<Peso>> call, Throwable t) {
                    Toast.makeText(Exercicios.this, "ERRO NO onfailure", Toast.LENGTH_LONG).show();
                }
            });
//        }
//        else if(pesoGlobal > 50.0 && pesoGlobal < 60.0){
//
//        }
//        else{
//
//        }

//        btnExercicio.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Exercicios.this,Exercicio.class);
//                startActivity(intent);
//            }
//        });
        btnAvancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Exercicios.this,Home.class);
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