
package MaxMean;

import java.util.ArrayList;

/**
 * @author Jorge Alonso Hernandez
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 19/04/2016
 * Asignatura: Diseño y Analisis de Algoritmos
 * Comentario: Clase que realiza el algoritmo voraz (apartado b) de la practica)
 */
public class AlgoritmoVoraz extends Algoritmo{
    
    public AlgoritmoVoraz(Problema problema){
    
        super(problema);
        for(int i = 0; i < getSolucion().getNodosVisitados().length; i++)               // Se inicializa la solucion toda a true
            getSolucion().setVisitado(i, true);                                         // es decir se parte de la solucion en la cual estan presentes todos los nodos
                                                                                        // y se irán eliminando nodos si se mejora la solucion
    }

    /**
     * Metodo que va a ejecutar el algoritmo voraz
     */
    public void ejecutar(){
    
        ArrayList<Integer> s = solucionInicial();
        ArrayList<Integer> s1 = new ArrayList<Integer>();
        int nodoCandidato;
        int ejecucion = 0;
        while(!sonIguales(s, s1)){
            ejecucion++;  
            System.out.println("Ejecucion = " + ejecucion);
            System.out.println("Md = " + md(s));
            s1 = igualar(s);
            
            nodoCandidato = nodoAEliminar(s);

            if(nodoCandidato != -1){
                 s.remove(nodoCandidato);
                 if(md(s) > md(s1)){
                     getSolucion().setVisitado(nodoCandidato, false);
                     getSolucion().setCoste(obtenerCoste(s));
                     getSolucion().setMd(md(s));
                 }
             }
        }
       getSolucion().setnEjecuciones(ejecucion); 
    }
   
    /**
     * Metodo que obtiene una solucion inicial con todos los nodos del problema
     * @return 
     */
    public ArrayList<Integer> solucionInicial(){
        ArrayList<Integer> vector = new ArrayList<Integer>();
        for(int i = 0; i < getSolucion().getNodosVisitados().length; i++)
            if(getSolucion().isVisitado(i))
                vector.add(i);
        getSolucion().setCoste(obtenerCoste(vector));
        getSolucion().setMd(md(vector));
        return vector;
    }
    
     /**
     * Metodo que devuelve el nodo el cual al eliminarlo aporta un mayor md a la solucion
     * @param vector
     * @return 
     */
    public int nodoAEliminar(ArrayList<Integer> vector){
    
        double maxMd = md(vector);
        int nodo = -1;
        ArrayList<Integer> aux = igualar(vector);
        
        for(int i = 0; i < vector.size(); i++){
            aux = igualar(vector);
            if(getSolucion().isVisitado(aux.get(i)))
                aux.remove(i);
                if(maxMd < md(aux)){
                    maxMd = md(aux);
                    nodo = i;           // devuelve la posicion del nodo a eliminar
                }
                    
        }
        return nodo;
        
    }

    
    
}
