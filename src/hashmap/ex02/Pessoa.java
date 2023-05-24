package hashmap.ex02;

import java.time.LocalDate;
import java.util.Date;


public class Pessoa {
    private String CPF;
    private String nome;
    private LocalDate dataDeNascimento;
    private double peso;
    
    public Pessoa(){}

    public Pessoa(String CPF, String nome, LocalDate dataDeNascimento, double peso){
        this.CPF = CPF;
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.peso = peso;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "CPF:" +CPF + ", Nome: " + nome + ", Data de nascimento: " + dataDeNascimento + ", Peso: " + peso + "kg";
    }
    
}
