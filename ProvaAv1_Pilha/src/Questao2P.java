public class Questao2P {
    public static void main(String[] args) {

        int[][] estante = new int[40][40];
        int[] produtos = {10, 20, 30, 40, 50, 0};
        int[] quantidade = new int[produtos.length];
        int i, j;

        for (i = 0; i < estante.length; i++) {
            for (j = 0; j < estante[i].length; j++) {
                estante[i][j] = produtos[(int) (Math.random() * produtos.length)];
                System.out.print(estante[i][j] + "\t");
            }
            System.out.println("");
        }

        for (i = 0; i < estante.length; i++) {
            for (j = 0; j < estante[i].length; j++) {
                int produtoAtual = estante[i][j];


                switch (produtoAtual) {
                    case 10:
                        quantidade[0]++;
                        break;
                    case 20:
                        quantidade[1]++;
                        break;
                    case 30:
                        quantidade[2]++;
                        break;
                    case 40:
                        quantidade[3]++;
                        break;
                    case 50:
                        quantidade[4]++;
                        break;
                    case 0:
                        quantidade[5]++;
                        break;
                }
            }
        }
        System.out.println("\nQuantidade de Caixas Shampoo 1: " + quantidade[0]);
        System.out.println("Quantidade de Caixas Condicionador 2: " + quantidade[1]);
        System.out.println("Quantidade de Caixas Hidratantes 3: " + quantidade[2]);
        System.out.println("Quantidade de Caixas Tintura 4: " + quantidade[3]);
        System.out.println("Quantidade de Caixas Demaquilante 5: " + quantidade[4]);
        System.out.println("Quantidade de Espaços Vazios: " + quantidade[5]);
    }
}