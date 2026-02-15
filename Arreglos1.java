import java.util.Arrays;
import java.util.Scanner;

class Arreglos1
{
    public static void main(String [] args)
    {
        int numeros[] = {2, 2, 5, 8, 1, 3, 9, 2, 5, 2};

        int inicio = ingresarEntero ("Bienvenido/a! \nLa longitud de la Matriz es "+numeros.length + "\nQue desea hacer? \n 1. Añadir Numero \n 2. Eliminar ultimo numero \n 3. Buscar Numero \n 4. Imprimir Numero \n 5. Buscar Numero mas Repetido \n 6. Buscar Numero perfecto \nIngresar numero para elegir opcion: ");
        switch (inicio)
        {
            case 1:
                int adicion = ingresarEntero("Numero a añadir: ");
                numeros = Arrays.copyOf(numeros, numeros.length + 1); //Apoyado con IA
                numeros[numeros.length - 1] = adicion;
                System.out.println("Se añadio el numero con exito! \nNueva longitud de la matriz: "+numeros.length+"\nNumero añadido: "+adicion );
                break;

            case 2:
                numeros = Arrays.copyOf(numeros, numeros.length - 1); //Apoyado con IA
                System.out.println("Se elimino el numero con exito! \nNueva longitud de la matriz: "+numeros.length);
                break;

            case 3:
                int buscar = ingresarEntero("Ingrese numero buscado: ");
                boolean comp = false;
                for(int i= 0; i<numeros.length;i++)
                {
                    if(numeros[i] == buscar) 
                    {
                        System.out.print("Numero "+buscar+" encontrado en la posición "+i);
                        comp = true;
                    }             
                }
                if(comp == false)
                {
                    System.out.print("Numero no encontrado.");
                }
                break;

            case 4:
                int imprimir = ingresarEntero("Posición del numero a imprimir: ");
                if(imprimir <= numeros.length)
                {
                    System.out.print("El numero en la posicion "+imprimir+" es "+numeros[imprimir]);
                }
                else
                {
                    System.out.print("ERROR: Posicion no valida.");
                }
                break;

            case 5: //Usando de guia un articulo de StackOverflow
                int moda = numeros[0];
                int maxFrecuencia = 1;
        
                for (int i = 0; i < numeros.length; i++) {
                    int frecuenciaActual = 0;
                    for (int j = 0; j < numeros.length; j++) {
                        if (numeros[i] == numeros[j]) {
                            frecuenciaActual++;
                        }
                    }
                    if (frecuenciaActual > maxFrecuencia) {
                        maxFrecuencia = frecuenciaActual;
                        moda = numeros[i];
                    }
                }
                
                System.out.print("El numero mas repetido es: " +moda);
                
                break;

            case 6:
                boolean perfecto = false;
                for(int i = 0; i < numeros.length; i++)
                {
                   for(int j = 1; j < numeros[i]; j++)
                   {
                       if(numeros[i] % j == 0)
                       {
                           int sumaDivisores = 0;
                           sumaDivisores += j;
                           if(sumaDivisores == numeros[i])
                           {
                               perfecto = true;
                           }
                       }
                   }

                }
                if(perfecto == true)
                {
                    System.out.print("Hay numeros perfectos en la matriz.");
                }
                else
                {
                    System.out.print("No hay numeros perfectos en la matriz.");
                }
        }
    }

    public static int ingresarEntero(String mensaje)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.print(mensaje);
            return scanner.nextInt();
        }
}
