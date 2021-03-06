/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Gui.Tablero;

/**
 *
 * @author Grupo 01
 */
public class JugadorAutomatico extends Jugador{
    private Logica log;
    private int num;
    
    
    public JugadorAutomatico(Logica l, int i){
        log=l;
        num=i;
    }
    @Override      
    public Carta jugar() {
        Carta c;
        Tablero.bloquearPasar(false);
        c=mejorCarta();
        
        if(c!=null){
            Tablero.jugarBot(c);
        }
        
        log.pasarTurno();
        Tablero.actualizaTurno(num+1);
        Tablero.bloquearPasar(true);
       return c;
    }

    @Override
    public void pasar() {
    }

    @Override
    public String getModo() {
       return "Automatico";}

    public boolean buenasParaAbrir(char c){

    	boolean buena=false;

    	for(int i =0; i<cartas.size();i++){

    		if(c == 'o')
    			if(cartas.get(i).getValor() == 1 && cartas.get(i).getColor() == 'o' 
    			||cartas.get(i).getValor() == 2 && cartas.get(i).getColor() == 'o' 
    			||cartas.get(i).getValor() == 11 && cartas.get(i).getColor() == 'o' 
    			||cartas.get(i).getValor() == 12 && cartas.get(i).getColor() == 'o')

    				buena=true;

    		if(c == 'e')
    			if(cartas.get(i).getValor() == 1 && cartas.get(i).getColor() == 'e' 
    			||cartas.get(i).getValor() == 2 && cartas.get(i).getColor() == 'e' 
    			||cartas.get(i).getValor() == 11 && cartas.get(i).getColor() == 'e' 
    			||cartas.get(i).getValor() == 12 && cartas.get(i).getColor() == 'e')

    				buena=true;

    		if(c == 'b')
    			if(cartas.get(i).getValor() == 1 && cartas.get(i).getColor() == 'b' 
    			||cartas.get(i).getValor() == 2 && cartas.get(i).getColor() == 'b' 
    			||cartas.get(i).getValor() == 11 && cartas.get(i).getColor() == 'b' 
    			||cartas.get(i).getValor() == 12 && cartas.get(i).getColor() == 'b')

    				buena=true;

    		if(c == 'c')
    			if(cartas.get(i).getValor() == 1 && cartas.get(i).getColor() == 'c' 
    			||cartas.get(i).getValor() == 2 && cartas.get(i).getColor() == 'c' 
    			||cartas.get(i).getValor() == 11 && cartas.get(i).getColor() == 'c' 
    			||cartas.get(i).getValor() == 12 && cartas.get(i).getColor() == 'c')

    				buena=true;
    	}

    	return buena;
    }

    	
    private Carta mejorCarta(){

    	Carta mejorOpcion = null;
    	int cont = 0;
    	boolean cartasAltas = false,abrir = false;
    	if(cincoDeOros() != -1){  
    		mejorOpcion = cartas.get(cincoDeOros());
    	}else{
    		for(int i = 0; i < cartas.size() && !abrir;i++){
    			if(cartas.get(i).getValor() > 5){
    				if(cartas.get(i).getColor() == 'o'){
    					if(cartasAltas('o') && cartasAltas){
    						if(numCartasAltas('o') >= cont && log.esPosible(cartas.get(i),false) == null){
    							cont = numCartasAltas('o');
    							mejorOpcion = cartas.get(i);
    						}
    					}else if(!cartasAltas && cartasAltas('o') && log.esPosible(cartas.get(i),false) == null){
    						cartasAltas = true;
    						cont = numCartasAltas('o');
    						mejorOpcion = cartas.get(i);
    					}else if(mejorOpcion == null && log.esPosible(cartas.get(i),false) == null){
    						cartasAltas = cartasAltas('o');
    						cont = numCartasAltas('o');
    						mejorOpcion = cartas.get(i);
    					}
    					}else if(cartas.get(i).getColor() == 'e'){
    						if(cartasAltas('e') && cartasAltas){
    							if(numCartasAltas('e') >= cont && log.esPosible(cartas.get(i),false) == null){
    								cont = numCartasAltas('e');
    								mejorOpcion = cartas.get(i);
    							}
    						}else if(!cartasAltas && cartasAltas('e') && log.esPosible(cartas.get(i),false) == null){
    							cartasAltas = true;
    							cont = numCartasAltas('e');
    							mejorOpcion = cartas.get(i);
    						}else if(mejorOpcion == null && log.esPosible(cartas.get(i),false) == null){
        						cartasAltas = cartasAltas('e');
        						cont = numCartasAltas('e');
        						mejorOpcion = cartas.get(i);
        					}
    					}else if(cartas.get(i).getColor() == 'b'){
    						if(cartasAltas('b') && cartasAltas){
    							if(numCartasAltas('b') >= cont && log.esPosible(cartas.get(i),false) == null){
    								cont = numCartasAltas('b');
    								mejorOpcion = cartas.get(i);
    							}
    						}else if(!cartasAltas && cartasAltas('b') && log.esPosible(cartas.get(i),false) == null){
    							cartasAltas = true;
    							cont = numCartasAltas('b');
    							mejorOpcion = cartas.get(i);
    						}else if(mejorOpcion == null && log.esPosible(cartas.get(i),false) == null){
        						cartasAltas = cartasAltas('b');
        						cont = numCartasAltas('b');
        						mejorOpcion = cartas.get(i);
        					}
    					}else{
    						if(cartasAltas('c') && cartasAltas){
    							if(numCartasAltas('c') >= cont && log.esPosible(cartas.get(i),false) == null){
    								cont = numCartasAltas('c');
    								mejorOpcion = cartas.get(i);
    							}
    						}else if(!cartasAltas && cartasAltas('c') && log.esPosible(cartas.get(i),false) == null){
    							cartasAltas = true;
    							cont = numCartasAltas('c');
    							mejorOpcion = cartas.get(i);
    						}else if(mejorOpcion == null && log.esPosible(cartas.get(i),false) == null){
        						cartasAltas = cartasAltas('c');
        						cont = numCartasAltas('c');
        						mejorOpcion = cartas.get(i);
        					}
    					}				
    				}else if(cartas.get(i).getValor() < 5){
    					if(cartas.get(i).getColor() == 'o'){
    						if(cartaBajas('o') && cartasAltas){
    							if(numCartasAltas('o') >= cont && log.esPosible(cartas.get(i),false) == null){
    								cont = numCartaBajas('o');
    								mejorOpcion = cartas.get(i);
    							}
    						}else if(!cartasAltas && cartaBajas('o') && log.esPosible(cartas.get(i),false) == null){
    							cartasAltas = true;
    							cont = numCartaBajas('o');
    							mejorOpcion = cartas.get(i);
    							
    						}else if(mejorOpcion == null && log.esPosible(cartas.get(i),false) == null){
        						cartasAltas = cartasAltas('o');
        						cont = numCartasAltas('o');
        						mejorOpcion = cartas.get(i);
        					}
    					}else if(cartas.get(i).getColor() == 'e'){
    						if(cartaBajas('e') && cartasAltas){
    							if(numCartaBajas('e') >= cont && log.esPosible(cartas.get(i),false) == null){
    								cont = numCartaBajas('e');
    								mejorOpcion = cartas.get(i);
    							}
    						}else if(!cartasAltas && cartaBajas('e') && log.esPosible(cartas.get(i),false) == null){
    							cartasAltas = true;
    							cont = numCartaBajas('e');
    							mejorOpcion = cartas.get(i);
    							
    						}else if(mejorOpcion == null && log.esPosible(cartas.get(i),false) == null){
        						cartasAltas = cartasAltas('e');
        						cont = numCartasAltas('e');
        						mejorOpcion = cartas.get(i);
        					}					
    					}else if(cartas.get(i).getColor() == 'b'){
    						if(cartaBajas('b') && cartasAltas){
    							if(numCartaBajas('b') >= cont && log.esPosible(cartas.get(i),false) == null){
    								cont = numCartaBajas('b');
    								mejorOpcion = cartas.get(i);
    							}
    						}else if(!cartasAltas && cartaBajas('b') && log.esPosible(cartas.get(i),false) == null){
    							cartasAltas = true;
    							cont = numCartaBajas('b');
    							mejorOpcion = cartas.get(i);
    							
    						}else if(mejorOpcion == null && log.esPosible(cartas.get(i),false) == null){
        						cartasAltas = cartasAltas('b');
        						cont = numCartasAltas('b');
        						mejorOpcion = cartas.get(i);
        					}					
    					}else{
    						if(cartaBajas('c') && cartasAltas){
    							if(numCartaBajas('c') >= cont && log.esPosible(cartas.get(i),false) == null){
    								cont = numCartaBajas('c');
    								mejorOpcion = cartas.get(i);
    							}
    						}else if(!cartasAltas && cartaBajas('c') && log.esPosible(cartas.get(i),false) == null){
    							cartasAltas = true;
    							cont = numCartaBajas('c');
    							mejorOpcion = cartas.get(i);
    							
    						}else if(mejorOpcion == null && log.esPosible(cartas.get(i),false) == null){
        						cartasAltas = cartasAltas('c');
        						cont = numCartasAltas('c');
        						mejorOpcion = cartas.get(i);
        					}
    					}
    				}else{
    					
    						abrir = true;
    						mejorOpcion = cartas.get(i);
    					
    				}
    		}
    	}
    	
    	if(mejorOpcion != null)
    		log.esPosible(mejorOpcion, true);
    	
    	return mejorOpcion;
    }
    
