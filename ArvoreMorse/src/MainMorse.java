import java.util.Scanner;

public class MainMorse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArvoreBinariaMorse arvore = new ArvoreBinariaMorse();
        arvore.inicializar();

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n     ÁRVORE BINÁRIA - CÓDIGO MORSE");
            System.out.println("1 - Inserir novo caractere");
            System.out.println("2 - Buscar código Morse de um caractere");
            System.out.println("3 - Exibir tabela de código Morse (A → .-)");
            System.out.println("4 - Exibir árvore em estrutura hierárquica");
            System.out.println("5 - Traduzir frase para código Morse");
            System.out.println("6 - Traduzir código Morse para texto");
            System.out.println("7 - Remover caractere da árvore");
            System.out.println("8 - Exibir tabela completa ordenada (A-Z, 0-9)");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1) {
                System.out.print("Digite o caractere a inserir: ");
                char c = sc.nextLine().toUpperCase().charAt(0);
                System.out.print("Digite o código Morse (use . e -): ");
                String morse = sc.nextLine();
                arvore.inserir(c, morse);
                System.out.println("Caractere inserido com sucesso");
            }

            else if (opcao == 2) {
                System.out.print("Digite o caractere a buscar: ");
                char c = sc.nextLine().toUpperCase().charAt(0);
                String codigo = arvore.buscarCodigo(c);
                if (codigo.length() == 0) {
                    System.out.println("Caractere não encontrado na árvore");
                } else {
                    System.out.println("Código Morse: " + codigo);
                }
            }

            else if (opcao == 3) {
                arvore.exibir();
            }

            else if (opcao == 4) {
                arvore.exibirHierarquia();
            }

            else if (opcao == 5) {
                System.out.print("Digite a frase para traduzir: ");
                String frase = sc.nextLine();
                String morse = arvore.traduzirFrase(frase);
                System.out.println("Código Morse: " + morse);
            }

            else if (opcao == 6) {
                System.out.print("Digite o código Morse (use espaço entre letras e 3 espaços entre palavras): ");
                String codigo = sc.nextLine();
                String frase = arvore.traduzirCodigo(codigo);
                System.out.println("Frase traduzida: " + frase);
            }

            else if (opcao == 7) {
                System.out.print("Digite o caractere a remover: ");
                char c = sc.nextLine().toUpperCase().charAt(0);
                arvore.remover(c);
                System.out.println("Caractere removido (nó esvaziado).");
            }

            else if (opcao == 8) {
                System.out.println("\n     CÓDIGOS MORSE ORDENADOS");
                String[] letras = {
                        "A","B","C","D","E","F","G","H","I","J",
                        "K","L","M","N","O","P","Q","R","S","T",
                        "U","V","W","X","Y","Z",
                        "1","2","3","4","5","6","7","8","9","0"
                };
                String[] morse = {
                        ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---",
                        "-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-",
                        "..-","...-", ".--","-..-","-.--","--..",
                        ".----","..---","...--","....-",".....","-....","--...","---..","----.","-----"
                };
                int total = 36; // não usar .length
                for (int i = 0; i < total; i++) {
                    System.out.println(letras[i] + " → " + morse[i]);
                }
            }

            else if (opcao == 0) {
                System.out.println("Encerrando...");
            }

            else {
                System.out.println("Opção inválida");
            }
        }

        sc.close();
    }
}
