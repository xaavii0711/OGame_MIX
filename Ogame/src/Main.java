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

public class Main {
	
	public static void main(String[] args) {
		Battle b = new Battle();
		b.playBattle();
		
	
		
		
		
	}
}

class VariablesBBDDShips{
	
	CallableStatement cst;
	BufferedReader entrada;
	int id;
	Connection cn;
	
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
//                Integer P_ID = cst.getInt(1);
//                String P_NAME = cst.getString(2);
//                Integer P_METAL_COST = cst.getInt(3);
//                Integer P_CRYSTAL_COST = cst.getInt(4);
//                Integer P_DEUTERIUM_COST = cst.getInt(5);
//                Integer P_INITIALARMOR = cst.getInt(6);
//                Integer P_ARMOR = cst.getInt(7);
//                Integer P_BASEDAMAGE = cst.getInt(8);
//                Integer P_SPEED = cst.getInt(9);
//                Integer P_GENERATE_WASTINGS = cst.getInt(10);
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
	}
	public int getCosteMetal() {
		try {
			return cst.getInt(3);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public int getBaseDamage() {
		try {
			return cst.getInt(8);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public int getCosteDeuterium() {
		try {
			return cst.getInt(5);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public int getinitialArmor() {
		try {
			return cst.getInt(6);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public int getActualArmor() {
		try {
			return cst.getInt(7);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public int getGenerateWastings() {
		try {
			return cst.getInt(10);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	
}

class VariablesBBDDDefenses{
	
	CallableStatement cst;
	BufferedReader entrada;
	int id;
	Connection cn;
	
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
//                Integer P_ID = cst.getInt(1);
//                String P_NAME = cst.getString(2);
//                Integer P_METAL_COST = cst.getInt(3);
//                Integer P_CRYSTAL_COST = cst.getInt(4);
//                Integer P_DEUTERIUM_COST = cst.getInt(5);
//                Integer P_INITIALARMOR = cst.getInt(6);
//                Integer P_ARMOR = cst.getInt(7);
//                Integer P_BASEDAMAGE = cst.getInt(8);
//                Integer P_SPEED = cst.getInt(9);
//                Integer P_GENERATE_WASTINGS = cst.getInt(10);
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
	
		
	}
	
	public int getCosteMetal() {
		try {
			return cst.getInt(3);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public int getBaseDamage() {
		try {
			return cst.getInt(8);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public int getCosteDeuterium() {
		try {
			return cst.getInt(5);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public int getinitialArmor() {
		try {
			return cst.getInt(6);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public int getActualArmor() {
		try {
			return cst.getInt(7);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public int getGenerateWastings() {
		try {
			return cst.getInt(10);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
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

class Battle{
	
	private ArrayList<MilitaryUnit>[] planetArmy;
	private ArrayList<MilitaryUnit>[] enemyArmy;
	private ArrayList[][] armies;
	private String battleDevelopment;
	private int[][] initialCostFleet;
	private int initialNumberUnitsPlanet;
	private int initialNumberUnitsEnemy;
	private int[][] wasteMetalDeuterium;
	private int[] enemyDrops;
	private int[] planetDrops;
	private int[][] resourcesLooses;
	private int[][] initialArmies;
	private int[] actualNumberUnitsPlanet;
	private int[] actualNumberUnitsEnemy;
	
	public Battle() {
		planetArmy = new ArrayList[7];
		enemyArmy = new ArrayList[4];
		enemyArmy[0] = new ArrayList<>(0);
		enemyArmy[1] = new ArrayList<>(0);
		enemyArmy[2] = new ArrayList<>(0);
		enemyArmy[3] = new ArrayList<>(0);
		planetArmy[0] = new ArrayList<>(0);
		planetArmy[1] = new ArrayList<>(0);
		planetArmy[2] = new ArrayList<>(0);
		planetArmy[3] = new ArrayList<>(0);
		planetArmy[4] = new ArrayList<>(0);
		planetArmy[5] = new ArrayList<>(0);
		planetArmy[6] = new ArrayList<>(0);
		int[] wasteMetalDeuterium = new int[] {0,0};
	}
	
	public MilitaryUnit EjercitoAtacanteEnemigo() {
		enemyArmy[0].add(new LightHunter());
		enemyArmy[0].add(new LightHunter());
		enemyArmy[0].add(new LightHunter());
		enemyArmy[1].add(new HeavyHunter());
		enemyArmy[1].add(new HeavyHunter());
		enemyArmy[2].add(new BattleShip());
		enemyArmy[2].add(new BattleShip());
		enemyArmy[3].add(new ArmoredShip());
		enemyArmy[3].add(new ArmoredShip());
		MilitaryUnit atacanteEnemigo = null;
		
		List<Integer> listaProbabilidad = Arrays.asList(1,2,2,3,3,3,4,4,4,4);
		int probabilidad = (int)((Math.random()* 10)+0);
		
		if (listaProbabilidad.get(probabilidad) == 1) {
			atacanteEnemigo = enemyArmy[0].get((int)(Math.random()*enemyArmy[0].size()));
		}
		else if (listaProbabilidad.get(probabilidad) == 2) {
			atacanteEnemigo = enemyArmy[1].get((int)(Math.random()*enemyArmy[1].size()));
		}
		else if (listaProbabilidad.get(probabilidad) == 3) {
			atacanteEnemigo = enemyArmy[2].get((int)(Math.random()*enemyArmy[2].size()));
		}
		else if (listaProbabilidad.get(probabilidad) == 4) {
			atacanteEnemigo = enemyArmy[3].get((int)(Math.random()*enemyArmy[3].size()));
		}
		return atacanteEnemigo;
	}
	
	public MilitaryUnit EjercitoDefensorNuestro() {
		planetArmy[0].add(new LightHunter());
		planetArmy[0].add(new LightHunter());
		planetArmy[0].add(new LightHunter());
		planetArmy[1].add(new HeavyHunter());
		planetArmy[1].add(new HeavyHunter());
		planetArmy[2].add(new BattleShip());
		planetArmy[2].add(new BattleShip());
		planetArmy[3].add(new ArmoredShip());
		planetArmy[3].add(new ArmoredShip());
		planetArmy[4].add(new MissileLauncher());
		planetArmy[5].add(new IonCannon());
		planetArmy[6].add(new PlasmaCannon());
		int TotalUnidades = (planetArmy[0].size()+planetArmy[1].size()+planetArmy[2].size()+planetArmy[3].size()+planetArmy[4].size()+planetArmy[5].size()+planetArmy[6].size());
		MilitaryUnit defensorNuestro = null;
		
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
		
			if (arrayProbabilidades[0] > numAleatorio) {
				defensorNuestro = planetArmy[0].get((int)(Math.random()*planetArmy[0].size()));
			}
			else if (arrayProbabilidades[0] + arrayProbabilidades[1] > numAleatorio) {
				defensorNuestro = planetArmy[1].get((int)(Math.random()*planetArmy[1].size()));
			}
			else if (arrayProbabilidades[0] + arrayProbabilidades[1] + arrayProbabilidades[2] > numAleatorio) {
				defensorNuestro = planetArmy[2].get((int)(Math.random()*planetArmy[2].size()));
			}
			else if (arrayProbabilidades[0] + arrayProbabilidades[1] + arrayProbabilidades[2] + arrayProbabilidades[3] > numAleatorio) {
				defensorNuestro = planetArmy[3].get((int)(Math.random()*planetArmy[3].size()));
			}
			else if (arrayProbabilidades[0] + arrayProbabilidades[1] + arrayProbabilidades[2] + arrayProbabilidades[3] + arrayProbabilidades[4] > numAleatorio) {
				defensorNuestro = planetArmy[4].get((int)(Math.random()*planetArmy[4].size()));
			}
			else if (arrayProbabilidades[0] + arrayProbabilidades[1] + arrayProbabilidades[2] + arrayProbabilidades[3] + arrayProbabilidades[4] + arrayProbabilidades[5]> numAleatorio) {
				defensorNuestro = planetArmy[5].get((int)(Math.random()*planetArmy[5].size()));
			}
			else if (arrayProbabilidades[0] + arrayProbabilidades[1] + arrayProbabilidades[2] + arrayProbabilidades[3] + arrayProbabilidades[4] + arrayProbabilidades[5] + arrayProbabilidades[6]> numAleatorio) {
				defensorNuestro = planetArmy[6].get((int)(Math.random()*planetArmy[6].size()));
			}
			return defensorNuestro;
	}
	
	//PREGUNTAR POR CUANDO SE GENERAN RECURSOS
	//HACER METODO PARA ATACANTE MI PLANETA LOS 6
	//PREGUNTAR METODOS DEFENSAS 
	//HACER METODO PARA ACATANTE ENEMIGO SOLO 4
	// CUANDO ME ATACAN DEFIENDE UNO D LOS 6 VALE
	// CUANDO YO ATACO QUIEN DEFIENDE
	public void playBattle() {
		MilitaryUnit atacanteContrario;
		MilitaryUnit defensorContrario;
		MilitaryUnit atacanteMiPlaneta;
		MilitaryUnit defensorMiPlaneta;
		boolean turnoMiplaneta = false;
		boolean turnoPlanetaAtacante = true;
		atacanteContrario = EjercitoAtacanteEnemigo();
		defensorContrario = EjercitoDefensorNuestro();
		atacanteMiPlaneta = EjercitoAtacanteEnemigo();
		defensorMiPlaneta = EjercitoDefensorNuestro();
//		int sumaEjercitoAtacante = enemyArmy[0].size() + enemyArmy[1].size() + enemyArmy[2].size() + enemyArmy[3].size();
//		int sumaEjercitoDefensor = planetArmy[0].size() + planetArmy[1].size() + planetArmy[2].size() +  planetArmy[3].size() + planetArmy[4].size() + planetArmy[5].size() + planetArmy[0].size();
		int ResiduosTotalMetal = 0;
		int ResiduosTotalDeuterium = 0;
		while (true) {
			if (turnoPlanetaAtacante) {
				System.out.println("*****CHANGE ATTACKER*****");
				System.out.println("Attacks fleet enemy: " + atacanteContrario.getClass().getName() + " attacks " + defensorContrario.getClass().getName());
				System.out.println(atacanteContrario.getClass().getName() + " generates the damage = " + atacanteContrario.attack());
				defensorContrario.tekeDamage(atacanteContrario.attack());
				System.out.println(defensorContrario.getClass().getName() + " stays with armor = " + defensorContrario.getActualArmor());
				int probabilidadRecursos = (int)((Math.random()* 100)+1);
				int probabilidadAtacar = (int)((Math.random()* 100)+1);
				if (defensorContrario.getActualArmor() <= 0) {
					if (defensorContrario.getClass().getName().equals("LightHunter")) {
						if (probabilidadRecursos <= Variables.CHANCE_GENERATNG_WASTE_LIGTHHUNTER) {
							int residuosMetal = defensorContrario.getMetalCost()*Variables.PERCENTATGE_WASTE/100;
							int residuoDeuterio = defensorContrario.getDeuteriumCost()*Variables.PERCENTATGE_WASTE/100;
							ResiduosTotalMetal += residuosMetal;
							ResiduosTotalDeuterium += residuoDeuterio;
						}
						planetArmy[0].remove(defensorContrario);
//						sumaEjercitoDefensor = sumaEjercitoDefensor -1;
						System.out.println("Eliminado lighthunter");
					
					}
					else if (defensorContrario.getClass().getName().equals("HeavyHunter")) {
						if (probabilidadRecursos <= Variables.CHANCE_GENERATNG_WASTE_HEAVYHUNTER) {
							int residuosMetal = defensorContrario.getMetalCost()*Variables.PERCENTATGE_WASTE/100;
							int residuoDeuterio = defensorContrario.getDeuteriumCost()*Variables.PERCENTATGE_WASTE/100;
							ResiduosTotalMetal += residuosMetal;
							ResiduosTotalDeuterium += residuoDeuterio;
						}
						planetArmy[1].remove(defensorContrario);
//						sumaEjercitoDefensor = sumaEjercitoDefensor -1;
						System.out.println("Eliminado heavyhunter");
						
						
					}
					else if (defensorContrario.getClass().getName().equals("BattleShip")) {
						if (probabilidadRecursos <= Variables.CHANCE_GENERATNG_WASTE_BATTLESHIP) {
							int residuosMetal = defensorContrario.getMetalCost()*Variables.PERCENTATGE_WASTE/100;
							int residuoDeuterio = defensorContrario.getDeuteriumCost()*Variables.PERCENTATGE_WASTE/100;
							ResiduosTotalMetal += residuosMetal;
							ResiduosTotalDeuterium += residuoDeuterio;
						}
						planetArmy[2].remove(defensorContrario);
//						sumaEjercitoDefensor = sumaEjercitoDefensor -1;
						System.out.println("Eliminado battleship");
						
					}
					else if (defensorContrario.getClass().getName().equals("ArmoredShip")) {
						if (probabilidadRecursos <= Variables.CHANCE_GENERATNG_WASTE_ARMOREDSHIP) {
							int residuosMetal = defensorContrario.getMetalCost()*Variables.PERCENTATGE_WASTE/100;
							int residuoDeuterio = defensorContrario.getDeuteriumCost()*Variables.PERCENTATGE_WASTE/100;
							ResiduosTotalMetal += residuosMetal;
							ResiduosTotalDeuterium += residuoDeuterio;
						}
						planetArmy[3].remove(defensorContrario);
//						sumaEjercitoDefensor = sumaEjercitoDefensor -1;
						System.out.println("Eliminado armoredship");
						
						
					}
					else if (defensorContrario.getClass().getName().equals("MissileLauncher")) {
						if (probabilidadRecursos <= Variables.CHANCE_GENERATNG_WASTE_MISSILELAUNCHER) {
							int residuosMetal = defensorContrario.getMetalCost()*Variables.PERCENTATGE_WASTE/100;
							int residuoDeuterio = defensorContrario.getDeuteriumCost()*Variables.PERCENTATGE_WASTE/100;
							ResiduosTotalMetal += residuosMetal;
							ResiduosTotalDeuterium += residuoDeuterio;
						}
						planetArmy[4].remove(defensorContrario);
//						sumaEjercitoDefensor = sumaEjercitoDefensor -1;
						System.out.println("Eliminado missilelauncher");
						
						
					}
					else if (defensorContrario.getClass().getName().equals("IonCannon")) {
						if (probabilidadRecursos <= Variables.CHANCE_GENERATNG_WASTE_IONCANNON) {
							int residuosMetal = defensorContrario.getMetalCost()*Variables.PERCENTATGE_WASTE/100;
							int residuoDeuterio = defensorContrario.getDeuteriumCost()*Variables.PERCENTATGE_WASTE/100;
							ResiduosTotalMetal += residuosMetal;
							ResiduosTotalDeuterium += residuoDeuterio;
						}
						planetArmy[5].remove(defensorContrario);
//						sumaEjercitoDefensor = sumaEjercitoDefensor -1;
						System.out.println("Eliminado ioncannon");
						
						
					}
					else if (defensorContrario.getClass().getName().equals("PlasmaCannon")) {
						if (probabilidadRecursos <= Variables.CHANCE_GENERATNG_WASTE_PLASMACANNON) {
							int residuosMetal = defensorContrario.getMetalCost()*Variables.PERCENTATGE_WASTE/100;
							int residuoDeuterio = defensorContrario.getDeuteriumCost()*Variables.PERCENTATGE_WASTE/100;
							ResiduosTotalMetal += residuosMetal;
							ResiduosTotalDeuterium += residuoDeuterio;
						}
						planetArmy[6].remove(defensorContrario);
//						sumaEjercitoDefensor = sumaEjercitoDefensor -1;
						System.out.println("Eliminado plasmacannon");
						
					}
				}
				
				if (atacanteContrario.getClass().getName().equals("LightHunter")) {
					if (probabilidadAtacar <= Variables.CHANCE_ATTACK_AGAIN_LIGTHHUNTER) {
						defensorContrario = EjercitoDefensorNuestro();
						if (defensorContrario.getClass().getName().equals("LightHunter")) {
							if (planetArmy[0].size() > 0) {
								defensorContrario = planetArmy[0].get((int)(Math.random()*planetArmy[0].size()));
							}
							else {
								System.out.println("hacer algo!!");
							}
							
							
								
						}
						else if (defensorContrario.getClass().getName().equals("HeavyHunter")) {
							if (planetArmy[1].size() > 0) {
								defensorContrario = planetArmy[1].get((int)(Math.random()*planetArmy[1].size()));
							}
							else {
								System.out.println("hacer algo");
							}
							
						}
						else if (defensorContrario.getClass().getName().equals("BattleShip")) {
							if (planetArmy[2].size() > 0) {
								defensorContrario = planetArmy[2].get((int)(Math.random()*planetArmy[2].size()));
							}
							else {
								System.out.println("hacer algo");
							}
							
						}
						else if (defensorContrario.getClass().getName().equals("ArmoredShip")) {
							if (planetArmy[3].size() > 0) {
								defensorContrario = planetArmy[3].get((int)(Math.random()*planetArmy[3].size()));
							}
							else {
								System.out.println("hacer algo");
							}
	
						}
						else if (defensorContrario.getClass().getName().equals("MissileLauncher")) {
							if (planetArmy[4].size() > 0) {
								defensorContrario = planetArmy[4].get((int)(Math.random()*planetArmy[4].size()));
							}
							else {
								System.out.println("hacer algo");
							}
							
						}
						else if (defensorContrario.getClass().getName().equals("IonCannon")) {
							if (planetArmy[5].size() > 0) {
								defensorContrario = planetArmy[5].get((int)(Math.random()*planetArmy[5].size()));
							}
							else {
								System.out.println("hacer algo");
							}
							
						}
						else if (defensorContrario.getClass().getName().equals("PlasmaCannon")) {
							if (planetArmy[6].size() > 0) {
								defensorContrario = planetArmy[6].get((int)(Math.random()*planetArmy[6].size()));
							}
							else {
								System.out.println("hacer algo");
							}
							
						}
					}
					else {
						turnoPlanetaAtacante = false;
						turnoMiplaneta = true;
						
					}
					System.out.println("Attacks Planet enemy: " + atacanteContrario.getClass().getName() + " attacks " + defensorContrario.getClass().getName());
					System.out.println(atacanteContrario.getClass().getName() + " generates the damage = " + atacanteContrario.attack());
					defensorContrario.tekeDamage(atacanteContrario.attack());
					System.out.println(defensorContrario.getClass().getName() + " stays with armor = " + defensorContrario.getActualArmor());
				}
				else if (atacanteContrario.getClass().getName().equals("HeavyHunter")) {
					if (probabilidadAtacar <= Variables.CHANCE_ATTACK_AGAIN_HEAVYHUNTER) {
						defensorContrario = EjercitoDefensorNuestro();
						if (defensorContrario.getClass().getName().equals("LightHunter")) {
							if (planetArmy[0].size() > 0) {
								defensorContrario = planetArmy[0].get((int)(Math.random()*planetArmy[0].size()));
							}
							else {
								System.out.println("haer algo");
							}
							
						}
						else if (defensorContrario.getClass().getName().equals("HeavyHunter")) {
							if (planetArmy[1].size() > 0) {
								defensorContrario = planetArmy[1].get((int)(Math.random()*planetArmy[1].size()));
							}
							else {
								System.out.println("hacer algo");
							}
							
						}
						else if (defensorContrario.getClass().getName().equals("BattleShip")) {
							if (planetArmy[2].size() > 0) {
								defensorContrario = planetArmy[2].get((int)(Math.random()*planetArmy[2].size()));
							}
							else {
								System.out.println("hacer algo");
							}
						
						}
						else if (defensorContrario.getClass().getName().equals("ArmoredShip")) {
							if (planetArmy[3].size() > 0) {
								defensorContrario = planetArmy[3].get((int)(Math.random()*planetArmy[3].size()));
							}
							else {
								System.out.println("hacer algo");
							}
							
						}
						else if (defensorContrario.getClass().getName().equals("MissileLauncher")) {
							if (planetArmy[4].size() > 0) {
								defensorContrario = planetArmy[4].get((int)(Math.random()*planetArmy[4].size()));
							}
							else {
								System.out.println("hacer alo");
							}
							
						}
						else if (defensorContrario.getClass().getName().equals("IonCannon")) {
							if (planetArmy[5].size() > 0) {
								defensorContrario = planetArmy[5].get((int)(Math.random()*planetArmy[5].size()));
							}
							else {
								System.out.println("hacer algo");
							}
							
						}
						else if (defensorContrario.getClass().getName().equals("PlasmaCannon")) {
							if (planetArmy[6].size() > 0) {
								defensorContrario = planetArmy[6].get((int)(Math.random()*planetArmy[6].size()));
							}
							else {
								System.out.println("hacer algo");
							}
							
						}
					}
					else {
						turnoPlanetaAtacante = false;
						turnoMiplaneta = true;
					}
					System.out.println("Attacks fleet enemy: " + atacanteContrario.getClass().getName() + " attacks " + defensorContrario.getClass().getName());
					System.out.println(atacanteContrario.getClass().getName() + " generates the damage = " + atacanteContrario.attack());
					defensorContrario.tekeDamage(atacanteContrario.attack());
					System.out.println(defensorContrario.getClass().getName() + " stays with armor = " + defensorContrario.getActualArmor());
				}
				else if (atacanteContrario.getClass().getName().equals("BattleShip")) {
					if (probabilidadAtacar <= Variables.CHANCE_ATTACK_AGAIN_BATTLESHIP) {
						defensorContrario = EjercitoDefensorNuestro();
						if (defensorContrario.getClass().getName().equals("LightHunter")) {
							if (planetArmy[0].size() > 0) {
								defensorContrario = planetArmy[0].get((int)(Math.random()*planetArmy[0].size()));
							}
							else {
								System.out.println("hacer algo");
							}
							
						}
						else if (defensorContrario.getClass().getName().equals("HeavyHunter")) {
							if (planetArmy[1].size() > 0) {
								defensorContrario = planetArmy[1].get((int)(Math.random()*planetArmy[1].size()));
							}
							else {
								System.out.println("hacer algo");
							}
							
						}
						else if (defensorContrario.getClass().getName().equals("BattleShip")) {
							if (planetArmy[2].size() > 0) {
								defensorContrario = planetArmy[2].get((int)(Math.random()*planetArmy[2].size()));
							}
							else {
								System.out.println("hacer algo");
							}
							
						}
						else if (defensorContrario.getClass().getName().equals("ArmoredShip")) {
							if (planetArmy[3].size() > 0) {
								defensorContrario = planetArmy[3].get((int)(Math.random()*planetArmy[3].size()));
							}
							else {
								System.out.println("hacer algo");
							}
							
						}
						else if (defensorContrario.getClass().getName().equals("MissileLauncher")) {
							if (planetArmy[4].size() > 0) {
								defensorContrario = planetArmy[4].get((int)(Math.random()*planetArmy[4].size()));
							}
							else {
								System.out.println("acer algo");
							}
							
						}
						else if (defensorContrario.getClass().getName().equals("IonCannon")) {
							if (planetArmy[5].size() > 0) {
								defensorContrario = planetArmy[5].get((int)(Math.random()*planetArmy[5].size()));
							}
							else {
								System.out.println("hacer alfo");
							}
							
						}
						else if (defensorContrario.getClass().getName().equals("PlasmaCannon")) {
							if (planetArmy[6].size() > 0) {
								defensorContrario = planetArmy[6].get((int)(Math.random()*planetArmy[6].size()));
							}
							else {
								System.out.println("hacer ajaja");
							}
							
						}
					}
					else {
						turnoPlanetaAtacante = false;
						turnoMiplaneta = true;
					}
					System.out.println("Attacks fleet enemy: " + atacanteContrario.getClass().getName() + " attacks " + defensorContrario.getClass().getName());
					System.out.println(atacanteContrario.getClass().getName() + " generates the damage = " + atacanteContrario.attack());
					defensorContrario.tekeDamage(atacanteContrario.attack());
					System.out.println(defensorContrario.getClass().getName() + " stays with armor = " + defensorContrario.getActualArmor());
				}
				else if (atacanteContrario.getClass().getName().equals("ArmoredShip")) {
					if (probabilidadAtacar <= Variables.CHANCE_ATTACK_AGAIN_ARMOREDSHIP) {
						defensorContrario = EjercitoDefensorNuestro();
						if (defensorContrario.getClass().getName().equals("LightHunter")) {
							if (planetArmy[0].size() > 0) {
								defensorContrario = planetArmy[0].get((int)(Math.random()*planetArmy[0].size()));
							}
							else {
								System.out.println("hacer algo");
							}
							
						}
						else if (defensorContrario.getClass().getName().equals("HeavyHunter")) {
							if (planetArmy[1].size() > 0) {
								defensorContrario = planetArmy[1].get((int)(Math.random()*planetArmy[1].size()));
							}
							else {
								System.out.println("hacer alfgo");
							}
							
						}
						else if (defensorContrario.getClass().getName().equals("BattleShip")) {
							if (planetArmy[2].size() > 0) {
								defensorContrario = planetArmy[2].get((int)(Math.random()*planetArmy[2].size()));
							}
							else {
								System.out.println("hacer algo");
							}
							
						}
						else if (defensorContrario.getClass().getName().equals("ArmoredShip")) {
							if (planetArmy[3].size() > 0) {
								defensorContrario = planetArmy[3].get((int)(Math.random()*planetArmy[3].size()));
							}
							else {
								System.out.println("hacer alfo");
							}
							
						}
						else if (defensorContrario.getClass().getName().equals("MissileLauncher")) {
							if (planetArmy[4].size() > 0) {
								defensorContrario = planetArmy[4].get((int)(Math.random()*planetArmy[4].size()));
							}
							else {
								System.out.println("hacer algo");
							}
							
						}
						else if (defensorContrario.getClass().getName().equals("IonCannon")) {
							if (planetArmy[5].size() > 0) {
								defensorContrario = planetArmy[5].get((int)(Math.random()*planetArmy[5].size()));
							}
							else {
								System.out.println("hacer algo");
							}
							
						}
						else if (defensorContrario.getClass().getName().equals("PlasmaCannon")) {
							if (planetArmy[6].size() > 0) {
								defensorContrario = planetArmy[6].get((int)(Math.random()*planetArmy[6].size()));
							}
							else {
								System.out.println("hacer algo");
							}
							
						}
					}
					else {
						turnoPlanetaAtacante = false;
						turnoMiplaneta = true;
					}
					System.out.println("Attacks fleet enemy: " + atacanteContrario.getClass().getName() + " attacks " + defensorContrario.getClass().getName());
					System.out.println(atacanteContrario.getClass().getName() + " generates the damage = " + atacanteContrario.attack());
					defensorContrario.tekeDamage(atacanteContrario.attack());
					System.out.println(defensorContrario.getClass().getName() + " stays with armor = " + defensorContrario.getActualArmor());
				}
				
			}
			if (turnoMiplaneta) {
				System.out.println("*****CHANGE ATTACKER*****");
				System.out.println("Attacks Planet enemy: " + atacanteMiPlaneta.getClass().getName() + " attacks " + defensorMiPlaneta.getClass().getName());
				System.out.println(atacanteMiPlaneta.getClass().getName() + " generates the damage = " + atacanteMiPlaneta.attack());
				defensorMiPlaneta.tekeDamage(atacanteMiPlaneta.attack());
				System.out.println(defensorMiPlaneta.getClass().getName() + " stays with armor = " + defensorMiPlaneta.getActualArmor());
				int probabilidadRecursos = (int)((Math.random()* 100)+1);
				int probabilidadAtacar = (int)((Math.random()* 100)+1);
				if (defensorMiPlaneta.getActualArmor() <= 0) {
					if (defensorMiPlaneta.getClass().getName().equals("LightHunter")) {
						if (probabilidadRecursos <= Variables.CHANCE_GENERATNG_WASTE_LIGTHHUNTER) {
							int residuosMetal = defensorMiPlaneta.getMetalCost()*Variables.PERCENTATGE_WASTE/100;
							int residuoDeuterio = defensorMiPlaneta.getDeuteriumCost()*Variables.PERCENTATGE_WASTE/100;
							ResiduosTotalMetal += residuosMetal;
							ResiduosTotalDeuterium += residuoDeuterio;
						}
						planetArmy[0].remove(defensorMiPlaneta);
//						sumaEjercitoDefensor = sumaEjercitoDefensor -1;
						System.out.println("Eliminado lighthunter");
						
					
					}
					else if (defensorMiPlaneta.getClass().getName().equals("HeavyHunter")) {
						if (probabilidadRecursos <= Variables.CHANCE_GENERATNG_WASTE_HEAVYHUNTER) {
							int residuosMetal = defensorMiPlaneta.getMetalCost()*Variables.PERCENTATGE_WASTE/100;
							int residuoDeuterio = defensorMiPlaneta.getDeuteriumCost()*Variables.PERCENTATGE_WASTE/100;
							ResiduosTotalMetal += residuosMetal;
							ResiduosTotalDeuterium += residuoDeuterio;
						}
						planetArmy[1].remove(defensorMiPlaneta);
//						sumaEjercitoDefensor = sumaEjercitoDefensor -1;
						System.out.println("Eliminado heavyhunter");
						
						
					}
					else if (defensorMiPlaneta.getClass().getName().equals("BattleShip")) {
						if (probabilidadRecursos <= Variables.CHANCE_GENERATNG_WASTE_BATTLESHIP) {
							int residuosMetal = defensorMiPlaneta.getMetalCost()*Variables.PERCENTATGE_WASTE/100;
							int residuoDeuterio = defensorMiPlaneta.getDeuteriumCost()*Variables.PERCENTATGE_WASTE/100;
							ResiduosTotalMetal += residuosMetal;
							ResiduosTotalDeuterium += residuoDeuterio;
						}
						planetArmy[2].remove(defensorMiPlaneta);
//						sumaEjercitoDefensor = sumaEjercitoDefensor -1;
						System.out.println("Eliminado battleship");
					}
					else if (defensorMiPlaneta.getClass().getName().equals("ArmoredShip")) {
						if (probabilidadRecursos <= Variables.CHANCE_GENERATNG_WASTE_ARMOREDSHIP) {
							int residuosMetal = defensorMiPlaneta.getMetalCost()*Variables.PERCENTATGE_WASTE/100;
							int residuoDeuterio = defensorMiPlaneta.getDeuteriumCost()*Variables.PERCENTATGE_WASTE/100;
							ResiduosTotalMetal += residuosMetal;
							ResiduosTotalDeuterium += residuoDeuterio;
						}
						planetArmy[3].remove(defensorMiPlaneta);
//						sumaEjercitoDefensor = sumaEjercitoDefensor -1;
						System.out.println("Eliminado armoredship");
						
					}
					else if (defensorMiPlaneta.getClass().getName().equals("MissileLauncher")) {
						if (probabilidadRecursos <= Variables.CHANCE_GENERATNG_WASTE_MISSILELAUNCHER) {
							int residuosMetal = defensorMiPlaneta.getMetalCost()*Variables.PERCENTATGE_WASTE/100;
							int residuoDeuterio = defensorMiPlaneta.getDeuteriumCost()*Variables.PERCENTATGE_WASTE/100;
							ResiduosTotalMetal += residuosMetal;
							ResiduosTotalDeuterium += residuoDeuterio;
						}
						planetArmy[4].remove(defensorMiPlaneta);
//						sumaEjercitoDefensor = sumaEjercitoDefensor -1;
						System.out.println("Eliminado missilelauncher");

						
					}
					else if (defensorMiPlaneta.getClass().getName().equals("IonCannon")) {
						if (probabilidadRecursos <= Variables.CHANCE_GENERATNG_WASTE_IONCANNON) {
							int residuosMetal = defensorMiPlaneta.getMetalCost()*Variables.PERCENTATGE_WASTE/100;
							int residuoDeuterio = defensorMiPlaneta.getDeuteriumCost()*Variables.PERCENTATGE_WASTE/100;
							ResiduosTotalMetal += residuosMetal;
							ResiduosTotalDeuterium += residuoDeuterio;
						}
						planetArmy[5].remove(defensorMiPlaneta);
//						sumaEjercitoDefensor = sumaEjercitoDefensor -1;
						System.out.println("Eliminado ioncannon");
						
					}
					else if (defensorMiPlaneta.getClass().getName().equals("PlasmaCannon")) {
						if (probabilidadRecursos <= Variables.CHANCE_GENERATNG_WASTE_PLASMACANNON) {
							int residuosMetal = defensorMiPlaneta.getMetalCost()*Variables.PERCENTATGE_WASTE/100;
							int residuoDeuterio = defensorMiPlaneta.getDeuteriumCost()*Variables.PERCENTATGE_WASTE/100;
							ResiduosTotalMetal += residuosMetal;
							ResiduosTotalDeuterium += residuoDeuterio;
						}
						enemyArmy[6].remove(defensorMiPlaneta);
//						sumaEjercitoDefensor = sumaEjercitoDefensor -1;
						System.out.println("Eliminado plasmacannon");
			
					}
				}
				
			}
		}
		
		
	}
	
	
	
	
	
}









