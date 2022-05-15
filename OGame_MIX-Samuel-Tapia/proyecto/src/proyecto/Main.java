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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.sql.SQLException;


interface Dimensiones{
	public static int ANCHO_TABLERO = 1000;
	public static int ALTO_TABLERO = 600;
}

public class Main extends JFrame implements Dimensiones{
PanelInicio panel1;
PanelInicio panelStats;
PanelInicio panelBuild;
PanelInicio panelBuildTroops;
PanelInicio panelBuildDefenses;
PanelInicio panelUpgradeTech;
PanelInicio panelBattleReport;
PanelInicio panelCurrentBattle;
PanelInicio PanelThreadComing;
private JButton[] botonesMenu1= new JButton[8];
private JButton[] botonesBuild= new JButton[12];
private JButton[] botonesTech= new JButton[3];
private JButton botonesStats= new JButton();
private JButton[] botonesReport= new JButton[3];
public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
		
	}
Main(){
Planet planetaNuestro = new Planet();
planetaNuestro.setMetal(7000);
planetaNuestro.setDeuterium(5000);

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

JLabel backgroundTech;
ImageIcon imgBuildTech = new ImageIcon("backg.jpg");
backgroundTech = new JLabel("",img,JLabel.CENTER);
backgroundTech.setBounds(0, 0, ANCHO_TABLERO, ALTO_TABLERO);

JLabel backgroundStats;
ImageIcon imgBuildStats = new ImageIcon("backg.jpg");
backgroundStats = new JLabel("",img,JLabel.CENTER);
backgroundStats.setBounds(0, 0, ANCHO_TABLERO, ALTO_TABLERO);
//Panel INICIAL
panel1 = new PanelInicio();
panel1.setBounds(0, 0, ANCHO_TABLERO, ALTO_TABLERO);
add(panel1);
panel1.setLayout(null);


JLabel titulo = new JLabel("ORGASM THE MOTHERFUCKING GAME", SwingConstants.CENTER);
titulo.setFont(new Font("Verdana",1,35));
titulo.setForeground(Color.white);



panel1.add(titulo);
titulo.setBounds((ANCHO_TABLERO/2)-450, 10, 900, 70);

panel1.add(botonesMenu1[0]);
botonesMenu1[0].setBounds((ANCHO_TABLERO/2)-150, 90, 300, 50);
botonesMenu1[0].addActionListener(new AddPanelStats());
panel1.add(botonesMenu1[1]);
botonesMenu1[1].setBounds((ANCHO_TABLERO/2)-150, 150, 300, 50);
botonesMenu1[1].addActionListener(new AddPanelBuild());
panel1.add(botonesMenu1[2]);
botonesMenu1[2].setBounds((ANCHO_TABLERO/2)-150, 210, 300, 50);
botonesMenu1[2].addActionListener(new AddPanelUpgrade());
panel1.add(botonesMenu1[3]);
botonesMenu1[3].setBounds((ANCHO_TABLERO/2)-150, 270, 300, 50);
botonesMenu1[3].addActionListener(new AddPanelReport());
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

//View Planet Stats
panelStats = new PanelInicio();
panelStats.setBounds(0, 0, ANCHO_TABLERO, ALTO_TABLERO);
add(panelStats);
panelStats.setLayout(null);
panelStats.setVisible(false);


JLabel tituloStats = new JLabel("PLANET STATS",SwingConstants.CENTER);
panelStats.add(tituloStats);
tituloStats.setBounds((ANCHO_TABLERO/2)-450, 10, 900, 70);
tituloStats.setFont(new Font("Verdana",1,35));
tituloStats.setForeground(Color.black);
JLabel planet = new JLabel();
planet.setText(planetaNuestro.printStats());
planet.setBounds((ANCHO_TABLERO/2)-75,60,400,400);
planet.setFont(new Font("Verdana",1,11));
panelStats.add(planet);
botonesMenu1[0].addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		planet.setText(planetaNuestro.printStats());
		
	}
});
botonesStats = new JButton("Go back");

panelStats.add(botonesStats);
botonesStats.setBounds((ANCHO_TABLERO/2)-150, (ALTO_TABLERO)-100, 300, 50);
botonesStats.addActionListener(new GoBackStats());
botonesStats.setBackground(new Color(246, 90, 90));
//panelStats.add(backgroundStats);

//Panel Battle Report
panelBattleReport = new PanelInicio();
panelBattleReport.setBounds(0, 0, ANCHO_TABLERO, ALTO_TABLERO);
add(panelBattleReport);
panelBattleReport.setLayout(null);
panelBattleReport.setVisible(false);


JLabel tituloReport = new JLabel("BATTLE REPORT",SwingConstants.CENTER);
panelBattleReport.add(tituloReport);
tituloReport.setBounds((ANCHO_TABLERO/2)-450, 10, 900, 70);
tituloReport.setFont(new Font("Verdana",1,35));

botonesReport[0] = new JButton("Go Back");
panelBattleReport.add(botonesReport[0]);
botonesReport[0].setBounds((ANCHO_TABLERO/2)-150, ALTO_TABLERO-100, 300, 50);
botonesReport[0].setBackground(new Color(246, 90, 90));
botonesReport[0].addActionListener(new GoBackReport());
//Panel Build
panelBuild = new PanelInicio();
panelBuild.setBounds(0, 0, ANCHO_TABLERO, ALTO_TABLERO);
add(panelBuild);
panelBuild.setLayout(null);
panelBuild.setVisible(false);


JLabel tituloBuild = new JLabel("BUILD",SwingConstants.CENTER);
panelBuild.add(tituloBuild);
tituloBuild.setBounds((ANCHO_TABLERO/2)-450, 10, 900, 70);
tituloBuild.setFont(new Font("Verdana",1,35));
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
tituloBuildTroops.setFont(new Font("Verdana",1,35));
tituloBuildTroops.setForeground(Color.white);
JLabel error3 = new JLabel("");
error3.setBounds((ANCHO_TABLERO/2)+20, 200, 900, 70);
panelBuildTroops.add(error3);
error3.setFont(new Font("Verdana",1,15));
error3.setForeground(Color.black);
JLabel error4 = new JLabel("");
error4.setBounds((ANCHO_TABLERO/2)+20, 200, 900, 70);
panelBuildTroops.add(error4);
error4.setFont(new Font("Verdana",1,15));
error4.setForeground(Color.black);
JLabel error5 = new JLabel("");
error5.setBounds((ANCHO_TABLERO/2)+20, 200, 900, 70);
panelBuildTroops.add(error5);
error5.setFont(new Font("Verdana",1,15));
error5.setForeground(Color.black);
JLabel error6 = new JLabel("");
error6.setBounds((ANCHO_TABLERO/2)+20, 200, 900, 70);
panelBuildTroops.add(error6);
error6.setFont(new Font("Verdana",1,15));
error6.setForeground(Color.black);
botonesBuild[4] = new JButton("Build Heavy Hunter");
botonesBuild[3] = new JButton("Build Light Hunter");
botonesBuild[3].addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		error4.setText("");
		error5.setText("");
		error6.setText("");
		JFrame panelDatos = new JFrame();
		String getMessage = JOptionPane.showInputDialog(panelDatos,"Lighthunters que desea construir:");
		int numLightHunters = Integer.parseInt(getMessage);
		try {
			planetaNuestro.newLightHunter(numLightHunters);
		} catch (ResourceException e1) {
			// TODO Auto-generated catch block
			error3.setText(e1.getMessage());
		}
		
	}
});

