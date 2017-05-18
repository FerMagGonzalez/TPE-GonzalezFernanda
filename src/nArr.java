
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Fernanda M. Gonzalez
 *
 */
public class nArr {

	private String dni;
	private ArrayList<String> gustos;
	
	/**
	 * 
	 */
	public nArr() {
		dni = " ";
		gustos = new ArrayList<String>();
	}
	
	/**
	 * @param dni
	 */
	public nArr(String dni) {
		this.dni = dni;
		this.gustos = new ArrayList<String>();
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
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
	
	public String getGusto(int i){
		return gustos.get(i);
	}
	
	public void setGusto(String g){
		gustos.add(g);
	}
	
	/**
	 * 
	 * @param n
	 * @param g
	 * @return
	 */
    private boolean estaGusto(nArr n, String g){
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
    public void agregarGusto(nArr n, String g){
    	if (this.getGustos() != null){
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
    
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[dni= " + dni + ", gustos= " + gustos + "]";
	}
	
}
