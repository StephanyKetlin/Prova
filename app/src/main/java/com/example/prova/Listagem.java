package com.example.prova;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class Listagem extends AppCompatActivity {

    /*Declarando as variaveis*/
    private List<Cadastro> lista;
    private ListView listView;
    Pessoa pessoa = new Pessoa(); //Instanciando a classe "Cadastro" na variavel 'pessoa'

    /*"onCreate" é  como se fosse uma "Main"*/
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listagem);//Seta o Layout utilizado (xml)

        /*Captura do XML (Mapeamento)*/
        listView=findViewById(R.id.lista);

        iniciaFirebase(); //Executa o método "iniciaFirebase()"
    }

    /*Método para iniciar o FireBase (BD na nuvem)*/
    private void iniciaFirebase(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase= FirebaseDatabase.getInstance();
        firebaseDatabase.setPersistenceEnabled(true);//caso esteja falso
        databaseReference= firebaseDatabase.getReference();
    }

    /*Método de Preenchimento*/
    private void preencheLista(){
        ArrayAdapter arrayAdapter =new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,lista);
        listView.setAdapter(arrayAdapter);
    }

    private Integer idMaior(){
        int maior=0;
        for (Pessoa p:
                lista) {
            if (p.getId()>maior)
                maior=p.getId();
        }
        return maior+1;
    }
    /*Método para busca*/
    private void buscaItens(){
        databaseReference.child("Pessoa");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DataSnapshot dataSnapshot = snapshot.child("Pessoa");
                lista.clear();
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    Pessoa pessoa = postSnapshot.getValue(Pessoa.class);
                    lista.add(pessoa);
                }
                preencheLista(); //Executa o método "preencheLista()"
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    /*Método para busca*/
    private void buscaItens(){
        databaseReference.child("Pessoa");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DataSnapshot dataSnapshot = snapshot.child("Pessoa");
                lista.clear();
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    Pessoa pessoa = postSnapshot.getValue(Pessoa.class);
                    lista.add(pessoa);
                }
                preencheLista(); //Executa o método "preencheLista()"
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
}
