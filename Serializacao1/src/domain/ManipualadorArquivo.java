package domain;

import java.io.*;
import java.util.Scanner;

public class ManipualadorArquivo {
    public static void leitor(String path) throws IOException {
        BufferedReader buffread = new BufferedReader(new FileReader(path));
        String linha = "";
        while (true) {
            if (linha != null) {
                System.out.println(linha);
            } else
                break;
            linha = buffread.readLine();
        }
        buffread.close();
    }

    public static void escritor(String path) throws IOException {
        BufferedWriter buffwrite = new BufferedWriter(new FileWriter(path));
        String linha = "";
        Scanner in = new Scanner(System.in);
        System.out.println("Escreva algo: ");
        linha = in.nextLine();
        buffwrite.append(linha + "\n");
        buffwrite.close();
    }
}
