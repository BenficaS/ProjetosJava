package br.com.newton.domain;

import java.util.Random;

public class Atividade02 {
    public static void main(String[] args) {

        Random random = new Random(0);
        int[] numero = new int[51];
        int aux = 0;
        int i = 0;
        int x = 3;


        for (i = 0; i < numero.length; i++) {
            numero[i] = random.nextInt(10);

            System.out.println("O tamanho do vetor é: " + i);
            System.out.println("0 Valor no vetor é : " + numero[i]);
            System.out.println("");
        }
        for (i=0;i<50;i++){
            for (int j = 0;j<50;j++){
                if (numero[j]>numero[j+1]){
                    aux = numero[j+1];
                    numero[j+1] = aux;
                }
            }
        }


        int inicio = 0;
        int meio = 0;
        int fim = numero.length - 1;

        while (inicio <= fim) {
            meio = (fim + inicio) / 2;
            System.out.println("Inicio: " + numero[inicio] + " - Meio: " + numero[meio] + " - Fim: " +
                    numero[fim]);


            if (numero[meio] == x) {
                System.out.println("Encontrou o número " + x);
                break;
            }

            if (numero[meio] < x) {
                inicio = meio + 1;
            } else if (numero[meio]>x) {

                fim = meio - 1;

            }else{
                    System.out.println("Encontrou o numero " + x);
                    break;
                }
            }
        }
    }




