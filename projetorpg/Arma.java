package projetorpg;

/**
 * Classe que representa um item do tipo arma.
 * Herda da classe Item e implementa a interface Equipavel.
 */

public class Arma extends Item implements Equipavel {
    /**
     * Variáveis que representam os bônus ganhos ao equipar a arma.
     */
    private int bonusAtk;
    private int mana;

   /**
     * Construtor da classe.
     * @param nome nome da arma.
     * @param bonusAtk O bônus de ataque fornecido pela arma.
     * @param mana O bônus de mana fornecido pela arma
     */

    public Arma(String nome, int bonusAtk, int mana) {
        super(nome);
        this.bonusAtk = bonusAtk;
        this.mana=mana;
    }

    /**
     * Método para equipar a arma, caso ela esteja no inventário.
     * @param personagem O personagem que irá equipar a arma.
     */

    public void equipar(Personagem personagem) {
        if (Inventario.contemItem(this)){
            personagem.setArmaEquipada(this);
            personagem.setAtk(personagem.getAtk() + bonusAtk);
            System.out.printf("%s equipado.%n", this.getNome());
            System.out.println();
        }
        else System.out.printf("%s não está no inventário.%n", this.getNome());
    }

    /**
     * Método para desequipar a arma, fazendo o personagem perder os bônus.
     * @param personagem O personagem que irá desequipar a arma.
     */

    public void desequipar(Personagem personagem){
        personagem.setAtk(personagem.getAtk() - bonusAtk);
        personagem.setArmaEquipada(null);
        System.out.printf("%s desequipado%n", this.getNome());
    }

    /**Getters e setters */
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getBonusAtk() {
        return bonusAtk;
    }
    public void setBonusAtk(int bonusAtk) {
        this.bonusAtk = bonusAtk;
    }
    public int getMana() {
        return mana;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }
}
 