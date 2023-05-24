package hashmap.ex03;


public class CD {
    private String titulo;
    private String artistaOuBanda;
    private int qntMusicas;
    private double preco;
    private String comentarios;
    
    public CD(){}
    
    public CD(String titulo, String artistaOuBanda, int qntMusicas, double preco, String comentarios){
        this.titulo = titulo;
        this.artistaOuBanda = artistaOuBanda;
        this.qntMusicas = qntMusicas;
        this.preco = preco;
        this.comentarios = comentarios;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtistaOuBanda() {
        return artistaOuBanda;
    }

    public void setArtistaOuBanda(String artistaOuBanda) {
        this.artistaOuBanda = artistaOuBanda;
    }

    public int getQntMusicas() {
        return qntMusicas;
    }

    public void setQntMusicas(int qntMusicas) {
        this.qntMusicas = qntMusicas;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public String toString() {
        return "titulo: " + titulo + ", artistaOuBanda: " + artistaOuBanda + ", qntMusicas :" + qntMusicas + ", preco:" + preco + ", comentarios:" 
                + comentarios + ';';
    }
    
    
    
}
