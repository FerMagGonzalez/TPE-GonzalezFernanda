import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * @author Fernanda M. Gonzalez
 */
public class Nodo {
    // Variable en la cual se va a guardar el dni.
    private String dni;
    // Variable en la cual se va a guardar los gustos.
    private ArrayList<String> gustos;
    // Variable para enlazar los nodos.
    private Nodo sig;
    
    /**
     * Constructor que inicializamos el valor de las variables.
     */
    public Nodo(){
        this.dni = " ";
        this.gustos = new ArrayList<String>();
        this.sig = null;
    }
    
    /**
     * Constructor que inicializamos el valor de las variables pasadas por parametros.
     * @param n
     * @param sig
     */
    public Nodo(String n){
    	this.dni = n;
        this.gustos = new ArrayList<String>();
        this.sig = null;
    }
    
    // Métodos get y set para los atributos.
    public String getDni() {
        return dni;
    }

    public void setDni(String u) {
        this.dni = u;
    }

    /**
	 * @return the gustos
	 */
	public ArrayList<String> getGustos() {
		return gustos;
	}

	/**
	 * @param gustos the gustos to set
	 */
	public void setGustos(ArrayList<String> gustos) {
		this.gustos = gustos;
	}

	public Nodo getSiguiente() {
        return sig;
    }

    public void setSiguiente(Nodo sig) {
        this.sig = sig;
    }   
    
    /**
	 * 
	 * @param n
	 * @param g
	 * @return
	 */
    private boolean estaGusto(Nodo n, String g){
		boolean esta = false;
		if (n.getGustos() != null){
			Iterator<String> it = n.getGustos().iterator();
	    	while ((it.hasNext()) && (esta != true)){
	    		if (n.getGustos().contains(g)){
	    			esta = true;
	    		}
	    		
	    		it.next();
	    	}
		}
    	return esta;
    }
    
    /**
     * 
     * @param n
     * @param g
     */
    public void agregarGusto(Nodo n, String g){
    	if (n.getGustos() != null){
    		if (g != " "){
    			if (!this.estaGusto(n,g)){
        			n.getGustos().add(g);
            	}
    		}
    	}
    	else{
    		n.getGustos().add(g);
    	}
    }
    
    /**
     * 
     * @return
     */
    public String listar(){
		String temporal = dni;
		Iterator<String> it = this.getGustos().iterator();
		int i = 0;
		while(it.hasNext() && (i <= gustos.size())){
			temporal+=";"+gustos.get(i);
			i++;
			it.next();
		}
		return temporal;
    }
    
}
