package projetorpg;

 /**
 * Classe que representa um item do tipo armadura.
 * Herda da classe Item e implementa a interface Equipavel.
 */

public class Armadura extends Item implements Equipavel {
    private int bonusHpMax;

    /**
     * Construtor da classe.
     * @param nome nome da armadura.
     * @param bonusHPMax O bônus de vida máxima fornecido pela armadura.
     */

    public Armadura(String nome, int bonusHpMax) {
        super(nome);
        this.bonusHpMax = bonusHpMax;
    }

    /**
     * Método para equipar a armadura, caso ela esteja no inventário.
     * @param personagem O personagem que irá equipar a armadura.
     */

    public void equipar(Personagem personagem) {
       if (Inventario.contemItem(this)){
            personagem.setArmaduraEquipada(this);
            personagem.setAtk(personagem.getHpMax() + bonusHpMax);
            System.out.printf("%s equipado.%n", this.getNome());
            System.out.println();
        }
        else System.out.printf("%s não está no inventário.%n", this.getNome());
    }
    
/**
     * Método para desequipar a armadura, fazendo o personagem perder os bônus.
     * @param personagem O personagem que irá desequipar a arma.
     */

    public void desequipar(Personagem personagem){
        personagem.setHpmax(personagem.getHpMax() - bonusHpMax);
        personagem.setArmaduraEquipada(null);
        System.out.printf("%s desequipado%n", this.getNome());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getBonusHpMax() {
        return bonusHpMax;
    }

    public void setBonusHpMax(int bonusHpMax) {
        this.bonusHpMax = bonusHpMax;
    }
}

