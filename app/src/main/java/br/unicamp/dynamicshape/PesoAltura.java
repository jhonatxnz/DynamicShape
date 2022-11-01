package br.unicamp.dynamicshape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class PesoAltura extends AppCompatActivity {

    ImageView seta;
    EditText edtPeso,edtAltura;
    Button btnAvancar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peso_altura);

        seta       = findViewById(R.id.imgSeta);
        edtPeso    = findViewById(R.id.edtPesoo);
        edtAltura  = findViewById(R.id.edtAltura);
        btnAvancar = findViewById(R.id.btnAvancar);

        Intent intent     = getIntent();
        Bundle parametros = intent.getExtras();

        Usuario usuario = (Usuario) getIntent().getSerializableExtra("usuario");

        btnAvancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PesoAltura.this,Objetivo.class);
                if(edtPeso.getText().length() == 0 || edtAltura.getText().length() == 0){
                    Toast.makeText(PesoAltura.this, "Campos vazios", Toast.LENGTH_LONG).show();
                }else{
                    usuario.setPeso(Float.parseFloat(edtPeso.getText().toString()));
                    usuario.setAltura(Float.parseFloat(edtAltura.getText().toString()));
                    intent.putExtra("usuario", usuario);
                    startActivity(intent);
                }
            }
        });
        seta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PesoAltura.this, Genero.class);
                startActivity(intent);
            }
        });
    }
}