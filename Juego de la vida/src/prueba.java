import java.util.Vector;


public class prueba {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//EspacioCelular e=new EspacioCelular(4,5,10,10,Patron.BLINKER);
		EspacioCelular e=new EspacioCelular(4,5,2,1,Patron.BLINKER);
		//EspacioCelular e=new EspacioCelular(4,5,EspacioCelular.ALEATORIO);
		Celula ej[][] = e.get();
		for(int i=0;i<ej.length;i++){
			for(int j=0;j<ej[i].length;j++)
				System.out.print(ej[i][j]+" ");
			System.out.println("");
		}
		System.out.println("");
		Vector<Integer> cambios[];
		//System.out.println(e.calculoVecinos(0, 0));
		cambios=e.siguienteGeneracion();
		//System.out.println(e.calculoVecinos(0, 0));
		for(int i=0;i<cambios[0].size();i++)
			System.out.println(cambios[0].elementAt(i)+"    "+cambios[1].elementAt(i));
		
		ej=e.get();
		for(int i=0;i<ej.length;i++){
			for(int j=0;j<ej[i].length;j++)
				System.out.print(ej[i][j]+" ");
			System.out.println("");
		
		}
		//System.out.println(e.calculoVecinos(0, 0));
				cambios=e.siguienteGeneracion();
				//System.out.println(e.calculoVecinos(0, 0));
				for(int i=0;i<cambios[0].size();i++)
					System.out.println(cambios[0].elementAt(i)+"    "+cambios[1].elementAt(i));
				
				ej=e.get();
				for(int i=0;i<ej.length;i++){
					for(int j=0;j<ej[i].length;j++)
						System.out.print(ej[i][j]+" ");
					System.out.println("");
				
				}
	}
}
