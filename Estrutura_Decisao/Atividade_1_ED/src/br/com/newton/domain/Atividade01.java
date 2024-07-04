package br.com.newton.domain;

import java.util.Random;

public class Atividade01 {
    public static void main(String[] args) {

        Random random = new Random(10);
        int busca = 4, posicaoVetor, impr;
        int[] vet = new int[10];
        for (int i = 0; i < vet.length; i++) {
            vet[i] = random.nextInt(9);
        }
        for (int i = 0; i < vet.length; i++) {


            System.out.println("posição vetor é : " + i + ". O valor interno do vetor é : " + vet[i]);

            if (busca == vet[i]) {
                posicaoVetor = i;
                System.out.println("Valor encontrado : " + busca + "A posição encontrada é : " + posicaoVetor);
                break;
            }
            System.out.println("Valor não encontrado.");
        }
    }
}

