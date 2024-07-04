package br.newtonpaiva.ui;

import br.newtonpaiva.dominio.*;

public class MAIN {

    public static void main(String[] args) {
        Conta c = new Conta(10);
//        c.setNumero(10);
        c.setSaldo(100.0);

        c.depositar(50.0);
        c.sacar(20.0);

        Conta c2 = new Conta(20);
//        c2.setNumero(90);
        c2.setSaldo(500.0);

        Conta c3 = new Conta();

        if(c.equals(c2)){
            System.out.println("Mesma conta");
        }
        else {
            System.out.println("Contas diferentes");
        }

        c2.transferir(c, 300.0);

        System.out.println(c.getSaldo());

        Conta c10 = new Conta(123123213);

        Pessoa guilherme = new PessoaFisica();
        guilherme.setNome("Guilherme");
        guilherme.getConta().add(guilherme);
        guilherme.getConta().add(guilherme);

        //guilherme.getContas().remove(conta);

        //guilherme.setConta(c2);

        c.setPessoa(guilherme);

    }
}