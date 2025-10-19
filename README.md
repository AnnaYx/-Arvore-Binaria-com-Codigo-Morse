#  Árvore Binária - Código Morse

 
O objetivo é implementar uma **árvore binária** que representa o **Código Morse**, permitindo inserir, buscar, remover e traduzir caracteres.

---

##  Como funciona

O Código Morse usa:
- **Ponto (.) →** filho **esquerdo** da árvore  
- **Traço (-) →** filho **direito** da árvore  

Cada **nó (Nodo)** representa uma letra (A–Z) ou número (0–9).  
O caminho da **raiz até o nó** forma o código Morse daquela letra.

Exemplo:
```
E → .
T → -
I → ..
M → --
```

---

##  Estrutura do projeto

### Classe `Nodo`
Representa cada nó da árvore:
- `char caractere` → letra ou número armazenado  
- `Nodo esquerda` → representa ponto (.)  
- `Nodo direita` → representa traço (-)

### Classe `ArvoreBinariaMorse`
Contém toda a lógica da árvore binária:
- **inicializar()** → monta a árvore completa com A–Z e 0–9  
- **inserir(char, código)** → adiciona um novo caractere conforme o caminho em Morse  
- **buscarCodigo(char)** → retorna o código Morse de uma letra  
- **remover(char)** → apaga o caractere mantendo a estrutura da árvore  
- **exibir()** → mostra a tabela completa de códigos (letra → morse)  
- **exibirHierarquia()** → mostra visualmente a estrutura da árvore binária  
- **traduzirFrase(String)** → converte texto normal para código Morse  
- **traduzirCodigo(String)** → converte código Morse em texto  

---

##  Classe `MainMorse`

Interface simples via console.  
O menu oferece as opções:

```
1 - Inserir novo caractere
2 - Buscar código Morse de um caractere
3 - Exibir tabela de código Morse (A → .-)
4 - Exibir árvore em estrutura hierárquica
5 - Traduzir frase para código Morse
6 - Traduzir código Morse para texto
7 - Remover caractere da árvore
8 - Exibir tabela completa ordenada (A-Z, 0-9)
0 - Sair
```

---

##  Exemplo de uso

### Traduzindo texto para código Morse:
```
Entrada:  SOS
Saída:    ... --- ...
```

### Traduzindo Morse para texto:
```
Entrada:  ... --- ...
Saída:    SOS
```

### Exibição hierárquica:
Mostra como a árvore binária está estruturada (pontos → esquerda, traços → direita):

```
→ ·
   → E
      → I
         → S
            → H
               → 5
               → 4
         → V
            → 3
      → A
         → R
            → L
         → W
            → P
            → J
               → 1
   → T
      → N
         → D
            → B
               → 6
            → X
         → K
            → C
            → Y
      → M
         → G
            → Z
               → 7
            → Q
         → O
            → 8
            → 9
               → 0
```

---
