public class Questao2 {
    public static void main(String[] args) {
        int[] noiva = new int[60];
        int[] noivo = new int[55];
        int[] lista = new int[115];

        int cont = 0;

        for (int i = 0; i < 60; i++) {
            noiva[i] = i;
        }
        System.out.println();
        for (int i = 0; i < 55; i++) {
            noivo[i] = i;
        }
        for (int i = 0; i < 60; i++) {
            lista[i] = noiva[i];
        }
        for (int i = 60; i < 115; i++) {
            lista[i] = noivo[cont];
            cont++;
        }
        System.out.println(" Lista de convidados");
        for (int convidados : lista) {
            System.out.print(convidados + " ");
        }
    }

}
