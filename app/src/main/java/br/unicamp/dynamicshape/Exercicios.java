package br.unicamp.dynamicshape;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Exercicios extends AppCompatActivity {

    Button btnExercicio,btnAvancar,btnAdicionar;
    RecyclerView recyclerView;
    List<Peso> list = new ArrayList<>();
    MeuAdaptador adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicios);

        btnExercicio = findViewById(R.id.btnExercicio);
        btnAvancar = findViewById(R.id.btnAvancar);
        btnAdicionar = findViewById(R.id.btnAdicionar);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();
        Bundle parametros = intent.getExtras();

        Usuario usuario = (Usuario) getIntent().getSerializableExtra("usuario");
        intent.putExtra("usuario", usuario);

        Service service = RetrofitConfig.getRetrofitInstance().create(Service.class);
        Call<Usuario> call = service.getUsuarioByEmail(usuario.getEmail().toString());
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                Service service2 = RetrofitConfig.getRetrofitInstance().create(Service.class);
                Call<List<Peso>> call2 = service.getExercicio50_150();

                call2.enqueue(new Callback<List<Peso>>() {
                    @Override
                    public void onResponse(Call<List<Peso>> call, Response<List<Peso>> response) {
                        try {
                            if(response.isSuccessful()){
                                System.err.println("RESPOSTA: " + response.body());
                                list.addAll(response.body());
                                adaptador = new MeuAdaptador(list);
                                recyclerView.setAdapter(adaptador);
                                adaptador.notifyDataSetChanged();
                            }
                            else{
                                Toast.makeText(Exercicios.this, "blablabla!", Toast.LENGTH_LONG).show();

                            }
                        }catch (Exception err){
                            System.err.println(err.getMessage());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Peso>> call, Throwable t) {
                        Toast.makeText(Exercicios.this, "ERRO NO onfailure", Toast.LENGTH_LONG).show();
                    }
                });
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {

            }
        });



        btnExercicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Exercicios.this,Exercicio.class);
                startActivity(intent);
            }
        });
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