public class Pintura extends Obra {
    private String genero;

    public Pintura(String titulo, String material,
                   String nombre1, int ci1, int anios1,
                   String nombre2, int ci2, int anios2,
                   String genero, Anuncio anuncio) {
        super(titulo, material, nombre1, ci1, anios1,
              nombre2, ci2, anios2, anuncio);
        this.genero = genero;
    }

    public String getGenero() { return genero; }
}