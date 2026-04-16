package edu.teamrocket.bicipalma.domain.estacion;


import edu.teamrocket.bicipalma.domain.bicicleta.Movil;
import edu.teamrocket.bicipalma.domain.tarjetausuario.Autenticacion;

public class Estacion {

    private final int id;
    private final String direccion;
    private final Anclajes anclajes;

    public Estacion(int id, String direccion, int numAnclajes) {
        this.id = id;
        this.direccion = direccion;
        this.anclajes = new Anclajes(numAnclajes);
    }

    @Override
    public String toString() {
        return "id: " + id + " \n" +
               "direccion: " + direccion + " \n" +
               "anclajes: " + anclajes.numAnclajes();
    }

    public void consultarEstacion() {
        System.out.println(this);
    }

    public int anclajesLibres() {
        int libres = 0;

        for (Anclaje a : anclajes.anclajes()) {
            if (!a.isOcupado()) {
                libres++;
            }
        }

        return libres;
    }

    public void anclarBicicleta(Movil bici) {
        if (bici == null) return;

        Anclaje[] lista = anclajes.anclajes();

        for (int i = 0; i < lista.length; i++) {
            if (!lista[i].isOcupado()) {
                anclajes.ocuparAnclaje(i, bici);
                System.out.println("bicicleta " + bici.getId() +
                                   " anclada en el anclaje " + (i + 1));
                return;
            }
        }

        System.out.println("No hay anclajes libres.");
    }

    public boolean leerTarjetaUsuario(Autenticacion tarjeta) {
        return tarjeta.isActivada();
    }

    public void retirarBicicleta(Autenticacion tarjeta) {
        if (!leerTarjetaUsuario(tarjeta)) {
            System.out.println("Tarjeta de usuario inactiva :(");
            return;
        }

        // Verificar si hay bicicletas disponibles
        if (anclajesLibres() == anclajes.numAnclajes()) {
            System.out.println("No hay bicicletas disponibles para retirar.");
            return;
        }

        boolean retirada = false;

        while (!retirada) {
            int pos = anclajes.seleccionarAnclaje();

            if (anclajes.isAnclajeOcupado(pos)) {
                Movil bici = anclajes.getBiciAt(pos);
                System.out.println("bicicleta retirada: " + bici.getId() +
                                   " del anclaje: " + (pos + 1));
                anclajes.liberarAnclaje(pos);
                retirada = true;
            }
        }
    }

    public void consultarAnclajes() {
        Anclaje[] lista = anclajes.anclajes();

        for (int i = 0; i < lista.length; i++) {
            int numero = i + 1;

            if (lista[i].isOcupado()) {
                System.out.println("Anclaje " + numero + ": " +
                                   lista[i].getBici().getId());
            } else {
                System.out.println("Anclaje " + numero + ": libre");
            }
        }
    }
}
