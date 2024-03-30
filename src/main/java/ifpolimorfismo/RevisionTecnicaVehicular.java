package ifpolimorfismo;

import java.time.Year;

public class RevisionTecnicaVehicular {
    public static double calcularCostosRevision(String tipoVehiculo,
                                                int anioFabricacion,
                                                boolean dobleCabina,
                                                int numeroPasajeros) {
        double costoBase = 0;
        switch (tipoVehiculo.toLowerCase()) {
            case "auto":
                costoBase = 10000.0;
                // Calcular porcentaje adicional basado en el año de fabricacion
                int anioActual = Year.now().getValue();
                double porcentajeAdicional = (anioActual - anioFabricacion) * 0.1;
                costoBase += costoBase * (porcentajeAdicional / 100);
                break;
            case "pickup":
                costoBase = 15000.0;
                if (dobleCabina) {
                    costoBase += 2000.0;
                }
                break;
            case "transporte pasajeros":
                // Costo base
                costoBase = 30000.0;
                // Agregar costo adicional por pasajero
                costoBase += numeroPasajeros * 500.0; //Supongamos que se cobran $500 por persona
                break;
            default:
                throw new RuntimeException("Tipo de vehiculo no valido");

        }
        return costoBase;
    }
}
