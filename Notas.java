import javax.swing.*;


public class Notas 
{
    public static void main(String[] args)
    {
        int cantidadNotas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de notas: "));

        double notas[] = new double[cantidadNotas];

         ingresoNotas(notas);
         double promedio = calculoPromedio(notas);
         double mayor = calculoMayor(notas);
         double menor = calculoMenor(notas);
         ordenamientoBurbuja(notas);
         resumenNotas(promedio, mayor, menor, notas);
         bancoDeNotas(menor);
    }

    public static double ingresoNotas(double[] notas)
    {
        for(int i = 0; i < notas.length; i++)
        {
            notas[i] = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nota "+(i+1)+": "));
        }
        return 0;
    }

    public static double calculoPromedio(double[] notas)
    {
        double suma = 0;
        for(int i = 0; i < notas.length; i++)   
        {
            suma += notas[i];
        }
        double notaFinal = suma / notas.length;
        return notaFinal;
    }

    public static double calculoMayor(double[] notas)
    {
        double mayor = notas[0];
        for(int i = 1; i < notas.length; i++)
        {
            if(notas[i] > mayor)
            {
                mayor = notas[i];
            }
        }
        return mayor;
    }

    public static double calculoMenor(double[] notas)
    {
        double menor = notas[0];
        for(int i = 1; i < notas.length; i++)
        {
            if(notas[i] < menor)
            {
                menor = notas[i];
            }
        }
        return menor;
    }

    public static void ordenamientoBurbuja(double[] notas)
    {
        /**
         * En este método se implementa el algoritmo de ordenamiento burbuja para ordenar las notas de menor a mayor. 
         * El algoritmo compara cada par de elementos adyacentes y los intercambia si están en el orden incorrecto. 
         * Este proceso se repite hasta que la lista esté completamente ordenada.
         */
        
        for(int i = 0; i < notas.length - 1; i++)
        {
            for(int j = 0; j < notas.length - i - 1; j++)
            {
                if(notas[j] > notas[j + 1])
                {
                    double temp = notas[j];
                    notas[j] = notas[j + 1];
                    notas[j + 1] = temp;
                }
            }
        }
    }

    public static void resumenNotas(double promedio, double mayor, double menor, double[] notas)
    {
        System.out.println("Resumen de notas: \n Promedio: "+promedio+"\n Nota mayor: "
        +mayor+"\n Nota menor: "+menor+"\n Notas ordenadas: "+java.util.Arrays.toString(notas));
    }

    public static void bancoDeNotas(double menor)
    {
        /**
         * En este método se le pregunta al usuario si el estudiante tiene puntos acumulados en el banco de notas. 
         * Si la respuesta es afirmativa, se le solicita ingresar los puntos acumulados. 
         * Luego, se verifica si al sumar esos puntos a la nota más baja (menor) se supera la nota máxima permitida (5.0). 
         * Si es así, se ajusta la nota más baja al valor máximo; de lo contrario, se suma directamente los puntos al menor. 
         * Finalmente, se muestra la nueva nota más baja después de aplicar los puntos del banco de notas.
         */

        double notaMaxima = 5.0; 
        char respuesta = JOptionPane.showInputDialog("¿El estudiante tiene puntos acumulados en el banco de notas? (S/N)").charAt(0);
        if(respuesta == 'S' || respuesta == 's')
        {
            double puntosBanco = Double.parseDouble(JOptionPane.showInputDialog("Ingrese los puntos acumulados en el banco de notas: "));
            if(puntosBanco > 0)
            {
              if(menor + puntosBanco > notaMaxima)
              {
                menor = notaMaxima;
              }
              else
              {
                menor += puntosBanco;
              }
                System.out.println("La nota más baja ha sido subida a: "+menor);
            }
            else
            {
                System.out.println("Puntos del banco de notas no válidos.");
            }
        }
        else
        {
            System.out.println("No se han utilizado puntos del banco de notas.");
        }
    }
}
