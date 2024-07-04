import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Questao1P {
    public static void main(String[] args) throws FileNotFoundException {

        Stack Pilha = new Stack();
        Scanner scanner;
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);

        scanner = new Scanner(new File("C:/Users/12111280/Documents/Lista_URL.txt"));
        while (scanner.hasNextLine()) {
            Pilha.push(scanner.nextLine());
        }


        System.out.println("Pilha de links: " + Pilha);
        System.out.println("Tamanho da Pilha: " + Pilha.size());


        System.out.println("Digite um link para ser excluido: ");
        String exclusaoLink = scanner1.nextLine();


        if (Pilha.contains(exclusaoLink)) {
            Pilha.remove(exclusaoLink);
            System.out.println("Link removido!");
        } else {
            System.out.println("O Link Não existe!");
        }



        System.out.println("Tamanho de Pilha: " + Pilha.size());
        System.out.println("Quantidade de inks: " + Pilha);


        System.out.println("Pesquise um link para consultar: ");
        String link2 = scanner2.nextLine();
        if (Pilha.contains(link2)) {
            System.out.println("Link Encontrado com Sucesso!");
        } else {
            System.out.println("Link não Inexistente!");
        }
    }
}