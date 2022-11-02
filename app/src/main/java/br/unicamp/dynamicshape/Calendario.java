package br.unicamp.dynamicshape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.service.controls.actions.FloatAction;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class Calendario extends AppCompatActivity {
    FloatingActionButton btnImage,btnEscImage;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);
        btnImage = findViewById(R.id.btnAdicionarImagem);
        btnEscImage = findViewById(R.id.btnEscolherImagem);
        img = findViewById(R.id.ivFoto);

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

        super.onActivityResult(requestCode, resultCode, dados);
        if(requestCode == 1) { //funciona
            if (dados != null) {
                Bundle bundle = dados.getExtras();
                if (bundle != null) {
                    Bitmap bitmap = (Bitmap) bundle.get("data");
                    img.setImageBitmap(bitmap);

                    byte [] fotoEmBytes;
                    ByteArrayOutputStream streamDaFotoEmBytes = new ByteArrayOutputStream();



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
    public void TirarFoto(View view)
    {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivityForResult(intent,1);
    }
    public void PegarImagem()
    {

        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(Intent.createChooser(intent, "Selecione uma imagem"), 2);
    }
}