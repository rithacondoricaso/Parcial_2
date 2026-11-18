public class Artista {
    private String nombre;
    private int ci;
    private int aniosExperiencia;

    public Artista(String nombre, int ci, int aniosExperiencia) {
        this.nombre = nombre;
        this.ci = ci;
        this.aniosExperiencia = aniosExperiencia;
    }

    public String getNombre() { return nombre; }
    public int getCi() { return ci; }
    public int getAnios() { return aniosExperiencia; }
}