botonesBuild[4].addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		error3.setText("");
		error5.setText("");
		error6.setText("");
		JFrame panelDatos = new JFrame();
		String getMessage = JOptionPane.showInputDialog(panelDatos,"Heavyhunters que desea construir:");
		int numHeavyHunters = Integer.parseInt(getMessage);
		try {
			planetaNuestro.newHeavyHunter(numHeavyHunters);
		} catch (ResourceException e1) {
			// TODO Auto-generated catch block
			error4.setText(e1.getMessage());
		}
		
	}
});
botonesBuild[5] = new JButton("Build Battle Ship");
botonesBuild[5].addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		error3.setText("");
		error4.setText("");
		error6.setText("");
		JFrame panelDatos = new JFrame();
		String getMessage = JOptionPane.showInputDialog(panelDatos,"Battleships que desea construir:");
		int numBattleships = Integer.parseInt(getMessage);
		try {
			planetaNuestro.newBattleShip(numBattleships);
		} catch (ResourceException e1) {
			// TODO Auto-generated catch block
			error5.setText(e1.getMessage());
		}
		
	}
});
botonesBuild[6] = new JButton("Build Armored Ship");
botonesBuild[6].addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		error3.setText("");
		error4.setText("");
		error5.setText("");
		JFrame panelDatos = new JFrame();
		String getMessage = JOptionPane.showInputDialog(panelDatos,"Armoredship que desea construir:");
		int numArmoredship = Integer.parseInt(getMessage);
		try {
			planetaNuestro.newArmoredShip(numArmoredship);
		} catch (ResourceException e1) {
			// TODO Auto-generated catch block
			error6.setText(e1.getMessage());
		}
		
	}
});
botonesBuild[7] = new JButton("Go back");
botonesBuild[7].addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		error3.setText("");
		error4.setText("");
		error5.setText("");
		error6.setText("");
		
	}
});

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
tituloBuildDefenses.setFont(new Font("Verdana",1,35));
tituloBuildDefenses.setForeground(Color.white);



JLabel error8 = new JLabel("");
error8.setBounds((ANCHO_TABLERO/2)+20, 300, 900, 70);
panelBuildDefenses.add(error8);
error8.setFont(new Font("Verdana",1,15));
error8.setForeground(Color.white);
JLabel error9 = new JLabel("");
error9.setBounds((ANCHO_TABLERO/2)+20, 300, 900, 70);
panelBuildDefenses.add(error9);
error9.setFont(new Font("Verdana",1,15));
error9.setForeground(Color.white);
JLabel error10 = new JLabel("");
error10.setBounds((ANCHO_TABLERO/2)+20, 300, 900, 70);
panelBuildDefenses.add(error10);
error10.setFont(new Font("Verdana",1,15));
error10.setForeground(Color.white);
botonesBuild[8] = new JButton("Build Missile Launcher");
botonesBuild[8].addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent e) {
		error9.setText("");
		error10.setText("");
		JFrame panelDatos = new JFrame();
		String getMessage = JOptionPane.showInputDialog(panelDatos,"MissileLauncher que desea construir:");
		int numMissileLauncher = Integer.parseInt(getMessage);
		try {
			planetaNuestro.newMissileLauncher(numMissileLauncher);
		} catch (ResourceException e1) {
			// TODO Auto-generated catch block
			error8.setText(e1.getMessage());
		}
		
	}
});
botonesBuild[9] = new JButton("Build Ion Cannon");
botonesBuild[9].addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		error8.setText("");
		error10.setText("");
		JFrame panelDatos = new JFrame();
		String getMessage = JOptionPane.showInputDialog(panelDatos,"Ion Cannon que desea construir:");
		int numIonCannon = Integer.parseInt(getMessage);
		try {
			planetaNuestro.newIonCannon(numIonCannon);
		} catch (ResourceException e1) {
			// TODO Auto-generated catch block
			error9.setText(e1.getMessage());
		}
		
	}
});
botonesBuild[10] = new JButton("Build Build Plasma Cannon");
botonesBuild[10].addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		error8.setText("");
		error9.setText("");
		JFrame panelDatos = new JFrame();
		String getMessage = JOptionPane.showInputDialog(panelDatos,"Plasma Cannon que desea construir:");
		int numPlasmaCannon = Integer.parseInt(getMessage);
		try {
			planetaNuestro.newPlasmaCannon(numPlasmaCannon);
		} catch (ResourceException e1) {
			// TODO Auto-generated catch block
			error10.setText(e1.getMessage());
		}
	}
});
botonesBuild[11] = new JButton("Go Back");
botonesBuild[11].addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		error8.setText("");
		error10.setText("");
		error9.setText("");
	}
});

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
//Upgrade Tech

panelUpgradeTech = new PanelInicio();
panelUpgradeTech.setBounds(0, 0, ANCHO_TABLERO, ALTO_TABLERO);
add(panelUpgradeTech);
panelUpgradeTech.setLayout(null);
panelUpgradeTech.setVisible(false);

JLabel tituloUpgradeTech = new JLabel("UPGRADE TECHNOLOGY",SwingConstants.CENTER);
panelUpgradeTech.add(tituloUpgradeTech);
tituloUpgradeTech.setBounds((ANCHO_TABLERO/2)-450, 10, 900, 70);
tituloUpgradeTech.setFont(new Font("Verdana",1,35));
tituloUpgradeTech.setForeground(Color.white);
JLabel CantidadDeuterium = new JLabel("Deuterium resources: " + planetaNuestro.getDeuterium());
panelUpgradeTech.add(CantidadDeuterium);
CantidadDeuterium.setBounds((ANCHO_TABLERO/2)-185, 50, 900, 70);
CantidadDeuterium.setFont(new Font("Verdana",1,20));
CantidadDeuterium.setForeground(Color.white);

botonesTech[0] = new JButton("<html>Upgrade Attack Technology<br> COSTE: "+planetaNuestro.getCosteAtaque()+"</html>");
JLabel error = new JLabel("");
error.setBounds((ANCHO_TABLERO/2)-110, 290, 900, 70);
panelUpgradeTech.add(error);
error.setFont(new Font("Verdana",1,20));
error.setForeground(Color.black);
JLabel error2 = new JLabel("");
error2.setBounds((ANCHO_TABLERO/2)-110, 290, 900, 70);
panelUpgradeTech.add(error2);
error2.setFont(new Font("Verdana",1,20));
error2.setForeground(Color.black);
botonesTech[0].addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		try {
			planetaNuestro.upgradeTechnologyAttack();
			CantidadDeuterium.setText("Deuterium resources: " + planetaNuestro.getDeuterium());
			botonesTech[0].setText("<html>Upgrade Attack Technology<br> COSTE: "+planetaNuestro.getCosteAtaque()+"</html>");
			error2.setText("");
			
		} catch (ResourceException e1) {
			// TODO Auto-generated catch block
			error.setText(e1.getMessage());
		}
		
	}
});
botonesTech[1] = new JButton("<html>Upgrade Defenses Technology<br> COSTE: "+planetaNuestro.getCosteDefensa()+"</html>");

botonesTech[1].addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		try {
			planetaNuestro.upgradeTechnologyDefense();
			CantidadDeuterium.setText("Deuterium resources: " + planetaNuestro.getDeuterium());
			botonesTech[1].setText("<html>Upgrade Defenses Technology<br> COSTE: "+planetaNuestro.getCosteDefensa()+"</html>");
			error.setText("");
			
		} catch (ResourceException e2) {
			// TODO Auto-generated catch block
			error2.setText(e2.getMessage());
		}
		
	}
});
botonesTech[2] = new JButton("Go Back");
botonesTech[2].addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		error.setText("");
		error2.setText("");
		
	}
});
panelUpgradeTech.add(botonesTech[0]);
botonesTech[0].setBounds((ANCHO_TABLERO/2)-250, 150, 250, 50);
panelUpgradeTech.add(botonesTech[1]);
botonesTech[1].setBounds((ANCHO_TABLERO/2)+15, 150, 250, 50);
panelUpgradeTech.add(botonesTech[2]);
botonesTech[2].setBounds((ANCHO_TABLERO/2)-75, 400, 200, 50);
botonesTech[2].setBackground(new Color(246, 90, 90));
botonesTech[2].addActionListener(new GoBackUpgradeTech());
panelUpgradeTech.add(backgroundTech);

