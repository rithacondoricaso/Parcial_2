public class MainA {
    public static void main(String[] args) {
        // a) Una pintura con anuncio y otra sin anuncio.
        Pintura p1 = new Pintura("Mona Lisa", "oleo",
                "Leonardo da Vinci", 123, 20, "Joel", 321, 1,
                "retrato", new Anuncio(1, 1500));

        Pintura p2 = new Pintura("Noche estrellada", "oleo",
                "Vincent van Gogh", 456, 15, "Adrian", 444, 4,
                "postimpresionismo", null);

        System.out.println("a) Pintura 1 tiene anuncio: " + (p1.getAnuncio() != null));
        System.out.println("   Pintura 2 tiene anuncio: " + (p2.getAnuncio() != null));

        // b) Nombre del artista con más años de experiencia.
        Artista[] artistas = {p1.getArt1(), p1.getArt2(), p2.getArt1(), p2.getArt2()};
        Artista mayor = artistas[0];
        for (Artista artista : artistas) {
            if (artista.getAnios() > mayor.getAnios()) {
                mayor = artista;
            }
        }
        System.out.println("b) Artista con mayor experiencia: " +
                mayor.getNombre() + " - " + mayor.getAnios() + " años");

        // c) Agregar anuncio a la pintura sin anuncio y sumar los precios.
        p2.agregarAnuncio(new Anuncio(2, 2300));
        double total = p1.getAnuncio().getPrecio() + p2.getAnuncio().getPrecio();
        System.out.println("c) Anuncio agregado a la pintura 2.");
        System.out.println("   Monto total de venta: " + total);
    }
}