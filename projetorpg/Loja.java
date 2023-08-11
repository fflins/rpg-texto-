package projetorpg;

/**
 * Classe que representa uma loja no jogo onde os personagens podem comprar itens.
 */

public abstract class Loja {

     /**
     * Exibe os itens disponíveis na loja com seus respectivos preços
     * e o ouro atual dos personagens.
     */

    public static void mostrarloja(){
        System.out.println("Bem vindo à loja, escolha o que deseja comprar: ");
        System.out.println();
        System.out.println("Espada de Platina - 30 de ouro");
        System.out.println("Espada de Diamante - 60 de ouro");
        System.out.println("Arco Simples - 35 de ouro");
        System.out.println("Arco Profissional - 70 de ouro");
        System.out.println("Cajado de Pinheiro - 40 de ouro");
        System.out.println("Cajado de Cristal - 80 de ouro");
        System.out.println("Armadura de Prata - 50 de ouro");
        System.out.println("Armadura de Ouro - 100 de ouro");
        System.out.printf("Ouro atual: %d%n", RPGTexto.ouro);
        System.out.println();
    }

    /**
     * Caso tenha ouro suficiente, realiza a compra de um item da loja de acordo com a escolha do jogador
     * Adiciona o item ao inventário e desconta do ouro total  
     * @param item O item a ser comprado.
     */

    public static void comprarLoja(Item item){      
                    switch (item.getNome()) {
                        case "Espada de Platina":
                        System.out.println();
                            if (RPGTexto.ouro >= 30) {
                                Inventario.adicionarItem(item);
                                RPGTexto.ouro -= 30;
                                System.out.println("Espada de Platina comprada.");
                                break;
                            } else {
                                System.out.println("Ouro insuficiente");
                                break;
                            }

                        case "Espada de Diamante":
                            System.out.println();
                            if (RPGTexto.ouro >= 60) {
                                Inventario.adicionarItem(item);
                                RPGTexto.ouro -= 60;
                                System.out.println("Espada de Diamante comprada.");
                                break;
                            } else {
                                System.out.println("Ouro insuficiente.");
                                break;
                            }
                            
                        case "Arco Simples":
                            System.out.println();
                            if (RPGTexto.ouro >= 35) {
                                Inventario.adicionarItem(item);
                                RPGTexto.ouro -= 35;
                                System.out.println("Arco Simples comprado.");
                                break;
                            } else {
                                System.out.println("Ouro insuficiente.");
                                break;
                            }
                          
                        case "Arco Profissional":
                            System.out.println();
                            if (RPGTexto.ouro >= 70) {
                                Inventario.adicionarItem(item);
                                RPGTexto.ouro -= 70;
                                System.out.println("Arco Profissional comprado.");
                                break;
                            } else {
                                System.out.println("Ouro insuficiente.");
                                break;
                            }
                         
                        case "Cajado de Pinheiro":
                            System.out.println();
                            if (RPGTexto.ouro >= 40) {
                                Inventario.adicionarItem(item);
                                RPGTexto.ouro -= 40;
                                System.out.println("Cajado de Pinheiro comprado.");
                                break;
                            } else {
                                System.out.println("Ouro insuficiente.");
                                break;
                            }
                        
                        case "Cajado de Cristal":
                            System.out.println();
                            if (RPGTexto.ouro >= 80) {
                                Inventario.adicionarItem(item);
                                RPGTexto.ouro -= 80;
                                System.out.println("Cajado de Cristal comprado.");
                                break;
                            } else {
                                System.out.println("Ouro insuficiente.");
                                break;
                            }
                            
                        case "Armadura de Prata":
                            System.out.println();
                            if (RPGTexto.ouro >= 50) {
                                Inventario.adicionarItem(item);
                                RPGTexto.ouro -= 50;
                                System.out.println("Armadura de Prata comprada.");
                                break;
                            } else {
                                System.out.println("Ouro insuficiente.");
                                break;
                            }
                        
                        case "Armadura de Ouro":
                            System.out.println();
                            if (RPGTexto.ouro >= 100) {
                                Inventario.adicionarItem(item);
                                RPGTexto.ouro -= 100;
                                System.out.println("Armadura de Ouro comprada.");
                                break;
                            } else {
                                System.out.println("Ouro insuficiente.");
                                break;
                            }
                        default:
                            System.out.println();
                            System.out.println("Opção inválida.");
                            break;
                    }
    }

}
