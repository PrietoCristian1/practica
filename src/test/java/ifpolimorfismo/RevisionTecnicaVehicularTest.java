package ifpolimorfismo;

import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;

public class RevisionTecnicaVehicularTest {
    @Test
    public void costoDeRevisionAuto() {
        var costo = new Auto(2015).costo();
        assertEquals(10090, costo, 0.0);
    }

    @Test
    public void costoDeRevisionPickUp() {
        var costo = new PickUp(true).costo();
        assertEquals(17000, costo, 0.0);
    }

    @Test
    public void costoDeRevisionTransporte() {
        var costo = new TransportePasajeros(55).costo();
        assertEquals(57500, costo, 0.0);
    }

    @Test
    public void costoRevisionAutoViaApi() throws ReflectiveOperationException {
        var costo = new RevisionTecnicaVehicular().calcularCostoAuto(2015);
        assertEquals(10090, costo, 0.0);
    }

    @Test
    public void costoRevisionPickupViaApi() throws ReflectiveOperationException {
        var costo = new RevisionTecnicaVehicular().calcularCostoPickUp(true);
        assertEquals(17000, costo, 0.0);
    }

    @Test
    public void costoRevisionTransporteViaApi() throws ReflectiveOperationException {
        var costo = new RevisionTecnicaVehicular().calcularCostoTransporte(55);
        assertEquals(57500, costo, 0.0);
    }
}
