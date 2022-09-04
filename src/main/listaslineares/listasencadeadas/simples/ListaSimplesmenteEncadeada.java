package listasencadeadas.simples;

public class ListaSimplesmenteEncadeada {

    private Nodo inicio;
    private Nodo fim;
    private int quantidade;

    public ListaSimplesmenteEncadeada() {
        inicio = null;
        fim = null;
        quantidade = 0;
    }

    public void adicionar(int elemento) {
        Nodo novoNodo = new Nodo(elemento);
        if(this.inicio==null) { //lista esta vazia --> insere no inicio
            this.inicio = novoNodo;
            this.fim = novoNodo;
        }
        else { //lista nao esta vazia --> insere no final
            Nodo paux = this.fim;
            this.fim = novoNodo;
            paux.proximo = novoNodo;
        }
        quantidade++;
    }

    public void adicionar(int posicao, int elemento) {
        if ((posicao < 0) || (posicao >= quantidade)) {
            throw new IndexOutOfBoundsException("Não é possível inserir na posição " + posicao);
        }
        Nodo novoNodo = new Nodo(elemento);
        if(posicao==0) { //inserindo no inicio
            novoNodo.proximo = this.inicio;
            this.inicio = novoNodo;
            quantidade++;
        }
        else if (posicao==quantidade-1) { //insere no final
            this.adicionar(elemento);
        }
        else { //insere no meio
            Nodo pant = null;
            Nodo paux = this.inicio;
            for(int i=0;i<posicao;i++) {
                pant = paux;
                paux = paux.proximo;
            }
            pant.proximo = novoNodo; //liga o anterior ao novo Nodo
            novoNodo.proximo = paux;
            quantidade++;
        }
    }

    public void remover(int elemento) {
        // Implementado
        Nodo pant = null;
        Nodo paux = this.inicio;
        for (int i=0; i<quantidade-1; i++){
            pant = paux;
            paux = paux.proximo;
            if (pant.elemento == elemento) {
                this.inicio = pant.proximo;
                break;
            } else if (paux.elemento == elemento) {
                pant.proximo = paux.proximo;
                break;
            }
            pant = pant.proximo;
            paux = paux.proximo;
        }
    }

    public void removerPelaPosicao(int posicao) {
        // Implementado
        int elemento = ler(posicao);
        remover(elemento);
        System.out.println("Removido elemento "+elemento+" na posição "+posicao);
    }

    public int ler(int posicao) {
        Nodo paux = this.inicio;
        int p = 0;
        for(int i=0; i<posicao; i++) {
            paux = paux.proximo;
        }
        return paux.elemento;
    }

    public void escrever(int posicao, int elemento) {
        // Implementado
        Nodo paux = this.inicio;
        int p = 0;
        for(int i=0; i<posicao; i++) {
            paux = paux.proximo;
        }
        paux.elemento = elemento;
        System.out.println("Escrito na posição "+posicao+" o elemento "+elemento);
    }

    public int tamanho() {
        return this.quantidade;
    }

    public boolean estaVazia() {
        return this.quantidade==0;
    }

    public boolean contem(int elemento) {
        return (this.retornarPosicao(elemento)>-1);
    }

    public int retornarPosicao(int elemento) {
        //indexOf metodo
        //retorna a posicao na lista do elemento ou -1 se nao existir
        Nodo paux = this.inicio;
        int posicao = 0;
        if (paux.elemento == elemento) {
            return posicao;
        }
        while (paux.proximo != null) {
            posicao++;
            paux = paux.proximo;
            if (paux.elemento == elemento) {
                return posicao;
            }
        }
        
        return -1;
    }
    @Override
    public String toString() {
        String aux = "[ ";
        Nodo paux = inicio;
        while (paux != null) {
            aux = aux + paux.elemento + " ";
            paux = paux.proximo; // avanca para proximo novo
        }
        aux += "]";
        return aux;
    }


}
