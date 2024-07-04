package br.com.newtonpaiva.main;

import javax.swing.*;

public class Estoque {
    public static void main(String[] args) {
        int[][] estoque = new int[4][5];
        int opcao = 0, armario = 0, prateleira = 0;
        boolean loop = true;

        while (loop) {
            armario = Integer.parseInt(JOptionPane.showInputDialog("Escolha um armario de 1 - 5"));
            prateleira = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da prateleira 0- 3"));
            if (armario <= 0 || armario >= 6) {
                JOptionPane.showMessageDialog(null, "Armario invalido escolha entre 1 - 5.");
                continue;
            }
            if (armario > 1 && armario < 5 && prateleira >= 0 && prateleira < 4) {
                if (estoque[prateleira][armario] < 10) {
                    estoque[prateleira][armario]++;
                    JOptionPane.showMessageDialog(null, "Caixa adicionada com sucesso.");
                } else {
                    JOptionPane.showMessageDialog(null, "Espaço insuficiente no armario.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Armario ou prateleiras invalidos.");
            }
            opcao = JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Continue", JOptionPane.YES_NO_OPTION);
            loop = opcao == JOptionPane.YES_OPTION;
        }
        StringBuilder resultado = new StringBuilder("Quantidade de caixas em cada prateleira/armário:\n");
        for ( prateleira = 0; prateleira < 4; prateleira++) {
            for ( armario = 0; armario < 5; armario++) {
                resultado.append("Armário ").append(armario).append(", Prateleira ").append(prateleira)
                        .append(": ").append(estoque[prateleira][armario]).append(" caixas\n");
            }
        }
        JOptionPane.showMessageDialog(null, resultado.toString());
    }
}
