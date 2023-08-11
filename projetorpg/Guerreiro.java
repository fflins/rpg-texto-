package projetorpg;
    /**
    * Classe que representa um personagem do tipo guerreiro.
    * Herda da classe Personagem. 
    */
    
public class Guerreiro extends Personagem {
    /**
     * Construtor da classe 
     * @param nome O nome do guerreiro.
     * @param atk O valor do ataque do guerreiro.
     * @param hp Os pontos de vida atual do guerreiro.
     * @param hpmax Os pontos de vida máximo do guerreiro.
     */

    public Guerreiro(String nome, int atk,int hp, int hpmax){
        super(nome, atk, hp, hpmax);
    }

    /**
     * Método de ataque do guerreiro, sobrepondo o método abstrato da classe-mãe .
     * Ataca e reduz os pontos de vida do monstro com base no valor de ataque do guerreiro.
     * @param monstro O monstro a ser atacado.
     */

    @Override
    public void atacar(Monstro monstro){
        System.out.printf("%s atacou e causou %d de dano%n%n",this.getNome(), this.getAtk());
        monstro.setHp(monstro.getHp()- this.getAtk());
    }

}
