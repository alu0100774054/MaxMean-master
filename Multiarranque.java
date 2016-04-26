
package MaxMean;

import java.util.*;

/**
 * @author Jorge Alonso Hernandez
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 19/04/2016
 * Asignatura: Diseño y Analisis de Algoritmos
 * Comentario: Clase que realiza el algoritmo de multiarranque (apartado d) de la practica)
 */
public class Multiarranque extends Algoritmo{
    
    public Multiarranque(Problema problema) {
        super(problema);
    }
    
    /**
     * Metodo que realiza el algoritmo del multiarranque
     */
    public void ejecutar(){
       
        Stack<Integer> pila = new Stack<Integer>();
        ArrayList<Integer> s = solucionInicial();
        mostrarArrayList(s);
        ArrayList<Integer> s1 = new ArrayList<Integer>();
        int nodoCandidato;
        int ejecucion = 0;
        
        for(int i = 0; i < s.size(); i++){
            pila.push(s.get(i));
            getSolucion().setVisitado(s.get(i), true);
            getSolucion().setCoste(obtenerCoste(s));
            getSolucion().setMd(md(s));
        }
        
        while(!sonIguales(s, s1)){
            ejecucion++;
            System.out.println("Ejecucion = " + ejecucion);
            System.out.println("Md = " + md(s));
            s1 = igualar(s);
            nodoCandidato = (int) (Math.random() * getProblema().getnNodos());
 
            
            
            while(pila.size() < getProblema().getnNodos() && pila.contains(nodoCandidato)){
                nodoCandidato = (int) (Math.random() * getProblema().getnNodos());
            }
            if(!pila.contains(nodoCandidato)){
                s.add(nodoCandidato);
                if(md(s) > md(s1)){
                    getSolucion().setVisitado(nodoCandidato, true);
                    getSolucion().setCoste(obtenerCoste(s));
                    getSolucion().setMd(md(s));
                }
                else 
                    s.remove(s.size() - 1);
                
                pila.push(nodoCandidato);
            }
            getSolucion().setnEjecuciones(ejecucion);
            
        }
    }
    
    /**
     * Metodo que obtiene una solucion inicial con dos nodos aleatorios
     * @return 
     */
    public ArrayList<Integer> solucionInicial(){
        ArrayList<Integer> vector = new ArrayList<Integer>();
        Stack<Integer> pila = new Stack<Integer>();
        int nodo1 = (int) (Math.random() * getProblema().getnNodos());
        int nodo2 = (int) (Math.random() * getProblema().getnNodos());
        
        pila.push(nodo1);
        while(pila.contains(nodo2)){
            nodo2 = (int) (Math.random() * getProblema().getnNodos());
        }
        
        vector.add(nodo1);
        vector.add(nodo2);
        getSolucion().setVisitado(nodo1, true);
        getSolucion().setVisitado(nodo2, true);
        getSolucion().setCoste(obtenerCoste(vector));
        getSolucion().setMd(md(vector));
        
        return vector;
    }
    
}
