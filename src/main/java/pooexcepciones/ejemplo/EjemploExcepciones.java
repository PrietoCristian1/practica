package pooexcepciones.ejemplo;

import javax.swing.*;

public class EjemploExcepciones {
    public static void main(String[] args) {
        // Las unchecked son: NumberFormatException, ArithmeticException, NullPointerExcepcion
        String valor = JOptionPane.showInputDialog("Ingrese un entero");
        try {
            int divisor = Integer.parseInt(valor);
            int division = 10 / divisor;
            System.out.println(division);
        } catch (NumberFormatException e) {
            System.out.println("Se detecto una excepcion: por favor ingrese un valor numerico: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Capturamos la excepcion en tiempo de ejecucion: " + e.getMessage());
        } finally {
            System.out.println("Es opcional, pero se ejecuta siempre con o sin excepcion");
        }
        System.out.println("Si tratamos la excepcion uncheked, nuestro flujo puede continuar");
    }
}
