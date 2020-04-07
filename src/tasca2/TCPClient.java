package tasca2;


import java.io.*; 
import java.net.*; 



class TCPClient { 

    public static void main(String argv[]) throws Exception 
    { 
        String sentence = null; 
        String modifiedSentence; 
        String host = "deim.urv.cat";
        String path = "/~josepm.banus/miniwebxdd/xdd.html";
        
        
        
        /* 
         Indicacions:
         	cal que feu un bucle usant el mètode:
         		readline
         		ready
         			de la clase: BufferedReader.
         */
  /*****************************************************************************************************************************/	
     // TRACTAMENT DE LA URL
        /*
        URL link = new URL(url);
        BufferedReader in = new BufferedReader(new InputStreamReader(link.openStream()));
        String inputLine;
        while ((inputLine = in.readLine())!= null)
	
		System.out.println(inputLine);
        in.close();
        */
  /*****************************************************************************************************************************/	
     // INICIALITZACIÓ BUSTIA USUARI
          BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in)); 							// lectura per teclat
        
        
  /*****************************************************************************************************************************/	        
     // INICIALITZACIÓ BUSTIA DE SORTIDA
     // substitueix hostname pel nom del host del company mes proper, ex: d600.labdeim.net
          Socket clientSocket = new Socket(host, 80); // maquina destí
          
          DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream()); 						// aixo es la bustia de sortida
        
        
        
     
  /*****************************************************************************************************************************/	        
     // INICIALITZACIÓ BUSTIA DE ENTRADA      
	      BufferedReader inFromServer =  new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); 	// aixo es un casting amb bustia d'entrada

	      
	      
  /*****************************************************************************************************************************/	        
	      
	    
	    
  /*****************************************************************************************************************************/	        
	 //	TRACTAMENT DEL MISSATGE
         // sentence = inFromUser.readLine(); 						// llegeix una linea de la bustia de entrada d'usuari

         outToServer.writeBytes("GET "+path+"\r\n\r\n"); 				// envia lo escrit per l'usuari i ho transmet per el canal de clientoscket outputstream

          
        
          do{ 
        	 		sentence = inFromServer.readLine();
        			System.out.println(sentence);		
         	} 
         	while ((inFromServer.ready()== true)&&(sentence!=null));
         
         	
         	clientSocket.close(); 									// tanca la conexió
                   
  
	    
	    
	    
    } 
} 
