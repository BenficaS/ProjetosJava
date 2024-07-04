package br.com.newton.domain;

import java.util.LinkedList;

public class Questao1 {
    public static void main(String[] args) {
        LinkedList<String> filaComum = new LinkedList<>();
        LinkedList<String> filaPrioridade = new LinkedList<>();

        // Gerar senhas automaticamente de 1 a 200
        for (int senha = 1; senha <= 200; senha++) {


            if (senha % 2 == 1 && senha <= 100) {
                filaPrioridade.add(" (Senha: " + senha + ")");
            } else {
                filaComum.add(" (Senha: " + senha + ")");
            }
        }

        System.out.println("Lista de Prioridade:");
        for (String pessoa : filaPrioridade) {
            System.out.println(pessoa);
        }

        System.out.println("\nLista de Fila Comum:");
        for (String pessoa : filaComum) {
            System.out.println(pessoa);
        }
    }
}
