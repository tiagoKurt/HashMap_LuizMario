package hashmap.ex02;

import hashmap.ex02.Pessoa;
import java.awt.Desktop;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class CadastroDePessoas {

    public static void main(String[] args) {
        HashMap<Pessoa, String> pessoaCadastrada = new HashMap<>();
        Scanner entrada = new Scanner(System.in);
        int rec = 0;
        int opc = 0;

        do {
            System.out.println("Escolha uma opção do menu abaixo");
            System.out.println("1 - Cadastrar uma pessoa");
            System.out.println("2 - Serviços do RH");
            System.out.println("3 - Listar pessoas");
            System.out.println("4 - Sair");
            rec = entrada.nextInt();

            if (rec == 1) {

                String nome = "";
                String cpf = "";
                String dataNascimento;
                double peso = 0;

                System.out.println("Digite o seu nome: ");
                nome = entrada.next();

                System.out.println(nome + ", digite o seu cpf:");
                cpf = entrada.next();

                System.out.println(nome + ", digite sua data de nascimento no formato 'dd-MM-yyyy': ");
                dataNascimento = entrada.next();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate data = LocalDate.parse(dataNascimento, formatter);

                System.out.println(nome + ", digite o seu peso: ");
                peso = entrada.nextDouble();

                Pessoa obejtoPessoa = new Pessoa(cpf, nome, data, peso);
                pessoaCadastrada.put(obejtoPessoa, cpf);
                System.out.println(nome + ", foi cadastrado com sucesso! \n");
            } else if (rec == 3) {

                if (pessoaCadastrada.isEmpty()) {
                    System.out.println("A lista de pessoas está vazia! \n");
                } else {
                    for (HashMap.Entry<Pessoa, String> pessoas : pessoaCadastrada.entrySet()) {

                        System.out.println(pessoas.getKey());
                        System.out.println("\n");
                    }
                }

            } else if (rec == 4) {
                System.out.println("Saiu :)");
                System.exit(0);

            }
            while (rec == 2) {
                char opcaoRH;
                System.out.println("a - Cadastrar pessoas sem CPF repetidos");
                System.out.println("b - Listas pessoas identificadas pelo CPF");
                System.out.println("c - listar o NOME e CPF da pessoa mais idosa e mais jovem");
                System.out.println("d - Listar média de peso das pessoas ");
                System.out.println("e - Atulizar os dados de uma pessoa pelo CPF");
                System.out.println("f - Remvover os dados de uma pessoa pelo CPF");
                System.out.println("v - voltar para cadastro de pessoas");
                opcaoRH = entrada.next().charAt(0);

//                if(opcaoRH != 'a' && opcaoRH != 'A' && opcaoRH != 'b' && opcaoRH != 'B' && opcaoRH != 'c' && opcaoRH != 'C'){
//                    System.out.println("Opção inválida, digite novamente: ");
//                    opcaoRH = entrada.next().charAt(0);
//                }
                if (opcaoRH == 'a' || opcaoRH == 'A') {
                    String nome = "";
                    String cpf = "";
                    String dataNascimento;
                    double peso = 0;

                    System.out.println("Digite o seu nome: ");
                    nome = entrada.next();

                    System.out.println(nome + ", digite o seu CPF:");
                    cpf = entrada.next();
                    for (HashMap.Entry<Pessoa, String> pessoas : pessoaCadastrada.entrySet()) {
                        if (pessoas.getKey().getCPF().contains(cpf) == true) {
                            System.out.println("CPF já cadastrado, tente novamente usando um CPF diferente! \n");
                        } else {

                            System.out.println(nome + ", digite sua data de nascimento no formato 'dd-MM-yyyy': ");
                            dataNascimento = entrada.next();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            LocalDate data = LocalDate.parse(dataNascimento, formatter);

                            System.out.println(nome + ", digite o seu peso: ");
                            peso = entrada.nextDouble();

                            Pessoa obejtoPessoa = new Pessoa(cpf, nome, data, peso);
                            pessoaCadastrada.put(obejtoPessoa, cpf);
                            System.out.println(nome + ", foi cadastrado com sucesso! \n");
                        }
                    }

                } else if (opcaoRH == 'b' || opcaoRH == 'B') {
                    String cpfPessoas = "";

                    System.out.println("Digite o CPF que deseja buscar pessoas ");
                    cpfPessoas = entrada.next();

                    for (HashMap.Entry<Pessoa, String> pessoas : pessoaCadastrada.entrySet()) {
                        if (pessoas.getKey().getCPF().contains(cpfPessoas) == true) {
                            System.out.println(pessoas.getKey());

                        }
                    }
                } else if (opcaoRH == 'c' || opcaoRH == 'C') {
                    int maiorIdade = 0;
                    int MenorIdade = 0;
                    String nomeMaior = "";
                    String nomeMenor = "";
                    String cpfMaior = "";
                    String cpfMenor = "";
                    for (HashMap.Entry<Pessoa, String> pessoas : pessoaCadastrada.entrySet()) {

                        Date dataAtual = new Date();
                        LocalDate nascimento = pessoas.getKey().getDataDeNascimento();

                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                        LocalDate dataAgora = LocalDate.now();

                        String AgoraFormat = dataAgora.format(formatter);
                        String nascimentoFormatada = nascimento.format(formatter);

                        int ano1 = Integer.parseInt(nascimentoFormatada);
                        int ano2 = Integer.parseInt(AgoraFormat);
                        int idadeTotal = ano2 - ano1;

                        int mes1 = Integer.parseInt(nascimentoFormatada);
                        int mes2 = Integer.parseInt(AgoraFormat);

                        int dia1 = Integer.parseInt(nascimentoFormatada);
                        int dia2 = Integer.parseInt(AgoraFormat);

                        if (idadeTotal > maiorIdade || maiorIdade < MenorIdade) {
                            maiorIdade = idadeTotal;
                            nomeMaior = pessoas.getKey().getNome();
                            cpfMaior = pessoas.getKey().getCPF();
                        }
                        if (maiorIdade > MenorIdade || idadeTotal < MenorIdade) {
                            MenorIdade = idadeTotal;
                            nomeMaior = pessoas.getKey().getNome();
                            cpfMaior = pessoas.getKey().getCPF();
                        }

                    }
                    System.out.println("A pessoa mais velha é: " + nomeMaior + ", com CPF: " + cpfMaior + "tem a idade de: " + maiorIdade + " anos");
                    System.out.println("A pessoa mais velha é: " + nomeMenor + ", com CPF: " + cpfMenor + "tem a idade de: " + MenorIdade + " anos");
                } else if (opcaoRH == 'd' || opcaoRH == 'D') {
                    double pesoTotal = 0;
                    for (HashMap.Entry<Pessoa, String> pessoas : pessoaCadastrada.entrySet()) {
                        pesoTotal += pessoas.getKey().getPeso();
                    }
                    double mediaPeso = pesoTotal / pessoaCadastrada.size();

                    System.out.println("A media do peso entre: " + pessoaCadastrada.size() + " pessoas, é igual a: " + mediaPeso + "\n");
                } else if (opcaoRH == 'e' || opcaoRH == 'E') {
                    String nome = "";
                    String cpf = "";
                    String dataNascimento;
                    double peso = 0;
                    String cpfAlterar = "";
                    System.out.println("Digite o CPF que deseja alterar os dados");
                    cpfAlterar = entrada.next();

                    for (HashMap.Entry<Pessoa, String> pessoas : pessoaCadastrada.entrySet()) {
                        if (pessoas.getKey().getCPF().contains(cpfAlterar) == false) {
                            System.out.println("CPF inexistente, não será possivel alterar! \n");
                        } else {
                            System.out.println("CPF: '" + cpfAlterar + "' encontrado!");
                            System.out.println(pessoas.getKey() + "\n");

                            System.out.println("Digite o seu nome: ");
                            nome = entrada.next();

                            System.out.println(nome + ", digite o seu cpf:");
                            cpf = entrada.next();

                            System.out.println(nome + ", digite sua data de nascimento no formato 'dd-MM-yyyy': ");
                            dataNascimento = entrada.next();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                            LocalDate data = LocalDate.parse(dataNascimento, formatter);

                            System.out.println(nome + ", digite o seu peso: ");
                            peso = entrada.nextDouble();

                            Pessoa obejtoPessoa = new Pessoa(cpf, nome, data, peso);
                            pessoaCadastrada.replace(obejtoPessoa, pessoas.getKey().getCPF());
                            System.out.println("O CPF: " + cpf + ", foi alterado com sucesso! \n");
                        }
                    }

                } else if (opcaoRH == 'f' || opcaoRH == 'F') {
                    String cpfDeletar = "";
                    System.out.println("Digite o CPF que deseja deletar os dados");
                    cpfDeletar = entrada.next();
                    
                    
                    for (HashMap.Entry<Pessoa, String> pessoas : pessoaCadastrada.entrySet()) {
                        if (pessoas.getKey().getCPF().contains(cpfDeletar) == false) {
                            System.out.println("CPF inexistente, não será possivel remover! \n");
                        }else{
                             pessoaCadastrada.remove(pessoas.getKey());
                             System.out.println(pessoas.getKey());
                             System.out.println("Os dados do CPF: " + cpfDeletar + ", foi removido com sucesso \n");
                        }
                    }
                    
                    
                } else if (opcaoRH == 'v' || opcaoRH == 'V') {
                    rec = 0;
                }
            }
        } while (opc == 0);
    }
}
