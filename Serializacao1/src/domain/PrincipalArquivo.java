package domain;

import java.io.IOException;

public class PrincipalArquivo {
    public static void main(String[] args)throws IOException{
        String path = "C:\\Users\\12111280\\Documents\\AulaRafa\\Lista de nomes.txt";
        String pat2 = "C:\\Users\\12111280\\Documents\\AulaRafa\\Lista de sobrenomes.txt";
        ManipualadorArquivo.leitor(path);
        ManipualadorArquivo.leitor(pat2);
    }
}
