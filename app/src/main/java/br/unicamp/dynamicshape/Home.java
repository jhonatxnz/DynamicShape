package br.unicamp.dynamicshape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home extends AppCompatActivity {

    ImageView imgExercicios;
    Button btnMes;
    TextView tvSair;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent intent = getIntent();
        Bundle parametros = intent.getExtras();

        imgExercicios = findViewById(R.id.imgExercicios);
        btnMes = findViewById(R.id.btnMes);
        tvSair = findViewById(R.id.tvSair);

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
                Usuario usuario = new Usuario();
                Logout(usuario);
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
    private void Logout(Usuario usuario){
        Service service = RetrofitConfig.getRetrofitInstance().create(Service.class);
        Call<Usuario> call = service.getLogout(usuario);

        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                try {
                    if(response.isSuccessful()){
                        Intent intent = new Intent(Home.this,MainActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(Home.this, "Erro ao deslogar", Toast.LENGTH_LONG).show();

                    }
                }catch (Exception err){
                    System.err.println(err.getMessage());
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Toast.makeText(Home.this, "Erro ao deslogar", Toast.LENGTH_LONG).show();
            }
        });
    }

}