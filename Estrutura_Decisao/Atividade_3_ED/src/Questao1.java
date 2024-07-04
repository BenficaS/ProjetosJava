
public class Questao1 {
    public static void main(String[] args) {
        int[] vetComun = new int[150];
        int[] vetImp = new int[50];

        int contadorImp = 0;
        int contadorPar = 0;


        for (int i = 0; i < 200; i++) {
            if (i % 2 == 1 && i < 100 && contadorImp < 50) {
                vetImp[contadorImp] = i;
                contadorImp++;
            } else if (contadorPar < 150) {
                vetComun[contadorPar] = i;
                contadorPar++;
            }
        }
        System.out.println("Imprimindo fila comum: ");
        for (int par : vetComun) {
            System.out.print(par + " ");
        }
        System.out.println();
        System.out.println("Imprimindo fila Prioritaria: ");
        for (int impar : vetImp) {
            System.out.print(impar + " ");

        }
    }
}



