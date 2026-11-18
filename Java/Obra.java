public class Obra {
    protected String titulo;
    protected String material;
    // La obra está compuesta por dos artistas, según el diagrama.
    protected Artista a1;
    protected Artista a2;
    // El anuncio es una agregación: puede ser null y agregarse después.
    protected Anuncio b;

    public Obra(String titulo, String material,
                String nombre1, int ci1, int anios1,
                String nombre2, int ci2, int anios2,
                Anuncio anuncio) {
        this.titulo = titulo;
        this.material = material;
        this.a1 = new Artista(nombre1, ci1, anios1);
        this.a2 = new Artista(nombre2, ci2, anios2);
        this.b = anuncio;
    }

    public void agregarAnuncio(Anuncio anuncio) { this.b = anuncio; }
    public Anuncio getAnuncio() { return b; }
    public Artista getArt1() { return a1; }
    public Artista getArt2() { return a2; }
    public String getTitulo() { return titulo; }
}