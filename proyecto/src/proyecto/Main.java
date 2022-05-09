package proyecto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.text.AbstractDocument.Content;


interface Dimensiones{
	public static int ANCHO_TABLERO = 1000;
	public static int ALTO_TABLERO = 600;
}

public class Main extends JFrame implements Dimensiones{
PanelInicio panel1;
PanelInicio panelBuild;
private JButton[] botonesMenu1= new JButton[8];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
		
	}
Main(){
setBounds(0, 0, ANCHO_TABLERO, ALTO_TABLERO);
setTitle("Orgasm");

botonesMenu1[0] = new JButton("View Planet Stats");
botonesMenu1[1] = new JButton("Build");
botonesMenu1[2] = new JButton("Upgrade Technology");
botonesMenu1[3] = new JButton("View Battle Report");
botonesMenu1[4] = new JButton("View Current Battle");
botonesMenu1[5] = new JButton("View Thread Coming");
botonesMenu1[6] = new JButton("Reset Battle History");
botonesMenu1[7] = new JButton("Exit");


panel1 = new PanelInicio();
panel1.setBounds(0, 0, ANCHO_TABLERO, ALTO_TABLERO);
add(panel1);
panel1.setBackground(new Color(41,40,78));

panel1.setLayout(null);

panelBuild = new PanelInicio();
panelBuild.setBounds(0, 0, ANCHO_TABLERO, ALTO_TABLERO);
add(panelBuild);
panelBuild.setBackground(new Color(0,255,0));

panelBuild.setLayout(null);
panelBuild.setVisible(false);

JLabel titulo = new JLabel("Orgasm the motherfucking game", SwingConstants.CENTER);
titulo.setFont(new Font("verdana",1,48));
titulo.setForeground(Color.white);

panel1.add(titulo);
titulo.setBounds((ANCHO_TABLERO/2)-450, 10, 900, 70);

panel1.add(botonesMenu1[0]);
botonesMenu1[0].setBounds((ANCHO_TABLERO/2)-150, 90, 300, 50);
panel1.add(botonesMenu1[1]);
botonesMenu1[1].setBounds((ANCHO_TABLERO/2)-150, 150, 300, 50);
botonesMenu1[1].addActionListener(new AddPanelBuild());
panel1.add(botonesMenu1[2]);
botonesMenu1[2].setBounds((ANCHO_TABLERO/2)-150, 210, 300, 50);
panel1.add(botonesMenu1[3]);
botonesMenu1[3].setBounds((ANCHO_TABLERO/2)-150, 270, 300, 50);
panel1.add(botonesMenu1[4]);
botonesMenu1[4].setEnabled(false);
botonesMenu1[4].setBounds((ANCHO_TABLERO/2)-150, 330, 300, 50);
panel1.add(botonesMenu1[5]);
botonesMenu1[5].setEnabled(false);
botonesMenu1[5].setBounds((ANCHO_TABLERO/2)-150, 390, 300, 50);
botonesMenu1[6].setBackground(new Color(201,238,80));
panel1.add(botonesMenu1[6]);
botonesMenu1[6].setBounds((ANCHO_TABLERO/2)-150, 450, 300, 50);
botonesMenu1[6].addActionListener(new ResetDatabase());
botonesMenu1[7].setBackground(new Color(246, 90, 90));
panel1.add(botonesMenu1[7]);
botonesMenu1[7].setBounds((ANCHO_TABLERO/2)-150, 510, 300, 50);
botonesMenu1[7].addActionListener(new CloseProgram());


setLocationRelativeTo(null);
setResizable(false);
setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
setVisible(true);
}

class PanelInicio extends JPanel{
	
}
class AddPanelBuild implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		panel1.setVisible(false);
		panelBuild.setVisible(true);

	}
}

class ResetDatabase implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		int reset = JOptionPane.showConfirmDialog(panel1, "¿Do you really want to reset database?");
//		if (JOptionPane.OK_OPTION == reset) {
//			resetear base de datos
//		}
	
	}
}

class CloseProgram implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		int salir = JOptionPane.showConfirmDialog(panel1, "¿Do you really want to exit?");
		if (JOptionPane.OK_OPTION == salir) {
			System.exit(0);
		}
	
	}
}
}