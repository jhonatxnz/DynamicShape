package br.unicamp.dynamicshape;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText edtEmail,edtSenha;
    TextView tvCadastrar;
    Button btnAvancar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtEmail    = findViewById(R.id.edtEmail);
        edtSenha    = findViewById(R.id.edtSenha);
        tvCadastrar = findViewById(R.id.tvCadastrar);
        btnAvancar  = findViewById(R.id.btnAvancar);

        btnAvancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(edtEmail.getText().toString()  == ""||
                        edtSenha.getText().toString()  == ""){
                    Toast.makeText(MainActivity.this, "Campos vazios", Toast.LENGTH_LONG).show();
                }else {
                    Usuario user = new Usuario(edtEmail.getText().toString(), edtSenha.getText().toString());
                    Logar(user);
                }
            }
        });
        tvCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Cadastro.class);
                startActivity(intent);
            }
        });

    }
    private void Logar(Usuario usuario){
        Service service = RetrofitConfig.getRetrofitInstance().create(Service.class);
        Call<Usuario> call = service.getLogin(usuario);

        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                try {
                    if(response.isSuccessful()){
                        Intent intent = new Intent(MainActivity.this,Home.class);
                        intent.putExtra("usuario", usuario);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Email ou senha incorreto!", Toast.LENGTH_LONG).show();

                    }
                }catch (Exception err){
                    System.err.println(err.getMessage());
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}