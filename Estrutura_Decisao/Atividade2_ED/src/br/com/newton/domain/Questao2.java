package br.com.newton.domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Questao2 {
    public static void main(String[] args) throws FileNotFoundException {
        LinkedList<String> listaNoiva = new LinkedList<String>();
        LinkedList<String> listanoivo = new LinkedList<String>();

        Scanner scannerNoiva = new Scanner(new File("src/br/com/newton/domain/noiva.txt"));
        while (scannerNoiva.hasNextLine()) {
            listaNoiva.add(scannerNoiva.nextLine());
        }

        Scanner scannerNoivo = new Scanner(new File("src/br/com/newton/domain/noivo.txt"));
        while (scannerNoivo.hasNextLine()) {
            listanoivo.add(scannerNoivo.nextLine());
        }
        LinkedList<String> convidados = new LinkedList<>(listaNoiva);
        //for (String nome: listanoivo) {
        //convidados.add(nome);
        convidados.addAll(listanoivo);
        //adiciona lista de convidados

        Collections.sort(convidados);
        //ordem alfabetica
        for (String nome : convidados) {
            System.out.println(nome);

        }

    }

}








