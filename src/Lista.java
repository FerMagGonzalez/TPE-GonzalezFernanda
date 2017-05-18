
/**
 * Clase que define las operaciones básicas que debe tener una lista simple.
 * @author Fernanda M. Gonzalez
 */
public class Lista {
    // Puntero que indica el inicio de la lista.
    private Nodo inicio;
    // Variable para registrar el tamaño de la lista.
    private int tamanio;
    // Puntero que indica el fin de la lista.
    private Nodo fin;
    
    /**
     * Constructor por defecto.
     */
    public Lista(){
        inicio = null;
        tamanio = 0;
        fin = inicio;
    }
    
    /**
     * Consulta si la lista esta vacia.
     * @return true si el el tamanio de la lista es cero.
     */
    public boolean esVacia(){
        return this.tamanio == 0;
    }
    
    /**
     * Consulta cuantos elementos (nodos) tiene la lista.
     * @return el numero de elementosb que contenga la lista.
     */
    public int getTamanio(){
        return tamanio;
    }
    
    /**
     * 
     * @return
     */
    public Nodo getRaiz(){
    	return inicio;
    }
    
    /**
     * 
     * @return
     */
    public Nodo getUltimo(){
    	return fin;
    }
    
    /**
     * Agrega un nuevo nodo al final de la lista.
     * @param valor a agregar.
     */
    public void agregarAlFinal(Nodo n){
        // Define un nuevo nodo.
        //Nodo nuevo = new Nodo();
        // Agrega el valor al nodo.
        //nuevo.setDni(valor);
        // Consulta si la lista esta vacia.
        if (esVacia()) {
            // Inicializa la lista agregando como inicio al nuevo nodo.
            inicio = n;
            fin = inicio;
        // Caso contrario recorre la lista hasta llegar al ultimo nodo
        //y agrega el nuevo.
        } else{
            // Crea ua copia de la lista.
            Nodo aux = inicio;
            // Recorre la lista hasta llegar al ultimo nodo.
            while(aux.getSiguiente() != null){
                aux = aux.getSiguiente();
            }
            // Agrega el nuevo nodo al final de la lista.
            aux.setSiguiente(n);
            fin = n;
        }
        // Incrementa el contador de tamaño de la lista
        tamanio++;
    }
    
    /**
     * Agrega un nuevo nodo al inicio de la lista.
     * @param valor a agregar.
     */   
    public void agregarAlInicio(Nodo n){
        // Define un nuevo nodo.
        //Nodo nuevo = new Nodo();
        // Agrega al valor al nodo.
        //nuevo.setDni(valor);
        // Consulta si la lista esta vacia.
        if (esVacia()) {
            // Inicializa la lista agregando como inicio al nuevo nodo.
            inicio = n;
            fin = inicio;
        // Caso contrario va agregando los nodos al inicio de la lista.
        } else{
            // Une el nuevo nodo con la lista existente.
            n.setSiguiente(inicio);
            // Renombra al nuevo nodo como el inicio de la lista.
            inicio = n;
        }
        // Incrementa el contador de tamaño de la lista.
        tamanio++;
    }
    
    /**
     * Mustra en pantalla los elementos de la lista.
     */
    public void mostrarLista(){
        // Verifica si la lista contiene elementos.
        if (!esVacia()) {
            // Crea una copia de la lista.
            Nodo aux = inicio;
            // Posicion de los elementos de la lista.
            int i = 0;
            // Recorre la lista hasta el final.
            while(aux != null){
                // Imprime en pantalla el valor del nodo.
                System.out.print(i + ".[ " + aux.getDni() + " ]" + " ->  ");
                // Avanza al siguiente nodo.
                aux = aux.getSiguiente();
                // Incrementa el contador de la posión.
                i++;
            }
        }
    }
    
    /**
     * Busca si existe un valor en la lista.
     * @param referencia valor a buscar.
     * @return true si existe el valor en la lista.
     */
    public boolean buscar(String referencia){
        // Crea una copia de la lista.
        Nodo aux = inicio;
        // Bandera para indicar si el valor existe.
        boolean encontrado = false;
        // Recorre la lista hasta encontrar el elemento o hasta 
        // llegar al final de la lista.
        while(aux != null && encontrado != true){
            // Consulta si el valor del nodo es igual al de referencia.
            if (referencia.equals(aux.getDni())){
                // Canbia el valor de la bandera.
                encontrado = true;
            }
            else{
                // Avansa al siguiente. nodo.
                aux = aux.getSiguiente();
            }
        }
        // Retorna el resultado de la bandera.
        return encontrado;
    }
    
}
