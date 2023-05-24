package hashmap.ex03;


public class DVD {
    private String titulo;
    private String nomeDiretor;
    private int anoLancamento;
    private String comentarios;
    
    public DVD(){}
    
    public DVD(String titulo, String nomeDiretor, int anoLancamento, String comentarios){
        this.titulo = titulo;
        this.nomeDiretor = nomeDiretor;
        this.anoLancamento = anoLancamento;
        this.comentarios = comentarios;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNomeDiretor() {
        return nomeDiretor;
    }

    public void setNomeDiretor(String nomeDiretor) {
        this.nomeDiretor = nomeDiretor;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public String toString() {
        return "titulo: " + titulo + ", nomeDiretor: " + nomeDiretor + ", anoLancamento: " + anoLancamento + ", comentarios: " + comentarios + ";";
    }
    
    
}
