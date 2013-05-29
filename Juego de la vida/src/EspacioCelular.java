import java.util.Random;


public class EspacioCelular {
	
	
	private Celula [][]generacionActual;
	public static final boolean ALEATORIO=true;
	public static final boolean VACIO=false;

	
	
	public EspacioCelular(int ancho,int alto,int fila,int columna,Patron p){
	
		generacionActual = new Celula [alto][ancho];
		for(int i=0;i<p.getFilas();i++){
			for(int j=0;j<p.getColumnas();j++)
				
					generacionActual[i+fila][j+columna]=p.getCelula(i,j);
				
		}
	
	}

	
	
	public EspacioCelular(int ancho,int alto,boolean aleatorio){
		generacionActual = new Celula [alto][ancho];
		if(aleatorio){
			rellenoAleatorio();
		}
	}
	
	public void rellenoAleatorio(){
		Random r = new Random();
		int numCel= r.nextInt(generacionActual.length*generacionActual[0].length);
		for(int i=0;i<=numCel;i++)
			generacionActual[r.nextInt(generacionActual.length)][r.nextInt(generacionActual[0].length)]=Celula.VIVA;
	}
	
	public void limpiar(){
		for(int i=0;i<generacionActual.length;i++)
			for(int j=0;j<generacionActual[i].length;j++)
				generacionActual[i][j]=Celula.MUERTA;
	}
	
	public void changeEstadoCelula(int fila,int columna){
		try{
			if(generacionActual[fila][columna]==Celula.VIVA) 
				generacionActual[fila][columna]=Celula.MUERTA;
			else
				generacionActual[fila][columna]=Celula.VIVA;
		}catch (ArrayIndexOutOfBoundsException e){}
	}
	
	public Celula getCelula(int fila,int columna){
		try{
			if(generacionActual[fila][columna]==Celula.VIVA)
			return Celula.VIVA;
			return Celula.MUERTA;
		}catch (ArrayIndexOutOfBoundsException e){return null;}
		
		
	}
	
	public void siguienteGeneracion(){

		for(int c=0;c<generacionActual.length;c++)
			for(int f=0;f<generacionActual[c].length;f++){
				if(embrion(c,f)) generacionActual[c][f]=Celula.EMBRION;
				if(moribundo(c,f)) generacionActual[c][f]=Celula.MORIBUNDA;
				
			}
		

		for(int c=0;c<generacionActual.length;c++)
			for(int f=0;f<generacionActual[c].length;f++){
				if(generacionActual[c][f]==Celula.EMBRION){
					generacionActual[c][f]=Celula.VIVA;

				}	
				if(generacionActual[c][f]==Celula.MORIBUNDA){
					generacionActual[c][f]=Celula.MUERTA;

				}
				
			}
		
	}
	
	private boolean moribundo(int c,int f){
		return (calculoVecinos(c,f) <=1 || calculoVecinos(c,f) >=4) && generacionActual[c][f]==Celula.VIVA; 
	}
	
	private boolean embrion(int c,int f){
		return calculoVecinos(c,f)==3 && (generacionActual[c][f]==Celula.MUERTA || generacionActual[c][f]==null);
	}
	
	private int calculoVecinos(int c,int f){
		int cont=0;
	for(int co=c-1;co<=c+1;co++)
		for(int fi=f-1;fi<=f+1;fi++)
			try{
				if((co!=c || fi!=f)
					&& (generacionActual[co][fi]==Celula.VIVA
					|| generacionActual[co][fi]==Celula.MORIBUNDA))
				cont++;			
			}
				catch(IndexOutOfBoundsException e){}		
	return cont;	
		}
	
	public Celula[][] get(){
		Celula [][] copia= new Celula[generacionActual.length][generacionActual[0].length];
		for(int i=0; i<generacionActual.length;i++)
			copia[i]=generacionActual[i].clone();
		return copia;
	}
	
	
}
