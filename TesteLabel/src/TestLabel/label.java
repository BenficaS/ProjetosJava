package TestLabel;

import java.awt.Container;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.text.MaskFormatter;


    public class label extends JFrame{

        private static final long serialVersionUID = 1L;

        public static void main(String[] args) {

            label field = new label();
            field.testaJformattedTextField();

        }

        private void testaJformattedTextField() {

                Container janela = getContentPane();
                setLayout(null);

                JLabel labelCep = new JLabel("CEP: ");
                JLabel labelTel = new JLabel("telefone");
                JLabel labelCPF = new JLabel("CPF: ");
                JLabel labelDATA = new JLabel("Data: ");

                labelCep.setBounds(50,40,100,20);
                labelTel.setBounds(50,80,100,20);
                labelCPF.setBounds(50,120,100,20);
                labelDATA.setBounds(50,160,100,20);

                MaskFormatter mascaraCep=null;
                MaskFormatter mascaraTel=null;
                MaskFormatter mascaraCPF=null;
                MaskFormatter mascaraDATA=null;

                try {
                    mascaraCep = new MaskFormatter("#####-##");
                    mascaraTel = new MaskFormatter("(##)####-####");
                    mascaraCPF = new MaskFormatter("##########-##");
                    mascaraDATA = new MaskFormatter("##/##/####");

                    mascaraCep.setPlaceholderCharacter('_');
                    mascaraTel.setPlaceholderCharacter('_');
                    mascaraCPF.setPlaceholderCharacter('_');
                    mascaraDATA.setPlaceholderCharacter('_');

                }
                catch (ParseException excp){
                    System.err.println("Erro  na formatação: " + excp.getMessage());
                    System.exit(-1);
                }
                JFormattedTextField JformatedTextCep = new JFormattedTextField("Mascara Cep");
                JFormattedTextField JformatedTextTel = new JFormattedTextField("Mascara Tell");
                JFormattedTextField JformateTextCPF = new JFormattedTextField("Mascara  CPF");
                JFormattedTextField JformatedTextDATA = new JFormattedTextField("Mascara Data");

                JformatedTextCep.setBounds(150,40,100,20);
                JformatedTextTel.setBounds(150,80,100,20);
                JformateTextCPF.setBounds(150,120,100,20);
                JformatedTextDATA.setBounds(150,160,100,20);

                janela.add(labelCep);
                janela.add(labelTel);
                janela.add(labelCPF);
                janela.add(labelDATA);

                setSize(400,250);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setVisible(true);
        }
}
