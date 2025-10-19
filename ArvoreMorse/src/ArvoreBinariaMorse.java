public class ArvoreBinariaMorse {
    private Nodo raiz;

    private String[] letras = {
            "A","B","C","D","E","F","G","H","I","J",
            "K","L","M","N","O","P","Q","R","S","T",
            "U","V","W","X","Y","Z",
            "1","2","3","4","5","6","7","8","9","0"
    };

    private String[] morse = {
            ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---",
            "-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-",
            "..-","...-", ".--","-..-","-.--","--..",
            ".----","..---","...--","....-",".....","-....","--...","---..","----.","-----"
    };

    // Inicializa a árvore binária Morse (sem usar length em arrays)
    public void inicializar() {
        raiz = new Nodo(' ');
        int total = 36; // 26 letras + 10 números
        for (int i = 0; i < total; i++) {
            inserir(letras[i].charAt(0), morse[i]);
        }
    }

    public void inserir(char caractere, String codigo) {
        Nodo atual = raiz;
        int tamanho = codigo.length(); // permitido (String)
        for (int i = 0; i < tamanho; i++) {
            char c = codigo.charAt(i);
            if (c == '.') {
                if (atual.esquerda == null) atual.esquerda = new Nodo(' ');
                atual = atual.esquerda;
            } else if (c == '-') {
                if (atual.direita == null) atual.direita = new Nodo(' ');
                atual = atual.direita;
            }
        }
        atual.caractere = caractere;
    }

    public String buscarCodigo(char caractere) {
        return buscarCodigoRec(raiz, caractere, "");
    }

    private String buscarCodigoRec(Nodo atual, char caractere, String codigo) {
        if (atual == null) return "";
        if (atual.caractere == caractere) return codigo;

        String esquerda = buscarCodigoRec(atual.esquerda, caractere, codigo + ".");
        if (esquerda.length() > 0) return esquerda;

        String direita = buscarCodigoRec(atual.direita, caractere, codigo + "-");
        if (direita.length() > 0) return direita;

        return "";
    }

    public void remover(char caractere) {
        removerRec(raiz, caractere);
    }

    private void removerRec(Nodo atual, char caractere) {
        if (atual == null) return;
        if (atual.caractere == caractere) {
            atual.caractere = ' ';
            return;
        }
        removerRec(atual.esquerda, caractere);
        removerRec(atual.direita, caractere);
    }

    public void exibir() {
        System.out.println("\n     TABELA DE CÓDIGO MORSE");
        exibirRec(raiz, "");
    }

    private void exibirRec(Nodo atual, String codigo) {
        if (atual == null) return;
        exibirRec(atual.esquerda, codigo + ".");
        if (atual.caractere != ' ') {
            System.out.println(atual.caractere + " → " + codigo);
        }
        exibirRec(atual.direita, codigo + "-");
    }

    public String traduzirFrase(String frase) {
        String resultado = "";
        int tamanho = frase.length(); // permitido (String)
        for (int i = 0; i < tamanho; i++) {
            char c = frase.charAt(i);
            if (c == ' ') {
                resultado += "   ";
            } else {
                String codigo = buscarCodigo(Character.toUpperCase(c));
                if (codigo.length() > 0) {
                    resultado += codigo + " ";
                }
            }
        }
        return resultado;
    }

    public String traduzirCodigo(String codigo) {
        String resultado = "";
        int tamanho = codigo.length(); // permitido (String)
        int i = 0;
        String atual = "";

        while (i < tamanho) {
            char c = codigo.charAt(i);

            if (c == ' ') {
                int espacos = 1;

                // Conta até 3 espaços consecutivos
                if (i + 1 < tamanho && codigo.charAt(i + 1) == ' ') {
                    espacos++;
                    i++;
                    if (i + 1 < tamanho && codigo.charAt(i + 1) == ' ') {
                        espacos++;
                        i++;
                    }
                }

                // Finaliza a letra atual
                if (atual.length() > 0) {
                    resultado += traduzirSimbolo(atual);
                    atual = "";
                }

                // Se houver 3 espaços ou mais, separa palavras
                if (espacos >= 3) {
                    resultado += " ";
                }
            } else {
                atual += c;
            }
            i++;
        }

        if (atual.length() > 0) {
            resultado += traduzirSimbolo(atual);
        }

        return resultado;
    }

    private char traduzirSimbolo(String codigo) {
        Nodo atual = raiz;
        int tamanho = codigo.length(); // permitido
        for (int i = 0; i < tamanho; i++) {
            char c = codigo.charAt(i);
            if (c == '.') atual = atual.esquerda;
            else if (c == '-') atual = atual.direita;
            if (atual == null) return '?';
        }
        return atual.caractere == ' ' ? '?' : atual.caractere;
    }
    // Exibição hierárquica da árvore binária (estrutura visual)
    public void exibirHierarquia() {
        System.out.println("\n     ESTRUTURA HIERÁRQUICA DA ÁRVORE BINÁRIA");
        exibirHierarquiaRec(raiz, "");
    }

    private void exibirHierarquiaRec(Nodo atual, String prefixo) {
        if (atual == null) return;

        // Mostra o caractere atual (ou espaço se vazio)
        char c = (atual.caractere == ' ') ? '·' : atual.caractere;
        System.out.println(prefixo + c);

        // Recuo visual para esquerda (ponto) e direita (traço)
        exibirHierarquiaRec(atual.esquerda, prefixo + " . ");
        exibirHierarquiaRec(atual.direita, prefixo + " - ");
    }

}
