package app;

/**
 * Represents a piece of content with a title and an image URL.
 */
public class Conteudo {

    /**
     * The title of the content.
     */
    private String titulo;

    /**
     * The URL of the image associated with the content.
     */
    private String urlImagem;

    /**
     * Constructs a new Conteudo object with the given title and image URL.
     *
     * @param titulo the title of the content
     * @param urlImagem the URL of the image associated with the content
     * @throws NullPointerException if either argument is null
     * @throws IllegalArgumentException if the title or the URL is empty
     */
    public Conteudo(String titulo, String urlImagem) {
        if (titulo == null || urlImagem == null) {
            throw new NullPointerException("Both title and image URL must be non-null.");
        }
        if (titulo.isEmpty() || urlImagem.isEmpty()) {
            throw new IllegalArgumentException("Both title and image URL must be non-empty.");
        }
        this.titulo = titulo;
        this.urlImagem = urlImagem;
    }

    /**
     * Returns the title of the content.
     *
     * @return the title of the content
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Returns the URL of the image associated with the content.
     *
     * @return the URL of the image associated with the content
     */
    public String getUrlImagem() {
        return urlImagem;
    }

    /**
     * Returns a string representation of the Conteudo object.
     *
     * @return a string representation of the Conteudo object
     */
    @Override
    public String toString() {
        return "Conteudo{" +
                "titulo='" + titulo + '\'' +
                ", urlImagem='" + urlImagem + '\'' +
               