//View Current Battle
panelCurrentBattle= new PanelInicio();
panelCurrentBattle.setBounds(0, 0, ANCHO_TABLERO, ALTO_TABLERO);
add(panelCurrentBattle);
panelCurrentBattle.setLayout(null);
panelCurrentBattle.setVisible(false);

JLabel tituloCurrentB = new JLabel("CURRENT BATTLE",SwingConstants.CENTER);
panelCurrentBattle.add(tituloCurrentB);
tituloCurrentB.setBounds((ANCHO_TABLERO/2)-450, 10, 900, 70);
tituloCurrentB.setFont(new Font("Verdana",1,35));
tituloCurrentB.setForeground(Color.white);



//View Thread Coming
PanelThreadComing= new PanelInicio();
PanelThreadComing.setBounds(0, 0, ANCHO_TABLERO, ALTO_TABLERO);
add(PanelThreadComing);
PanelThreadComing.setLayout(null);
PanelThreadComing.setVisible(false);


JLabel tituloThreadC = new JLabel("Thread Coming",SwingConstants.CENTER);
PanelThreadComing.add(tituloThreadC);
tituloThreadC.setBounds((ANCHO_TABLERO/2)-450, 10, 900, 70);
tituloThreadC.setFont(new Font("Verdana",1,35));
tituloThreadC.setForeground(Color.white);



setLocationRelativeTo(null);
setResizable(false);
setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
setVisible(true);
}

class PanelInicio extends JPanel{

}


class AddPanelStats implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		panel1.setVisible(false);
		panelStats.setVisible(true);

	}
}

class AddPanelReport implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		panel1.setVisible(false);
		panelBattleReport.setVisible(true);

	}
}

class AddPanelBuild implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		panel1.setVisible(false);
		panelBuild.setVisible(true);

	}
}
//Go back

class GoBackStats implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		panel1.setVisible(true);
		panelStats.setVisible(false);

	}
}

class GoBackReport implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		panel1.setVisible(true);
		panelBattleReport.setVisible(false);

	}
}

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

class AddPanelUpgrade implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		panel1.setVisible(false);
		panelUpgradeTech.setVisible(true);
	}
}

class GoBackUpgradeTech implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		panel1.setVisible(true);
		panelUpgradeTech.setVisible(false);
	}
}

class ResetDatabase implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		int reset = JOptionPane.showConfirmDialog(panel1, "Â¿Do you really want to reset database?");
//		if (JOptionPane.OK_OPTION == reset) {
//			resetear base de datos
//		}
	
	}
}

class CloseProgram implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		int salir = JOptionPane.showConfirmDialog(panel1, "Â¿Do you really want to exit?");
		if (JOptionPane.OK_OPTION == salir) {
			System.exit(0);
		}
	
	}
}
}




class VariablesBBDDShips{
	
	CallableStatement cst;
	BufferedReader entrada;
	int id;
	Connection cn;
	Integer P_ID;
	String P_NAME;
	Integer P_METAL_COST;
	Integer P_CRYSTAL_COST;
	Integer P_DEUTERIUM_COST;
	Integer P_INITIALARMOR;
	Integer P_ARMOR;
	Integer P_BASEDAMAGE;
	Integer P_SPEED;
	Integer P_GENERATE_WASTINGS;
	
	
	public VariablesBBDDShips(int a){
		
        cn = null;
        
        try {
            // Carga el driver de oracle
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            
            // Conecta con la base de datos orcl con el usuario system y la contrase�a password
            //cn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.40.2:1521:orcl", "alumnoMIX4", "alumnoMIX4");
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "P@ssw0rd");
           
            
            // Llamada al procedimiento almacenado
            cst = cn.prepareCall("{call GET_SHIP (?,?,?,?,?,?,?,?,?,?)}");

            do {
                cst.setInt(1, a);
                cst.registerOutParameter(2, java.sql.Types.VARCHAR);
                cst.registerOutParameter(3, java.sql.Types.INTEGER);
                cst.registerOutParameter(4, java.sql.Types.INTEGER);
                cst.registerOutParameter(5, java.sql.Types.INTEGER);
                cst.registerOutParameter(6, java.sql.Types.INTEGER);
                cst.registerOutParameter(7, java.sql.Types.INTEGER);
                cst.registerOutParameter(8, java.sql.Types.INTEGER);
                cst.registerOutParameter(9, java.sql.Types.INTEGER);
                cst.registerOutParameter(10, java.sql.Types.INTEGER);
                cst.execute();
             


                // Se obtienen la salida del procedimineto almacenado
                P_ID = cst.getInt(1);
                P_NAME = cst.getString(2);
                P_METAL_COST = cst.getInt(3);
                P_CRYSTAL_COST = cst.getInt(4);
                P_DEUTERIUM_COST = cst.getInt(5);
                P_INITIALARMOR = cst.getInt(6);
                P_ARMOR = cst.getInt(7);
                P_BASEDAMAGE = cst.getInt(8);
                P_SPEED = cst.getInt(9);
                P_GENERATE_WASTINGS = cst.getInt(10);
//                System.out.println("P_ID: "+P_ID);
//                System.out.println("P_NAME: " + P_NAME);
//                System.out.println("P_METAL_COST: " + P_METAL_COST);
//                System.out.println("P_CRYSTAL_COST: " + P_CRYSTAL_COST);
//                System.out.println("P_DEUTERIUM_COST: " + P_DEUTERIUM_COST);
//                System.out.println("P_INITIALARMOR: " + P_INITIALARMOR);
//                System.out.println("P_ARMOR: " + P_ARMOR);
//                System.out.println("P_BASEDAMAGE: " + P_BASEDAMAGE);
//                System.out.println("P_SPEED: " + P_SPEED);
//                System.out.println("P_GENERATE_WASTINGS: " + P_GENERATE_WASTINGS);
            } while (id > 0);

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        
        }
        finally {
            try {
                cn.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
	}
	public int getCosteMetal() {
		return P_METAL_COST;
	}
	
	public int getBaseDamage() {
		return P_BASEDAMAGE;
	}
	
	public int getCosteDeuterium() {
		return P_DEUTERIUM_COST;
		
	}
	
	public int getinitialArmor() {
		return P_INITIALARMOR;
		
	}
	
	public int getActualArmor() {
		return P_ARMOR;
		
		
	}
	
	public int getGenerateWastings() {
		return P_GENERATE_WASTINGS;
		
	}
	
	
}

class VariablesBBDDDefenses{
	
	CallableStatement cst;
	BufferedReader entrada;
	int id;
	Connection cn;
	Integer P_ID;
	String P_NAME;
	Integer P_METAL_COST;
	Integer P_CRYSTAL_COST;
	Integer P_DEUTERIUM_COST;
	Integer P_INITIALARMOR;
	Integer P_ARMOR;
	Integer P_BASEDAMAGE;
	Integer P_SPEED;
	Integer P_GENERATE_WASTINGS;
	
