
package MaxMean;

import java.util.ArrayList;

/**
 * @author Jorge
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 19/04/2016
 * Asignatura: Diseño y Analisis de Algoritmos
 * Comentario: Clase que realiza el algoritmo constructivo voraz (apartado a) de la practica)
 */
public class ConstructivoVoraz  extends Algoritmo{
    
    public ConstructivoVoraz(Problema problema){
        super(problema);
    }
    
    /**
     * Metodo que realiza el algoritmo constructivo voraz 
     */
    public void ejecutar(){
        
        ArrayList<Integer> s = aristaMayor();
        ArrayList<Integer> s1 = new ArrayList();
        int nodoCandidato;
        
        int ejecucion = 0;      
        
        while(!sonIguales(s, s1)){
            ejecucion++;
            System.out.println("Ejecucion = " + ejecucion);
            System.out.println("Md = " + md(s));
            
             s1 = igualar(s);
             nodoCandidato = obtenerMaxMd(s);
             if(nodoCandidato != -1){
                 s.add(nodoCandidato);
                 if(md(s) > md(s1)){
                     getSolucion().setVisitado(nodoCandidato, true);
                     getSolucion().setCoste(obtenerCoste(s));
                     getSolucion().setMd(md(s));
                 }
             }
        } 
        getSolucion().setnEjecuciones(ejecucion);
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
      
}
