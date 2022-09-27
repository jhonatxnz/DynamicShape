package br.unicamp.dynamicshape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Objetivo extends AppCompatActivity {

    ImageView seta,imgEmagrecer,imgGanharMusculo;
    EditText edtDuracao;
    Button btnAvancar;
    Integer Objetivo = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objetivo);

        seta = findViewById(R.id.imgSeta);
        imgEmagrecer = findViewById(R.id.imgEmagrecer);
        imgGanharMusculo = findViewById(R.id.imgGanharMusculo);
        edtDuracao = findViewById(R.id.edtDuracao);
        btnAvancar = findViewById(R.id.btnAvancar);


        Intent intent = getIntent();
        Bundle parametros = intent.getExtras();
        Usuario usuario = (Usuario) getIntent().getSerializableExtra("usuario");

        imgEmagrecer.setOnClickListener(this::onClick);
        imgGanharMusculo.setOnClickListener(this::onClick);

       btnAvancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Objetivo.this,MainActivity.class);

                usuario.setObjetivo(Objetivo);


                if(edtDuracao.getText().length() == 0 || Objetivo < 0){
                    Toast.makeText(Objetivo.this, "Selecione o objetivo/coloque o tempo", Toast.LENGTH_LONG).show();
                }
                else
                {
                    usuario.setTempo(Float.parseFloat(edtDuracao.getText().toString()));

                    intent.putExtra("usuario", usuario);
                    System.err.println("Email: "+usuario.getEmail());
                    System.err.println("Nome: "+usuario.getNome());
                    System.err.println("Idade: "+usuario.getIdade());
                    System.err.println("Telefone: "+usuario.getTelefone());
                    System.err.println("Peso: "+usuario.getPeso());
                    System.err.println("Altura: "+usuario.getAltura());
                    System.err.println("Senha: "+usuario.getSenha());
                    System.err.println("Imagem: "+usuario.getImagem());
                    System.err.println("Genero: "+usuario.getGenero());
                    System.err.println("Objetivo: "+usuario.getObjetivo());
                    System.err.println("Tempo: "+usuario.getTempo());

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
                Objetivo = 2;
                break;
            case R.id.imgGanharMusculo:
                Objetivo = 1;
                break;
        }
    }
}