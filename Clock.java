
package MaxMean;

/**
 * @author Jorge Alonso Hernandez
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 19/04/2016
 * Asignatura: Diseño y Analisis de Algoritmos
 * Comentario: Clase que implementa un reloj de ejecución
 */
public class Clock {

        private long inicio;                // inicio del contador
        private long fin;                   // fin del contador

        public Clock(){
                inicio = 0;
                fin = 0;
        }

        /**
         * Metodo que indica el inicio del tiempo
         */
        public void start(){
                setInicio(System.currentTimeMillis());
        }

        /**
         * Metodo que indica el fin del tiempo
         */
        public void stop(){
                setFin(System.currentTimeMillis());
        }

        /**
         * Metodo que devuelve el tiempo en milisegundos transcurrido
         * @return
         */
        public long eslapsedTime(){
                return getFin() - getInicio();
        }
        
        public long getInicio() {
                return inicio;
        }

        public void setInicio(long inicio) {
                this.inicio = inicio;
        }

        public long getFin() {
                return fin;
        }

        public void setFin(long fin) {
                this.fin = fin;
        }
}  


