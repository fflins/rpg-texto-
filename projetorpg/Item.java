package projetorpg;

/**
 * Classe que representa os itens do jogo.
 */

public class Item {
    protected String nome;

    /**
     * Construtor vazio 
     */
    public Item(){}

    /**
     * Construtor da classe Item.
     * @param nome O nome do item.
     */

    /**
     * Getters e Setters
     */
    public Item(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}