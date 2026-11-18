public class MainB {
    public static void main(String[] args) {
        // a) Crear dos pinturas con anuncios de venta.
        Pintura p1 = new Pintura("Mona Lisa", "oleo",
                "Leonardo da Vinci", 123, 20, "Joel", 321, 1,
                "retrato", new Anuncio(1, 1500));

        Pintura p2 = new Pintura("Noche estrellada", "oleo",
                "Vincent van Gogh", 456, 15, "Adrian", 444, 4,
                "postimpresionismo", new Anuncio(2, 2300));

        System.out.println("a) Ambas pinturas tienen anuncio: " +
                (p1.getAnuncio() != null && p2.getAnuncio() != null));

        // b) Promedio de experiencia de los cuatro artistas.
        Artista[] artistas = {p1.getArt1(), p1.getArt2(), p2.getArt1(), p2.getArt2()};
        int suma = 0;
        for (Artista artista : artistas) {
            suma += artista.getAnios();
        }
        double promedio = (double) suma / artistas.length;
        System.out.println("b) Promedio de años de experiencia: " + promedio);

        // c) Incrementar en X el precio de la pintura del artista con nombre X.
        String nombreBuscado = "Adrian";
        double incremento = 500;
        Pintura[] pinturas = {p1, p2};
        boolean encontrada = false;

        for (Pintura pintura : pinturas) {
            if (pintura.getArt1().getNombre().equalsIgnoreCase(nombreBuscado)
                    || pintura.getArt2().getNombre().equalsIgnoreCase(nombreBuscado)) {
                Anuncio anuncio = pintura.getAnuncio();
                anuncio.setPrecio(anuncio.getPrecio() + incremento);
                System.out.println("c) Precio actualizado para la pintura de " +
                        nombreBuscado + ": " + anuncio.getPrecio());
                encontrada = true;
                break;
            }
        }
        if (!encontrada) {
            System.out.println("c) No se encontró una pintura asociada a " + nombreBuscado);
        }
    }
}