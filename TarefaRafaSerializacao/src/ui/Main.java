package ui;

import br.newtonpaiva.dominio.Banco;
import br.newtonpaiva.dominio.Cliente;
import br.newtonpaiva.dominio.Conta;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        String nomeCliente = JOptionPane.showInputDialog("Nome do cliente: ");
        Cliente c1 = new Cliente(nomeCliente);

        String nomeBanco = JOptionPane.showInputDialog("Nome do banco: ");
        Banco b1 = new Banco(nomeBanco, new ArrayList<>());

        String path = "C:\\Users\\Guuh\\Documents\\Arquivo\\Arquivo.txt";
        BufferedReader br = new BufferedReader(new FileReader(path));
        String linha;

        while ((linha = br.readLine()) != null) {
            String[] dados = linha.split(",");
            int numAgencia = Integer.parseInt(dados[0]);
            String numConta = dados[1];
            double saldo = Double.parseDouble(dados[2]);

            Conta conta = new Conta(numAgencia, numConta, saldo);
            b1.getContas().add(conta);
        }
        br.close();

        String path2 = "C:\\Users\\Guuh\\Documents\\Arquivo\\ArquivoFinal.txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter(path2));
        bw.write("Banco " + b1.getNome() + " possui o saldo geral de contas de R$ " + b1.somaTotalContas(b1.getContas()));
        bw.close();
    }
}
