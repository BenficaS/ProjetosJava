package br.newtonpaiva.dominio;

import java.util.LinkedList;
import java.util.List;

public abstract class Pessoa {

    private String nome;
    private List <Conta> conta = new LinkedList();

    public abstract void validarDocumento();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List getConta() {
        return conta;
    }

    public void setConta(List conta) {
        this.conta = conta;
    }
}
