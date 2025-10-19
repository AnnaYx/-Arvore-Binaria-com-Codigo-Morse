public class Nodo {
    char caractere;
    Nodo esquerda; // representa ponto (.)
    Nodo direita;  // representa traço (-)

    public Nodo(char caractere) {
        this.caractere = caractere;
        esquerda = null;
        direita = null;
    }
}
