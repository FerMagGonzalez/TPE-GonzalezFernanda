package Etapa2;

/**
 * Clase que define las operaciones básicas que debe tener una lista pero hecha con un arreglo.
 * @author Fernanda M. Gonzalez
 */
public class ListaConArreglo {

	private nArr[] listaUsuarios;
	private int cantElem = 0;
	
	/**
     * Constructor por defecto.
     */
    public ListaConArreglo(){
    	listaUsuarios = new nArr[10000];
    }
    
    /**
     * Constructor con parametro
	 * @param el tamaño del arreglo
	 */
	public ListaConArreglo(int tamanio) {
		listaUsuarios = new nArr[tamanio];
	}
	
	/**
	 * @return the listaUsuarios
	 */
	public nArr[] getListaUsuarios() {
		return listaUsuarios;
	}

	/**
	 * @param listaUsuarios the listaUsuarios to set
	 */
	public void setListaUsuarios(nArr[] listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	/**
     * Consulta si el arreglo esta vacio.
     * @return true si el el arreglo es null.
     */
	public boolean esVacio(){
		return cantElem == 0;
	}
	
	/**
     * Consulta cuantos elementos tiene el arreglo.
     * @return el numero de elementos que contiene el arreglo.
     */
    public int getCantElem(){
        return cantElem;
    }
    
	/**
     * Consulta el tamaño que tiene el arreglo.
     * @return el tamaño que tiene el arreglo.
     */
    public int getTamanio(){
        return listaUsuarios.length;
    }
    
    /**
     * Agrega un nuevo usuario en la lista.
     * @param valor a agregar.
     */   
    public void agregarUsuario(nArr n){
        // Consulta si la lista no esta vacia.
        if (!esVacio()){
        	//Consulta si el tañano del arreglo es menor o igual a la cantidad de elementos.
            if (getTamanio() == getCantElem()){
            	nArr[] arregloNuevo = new nArr[getTamanio() * 2];
            	//Copia la lista existente a la nueva con el doble de capacidad.
            	for(int i=0; i<this.getCantElem(); i++){
            		arregloNuevo[i] = listaUsuarios[i];
            	}
            	listaUsuarios = arregloNuevo;
            }            
        }
        //nArr aux = new nArr(valor);
        // Agrega el valor en la lista.
        listaUsuarios[this.cantElem] = n;
        // Incrementa el contador de tamaño de la lista.
        cantElem++;
    }
    
    /**
     * 
     * @param dni
     * @return
     */
    public boolean buscar(int dni){
		int i = 0;
		while(i<this.cantElem){
			if(listaUsuarios[i].getDni() == dni){
				return true;
			}
			i++;
		}
		return false;
    }
    
    /**
	 * Método de ordenamiento por MergeSort.
	 */
    public void ordenar() {
    	int tamanio = this.getTamanio();
    	nArr[] tempMergArr = new nArr[tamanio];
        mergeSort(tempMergArr, 0, tamanio - 1);
    }
    
    /**
     * 
     * @param min
     * @param max
     */
    private void mergeSort(nArr[] arr, int min, int max) {
        if (min < max) {
            int medio = min + (max - min) / 2;
            mergeSort(arr, min, medio);
            mergeSort(arr, medio + 1, max);
            intercalar(arr, min, medio, max);
        }
    }
 
    /**
     * Intercambia los valores.
     * @param izq
     * @param medio
     * @param der
     */
    private void intercalar(nArr[] a, int izq, int medio, int der) {
        for (int i = izq; i <= der; i++) {
            a[i] = listaUsuarios[i];
        }
        int i = izq;
        int j = medio + 1;
        int k = izq;
        while (i <= medio && j <= der) {
        	if ((a[i]!=null) && (a[j]!=null)){
        		if (a[i].getDni() <= a[j].getDni()) {
                	listaUsuarios[k] = a[i];
                    i++;
                } else {
                	listaUsuarios[k] = a[j];
                    j++;
                }
                k++;
        	}
            
        }
        while (i <= medio) {
        	listaUsuarios[k] = a[i];
            k++;
            i++;
        }
    }    

    public void mostrarLista(){
        if (!esVacio()) {
            for (int i=0; i<this.getCantElem();i++){
            	System.out.print((i+1) + ".[ " + listaUsuarios[i].getDni() + " ]" + ": \n");
            	for (int j = 0; j < listaUsuarios[i].getGustos().size(); j++) {
					System.out.println("Gusto " + (j+1) + ": " + listaUsuarios[i].getGustos().get(j));
				}
            }
        }
    }
    
}
