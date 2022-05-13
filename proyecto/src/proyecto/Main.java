package proyecto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
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
PanelInicio panelBuildTroops;
PanelInicio panelBuildDefenses;
private JButton[] botonesMenu1= new JButton[8];
private JButton[] botonesBuild= new JButton[12];
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

//Background Images
JLabel background;
ImageIcon img = new ImageIcon("backg.jpg");
background = new JLabel("",img,JLabel.CENTER);
background.setBounds(0, 0, ANCHO_TABLERO, ALTO_TABLERO);

JLabel backgroundBuild;
backgroundBuild = new JLabel("",img,JLabel.CENTER);
backgroundBuild.setBounds(0, 0, ANCHO_TABLERO, ALTO_TABLERO);

JLabel backgroundTroops;
ImageIcon imgBuildTroops = new ImageIcon("buildTroops.jpg");
backgroundTroops = new JLabel("",imgBuildTroops,JLabel.CENTER);
backgroundTroops.setBounds(0, 0, ANCHO_TABLERO, ALTO_TABLERO);

JLabel backgroundDefenses;
ImageIcon imgBuildDefenses = new ImageIcon("buildDefenses.jpg");
backgroundDefenses = new JLabel("",imgBuildDefenses,JLabel.CENTER);
backgroundDefenses.setBounds(0, 0, ANCHO_TABLERO, ALTO_TABLERO);
//Panel INICIAL
panel1 = new PanelInicio();
panel1.setBounds(0, 0, ANCHO_TABLERO, ALTO_TABLERO);
add(panel1);
panel1.setLayout(null);


JLabel titulo = new JLabel("ORGASM THE MOTHERFUCKING GAME", SwingConstants.CENTER);
titulo.setFont(new Font("verdana",1,35));
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
panel1.add(background);


//Panel Build
panelBuild = new PanelInicio();
panelBuild.setBounds(0, 0, ANCHO_TABLERO, ALTO_TABLERO);
add(panelBuild);
panelBuild.setLayout(null);
panelBuild.setVisible(false);


JLabel tituloBuild = new JLabel("BUILD",SwingConstants.CENTER);
panelBuild.add(tituloBuild);
tituloBuild.setBounds((ANCHO_TABLERO/2)-450, 10, 900, 70);
tituloBuild.setFont(new Font("verdana",1,35));
tituloBuild.setForeground(Color.white);

botonesBuild[0] = new JButton("Build Troops");
botonesBuild[1] = new JButton("Build Defenses");
botonesBuild[2] = new JButton("Go back");

panelBuild.add(botonesBuild[0]);
botonesBuild[0].setBounds((ANCHO_TABLERO/2)-310, 90, 300, 50);
botonesBuild[0].addActionListener(new BuildTroops());
panelBuild.add(botonesBuild[1]);
botonesBuild[1].setBounds((ANCHO_TABLERO/2)+10, 90, 300, 50);
botonesBuild[1].addActionListener(new BuildDefenses());
panelBuild.add(botonesBuild[2]);
botonesBuild[2].setBounds((ANCHO_TABLERO/2)-150, 150, 300, 50);
botonesBuild[2].setBackground(new Color(246, 90, 90));
botonesBuild[2].addActionListener(new GoBackBuild());

panelBuild.add(backgroundBuild);


//Build Troops
panelBuildTroops = new PanelInicio();
panelBuildTroops.setBounds(0, 0, ANCHO_TABLERO, ALTO_TABLERO);
add(panelBuildTroops);
panelBuildTroops.setLayout(null);
panelBuildTroops.setVisible(false);


JLabel tituloBuildTroops = new JLabel("BUILD TROOPS",SwingConstants.CENTER);
panelBuildTroops.add(tituloBuildTroops);
tituloBuildTroops.setBounds((ANCHO_TABLERO/2)-450, 10, 900, 70);
tituloBuildTroops.setFont(new Font("verdana",1,35));
tituloBuildTroops.setForeground(Color.white);

botonesBuild[3] = new JButton("Build Light Hunter");
botonesBuild[4] = new JButton("Build Heavy Hunter");
botonesBuild[5] = new JButton("Build Battle Ship");
botonesBuild[6] = new JButton("Build Armored Ship");
botonesBuild[7] = new JButton("Go back");

panelBuildTroops.add(botonesBuild[3]);
botonesBuild[3].setBounds((ANCHO_TABLERO/2)-415, 90, 200, 50);
panelBuildTroops.add(botonesBuild[4]);
botonesBuild[4].setBounds((ANCHO_TABLERO/2)-200, 90, 200, 50);
panelBuildTroops.add(botonesBuild[5]);
botonesBuild[5].setBounds((ANCHO_TABLERO/2)+15, 90, 200, 50);
panelBuildTroops.add(botonesBuild[6]);
botonesBuild[6].setBounds((ANCHO_TABLERO/2)+230, 90, 200, 50);
panelBuildTroops.add(botonesBuild[7]);
botonesBuild[7].setBounds((ANCHO_TABLERO/2)-75, 400, 150, 50);
botonesBuild[7].setBackground(new Color(246, 90, 90));
botonesBuild[7].addActionListener(new GoBackBuildTroops());
panelBuildTroops.add(backgroundTroops);
//Build Defenses
panelBuildDefenses = new PanelInicio();
panelBuildDefenses.setBounds(0, 0, ANCHO_TABLERO, ALTO_TABLERO);
add(panelBuildDefenses);
panelBuildDefenses.setLayout(null);
panelBuildDefenses.setVisible(false);


JLabel tituloBuildDefenses = new JLabel("BUILD DEFENSES",SwingConstants.CENTER);
panelBuildDefenses.add(tituloBuildDefenses);
tituloBuildDefenses.setBounds((ANCHO_TABLERO/2)-450, 10, 900, 70);
tituloBuildDefenses.setFont(new Font("verdana",1,35));
tituloBuildDefenses.setForeground(Color.white);

botonesBuild[8] = new JButton("Build Missile Launcher");
botonesBuild[9] = new JButton("Build Ion Cannon");
botonesBuild[10] = new JButton("Build Build Plasma Cannon");
botonesBuild[11] = new JButton("Go Back");


panelBuildDefenses.add(botonesBuild[8]);
botonesBuild[8].setBounds((ANCHO_TABLERO/2)-300, 90, 200, 50);
panelBuildDefenses.add(botonesBuild[9]);
botonesBuild[9].setBounds((ANCHO_TABLERO/2)-75, 90, 200, 50);
panelBuildDefenses.add(botonesBuild[10]);
botonesBuild[10].setBounds((ANCHO_TABLERO/2)+150, 90, 200, 50);
panelBuildDefenses.add(botonesBuild[11]);
botonesBuild[11].setBounds((ANCHO_TABLERO/2)-75, 400, 200, 50);
botonesBuild[11].setBackground(new Color(246, 90, 90));
botonesBuild[11].addActionListener(new GoBackBuildDefenses());
panelBuildDefenses.add(backgroundDefenses);

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
//Build
class GoBackBuild implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		panel1.setVisible(true);
		panelBuild.setVisible(false);

	}
}

class GoBackBuildTroops implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		panelBuild.setVisible(true);
		panelBuildTroops.setVisible(false);

	}
}

class GoBackBuildDefenses implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		panelBuild.setVisible(true);
		panelBuildDefenses.setVisible(false);

	}
}

class BuildTroops implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		panelBuild.setVisible(false);
		panelBuildTroops.setVisible(true);
	}
}

class BuildDefenses implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		panelBuild.setVisible(false);
		panelBuildDefenses.setVisible(true);
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