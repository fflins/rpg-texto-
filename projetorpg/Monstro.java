package projetorpg;

/**
 * Classe que representa um monstro no rpg.
 */

public class Monstro {
    private String nome;
    private int atk;
    private int hp;
    private int hpmax;

    /**
     * Construtor da classe
     * @param nome O nome do monstro.
     * @param atk Os pontos de ataque do monstro.
     * @param hp Os pontos de vida do monstro.
     * @param hpmax Os pontos de vida máximos do monstro.
     */

    public Monstro(String nome,int atk, int hp, int hpmax){
        this.nome=nome;
        this.atk = atk;
        this.hp = hp;
        this.hpmax = hpmax;
    }


    /**Getters e Setters */
     public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
     public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtk() {
        return atk;
    }
    public void setAtk(int atk) {
        this.atk = atk;
    }

     public int getHpMax() {
        return hpmax;
    }

    public void setHpMax(int hpmax) {
        this.hpmax = hpmax;
    }

}
