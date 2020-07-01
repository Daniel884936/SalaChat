package com.example.salachat;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import Entidades.Mensaje;
import de.hdodenhof.circleimageview.CircleImageView;

public class Chat extends AppCompatActivity {
    private Button btnEnviar;
    private RecyclerView recyclerView;
    private EditText edtMensaje;
    private CircleImageView imgPerfil;
    private TextView txtNombre;
    private  AdapterMensajes adapterMensajes;
    private FirebaseStorage storage;
    private StorageReference storageReference;
    private FirebaseDatabase database;
    private DatabaseReference reference;
    private ImageButton btnEnviarFoto;
    private static  final int PHOTO_SEND =1;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==PHOTO_SEND && requestCode==RESULT_OK){
            Uri uri = data.getData();
            storageReference = storage.getReference("Imagnene_chat");//Imagenes de mi chat
            StorageReference fotoReferencia = storageReference.child(uri.getLastPathSegment());
            fotoReferencia.putFile(uri).addOnSuccessListener(this, new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Uri u = taskSnapshot.getUploadSessionUri();
                    MnesajeEnviar mensaje = new MnesajeEnviar("Daniel te ha enviado una foto","2",u.toString(),
                            txtNombre.getText().toString(), ServerValue.TIMESTAMP);
                    reference .push().setValue(mensaje);

                }
            });
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        imgPerfil = findViewById(R.id.imgPerfil);
        recyclerView = findViewById(R.id.rvMnesajes);
        txtNombre = findViewById(R.id.txtNombre);
        btnEnviar = findViewById(R.id.btnEnviar);
        edtMensaje = findViewById(R.id.edtMensaje);
        btnEnviarFoto = findViewById(R.id.btnEnviarFoto);
//data
        database = FirebaseDatabase.getInstance();
        reference =database.getReference("chat");// sala de chatt
        storage = FirebaseStorage.getInstance();


        adapterMensajes = new AdapterMensajes(this);
        LinearLayoutManager l = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(l);
        recyclerView.setAdapter(adapterMensajes);


        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference.push().setValue(new MnesajeEnviar(edtMensaje.getText().toString(),"1",
                        txtNombre.getText().toString(),ServerValue.TIMESTAMP));
                edtMensaje.setText("");
                //coment
            }
        });

        btnEnviarFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_GET_CONTENT);
                i.setType("image/jpeg");
                i.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
                startActivityForResult(Intent.createChooser(i,"Selecciona una foto mi loco"),PHOTO_SEND);
            }
        });

        adapterMensajes.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart, itemCount);
                setEscrollBar();
            }
        });

        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                MensajeRecibir m = snapshot.getValue(MensajeRecibir.class);
                adapterMensajes.addMnesaje(m);


            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void setEscrollBar(){
        recyclerView.scrollToPosition(adapterMensajes.getItemCount()-1);
    }

}
