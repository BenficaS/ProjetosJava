import java.util.Scanner;

public class Ex1Diagnostica {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int[] vet = new int[8];
        int somaTotal = 0;
        int aux = 0;
        int soma = 0;


        for (int i = 0; i < 8; i++) {
            System.out.println("Entre com o número " + (i + 1));
            vet[i] = ler.nextInt();
        }
        for (int i = 0; i<8;i++){
            somaTotal = somaTotal+vet[i];
        }
        for (int i = 0; i < 8; i++) {
            if (vet[i] > 30) {
                soma += vet[i];
                aux++;

            }

        }
        System.out.println("A quantidade de numeros acima de 30 no vetor é: " + aux);
        System.out.println("a soma dos numeros do vetor são: " + soma);
        System.out.println("a soma do vetor é: " +somaTotal );
    }
}
