import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Scanner;

//Elabore um programa que utilize o TAD Doquer para
//        adicionar objetos de uma classe contendo os seguintes
//        atributos:
//        Nome, telefone e e-mail.
//        O programa deve solicitar os dados de 10 pessoas.
//        Ao final imprimir a lista na ordem convencional e na ordem
//        inversa


public class Questao2 {
    public static void main(String[] args) {
        String nome, email,telefone;



        Deque<Pessoa> dq = new ArrayDeque<>();
        Pessoa p;

        Scanner ler = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            System.out.println("Adcione NOME:");
            nome = ler.next();
            System.out.println("TELEFONE:");
            email = ler.next();
            System.out.println("email:");
            telefone = ler.next();
            p = new Pessoa(nome, telefone, email);
            dq.add(p);


        }
        for (Iterator itr = dq.iterator(); itr.hasNext(); ) {
            System.out.print(itr.next().toString());

        }

        System.out.println();

        for (Iterator itr = dq.descendingIterator(); itr.hasNext(); ) {
            System.out.print(itr.next().toString());
        }
    }
}