	public VariablesBBDDDefenses(int a) {
		
		cn = null;
        
        try {
            // Carga el driver de oracle
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            
            // Conecta con la base de datos orcl con el usuario system y la contrase�a password
            //cn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.40.2:1521:orcl", "alumnoMIX4", "alumnoMIX4");
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "P@ssw0rd");
            
            // Llamada al procedimiento almacenado
            cst = cn.prepareCall("{call GET_DEFENSE (?,?,?,?,?,?,?,?,?,?)}");

            do {
                cst.setInt(1, a);
                cst.registerOutParameter(2, java.sql.Types.VARCHAR);
                cst.registerOutParameter(3, java.sql.Types.INTEGER);
                cst.registerOutParameter(4, java.sql.Types.INTEGER);
                cst.registerOutParameter(5, java.sql.Types.INTEGER);
                cst.registerOutParameter(6, java.sql.Types.INTEGER);
                cst.registerOutParameter(7, java.sql.Types.INTEGER);
                cst.registerOutParameter(8, java.sql.Types.INTEGER);
                cst.registerOutParameter(9, java.sql.Types.INTEGER);
                cst.registerOutParameter(10, java.sql.Types.INTEGER);
                cst.execute();
             
                // Se obtienen la salida del procedimineto almacenado
                P_ID = cst.getInt(1);
                P_NAME = cst.getString(2);
                P_METAL_COST = cst.getInt(3);
                P_CRYSTAL_COST = cst.getInt(4);
                P_DEUTERIUM_COST = cst.getInt(5);
                P_INITIALARMOR = cst.getInt(6);
                P_ARMOR = cst.getInt(7);
                P_BASEDAMAGE = cst.getInt(8);
                P_SPEED = cst.getInt(9);
                P_GENERATE_WASTINGS = cst.getInt(10);
//                System.out.println("P_ID: "+P_ID);
//                System.out.println("P_NAME: " + P_NAME);
//                System.out.println("P_METAL_COST: " + P_METAL_COST);
//                System.out.println("P_CRYSTAL_COST: " + P_CRYSTAL_COST);
//                System.out.println("P_DEUTERIUM_COST: " + P_DEUTERIUM_COST);
//                System.out.println("P_INITIALARMOR: " + P_INITIALARMOR);
//                System.out.println("P_ARMOR: " + P_ARMOR);
//                System.out.println("P_BASEDAMAGE: " + P_BASEDAMAGE);
//                System.out.println("P_SPEED: " + P_SPEED);
//                System.out.println("P_GENERATE_WASTINGS: " + P_GENERATE_WASTINGS);
            } while (id > 0);

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            try {
                cn.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        } 
	
		
	}
	
	public int getCosteMetal() {
		return P_METAL_COST;
	}
	
	public int getBaseDamage() {
		return P_BASEDAMAGE;
	}
	
	public int getCosteDeuterium() {
		return P_DEUTERIUM_COST;
		
	}
	
	public int getinitialArmor() {
		return P_INITIALARMOR;
		
	}
	
	public int getActualArmor() {
		return P_ARMOR;
		
		
	}
	
	public int getGenerateWastings() {
		return P_GENERATE_WASTINGS;
		
	}
	
	
	
	
}

class Planet {
	
	private int technologyDefense;
	private int technologyAtack;
	private int metal ;
	private int deuterium ;
	private int upgradeDefenseTechnologyDeuteriumCost;
	private int upgradeAttackTechnologyDeuteriumCost;
	private ArrayList<MilitaryUnit>[] army;

	private int costeDefensa = 2000;
	private int costeAtaque = 2000;
	
	public Planet() {
		super();
		army = new ArrayList[7];
		army[0] = new ArrayList<>(0);
        army[1] = new ArrayList<>(0);
        army[2] = new ArrayList<>(0);
        army[3] = new ArrayList<>(0);
        army[4] = new ArrayList<>(0);
        army[5] = new ArrayList<>(0);
        army[6] = new ArrayList<>(0);
	}
	public int getCosteAtaque() {
		return costeAtaque;
	}
	

	public void setCosteAtaque(int costeAtaque) {
		this.costeAtaque = costeAtaque;
	}

	public int getCosteDefensa() {
		return costeDefensa;
	}

	public void setCosteDefensa(int coste) {
		this.costeDefensa = coste;
	}

	public void upgradeTechnologyDefense() throws ResourceException{
		if (getTechnologyDefense() < 1) {
			setCosteDefensa(Variables.UPGRADE_BASE_DEFENSE_TECHNOLOGY_DEUTERIUM_COST);
			if (getDeuterium() >= getCosteDefensa()) {
				setTechnologyDefense(getTechnologyDefense()+1);
				setDeuterium(getDeuterium()-getCosteDefensa());
			}
			else {
				throw new ResourceException("Insufficient deuterium");
			}
		}
		
		else {
			setCosteDefensa((int)(getCosteDefensa()*0.1)+getCosteDefensa());
			if (getDeuterium() >= getCosteDefensa()) {
				setTechnologyDefense(getTechnologyDefense()+1);
				setDeuterium(getDeuterium()-getCosteDefensa());
			}
			else {
				throw new ResourceException("Insufficient deuterium");
			}
			
		}
	}
	
	public void upgradeTechnologyAttack() throws ResourceException{
		if (getTechnologyAtack() < 1) {
			setCosteAtaque(Variables.UPGRADE_BASE_ATTACK_TECHNOLOGY_DEUTERIUM_COST);
			if (getDeuterium() >= getCosteAtaque()) {
				setTechnologyAtack(getTechnologyAtack()+1);
				setDeuterium(getDeuterium()-getCosteAtaque());
			}
			else {
				throw new ResourceException("Insufficient deuterium");
			}
		}
		else {
			setCosteAtaque((int)(getCosteAtaque()*0.10)+getCosteAtaque());
			if (getDeuterium() >= getCosteAtaque()) {
				setTechnologyAtack(getTechnologyAtack()+1);
				setDeuterium(getDeuterium()-getCosteAtaque());
			}
			else {
				throw new ResourceException("Insufficient deuterium");
			}
		}
	}
	
	public void newLightHunter(int n) throws ResourceException{
		army[0] = new ArrayList<>();
		VariablesBBDDShips variablesLightHunter = new VariablesBBDDShips(1);
		int costeMetal = variablesLightHunter.getCosteMetal();
		int costeDeuterium = variablesLightHunter.getCosteDeuterium();
		int count = 0;
		int armor_plus = variablesLightHunter.getinitialArmor() + (getTechnologyDefense()*Variables.PLUS_ARMOR_LIGTHHUNTER_BY_TECHNOLOGY)*variablesLightHunter.getinitialArmor()/100;
		int damage_plus = variablesLightHunter.getBaseDamage() + (getTechnologyAtack()*Variables.PLUS_ATTACK_LIGTHHUNTER_BY_TECHNOLOGY)*variablesLightHunter.getBaseDamage()/100;
		
		while (count < n) {
			if (getMetal() >= costeMetal && getDeuterium() >= costeDeuterium) {
				//si tecnlogia es 0 blindaje y lo otro normal.
				//si tecnologia es mas grande de 0 con el plus.
				if (getTechnologyAtack() < 1) {
					army[0].add(new LightHunter());
					setMetal(getMetal()-costeMetal);
					setDeuterium(getDeuterium()-costeDeuterium);
					count = count + 1;
				}
				else {
					army[0].add(new LightHunter(armor_plus,damage_plus));
					setMetal(getMetal()-costeMetal);
					setDeuterium(getDeuterium()-costeDeuterium);
					count = count + 1;
				}
			}
			else {
				throw new ResourceException("<html>Se han creado " + count + " lanzamisiles.<br> No se han podido crear mas lanzamisiles.</html>");
			}
		}
		
		
	}
	
