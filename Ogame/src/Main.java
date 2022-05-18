import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.sql.SQLException;

public class Main {
	
	
	public static void main(String[] args) {
		Planet miPlaneta = new Planet();
		try {
			miPlaneta.newLightHunter(12);
			miPlaneta.newIonCannon(3);
		} catch (ResourceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Battle b = new Battle();
		b.createEnemyArmy();
		b.playBattle(miPlaneta);
		System.out.println(b.getBattleDevelopment());
		System.out.println(b.battleReport(9));
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
            cn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.40.2:1521:orcl", "alumnoMIX4", "alumnoMIX4");
            //cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "P@ssw0rd");
           
            
            
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
            cn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.40.2:1521:orcl", "alumnoMIX4", "alumnoMIX4");
            //cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "P@ssw0rd");
            
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
	private int metal = 100000;
	private int deuterium = 100000;
	private int upgradeDefenseTechnologyDeuteriumCost;
	private int upgradeAttackTechnologyDeuteriumCost;
	private ArrayList<MilitaryUnit>[] army;

	private int costeDefensa;
	private int costeAtaque;
	
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
				System.out.println("Se han creado " + count + " lanzamisiles.");
				throw new ResourceException("No se han podido crear mas lanzamisiles.");
			}
		}
		System.out.println("Se han creado " + count + " lanzamisiles.");
		
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
				System.out.println("Se han creado " + count + " lazamisiles.");
				throw new ResourceException("No se han podido crear mas lanzamisiles.");
			}
		}
		System.out.println("Se han creado " + count + " lazamisiles.");
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
				System.out.println("Se han creado " + count + " lazamisiles.");
				throw new ResourceException("No se han podido crear mas lanzamisiles.");
			}
		}
		System.out.println("Se han creado " + count + " lazamisiles.");
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
				System.out.println("Se han creado " + count + " lazamisiles.");
				throw new ResourceException("No se han podido crear mas lanzamisiles.");
			}
		}
		System.out.println("Se han creado " + count + " lazamisiles.");
		
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
				System.out.println("Se han creado " + count + " lazamisiles.");
				throw new ResourceException("No se han podido crear mas lanzamisiles.");
			}
		}
		System.out.println("Se han creado " + count + " lazamisiles.");
		
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
				System.out.println("Se han creado " + count + " lazamisiles.");
				throw new ResourceException("No se han podido crear mas lanzamisiles.");
			}
		}
		System.out.println("Se han creado " + count + " lazamisiles.");
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
				System.out.println("Se han creado " + count + " lazamisiles.");
				throw new ResourceException("No se han podido crear mas lanzamisiles.");
			}
		}
		System.out.println("Se han creado " + count + " lazamisiles.");
	}
	
	public void printStats() {
		System.out.println("Planet Stats:\n\nTECHNOLOGY\n\n"
			   +"Attack Technology          "+getTechnologyAtack()+
			  "\nDefense Technology         "+getTechnologyDefense()+
			    "\n\nDEFENSES\n\n"
			   +"Missile Launcher           "+army[4].size()+"\n"
			   +"Ion Cannon                 "+army[5].size()+"\n"
			   +"Plasma Cannon              "+army[6].size()+"\n\nFLEET\n\n"
			   +"Light Hunter               "+army[0].size()+"\n"
			   +"Heavy Hunter               "+army[1].size()+"\n"
			   +"Battle Ship                "+army[2].size()+"\n"
			   +"Armored Ship               "+army[3].size()+"\n\nRESOURCES\n\n"
			   +"Metal                      "+getMetal()+"\n"
			   +"Deuterium                  "+getDeuterium()+"\n");
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
		setArmor(armor);
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
		if (getActualArmor() > 0) {
			setArmor(getActualArmor()-receivedDamage);
		}
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
		if (getActualArmor() > 0) {
			setArmor(getActualArmor()-receivedDamage);
		}
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
		if (getActualArmor() > 0) {
			setArmor(getActualArmor()-receivedDamage);
		}
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
		if (getActualArmor() > 0) {
			setArmor(getActualArmor()-receivedDamage);
		}
		
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
		if (getActualArmor() > 0) {
			setArmor(getActualArmor()-receivedDamage);
		}
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
		if (getActualArmor() > 0) {
			setArmor(getActualArmor()-receivedDamage);
		}
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
		if (getActualArmor() > 0) {
			setArmor(getActualArmor()-receivedDamage);
		}
		
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

class Battle{
	
	private ArrayList<MilitaryUnit>[] planetArmy;
	private ArrayList<MilitaryUnit>[] planetArmyDeath;
	private ArrayList<MilitaryUnit>[] enemyArmy;
	private ArrayList<MilitaryUnit>[] enemyArmyDeath;
	
	public Battle() {
		planetArmy = new ArrayList[7];
		enemyArmy = new ArrayList[4];
		enemyArmy[0] = new ArrayList<>(0);
		enemyArmy[1] = new ArrayList<>(0);
		enemyArmy[2] = new ArrayList<>(0);
		enemyArmy[3] = new ArrayList<>(0);
		planetArmyDeath = new ArrayList[7];
		planetArmyDeath[0] = new ArrayList<>(0);
		planetArmyDeath[1] = new ArrayList<>(0);
		planetArmyDeath[2] = new ArrayList<>(0);
		planetArmyDeath[3] = new ArrayList<>(0);
		planetArmyDeath[4] = new ArrayList<>(0);
		planetArmyDeath[5] = new ArrayList<>(0);
		planetArmyDeath[6] = new ArrayList<>(0);
		enemyArmyDeath = new ArrayList[4];
		enemyArmyDeath[0] = new ArrayList<>(0);
		enemyArmyDeath[1] = new ArrayList<>(0);
		enemyArmyDeath[2] = new ArrayList<>(0);
		enemyArmyDeath[3] = new ArrayList<>(0);
		
		
	}
	
	public MilitaryUnit EjercitoAtacanteEnemigo() {
		MilitaryUnit atacanteEnemigo = null;
		
		List<Integer> listaProbabilidad = Arrays.asList(1,2,2,3,3,3,4,4,4,4);
		int probabilidad = (int)((Math.random()* 10)+0);
		
		if (enemyArmy[0].size() > 0 && listaProbabilidad.get(probabilidad) == 1) {
				atacanteEnemigo = enemyArmy[0].get((int)(Math.random()*enemyArmy[0].size()));
			
			
		}
		else if (enemyArmy[1].size() > 0 && listaProbabilidad.get(probabilidad) == 2) {
				atacanteEnemigo = enemyArmy[1].get((int)(Math.random()*enemyArmy[1].size()));
		
			
		}
		else if (enemyArmy[2].size() > 0 && listaProbabilidad.get(probabilidad) == 3) {
				atacanteEnemigo = enemyArmy[2].get((int)(Math.random()*enemyArmy[2].size()));
			
			
		}
		else if (enemyArmy[3].size() > 0 && listaProbabilidad.get(probabilidad) == 4) {
				atacanteEnemigo = enemyArmy[3].get((int)(Math.random()*enemyArmy[3].size()));
			
			
		}
		if (atacanteEnemigo == null) {
			atacanteEnemigo = EjercitoAtacanteEnemigo();
		}
		return atacanteEnemigo;
	}
	
	public MilitaryUnit EjercitoDefensorEnemigo() {
		
		MilitaryUnit defensorEnemigo = null;
		
		int TotalUnidades = (enemyArmy[0].size()+enemyArmy[1].size()+enemyArmy[2].size()+enemyArmy[3].size());
		
		int probabilidadLightHunter = (int)100*(enemyArmy[0].size())/(TotalUnidades);
		int probabilidadHeavyHunter = (int)100*(enemyArmy[1].size())/(TotalUnidades);
		int probabilidadBattleShip = (int)100*(enemyArmy[2].size())/(TotalUnidades);
		int probabilidadArmoredShip = (int)100*(enemyArmy[3].size())/(TotalUnidades);
		
		int SumaTotalProbabilidades = (probabilidadLightHunter+probabilidadHeavyHunter+probabilidadBattleShip+probabilidadArmoredShip);
		
		int[] arrayProbabilidades = new int[] {probabilidadLightHunter,probabilidadHeavyHunter,probabilidadBattleShip,probabilidadArmoredShip};
		
		int numAleatorio = (int)((Math.random()* SumaTotalProbabilidades)+1);
		
			if (enemyArmy[0].size() > 0 && arrayProbabilidades[0] > numAleatorio) {
					defensorEnemigo = enemyArmy[0].get((int)(Math.random()*enemyArmy[0].size()));
				
			}
			else if (enemyArmy[1].size() > 0 && arrayProbabilidades[0] + arrayProbabilidades[1] > numAleatorio) {
					defensorEnemigo = enemyArmy[1].get((int)(Math.random()*enemyArmy[1].size()));
				
				
			}
			else if (enemyArmy[2].size() > 0 && arrayProbabilidades[0] + arrayProbabilidades[1] + arrayProbabilidades[2] > numAleatorio) {
					defensorEnemigo = enemyArmy[2].get((int)(Math.random()*enemyArmy[2].size()));
				
				
			}
			else if (enemyArmy[3].size() > 0 && arrayProbabilidades[0] + arrayProbabilidades[1] + arrayProbabilidades[2] + arrayProbabilidades[3] > numAleatorio) {
					defensorEnemigo = enemyArmy[3].get((int)(Math.random()*enemyArmy[3].size()));
				
				
			}
			if (defensorEnemigo == null) {
				defensorEnemigo = EjercitoDefensorEnemigo();
				
			}
			return defensorEnemigo;
	}
	
	public MilitaryUnit EjercitoAtacanteNuestro() { 

		int sumaProbabilidades = 5 + 10 + 15 + 40 + 5 + 10 + 15;
		
		int[] arrayProbabilidades = new int[] {5,10,15,40,5,10,15};
		
		int numAleatorio = (int)((Math.random()* sumaProbabilidades)+1);
		
		MilitaryUnit atacante = planetArmy[0].get((int)(Math.random()*planetArmy[0].size()));;
		
		if (planetArmy[0].size() > 0 && arrayProbabilidades[0] > numAleatorio) {
			atacante = planetArmy[0].get((int)(Math.random()*planetArmy[0].size()));
		}
		else if (planetArmy[1].size() > 0 && arrayProbabilidades[0] + arrayProbabilidades[1] > numAleatorio) {
			atacante = planetArmy[1].get((int)(Math.random()*planetArmy[1].size()));
		}
		else if (planetArmy[2].size() > 0 && arrayProbabilidades[0] + arrayProbabilidades[1] + arrayProbabilidades[2] > numAleatorio) {
			atacante = planetArmy[2].get((int)(Math.random()*planetArmy[2].size()));
		}
		else if (planetArmy[3].size() > 0 && arrayProbabilidades[0] + arrayProbabilidades[1] + arrayProbabilidades[2] + arrayProbabilidades[3] > numAleatorio) {
			atacante = planetArmy[3].get((int)(Math.random()*planetArmy[3].size()));
		}
		else if (planetArmy[4].size() > 0 && arrayProbabilidades[0] + arrayProbabilidades[1] + arrayProbabilidades[2] + arrayProbabilidades[3] + arrayProbabilidades[4] > numAleatorio) {
			atacante = planetArmy[4].get((int)(Math.random()*planetArmy[4].size()));
		}
		else if (planetArmy[5].size() > 0 && arrayProbabilidades[0] + arrayProbabilidades[1] + arrayProbabilidades[2] + arrayProbabilidades[3] + arrayProbabilidades[4] + arrayProbabilidades[5]> numAleatorio) {
			atacante = planetArmy[5].get((int)(Math.random()*planetArmy[5].size()));
		}
		else if (planetArmy[6].size() > 0 && arrayProbabilidades[0] + arrayProbabilidades[1] + arrayProbabilidades[2] + arrayProbabilidades[3] + arrayProbabilidades[4] + arrayProbabilidades[5] + arrayProbabilidades[6]> numAleatorio) {
			atacante = planetArmy[6].get((int)(Math.random()*planetArmy[6].size()));
		}
		if (atacante == null) {
			atacante = EjercitoAtacanteNuestro();
		}
		return atacante;
		
	}
	
	public MilitaryUnit EjercitoDefensorNuestro() {
		
		int TotalUnidades = (planetArmy[0].size()+planetArmy[1].size()+planetArmy[2].size()+planetArmy[3].size()+planetArmy[4].size()+planetArmy[5].size()+planetArmy[6].size());
		MilitaryUnit defensorNuestro = null;
		
		//si no tienes unidades, te peta divided entre 0
		int probabilidadLightHunter = (int)100*(planetArmy[0].size())/(TotalUnidades);
		int probabilidadHeavyHunter = (int)100*(planetArmy[1].size())/(TotalUnidades);
		int probabilidadBattleShip = (int)100*(planetArmy[2].size())/(TotalUnidades);
		int probabilidadArmoredShip = (int)100*(planetArmy[3].size())/(TotalUnidades);
		int probabilidadMissileLauncher = (int)100*(planetArmy[4].size())/(TotalUnidades);
		int probabilidadIonCannon = (int)100*(planetArmy[5].size())/(TotalUnidades);
		int probabilidadPlasmaCannon = (int)100*(planetArmy[6].size())/(TotalUnidades);
		
		int SumaTotalProbabilidades = (probabilidadLightHunter+probabilidadHeavyHunter+probabilidadBattleShip+probabilidadArmoredShip+probabilidadMissileLauncher+probabilidadIonCannon+probabilidadPlasmaCannon);
		
		int[] arrayProbabilidades = new int[] {probabilidadLightHunter,probabilidadHeavyHunter,probabilidadBattleShip,probabilidadArmoredShip,probabilidadMissileLauncher,probabilidadIonCannon,probabilidadPlasmaCannon};
		
		int numAleatorio = (int)((Math.random()* SumaTotalProbabilidades)+1);
		
		if (planetArmy[0].size() > 0 && arrayProbabilidades[0] > numAleatorio) {
				defensorNuestro = planetArmy[0].get((int)(Math.random()*planetArmy[0].size()));
			
			
		}
		else if (planetArmy[1].size() > 0 && arrayProbabilidades[0] + arrayProbabilidades[1] > numAleatorio) {
				defensorNuestro = planetArmy[1].get((int)(Math.random()*planetArmy[1].size()));
			
			
		}
		else if (planetArmy[2].size() > 0 && arrayProbabilidades[0] + arrayProbabilidades[1] + arrayProbabilidades[2] > numAleatorio) {
				defensorNuestro = planetArmy[2].get((int)(Math.random()*planetArmy[2].size()));
			
			
		}
		else if (planetArmy[3].size() > 0 && arrayProbabilidades[0] + arrayProbabilidades[1] + arrayProbabilidades[2] + arrayProbabilidades[3] > numAleatorio) {
				defensorNuestro = planetArmy[3].get((int)(Math.random()*planetArmy[3].size()));
			
			
		}
		else if (planetArmy[4].size() > 0 && arrayProbabilidades[0] + arrayProbabilidades[1] + arrayProbabilidades[2] + arrayProbabilidades[3] + arrayProbabilidades[4] > numAleatorio) {
				defensorNuestro = planetArmy[4].get((int)(Math.random()*planetArmy[4].size()));
			
			
		}
		else if (planetArmy[5].size() > 0 && arrayProbabilidades[0] + arrayProbabilidades[1] + arrayProbabilidades[2] + arrayProbabilidades[3] + arrayProbabilidades[4] + arrayProbabilidades[5]> numAleatorio) {
				defensorNuestro = planetArmy[5].get((int)(Math.random()*planetArmy[5].size()));
			
			
		}
		else if (planetArmy[6].size() > 0 && arrayProbabilidades[0] + arrayProbabilidades[1] + arrayProbabilidades[2] + arrayProbabilidades[3] + arrayProbabilidades[4] + arrayProbabilidades[5] + arrayProbabilidades[6]> numAleatorio) {
				defensorNuestro = planetArmy[6].get((int)(Math.random()*planetArmy[6].size()));
			
			
		}
		if (defensorNuestro == null) {
			defensorNuestro = EjercitoDefensorNuestro();
		}
		return defensorNuestro;
	}
	
	int LightHuntersEnemigoComienzo;
	int HeavyHuntersEnemigoComienzo;
	int BattleShipEnemigoComienzo;
	int ArmoredShipEnemigoComienzo;
	int LightHunterMiosComienzo;
	int HeavyHunterMiosComienzo;
	int BattleShipMiosComienzo;
	int ArmoredShipMiosComienzo;
	int MissileLauncherMiosComienzo;
	int IonCannonMiosComienzo;
	int PlasmaCannonMiosComienzo;
	int LightHuntersEnemigoFinal;
	int HeavyHuntersEnemigoFinal;
	int BattleShipEnemigoFinal;
	int ArmoredShipEnemigoFinal;
	int LightHunterMiosFinal;
	int HeavyHunterMiosFinal;
	int BattleShipMiosFinal;
	int ArmoredShipMiosFinal;
	int MissileLauncherMiosFinal;
	int IonCannonMiosFinal;
	int PlasmaCannonMiosFinal;
	int residuoDeuterio;
	int residuosMetal;
	String battle;
	
	
	
	public void playBattle(Planet miPlaneta) {
		
		planetArmy=miPlaneta.getArmy();
		boolean turnoMiplaneta = false; 
		boolean turnoPlanetaAtacante = true;
		MilitaryUnit atacanteContrario = EjercitoAtacanteEnemigo();
		MilitaryUnit defensorContrario = EjercitoDefensorEnemigo();
		MilitaryUnit atacanteMiPlaneta = EjercitoAtacanteNuestro();
		MilitaryUnit defensorMiPlaneta = EjercitoDefensorNuestro();
		int sumaEjercitoAtacante = enemyArmy[0].size() + enemyArmy[1].size() + enemyArmy[2].size() + enemyArmy[3].size();
		int sumaEjercitoDefensor = planetArmy[0].size() + planetArmy[1].size() + planetArmy[2].size() +  planetArmy[3].size() + planetArmy[4].size() + planetArmy[5].size() + planetArmy[0].size();
		int ResiduosTotalMetal = 0;
		int ResiduosTotalDeuterium = 0;
		int pararAtacante = sumaEjercitoAtacante*20/100;
		int pararDefensor = sumaEjercitoDefensor*20/100;
		boolean parar = false;
		 LightHuntersEnemigoComienzo = enemyArmy[0].size();
		 HeavyHuntersEnemigoComienzo = enemyArmy[1].size();
		 BattleShipEnemigoComienzo = enemyArmy[2].size();
		 ArmoredShipEnemigoComienzo = enemyArmy[3].size();
		 LightHunterMiosComienzo = planetArmy[0].size();
		 HeavyHunterMiosComienzo = planetArmy[1].size();
		 BattleShipMiosComienzo = planetArmy[2].size();
		 ArmoredShipMiosComienzo = planetArmy[3].size();
		 MissileLauncherMiosComienzo = planetArmy[4].size();
		 IonCannonMiosComienzo = planetArmy[5].size();
		 PlasmaCannonMiosComienzo = planetArmy[6].size();
		 LightHuntersEnemigoFinal = 0;
		 HeavyHuntersEnemigoFinal = 0;
		 BattleShipEnemigoFinal = 0;
		 ArmoredShipEnemigoFinal = 0;
		 LightHunterMiosFinal = 0;
		 HeavyHunterMiosFinal = 0;
		 BattleShipMiosFinal = 0;
		 ArmoredShipMiosFinal = 0;
		 MissileLauncherMiosFinal = 0;
		 IonCannonMiosFinal = 0;
		 PlasmaCannonMiosFinal = 0;
		
		battle = "*****CHANGE ATTACKER*****" + "\n";
		while (true) {
			sumaEjercitoAtacante = enemyArmy[0].size() + enemyArmy[1].size() + enemyArmy[2].size() + enemyArmy[3].size();
			sumaEjercitoDefensor = planetArmy[0].size() + planetArmy[1].size() + planetArmy[2].size() +  planetArmy[3].size() + planetArmy[4].size() + planetArmy[5].size() + planetArmy[0].size();
			while (turnoPlanetaAtacante == true) {
				battle = battle + "Attacks fleet enemy: " + atacanteContrario.getClass().getName() + " attacks " + defensorMiPlaneta.getClass().getName() + "\n";
				battle = battle + atacanteContrario.getClass().getName() + " generates the damage = " + atacanteContrario.attack() + "\n";
				defensorMiPlaneta.tekeDamage(atacanteContrario.attack());
				battle = battle + defensorMiPlaneta.getClass().getName() + " stays with armor = " + defensorMiPlaneta.getActualArmor() + "\n";
				int probabilidadAtacarEnemigo = (int)((Math.random()* 100)+1);
				int probabilidadRecursosNuestro = (int)((Math.random()* 100)+1);
				if (defensorMiPlaneta.getActualArmor() <= 0) {
					if (defensorMiPlaneta.getClass().getName().equals("LightHunter")) {
						if (probabilidadRecursosNuestro <= Variables.CHANCE_GENERATNG_WASTE_LIGTHHUNTER) {
							residuosMetal = defensorMiPlaneta.getMetalCost()*Variables.PERCENTATGE_WASTE/100;
							residuoDeuterio = defensorMiPlaneta.getDeuteriumCost()*Variables.PERCENTATGE_WASTE/100;
							ResiduosTotalMetal += residuosMetal;
							ResiduosTotalDeuterium += residuoDeuterio;
						}
						if (planetArmy[0].size() > 0) {
							boolean eliminado = planetArmy[0].remove(defensorMiPlaneta);
							if (eliminado) {
								planetArmyDeath[0].add(defensorMiPlaneta);
							}
							if (!eliminado) {
								planetArmyDeath[0].add(planetArmy[0].get(0));
								planetArmy[0].remove(0);
							}
							battle = battle + "Eliminado lighthunter" + "\n";
							LightHunterMiosFinal = LightHunterMiosFinal + 1;
							sumaEjercitoDefensor = sumaEjercitoDefensor - 1;
							if (sumaEjercitoAtacante <pararAtacante ) {
								parar = true;
								break;
							}
							else if (sumaEjercitoDefensor < pararDefensor) {
								parar = true;
								break;
							}
						}
						else {
							defensorMiPlaneta = EjercitoDefensorNuestro();
						}
							
						
						
					
					}
					else if (defensorMiPlaneta.getClass().getName().equals("HeavyHunter")) {
						if (probabilidadRecursosNuestro <= Variables.CHANCE_GENERATNG_WASTE_HEAVYHUNTER) {
							residuosMetal = defensorMiPlaneta.getMetalCost()*Variables.PERCENTATGE_WASTE/100;
							residuoDeuterio = defensorMiPlaneta.getDeuteriumCost()*Variables.PERCENTATGE_WASTE/100;
							ResiduosTotalMetal += residuosMetal;
							ResiduosTotalDeuterium += residuoDeuterio;
						}
						if (planetArmy[1].size() > 0) {
							boolean eliminado = planetArmy[1].remove(defensorMiPlaneta);
							if (eliminado) {
								planetArmyDeath[1].add(defensorMiPlaneta);
							}
							if (!eliminado) {
								planetArmyDeath[1].add(planetArmy[1].get(0));
								planetArmy[1].remove(0);
							}
							battle = battle + "Eliminado heavyhunter" + "\n";
							HeavyHunterMiosFinal = HeavyHunterMiosFinal + 1;
							sumaEjercitoDefensor = sumaEjercitoDefensor - 1;
							if (sumaEjercitoAtacante <pararAtacante ) {
								parar = true;
								break;
							}
							else if (sumaEjercitoDefensor < pararDefensor) {
								parar = true;
								break;
							}
						}
						else {
							defensorMiPlaneta = EjercitoDefensorNuestro();
						}
							

					}
					else if (defensorMiPlaneta.getClass().getName().equals("BattleShip")) {
						if (probabilidadRecursosNuestro <= Variables.CHANCE_GENERATNG_WASTE_BATTLESHIP) {
							residuosMetal = defensorMiPlaneta.getMetalCost()*Variables.PERCENTATGE_WASTE/100;
							residuoDeuterio = defensorMiPlaneta.getDeuteriumCost()*Variables.PERCENTATGE_WASTE/100;
							ResiduosTotalMetal += residuosMetal;
							ResiduosTotalDeuterium += residuoDeuterio;
						}
						if (planetArmy[2].size() > 0) {
							boolean eliminado = planetArmy[2].remove(defensorMiPlaneta);
							if (eliminado) {
								planetArmyDeath[2].add(defensorMiPlaneta);
							}
							if (!eliminado) {
								planetArmyDeath[2].add(planetArmy[2].get(0));
								planetArmy[2].remove(0);
							}
							battle = battle + "Eliminado battleship" + "\n";
							BattleShipMiosFinal = BattleShipMiosFinal + 1;
							sumaEjercitoDefensor = sumaEjercitoDefensor - 1;
							if (sumaEjercitoAtacante <pararAtacante ) {
								parar = true;
								break;
							}
							else if (sumaEjercitoDefensor < pararDefensor) {
								parar = true;
								break;
							}
						}
						else {
							defensorMiPlaneta = EjercitoDefensorNuestro();
						}
							
						
						
						
					}
					else if (defensorMiPlaneta.getClass().getName().equals("ArmoredShip")) {
						if (probabilidadRecursosNuestro <= Variables.CHANCE_GENERATNG_WASTE_ARMOREDSHIP) {
							residuosMetal = defensorMiPlaneta.getMetalCost()*Variables.PERCENTATGE_WASTE/100;
							residuoDeuterio = defensorMiPlaneta.getDeuteriumCost()*Variables.PERCENTATGE_WASTE/100;
							ResiduosTotalMetal += residuosMetal;
							ResiduosTotalDeuterium += residuoDeuterio;
						}
						if (planetArmy[3].size() > 0) {
							boolean eliminado = planetArmy[3].remove(defensorMiPlaneta);
							if (eliminado) {
								planetArmyDeath[3].add(defensorMiPlaneta);
							}
							if (!eliminado) {
								planetArmyDeath[3].add(planetArmy[3].get(0));
								planetArmy[3].remove(0);
							}
							battle = battle + "Eliminado armoredship" + "\n";
							ArmoredShipMiosFinal = ArmoredShipMiosFinal + 1;
							sumaEjercitoDefensor = sumaEjercitoDefensor - 1;
							if (sumaEjercitoAtacante <pararAtacante ) {
								parar = true;
								break;
							}
							else if (sumaEjercitoDefensor < pararDefensor) {
								parar = true;
								break;
							}
						}
						else {
							defensorMiPlaneta = EjercitoDefensorNuestro();
						}
							
						
						
						
						
					}
					else if (defensorMiPlaneta.getClass().getName().equals("MissileLauncher")) {
						if (probabilidadRecursosNuestro <= Variables.CHANCE_GENERATNG_WASTE_MISSILELAUNCHER) {
							residuosMetal = defensorMiPlaneta.getMetalCost()*Variables.PERCENTATGE_WASTE/100;
							residuoDeuterio = defensorMiPlaneta.getDeuteriumCost()*Variables.PERCENTATGE_WASTE/100;
							ResiduosTotalMetal += residuosMetal;
							ResiduosTotalDeuterium += residuoDeuterio;
						}
						if (planetArmy[4].size() > 0) {
							boolean eliminado = planetArmy[4].remove(defensorMiPlaneta);
							if (eliminado) {
								planetArmyDeath[4].add(defensorMiPlaneta);
							}
							if (!eliminado) {
								planetArmyDeath[4].add(planetArmy[4].get(0));
								planetArmy[4].remove(0);
							}	
							battle = battle + "Eliminado missilelauncher" + "\n";
							MissileLauncherMiosFinal = MissileLauncherMiosFinal + 1;
							sumaEjercitoDefensor = sumaEjercitoDefensor - 1;
							if (sumaEjercitoAtacante <pararAtacante ) {
								parar = true;
								break;
							}
							else if (sumaEjercitoDefensor < pararDefensor) {
								parar = true;
								break;
							}
						}
						else {
							defensorMiPlaneta = EjercitoDefensorNuestro();
						}
							
						
					}
					else if (defensorMiPlaneta.getClass().getName().equals("IonCannon")) {
						if (probabilidadRecursosNuestro <= Variables.CHANCE_GENERATNG_WASTE_IONCANNON) {
							residuosMetal = defensorMiPlaneta.getMetalCost()*Variables.PERCENTATGE_WASTE/100;
							residuoDeuterio = defensorMiPlaneta.getDeuteriumCost()*Variables.PERCENTATGE_WASTE/100;
							ResiduosTotalMetal += residuosMetal;
							ResiduosTotalDeuterium += residuoDeuterio;
						}
						if (planetArmy[5].size() > 0) {
							boolean eliminado = planetArmy[5].remove(defensorMiPlaneta);
							if (eliminado) {
								planetArmyDeath[5].add(defensorMiPlaneta);
							}
							if (!eliminado) {
								planetArmyDeath[5].add(planetArmy[5].get(0));
								planetArmy[5].remove(0);
							}
						
							battle = battle + "Eliminado ioncannon" + "\n";
							IonCannonMiosFinal = IonCannonMiosFinal + 1;
							sumaEjercitoDefensor = sumaEjercitoDefensor - 1;
							if (sumaEjercitoAtacante <pararAtacante ) {
								parar = true;
								break;
							}
							else if (sumaEjercitoDefensor < pararDefensor) {
								parar = true;
								break;
							}
						}
						else {
							defensorMiPlaneta = EjercitoDefensorNuestro();
						}
							
						
						
						
						
					}
					else if (defensorMiPlaneta.getClass().getName().equals("PlasmaCannon")) {
						if (probabilidadRecursosNuestro <= Variables.CHANCE_GENERATNG_WASTE_PLASMACANNON) {
							residuosMetal = defensorMiPlaneta.getMetalCost()*Variables.PERCENTATGE_WASTE/100;
							residuoDeuterio = defensorMiPlaneta.getDeuteriumCost()*Variables.PERCENTATGE_WASTE/100;
							ResiduosTotalMetal += residuosMetal;
							ResiduosTotalDeuterium += residuoDeuterio;
						}
						if (planetArmy[6].size() > 0) {
							boolean eliminado = planetArmy[6].remove(defensorMiPlaneta);
							if (eliminado) {
								planetArmyDeath[6].add(defensorMiPlaneta);
							}
							if (!eliminado) {
								planetArmyDeath[6].add(planetArmy[6].get(0));
								planetArmy[6].remove(0);
							}
							
							System.out.println("Eliminado plasmacannon");
							PlasmaCannonMiosFinal = PlasmaCannonMiosFinal + 1;
							sumaEjercitoDefensor = sumaEjercitoDefensor - 1;
							if (sumaEjercitoAtacante <pararAtacante ) {
								parar = true;
								break;
							}
							else if (sumaEjercitoDefensor < pararDefensor) {
								parar = true;
								break;
							}
						}
						else {
							defensorMiPlaneta = EjercitoDefensorNuestro();
						}
							
						
						
						
					}
				}
				
				if (atacanteContrario.getClass().getName().equals("LightHunter")) {
					if (probabilidadAtacarEnemigo <= Variables.CHANCE_ATTACK_AGAIN_LIGTHHUNTER) {
						defensorMiPlaneta = EjercitoDefensorNuestro();
						if (defensorMiPlaneta.getClass().getName().equals("LightHunter")) {
							if (planetArmy[0].size() > 0) {
								defensorMiPlaneta = planetArmy[0].get((int)(Math.random()*planetArmy[0].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 6)+0);
									if (planetArmy[random].size() > 0) {
										defensorMiPlaneta = planetArmy[random].get((int)(Math.random()*planetArmy[random].size()));
										break;
									}
								}
							}
							
							
								
						}
						else if (defensorMiPlaneta.getClass().getName().equals("HeavyHunter")) {
							if (planetArmy[1].size() > 0) {
								defensorMiPlaneta = planetArmy[1].get((int)(Math.random()*planetArmy[1].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 6)+0);
									if (planetArmy[random].size() > 0) {
										defensorMiPlaneta = planetArmy[random].get((int)(Math.random()*planetArmy[random].size()));
										break;
									}
								}
							}
							
						}
						else if (defensorMiPlaneta.getClass().getName().equals("BattleShip")) {
							if (planetArmy[2].size() > 0) {
								defensorMiPlaneta = planetArmy[2].get((int)(Math.random()*planetArmy[2].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 6)+0);
									if (planetArmy[random].size() > 0) {
										defensorMiPlaneta = planetArmy[random].get((int)(Math.random()*planetArmy[random].size()));
										break;
									}
								}
							}
							
						}
						else if (defensorMiPlaneta.getClass().getName().equals("ArmoredShip")) {
							if (planetArmy[3].size() > 0) {
								defensorMiPlaneta = planetArmy[3].get((int)(Math.random()*planetArmy[3].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 6)+0);
									if (planetArmy[random].size() > 0) {
										defensorMiPlaneta = planetArmy[random].get((int)(Math.random()*planetArmy[random].size()));
										break;
									}
								}
							}
	
						}
						else if (defensorMiPlaneta.getClass().getName().equals("MissileLauncher")) {
							if (planetArmy[4].size() > 0) {
								defensorMiPlaneta = planetArmy[4].get((int)(Math.random()*planetArmy[4].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 6)+0);
									if (planetArmy[random].size() > 0) {
										defensorMiPlaneta = planetArmy[random].get((int)(Math.random()*planetArmy[random].size()));
										break;
									}
								}
							}
							
						}
						else if (defensorMiPlaneta.getClass().getName().equals("IonCannon")) {
							if (planetArmy[5].size() > 0) {
								defensorMiPlaneta = planetArmy[5].get((int)(Math.random()*planetArmy[5].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 6)+0);
									if (planetArmy[random].size() > 0) {
										defensorMiPlaneta = planetArmy[random].get((int)(Math.random()*planetArmy[random].size()));
										break;
									}
								}
							}
							
						}
						else if (defensorMiPlaneta.getClass().getName().equals("PlasmaCannon")) {
							if (planetArmy[6].size() > 0) {
								defensorMiPlaneta = planetArmy[6].get((int)(Math.random()*planetArmy[6].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 6)+0);
									if (planetArmy[random].size() > 0) {
										defensorMiPlaneta = planetArmy[random].get((int)(Math.random()*planetArmy[random].size()));
										break;
									}
								}
							}
							
						}
					}
					else {
						turnoPlanetaAtacante = false;
						turnoMiplaneta = true;
						battle = battle + "*****CHANGE ATTACKER*****" + "\n";
						
						
					}

				}
				else if (atacanteContrario.getClass().getName().equals("HeavyHunter")) {
					if (probabilidadAtacarEnemigo <= Variables.CHANCE_ATTACK_AGAIN_HEAVYHUNTER) {
						defensorMiPlaneta = EjercitoDefensorNuestro();
						if (defensorMiPlaneta.getClass().getName().equals("LightHunter")) {
							if (planetArmy[0].size() > 0) {
								defensorMiPlaneta = planetArmy[0].get((int)(Math.random()*planetArmy[0].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 6)+0);
									if (planetArmy[random].size() > 0) {
										defensorMiPlaneta = planetArmy[random].get((int)(Math.random()*planetArmy[random].size()));
										break;
									}
								}
							}
							
						}
						else if (defensorMiPlaneta.getClass().getName().equals("HeavyHunter")) {
							if (planetArmy[1].size() > 0) {
								defensorMiPlaneta = planetArmy[1].get((int)(Math.random()*planetArmy[1].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 6)+0);
									if (planetArmy[random].size() > 0) {
										defensorMiPlaneta = planetArmy[random].get((int)(Math.random()*planetArmy[random].size()));
										break;
									}
								}
							}
							
						}
						else if (defensorMiPlaneta.getClass().getName().equals("BattleShip")) {
							if (planetArmy[2].size() > 0) {
								defensorMiPlaneta = planetArmy[2].get((int)(Math.random()*planetArmy[2].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 6)+0);
									if (planetArmy[random].size() > 0) {
										defensorMiPlaneta = planetArmy[random].get((int)(Math.random()*planetArmy[random].size()));
										break;
									}
								}
							}
						
						}
						else if (defensorMiPlaneta.getClass().getName().equals("ArmoredShip")) {
							if (planetArmy[3].size() > 0) {
								defensorMiPlaneta = planetArmy[3].get((int)(Math.random()*planetArmy[3].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 6)+0);
									if (planetArmy[random].size() > 0) {
										defensorMiPlaneta = planetArmy[random].get((int)(Math.random()*planetArmy[random].size()));
										break;
									}
								}
							}
							
						}
						else if (defensorMiPlaneta.getClass().getName().equals("MissileLauncher")) {
							if (planetArmy[4].size() > 0) {
								defensorMiPlaneta = planetArmy[4].get((int)(Math.random()*planetArmy[4].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 6)+0);
									if (planetArmy[random].size() > 0) {
										defensorMiPlaneta = planetArmy[random].get((int)(Math.random()*planetArmy[random].size()));
										break;
									}
								}
							}
							
						}
						else if (defensorMiPlaneta.getClass().getName().equals("IonCannon")) {
							if (planetArmy[5].size() > 0) {
								defensorMiPlaneta = planetArmy[5].get((int)(Math.random()*planetArmy[5].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 6)+0);
									if (planetArmy[random].size() > 0) {
										defensorMiPlaneta = planetArmy[random].get((int)(Math.random()*planetArmy[random].size()));
										break;
									}
								}
							}
							
						}
						else if (defensorMiPlaneta.getClass().getName().equals("PlasmaCannon")) {
							if (planetArmy[6].size() > 0) {
								defensorMiPlaneta = planetArmy[6].get((int)(Math.random()*planetArmy[6].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 6)+0);
									if (planetArmy[random].size() > 0) {
										defensorMiPlaneta = planetArmy[random].get((int)(Math.random()*planetArmy[random].size()));
										break;
									}
								}
							}
							
						}
					}
					else {
						turnoPlanetaAtacante = false;
						turnoMiplaneta = true;
						battle = battle + "*****CHANGE ATTACKER*****" + "\n";
						
					}

				}
				else if (atacanteContrario.getClass().getName().equals("BattleShip")) {
					if (probabilidadAtacarEnemigo <= Variables.CHANCE_ATTACK_AGAIN_BATTLESHIP) {
						defensorMiPlaneta = EjercitoDefensorNuestro();
						if (defensorMiPlaneta.getClass().getName().equals("LightHunter")) {
							if (planetArmy[0].size() > 0) {
								defensorMiPlaneta = planetArmy[0].get((int)(Math.random()*planetArmy[0].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 6)+0);
									if (planetArmy[random].size() > 0) {
										defensorMiPlaneta = planetArmy[random].get((int)(Math.random()*planetArmy[random].size()));
										break;
									}
								}
							}
							
						}
						else if (defensorMiPlaneta.getClass().getName().equals("HeavyHunter")) {
							if (planetArmy[1].size() > 0) {
								defensorMiPlaneta = planetArmy[1].get((int)(Math.random()*planetArmy[1].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 6)+0);
									if (planetArmy[random].size() > 0) {
										defensorMiPlaneta = planetArmy[random].get((int)(Math.random()*planetArmy[random].size()));
										break;
									}
								}
							}
							
						}
						else if (defensorMiPlaneta.getClass().getName().equals("BattleShip")) {
							if (planetArmy[2].size() > 0) {
								defensorMiPlaneta = planetArmy[2].get((int)(Math.random()*planetArmy[2].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 6)+0);
									if (planetArmy[random].size() > 0) {
										defensorMiPlaneta = planetArmy[random].get((int)(Math.random()*planetArmy[random].size()));
										break;
									}
								}
							}
							
						}
						else if (defensorMiPlaneta.getClass().getName().equals("ArmoredShip")) {
							if (planetArmy[3].size() > 0) {
								defensorMiPlaneta = planetArmy[3].get((int)(Math.random()*planetArmy[3].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 6)+0);
									if (planetArmy[random].size() > 0) {
										defensorMiPlaneta = planetArmy[random].get((int)(Math.random()*planetArmy[random].size()));
										break;
									}
								}
							}
							
						}
						else if (defensorMiPlaneta.getClass().getName().equals("MissileLauncher")) {
							if (planetArmy[4].size() > 0) {
								defensorMiPlaneta = planetArmy[4].get((int)(Math.random()*planetArmy[4].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 6)+0);
									if (planetArmy[random].size() > 0) {
										defensorMiPlaneta = planetArmy[random].get((int)(Math.random()*planetArmy[random].size()));
										break;
									}
								}
							}
							
						}
						else if (defensorMiPlaneta.getClass().getName().equals("IonCannon")) {
							if (planetArmy[5].size() > 0) {
								defensorMiPlaneta = planetArmy[5].get((int)(Math.random()*planetArmy[5].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 6)+0);
									if (planetArmy[random].size() > 0) {
										defensorMiPlaneta = planetArmy[random].get((int)(Math.random()*planetArmy[random].size()));
										break;
									}
								}
							}
							
						}
						else if (defensorMiPlaneta.getClass().getName().equals("PlasmaCannon")) {
							if (planetArmy[6].size() > 0) {
								defensorMiPlaneta = planetArmy[6].get((int)(Math.random()*planetArmy[6].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 6)+0);
									if (planetArmy[random].size() > 0) {
										defensorMiPlaneta = planetArmy[random].get((int)(Math.random()*planetArmy[random].size()));
										break;
									}
								}
							}
							
						}
					}
					else {
						turnoPlanetaAtacante = false;
						turnoMiplaneta = true;
						battle = battle + "*****CHANGE ATTACKER*****" + "\n";
						
					}

				}
				else if (atacanteContrario.getClass().getName().equals("ArmoredShip")) {
					if (probabilidadAtacarEnemigo <= Variables.CHANCE_ATTACK_AGAIN_ARMOREDSHIP) {
						defensorMiPlaneta = EjercitoDefensorNuestro();
						if (defensorMiPlaneta.getClass().getName().equals("LightHunter")) {
							if (planetArmy[0].size() > 0) {
								defensorMiPlaneta = planetArmy[0].get((int)(Math.random()*planetArmy[0].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 6)+0);
									if (planetArmy[random].size() > 0) {
										defensorMiPlaneta = planetArmy[random].get((int)(Math.random()*planetArmy[random].size()));
										break;
									}
								}
							}
							
						}
						else if (defensorMiPlaneta.getClass().getName().equals("HeavyHunter")) {
							if (planetArmy[1].size() > 0) {
								defensorMiPlaneta = planetArmy[1].get((int)(Math.random()*planetArmy[1].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 6)+0);
									if (planetArmy[random].size() > 0) {
										defensorMiPlaneta = planetArmy[random].get((int)(Math.random()*planetArmy[random].size()));
										break;
									}
								}
							}
							
						}
						else if (defensorMiPlaneta.getClass().getName().equals("BattleShip")) {
							if (planetArmy[2].size() > 0) {
								defensorMiPlaneta = planetArmy[2].get((int)(Math.random()*planetArmy[2].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 6)+0);
									if (planetArmy[random].size() > 0) {
										defensorMiPlaneta = planetArmy[random].get((int)(Math.random()*planetArmy[random].size()));
										break;
									}
								}
							}
							
						}
						else if (defensorMiPlaneta.getClass().getName().equals("ArmoredShip")) {
							if (planetArmy[3].size() > 0) {
								defensorMiPlaneta = planetArmy[3].get((int)(Math.random()*planetArmy[3].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 6)+0);
									if (planetArmy[random].size() > 0) {
										defensorMiPlaneta = planetArmy[random].get((int)(Math.random()*planetArmy[random].size()));
										break;
									}
								}
							}
							
						}
						else if (defensorMiPlaneta.getClass().getName().equals("MissileLauncher")) {
							if (planetArmy[4].size() > 0) {
								defensorMiPlaneta = planetArmy[4].get((int)(Math.random()*planetArmy[4].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 6)+0);
									if (planetArmy[random].size() > 0) {
										defensorMiPlaneta = planetArmy[random].get((int)(Math.random()*planetArmy[random].size()));
										break;
									}
								}
							}
							
						}
						else if (defensorMiPlaneta.getClass().getName().equals("IonCannon")) {
							if (planetArmy[5].size() > 0) {
								defensorMiPlaneta = planetArmy[5].get((int)(Math.random()*planetArmy[5].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 6)+0);
									if (planetArmy[random].size() > 0) {
										defensorMiPlaneta = planetArmy[random].get((int)(Math.random()*planetArmy[random].size()));
										break;
									}
								}
							}
							
						}
						else if (defensorMiPlaneta.getClass().getName().equals("PlasmaCannon")) {
							if (planetArmy[6].size() > 0) {
								defensorMiPlaneta = planetArmy[6].get((int)(Math.random()*planetArmy[6].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 6)+0);
									if (planetArmy[random].size() > 0) {
										defensorMiPlaneta = planetArmy[random].get((int)(Math.random()*planetArmy[random].size()));
										break;
									}
								}
							}
							
						}
					}
					else {
						turnoPlanetaAtacante = false;
						turnoMiplaneta = true;
						battle = battle + "*****CHANGE ATTACKER*****" + "\n";
						
					}

				}
				
			}
			while (turnoMiplaneta == true) {
				sumaEjercitoAtacante = enemyArmy[0].size() + enemyArmy[1].size() + enemyArmy[2].size() + enemyArmy[3].size();
				sumaEjercitoDefensor = planetArmy[0].size() + planetArmy[1].size() + planetArmy[2].size() +  planetArmy[3].size() + planetArmy[4].size() + planetArmy[5].size() + planetArmy[0].size();
				battle = battle + "Attacks Planet enemy: " + atacanteMiPlaneta.getClass().getName() + " attacks " + defensorContrario.getClass().getName() + "\n";
				battle = battle + atacanteMiPlaneta.getClass().getName() + " generates the damage = " + atacanteMiPlaneta.attack() + "\n";
				defensorContrario.tekeDamage(atacanteMiPlaneta.attack());
				battle = battle + defensorContrario.getClass().getName() + " stays with armor = " + defensorContrario.getActualArmor() + "\n";
				int probabilidadAtacarNuestro = (int)((Math.random()* 100)+1);
				int probabilidadRecursosEnemigo = (int)((Math.random()* 100)+1);
				if (defensorContrario.getActualArmor() <= 0) {
					if (defensorContrario.getClass().getName().equals("LightHunter")) {

						if (enemyArmy[0].size() > 0) {
							boolean eliminado = enemyArmy[0].remove(defensorContrario);
							if (eliminado) {
								enemyArmyDeath[0].add(defensorContrario);
							}
							if (!eliminado) {
								enemyArmyDeath[0].add(enemyArmy[0].get(0));
								enemyArmy[0].remove(0);
							}
							battle = battle + "Eliminado lighthunter" + "\n";
							LightHuntersEnemigoFinal = LightHuntersEnemigoFinal + 1;
							sumaEjercitoAtacante = sumaEjercitoAtacante - 1;
							if (sumaEjercitoAtacante < pararAtacante) {
								parar = true;
								break;
							}
							else if (sumaEjercitoDefensor < pararDefensor) {
								parar = true;
								break;
							}
						}
						else {
							defensorContrario = EjercitoDefensorEnemigo();
						}
							
					}
					else if (defensorContrario.getClass().getName().equals("HeavyHunter")) {

						if (enemyArmy[1].size() > 0) {
							boolean eliminado = enemyArmy[1].remove(defensorContrario);
							if (eliminado) {
								enemyArmyDeath[1].add(defensorContrario);
							}
							if (!eliminado) {
								enemyArmyDeath[1].add(enemyArmy[1].get(0));
								enemyArmy[1].remove(0);
							}
							
							battle = battle + "Eliminado heavyhunter" + "\n";
							HeavyHuntersEnemigoFinal = HeavyHuntersEnemigoFinal + 1;
							sumaEjercitoAtacante = sumaEjercitoAtacante - 1;
							if (sumaEjercitoAtacante < pararAtacante) {
								parar = true;
								break;
							}
							else if (sumaEjercitoDefensor < pararDefensor) {
								parar = true;
								break;
							}
						}
						else {
							defensorContrario = EjercitoDefensorEnemigo();
						}
							
						
					}
					else if (defensorContrario.getClass().getName().equals("BattleShip")) {

						if (enemyArmy[2].size() > 0) {
							boolean eliminado = enemyArmy[2].remove(defensorContrario);
							if (eliminado) {
								enemyArmyDeath[2].add(defensorContrario);
							}
							if (!eliminado) {
								enemyArmyDeath[2].add(enemyArmy[2].get(0));
								enemyArmy[2].remove(0);
							}
							battle = battle + "Eliminado battleship" + "\n";
							BattleShipEnemigoFinal = BattleShipEnemigoFinal + 1;
							sumaEjercitoAtacante = sumaEjercitoAtacante - 1;
							if (sumaEjercitoAtacante < pararAtacante) {
								parar = true;
								break;
							}
							else if (sumaEjercitoDefensor < pararDefensor) {
								parar = true;
								break;
							}
						}
						else {
							defensorContrario = EjercitoDefensorEnemigo();
						}
						
						
						
					}
					else if (defensorContrario.getClass().getName().equals("ArmoredShip")) {

						if (enemyArmy[3].size() > 0) {
							boolean eliminado = enemyArmy[3].remove(defensorContrario);
							if (eliminado) {
								enemyArmyDeath[3].add(defensorContrario);
							}
							if (!eliminado) {
								enemyArmyDeath[3].add(enemyArmy[3].get(0));
								enemyArmy[3].remove(0);
							}
							battle = battle + "Eliminado armoredship" + "\n";
							ArmoredShipEnemigoFinal = ArmoredShipEnemigoFinal + 1;
							sumaEjercitoAtacante = sumaEjercitoAtacante - 1;
							if (sumaEjercitoAtacante < pararAtacante) {
								parar = true;
								break;
							}
							else if (sumaEjercitoDefensor < pararDefensor) {
								parar = true;
								break;
							}
						}
						else {
							defensorContrario = EjercitoDefensorEnemigo();
						}
							
						
						
						
					}
					
				}
				
				if (atacanteMiPlaneta.getClass().getName().equals("LightHunter")) {
					if (probabilidadAtacarNuestro <= Variables.CHANCE_ATTACK_AGAIN_LIGTHHUNTER) {
						defensorContrario = EjercitoDefensorEnemigo();
						if (defensorContrario.getClass().getName().equals("LightHunter")) {
							if (enemyArmy[0].size() > 0) {
								defensorContrario = enemyArmy[0].get((int)(Math.random()*enemyArmy[0].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 3)+0);
									if (enemyArmy[random].size() > 0) {
										defensorContrario = enemyArmy[random].get((int)(Math.random()*enemyArmy[random].size()));
										break;
									}
								}
							}
							
							
								
						}
						else if (defensorContrario.getClass().getName().equals("HeavyHunter")) {
							if (enemyArmy[1].size() > 0) {
								defensorContrario = enemyArmy[1].get((int)(Math.random()*enemyArmy[1].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 3)+0);
									if (enemyArmy[random].size() > 0) {
										defensorContrario = enemyArmy[random].get((int)(Math.random()*enemyArmy[random].size()));
										break;
									}
								}
							}
							
						}
						else if (defensorContrario.getClass().getName().equals("BattleShip")) {
							if (enemyArmy[2].size() > 0) {
								defensorContrario = enemyArmy[2].get((int)(Math.random()*enemyArmy[2].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 3)+0);
									if (enemyArmy[random].size() > 0) {
										defensorContrario = enemyArmy[random].get((int)(Math.random()*enemyArmy[random].size()));
										break;
									}
								}
							}
							
						}
						else if (defensorContrario.getClass().getName().equals("ArmoredShip")) {
							if (enemyArmy[3].size() > 0) {
								defensorContrario = enemyArmy[3].get((int)(Math.random()*enemyArmy[3].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 3)+0);
									if (enemyArmy[random].size() > 0) {
										defensorContrario = enemyArmy[random].get((int)(Math.random()*enemyArmy[random].size()));
										break;
									}
								}
							}
						}
					}
					else {
						turnoMiplaneta = false;
						turnoPlanetaAtacante = true;
						battle = battle + "*****CHANGE ATTACKER*****" + "\n";
					}
						
				}
				else if (atacanteMiPlaneta.getClass().getName().equals("HeavyHunter")) {
					if (probabilidadAtacarNuestro <= Variables.CHANCE_ATTACK_AGAIN_HEAVYHUNTER) {
						defensorContrario = EjercitoDefensorEnemigo();
						if (defensorContrario.getClass().getName().equals("LightHunter")) {
							if (enemyArmy[0].size() > 0) {
								defensorContrario = enemyArmy[0].get((int)(Math.random()*enemyArmy[0].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 3)+0);
									if (enemyArmy[random].size() > 0) {
										defensorContrario = enemyArmy[random].get((int)(Math.random()*enemyArmy[random].size()));
										break;
									}
								}
							}
							
						}
						else if (defensorContrario.getClass().getName().equals("HeavyHunter")) {
							if (enemyArmy[1].size() > 0) {
								defensorContrario = enemyArmy[1].get((int)(Math.random()*enemyArmy[1].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 3)+0);
									if (enemyArmy[random].size() > 0) {
										defensorContrario = enemyArmy[random].get((int)(Math.random()*enemyArmy[random].size()));
										break;
									}
								}
							}
							
						}
						else if (defensorContrario.getClass().getName().equals("BattleShip")) {
							if (enemyArmy[2].size() > 0) {
								defensorContrario = enemyArmy[2].get((int)(Math.random()*enemyArmy[2].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 3)+0);
									if (enemyArmy[random].size() > 0) {
										defensorContrario = enemyArmy[random].get((int)(Math.random()*enemyArmy[random].size()));
										break;
									}
								}
							}
						
						}
						else if (defensorContrario.getClass().getName().equals("ArmoredShip")) {
							if (enemyArmy[3].size() > 0) {
								defensorContrario = enemyArmy[3].get((int)(Math.random()*enemyArmy[3].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 3)+0);
									if (enemyArmy[random].size() > 0) {
										defensorContrario = enemyArmy[random].get((int)(Math.random()*enemyArmy[random].size()));
										break;
									}
								}
							}
							
						}
					}
					else {
						turnoMiplaneta = false;
						turnoPlanetaAtacante = true;
						battle = battle + "*****CHANGE ATTACKER*****" + "\n";
						
					}

				}
				else if (atacanteMiPlaneta.getClass().getName().equals("BattleShip")) {
					if (probabilidadAtacarNuestro <= Variables.CHANCE_ATTACK_AGAIN_BATTLESHIP) {
						defensorContrario = EjercitoDefensorEnemigo();
						if (defensorContrario.getClass().getName().equals("LightHunter")) {
							if (enemyArmy[0].size() > 0) {
								defensorContrario = enemyArmy[0].get((int)(Math.random()*enemyArmy[0].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 3)+0);
									if (enemyArmy[random].size() > 0) {
										defensorContrario = enemyArmy[random].get((int)(Math.random()*enemyArmy[random].size()));
										break;
									}
								}
							}
							
						}
						else if (defensorContrario.getClass().getName().equals("HeavyHunter")) {
							if (enemyArmy[1].size() > 0) {
								defensorContrario = enemyArmy[1].get((int)(Math.random()*enemyArmy[1].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 3)+0);
									if (enemyArmy[random].size() > 0) {
										defensorContrario = enemyArmy[random].get((int)(Math.random()*enemyArmy[random].size()));
										break;
									}
								}
							}
							
						}
						else if (defensorContrario.getClass().getName().equals("BattleShip")) {
							if (enemyArmy[2].size() > 0) {
								defensorContrario = enemyArmy[2].get((int)(Math.random()*enemyArmy[2].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 3)+0);
									if (enemyArmy[random].size() > 0) {
										defensorContrario = enemyArmy[random].get((int)(Math.random()*enemyArmy[random].size()));
										break;
									}
								}
							}
							
						}
						else if (defensorContrario.getClass().getName().equals("ArmoredShip")) {
							if (enemyArmy[3].size() > 0) {
								defensorContrario = enemyArmy[3].get((int)(Math.random()*enemyArmy[3].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 3)+0);
									if (enemyArmy[random].size() > 0) {
										defensorContrario = enemyArmy[random].get((int)(Math.random()*enemyArmy[random].size()));
										break;
									}
								}
							}
						}
					}
					else {
						turnoMiplaneta = false;
						turnoPlanetaAtacante = true;
						battle = battle + "*****CHANGE ATTACKER*****" + "\n";
						
					}

				}
				else if (atacanteMiPlaneta.getClass().getName().equals("ArmoredShip")) {
					if (probabilidadAtacarNuestro <= Variables.CHANCE_ATTACK_AGAIN_ARMOREDSHIP) {
						defensorContrario = EjercitoDefensorEnemigo();
						if (defensorContrario.getClass().getName().equals("LightHunter")) {
							if (enemyArmy[0].size() > 0) {
								defensorContrario = enemyArmy[0].get((int)(Math.random()*enemyArmy[0].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 3)+0);
									if (enemyArmy[random].size() > 0) {
										defensorContrario = enemyArmy[random].get((int)(Math.random()*enemyArmy[random].size()));
										break;
									}
								}
							}
							
						}
						else if (defensorContrario.getClass().getName().equals("HeavyHunter")) {
							if (enemyArmy[1].size() > 0) {
								defensorContrario = enemyArmy[1].get((int)(Math.random()*enemyArmy[1].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 3)+0);
									if (enemyArmy[random].size() > 0) {
										defensorContrario = enemyArmy[random].get((int)(Math.random()*enemyArmy[random].size()));
										break;
									}
								}
							}
							
						}
						else if (defensorContrario.getClass().getName().equals("BattleShip")) {
							if (enemyArmy[2].size() > 0) {
								defensorContrario = enemyArmy[2].get((int)(Math.random()*enemyArmy[2].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 3)+0);
									if (enemyArmy[random].size() > 0) {
										defensorContrario = enemyArmy[random].get((int)(Math.random()*enemyArmy[random].size()));
										break;
									}
								}
							}
							
						}
						else if (defensorContrario.getClass().getName().equals("ArmoredShip")) {
							if (enemyArmy[3].size() > 0) {
								defensorContrario = enemyArmy[3].get((int)(Math.random()*enemyArmy[3].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 3)+0);
									if (enemyArmy[random].size() > 0) {
										defensorContrario = enemyArmy[random].get((int)(Math.random()*enemyArmy[random].size()));
										break;
									}
								}
							}
							
						}
					}
					else {
						turnoMiplaneta = false;
						turnoPlanetaAtacante = true;
						battle = battle + "*****CHANGE ATTACKER*****" + "\n";
						
					}

				}
				else if (atacanteMiPlaneta.getClass().getName().equals("MissileLauncher")){
					if (probabilidadAtacarNuestro <= Variables.CHANCE_ATTACK_AGAIN_MISSILELAUNCHER) {
						defensorContrario = EjercitoDefensorEnemigo();
						if (defensorContrario.getClass().getName().equals("LightHunter")) {
							if (enemyArmy[0].size() > 0) {
								defensorContrario = enemyArmy[0].get((int)(Math.random()*enemyArmy[0].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 3)+0);
									if (enemyArmy[random].size() > 0) {
										defensorContrario = enemyArmy[random].get((int)(Math.random()*enemyArmy[random].size()));
										break;
									}
								}
							}
							
						}
						else if (defensorContrario.getClass().getName().equals("HeavyHunter")) {
							if (enemyArmy[1].size() > 0) {
								defensorContrario = enemyArmy[1].get((int)(Math.random()*enemyArmy[1].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 3)+0);
									if (enemyArmy[random].size() > 0) {
										defensorContrario = enemyArmy[random].get((int)(Math.random()*enemyArmy[random].size()));
										break;
									}
								}
							}
							
						}
						else if (defensorContrario.getClass().getName().equals("BattleShip")) {
							if (enemyArmy[2].size() > 0) {
								defensorContrario = enemyArmy[2].get((int)(Math.random()*enemyArmy[2].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 3)+0);
									if (enemyArmy[random].size() > 0) {
										defensorContrario = enemyArmy[random].get((int)(Math.random()*enemyArmy[random].size()));
										break;
									}
								}
							}
							
						}
						else if (defensorContrario.getClass().getName().equals("ArmoredShip")) {
							if (enemyArmy[3].size() > 0) {
								defensorContrario = enemyArmy[3].get((int)(Math.random()*enemyArmy[3].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 3)+0);
									if (enemyArmy[random].size() > 0) {
										defensorContrario = enemyArmy[random].get((int)(Math.random()*enemyArmy[random].size()));
										break;
									}
								}
							}
							
						}
					}
					else {
						turnoMiplaneta = false;
						turnoPlanetaAtacante = true;
						battle = battle + "*****CHANGE ATTACKER*****" + "\n";
						
					}
				}
				else if (atacanteMiPlaneta.getClass().getName().equals("IonCannon")) {
					if (probabilidadAtacarNuestro <= Variables.CHANCE_ATTACK_AGAIN_IONCANNON) {
						defensorContrario = EjercitoDefensorEnemigo();
						if (defensorContrario.getClass().getName().equals("LightHunter")) {
							if (enemyArmy[0].size() > 0) {
								defensorContrario = enemyArmy[0].get((int)(Math.random()*enemyArmy[0].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 3)+0);
									if (enemyArmy[random].size() > 0) {
										defensorContrario = enemyArmy[random].get((int)(Math.random()*enemyArmy[random].size()));
										break;
									}
								}
							}
							
						}
						else if (defensorContrario.getClass().getName().equals("HeavyHunter")) {
							if (enemyArmy[1].size() > 0) {
								defensorContrario = enemyArmy[1].get((int)(Math.random()*enemyArmy[1].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 3)+0);
									if (enemyArmy[random].size() > 0) {
										defensorContrario = enemyArmy[random].get((int)(Math.random()*enemyArmy[random].size()));
										break;
									}
								}
							}
							
						}
						else if (defensorContrario.getClass().getName().equals("BattleShip")) {
							if (enemyArmy[2].size() > 0) {
								defensorContrario = enemyArmy[2].get((int)(Math.random()*enemyArmy[2].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 3)+0);
									if (enemyArmy[random].size() > 0) {
										defensorContrario = enemyArmy[random].get((int)(Math.random()*enemyArmy[random].size()));
										break;
									}
								}
							}
							
						}
						else if (defensorContrario.getClass().getName().equals("ArmoredShip")) {
							if (enemyArmy[3].size() > 0) {
								defensorContrario = enemyArmy[3].get((int)(Math.random()*enemyArmy[3].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 3)+0);
									if (enemyArmy[random].size() > 0) {
										defensorContrario = enemyArmy[random].get((int)(Math.random()*enemyArmy[random].size()));
										break;
									}
								}
							}
							
						}
					}
					else {
						turnoMiplaneta = false;
						turnoPlanetaAtacante = true;
						battle = battle + "*****CHANGE ATTACKER*****" + "\n";
						
					}
				}
				else if (atacanteMiPlaneta.getClass().getName().equals("PlasmaCannon")) {
					if (probabilidadAtacarNuestro <= Variables.CHANCE_ATTACK_AGAIN_PLASMACANNON) {
						defensorContrario = EjercitoDefensorEnemigo();
						if (defensorContrario.getClass().getName().equals("LightHunter")) {
							if (enemyArmy[0].size() > 0) {
								defensorContrario = enemyArmy[0].get((int)(Math.random()*enemyArmy[0].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 3)+0);
									if (enemyArmy[random].size() > 0) {
										defensorContrario = enemyArmy[random].get((int)(Math.random()*enemyArmy[random].size()));
										break;
									}
								}
							}
							
						}
						else if (defensorContrario.getClass().getName().equals("HeavyHunter")) {
							if (enemyArmy[1].size() > 0) {
								defensorContrario = enemyArmy[1].get((int)(Math.random()*enemyArmy[1].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 3)+0);
									if (enemyArmy[random].size() > 0) {
										defensorContrario = enemyArmy[random].get((int)(Math.random()*enemyArmy[random].size()));
										break;
									}
								}
							}
							
						}
						else if (defensorContrario.getClass().getName().equals("BattleShip")) {
							if (enemyArmy[2].size() > 0) {
								defensorContrario = enemyArmy[2].get((int)(Math.random()*enemyArmy[2].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 3)+0);
									if (enemyArmy[random].size() > 0) {
										defensorContrario = enemyArmy[random].get((int)(Math.random()*enemyArmy[random].size()));
										break;
									}
								}
							}
							
						}
						else if (defensorContrario.getClass().getName().equals("ArmoredShip")) {
							if (enemyArmy[3].size() > 0) {
								defensorContrario = enemyArmy[3].get((int)(Math.random()*enemyArmy[3].size()));
							}
							else {
								int random;
								while(true) {
									random = (int)((Math.random()* 3)+0);
									if (enemyArmy[random].size() > 0) {
										defensorContrario = enemyArmy[random].get((int)(Math.random()*enemyArmy[random].size()));
										break;
									}
								}
							}
							
						}
					}
					else {
						turnoMiplaneta = false;
						turnoPlanetaAtacante = true;
						battle = battle + "*****CHANGE ATTACKER*****" + "\n";
						
					}
					
				}
					
			}
			if (parar == true) {
				guardarPartidaEnBasedatos();
				break;
			}
			
			
			
		
		}

	}
	
	VariablesBBDDShips variablesLightHunter = new VariablesBBDDShips(1);
	VariablesBBDDShips variablesHeavyHunter = new VariablesBBDDShips(2);
	VariablesBBDDShips variablesBattleShip = new VariablesBBDDShips(3);
	VariablesBBDDShips variablesArmoredShip = new VariablesBBDDShips(4);
	VariablesBBDDDefenses variablesMissileLauncher = new VariablesBBDDDefenses(1);
	VariablesBBDDDefenses variablesIonCannon = new VariablesBBDDDefenses(2);
	VariablesBBDDDefenses variablesPlasmaCannon = new VariablesBBDDDefenses(3);
	int battleId;
	private void guardarPartidaEnBasedatos() {
		int userId = 1;
		Connection cn = null;
		Connection cn2 = null;
		
		
		 try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			 // Conecta con la base de datos orcl con el usuario system y la contrase�a password
	         cn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.40.2:1521:orcl", "alumnoMIX4", "alumnoMIX4");
	         //cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "P@ssw0rd");
	         String query = "select nvl(max(id_battle),0) from battle";
	         Statement stmnt = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	         ResultSet rs = stmnt.executeQuery(query);
	         
	         //maxID
	         while(rs.next()) {
	        	 battleId = rs.getInt(1);
	         }
	         
	         battleId = battleId + 1;
	         //PlanetNuestro
	         String query2 = "INSERT INTO ships_defenses_battle values(?,?,?,?,?)";
	         PreparedStatement pst;
	         pst = cn.prepareStatement(query2);
	         pst.setInt(1, battleId);
	         pst.setInt(2, 1);
	         pst.setInt(3, 0);
	         pst.setInt(4, LightHunterMiosComienzo);
	         pst.setInt(5, LightHunterMiosFinal);
	         pst.execute();
	         
	         String query3 = "INSERT INTO ships_defenses_battle values(?,?,?,?,?)";
	         PreparedStatement pst2;
	         pst2 = cn.prepareStatement(query3);
	         pst2.setInt(1, battleId);
	         pst2.setInt(2, 1);
	         pst2.setInt(3, 1);
	         pst2.setInt(4, HeavyHunterMiosComienzo);
	         pst2.setInt(5, HeavyHunterMiosFinal);
	         pst2.execute();
	         
	         String query4 = "INSERT INTO ships_defenses_battle values(?,?,?,?,?)";
	         PreparedStatement pst3;
	         pst3 = cn.prepareStatement(query4);
	         pst3.setInt(1, battleId);
	         pst3.setInt(2, 1);
	         pst3.setInt(3, 2);
	         pst3.setInt(4, BattleShipMiosComienzo);
	         pst3.setInt(5, BattleShipMiosFinal);
	         pst3.execute();
	         
	         String query5 = "INSERT INTO ships_defenses_battle values(?,?,?,?,?)";
	         PreparedStatement pst4;
	         pst4 = cn.prepareStatement(query5);
	         pst4.setInt(1, battleId);
	         pst4.setInt(2, 1);
	         pst4.setInt(3, 3);
	         pst4.setInt(4, ArmoredShipMiosComienzo);
	         pst4.setInt(5, ArmoredShipMiosFinal);
	         pst4.execute();
	         
	         String query6 = "INSERT INTO ships_defenses_battle values(?,?,?,?,?)";
	         PreparedStatement pst5;
	         pst5 = cn.prepareStatement(query6);
	         pst5.setInt(1, battleId);
	         pst5.setInt(2, 1);
	         pst5.setInt(3, 4);
	         pst5.setInt(4, MissileLauncherMiosComienzo);
	         pst5.setInt(5, MissileLauncherMiosFinal);
	         pst5.execute();
	         
	         String query7 = "INSERT INTO ships_defenses_battle values(?,?,?,?,?)";
	         PreparedStatement pst6;
	         pst6 = cn.prepareStatement(query7);
	         pst6.setInt(1, battleId);
	         pst6.setInt(2, 1);
	         pst6.setInt(3, 5);
	         pst6.setInt(4, IonCannonMiosComienzo);
	         pst6.setInt(5, IonCannonMiosFinal);
	         pst6.execute();
	         
	         String query8 = "INSERT INTO ships_defenses_battle values(?,?,?,?,?)";
	         PreparedStatement pst7;
	         pst7 = cn.prepareStatement(query8);
	         pst7.setInt(1, battleId);
	         pst7.setInt(2, 1);
	         pst7.setInt(3, 6);
	         pst7.setInt(4, PlasmaCannonMiosComienzo);
	         pst7.setInt(5, PlasmaCannonMiosFinal);
	         pst7.execute();
	         
	         //planet enemigo
	        String query9 = "INSERT INTO ships_defenses_battle values(?,?,?,?,?)";
	        PreparedStatement pst8;
	        pst8 = cn.prepareStatement(query9);
	        pst8.setInt(1, battleId);
	        pst8.setInt(2, 2);
	        pst8.setInt(3, 0);
	        pst8.setInt(4, LightHuntersEnemigoComienzo);
	        pst8.setInt(5, LightHuntersEnemigoFinal);
	        pst8.execute();
	        
	        String query10 = "INSERT INTO ships_defenses_battle values(?,?,?,?,?)";
	        PreparedStatement pst9;
	        pst9 = cn.prepareStatement(query10);
	        pst9.setInt(1, battleId);
	        pst9.setInt(2, 2);
	        pst9.setInt(3, 1);
	        pst9.setInt(4, HeavyHuntersEnemigoComienzo);
	        pst9.setInt(5, HeavyHuntersEnemigoFinal);
	        pst9.execute();
	        
	        String query11 = "INSERT INTO ships_defenses_battle values(?,?,?,?,?)";
	        PreparedStatement pst10;
	        pst10 = cn.prepareStatement(query11);
	        pst10.setInt(1, battleId);
	        pst10.setInt(2, 2);
	        pst10.setInt(3, 2);
	        pst10.setInt(4, BattleShipEnemigoComienzo);
	        pst10.setInt(5, BattleShipEnemigoFinal);
	        pst10.execute();
	        
	        String query12 = "INSERT INTO ships_defenses_battle values(?,?,?,?,?)";
	        PreparedStatement pst11;
	        pst11 = cn.prepareStatement(query12);
	        pst11.setInt(1, battleId);
	        pst11.setInt(2, 2);
	        pst11.setInt(3, 3);
	        pst11.setInt(4, ArmoredShipEnemigoComienzo);
	        pst11.setInt(5, ArmoredShipEnemigoFinal);
	        pst11.execute();
	        
	        //meto ejercito planeta vivo
	        String query13 = "INSERT INTO battle_details values(?,?,?,?,?,?)";
	        PreparedStatement pst12;
	        int techA;
	        int techB;
	        for (int i = 0; i < planetArmy.length; i++) {
				for (int j = 0; j < planetArmy[i].size(); j++) {
					 MilitaryUnit m = planetArmy[i].get(j);
					 if (m.getClass().getName().equals("LightHunter")) {
						 LightHunter l = (LightHunter) m;
						 techA = 100*(l.getBaseDamage()-variablesLightHunter.getBaseDamage())/(Variables.PLUS_ATTACK_LIGTHHUNTER_BY_TECHNOLOGY*variablesLightHunter.getBaseDamage());
						 techB = 100*(l.getInitialArmor()-variablesLightHunter.getinitialArmor())/(Variables.PLUS_ARMOR_LIGTHHUNTER_BY_TECHNOLOGY*variablesLightHunter.getinitialArmor());
						 pst12 = cn.prepareStatement(query13);
					        pst12.setInt(1, battleId);
					        pst12.setInt(2, 1);
					        pst12.setInt(3, 0);
					        pst12.setInt(4, techA);
					        pst12.setInt(5, techB);
					        pst12.setString(6, "false");
					        pst12.execute();
					 }
					 else if (m.getClass().getName().equals("HeavyHunter")) {
						 HeavyHunter h = (HeavyHunter) m;
						 techA = 100*(h.getBaseDamage()-variablesHeavyHunter.getBaseDamage())/(Variables.PLUS_ATTACK_HEAVYHUNTER_BY_TECHNOLOGY*variablesHeavyHunter.getBaseDamage());
						 techB = 100*(h.getInitialArmor()-variablesHeavyHunter.getinitialArmor())/(Variables.PLUS_ARMOR_HEAVYHUNTER_BY_TECHNOLOGY*variablesHeavyHunter.getinitialArmor());
						 pst12 = cn.prepareStatement(query13);
					        pst12.setInt(1, battleId);
					        pst12.setInt(2, 1);
					        pst12.setInt(3, 1);
					        pst12.setInt(4, techA);
					        pst12.setInt(5, techB);
					        pst12.setString(6, "false");
					        pst12.execute();
					 }
					 else if (m.getClass().getName().equals("BattleShip")) {
						 BattleShip b = (BattleShip) m;
						 techA = 100*(b.getBaseDamage()-variablesBattleShip.getBaseDamage())/(Variables.PLUS_ATTACK_BATTLESHIP_BY_TECHNOLOGY*variablesBattleShip.getBaseDamage());
						 techB = 100*(b.getInitialArmor()-variablesBattleShip.getinitialArmor())/(Variables.PLUS_ARMOR_BATTLESHIP_BY_TECHNOLOGY*variablesBattleShip.getinitialArmor());
						 pst12 = cn.prepareStatement(query13);
					        pst12.setInt(1, battleId);
					        pst12.setInt(2, 1);
					        pst12.setInt(3, 2);
					        pst12.setInt(4, techA);
					        pst12.setInt(5, techB);
					        pst12.setString(6, "false");
					        pst12.execute();
					 }
					 else if (m.getClass().getName().equals("ArmoredShip")) {
						 ArmoredShip a = (ArmoredShip) m;
						 techA = 100*(a.getBaseDamage()-variablesArmoredShip.getBaseDamage())/(Variables.PLUS_ATTACK_ARMOREDSHIP_BY_TECHNOLOGY*variablesArmoredShip.getBaseDamage());
						 techB = 100*(a.getInitialArmor()-variablesArmoredShip.getinitialArmor())/(Variables.PLUS_ARMOR_ARMOREDSHIP_BY_TECHNOLOGY*variablesArmoredShip.getinitialArmor());
						 pst12 = cn.prepareStatement(query13);
					        pst12.setInt(1, battleId);
					        pst12.setInt(2, 1);
					        pst12.setInt(3, 3);
					        pst12.setInt(4, techA);
					        pst12.setInt(5, techB);
					        pst12.setString(6, "false");
					        pst12.execute();
					 }
					 else if (m.getClass().getName().equals("MissileLauncher")) {
						 MissileLauncher mi = (MissileLauncher) m;
						 techA = 100*(mi.getBaseDamage()-variablesMissileLauncher.getBaseDamage())/(Variables.PLUS_ATTACK_MISSILELAUNCHER_BY_TECHNOLOGY*variablesMissileLauncher.getBaseDamage());
						 techB = 100*(mi.getInitialArmor()-variablesMissileLauncher.getinitialArmor())/(Variables.PLUS_ARMOR_MISSILELAUNCHER_BY_TECHNOLOGY*variablesMissileLauncher.getinitialArmor());
						 pst12 = cn.prepareStatement(query13);
					        pst12.setInt(1, battleId);
					        pst12.setInt(2, 1);
					        pst12.setInt(3, 4);
					        pst12.setInt(4, techA);
					        pst12.setInt(5, techB);
					        pst12.setString(6, "false");
					        pst12.execute();
					 }
					 else if (m.getClass().getName().equals("IonCannon")) {
						 IonCannon io = (IonCannon) m;
						 techA = 100*(io.getBaseDamage()-variablesIonCannon.getBaseDamage())/(Variables.PLUS_ATTACK_IONCANNON_BY_TECHNOLOGY*variablesIonCannon.getBaseDamage());
						 techB = 100*(io.getInitialArmor()-variablesIonCannon.getinitialArmor())/(Variables.PLUS_ARMOR_IONCANNON_BY_TECHNOLOGY*variablesIonCannon.getinitialArmor());
						 pst12 = cn.prepareStatement(query13);
					        pst12.setInt(1, battleId);
					        pst12.setInt(2, 1);
					        pst12.setInt(3, 5);
					        pst12.setInt(4, techA);
					        pst12.setInt(5, techB);
					        pst12.setString(6, "false");
					        pst12.execute();
					 }
					 else if (m.getClass().getName().equals("PlasmaCannon")) {
						 PlasmaCannon p = (PlasmaCannon) m;
						 techA = 100*(p.getBaseDamage()-variablesPlasmaCannon.getBaseDamage())/(Variables.PLUS_ATTACK_PLASMACANNON_BY_TECHNOLOGY*variablesPlasmaCannon.getBaseDamage());
						 techB = 100*(p.getInitialArmor()-variablesPlasmaCannon.getinitialArmor())/(Variables.PLUS_ARMOR_PLASMACANNON_BY_TECHNOLOGY*variablesPlasmaCannon.getinitialArmor());
						 pst12 = cn.prepareStatement(query13);
					        pst12.setInt(1, battleId);
					        pst12.setInt(2, 1);
					        pst12.setInt(3, 6);
					        pst12.setInt(4, techA);
					        pst12.setInt(5, techB);
					        pst12.setString(6, "false");
					        pst12.execute();
					 } 
				}	
			}
	        //meter ejercito planeta muerto
	        
	        String query15 = "INSERT INTO battle_details values(?,?,?,?,?,?)";
	        PreparedStatement pst15;
	        for (int i = 0; i < planetArmyDeath.length; i++) {
				for (int j = 0; j < planetArmyDeath[i].size(); j++) {
					 MilitaryUnit m = planetArmyDeath[i].get(j);
					 if (m.getClass().getName().equals("LightHunter")) {
						 LightHunter l = (LightHunter) m;
						 techA = 100*(l.getBaseDamage()-variablesLightHunter.getBaseDamage())/(Variables.PLUS_ATTACK_LIGTHHUNTER_BY_TECHNOLOGY*variablesLightHunter.getBaseDamage());
						 techB = 100*(l.getInitialArmor()-variablesLightHunter.getinitialArmor())/(Variables.PLUS_ARMOR_LIGTHHUNTER_BY_TECHNOLOGY*variablesLightHunter.getinitialArmor());
						 pst15 = cn.prepareStatement(query15);
						 pst15.setInt(1, battleId);
						 pst15.setInt(2, 1);
						 pst15.setInt(3, 0);
						 pst15.setInt(4, techA);
						 pst15.setInt(5, techB);
						 pst15.setString(6, "true");
						 pst15.execute();
					 }
					 else if (m.getClass().getName().equals("HeavyHunter")) {
						 HeavyHunter h = (HeavyHunter) m;
						 techA = 100*(h.getBaseDamage()-variablesHeavyHunter.getBaseDamage())/(Variables.PLUS_ATTACK_HEAVYHUNTER_BY_TECHNOLOGY*variablesHeavyHunter.getBaseDamage());
						 techB = 100*(h.getInitialArmor()-variablesHeavyHunter.getinitialArmor())/(Variables.PLUS_ARMOR_HEAVYHUNTER_BY_TECHNOLOGY*variablesHeavyHunter.getinitialArmor());
						 pst15 = cn.prepareStatement(query15);
						 pst15.setInt(1, battleId);
						 pst15.setInt(2, 1);
						 pst15.setInt(3, 1);
						 pst15.setInt(4, techA);
						 pst15.setInt(5, techB);
						 pst15.setString(6, "true");
						 pst15.execute();
					 }
					 else if (m.getClass().getName().equals("BattleShip")) {
						 BattleShip b = (BattleShip) m;
						 techA = 100*(b.getBaseDamage()-variablesBattleShip.getBaseDamage())/(Variables.PLUS_ATTACK_BATTLESHIP_BY_TECHNOLOGY*variablesBattleShip.getBaseDamage());
						 techB = 100*(b.getInitialArmor()-variablesBattleShip.getinitialArmor())/(Variables.PLUS_ARMOR_BATTLESHIP_BY_TECHNOLOGY*variablesBattleShip.getinitialArmor());
						 pst15 = cn.prepareStatement(query15);
						 pst15.setInt(1, battleId);
						 pst15.setInt(2, 1);
						 pst15.setInt(3, 2);
						 pst15.setInt(4, techA);
						 pst15.setInt(5, techB);
						 pst15.setString(6, "true");
						 pst15.execute();
					 }
					 else if (m.getClass().getName().equals("ArmoredShip")) {
						 ArmoredShip a = (ArmoredShip) m;
						 techA = 100*(a.getBaseDamage()-variablesArmoredShip.getBaseDamage())/(Variables.PLUS_ATTACK_ARMOREDSHIP_BY_TECHNOLOGY*variablesArmoredShip.getBaseDamage());
						 techB = 100*(a.getInitialArmor()-variablesArmoredShip.getinitialArmor())/(Variables.PLUS_ARMOR_ARMOREDSHIP_BY_TECHNOLOGY*variablesArmoredShip.getinitialArmor());
						 pst15 = cn.prepareStatement(query15);
						 pst15.setInt(1, battleId);
						 pst15.setInt(2, 1);
						 pst15.setInt(3, 3);
						 pst15.setInt(4, techA);
						 pst15.setInt(5, techB);
						 pst15.setString(6, "true");
						 pst15.execute();
					 }
					 else if (m.getClass().getName().equals("MissileLauncher")) {
						 MissileLauncher mi = (MissileLauncher) m;
						 techA = 100*(mi.getBaseDamage()-variablesMissileLauncher.getBaseDamage())/(Variables.PLUS_ATTACK_MISSILELAUNCHER_BY_TECHNOLOGY*variablesMissileLauncher.getBaseDamage());
						 techB = 100*(mi.getInitialArmor()-variablesMissileLauncher.getinitialArmor())/(Variables.PLUS_ARMOR_MISSILELAUNCHER_BY_TECHNOLOGY*variablesMissileLauncher.getinitialArmor());
						 pst15 = cn.prepareStatement(query15);
						 pst15.setInt(1, battleId);
						 pst15.setInt(2, 1);
						 pst15.setInt(3, 4);
						 pst15.setInt(4, techA);
						 pst15.setInt(5, techB);
						 pst15.setString(6, "true");
						 pst15.execute();
					 }
					 else if (m.getClass().getName().equals("IonCannon")) {
						 IonCannon io = (IonCannon) m;
						 techA = 100*(io.getBaseDamage()-variablesIonCannon.getBaseDamage())/(Variables.PLUS_ATTACK_IONCANNON_BY_TECHNOLOGY*variablesIonCannon.getBaseDamage());
						 techB = 100*(io.getInitialArmor()-variablesIonCannon.getinitialArmor())/(Variables.PLUS_ARMOR_IONCANNON_BY_TECHNOLOGY*variablesIonCannon.getinitialArmor());
						 pst15 = cn.prepareStatement(query15);
						 pst15.setInt(1, battleId);
						 pst15.setInt(2, 1);
						 pst15.setInt(3, 5);
						 pst15.setInt(4, techA);
						 pst15.setInt(5, techB);
						 pst15.setString(6, "true");
						 pst15.execute();
					 }
					 else if (m.getClass().getName().equals("PlasmaCannon")) {
						 PlasmaCannon p = (PlasmaCannon) m;
						 techA = 100*(p.getBaseDamage()-variablesPlasmaCannon.getBaseDamage())/(Variables.PLUS_ATTACK_PLASMACANNON_BY_TECHNOLOGY*variablesPlasmaCannon.getBaseDamage());
						 techB = 100*(p.getInitialArmor()-variablesPlasmaCannon.getinitialArmor())/(Variables.PLUS_ARMOR_PLASMACANNON_BY_TECHNOLOGY*variablesPlasmaCannon.getinitialArmor());
						 pst15 = cn.prepareStatement(query15);
						 pst15.setInt(1, battleId);
						 pst15.setInt(2, 1);
						 pst15.setInt(3, 6);
						 pst15.setInt(4, techA);
						 pst15.setInt(5, techB);
						 pst15.setString(6, "true");
						 pst15.execute();
					 } 
				}	
			}
	        
	      //meter ejercito enemigo muerto

	        for (int i = 0; i < enemyArmy.length; i++) {
				for (int j = 0; j < enemyArmy[i].size(); j++) {
					MilitaryUnit m = enemyArmy[i].get(j);
					String query14 = "INSERT INTO battle_details values(?,?,?,?,?,?)";
			        PreparedStatement pst13;
			        pst13 = cn.prepareStatement(query14);
			        pst13.setInt(1, battleId);
			        pst13.setInt(2, 2);
			        pst13.setInt(3, j);
			        pst13.setInt(4, 0);
			        pst13.setInt(5, 0);
			        pst13.setString(6, "false");
			        pst13.execute();
				}
			}
	        
	        for (int i = 0; i < enemyArmyDeath.length; i++) {
				for (int j = 0; j < enemyArmyDeath[i].size(); j++) {
					MilitaryUnit m = enemyArmyDeath[i].get(j);
					String query16 = "INSERT INTO battle_details values(?,?,?,?,?,?)";
			        PreparedStatement pst16;
			        pst16 = cn.prepareStatement(query16);
			        pst16.setInt(1, battleId);
			        pst16.setInt(2, 2);
			        pst16.setInt(3, j);
			        pst16.setInt(4, 0);
			        pst16.setInt(5, 0);
			        pst16.setString(6, "true");
			        pst16.execute();
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				cn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 
		 try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			cn2 = DriverManager.getConnection("jdbc:oracle:thin:@192.168.40.2:1521:orcl", "alumnoMIX4", "alumnoMIX4");
			//cn2 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "P@ssw0rd");
			//guardar los steps
	        String[] pasosBatalla = battle.split("\n");
			
			for (int i = 0; i < pasosBatalla.length; i++) {
				PreparedStatement pst12;
				String query13 = "INSERT INTO battle values(?,?,?,?)";
				pst12 = cn2.prepareStatement(query13);
				pst12.setInt(1, battleId);
				pst12.setInt(2, userId);
				pst12.setInt(3, i);
				pst12.setString(4, pasosBatalla[i]);
				pst12.execute();
				//insert into battle values (battleId, userId, i, pasosBatalla[i])
			}
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				cn2.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	int metalPlanetaEnemigo;
	int deuteriumPlanetaEnemigo;
	public void createEnemyArmy() {
		Planet planetMio = new Planet();
		VariablesBBDDShips Lighthunters = new VariablesBBDDShips(1);
		VariablesBBDDShips HeavyHunters = new VariablesBBDDShips(2);
		VariablesBBDDShips Battleship = new VariablesBBDDShips(3);
		VariablesBBDDShips Armoredship = new VariablesBBDDShips(4);
		metalPlanetaEnemigo = planetMio.getMetal();
		deuteriumPlanetaEnemigo = planetMio.getDeuterium();
		int[] arrayProbabilidades = new int[] {35,25,20,20};
		while (true) {
			int random = (int)((Math.random()* 100)+1);
			if(metalPlanetaEnemigo < Lighthunters.getCosteMetal() || deuteriumPlanetaEnemigo < Lighthunters.getCosteDeuterium()) {
				break;
			}
			else if (arrayProbabilidades[0] > random && metalPlanetaEnemigo >= Lighthunters.getCosteMetal() && deuteriumPlanetaEnemigo >= Lighthunters.getCosteDeuterium() ) {
				enemyArmy[0].add(new LightHunter());
				metalPlanetaEnemigo = metalPlanetaEnemigo - Lighthunters.getCosteMetal();
				deuteriumPlanetaEnemigo = deuteriumPlanetaEnemigo - Lighthunters.getCosteDeuterium();
			}
			else if (arrayProbabilidades[0] + arrayProbabilidades[1] > random && metalPlanetaEnemigo >= HeavyHunters.getCosteMetal() && deuteriumPlanetaEnemigo >= HeavyHunters.getCosteDeuterium()) {
				enemyArmy[1].add(new HeavyHunter());
				metalPlanetaEnemigo = metalPlanetaEnemigo - HeavyHunters.getCosteMetal();
				deuteriumPlanetaEnemigo = deuteriumPlanetaEnemigo - HeavyHunters.getCosteDeuterium();
				
			}
			else if (arrayProbabilidades[0] + arrayProbabilidades[1] + arrayProbabilidades[2] > random && metalPlanetaEnemigo >= Battleship.getCosteMetal() && deuteriumPlanetaEnemigo >= Battleship.getCosteDeuterium()) {
				enemyArmy[2].add(new BattleShip());
				metalPlanetaEnemigo = metalPlanetaEnemigo -  Battleship.getCosteMetal();
				deuteriumPlanetaEnemigo = deuteriumPlanetaEnemigo - Battleship.getCosteDeuterium();
			}
			else if (arrayProbabilidades[0] + arrayProbabilidades[1] + arrayProbabilidades[2] + arrayProbabilidades[3] > random && metalPlanetaEnemigo >= Armoredship.getCosteMetal() && deuteriumPlanetaEnemigo >= Armoredship.getCosteDeuterium()) {
				enemyArmy[3].add(new ArmoredShip());
				metalPlanetaEnemigo = metalPlanetaEnemigo - Armoredship.getCosteMetal();
				deuteriumPlanetaEnemigo = deuteriumPlanetaEnemigo - Armoredship.getCosteDeuterium();
			}
		}
	}

	public ArrayList<MilitaryUnit>[] getPlanetArmy() {
		return planetArmy;
	}

	public void setPlanetArmy(ArrayList<MilitaryUnit>[] planetArmy) {
		this.planetArmy = planetArmy;
	}

	public ArrayList<MilitaryUnit>[] getEnemyArmy() {
		return enemyArmy;
	}

	public void setEnemyArmy(ArrayList<MilitaryUnit>[] enemyArmy) {
		this.enemyArmy = enemyArmy;
	}
	
	public String ViewThread() {
		String cadena;
		cadena = "Light Hunter " + enemyArmy[0].size() + "\nHeavy Hunter " + enemyArmy[1].size() + "\nBattle Ship "+ enemyArmy[2].size() + "\nArmored Ship " + enemyArmy[3].size() ;
		return cadena;
	}
	
	int LightHuntersPlanetStart;
	int LightHuntersPlanetDrop;
	int HeavyHuntersPlanetStart;
	int HeavyHuntersPlanetDrop;
	int BattleShipsPlanetStart;
	int BattleShipPlanetDrop;
	int ArmoredShipPlanetStart;
	int ArmoredShipPlanetDrop;
	int MissileLauncherPlanetStart;
	int MissileLauncherPlanetDrop;
	int IonCannonPlanetStart;
	int IonCannonPlanetDrop;
	int PlasmaCannonPlanetStart;
	int PlasmaCannonPlanetDrop;
	int LightHuntersEnemyStart;
	int LightHuntersEnemyDrop;
	int HeavyHuntersEnemyStart;
	int HeavyHuntersEnemyDrop;
	int BattleShipEnemyStart;
	int BattleShipEnemyDrop;
	int ArmoredShipEnemyStart;
	int ArmoredShipEnemyDrop;
	public String battleReport(int ibatalla) {
		VariablesBBDDShips Lighthunters = new VariablesBBDDShips(1);
		VariablesBBDDShips HeavyHunters = new VariablesBBDDShips(2);
		VariablesBBDDShips Battleship = new VariablesBBDDShips(3);
		VariablesBBDDShips Armoredship = new VariablesBBDDShips(4);
		VariablesBBDDDefenses MissileLauncher = new VariablesBBDDDefenses(1);
		VariablesBBDDDefenses IonCannon = new VariablesBBDDDefenses(2);
		VariablesBBDDDefenses PlasmaCannon = new VariablesBBDDDefenses(3);
		
		Connection cn = null;
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			// Conecta con la base de datos orcl con el usuario system y la contrase�a password
	        cn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.40.2:1521:orcl", "alumnoMIX4", "alumnoMIX4");
	        //cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "P@ssw0rd");
	        String query = "select quantityinitial from ships_defenses_battle where id_battle = ? and id_planet = 1 and id_ships = 0";
	        PreparedStatement ps = cn.prepareStatement(query);
	        ps.setInt(1, ibatalla);
	        ResultSet rs = ps.executeQuery();
	        
	        while(rs.next()) {
	        	LightHuntersPlanetStart = rs.getInt(1);
	        }
	        
	        query = "select quantityfinal  from ships_defenses_battle where id_battle = ? and id_planet = 1 and id_ships = 0";
	        ps = cn.prepareStatement(query);
	        ps.setInt(1, ibatalla);
	        rs = ps.executeQuery();
	        
	        while(rs.next()) {
	        	LightHuntersPlanetDrop = rs.getInt(1);
	        }
	        
	        query = "select quantityinitial  from ships_defenses_battle where id_battle = ? and id_planet = 1 and id_ships = 1";
	        ps = cn.prepareStatement(query);
	        ps.setInt(1, ibatalla);
	        rs = ps.executeQuery();
	        
	        while(rs.next()) {
	        	HeavyHuntersPlanetStart = rs.getInt(1);
	        }
	        
	        query = "select quantityfinal  from ships_defenses_battle where id_battle = ? and id_planet = 1 and id_ships = 1";
	        ps = cn.prepareStatement(query);
	        ps.setInt(1, ibatalla);
	        rs = ps.executeQuery();
	        
	        while(rs.next()) {
	        	HeavyHuntersPlanetDrop = rs.getInt(1);
	        }
	        
	        query = "select quantityinitial from ships_defenses_battle where id_battle = ? and id_planet = 1 and id_ships = 2";
	        ps = cn.prepareStatement(query);
	        ps.setInt(1, ibatalla);
	        rs = ps.executeQuery();
	        
	        while(rs.next()) {
	        	BattleShipsPlanetStart = rs.getInt(1);
	        }
	        
	        query = "select quantityfinal from ships_defenses_battle where id_battle = ? and id_planet = 1 and id_ships = 2";
	        ps = cn.prepareStatement(query);
	        ps.setInt(1, ibatalla);
	        rs = ps.executeQuery();
	        
	        while(rs.next()) {
	        	BattleShipPlanetDrop = rs.getInt(1);
	        }
	        
	        query = "select quantityinitial from ships_defenses_battle where id_battle = ? and id_planet = 1 and id_ships = 3";
	        ps = cn.prepareStatement(query);
	        ps.setInt(1, ibatalla);
	        rs = ps.executeQuery();
	        
	        while(rs.next()) {
	        	ArmoredShipPlanetStart = rs.getInt(1);
	        }
	        
	        query = "select quantityfinal from ships_defenses_battle where id_battle = ? and id_planet = 1 and id_ships = 3";
	        ps = cn.prepareStatement(query);
	        ps.setInt(1, ibatalla);
	        rs = ps.executeQuery();
	        
	        while(rs.next()) {
	        	ArmoredShipPlanetDrop = rs.getInt(1);
	        }
	        
	        query = "select quantityinitial from ships_defenses_battle where id_battle = ? and id_planet = 1 and id_ships = 4";
	        ps = cn.prepareStatement(query);
	        ps.setInt(1, ibatalla);
	        rs = ps.executeQuery();
	        
	        while(rs.next()) {
	        	MissileLauncherPlanetStart = rs.getInt(1);
	        }
	        
	        query = "select quantityfinal from ships_defenses_battle where id_battle = ? and id_planet = 1 and id_ships = 4";
	        ps = cn.prepareStatement(query);
	        ps.setInt(1, ibatalla);
	        rs = ps.executeQuery();
	        
	        while(rs.next()) {
	        	MissileLauncherPlanetDrop = rs.getInt(1);
	        }
	        
	        query = "select quantityinitial from ships_defenses_battle where id_battle = ? and id_planet = 1 and id_ships = 5";
	        ps = cn.prepareStatement(query);
	        ps.setInt(1, ibatalla);
	        rs = ps.executeQuery();
	        
	        while(rs.next()) {
	        	IonCannonPlanetStart = rs.getInt(1);
	        }
	        
	        query = "select quantityfinal from ships_defenses_battle where id_battle = ? and id_planet = 1 and id_ships = 5";
	        ps = cn.prepareStatement(query);
	        ps.setInt(1, ibatalla);
	        rs = ps.executeQuery();
	        
	        while(rs.next()) {
	        	IonCannonPlanetDrop = rs.getInt(1);
	        }
	        
	        query = "select quantityinitial from ships_defenses_battle where id_battle = ? and id_planet = 1 and id_ships = 6";
	        ps = cn.prepareStatement(query);
	        ps.setInt(1, ibatalla);
	        rs = ps.executeQuery();
	        
	        while(rs.next()) {
	        	PlasmaCannonPlanetStart = rs.getInt(1);
	        }
	        
	        query = "select quantityfinal from ships_defenses_battle where id_battle = ? and id_planet = 1 and id_ships = 6";
	        ps = cn.prepareStatement(query);
	        ps.setInt(1, ibatalla);
	        rs = ps.executeQuery();
	        
	        while(rs.next()) {
	        	PlasmaCannonPlanetDrop = rs.getInt(1);
	        }
	        
	        query = "select quantityinitial from ships_defenses_battle where id_battle = ? and id_planet = 2 and id_ships = 0";
	        ps = cn.prepareStatement(query);
	        ps.setInt(1, ibatalla);
	        rs = ps.executeQuery();
	        
	        while(rs.next()) {
	        	LightHuntersEnemyStart = rs.getInt(1);
	        }
	        
	        query = "select quantityfinal from ships_defenses_battle where id_battle = ? and id_planet = 2 and id_ships = 0";
	        ps = cn.prepareStatement(query);
	        ps.setInt(1, ibatalla);
	        rs = ps.executeQuery();
	        
	        while(rs.next()) {
	        	LightHuntersEnemyDrop = rs.getInt(1);
	        }
	        
	        query = "select quantityinitial from ships_defenses_battle where id_battle = ? and id_planet = 2 and id_ships = 1";
	        ps = cn.prepareStatement(query);
	        ps.setInt(1, ibatalla);
	        rs = ps.executeQuery();
	        
	        while(rs.next()) {
	        	HeavyHuntersEnemyStart = rs.getInt(1);
	        }
	        
	        query = "select quantityfinal from ships_defenses_battle where id_battle = ? and id_planet = 2 and id_ships = 1";
	        ps = cn.prepareStatement(query);
	        ps.setInt(1, ibatalla);
	        rs = ps.executeQuery();
	        
	        while(rs.next()) {
	        	HeavyHuntersEnemyDrop = rs.getInt(1);
	        }
	        
	        query = "select quantityinitial from ships_defenses_battle where id_battle = ? and id_planet = 2 and id_ships = 2";
	        ps = cn.prepareStatement(query);
	        ps.setInt(1, ibatalla);
	        rs = ps.executeQuery();
	        
	        while(rs.next()) {
	        	BattleShipEnemyStart = rs.getInt(1);
	        }
	        
	        query = "select quantityfinal from ships_defenses_battle where id_battle = ? and id_planet = 2 and id_ships = 2";
	        ps = cn.prepareStatement(query);
	        ps.setInt(1, ibatalla);
	        rs = ps.executeQuery();
	        
	        while(rs.next()) {
	        	BattleShipEnemyDrop = rs.getInt(1);
	        }
	        
	        query = "select quantityinitial from ships_defenses_battle where id_battle = ? and id_planet = 2 and id_ships = 3";
	        ps = cn.prepareStatement(query);
	        ps.setInt(1, ibatalla);
	        rs = ps.executeQuery();
	        
	        while(rs.next()) {
	        	ArmoredShipEnemyStart = rs.getInt(1);
	        }
	        
	        query = "select quantityfinal from ships_defenses_battle where id_battle = ? and id_planet = 2 and id_ships = 3";
	        ps = cn.prepareStatement(query);
	        ps.setInt(1, ibatalla);
	        rs = ps.executeQuery();
	        
	        while(rs.next()) {
	        	ArmoredShipEnemyDrop = rs.getInt(1);
	        }
	        
	        
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				cn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 
		
		int metalPlaneta = (LightHuntersPlanetStart*Lighthunters.getCosteMetal() + HeavyHuntersPlanetStart*HeavyHunters.getCosteMetal() + BattleShipsPlanetStart*Battleship.getCosteMetal() + ArmoredShipPlanetStart*Armoredship.getCosteMetal() +
				MissileLauncherPlanetStart*MissileLauncher.getCosteMetal() + IonCannonPlanetStart*IonCannon.getCosteMetal()+ PlasmaCannonPlanetStart*PlasmaCannon.getCosteMetal());
		int metalEnemigo = (LightHuntersEnemyStart*Lighthunters.getCosteMetal()+
				HeavyHuntersEnemyStart*HeavyHunters.getCosteMetal() + BattleShipEnemyStart*Battleship.getCosteMetal() + ArmoredShipEnemyStart*Armoredship.getCosteMetal());
		int deuteriumPlaneta = (LightHuntersPlanetStart*Lighthunters.getCosteDeuterium() + HeavyHuntersPlanetStart*HeavyHunters.getCosteDeuterium() + BattleShipsPlanetStart*Battleship.getCosteDeuterium() + ArmoredShipPlanetStart*Armoredship.getCosteDeuterium() +
				MissileLauncherPlanetStart*MissileLauncher.getCosteDeuterium() + IonCannonPlanetStart*IonCannon.getCosteDeuterium()+ PlasmaCannonPlanetStart*PlasmaCannon.getCosteDeuterium());
		int deuteriumEnemigo = (LightHuntersEnemyStart*Lighthunters.getCosteDeuterium()+
				HeavyHuntersEnemyStart*HeavyHunters.getCosteDeuterium() + BattleShipEnemyStart*Battleship.getCosteDeuterium() + ArmoredShipEnemyStart*Armoredship.getCosteDeuterium());
		int metalPerdidoPlaneta = (LightHuntersPlanetDrop*Lighthunters.getCosteMetal() + HeavyHuntersPlanetDrop*HeavyHunters.getCosteMetal() + BattleShipPlanetDrop*Battleship.getCosteMetal() + ArmoredShipPlanetDrop*Armoredship.getCosteMetal() +
				MissileLauncherPlanetDrop*MissileLauncher.getCosteMetal() + IonCannonPlanetDrop*IonCannon.getCosteMetal()+ PlasmaCannonPlanetDrop*PlasmaCannon.getCosteMetal());
		int metalPerdidoEnemigo = (LightHuntersEnemyDrop*Lighthunters.getCosteMetal()+
				HeavyHuntersEnemyDrop*HeavyHunters.getCosteMetal() + BattleShipEnemyDrop*Battleship.getCosteMetal() + ArmoredShipEnemyDrop*Armoredship.getCosteMetal());
		int deuteriumPerdidoPlaneta = (LightHuntersPlanetDrop*Lighthunters.getCosteDeuterium() + HeavyHuntersPlanetDrop*HeavyHunters.getCosteDeuterium() + BattleShipPlanetDrop*Battleship.getCosteDeuterium() + ArmoredShipPlanetDrop*Armoredship.getCosteDeuterium() +
				MissileLauncherPlanetDrop*MissileLauncher.getCosteDeuterium() + IonCannonPlanetDrop*IonCannon.getCosteDeuterium()+ PlasmaCannonPlanetDrop*PlasmaCannon.getCosteDeuterium());
		int deuteriumPerdidoEnemigo = (LightHuntersEnemyDrop*Lighthunters.getCosteDeuterium()+
				HeavyHuntersEnemyDrop*HeavyHunters.getCosteDeuterium() + BattleShipEnemyDrop*Battleship.getCosteDeuterium() + ArmoredShipEnemyDrop*Armoredship.getCosteDeuterium());
		int weightedPlaneta = (metalPerdidoPlaneta) + (deuteriumPerdidoPlaneta)*5;
		int weightedEnemigo = (metalPerdidoEnemigo) + (deuteriumPerdidoEnemigo)*5;
		String cadena = "<html>BATTLE STATISTICS<br><br>"
				+ "Army Planet Units Drops Initial Army Enemy Units Drops<br>"
				+ "LightHunter "+LightHuntersPlanetStart + " "+ LightHuntersPlanetDrop + " Light Hunter" + LightHuntersEnemyStart + LightHuntersEnemyDrop + "<br>"
						+ "Heavy Hunter "+ HeavyHuntersPlanetStart + " "+ HeavyHuntersPlanetDrop + " Heavy Hunter "+HeavyHuntersEnemyStart + " "+HeavyHuntersEnemyDrop + "<br>"
								+ "Battle Ship "+BattleShipsPlanetStart + " "+BattleShipPlanetDrop + " Battle Ship "+BattleShipEnemyStart + " "+BattleShipEnemyDrop + "<br>"
										+ "Armored Ship "+ArmoredShipPlanetStart+" "+ArmoredShipPlanetDrop + " Armored Ship "+ArmoredShipEnemyStart + " "+ArmoredShipEnemyDrop + "<br>"
												+ "Missile Launcher "+MissileLauncherPlanetStart + " "+MissileLauncherPlanetDrop+"<br>"
														+ "Ion Cannon "+ IonCannonPlanetStart + " "+IonCannonPlanetDrop+"<br>"
																+ "Plasma Cannon "+PlasmaCannonPlanetStart + " "+PlasmaCannonPlanetDrop + "<br>"
																		+ "*********************************" + "<br>"
																				+ "Cost Army Planet Cost Army Enemy"+"<br>"
																						+ "Metal: "+ metalPlaneta + "Metal: " + metalEnemigo + "<br>"
																												+ "Deuterium: " + deuteriumPlaneta+ "Deuterium: " + deuteriumEnemigo + "<br>"
																																		+ "**************************************" + "<br>"
																																				+ "Losses Army Planet Losses Army Enemy" + "<br>"
																																						+ "Metal: "+ metalPerdidoPlaneta + "Metal: " +  metalPerdidoEnemigo+ "<br>"
																																												+ "Deuterium: " + deuteriumPerdidoPlaneta + "Deuterium " + deuteriumPerdidoEnemigo + "<br>"
																																																		+ "Weighted: " + weightedPlaneta + "Weighted: " + weightedEnemigo + "<br>"
																																																				+ "*********************" + "<br>"
																																																						+ "Waste Generated " + "<br>"
																																																								+ "Metal: "+ residuosMetal + "<br>"
																																																										+ "Deuterium: "+ residuoDeuterio + "<br></html>";
		if (weightedEnemigo < weightedPlaneta) {
			cadena = cadena + "Battle Winned by Fleet enemy, don't Collecte Rubble";
		}
		else if (weightedPlaneta < weightedEnemigo) {
			cadena = cadena + "Battle Winned by Planet, We Collect Rubble";
		}
		return cadena;												
	}
	
	public String getBattleDevelopment() {
		return battle;
	}
	
}