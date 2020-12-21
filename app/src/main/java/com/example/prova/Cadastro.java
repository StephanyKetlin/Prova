package com.example.prova;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import java.util.LinkedList;

public class Cadastro extends AppCompatActivity {

    /*Declarando as variaveis com referencia aos componentes da tela*/
    private EditText nome;
    private EditText idade;
    Pessoa pessoa = new Pessoa(); //Instanciando a classe "Cadastro" na variavel 'pessoa'

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro); //Seta o Layout utilizado (xml)

        /*Captura do XML (Mapeamento)*/
        nome= findViewById(R.id.editText_nome);
        idade= findViewById(R.id.editText_idade);

        iniciaFirebase(); //Executa o método "iniciaFirebase()"
        buscaItens(); //Executa o método "buscaItens()"
        lista= new LinkedList<>(); //Declarando uma lista
    }

    /*Método para iniciar o FireBase (BD na nuvem)*/
    private void iniciaFirebase(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase= FirebaseDatabase.getInstance();
        firebaseDatabase.setPersistenceEnabled(true);//caso esteja falso
        databaseReference= firebaseDatabase.getReference();
    }

    /*Método Salvar*/
    private void salva(View view){
        /*Salva os dados inseridos no xml dentro da classe Pessoa*/
        pessoa.setIdade(Integer.parseInt(idade.getText().toString()));
        pessoa.setNome(nome.getText().toString());
        pessoa.setId(idMaior());

        databaseReference.child("Pessoa").child(pessoa.getId()+"").setValue(pessoa);
    }

    private void buscaItem() {
        //  databaseReference.child("Pessoa").child("1");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Object nome = snapshot.child("Pessoa").child(pessoa.getId()).child(pessoa.getNome()).getValue(String.class);
                Toast.makeText(MainActivity.this, nome.toString(), Toast.LENGTH_LONG).show();
                //Pessoa pessoa = snapshot.getValue(Pessoa.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}
