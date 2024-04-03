package ifpolimorfismo;

import java.lang.reflect.Constructor;
import java.util.Map;

public class RevisionTecnicaVehicular {
    public static final String AUTO = "auto";
    public static final String PICKUP = "pickup";
    public static final String TRANSPORTE_PASAJEROS = "transporte pasajeros";
    // El Map asocia cadenas de texto (que representan los tipos de vehiculos) con las clases de esos vehiculos.
    // NO almacena instancias de objetos de esas clase, sino las clases mismas
    // Se crea con la finalidad de luego crear diferentes vehiculos de manera dinamica
    public final Map<String, Class<? extends Vehiculo>> vehiculosClazz;

    public RevisionTecnicaVehicular() {
        // El metodo "of" produce un Map inmutable, por lo que no se puede modificar, agregar o eliminar otro elemento
        vehiculosClazz = Map.of(AUTO, Auto.class, PICKUP, PickUp.class, TRANSPORTE_PASAJEROS, TransportePasajeros.class);
    }

    // Se indica que puede lanzar una "ReflectiveOperationException", esta se lanza en tiempo de ejecucion si ocurren
    //errores relacionados con la reflexion.
    public double calcularCostoAuto(int anioFabricacion) throws ReflectiveOperationException {
        //La siguiente linea es la que puede lanzar la excepcion. Esto puede suceder si no encuentra el constructor que
        //coincida con los parametros especificados (´Integer.class´) en el map, o si la clase no tiene acceso a ese constructor,
        // se lanzara una ReflectiveOperationException
        Constructor<? extends Vehiculo> constructor = vehiculosClazz.get(AUTO)
                .getDeclaredConstructor(Integer.class);
        return constructor.newInstance(anioFabricacion).costo();
    }

    public double calcularCostoPickUp(boolean dobleCabina) throws ReflectiveOperationException {
        //Se esta declarando una variable constructor que es de tipo Constructor, pero especificando que el constructor
        // pertenece a alguna subclase de Vehiculo. Luego el metodo get retorna la clase PICKUP y luego con el otro metodo
        // se busca el constructor que coincida con los parametros especificados.
        Constructor<? extends Vehiculo> constructor = vehiculosClazz.get(PICKUP)
                .getDeclaredConstructor(Boolean.class);
        //Luego se utiliza la variable constructor para crear el objeto dinamicamente.
        // Por ultimo, se llaman a los metodos o se manipulan
        return constructor.newInstance(dobleCabina).costo();
    }

    //Throws indica que el metodo puede lanzar una excepcion y delega la responsabilidad de manejarla a los metodos que
    // la llamen
    public double calcularCostoTransporte(int numeroPasajeros) throws ReflectiveOperationException {
        Constructor<? extends Vehiculo> constructor = vehiculosClazz.get(TRANSPORTE_PASAJEROS)
                .getDeclaredConstructor(Integer.class);
        return constructor.newInstance(numeroPasajeros).costo();
    }
}
