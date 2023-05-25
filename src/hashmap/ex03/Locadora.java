package hashmap.ex03;

import java.util.HashMap;
import java.util.Scanner;

public class Locadora {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        HashMap<CD, String> listaDeCD = new HashMap<CD, String>();
        HashMap<DVD, String> listaDeDVD = new HashMap<DVD, String>();

        int opcMenu = 0;
        int loop = 0;
        char opcEscolha;

        do {
            System.out.println("Bem vindo a locadora! selecione uma opção do menu abaixo ;)");
            System.out.println("1 - Adicionar um CD ou DVD");
            System.out.println("2 - Buscar um CD ou DVD pelo TíTULO");
            System.out.println("3 - Buscar um CD pelo nome do artista ou um DVD pelo nome do diretor");
            System.out.println("4 - Listar um CD ou um DVD");
            System.out.println("5 - Sair");
            opcMenu = entrada.nextInt();

            if (opcMenu == 1) {
                int opcAD;
                System.out.println("1 - Adicionar um CD");
                System.out.println("2 - Adicionar um DVD");
                System.out.println("3 - Voltar");
                opcAD = entrada.nextInt();

                if (opcAD == 1) {

                    String titulo = "";
                    String artistaOuBanda;
                    int qntMusicas;
                    double preco;
                    String comentarios;

                    System.out.println("Digite o titulo do CD: ");
                    titulo = entrada.next();

                    System.out.println("Digite o artista ou a banda do CD: ");
                    artistaOuBanda = entrada.next();

                    System.out.println("Digite a quantidade de músicas que o CD possui: ");
                    qntMusicas = entrada.nextInt();
                    System.out.println("Digite o preço desse CD: ");
                    preco = entrada.nextDouble();
                    System.out.println("Quais comentários esse CD possui?");
                    comentarios = entrada.next();

                    CD objetoCD = new CD(titulo, artistaOuBanda, qntMusicas, preco, comentarios);
                    listaDeCD.put(objetoCD, titulo);
                    System.out.println("O CD; " + titulo + ", foi adicionado com sucesso! \n");

                } else if (opcAD == 2) {
                    String titulo;
                    String nomeDiretor;
                    int anoLancamento;
                    String comentarios;
                    System.out.println("Digite o titulo do DVD: ");
                    titulo = entrada.next();
                    System.out.println("Digite o nome do diretor do DVD: ");
                    nomeDiretor = entrada.next();
                    System.out.println("Digite o ano de lançamento desse DVD: ");
                    anoLancamento = entrada.nextInt();
                    System.out.println("Quais comentários esse DVD possui? ");
                    comentarios = entrada.next();
                    DVD objetoDVD = new DVD(titulo, nomeDiretor, anoLancamento, comentarios);
                    listaDeDVD.put(objetoDVD, titulo);
                    System.out.println("O DVD: " + titulo + ", foi adicionado com sucesso! \n");

                } else if (opcAD == 3) {
                    opcMenu = 0;
                    System.out.println("\n");
                }

            } else if (opcMenu == 2) {
                int opc = 0;
                System.out.println("Qual deseja buscar pelo titulo?");
                System.out.println("1 - Buscar um CD");
                System.out.println("2 - Buscar um DVD");
                System.out.println("3 - Voltar");
                opc = entrada.nextInt();
                if (opc == 1) {
                    String tituloCD;
                    System.out.println("Digite o titulo do CD que deseja buscar: ");
                    tituloCD = entrada.next();
                    for (HashMap.Entry<CD, String> cd : listaDeCD.entrySet()) {
                        if (cd.getKey().getTitulo().equals(tituloCD) == true) {
                            System.out.println("O titulo: " + tituloCD + ", foi encontrado! ");
                            System.out.println(cd.getKey() + "\n");
                        } else {
                            System.out.println("O titulo: " + tituloCD + ", não existe na lista de CD's! \n");
                        }
                    }
                } else if (opc == 2) {
                    String tituloDVD;
                    System.out.println("Digite o titulo do DVD que deseja buscar: ");
                    tituloDVD = entrada.next();

                    for (HashMap.Entry<DVD, String> dvd : listaDeDVD.entrySet()) {
                        if (dvd.getKey().getTitulo().contains(tituloDVD) == true) {
                            System.out.println("O titulo: " + tituloDVD + ", foi encontrado! ");
                            System.out.println(dvd.getKey() + "\n");
                        } else {
                            System.out.println("O titulo: " + tituloDVD + ", não existe na lista de DVD's! \n");
                        }
                    }

                } else if (opc == 3) {
                    opcMenu = 0;
                }
            } else if (opcMenu == 3) {
                int opc = 0;
                System.out.println("Escolha uma opção do menu abaixo!");
                System.out.println("1 - Buscar um CD pelo nome do Artista ou pela Banda");
                System.out.println("2 - Buscar um DVD pelo nome do Diretor");
                System.out.println("3 - Voltar");
                opc = entrada.nextInt();

                if (opc == 1) {
                    String artistaOuBanda = "";
                    System.out.println("Digite o artista ou a banda que deseja buscar:");
                    artistaOuBanda = entrada.next();

                    for (HashMap.Entry<CD, String> CDd : listaDeCD.entrySet()) {
                        if (CDd.getKey().getArtistaOuBanda().equals(artistaOuBanda) == true) {
                            System.out.println("O artista ou a banda: " + artistaOuBanda + ", foi encontrado!");
                            System.out.println(CDd.getKey() + "\n");
                        }
                    }
                } else if (opc == 2) {
                    String NomeDiretor = "";
                    System.out.println("Digite o nome do Diretor que deseja buscar:");
                    NomeDiretor = entrada.next();

                    for (HashMap.Entry<DVD, String> DVDD : listaDeDVD.entrySet()) {
                        if (DVDD.getKey().getNomeDiretor().equals(NomeDiretor) == true) {
                            System.out.println("O diretor: " + NomeDiretor + ", foi encontrado!");
                            System.out.println(DVDD.getKey() + "\n");
                        }
                    }
                } else if (opc == 3) {
                    opcMenu = 0;
                    System.out.println("\n");
                }
            } else if (opcMenu == 4) {
                int opc = 0;
                System.out.println("Selecione uma opção abaixo!");
                System.out.println("1 - Listar CD");
                System.out.println("2 - Listar DVD");
                System.out.println("3 - Voltar");
                opc = entrada.nextInt();

                if (opc == 1) {
                    if (listaDeCD.isEmpty()) {
                        System.out.println("A lista de CD's está vazia! \n");
                    } else {
                        for (HashMap.Entry<CD, String> cd : listaDeCD.entrySet()) {
                            System.out.println(cd.getKey() + "\n");
                        }
                    }
                } else if (opc == 2) {
                    if (listaDeDVD.isEmpty()) {
                        System.out.println("A lista de DVD's está vazia! \n");
                    } else {
                        for (HashMap.Entry<DVD, String> dvd : listaDeDVD.entrySet()) {
                            System.out.println(dvd.getKey() + "\n");
                        }
                    }
                } else if (opc == 3) {
                    opcMenu = 0;
                    System.out.println("\n");
                }

            } else if (opcMenu == 5) {
                System.out.println("Saiu :)");
                System.exit(0);
            }

        } while (loop == 0);

    }
}
