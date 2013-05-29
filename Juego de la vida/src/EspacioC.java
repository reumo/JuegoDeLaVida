import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import javax.swing.JPanel;




public class EspacioC extends JPanel implements MouseListener{
	private int ancho;
	private int alto;
	int zoom=2;
	Thread t = null;
	EspacioCelular ec;
	public EspacioC(int alto,int ancho){
		
		this.ancho=ancho;
		this.alto=alto;
		addMouseListener(this);
		ec=new EspacioCelular(ancho, alto, zoom,zoom,Patron.BLINKER);
		setPreferredSize(new java.awt.Dimension(ancho*zoom, alto*zoom));
		setBackground(Color.LIGHT_GRAY);
		
	}
	@Override
	public void paintComponent(Graphics g) {
		int altoMax=getHeight();
		int anchoMax=getWidth();
	
		for(int i=0;i<alto && i<altoMax;i++)
			for(int j=0;j<ancho && i< anchoMax;j++){
				if(ec.getCelula(i, j)==Celula.VIVA){
					g.setColor(Color.RED);
					
				}else
					g.setColor(getBackground());
				g.fillRect(j * zoom, i * zoom, zoom, zoom);
			}
		
	}
	public void siguienteGeneracion(){
		ec.siguienteGeneracion();
		repaint();
		
	}
	
	public void limpiar(){
		ec.limpiar();
		repaint();
	}
	public void aleatorio(){
		ec.limpiar();
		ec.rellenoAleatorio();
		repaint();
	}
	public void vida(){
		if (t == null){
			t = new Thread(new Runnable() {
				public void run() {
					Thread aux = Thread.currentThread();
					while (t == aux) {
						ec.siguienteGeneracion();
						repaint();
						try { Thread.sleep(30); } catch (InterruptedException e1) {}
					}
				}
			});
			t.start();
		}
		else
			t = null;
	}

	

	@Override
	public void mouseClicked(MouseEvent m) {
		
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}
	@Override
	public void mousePressed(MouseEvent m) {
		
		
		
	}
	@Override
	public void mouseReleased(MouseEvent m) {
		if(m.getButton()==m.BUTTON2)
		ec.changeEstadoCelula(m.getY()/zoom, m.getX()/zoom);
		repaint();
	}
	
	
}
