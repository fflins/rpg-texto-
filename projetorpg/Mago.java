package projetorpg;
import java.util.Scanner;

/**
 * Classe que representa um personagem do tipo Mago.
 * Herda da classe Personagem
 */

public class Mago extends Personagem {
    private int mana;
    Scanner entrada = new Scanner(System.in);
   
    /**
     * Construtor da classe.
     * @param nome O nome do mago.
     * @param atk O valor de ataque do mago.
     * @param hp O valor de pontos de vida do mago.
     * @param hpmax O valor máximo de pontos de vida do mago.
     * @param mana O valor de pontos de mana do mago.
     */

    public Mago(String nome, int atk, int hp, int hpmax, int mana) {
        super(nome, atk, hp, hpmax);
        this.mana = mana;
     
    }

     /**
     * Realiza a ação de ataque do mago contra um monstro.
     * O jogador deve escolher uma magia a ser utilizada
     * @param monstro O monstro alvo do ataque.
     */

    public void atacar(Monstro monstro){
        System.out.println("Escolha a magia a ser usada:");
        System.out.println();
        System.out.println("1 - Fogo (level 1 min)");
        System.out.println("2 - Gelo (level 3 min)");
        System.out.println("3 - Raio (level 5 min)");
        int escolhaMagia = entrada.nextInt();
        switch(escolhaMagia){
            case 1:
                usarFogo(monstro);
                break;
            case 2:
                usarGelo(monstro);
                break;
            case 3:
                usarRaio(monstro);
                break;
            default:
                break;

        }

    }

    /**
     * Usa a magia Fogo caso o mago tenha mana suficiente.
     * @param monstro O monstro alvo da magia.
     */

    public void usarFogo(Monstro monstro) {
        if (this.mana >= 5) {
            this.mana -= 5;
            System.out.printf("%s usou Fogo e causou %d de dano!%n", this.getNome(), this.getAtk()+50);
            monstro.setHp(monstro.getHp()- (this.getAtk()+50));}
            else System.out.println("Mana insuficiente.");
        } 
  
     /**
     * Usa a magia Gelo caso o mago tenha mana e level suficiente.
     * @param monstro O monstro alvo da magia.
     */

    public void usarGelo(Monstro monstro) {
        if (this.level <3){
            System.out.println("Level 3 necessário.");
        }
        else { 
            if(this.mana < 10){ 
                System.out.println("Mana insuficiente.");
            }
            else{ 
                this.mana -= 10;
                System.out.printf("%s usou magia Gelo causando %d de dano!%n", this.getNome(), this.getAtk()+100);
                monstro.setHp(monstro.getHp()-(this.getAtk()+100));
            }
        } 
    }
 
     /**
     * Usa a magia Raio caso o mago tenha mana e level suficiente.
     * @param monstro O monstro alvo da magia.
     */
    public void usarRaio(Monstro monstro) {
        if (this.level <5){
            System.out.println("Level 5 necessário.");
        } else { 

            if(this.mana < 20){
                System.out.println("Mana insuficiente.");
            }

            else{ 
                this.mana -= 20;
                System.out.printf("%s usou magia Raio causando %d de dano!%n", this.getNome(), this.getAtk()+150);
                monstro.setHp(monstro.getHp()-(this.getAtk()+150));
            }
          
        } 
    }

    /**Sobreposição do método ganharXP da classe mãe.
     * O mago desbloqueia novas magias ao subir de level
     * O mago aumenta a quantidade de mana base ao subir de level.
     */

    @Override
    public void ganharXp(int xp) {
        super.ganharXp(xp);
        this.mana+=20;

        if (level == 3) {
            System.out.printf("%s agora pode usar Gelo.%n", this.getNome());
        }

        if (level == 5) {
            System.out.printf("%s agora pode usar Raio.%n", this.getNome());
        }

    }

    /**Sobreposição do método mostrarStatus da classe mãe.
     * O mago também exibe a mana atual.
     */
    @Override
    public void mostrarStatus(){
        System.out.printf("Nome: %s%n", this.getNome());
        System.out.printf("Level: %s%n", this.getLevel());
        System.out.printf("HP Máximo: %d%n", this.getHpMax());
        System.out.printf("HP Atual: %d%n", this.getHp());
        System.out.printf("Atk: %d%n", this.getAtk());
        System.out.printf("Xp: %d%n", this.getXp());
        System.out.printf("Mana:%d%n",this.getMana());
        if (this.getArmaEquipada() != null) System.out.println("Arma equipada: "+ this.armaEquipada.getNome());
        else System.out.printf("Nenhuma arma equipada%n");
        if(this.getArmaduraEquipada()!=null) System.out.println("Armadura equipada: " + this.armaduraEquipada.getNome());
        else System.out.printf("Nenhuma armadura equipada%n%n");
    }

    /**Getters e Setters */
   public void setMana(int mana){
        this.mana=mana;
    }
    @Override
    public int getMana() {
        return this.mana;
    }


}