	public void newHeavyHunter(int n) throws ResourceException{
		army[1] = new ArrayList<>();
		VariablesBBDDShips variablesHeavyHunter = new VariablesBBDDShips(2);
		int costeMetal = variablesHeavyHunter.getCosteMetal();
		int costeDeuterium = variablesHeavyHunter.getCosteDeuterium();
		int count = 0;
		int armor_plus = variablesHeavyHunter.getinitialArmor() + (getTechnologyDefense()*Variables.PLUS_ARMOR_HEAVYHUNTER_BY_TECHNOLOGY)*variablesHeavyHunter.getinitialArmor()/100;
		int damage_plus = variablesHeavyHunter.getBaseDamage() + (getTechnologyAtack()*Variables.PLUS_ATTACK_HEAVYHUNTER_BY_TECHNOLOGY)*variablesHeavyHunter.getBaseDamage()/100;
		
		while (count < n) {
			if (getMetal() >= costeMetal && getDeuterium() >= costeDeuterium) {
				if (getTechnologyAtack() < 1) {
					army[1].add(new HeavyHunter());
					setMetal(getMetal()-costeMetal);
					setDeuterium(getDeuterium()-costeDeuterium);
					count = count + 1;
				}
				else {
					army[1].add(new HeavyHunter(armor_plus,damage_plus));
					setMetal(getMetal()-costeMetal);
					setDeuterium(getDeuterium()-costeDeuterium);
					count = count + 1;
				}
				
			}
			else {
				throw new ResourceException("<html>Se han creado " + count + " lanzamisiles.<br> No se han podido crear mas lanzamisiles.</html>");
			}
		}
		
	}
	
	public void newBattleShip(int n) throws ResourceException{
		army[2] = new ArrayList<>();
		VariablesBBDDShips variablesBattleShip = new VariablesBBDDShips(3);
		int costeMetal = variablesBattleShip.getCosteMetal();
		int costeDeuterium = variablesBattleShip.getCosteDeuterium();
		int count = 0;
		int armor_plus = variablesBattleShip.getinitialArmor() + (getTechnologyDefense()*Variables.PLUS_ARMOR_BATTLESHIP_BY_TECHNOLOGY)*variablesBattleShip.getinitialArmor()/100;
		int damage_plus = variablesBattleShip.getBaseDamage() + (getTechnologyAtack()*Variables.PLUS_ATTACK_BATTLESHIP_BY_TECHNOLOGY)*variablesBattleShip.getBaseDamage()/100;
		
		while (count < n) {
			if (getMetal() >= costeMetal && getDeuterium() >= costeDeuterium) {
				if (getTechnologyAtack() < 1) {
					army[2].add(new BattleShip());
					setMetal(getMetal()-costeMetal);
					setDeuterium(getDeuterium()-costeDeuterium);
					count = count + 1;
				}
				else {
					army[2].add(new BattleShip(armor_plus,damage_plus));
					setMetal(getMetal()-costeMetal);
					setDeuterium(getDeuterium()-costeDeuterium);
					count = count + 1;
				}
				
			}
			else {
				throw new ResourceException("<html>Se han creado " + count + " lanzamisiles.<br> No se han podido crear mas lanzamisiles.</html>");
			}
		}
		
	}
	
	public void newArmoredShip(int n) throws ResourceException{
		army[3] = new ArrayList<>();
		VariablesBBDDShips variablesArmoredShip = new VariablesBBDDShips(4);
		int costeMetal = variablesArmoredShip.getCosteMetal();
		int costeDeuterium = variablesArmoredShip.getCosteDeuterium();
		int count = 0;
		int armor_plus = variablesArmoredShip.getinitialArmor() + (getTechnologyDefense()*Variables.PLUS_ARMOR_ARMOREDSHIP_BY_TECHNOLOGY)*variablesArmoredShip.getinitialArmor()/100;
		int damage_plus = variablesArmoredShip.getBaseDamage() + (getTechnologyAtack()*Variables.PLUS_ATTACK_ARMOREDSHIP_BY_TECHNOLOGY)*variablesArmoredShip.getBaseDamage()/100;
		
		while (count < n) {
			if (getMetal() >= costeMetal && getDeuterium() >= costeDeuterium) {
				if (getTechnologyAtack() < 1) {
					army[3].add(new ArmoredShip());
					setMetal(getMetal()-costeMetal);
					setDeuterium(getDeuterium()-costeDeuterium);
					count = count + 1;
				}
				else {
					army[3].add(new ArmoredShip(armor_plus,damage_plus));
					setMetal(getMetal()-costeMetal);
					setDeuterium(getDeuterium()-costeDeuterium);
					count = count + 1;
				}
				
			}
			else {
				throw new ResourceException("<html>Se han creado " + count + " lanzamisiles.<br> No se han podido crear mas lanzamisiles.</html>");
			}
		}
		
		
	}
	
	public void newMissileLauncher(int n) throws ResourceException{
		army[4] = new ArrayList<>();
		VariablesBBDDDefenses variablesMissileLauncher = new VariablesBBDDDefenses(1);
		int costeMetal = variablesMissileLauncher.getCosteMetal();
		int costeDeuterium = variablesMissileLauncher.getCosteDeuterium();
		int count = 0;
		int armor_plus = variablesMissileLauncher.getinitialArmor() + (getTechnologyDefense()*Variables.PLUS_ARMOR_MISSILELAUNCHER_BY_TECHNOLOGY)*variablesMissileLauncher.getinitialArmor()/100;
		int damage_plus = variablesMissileLauncher.getBaseDamage() + (getTechnologyAtack()*Variables.PLUS_ATTACK_MISSILELAUNCHER_BY_TECHNOLOGY)*variablesMissileLauncher.getBaseDamage()/100;
		
		while (count < n) {
			if (getMetal() >= costeMetal && getDeuterium() >= costeDeuterium) {
				if (getTechnologyDefense() < 1) {
					army[4].add(new MissileLauncher(variablesMissileLauncher.getinitialArmor(),variablesMissileLauncher.getBaseDamage()));
					setMetal(getMetal()-costeMetal);
					setDeuterium(getDeuterium()-costeDeuterium);
					count = count + 1;
				}
				else {
					army[4].add(new MissileLauncher(armor_plus,damage_plus));
					setMetal(getMetal()-costeMetal);
					setDeuterium(getDeuterium()-costeDeuterium);
					count = count + 1;
				}
			}
			else {
				throw new ResourceException("<html>Se han creado " + count + " lanzamisiles.<br> No se han podido crear mas lanzamisiles.</html>");
			}
		}
		
		
	}
	
	public void newIonCannon(int n) throws ResourceException{
		army[5] = new ArrayList<>();
		VariablesBBDDDefenses variablesIonCannon= new VariablesBBDDDefenses(2);
		int costeMetal = variablesIonCannon.getCosteMetal();
		int costeDeuterium = variablesIonCannon.getCosteDeuterium();
		int count = 0;
		int armor_plus = variablesIonCannon.getinitialArmor() + (getTechnologyDefense()*Variables.PLUS_ARMOR_IONCANNON_BY_TECHNOLOGY)*variablesIonCannon.getinitialArmor()/100;
		int damage_plus = variablesIonCannon.getBaseDamage() + (getTechnologyAtack()*Variables.PLUS_ATTACK_IONCANNON_BY_TECHNOLOGY)*variablesIonCannon.getBaseDamage()/100;
		
		while (count < n) {
			if (getMetal() >= costeMetal && getDeuterium() >= costeDeuterium) {
				if (getTechnologyDefense() < 1) {
					army[5].add(new IonCannon(variablesIonCannon.getinitialArmor(),variablesIonCannon.getBaseDamage()));
					setMetal(getMetal()-costeMetal);
					setDeuterium(getDeuterium()-costeDeuterium);
					count = count + 1;
				}
				else {
					army[5].add(new IonCannon(armor_plus,damage_plus));
					setMetal(getMetal()-costeMetal);
					setDeuterium(getDeuterium()-costeDeuterium);
					count = count + 1;
				}
			}
			else {
				throw new ResourceException("<html>Se han creado " + count + " lanzamisiles.<br> No se han podido crear mas lanzamisiles.</html>");
			}
		}
		
	}
	
