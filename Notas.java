import javax.swing.*;


public class Notas 
{
    public static void main(String[] args)
    {
        int cantidadNotas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de notas: "));

        double notas[] = new double[cantidadNotas];


        // Ingreso de notas
        for(int i = 0; i < notas.length; i++)
        {
            notas[i] = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nota "+(i+1)+": "));
        }

        // Calculo de promedio
        double suma = 0;
        for(int i = 0; i < notas.length; i++)   
        {
            suma += notas[i];
        }
        double promedio = suma / notas.length;
        

        // Calculo de nota mayor y menor
        double mayor = notas[0];
        for(int i = 1; i < notas.length; i++)
        {
            if(notas[i] > mayor)
            {
                mayor = notas[i];
            }
        }
        

        double menor = notas[0];
        for(int i = 1; i < notas.length; i++)   
        {
            if(notas[i] < menor)
            {
                menor = notas[i];
            }
        }
        
        // Ordenar el arreglo con metodo burbuja (apoyado con IA y un articulo de StackOverflow)
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



        // Impresion de resumen de las notas
        System.out.println("Resumen de notas: \n Promedio: "+promedio+"\n Nota mayor: "+mayor+"\n Nota menor: "+menor+"\n Notas ordenadas: "+java.util.Arrays.toString(notas));

        // Funcion adicional: Subir la nota mas baja con banco de notas
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
