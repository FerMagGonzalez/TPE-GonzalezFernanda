
package Etapa2;

/**
 * @author Fernanda M. Gonzalez
 */
public class MergeSort {

	private nArr[] arreglo;
	private nArr[] tempMergArr;
    private int tamanio;
	     
    /**
     * Constructor de la clase.
	 * @param m
	 */
	public MergeSort(int m) {
		this.arreglo = new nArr[m];
	}

	/**
	 * Setea el arreglo.
	 * @param arreglo
	 */
	public void setArreglo(nArr[] arreglo) {
		this.arreglo = arreglo;
	}
    
	/**
	 * Método de ordenamiento por MergeSort.
	 */
    public void ordenar() {
        //this.arreglo = arr;
        this.tamanio = this.arreglo.length;
        this.tempMergArr = new nArr[tamanio];
        mergeSort(0, tamanio - 1);
    }
    
    /**
     * 
     * @param min
     * @param max
     */
    private void mergeSort(int min, int max) {
        if (min < max) {
            int medio = min + (max - min) / 2;
            mergeSort(min, medio);
            mergeSort(medio + 1, max);
            intercalar(min, medio, max);
        }
    }
 
    /**
     * Intercambia los valores.
     * @param izq
     * @param medio
     * @param der
     */
    private void intercalar(int izq, int medio, int der) {
        for (int i = izq; i <= der; i++) {
            tempMergArr[i] = arreglo[i];
        }
        int i = izq;
        int j = medio + 1;
        int k = izq;
        while (i <= medio && j <= der) {
            if (tempMergArr[i].getDni() <= tempMergArr[j].getDni()) {
                arreglo[k] = tempMergArr[i];
                i++;
            } else {
                arreglo[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= medio) {
            arreglo[k] = tempMergArr[i];
            k++;
            i++;
        }
    }
    
    /*
	public void mostrarArreglo(){
		for (int i=0; i < arreglo.length; i++){
			System.out.println(i+1 + " " + arreglo[i]);
		}
	}*/
	
}
