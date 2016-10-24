package hja;

import java.util.ArrayList;

/**
 *
 * @author Grupo 1
 */

//Clase para el apartado 2
public class CartasModo2 {
	private ArrayList<Carta[]> cartasMano;
	private ArrayList<Carta[]> cartasMesa;
	private int size;

	public CartasModo2(ArrayList<Carta[]> mano, ArrayList<Carta[]> mesa){
		cartasMano=mano;
		cartasMesa=mesa;
	}

	public ArrayList<Carta[]> getCartasMano() {
		return cartasMano;
	}

	public ArrayList<Carta[]> getCartasMesa() {
		return cartasMesa;
	}


	public ArrayList<Carta[]> juntar(){ //Metodo para juntar el arrayList mano y arrayList mesa
		ArrayList<Carta[]> cartas = new ArrayList<Carta[]>();
		int i=0;
                for(int pos=0; pos<size; pos++){

			Carta[] c = new Carta[5]; //Creamos un array de Carta con el tama�o de la mesa mas 2 (las cartas de la mano)

			for (i=0; i<2; i++){ //Cogemos las cartas de la mano
				c[i]=(cartasMano.get(pos)[i]);
			}

			for (int j=0; j<=cartasMesa.size(); j++){ //Cogemos las cartas de la mesa
				c[j+i]=(cartasMesa.get(pos)[j]);
			}

			cartas.add(c); 
		}
		return cartas;
	}


	public int getSize() {
		return size;
	}

    public void setSize(int size) {
        this.size = size;
    }
        

}
