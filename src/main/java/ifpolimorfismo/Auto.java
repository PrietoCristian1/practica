package ifpolimorfismo;

import java.time.Year;

public class Auto extends Vehiculo {
    private final int anioFabricacion;

    public Auto(Integer anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    @Override
    public double costo() {
        double costoBase;
        costoBase = 10000.0;
        // Calcular porcentaje adicional basado en el año de fabricacion
        int anioActual = Year.now().getValue();
        double porcentajeAdicional = (anioActual - anioFabricacion) * 0.1;
        costoBase += costoBase * (porcentajeAdicional / 100);
        return costoBase;
    }
}
