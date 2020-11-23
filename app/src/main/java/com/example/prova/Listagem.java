package com.example.prova;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class Listagem extends AppCompatActivity {

    /*Declarando as variaveis*/
    private List<Cadastro> lista;
    private ListView listView;

    /*"onCreate" é  como se fosse uma "Main"*/
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listagem);//Seta o Layout utilizado (xml)

        /*Captura do XML (Mapeamento)*/
        listView=findViewById(R.id.lista);
    }
}
