
package MaxMean;

import java.io.*;
import java.util.ArrayList;

/**
 * @author Jorge Alonso Hernandez
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 19/04/2016
 * Asignatura: Diseño y Analisis de Algoritmos
 * Comentario: Clase con la matriz de costes que conforma el problema
 */
public class Problema {
    
    private double[][] matrizCostes;        // Matriz con los costes de las aristas entre las ciudades
    private int nNodos;                     // Numero de ciudades del prolema
    
    public Problema(String fichero) throws FileNotFoundException, IOException{
    
        BufferedReader reader = new BufferedReader(new FileReader(fichero));
        String linea = reader.readLine();
        nNodos = Integer.parseInt(linea);
        matrizCostes = new double[nNodos][nNodos];
        double valor;
        
        for(int i = 0; i < nNodos; i++){
            for(int j = 0; j < nNodos; j++){
                if(i != j && matrizCostes[i][j] == 0.0 && (linea = reader.readLine()) != null){
                    String[] token = linea.split("\\s");
                    valor = Double.parseDouble(token[0]);
                    matrizCostes[j][i] = valor;
                    matrizCostes[i][j] = valor;
                }
            }
        }
    }
    
    /**
     * Metodo que muestra la matriz de costes
     */
    public void mostrarCostes(){
        for(int i = 0; i < getnNodos(); i++){
            for(int j = 0; j < getnNodos(); j++){
                System.out.print(getElemento(i, j) + " ");
            }
            System.out.println();
        }
    }
    
    public double[][] getMatrizCostes() {
        return matrizCostes;
    }

    public void setMatrizCostes(double[][] matrizCostes) {
        this.matrizCostes = matrizCostes;
    }
    
    public int getnNodos() {
        return nNodos;
    }

    public void setnNodos(int nNodos) {
        this.nNodos = nNodos;
    }
    
    public double getElemento(int i, int j){
        return matrizCostes[i][j];
    }
    
    public void setElemento(int i, int j, double elem){
        matrizCostes[i][j] = elem;
    }
    
}