	public void newPlasmaCannon(int n) throws ResourceException{
		army[6] = new ArrayList<>();
		VariablesBBDDDefenses variablesPlasmaCannon= new VariablesBBDDDefenses(3);
		int costeMetal = variablesPlasmaCannon.getCosteMetal();
		int costeDeuterium = variablesPlasmaCannon.getCosteDeuterium();
		int count = 0;
		int armor_plus = variablesPlasmaCannon.getinitialArmor() + (getTechnologyDefense()*Variables.PLUS_ARMOR_PLASMACANNON_BY_TECHNOLOGY)*variablesPlasmaCannon.getinitialArmor()/100;
		int damage_plus = variablesPlasmaCannon.getBaseDamage() + (getTechnologyAtack()*Variables.PLUS_ATTACK_PLASMACANNON_BY_TECHNOLOGY)*variablesPlasmaCannon.getBaseDamage()/100;
		
		while (count < n) {
			if (getMetal() >= costeMetal && getDeuterium() >= costeDeuterium) {
				if (getTechnologyDefense() < 1) {
					army[6].add(new PlasmaCannon(variablesPlasmaCannon.getinitialArmor(),variablesPlasmaCannon.getBaseDamage()));
					setMetal(getMetal()-costeMetal);
					setDeuterium(getDeuterium()-costeDeuterium);
					count = count + 1;
				}
				else {
					army[6].add(new PlasmaCannon(armor_plus,damage_plus));
					setMetal(getMetal()-costeMetal);
					setDeuterium(getDeuterium()-costeDeuterium);
					count = count + 1;
				}
			}
			else {
				throw new ResourceException("<html>Se han creado " + count + " lanzamisiles.<br> No se han podido crear mas lanzamisiles.</html>");
			}
		}
		
	}
	
	public String printStats() {
		String cadena;
		cadena = "<html>TECHNOLOGY<br><br>"
			   +"Attack Technology          &nbsp;"+getTechnologyAtack()+
			  "<br>Defense Technology         &nbsp;"+getTechnologyDefense()+
			    "<br><br>DEFENSES<br><br>"
			   +"Missile Launcher           &nbsp;"+army[4].size()+"<br>"
			   +"Ion Cannon                 &nbsp;"+army[5].size()+"<br>"
			   +"Plasma Cannon              &nbsp;"+army[6].size()+"<br><br>FLEET<br><br>"
			   +"Light Hunter               &nbsp;"+army[0].size()+"<br>"
			   +"Heavy Hunter               &nbsp;"+army[1].size()+"<br>"
			   +"Battle Ship                &nbsp;"+army[2].size()+"<br>"
			   +"Armored Ship               &nbsp;"+army[3].size()+"<br><br>RESOURCES<br><br>"
			   +"Metal                      &nbsp;"+getMetal()+"<br>"
			   +"Deuterium                  &nbsp;"+getDeuterium()+"<br></html>";
		
		return cadena;
	}
	
	

	public int getTechnologyDefense() {
		return technologyDefense;
	}

	public void setTechnologyDefense(int technologyDefense) {
		this.technologyDefense = technologyDefense;
	}

	public int getTechnologyAtack() {
		return technologyAtack;
	}

	public void setTechnologyAtack(int technologyAtack) {
		this.technologyAtack = technologyAtack;
	}

	public int getMetal() {
		return metal;
	}

	public void setMetal(int metal) {
		this.metal = metal;
	}

	public int getDeuterium() {
		return deuterium;
	}

	public void setDeuterium(int deuterium) {
		this.deuterium = deuterium;
	}

	public int getUpgradeDefenseTechnologyDeuteriumCost() {
		return upgradeDefenseTechnologyDeuteriumCost;
	}

	public void setUpgradeDefenseTechnologyDeuteriumCost(int upgradeDefenseTechnologyDeuteriumCost) {
		this.upgradeDefenseTechnologyDeuteriumCost = upgradeDefenseTechnologyDeuteriumCost;
	}

	public int getUpgradeAttackTechnologyDeuteriumCost() {
		return upgradeAttackTechnologyDeuteriumCost;
	}

	public void setUpgradeAttackTechnologyDeuteriumCost(int upgradeAttackTechnologyDeuteriumCost) {
		this.upgradeAttackTechnologyDeuteriumCost = upgradeAttackTechnologyDeuteriumCost;
	}

	public ArrayList<MilitaryUnit>[] getArmy() {
		return army;
	}
	
	public int LongitudLista(ArrayList<MilitaryUnit> array){
		return array.size();
		
	}

	public void setArmy(ArrayList<MilitaryUnit>[] army) {
		this.army = army;
	}

	
		
}

class ResourceException extends Exception{

	public ResourceException() {
		super();
	}

	public ResourceException(String message) {
		super(message);
	}
}

interface MilitaryUnit{
	
	abstract int attack();
	abstract void tekeDamage(int receivedDamage);
	abstract int getActualArmor();
	abstract int getMetalCost();
	abstract int getDeuteriumCost();
	abstract int getChanceGeneratinWaste();
	abstract int getChanceAttackAgain();
	abstract void resetArmor();
	abstract int getInitialArmor();
}

abstract class Ship implements MilitaryUnit{
	
	private int armor;
	private int initialArmor;
	private int baseDamage;
	
	public int getArmor() {
		return armor;
	}
	public void setArmor(int armor) {
		this.armor = armor;
	}
	public int getInitialArmor() {
		return initialArmor;
	}
	public void setInitialArmor(int initialArmor) {
		this.initialArmor = initialArmor;
	}
	public int getBaseDamage() {
		return baseDamage;
	}
	public void setBaseDamage(int baseDamage) {
		this.baseDamage = baseDamage;
	}
	
	
	
	
}

class LightHunter extends Ship{
	
	public LightHunter(int armor,int baseDamage) {
		super();
		setArmor(armor);;
		setBaseDamage(baseDamage);
		setInitialArmor(armor);
	}
	
	public LightHunter() {
		super();
		setArmor(variablesLightHunter.getinitialArmor());
		setBaseDamage(variablesLightHunter.getBaseDamage());
		setInitialArmor(variablesLightHunter.getinitialArmor());
	}
	
	VariablesBBDDShips variablesLightHunter = new VariablesBBDDShips(1);
	
	public int getInitialArmor() {
		return variablesLightHunter.getinitialArmor();
	}

	public int attack() {
		return 80;
	}

	public void tekeDamage(int receivedDamage) {
		setArmor(variablesLightHunter.getinitialArmor()-receivedDamage);
	}

	public int getActualArmor() {
		return getArmor();
	}

	public int getMetalCost() {
		return variablesLightHunter.getCosteMetal();
	}

	public int getDeuteriumCost() {
		return variablesLightHunter.getCosteDeuterium();
	}

	public int getChanceGeneratinWaste() {
		return variablesLightHunter.getGenerateWastings();
	}

	public int getChanceAttackAgain() {
		return 3;
	}

	public void resetArmor() {
		setArmor(variablesLightHunter.getinitialArmor());
	}
}

class HeavyHunter extends Ship{
	
	
	public HeavyHunter(int armor, int baseDamage) {
		super();
		setArmor(armor);
		setBaseDamage(baseDamage);
		setInitialArmor(armor);
	}
	
	public HeavyHunter() {
		setArmor(variablesHeavyHunter.getinitialArmor());
		setBaseDamage(variablesHeavyHunter.getBaseDamage());
		setInitialArmor(variablesHeavyHunter.getinitialArmor());
	}
	
	VariablesBBDDShips variablesHeavyHunter = new VariablesBBDDShips(2);
	
	public int getInitialArmor() {
		return variablesHeavyHunter.getinitialArmor();
	}
	
	public int attack() {
		return 150;
	}

	public void tekeDamage(int receivedDamage) {
		setArmor(variablesHeavyHunter.getinitialArmor()-receivedDamage);
	}

	public int getActualArmor() {
		return getArmor();
	}

	public int getMetalCost() {
		return variablesHeavyHunter.getCosteMetal();
	}

