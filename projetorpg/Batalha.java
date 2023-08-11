package projetorpg;
import java.util.Scanner;

/**
 * Classe que representa uma batalha entre personagens do jogador e um monstro.
 */

public abstract class Batalha {
    /**Variável que detecta se o jogador deseja fugir */
    private static boolean fugir;


     /**
     * Método que realiza a batalha entre os personagens do jogador e um monstro.
     * A batalha termina quando o hp do monstro ou dos três personagens for 0.
     * Se vencer, os personagens ganharão ouro e pontos de experiência.
     * O jogador pode fugir e encerrar a batalha, mas não ganhará ouro nem pontos de experiência.
     * @param guerreiro O personagem guerreiro.
     * @param arqueiro O personagem arqueiro.
     * @param mago O personagem mago.
     * @param monstro O monstro a ser enfrentado.
     */

    public static void batalha(Personagem guerreiro, Personagem arqueiro, Personagem mago, Monstro monstro ){
        fugir = false;
        while(monstro.getHp()>0){
            statusBatalha(guerreiro,arqueiro,mago,monstro);
            if (guerreiro.getHp()>0){
                açao(guerreiro, monstro);
                if(fugir) return;
                statusBatalha(guerreiro,arqueiro,mago,monstro);
            }
            if (monstro.getHp()<=0) break;
            if(arqueiro.getHp()>0){
                açao(arqueiro,monstro);
                if(fugir) return;
                statusBatalha(guerreiro,arqueiro,mago,monstro);
            }
            if (monstro.getHp()<=0) break;

            if(mago.getHp()>0){
                açao(mago,monstro);
                if(fugir) return;
                }
            if (monstro.getHp()<=0) break;
            if (guerreiro.getHp()<=0 && mago.getHp()<=0 && arqueiro.getHp()<=0){ 
                System.out.println("Você perdeu a batalha.");
                break;
            }
        }
    }

     /**
     * Método que mostra os status do monstro e dos personagens durante a batalha.
     * @param guerreiro O personagem guerreiro.
     * @param arqueiro O personagem arqueiro.
     * @param mago O personagem mago.
     * @param monstro O monstro.
     */

    public static void statusBatalha(Personagem guerreiro, Personagem arqueiro, Personagem mago, Monstro monstro){
        System.out.println();
        if (guerreiro.getHp()<=0) System.out.printf("%s - %d/%d HP%n",guerreiro.getNome(), 0, guerreiro.getHpMax());
        else System.out.printf("%s - %d/%d HP%n",guerreiro.getNome(), guerreiro.getHp(), guerreiro.getHpMax());
        System.out.println();
        if (arqueiro.getHp()<=0) System.out.printf("%s - %d/%d HP%n",arqueiro.getNome(), 0, arqueiro.getHpMax());
        else System.out.printf("%s - %d/%d HP%n",arqueiro.getNome(), arqueiro.getHp(), arqueiro.getHpMax());
        System.out.println();
        if (mago.getHp()<=0) System.out.printf("%s - %d/%d HP %d MP%n",mago.getNome(), 0, mago.getHpMax(),mago.getMana());
        else System.out.printf("%s - %d/%d HP %d MP%n",mago.getNome(), 0, mago.getHpMax(),mago.getMana());
        System.out.println();
        if (monstro.getHp()<=0) System.out.printf("%s - %d/%d HP%n",monstro.getNome(), 0, monstro.getHpMax());
        else System.out.printf("%s - %d/%d HP%n",monstro.getNome(), monstro.getHp(), monstro.getHpMax());
        System.out.println();
    }

     /**
     * Método que realiza a ação do personagem na batalha.
     * O personagem pode atacar, defender ou fugir.
     * Atacar causa dano ao monstro e defender reduz o dano sofrido 
     * @param personagem O personagem que realizará a ação.
     * @param monstro O monstro alvo da ação.
     */


    public static void açao(Personagem personagem, Monstro monstro){
        Scanner entradaAçao = new Scanner(System.in);
        int escolhaAçao;
        System.out.printf("Escolha a ação de %s: %n", personagem.getNome());
        System.out.println();  
        System.out.println("1 - Atacar");       
        System.out.println("2 - Defender"); 
        System.out.println("3 - Fugir"); 
        System.out.println();          
        escolhaAçao = entradaAçao.nextInt();
        switch (escolhaAçao){
            case 1:
                personagem.atacar(monstro);
                System.out.printf("%s atacou e causou %d de dano.%n",monstro.getNome(), monstro.getAtk());
                personagem.setHp(personagem.getHp() - monstro.getAtk());
            break;
            case 2:
                System.out.printf("%s defendeu e irá tomar 50%% a menos de dano.%n", personagem.getNome());
                System.out.printf("O monstro atacou e causou %d de dano.%n",monstro.getAtk()/2 );
                personagem.setHp(personagem.getHp() - monstro.getAtk()/2); 
            break;
            case 3: 
                System.out.println("O grupo fugiu da batalha.");
                fugir = true;
                return;
            default:
            break;    
        }
    }              
           
}
