import java.util.Arrays;

public class Questao2 {
    public static void main(String[] args) {
        String[] vetorNoiva = {
                "João", "Maria", "José", "Ana", "Pedro", "Mariana", "Carlos", "Isabel", "Lucas", "Fernanda",
                "Rafael", "Laura", "Gustavo", "Camila", "André", "Beatriz", "Felipe", "Juliana", "Diego",
                "Patrícia", "Eduardo", "Carolina", "Leandro", "Larissa", "Bruno", "Amanda", "Ricardo", "Cláudia",
                "Márcio", "Cristina", "Henrique", "Tatiana", "Rodrigo", "Marta", "Marcos", "Vanessa", "Renato",
                "Márcia", "Feliciano", "Catarina", "Carlos", "Antônia", "Raul", "Cecília", "Silvio", "Cíntia",
                "Bruno", "Daniela", "Milton", "Teresa", "Rogério", "Rita", "Hugo", "Vera", "Pedro", "Júlia"
        };

        String[] vetorNoivo = {
                "Fernando", "Beatriz", "Leonardo", "Helena", "Rogério", "Lorena", "Victor", "Mara", "Ricardo",
                "Sofia", "André", "Flávia", "Eduardo", "Aline", "Gustavo", "Renata", "Jorge", "Cíntia", "Luis",
                "Raquel", "Paulo", "Rosa", "Felipe", "Rita", "Carlos", "Fernanda", "Miguel", "Alice", "Cesar",
                "Luciana", "Roberto", "Cláudia", "Francisco", "Sofia", "Ricardo", "Lúcia", "Marcelo", "Vivian",
                "Renato", "Márcia", "Feliciano", "Catarina", "Carlos", "Antônia", "Raul", "Cecília", "Pedro", "Júlia"
        };

        String[] lista = new String[vetorNoiva.length + vetorNoivo.length];

        for (int i = 0; i < vetorNoiva.length; i++) {
            lista[i] = vetorNoiva[i];
        }

        for (int i = 0; i < vetorNoivo.length; i++) {
            lista[vetorNoiva.length + i] = vetorNoivo[i];
        }
        Arrays.sort(lista);

        System.out.println("Lista de convidados:");
        for (String convidado : lista) {
            System.out.println(convidado);
        }
    }
}
