package projetorpg;

    /**
    * Classe que representa um personagem do tipo arqueiro.
    * Herda da classe Personagem. 
    */

public class Arqueiro extends Personagem{

    /**
     * Construtor da classe 
     * @param nome O nome do arqueiro.
     * @param atk O valor do ataque do arqueiro.
     * @param hp Os pontos de vida atual do arqueiro.
     * @param hpmax Os pontos de vida máximo do arqueiro.
     */

    public Arqueiro(String nome, int atk, int hp,int hpmax){
        super(nome, atk, hp, hpmax);
    }

    /**
     * Método de ataque do arqueiro, sobrepondo o método abstrato da classe-mãe .
     * Ataca e reduz os pontos de vida do monstro com base no valor de ataque do arqueiro.
     * @param monstro O monstro a ser atacado.
     */

    @Override
    public void atacar(Monstro monstro){
        System.out.printf("%s atacou e causou %d de dano%n%n", this.getNome(), this.getAtk());
        monstro.setHp(monstro.getHp()- this.getAtk());
    }
}