	public int getDeuteriumCost() {
		return variablesHeavyHunter.getCosteDeuterium();
	}

	public int getChanceGeneratinWaste() {
		return variablesHeavyHunter.getGenerateWastings();
	}

	public int getChanceAttackAgain() {
		return 7;
	}

	public void resetArmor() {
		setArmor(variablesHeavyHunter.getinitialArmor());
	}
	
}

class BattleShip extends Ship{
	
	

	public BattleShip(int armor, int baseDamage) {
		super();
		setArmor(armor);
		setBaseDamage(baseDamage);
		setInitialArmor(armor);
	}
	
	public BattleShip() {
		setArmor(variablesBattleShip.getinitialArmor());
		setBaseDamage(variablesBattleShip.getBaseDamage());
		setInitialArmor(variablesBattleShip.getinitialArmor());
	}
	
	VariablesBBDDShips variablesBattleShip = new VariablesBBDDShips(3);
	
	public int getInitialArmor() {
		return variablesBattleShip.getinitialArmor();
	}

	public int attack() {
		return 1000;
	}

	public void tekeDamage(int receivedDamage) {
		setArmor(variablesBattleShip.getinitialArmor()-receivedDamage);
		
	}

	public int getActualArmor() {
		return getArmor();
	}

	public int getMetalCost() {
		return variablesBattleShip.getCosteMetal();
	}

	public int getDeuteriumCost() {
		return variablesBattleShip.getCosteDeuterium();
	}

	public int getChanceGeneratinWaste() {
		return variablesBattleShip.getGenerateWastings();
	}

	public int getChanceAttackAgain() {
		return 45;
	}

	public void resetArmor() {
		setArmor(variablesBattleShip.getinitialArmor());
	}
	
}

class ArmoredShip extends Ship{
	
	public ArmoredShip(int armor, int baseDamage) {
		super();
		setArmor(armor);
		setBaseDamage(baseDamage);
		setArmor(armor);
	}
	
	public ArmoredShip() {
		setArmor(variablesArmoredShip.getinitialArmor());
		setBaseDamage(variablesArmoredShip.getBaseDamage());
		setInitialArmor(variablesArmoredShip.getinitialArmor());
	}
	
	VariablesBBDDShips variablesArmoredShip = new VariablesBBDDShips(4);
	
	public int getInitialArmor() {
		return variablesArmoredShip.getinitialArmor();
	}
	
	public int attack() {
		return 8000;
	}

	public void tekeDamage(int receivedDamage) {
		setArmor(variablesArmoredShip.getinitialArmor()-receivedDamage);
		
	}

	public int getActualArmor() {
		return getArmor();
	}

	public int getMetalCost() {
		return variablesArmoredShip.getCosteMetal();
	}

	public int getDeuteriumCost() {
		return variablesArmoredShip.getCosteDeuterium();
	}

	public int getChanceGeneratinWaste() {
		return variablesArmoredShip.getGenerateWastings();
	}

	public int getChanceAttackAgain() {
		return 70;
	}

	public void resetArmor() {
		setArmor(variablesArmoredShip.getinitialArmor());
		
	}
	
}

abstract class Defense implements MilitaryUnit,Variables{
	
	private int armor;
	private int initialArmor;
	private int baseDamage;
	
	public int getArmor() {
		return armor;
	}
	public void setArmor(int armor) {
		this.armor = armor;
	}
	public int getInitialArmor() {
		return initialArmor;
	}
	public void setInitialArmor(int initialArmor) {
		this.initialArmor = initialArmor;
	}
	public int getBaseDamage() {
		return baseDamage;
	}
	public void setBaseDamage(int baseDamage) {
		this.baseDamage = baseDamage;
	}

}

class MissileLauncher extends Defense{

	public MissileLauncher(int armor, int baseDamage) {
		super();
		setArmor(armor);
		setBaseDamage(baseDamage);
		setInitialArmor(armor);
	}
	
	VariablesBBDDDefenses variablesMissileLauncher = new VariablesBBDDDefenses(1);
	
	public MissileLauncher() {
		setArmor(variablesMissileLauncher.getinitialArmor());
		setBaseDamage(variablesMissileLauncher.getBaseDamage());
		setInitialArmor(variablesMissileLauncher.getinitialArmor());
	}
	
	public int getInitialArmor() {
		return variablesMissileLauncher.getinitialArmor();
	}
	

	public int attack() {
		return 80;
	}

	public void tekeDamage(int receivedDamage) {
		setArmor(variablesMissileLauncher.getinitialArmor()-receivedDamage);
	}

	public int getActualArmor() {
		return getArmor();
	}

	public int getMetalCost() {
		return variablesMissileLauncher.getCosteMetal();
	}

	public int getDeuteriumCost() {
		return variablesMissileLauncher.getCosteDeuterium();
	}

	public int getChanceGeneratinWaste() {
		return variablesMissileLauncher.getGenerateWastings();
	}

	public int getChanceAttackAgain() {
		return 5;
	}

	public void resetArmor() {
		setArmor(variablesMissileLauncher.getinitialArmor());
		
	}

}

class IonCannon extends Defense{

	
	public IonCannon(int armor, int baseDamage) {
		super();
		setArmor(armor);
		setBaseDamage(baseDamage);
		setInitialArmor(armor);
	}
	
	public IonCannon() {
		setArmor(variablesIonCannon.getinitialArmor());
		setBaseDamage(variablesIonCannon.getBaseDamage());
		setInitialArmor(variablesIonCannon.getinitialArmor());
	}
	
	VariablesBBDDDefenses variablesIonCannon= new VariablesBBDDDefenses(2);

	public int getInitialArmor() {
		return variablesIonCannon.getinitialArmor();
	}
	
	
	public int attack() {
		return 250;
	}

	public void tekeDamage(int receivedDamage) {
		setArmor(variablesIonCannon.getinitialArmor()-receivedDamage);
	}

	public int getActualArmor() {
		return getArmor();
	}

	public int getMetalCost() {
		return variablesIonCannon.getCosteMetal();
	}

	public int getDeuteriumCost() {
		return variablesIonCannon.getCosteDeuterium();
	}

	public int getChanceGeneratinWaste() {
		return variablesIonCannon.getGenerateWastings();
	}

	public int getChanceAttackAgain() {
		return 12;
	}

	public void resetArmor() {
		setArmor(variablesIonCannon.getinitialArmor());
	}
	
}
class PlasmaCannon extends Defense{

	public PlasmaCannon(int armor, int baseDamage) {
		super();
		setArmor(armor);
		setBaseDamage(baseDamage);
		setInitialArmor(armor);
	}
	
	public PlasmaCannon() {
		setArmor(variablesPlasmaCannon.getinitialArmor());
		setBaseDamage(variablesPlasmaCannon.getBaseDamage());
		setInitialArmor(variablesPlasmaCannon.getinitialArmor());
	}
	
	VariablesBBDDDefenses variablesPlasmaCannon= new VariablesBBDDDefenses(3);
	
	public int getInitialArmor() {
		return variablesPlasmaCannon.getinitialArmor();
	}

	public int attack() {
		return 2000;
	}

	public void tekeDamage(int receivedDamage) {
		setArmor(variablesPlasmaCannon.getinitialArmor()-receivedDamage);
		
	}

	public int getActualArmor() {
		return getArmor();
	}

	public int getMetalCost() {
		return variablesPlasmaCannon.getActualArmor();
	}

	public int getDeuteriumCost() {
		return variablesPlasmaCannon.getCosteDeuterium();
	}

	public int getChanceGeneratinWaste() {
		return variablesPlasmaCannon.getGenerateWastings();
	}

	public int getChanceAttackAgain() {
		return 30;
	}

	public void resetArmor() {
		setArmor(variablesPlasmaCannon.getinitialArmor());
	}
}


interface Variables{
	
