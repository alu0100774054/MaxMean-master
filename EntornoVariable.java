
package MaxMean;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Jorge Alonso Hernandez
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 19/04/2016
 * Asignatura: Diseño y Analisis de Algoritmos
 * Comentario: Clase que realiza el algoritmo constructivo voraz (apartado e) de la practica)
 */
public class EntornoVariable extends Algoritmo{
    
    private final int kMax = 3;                             // 
    
    public EntornoVariable(Problema problema){
        super(problema);
    }
    
    /**
     * Metodo que ejecuta el algoritmo de Busqueda de Entorno Variable
     */
    public void ejecutar(){
        int k = 0;
        ArrayList<Integer> todosLosNodos = new ArrayList();
        for(int i = 0; i < getSolucion().getNodosVisitados().length; i++)
            todosLosNodos.add(i);
        
        ArrayList<Integer> s = aleatorio(todosLosNodos);
        ArrayList<Integer> vecinos = getVecinos(s);
        ArrayList<Integer> s1 = new ArrayList<Integer>();
        int nodoCandidato;
        int operacion;
        int nodoAEliminar;
        int ejecucion = 0;
        
        while(k < getkMax()){
            ejecucion++;
            System.out.println("Ejecucion = " + ejecucion);
            System.out.println("Md = " + md(s));
           s1 = igualar(s);
           vecinos = getVecinos(s);
           nodoCandidato = nodoAleatorio(vecinos);
           operacion = (int) (Math.random() * 3);
           if(operacion == 0){                                                  // cuando operacion == 0, se procede a comprobar
               s.add(nodoCandidato);                                            // si el md aumenta añadiendo un nuevo nodo aleatorio
               if(md(s) > md(s1)){
                    getSolucion().setVisitado(nodoCandidato, true);
                    getSolucion().setCoste(obtenerCoste(s));
                    getSolucion().setMd(md(s));
                    k = 0;
               }
               else{
                  k++;
                  s.remove(s.size() - 1);
               }
           }
           else if(operacion == 1){                                             // cuando operacion == 1, se procede a comprobar
               nodoAEliminar = (int) (Math.random() * s.size() - 1);            // si el md aumenta intercambiando un nodo de la solucion
                                                                                // por otro aleatorio
               s.remove(nodoAEliminar);
               s.add(nodoCandidato);
               if(md(s) > md(s1)){
                  
                  getSolucion().reiniciar();
                  getSolucion().iniciar(s);
                  getSolucion().setCoste(obtenerCoste(s));
                  getSolucion().setMd(md(s)); 
                  k = 0;
               }
               else{
                   k++;
                   s = igualar(s1);
               }
           }
           else if(operacion == 2){                                             // cuando operacion == 2, se procede a comprobar
               nodoAEliminar = (int) (Math.random() * s.size() - 1);            // si el md mejora eliminando un nodo de la solucion
               s.remove(nodoAEliminar);
               if(md(s) > md(s1)){
                   getSolucion().setVisitado(nodoAEliminar, false);
                   getSolucion().setCoste(obtenerCoste(s));
                   getSolucion().setMd(md(s));
                   k = 0;
               }
               else{
                   k++;
                   s = igualar(s1);
               }
           }
        }
        getSolucion().setnEjecuciones(ejecucion);
        
        for(int i = 0; i < s.size(); i++)
            getSolucion().setVisitado(s.get(i), true);
        getSolucion().setCoste(obtenerCoste(s));
        getSolucion().setMd(md(s));
    }
     
    /**
     * Metodo que devuelve un nodo aleatorio del ArrayList
     * @param vector
     * @return 
     */
    public int nodoAleatorio(ArrayList<Integer> vector){
        int aleatorio = (int) (Math.random() * vector.size() - 1);
        return vector.get(aleatorio);
        
    }
    
    /**
     * Metodo que devuelve un ArrayList con dos nodos aleatorios que conformaran la solucion inicial
     * @param vector
     * @return 
     */
    public ArrayList<Integer> aleatorio(ArrayList<Integer> vector){
        
        ArrayList<Integer> aux = new ArrayList<Integer>();
        Stack<Integer> pila = new Stack<Integer>();
        int nodo1 = (int) (Math.random() * vector.size());
        int nodo2 = (int) (Math.random() * vector.size());
        
        pila.push(nodo1);
        while(pila.contains(nodo2)){
            nodo2 = (int) (Math.random() * getProblema().getnNodos());
        }
        
        aux.add(nodo1);
        aux.add(nodo2);
        
        return aux;
    }

    /**
     * Metodo que devuelve un ArrayList con los nodos que tienen la arista de mayor coste
     * @return 
     */
    public ArrayList<Integer> aristaMayor(){
        double max = Double.NEGATIVE_INFINITY;
        int nodo1 = 0;
        int nodo2 = 0;
        ArrayList<Integer> vector = new ArrayList<Integer>();
        
        for (int i = 0; i < getProblema().getnNodos(); i++){
            for(int j = 0; j < getProblema().getnNodos(); j++){
                if(getProblema().getElemento(i, j) > max){
                    max = getProblema().getElemento(i, j);
                    nodo1 = i;
                    nodo2 = j;
                }
            }
        }
        getSolucion().setVisitado(nodo1, true);
        getSolucion().setVisitado(nodo2, true);
        vector.add(nodo1);
        vector.add(nodo2);
        getSolucion().setCoste(obtenerCoste(vector));       
        getSolucion().setMd(md(vector));                    
        
        return vector;
    }
    
    public int getkMax() {
        return kMax;
    }
    
}
