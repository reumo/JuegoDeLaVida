import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class JuegoVida extends JFrame implements ActionListener{
	JButton limpiar;
	JButton aleatorio;
	JButton siguiente;
	JButton vida;
	JPanel botonera;
	EspacioC ec;
	public JuegoVida(){
		super("Juego de la Vida");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		botonera = new JPanel();
		botonera.setVisible(true);
		
		limpiar = new JButton("Limpiar");
		limpiar.setVisible(true);
		limpiar.addActionListener(this);
		aleatorio = new JButton("Aleatorio");
		aleatorio.setVisible(true);
		aleatorio.addActionListener(this);
		siguiente = new JButton("Siguiente");
		siguiente.setVisible(true);
		siguiente.addActionListener(this);
		vida = new JButton("Vida");
		vida.setVisible(true);
		vida.addActionListener(this);
		add(botonera,BorderLayout.NORTH);
		ec= new EspacioC(400,800);
		add(ec,BorderLayout.CENTER);
		botonera.add(limpiar);
		botonera.add(aleatorio);
		botonera.add(siguiente);
		botonera.add(vida);
		pack();
	}
	public static void main(String[] args) {
		new JuegoVida().setVisible(true);
		

	}
	@Override
	public void actionPerformed(ActionEvent b) {
		
		if(b.getSource()==siguiente)
			ec.siguienteGeneracion();
		if(b.getSource()==limpiar)
			ec.limpiar();
		if(b.getSource()==aleatorio)
			ec.aleatorio();
		if(b.getSource()==vida){
			if(vida.getText()=="Vida")
			vida.setText("Para");
			else vida.setText("Vida");
			ec.vida();
		}
		
			
	}

}
