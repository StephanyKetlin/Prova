package com.example.prova;

public class Pessoa {

    /*Declarando as variaveis*/
    private Integer idade;
    private String nome;

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    /* O metodo 'toString' faz com que retorne varias variaveis ao mesmo tempo, (Vc pode usar esse return em alugum get acima tmb */
    public String toString() {
        return "Carro{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                '}';
    }
}