	   private int contarCuantasPalo(char c){

	    	  int cont = 0, contador = 0;
	    	  
	    	  while (cartas.size() > cont){
	    	   if (c == 'o')
	    	    contador++;
	    	   if (c == 'b')
	    	    contador++;
	    	   if (c == 'c')
	    	    contador++;
	    	   if (c == 'e')
	    	    contador++;
	    	   cont++;
	    	  }
	    	  
	    	  return contador;
	    }
	   
		private int cincoDeOros(){
			int pos = -1;
			
			for(int i = 0;i<cartas.size();i++)
				if(cartas.get(i).getValor() == 5 && cartas.get(i).getColor() == 'o')
					pos = i;
			
			
			return pos;
		}
		
		private boolean cartasAltas(char c){
			boolean altas = false;
			int extOroA,extEspA,extBastA,extCopasA;

			extOroA = log.extremoA('o');
			extEspA = log.extremoA('e');
			extBastA = log.extremoA('b');
			extCopasA = log.extremoA('c');

			for(int i = 0; i < cartas.size() && !altas;i++){
				if(c == 'o'){
					if(cartas.get(i).getColor() == 'o' && cartas.get(i).getValor() > extOroA+2)
						altas = true;
				}else if(c == 'e'){
						if(cartas.get(i).getColor() == 'e' && cartas.get(i).getValor() > extEspA+2)
							altas = true;
				}else if(c == 'b'){
						if(cartas.get(i).getColor() == 'b' && cartas.get(i).getValor() > extBastA+2)
							altas = true;
				}else
								
					if(cartas.get(i).getColor() == 'c' && cartas.get(i).getValor() > extCopasA+2)
						altas = true;

			}
			return altas;
		}
		
