
package Etapa2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Fernanda M. Gonzalez
 */
public class mainE2 {

	public static void main(String[] args) {

		int tamanio = 5;
		ListaConArreglo lista = new ListaConArreglo(tamanio);

        String csvFile = "datasets/dataset.csv";
        String line = "";
        String cvsSplitBy = ";";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        	br.readLine();    //Saltea la primer linea
            while ((line = br.readLine()) != null) {
                String[] items = line.split(cvsSplitBy);
                int i = 0;
                while (i < items.length) {
                	int dni= Integer.parseInt(items[i]);
                	nArr aux = new nArr(dni);
                	aux.agregarGusto(aux, items[i+1]);
                	aux.agregarGusto(aux, items[i+2]);
                	aux.agregarGusto(aux, items[i+3]);
                	aux.agregarGusto(aux, items[i+4]);
                	aux.agregarGusto(aux, items[i+5]);
                	lista.agregarUsuario(aux);
                	i = i+6;
                }
            }     
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    
        long startTime = 0;
        long endTime = 0;
        int tTotal = 0;
        int cant = 0;
        String csvFileInsert = "datasets/dataset_insert_10000.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFileInsert))) {

        	BufferedWriter bw = null;
    		try {
    			File file = new File("datasets/salidaInsertE2.csv");
    			if (!file.exists()) {
    				file.createNewFile();
    			}

    			FileWriter fw = new FileWriter(file);
    			bw = new BufferedWriter(fw);
    			tTotal = 0;
    			
    			while ((line = br.readLine()) != null) {
    				startTime = System.nanoTime();
                    String[] items = line.split(cvsSplitBy);
                    int i = 0;
                    while (i < items.length) {
                    	int dni= Integer.parseInt(items[i]);
                    	nArr aux = new nArr(dni);
                    	aux.agregarGusto(aux, items[i+1]);
                    	aux.agregarGusto(aux, items[i+2]);
                    	aux.agregarGusto(aux, items[i+3]);
                    	aux.agregarGusto(aux, items[i+4]);
                    	aux.agregarGusto(aux, items[i+5]);
                    	lista.agregarUsuario(aux);
                    	endTime = System.nanoTime();
                    	cant++;
                    	String contenidoLinea1 = (endTime - startTime) + " ns" + ";" + aux.getDni() + ";"+ aux.listar();
                    	tTotal += (endTime - startTime);
                    	bw.write(contenidoLinea1);
                    	bw.newLine();
                    	i = i+6;
                    }
                }     

    			String contenidoLinea1 = "Tiempo total;"+tTotal;
      			bw.write(contenidoLinea1);
            	bw.newLine();
            	if(cant > 0){
	        		contenidoLinea1 = "Tiempo promedio;"+(tTotal/cant);
		  			bw.write(contenidoLinea1);
		        	bw.newLine();
            	}

    		} 
    		catch (IOException ioe) {
    			ioe.printStackTrace();
    		} 
    		finally {
    			try {
    				if (bw != null)
    					bw.close();
    			} 
    			catch (Exception ex) {
    				System.out.println("Error cerrando el BufferedWriter" + ex);
    			}
    		}
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        
        String csvFileBusqueda = "datasets/dataset_busqueda_10000.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFileBusqueda))) {
     	   BufferedWriter bw = null;
     	   
       		try {
       			File file = new File("datasets/salidaBusquedaE2.csv");
       			
       			if (!file.exists()) {
       				file.createNewFile();
       			}
       			
       			cant = 0;
       			tTotal = 0;
       			FileWriter fw = new FileWriter(file);
       			bw = new BufferedWriter(fw);
       			String encontrado = ""; 
       			
 	            while ((line = br.readLine()) != null) {
 	            	
 	            	encontrado = "No Encontrado";
 	        		
 	        		String[] items = line.split(cvsSplitBy);
 	        		int dni= Integer.parseInt(items[0]);
 	        		
 	        		int u1 = lista.getListaUsuarios()[0].getDni();
 	        		int u2 = lista.getListaUsuarios()[1].getDni();
 	        		int u3 = lista.getListaUsuarios()[2].getDni();
 	        		
 	        		startTime = System.nanoTime();
 	        		if ((u1 < u2) && (u2 < u3)){ //comparo para saber si la lista esta ordenada de forma ascendente
 	        			if(lista.buscar(dni)){
 	 	        			encontrado = "Encontrado";
 	 	        		}
 	        		}
 	        		else{
 	        			if ((u1 > u2) && (u2 > u3)){  //comparo para saber si la lista esta ordenada de forma descendente
 	        				if(lista.buscar(dni)){
 	    	        			encontrado = "Encontrado";
 	    	        		}
 	        			}
 	        			else{   //supongo que esta desordenada
 	        				ListaConArreglo aux = new ListaConArreglo(lista.getTamanio());
 	        				aux.setListaUsuarios(lista.getListaUsuarios().clone());
 	        				aux.ordenar();
 	        				if(aux.buscar(dni)){
 	    	        			encontrado = "Encontrado";
 	    	        		}
 	        			}
 	        		}
 	        		
             	    endTime = System.nanoTime();
             	    String contenidoLinea1 = items[0] + ";" + encontrado + ";" + (endTime - startTime) + " ns";
             	    bw.write(contenidoLinea1);
             	    bw.newLine();
             	    tTotal += (endTime - startTime);
             	    cant++;
 	            }
 	            String contenidoLinea1 = "Tiempo total;"+tTotal;
 	  			bw.write(contenidoLinea1);
 	        	bw.newLine();
 	        	if(cant > 0){
 	        		contenidoLinea1 = "Tiempo promedio;"+(tTotal/cant);
 		  			bw.write(contenidoLinea1);
 		        	bw.newLine();
 	        	}
 	        } 
       		catch (IOException ioe) {
       			ioe.printStackTrace();
 	       	}
       		finally {
 	   			try {
 	   				if (bw != null)
 	   					bw.close();
 	   			} 
 	   			catch (Exception ex) {
 	   				System.out.println("Error cerrando el BufferedWriter" + ex);
 	   			}
       		}
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println("Programa terminado");

	}

}
