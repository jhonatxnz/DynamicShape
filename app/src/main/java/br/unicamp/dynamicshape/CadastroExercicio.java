package br.unicamp.dynamicshape;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CadastroExercicio extends AppCompatActivity {
    ImageView seta;
    Button btnAdicionarImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_exercicio);
        seta = findViewById(R.id.imgSeta);
        btnAdicionarImg = findViewById(R.id.btnAdicionarImg);
        Intent intent = getIntent();
        btnAdicionarImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                AlertDialog.Builder selecionarFoto = new AlertDialog.Builder(CadastroExercicio.this);
//                selecionarFoto.setTitle("djh");
//                selecionarFoto.setTitle("tem ctz?");
//                selecionarFoto.setCancelable(false);
//                selecionarFoto.setPositiveButton("Sim",);
//                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(intent,1);
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
}