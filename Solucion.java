
package MaxMean;

import java.util.ArrayList;

/**
 * @author Jorge Alonso Hernandez
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 19/04/2016
 * Asignatura: Diseño y Analisis de Algoritmos
 * Comentario: Clase en que tendra la solucion al problema
 */
public class Solucion {
    
    private boolean[] nodosVisitados;       // Vector en el que se almacena la solucion
                                            // el resultado lo compondran las posiciones en las que el valor sea true
    private double coste;                   // Coste total del subgrafo
    private double md;                      // maximun dispersion del subgrafo
    private int nEjecuciones;
    
    public Solucion(int nodos){
        nodosVisitados = new boolean[nodos];
        for (int i = 0; i < nodos; i++)
            nodosVisitados[i] = false;
        coste = 0;
        md = 0;
        nEjecuciones = 0;
    }

        /**
     * Metodo que imprime la solucion del algoritmo, el coste total y el md
     */
    public void mostrarSolucion(){
        System.out.print("Subgrafo solucion = {");
        for(int i = 0; i < getNodosVisitados().length; i++)
            if(isVisitado(i)){
                int nodo = i + 1;
                System.out.print(" " + nodo);
            }
        System.out.println(" } ");
        System.out.println("Coste total = " + getCoste());
        System.out.println("md = " + getMd());
        System.out.println("Numero de Ejecuciones = " + getnEjecuciones());
    }
    
    /**
     * Metodo que reinicia a false el vector de nodos visitados
     */
    public void reiniciar(){
        for(int i = 0; i < getNodosVisitados().length; i++)
            setVisitado(i, false);
    }
    
    /**
     * Metodo que pone a true los valores del ArrayList que se le pasa por parámetro
     * @param vector 
     */
    public void iniciar(ArrayList<Integer> vector){
        for(int i = 0; i < vector.size(); i++){
            setVisitado(vector.get(i), true);
        }
    }
    
    public boolean[] getNodosVisitados() {
        return nodosVisitados;
    }

    public void setNodosVisitados(boolean[] nodosVisitados) {
        this.nodosVisitados = nodosVisitados;
    }
    
    public void setVisitado(int index, boolean valor){
        nodosVisitados[index] = valor;
    }
    
    public boolean isVisitado(int index){
        return nodosVisitados[index];
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }

    public double getMd() {
        return md;
    }

    public void setMd(double md) {
        this.md = md;
    }

    public int getnEjecuciones() {
        return nEjecuciones;
    }

    public void setnEjecuciones(int nEjecuciones) {
        this.nEjecuciones = nEjecuciones;
    }
    
    
    
}
