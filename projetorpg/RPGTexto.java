package projetorpg;
import java.util.Scanner;


/**
 * Classe principal para o RPG de texto.
 */

public class RPGTexto {
    /**
     * Variáveis para armazenar a escolha do jogador, além do ouro dos personagens 
     */

    protected static int ouro = 1000;
    protected static int escolhaMenu = 1;
    protected static String escolhaLoja;
    protected static String escolhaItem;
    protected static String escolhaEquip;

    /**
    * Método main para executar o jogo.
    */ 
    public static void main(String[] args){

        /**
         * Escolha do nome e criação dos personagens
         */ 
        Scanner escolhaNome = new Scanner(System.in);
        System.out.printf("Escolha o nome do Guerreiro: ");
        String nome1 = escolhaNome.nextLine();
        Personagem guerreiro = new Guerreiro(nome1, 30,100,100);
        System.out.printf("%nEscolha o nome do Arqueiro: ");
        String nome2 = escolhaNome.nextLine();
        Personagem arqueiro = new Arqueiro(nome2, 35,70,70);
        System.out.printf("%nEscolha o nome do Mago: ");
        String nome3 = escolhaNome.nextLine();
        Personagem mago = new Mago(nome3, 20,80,80, 50);

        /**
         * Criação dos monstros e da lista que será usada para iniciar uma batalha 
         */
        Monstro zumbi = new Monstro("Zumbi",20,170,170);
        Monstro goblin = new Monstro("Goblin",30,150,150);
        Monstro lobo = new Monstro("Lobo",25,120,120);
        Monstro ogro = new Monstro("Ogro",35,200,200);
        Monstro[] monstros = {zumbi, goblin, lobo, ogro};

        /**
         * Criação dos itens do jogo
         */
        Arma espadaPlatina = new Arma("Espada de Platina", 35,0);
        Arma espadaDiamante = new Arma("Espada de Diamante", 100,0);
        Arma arcoSimples = new Arma("Arco Simples", 70,0);
        Arma arcoProfissional = new Arma("Arco Profissional", 100,0);
        Arma cajadoPinheiro = new Arma("Cajado de Pinheiro", 20,40);
        Arma cajadoCristal = new Arma("Cajado de Cristal", 40,80);
        Armadura armaduraPrata = new Armadura("Armadura de Prata",140);
        Armadura armaduraOuro = new Armadura("Armadura de Ouro",250);

        Scanner entradaMenu = new Scanner(System.in);
        Scanner entradaLoja = new Scanner(System.in);
        Scanner entradaItem = new Scanner(System.in);
        Scanner entradaEquip = new Scanner(System.in);

        /**
         * Loop principal que exibirá o menu do jogo 
         */    
        do{
            for (int i = 0; i<3; i++) System.out.printf("%n");
            mostrarMenu();
            escolhaMenu = entradaMenu.nextInt();

            switch(escolhaMenu){
                /**
                 * Inicia uma batalha com um monstro aleatório da lista de monstros 
                 * */
                case 1: 
                    Monstro monstro = monstros[(int) (Math.random() * monstros.length)];
                    monstro.setHp(monstro.getHpMax());
                    Batalha.batalha(guerreiro,arqueiro,mago,monstro);
                    if (monstro.getHp()<0){
                        System.out.println("Você venceu a batalha");
                        System.out.println("Ganhou 50 de ouro e 50 de xp");
                        mago.ganharXp(50);
                        guerreiro.ganharXp(50);
                        arqueiro.ganharXp(50);
                        ouro+=50;
                        break;
                    }
                    else
                    break;

                /**
                 * Exibe a loja e permite o jogador escolher um item a ser comprado 
                 **/
                case 2: 
                    Loja.mostrarloja();
                    escolhaLoja = entradaLoja.nextLine();
                    switch (escolhaLoja) {
                        case "Espada de Platina":
                            System.out.println();
                            Loja.comprarLoja(espadaPlatina);
                            break;
                            
                        case "Espada de Diamante":
                            System.out.println();
                            Loja.comprarLoja(espadaDiamante);
                            break;
                            
                        case "Arco Simples":
                            System.out.println();
                            Loja.comprarLoja(arcoSimples);
                            break;
                          
                        case "Arco Profissional":
                            System.out.println();
                            Loja.comprarLoja(arcoProfissional);
                            break;
                         
                        case "Cajado de Pinheiro":
                            System.out.println();
                            Loja.comprarLoja(cajadoPinheiro);
                            break;
                        
                        case "Cajado de Cristal":
                            System.out.println();
                            Loja.comprarLoja(cajadoCristal);
                            break;
                            
                        case "Armadura de Prata":
                            System.out.println();
                            Loja.comprarLoja(armaduraPrata);
                            break;
                        
                        case "Armadura de Ouro":
                            System.out.println();
                            Loja.comprarLoja(armaduraOuro);
                            break;

                        default:
                            System.out.println();
                            System.out.println("Opção inválida.");
                            break;
                    }
                    break;

                /**Personagens descansam para recuperar seus status ao máximo.  */
                case 3: 
                    System.out.println();
                    guerreiro.setHp(guerreiro.getHpMax());
                    arqueiro.setHp(arqueiro.getHpMax());
                    mago.setHp(mago.getHpMax());
                    System.out.println("Personagens descansaram.");
                    break;


                /**Mostra os status de todos os personagens*/
                case 4:
                    System.out.println();
                    System.out.println("Status da party: ");
                    System.out.println("Ouro: "+ouro);
                    System.out.println();
                    System.out.println("Guerreiro: ");
                    guerreiro.mostrarStatus();
                    System.out.println("Arqueiro: ");
                    arqueiro.mostrarStatus();
                    System.out.println("Mago: ");
                    mago.mostrarStatus();
                    break;


                /**Exibe o inventário e permite ao jogador equipar um item a algum personagem*/        
                case 5: 
                    System.out.println();
                    if(Inventario.exibirItens()) break;
                    else{
                    System.out.println("Escolha um item para equipar");
                    escolhaItem = entradaItem.nextLine();
                    switch(escolhaItem){
                        case "Espada de Platina":
                            System.out.println();
                            espadaPlatina.equipar(guerreiro);
                            break;

                        case "Espada de Diamante":
                            System.out.println();
                            espadaDiamante.equipar(guerreiro);
                            break;

                        case "Arco Simples":
                            System.out.println();
                            arcoSimples.equipar(arqueiro);
                            break;

                        case "Arco Profissional":
                            System.out.println();
                            arcoProfissional.equipar(arqueiro);
                            break;

                        case "Cajado de Pinheiro":
                            System.out.println();
                            cajadoPinheiro.equipar(mago);
                            break;

                        case "Cajado de Cristal":
                            System.out.println();
                            cajadoCristal.equipar(mago);
                            break;

                        case "Armadura de Prata":
                            System.out.println();
                            if (Inventario.contemItem(armaduraPrata)){
                                System.out.println("Escolha quem você quer equipar: ");
                                System.out.println("Guerreiro");
                                System.out.println("Arqueiro");
                                System.out.println("Mago");
                                escolhaEquip = entradaEquip.nextLine();
                                switch(escolhaEquip){
                                    case "Guerreiro":
                                        armaduraPrata.equipar(guerreiro);
                                        System.out.println("Item equipado.");
                                        System.out.println();
                                        break;

                                    case "Arqueiro":
                                        armaduraPrata.equipar(arqueiro);
                                        System.out.println("Item equipado.");
                                        System.out.println();
                                        break;

                                    case "Mago":
                                        armaduraPrata.equipar(mago);
                                        System.out.println("Item equipado.");
                                        System.out.println();
                                        break;

                                    default:
                                        System.out.println();
                                        System.out.println("Opção inválida.");
                                        break;
                                }

                            }
                            else System.out.println("Item não está no inventário.");
                            break;

                        case "Armadura de Ouro":
                            System.out.println();
                            if (Inventario.contemItem(armaduraOuro)){
                                System.out.println("Escolha quem você quer equipar: ");
                                System.out.println("Guerreiro");
                                System.out.println("Arqueiro");
                                System.out.println("Mago");
                                escolhaEquip = entradaEquip.nextLine();
                                switch(escolhaEquip){
                                    case "Guerreiro":
                                        armaduraOuro.equipar(guerreiro);
                                        System.out.println("Item equipado.");
                                        System.out.println();
                                        break;

                                    case "Arqueiro":
                                        armaduraOuro.equipar(arqueiro);
                                        System.out.println("Item equipado.");
                                        System.out.println();
                                        break;

                                    case "Mago":
                                        armaduraOuro.equipar(mago);
                                        System.out.println("Item equipado.");
                                        System.out.println();
                                        break;

                                    default:
                                        System.out.println();
                                        System.out.println("Opção inválida.");
                                        break;
                                }

                            }
                            else System.out.println("Item não está no inventário.");
                            break;

                        /**Encerra o jogo*/        
                        case "0":
                            System.out.println("Fim de jogo.");
                            System.out.println();
                            break;
                        default:
                            System.out.println("Escolha uma opção válida.");
                            System.out.println();
                            break;
                        }
                    }
                default:
                    break;
            }

        } while (escolhaMenu!=0);

    }

    /**Método que exibe o menu na execução do jogo*/
    public static void mostrarMenu(){
            System.out.println("Bem vindo ao RPG!");
            System.out.println("Escolha uma ação:\n");
            System.out.println("1 - Batalha");
            System.out.println("2 - Loja");
            System.out.println("3 - Descansar");
            System.out.println("4 - Status");
            System.out.println("5 - Inventário");
            System.out.println("0 - Sair");
            System.out.println();
    }
}