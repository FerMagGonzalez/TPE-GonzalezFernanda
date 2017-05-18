
/**
 * Clase que define las operaciones b�sicas que debe tener una lista pero hecha con un arreglo.
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
	 * @param el tama�o del arreglo
	 */
	public ListaConArreglo(int tamanio) {
		listaUsuarios = new nArr[tamanio];
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
     * Consulta el tama�o que tiene el arreglo.
     * @return el tama�o que tiene el arreglo.
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
        	//Consulta si el ta�ano del arreglo es menor o igual a la cantidad de elementos.
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
        // Incrementa el contador de tama�o de la lista.
        cantElem++;
    }
    
    /**
     * 
     * @param dni
     * @return
     */
    public boolean buscar(String dni){
		int i = 0;
		while(i<this.cantElem){
			if(listaUsuarios[i].getDni().equals(dni)){
				return true;
			}
			i++;
		}
		return false;
    }

    public void mostrarLista(){
        if (!esVacio()) {
            for (int i=1; i<this.getCantElem();i++){
            	System.out.print(i + ".[ " + listaUsuarios[i].getDni() + " ]" + ": \n");
            	for (int j = 0; j < listaUsuarios[i].getGustos().size(); j++) {
					System.out.println("Gusto " + (j+1) + ": " + listaUsuarios[i].getGustos().get(j));
				}
            }
        }
    }
    
}
