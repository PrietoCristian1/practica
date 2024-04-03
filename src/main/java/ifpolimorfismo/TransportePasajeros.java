package ifpolimorfismo;

public class TransportePasajeros extends Vehiculo {
    private final int numeroDePasajeros;

    public TransportePasajeros(Integer numeroDePasajeros) {
        this.numeroDePasajeros = numeroDePasajeros;
    }

    @Override
    public double costo() {
        double costoBase;
        //Costo
        costoBase = 30000.0;
        // Agregar costo adicional por pasajero
        costoBase += this.numeroDePasajeros * 500.0; // Supongamos que se cobran $500 por persona
        return costoBase;
    }
}
