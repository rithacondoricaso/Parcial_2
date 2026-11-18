class Anuncio:
    def __init__(self, numero=0, precio=0.0):
        self.__numero = numero
        self.__precio = float(precio)

    def getNumero(self):
        return self.__numero

    def getPrecio(self):
        return self.__precio

    def setPrecio(self, precio):
        self.__precio = float(precio)


class Artista:
    def __init__(self, nombre, ci, anios_experiencia):
        self.__nombre = nombre
        self.__ci = ci
        self.__anios_experiencia = int(anios_experiencia)

    def getNombre(self):
        return self.__nombre

    def getCi(self):
        return self.__ci

    def getAnios(self):
        return self.__anios_experiencia


class Obra:
    def __init__(self, titulo, material, nombre1, ci1, anios1,
                 nombre2, ci2, anios2, anuncio=None):
        self._titulo = titulo
        self._material = material
        # La obra contiene dos artistas, según el diagrama del examen.
        self._artista1 = Artista(nombre1, ci1, anios1)
        self._artista2 = Artista(nombre2, ci2, anios2)
        # El anuncio puede no existir; se agrega cuando sea necesario.
        self._anuncio = anuncio

    def agregarAnuncio(self, anuncio):
        self._anuncio = anuncio

    def getAnuncio(self):
        return self._anuncio

    def getArt1(self):
        return self._artista1

    def getArt2(self):
        return self._artista2

    def getArtistas(self):
        return [self._artista1, self._artista2]

    def getTitulo(self):
        return self._titulo


class Pintura(Obra):
    def __init__(self, titulo, material, nombre1, ci1, anios1,
                 nombre2, ci2, anios2, genero, anuncio=None):
        super().__init__(titulo, material, nombre1, ci1, anios1,
                         nombre2, ci2, anios2, anuncio)
        self.__genero = genero


def artistas_de(pinturas):
    artistas = []
    for pintura in pinturas:
        artistas.extend(pintura.getArtistas())
    return artistas


def resolver_version_a():
    print("\\n========== VERSION A ==========")
    anuncio1 = Anuncio(1, 1500)

    pintura1 = Pintura(
        "Mona Lisa", "oleo", "Leonardo da Vinci", 123, 20,
        "Joel", 321, 1, "retrato", anuncio1
    )
    pintura2 = Pintura(
        "Noche estrellada", "oleo", "Vincent van Gogh", 456, 15,
        "Adrian", 444, 4, "postimpresionismo"
    )

    # a) Una pintura con anuncio y otra sin anuncio.
    print("a) Pintura 1 tiene anuncio:", pintura1.getAnuncio() is not None)
    print("   Pintura 2 tiene anuncio:", pintura2.getAnuncio() is not None)

    # b) Artista con más años de experiencia entre ambas pinturas.
    artista_mayor = max(artistas_de([pintura1, pintura2]),
                        key=lambda artista: artista.getAnios())
    print("b) Artista con mayor experiencia:",
          artista_mayor.getNombre(),
          "-", artista_mayor.getAnios(), "años")

    # c) Agregar anuncio a la pintura que no tenía y sumar ambos precios.
    pintura2.agregarAnuncio(Anuncio(2, 2300))
    total = pintura1.getAnuncio().getPrecio() + pintura2.getAnuncio().getPrecio()
    print("c) Anuncio agregado a la pintura 2.")
    print("   Monto total de venta:", total)


def resolver_version_b():
    print("\\n========== VERSION B ==========")
    pintura1 = Pintura(
        "Mona Lisa", "oleo", "Leonardo da Vinci", 123, 20,
        "Joel", 321, 1, "retrato", Anuncio(1, 1500)
    )
    pintura2 = Pintura(
        "Noche estrellada", "oleo", "Vincent van Gogh", 456, 15,
        "Adrian", 444, 4, "postimpresionismo", Anuncio(2, 2300)
    )
    pinturas = [pintura1, pintura2]

    # a) Las dos pinturas se crean con anuncios de venta.
    print("a) Ambas pinturas tienen anuncio:",
          all(p.getAnuncio() is not None for p in pinturas))

    # b) Promedio de experiencia de los cuatro artistas.
    artistas = artistas_de(pinturas)
    promedio = sum(a.getAnios() for a in artistas) / len(artistas)
    print("b) Promedio de años de experiencia:", promedio)

    # c) Incrementar en X el precio de la pintura del artista con nombre X.
    nombre_buscado = "Adrian"
    incremento = 500
    encontrada = False
    for pintura in pinturas:
        if any(a.getNombre().lower() == nombre_buscado.lower()
               for a in pintura.getArtistas()):
            anuncio = pintura.getAnuncio()
            anuncio.setPrecio(anuncio.getPrecio() + incremento)
            encontrada = True
            print("c) Precio actualizado para la pintura de",
                  nombre_buscado, ":", anuncio.getPrecio())
            break
    if not encontrada:
        print("c) No se encontró una pintura asociada a", nombre_buscado)


if __name__ == "__main__":
    # Se muestran las dos variantes del PDF. Ejecuta solo la versión que te
    # corresponda al presentar el parcial.
    resolver_version_a()
    resolver_version_b()
