/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.pruebatecnicamontagas;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Prueba técnica para aplicar por el cargo de desarrollador Java en Montagas.
 * @author Jhorlen Andrés Rodríguez Bastidas.
 * Fecha: 7 de junio del 2022.
 */
public class PruebaTecnicaMontagas {
    /**
     * Método que permite calcular el resultado de un algoritmo del arreglo que viene por parámetro y 
     * por la cantidad de permutaciones que vienen por parámetro
     * @param pArrayEnteros Array de enteros entre 0 y 1 de cualquier tamaño.
     * @param pCantPermutaciones Cantidad de permutaciones a calcular.
     * @return Retorna el cálculo del algoritmo según el número de permutaciones digitadas. 
     */
    public static ArrayList<Integer> calcularResultadoPermutacion( ArrayList<Integer> pArrayEnteros, int pCantPermutaciones){
        // ArrayList que almacenará el resultado del algoritmo, este crea una copia del ArrayList que viene por parámetro.
        ArrayList<Integer> respuesta = new ArrayList(pArrayEnteros);
        // Ciclo que permitirá recorrer por el número de permutaciones que vienen por parámetro.
        for(int i = 0; i < pCantPermutaciones; i++){
            // Ciclo para recorrer ArrayList de enteros que viene por parámetro.
            for(int j = 0; j < pArrayEnteros.size(); j++){
                // Condicional que permite calcular el primer digito del arreglo, ya que por ser la primera posición, 
                // este no tiene un elemento anterior para comparar sus valores.
                if( j == 0 ) {
                    // Si la posición siguiente del primer valor del ArrayList que viene por parámetro es igual a 0 se agrega un numero 0
                    // ya que se asimila que el elemento anterior a la inicial es 0.
                    if( pArrayEnteros.get(j+1) == 0 ) {
                        respuesta.set(j,0); 
                    }
                    // Si no es un 0 se añade un 1 porque se asume que la posición anterior a la inicial es un 0.
                    else 
                        respuesta.set(j,1);
                }
                // Con el fin de tener un control con la posición final se asume que la posición anterior a la final es la última.
                else if( j == pArrayEnteros.size()-1 ) {
                    // Si la posición anterior a la última es igual a 0 se añade un 0 al arreglo de la respuesta.
                    if( pArrayEnteros.get(j-1) == 0 ) {
                        respuesta.set(j,0);
                    }
                    // Si no es un 0 se añade un 1 porque el número siguiente al último se asume que es un 0.
                    else
                        respuesta.set(j,1);
                }
                // Si no es la posición inicial o final se compara el elemento anterior a j y el elemento siguiente a j, 
                // si estos valores son iguales se añade un 0, de lo contrario se añade un 1 al ArrayList de respuesta. 
                else{
                    if(pArrayEnteros.get(j-1) == pArrayEnteros.get(j+1)) {
                        respuesta.set(j,0);
                    }
                    else{
                        respuesta.set(j,1);
                    }
                }
            }
            // Finalmente, después de cada permutación se hace una copia de la respuesta al parámetro, esto con el fin de ir almacenando 
            // cada permutación y no se altere el ArrayList del parámetro inicial.
            pArrayEnteros = new ArrayList<Integer>(respuesta);
        }
        return respuesta;
    }
    
    public static void main(String[] args) {
        
        // Código para probar el método anterior.
        ArrayList<Integer> arreglo = new ArrayList<Integer>(Arrays.asList(0,0,0,1,1,1,1,0,1,0));
        String miResultado = "";
        for (Integer integer : calcularResultadoPermutacion(arreglo, 2)){
            miResultado += " "+integer;
        }
        System.out.print("El resultado es: "+miResultado);
    }
}
