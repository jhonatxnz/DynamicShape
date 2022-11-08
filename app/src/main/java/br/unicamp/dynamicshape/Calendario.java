package br.unicamp.dynamicshape;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.provider.MediaStore;
import android.service.controls.actions.FloatAction;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Base64;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Calendario extends AppCompatActivity {
    FloatingActionButton btnImage,btnEscImage;
    ImageView img;

    private Bitmap StringToBitMap(String encodedString){
        try{
            byte [] encodeByte = Base64.getDecoder().decode(encodedString);
            Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        }
        catch(Exception e){
            e.getMessage();
            return null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);
        btnImage = findViewById(R.id.btnAdicionarImagem);
        btnEscImage = findViewById(R.id.btnEscolherImagem);
        img = findViewById(R.id.ivFoto);

        Intent intent     = getIntent();
        Bundle parametros = intent.getExtras();

        Usuario usuario = (Usuario) getIntent().getSerializableExtra("usuario");
        intent.putExtra("usuario", usuario);

        Service service = RetrofitConfig.getRetrofitInstance().create(Service.class);
        service = RetrofitConfig.getRetrofitInstance().create(Service.class);

        service.getUsuarioByEmail(usuario.getEmail()).enqueue(
                new Callback<Usuario>() {
                    @Override
                    public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                        img.setImageBitmap(StringToBitMap(response.body().getImagem()));
                    }

                    @NonNull
                    @Override
                    protected Object clone() throws CloneNotSupportedException {
                        return super.clone();
                    }

                    @Override
                    public void onFailure(Call<Usuario> call, Throwable t) {
                    }
                }
        );

        btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,1);
            }
        });
        btnEscImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PegarImagem();
            }
        });
    }

    protected void onActivityResult(int requestCode,int resultCode,Intent dados) {
        Intent intent     = getIntent();
        Bundle parametros = intent.getExtras();

        Usuario usuario = (Usuario) getIntent().getSerializableExtra("usuario");
        intent.putExtra("usuario", usuario);

        super.onActivityResult(requestCode, resultCode, dados);
        if(requestCode == 1) { //funciona
            if (dados != null) {
                Bundle bundle = dados.getExtras();
                if (bundle != null) {
                    Bitmap bitmap = (Bitmap) bundle.get("data");
                    img.setImageBitmap(bitmap);

                    byte [] fotoEmBytes;
                    ByteArrayOutputStream streamDaFotoEmBytes = new ByteArrayOutputStream();

                    bitmap.compress(Bitmap.CompressFormat.PNG, 70,streamDaFotoEmBytes);
                    fotoEmBytes = streamDaFotoEmBytes.toByteArray();
                    String fotoEmString = Base64.getEncoder().encodeToString(fotoEmBytes);

                    Service service = RetrofitConfig.getRetrofitInstance().create(Service.class);

                    Call<Usuario> call2 = service.getUsuarioByEmail(usuario.getEmail());
                    call2.enqueue(new Callback<Usuario>() {
                        @Override
                        public void onResponse(Call<Usuario> call2, Response<Usuario> response) {

                            usuario.setImagem(fotoEmString);
                            usuario.setNome(response.body().getNome());
                            usuario.setIdade(response.body().getIdade());
                            usuario.setTempo(response.body().getTempo());
                            usuario.setEmail(response.body().getEmail());
                            usuario.setPeso(response.body().getPeso());
                            usuario.setAltura(response.body().getAltura());
                            usuario.setSenha(response.body().getSenha());
                            usuario.setGenero(response.body().getGenero());
                            usuario.setObjetivo(response.body().getObjetivo());

                            System.err.println("nome: "+ usuario.getNome());
                            System.err.println("idade: "+ usuario.getIdade());
                            System.err.println("tempo: "+ usuario.getTempo());
                            System.err.println("email: "+ usuario.getEmail());
                            System.err.println("peso: "+ usuario.getPeso());
                            System.err.println("altura: "+ usuario.getAltura());
                            System.err.println("senha: "+ usuario.getSenha());
                            System.err.println("imagem: "+ usuario.getImagem());
                            System.err.println("idGenero: "+ usuario.getGenero());
                            System.err.println("idObjetivo: "+ usuario.getObjetivo());

                            Call<Usuario> call = service.alterarUsuario(usuario.getEmail(), usuario);
                            call.enqueue(new Callback<Usuario>() {
                                @Override
                                public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                                    if(response.isSuccessful()){
                                        Toast.makeText(Calendario.this, "Deu certo", Toast.LENGTH_LONG).show();
                                    }
                                    else{
                                        Toast.makeText(Calendario.this, "Deu Errado", Toast.LENGTH_LONG).show();
                                    }
                                }

                                @Override
                                public void onFailure(Call<Usuario> call, Throwable t) {
                                    Toast.makeText(Calendario.this, "Ocorre um erro de requisição no Node: " + t.toString(), Toast.LENGTH_LONG).show();
                                }
                            });
                        }
                        @Override
                        public void onFailure(Call<Usuario> call2, Throwable t) {
                        }
                    });
                }
            }
        }
        if(requestCode == 2)
        {
            if(resultCode == RESULT_OK)
            {
                Uri uri = dados.getData();
                Cursor cursor = getContentResolver().query(uri, new String[]{MediaStore.Images.Media.DATA}, null, null, null);
                cursor.moveToFirst();
                int indexColuna = cursor.getColumnIndex(MediaStore.Images.Media.DATA); // aqui sempre vem 0
                String path = cursor.getString(indexColuna);
                cursor.close();
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                img.setImageBitmap(bitmap);
            }
        }
    }

    public void PegarImagem()
    {

        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(Intent.createChooser(intent, "Selecione uma imagem"), 2);
    }
}