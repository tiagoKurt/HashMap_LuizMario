package hashmap.ex03;

import java.util.Scanner;

public class Locadora {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int opcMenu = 0;
        char opcEscolha;

        do {
            System.out.println("Bem vindo a locadora! selecione uma opção do menu abaixo ;)");
            System.out.println("1 - Adicionar um CD ou DVD");
            System.out.println("2 - Buscar um CD ou DVD pelo TíTULO");
            System.out.println("3 - Buscar um CD pelo nome do artista ou um DVD pelo nome do diretor");
            System.out.println("4 = Listar um CD ou um DVD");
            System.out.println("5 - Sair");
            opcMenu = entrada.nextInt();

            if (opcMenu == 1) {
                int opcAD;
                System.out.println("1 - Adicionar um CD");
                System.out.println("2 - Adicionar um DVD");
                System.out.println("3 - Voltar");
                opcAD = entrada.nextInt();
                
                if (opcAD == 1) {

                } else if (opcAD == 2) {

                }else if(opcAD ==3){
                    opcMenu =0;
                    System.out.println("\n");
                }
                
            } else if (opcMenu == 5) {
                System.out.println("Saiu :)");
                System.exit(0);
            }

        } while (opcMenu == 0);

    }
}
