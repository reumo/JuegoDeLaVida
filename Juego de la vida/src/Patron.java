
public class Patron {
	
	public static Patron BLOCK,BOAT,BLINKER;
	
	static {
		Celula[][] p1 = {
				{Celula.VIVA,Celula.VIVA},
				{Celula.VIVA,Celula.MUERTA}
			};
		BLOCK = new Patron(p1);
		
		Celula[][] p2 = {
				{Celula.VIVA,Celula.VIVA,Celula.MUERTA},
				{Celula.VIVA,Celula.MUERTA,Celula.VIVA},
				{Celula.MUERTA,Celula.VIVA,Celula.MUERTA}
			};
		BOAT = new Patron(p2);
		Celula[][] p3 ={
				{Celula.VIVA,Celula.VIVA,Celula.VIVA}
		};
		BLINKER = new Patron(p3);
				
		
		
	}
	
	private Celula [][] patron;
	
	public Patron(int filas, int columnas) {
		patron = new Celula[filas][columnas];
	}
	
	public Patron(Celula[][] patron) {
		this.patron = new Celula[patron.length][];
		try{
			for (int i=0; i<patron.length; i++)
			this.patron[i]=patron[i].clone();
		}
		catch(IndexOutOfBoundsException e){}
	}
	
	public void SetCelula(int f, int c, Celula estado){
		try{patron[f][c] = estado;}
		catch(IndexOutOfBoundsException e){}
	}

	public Celula getCelula(int f,int c) throws IndexOutOfBoundsException{
		return patron[f][c];
	}
	public int getFilas(){
		return patron.length;
	}
	public int getColumnas(){
		return patron[0].length;
	}
	
}

