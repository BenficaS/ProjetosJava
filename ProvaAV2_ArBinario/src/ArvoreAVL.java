import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArvoreAVL {
    public class Node {
        private Node left, right, parent;
        private int height = 1;
        private int value;

        private Node(int val) {
            this.value = val;
        }
    }

    private int height(Node N) {
        if (N == null)
            return 0;
        return N.height;
    }

    private Node insert(Node node, int value) {
        /* 1.  Perform the normal BST rotation */
        if (node == null) {
            return (new Node(value));
        }

        if (value < node.value)
            node.left = insert(node.left, value);
        else
            node.right = insert(node.right, value);

        /* 2. Update height of this ancestor node */
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        /* 3. Get the balance factor of this ancestor node to check whether
           this node became unbalanced */
        int balance = getBalance(node);

        // If this node becomes unbalanced, then there are 4 cases

        // Left Left Case
        if (balance > 1 && value < node.left.value)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && value > node.right.value)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && value > node.left.value) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && value < node.right.value) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        /* return the (unchanged) node pointer */
        return node;
    }

    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        //  Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // Get Balance factor of node N
    private int getBalance(Node N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    public void preOrder(Node root) {
        if (root != null) {
            preOrder(root.left);
            System.out.printf("%d ", root.value);
            preOrder(root.right);
        }
    }

    private Node minValueNode(Node node) {
        Node current = node;
        /* loop down to find the leftmost leaf */
        while (current.left != null)
            current = current.left;
        return current;
    }

    private Node deleteNode(Node root, int value) {
        // STEP 1: PERFORM STANDARD BST DELETE

        if (root == null)
            return root;

        // If the value to be deleted is smaller than the root's value,
        // then it lies in left subtree
        if (value < root.value)
            root.left = deleteNode(root.left, value);

            // If the value to be deleted is greater than the root's value,
            // then it lies in right subtree
        else if (value > root.value)
            root.right = deleteNode(root.right, value);

            // if value is same as root's value, then This is the node
            // to be deleted
        else {
            // node with only one child or no child
            if ((root.left == null) || (root.right == null)) {

                Node temp;
                if (root.left != null)
                    temp = root.left;
                else
                    temp = root.right;

                // No child case
                if (temp == null) {
                    temp = root;
                    root = null;
                } else // One child case
                    root = temp; // Copy the contents of the non-empty child

                temp = null;
            } else {
                // node with two children: Get the inorder successor (smallest
                // in the right subtree)
                Node temp = minValueNode(root.right);

                // Copy the inorder successor's data to this node
                root.value = temp.value;

                // Delete the inorder successor
                root.right = deleteNode(root.right, temp.value);
            }
        }

        // If the tree had only one node then return
        if (root == null)
            return root;

        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
        root.height = Math.max(height(root.left), height(root.right)) + 1;

        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
        //  this node became unbalanced)
        int balance = getBalance(root);

        // If this node becomes unbalanced, then there are 4 cases

        // Left Left Case
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Right Case
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    public void print(Node root) {

        if (root == null) {
            System.out.println("(XXXXXX)");
            return;
        }

        int height = root.height,
                width = (int) Math.pow(2, height - 1);

        // Preparing variables for loop.
        List<Node> current = new ArrayList<Node>(1),
                next = new ArrayList<Node>(2);
        current.add(root);

        final int maxHalfLength = 4;
        int elements = 1;

        StringBuilder sb = new StringBuilder(maxHalfLength * width);
        for (int i = 0; i < maxHalfLength * width; i++)
            sb.append(' ');
        String textBuffer;

        // Iterating through height levels.
        for (int i = 0; i < height; i++) {

            sb.setLength(maxHalfLength * ((int) Math.pow(2, height - 1 - i) - 1));

            // Creating spacer space indicator.
            textBuffer = sb.toString();

            // Print tree node elements
            for (Node n : current) {

                System.out.print(textBuffer);

                if (n == null) {

                    System.out.print("        ");
                    next.add(null);
                    next.add(null);

                } else {

                    System.out.printf("(%6d)", n.value);
                    next.add(n.left);
                    next.add(n.right);

                }

                System.out.print(textBuffer);

            }

            System.out.println();
            // Print tree node extensions for next level.
            if (i < height - 1) {

                for (Node n : current) {

                    System.out.print(textBuffer);

                    if (n == null)
                        System.out.print("        ");
                    else
                        System.out.printf("%s      %s",
                                n.left == null ? " " : "/", n.right == null ? " " : "\\");

                    System.out.print(textBuffer);

                }

                System.out.println();

            }

            // Renewing indicators for next run.
            elements *= 2;
            current = next;
            next = new ArrayList<Node>(elements);

        }


    }

    public static void main(String[] args) {
        ArvoreAVL arvore = new ArvoreAVL(); // Supondo que você tenha uma classe ArvoreAVL

        Scanner scanner = new Scanner(System.in);
        int opcao;


        do {
            exibirMenu();

            // Obter a opção do usuário
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    inserirDados(arvore);
                    break;
                case 2:
                    excluirValor(arvore, scanner);
                    break;
                case 3:
                    pesquisarValor(arvore, scanner);
                    break;
                case 4:
                    arvore.caminhamentoPreOrdem();
                    break;
                case 5:
                    System.out.println("Saindo do programa. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            // Pausar a execução para que o usuário possa ver a saída antes de continuar
            System.out.print("Pressione Enter para continuar...");
            scanner.nextLine(); // Limpar o buffer de entrada
            scanner.nextLine(); // Aguardar a entrada do Enter

        } while (opcao != 5);

        scanner.close();
    }

    private static void inserirDados(ArvoreAVL arvore) {
        try {
            Scanner fileScanner = new Scanner(new File("src/dados.txt"));

            while (fileScanner.hasNextInt()) {
                int valor = fileScanner.nextInt();
                arvore.inserir(valor);
            }

            System.out.println("Dados do arquivo inseridos com sucesso!");
            arvore.mostrarArvore();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo dados.txt não encontrado.");
        }
    }

    private void caminhamentoPreOrdem() {
    }

    private static void exibirMenu() {
        System.out.println("Menu:");
        System.out.println("<1> Inserir");
        System.out.println("<2> Excluir");
        System.out.println("<3> Pesquisar");
        System.out.println("<4> Caminhamento em pré-ordem");
        System.out.println("<5> Sair");
    }



    private void inserir(int valor) {
    }

    private static void excluirValor(ArvoreAVL arvore, Scanner scanner) {
        System.out.print("Digite o valor a ser excluído: ");
        int valor = scanner.nextInt();
        boolean excluido = arvore.excluir(valor);

        if (excluido) {
            System.out.println("Valor excluído com sucesso!");
            arvore.mostrarArvore();
        } else {
            System.out.println("Valor não encontrado na árvore.");
        }
    }

    private void mostrarArvore() {

    }

    private boolean excluir(int valor) {
        return false;
    }

    private static void pesquisarValor(ArvoreAVL arvore, Scanner scanner) {
        System.out.print("Digite o valor a ser pesquisado: ");
        int valor = scanner.nextInt();
        boolean encontrado = arvore.pesquisar(valor);

        if (encontrado) {
            System.out.println("Valor encontrado na árvore.");
        } else {
            System.out.println("Valor não encontrado na árvore.");
        }
    }

    private boolean pesquisar(int valor) {
        return false;
    }
}