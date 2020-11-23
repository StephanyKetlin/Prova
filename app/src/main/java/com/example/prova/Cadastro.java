package com.example.prova;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Cadastro extends AppCompatActivity {

    /*Declarando as variaveis com referencia aos componentes da tela*/
    private EditText nome;
    private EditText idade;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro); //Seta o Layout utilizado (xml)

        /*Captura do XML (Mapeamento)*/
        nome= findViewById(R.id.editText_nome);
        idade= findViewById(R.id.editText_idade);
    }

    /*PROCEDIMENTO "AcaoBotao", aparece na barra de opções onClick*/
    public  void salvar(View view){

    }

}
