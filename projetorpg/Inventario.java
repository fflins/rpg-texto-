package projetorpg;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um inventário que armazena itens.
 */

public abstract class Inventario {
    /**
     * Lista que irá armazenar os itens
     * O inventário é o mesmo para todos os personagens, portanto deve ser static.
     */

    private static List<Item> itens = new ArrayList<>();

    /**
     * Adiciona um item ao inventário.
     * @param item O item a ser adicionado.
     */

    public static void adicionarItem(Item item) {
        itens.add(item);
    }

    /**
     * Remove um item ao inventário.
     * @param item O item a ser removido.
     */

    public static void removerItem(Item item) {
        itens.remove(item);
    }

    /**
     * Percorre e exibe os itens do inventário.
     * @return true se o inventário estiver vazio, false se não estiver.
     */

    public static boolean exibirItens() {
        if (itens.isEmpty()) {
            System.out.println("O inventário está vazio.");
            return true;
        }
        else {
            System.out.println("Itens no inventário:");
            for (Item item : itens) System.out.println(item.getNome());
            return false;
            }
    }

    /**Verifica se determinado item está no inventário.    
     * @param item item a ser verificado
     * @return true se o item estiver no inventário, false se não estiver.
     */

    public static boolean contemItem(Item item){
        for (Item i : itens){
            if (i.equals(item)) return true;
        }
        return false;
    }
}