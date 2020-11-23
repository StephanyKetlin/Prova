package com.example.prova;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    /*Declarando as variaveis*/
    private Button cadastro;
    private Button listagem;
    private final Integer OK_TELA_CADASTR0=201;

    @Override
    /*"onCreate" é  como se fosse uma "Main"*/
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity); //Seta o Layout utilizado (xml)

        /*Captura do XML (Mapeamento)*/
        listagem=findViewById(R.id.btn_listagem);
        cadastro=findViewById(R.id.btn_cadastro);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*PROCEDIMENTO "AcaoBotao", aparece na barra de opções onClick*/
    public void TelaCadastro(View view){
        Intent it = new Intent(MainActivity.this,Cadastro.class);//SINTAXE: Intent([Nome da classe que deseja ser o "link" de volta].this,[Nome da outra classe ("link" de ida)].class)
        startActivityForResult(it,OK_TELA_CADASTR0);//Carrega os dados da Intent (Carrega a pagina "NovaPagina")
    }

    /*PROCEDIMENTO "AcaoBotao", aparece na barra de opções onClick*/
    public void TelaListagem(View view){
        Intent it = new Intent(MainActivity.this,Cadastro.class);//SINTAXE: Intent([Nome da classe que deseja ser o "link" de volta].this,[Nome da outra classe ("link" de ida)].class)
        startActivityForResult(it,OK_TELA_CADASTR0);//Carrega os dados da Intent (Carrega a pagina "NovaPagina")
    }
}