	// resources available to create the first enemy fleet
	public final int DEUTERIUM_BASE_ENEMY_ARMY = 26000;
	public final int METAL_BASE_ENEMY_ARMY = 180000;
	// percentage increase of resources available to create enemy fleet
	public final int ENEMY_FLEET_INCREASE = 6;
	// resources increment every minute
	public final int PLANET_DEUTERIUM_GENERATED = 1500;
	public final int PLANET_METAL_GENERATED = 5000;
	// TECHNOLOGY COST
	public final int UPGRADE_BASE_DEFENSE_TECHNOLOGY_DEUTERIUM_COST = 2000;
	public final int UPGRADE_BASE_ATTACK_TECHNOLOGY_DEUTERIUM_COST = 2000;
	public final int UPGRADE_PLUS_DEFENSE_TECHNOLOGY_DEUTERIUM_COST = 60;
	public final int UPGRADE_PLUS_ATTACK_TECHNOLOGY_DEUTERIUM_COST = 60;
	// COST SHIPS
	public final int METAL_COST_LIGTHHUNTER = 3000;
	public final int METAL_COST_HEAVYHUNTER = 6500;
	public final int METAL_COST_BATTLESHIP = 45000;
	public final int METAL_COST_ARMOREDSHIP = 30000;
	public final int DEUTERIUM_COST_LIGTHHUNTER = 50;
	public final int DEUTERIUM_COST_HEAVYHUNTER = 50;
	public final int DEUTERIUM_COST_BATTLESHIP = 7000;
	public final int DEUTERIUM_COST_ARMOREDSHIP = 15000;
	// COST DEFENSES
	public final int DEUTERIUM_COST_MISSILELAUNCHER = 0;
	public final int DEUTERIUM_COST_IONCANNON = 500;
	public final int DEUTERIUM_COST_PLASMACANNON = 5000;
	public final int METAL_COST_MISSILELAUNCHER = 2000;
	public final int METAL_COST_IONCANNON = 4000;
	public final int METAL_COST_PLASMACANNON = 50000;
	// array units costs
	public final int[] METAL_COST_UNITS = 
		{METAL_COST_LIGTHHUNTER,METAL_COST_HEAVYHUNTER,METAL_COST_BATTLESHIP,METAL_COST_ARMOREDSHIP,METAL_COST_MISSILELAUNCHER,METAL_COST_IONCANNON,
			METAL_COST_PLASMACANNON};
		public final int[] DEUTERIUM_COST_UNITS = 
		{DEUTERIUM_COST_LIGTHHUNTER,DEUTERIUM_COST_HEAVYHUNTER,DEUTERIUM_COST_BATTLESHIP,DEUTERIUM_COST_ARMOREDSHIP,DEUTERIUM_COST_MISSILELAUNCHER,
			DEUTERIUM_COST_IONCANNON,DEUTERIUM_COST_PLASMACANNON};
	//BASE DAMAGE SHIPS
	public final int BASE_DAMAGE_LIGTHHUNTER = 80;
	public final int BASE_DAMAGE_HEAVYHUNTER = 150;
	public final int BASE_DAMAGE_BATTLESHIP = 1000;
	public final int BASE_DAMAGE_ARMOREDSHIP = 700;
	// BASE DAMAGE DEFENSES
	public final int BASE_DAMAGE_MISSILELAUNCHER = 80;
	public final int BASE_DAMAGE_IONCANNON = 250;
	public final int BASE_DAMAGE_PLASMACANNON = 2000;
	// REDUCTION_DEFENSE
	public final int REDUCTION_DEFENSE_IONCANNON = 100;
	// ARMOR SHIPS
	public final int ARMOR_LIGTHHUNTER = 400;
	public final int ARMOR_HEAVYHUNTER = 1000;
	public final int ARMOR_BATTLESHIP = 6000;
	public final int ARMOR_ARMOREDSHIP = 8000;
	// ARMOR DEFENSES
	public final int ARMOR_MISSILELAUNCHER = 200;
	public final int ARMOR_IONCANNON = 1200;
	public final int ARMOR_PLASMACANNON = 7000;
	//fleet armor increase percentage per tech level 
	public final int PLUS_ARMOR_LIGTHHUNTER_BY_TECHNOLOGY = 5;
	public final int PLUS_ARMOR_HEAVYHUNTER_BY_TECHNOLOGY = 5;
	public final int PLUS_ARMOR_BATTLESHIP_BY_TECHNOLOGY = 5;
	public final int PLUS_ARMOR_ARMOREDSHIP_BY_TECHNOLOGY = 5;
	// defense armor increase percentage per tech level 
	public final int PLUS_ARMOR_MISSILELAUNCHER_BY_TECHNOLOGY = 5;
	public final int PLUS_ARMOR_IONCANNON_BY_TECHNOLOGY = 5;
	public final int PLUS_ARMOR_PLASMACANNON_BY_TECHNOLOGY = 5;
	// fleet attack power increase percentage per tech level
	public final int PLUS_ATTACK_LIGTHHUNTER_BY_TECHNOLOGY = 5;
	public final int PLUS_ATTACK_HEAVYHUNTER_BY_TECHNOLOGY = 5;
	public final int PLUS_ATTACK_BATTLESHIP_BY_TECHNOLOGY = 5;
	public final int PLUS_ATTACK_ARMOREDSHIP_BY_TECHNOLOGY = 5;
	// Defense attack power increase percentage per tech level
	public final int PLUS_ATTACK_MISSILELAUNCHER_BY_TECHNOLOGY = 5;
	public final int PLUS_ATTACK_IONCANNON_BY_TECHNOLOGY = 5;
	public final int PLUS_ATTACK_PLASMACANNON_BY_TECHNOLOGY = 5;
	// fleet probability of generating waste
	public final int CHANCE_GENERATNG_WASTE_LIGTHHUNTER = 55;
	public final int CHANCE_GENERATNG_WASTE_HEAVYHUNTER = 65;
	public final int CHANCE_GENERATNG_WASTE_BATTLESHIP = 80;
	public final int CHANCE_GENERATNG_WASTE_ARMOREDSHIP = 90;
	// Defense probability of generating waste
	public final int CHANCE_GENERATNG_WASTE_MISSILELAUNCHER = 55;
	public final int CHANCE_GENERATNG_WASTE_IONCANNON = 65;
	public final int CHANCE_GENERATNG_WASTE_PLASMACANNON = 75;
	// fleet chance to attack again
	public final int CHANCE_ATTACK_AGAIN_LIGTHHUNTER = 3;
	public final int CHANCE_ATTACK_AGAIN_HEAVYHUNTER = 7;
	public final int CHANCE_ATTACK_AGAIN_BATTLESHIP = 45;
	public final int CHANCE_ATTACK_AGAIN_ARMOREDSHIP = 70;
	//Defense chance to attack again
	public final int CHANCE_ATTACK_AGAIN_MISSILELAUNCHER = 5;
	public final int CHANCE_ATTACK_AGAIN_IONCANNON = 12;
	public final int CHANCE_ATTACK_AGAIN_PLASMACANNON = 30;
	// CHANCE ATTACK EVERY UNIT
	// LIGTHHUNTER, HEAVYHUNTER, BATTLESHIP, ARMOREDSHIP, MISSILELAUNCHER, IONCANNON, PLASMACANNON
	public final int[] CHANCE_ATTACK_PLANET_UNITS = {5,10,15,40,5,10,15};
	// LIGTHHUNTER, HEAVYHUNTER, BATTLESHIP, ARMOREDSHIP
	public final int[] CHANCE_ATTACK_ENEMY_UNITS = {10,20,30,40};
	// percentage of waste that will be generated with respect to the cost of the units
	public final int PERCENTATGE_WASTE = 70;
}