		private boolean cartaBajas(char c){
			boolean altas = false;
			int extOroB,extEspB,extBastB,extCopasB;


			extOroB = log.extremoB('o');
			extEspB = log.extremoB('e');
			extBastB = log.extremoB('b');
			extCopasB = log.extremoB('c');

			for(int i = 0; i < cartas.size() && !altas;i++){
				if(c == 'o'){
					if(cartas.get(i).getColor() == 'o' && cartas.get(i).getValor() < extOroB-2)
						altas = true;
				}else if(c == 'e'){
					if(cartas.get(i).getColor() == 'e' && cartas.get(i).getValor() < extEspB-2)
						altas = true;
				}else if(c == 'b'){
					if(cartas.get(i).getColor() == 'b' && cartas.get(i).getValor() < extBastB-2)
						altas = true;
				}else
					if(cartas.get(i).getColor() == 'c' && cartas.get(i).getValor() < extCopasB-2)
						altas = true;

			}
			return altas;
		}
		
	    private int numCartasAltas(char c) {
	    	int altas = 0;
	    	int extOroA, extEspA, extBastA, extCopasA;

	    	extOroA = log.extremoA('o');
	    	extEspA = log.extremoA('e');
	    	extBastA = log.extremoA('b');
	    	extCopasA = log.extremoA('c');

	    	for (int i = 0; i < cartas.size(); i++) {
	    		if (c == 'o' && cartas.get(i).getColor() == 'o') {
	    			if ((cartas.get(i).getValor() > extOroA + 2) || (cartas.get(i).getValor() == 11 && extOroA == 7))
	    				altas++;
	    		} else if (c == 'e' && cartas.get(i).getColor() == 'e') {
	    			if ((cartas.get(i).getValor() > extEspA + 2)|| (cartas.get(i).getValor() == 11 && extEspA == 7))
	    				altas++;
	    		} else if (c == 'b' && cartas.get(i).getColor() == 'b') {
	    			if ((cartas.get(i).getValor() > extBastA + 2)|| (cartas.get(i).getValor() == 11 && extBastA == 7))
	    				altas++;
	    		} else if (cartas.get(i).getColor() == 'c') {
	    			if ((cartas.get(i).getValor() > extCopasA + 2)|| (cartas.get(i).getValor() == 11 && extCopasA == 7))
	    				altas++;
	    		}

	    	}
	    	return altas;
	    }
		
		private int numCartaBajas(char c){
			int altas = 0;
			int extOroB,extEspB,extBastB,extCopasB;



			extOroB = log.extremoB('o');
			extEspB = log.extremoB('e');
			extBastB = log.extremoB('b');
			extCopasB = log.extremoB('c');

			for(int i = 0; i < cartas.size();i++){
				if(c == 'o'){
					if(cartas.get(i).getColor() == 'o' && cartas.get(i).getValor() < extOroB-2)
						altas++;
				}else if(c == 'e'){
					if(cartas.get(i).getColor() == 'e' && cartas.get(i).getValor() < extEspB-2)
						altas++;
				}else if(c == 'b'){
					if(cartas.get(i).getColor() == 'b' && cartas.get(i).getValor() < extBastB-2)
						altas++;
				}else
					if(cartas.get(i).getColor() == 'c' && cartas.get(i).getValor() < extCopasB-2)
						altas++;

			}
			return altas;
		}

    
}
