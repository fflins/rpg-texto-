package projetorpg;

/**
 * Interface que define métodos dos itens que podem ser equipados por um personagem.
 * Arma e armadura implementarão a interface pois tem um comportamento igual
 * embora sejam itens diferentes. */

public interface Equipavel {
    /**
     * Equipa o objeto.
     * @param personagem O personagem que irá equipar o objeto.
     */
    void equipar(Personagem personagem);

    /**
     * Desequipa o objeto.
     * @param personagem O personagem que irá desequipar o objeto.
     */
    void desequipar(Personagem personagem);

}