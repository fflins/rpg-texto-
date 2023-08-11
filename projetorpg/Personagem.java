package projetorpg;

/**Classe abstrata que representa os personagens do jogo */

public abstract class Personagem {
     /**Atributos de cada objeto do tipo Personagem:
      * 
        level, armaEquipada e armaduraEquipada são protected pois precisam ser acessados 
        diretamente em outras classes, o resto é private e serão acessados pelos getters
        e setters.
      */
      
    private String nome;                     
    protected int level; 
    private int atk; 
    private int hp; 
    private int hpmax;
    private int xp;
    protected Arma armaEquipada;
    protected Armadura armaduraEquipada;

    /**
     * Construtor da classe Personagem.
     *
     * @param nome   O nome do personagem.
     * @param atk    O valor do atributo de ataque do personagem.
     * @param hp     O valor dos pontos de vida atuais do personagem.
     * @param hpmax  O valor dos pontos de vida máximos do personagem.
     */

    public Personagem(String nome, int atk, int hp, int hpmax) { 
        this.nome=nome;
        this.level = 1;
        this.atk = atk; 
        this.hp = hp;
        this.hpmax = hp;
        this.xp=0;
        armaEquipada = null;
        armaduraEquipada = null;
        }

    /**
     * Método que incrementa a quantidade de experiência do personagem após cada batalha 
     * e verifica se atingiu 100 para subir seu nível, aumentando seus atributos.
     *
     * @param xp A quantidade de experiência ganha.
     */

    public void ganharXp(int xp){   
        this.xp += xp;
        if (this.xp>=100){
            System.out.printf("%s subiu de nível.%n", this.getNome());
            level++;
            this.atk += 5; 
            this.hpmax += 10; 
            this.hp = hpmax; 
            this.xp = 0;
            }
        }

    /**
     * Método que exibe o status atuais do personagem na tela.
     */
    public void mostrarStatus(){
        System.out.printf("Nome: %s%n", this.getNome());
        System.out.printf("Level: %s%n", this.getLevel());
        System.out.printf("HP Máximo: %d%n", this.getHpMax());
        System.out.printf("HP Atual: %d%n", this.getHp());
        System.out.printf("Atk: %d%n", this.getAtk());
        System.out.printf("Xp: %d%n", this.getXp());
        if (this.getArmaEquipada() != null) System.out.println("Arma equipada: "+ this.armaEquipada.getNome());
        else System.out.printf("Nenhuma arma equipada%n");
        if(this.getArmaduraEquipada()!=null) System.out.println("Armadura equipada: " + this.armaduraEquipada.getNome());
        else System.out.printf("Nenhuma armadura equipada%n%n");
    }

    /**
     * Método abstrato para atacar um monstro.
     *
     * @param monstro O monstro a ser atacado.
     * */
    
    public abstract void atacar(Monstro monstro);

    /**Getters e Setters dos atributos */

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHpMax() {
        return hpmax;
    }

    public void setHpmax(int hpmax) {
        this.hpmax = hpmax;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public Arma getArmaEquipada() {
        return armaEquipada;
    }

    public void setArmaEquipada(Arma armaEquipada) {
        this.armaEquipada = armaEquipada;
    }

    public Armadura getArmaduraEquipada() {
        return armaduraEquipada;
    }

    public void setArmaduraEquipada(Armadura armaduraEquipada) {
        this.armaduraEquipada = armaduraEquipada;
    }

    public int getMana(){
        return 0;
    }

 public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

}
  
