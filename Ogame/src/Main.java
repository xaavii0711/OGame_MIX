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
		Planet planetaEnemigo = new Planet();
		Battle b = new Battle();
		b.createEnemyArmy();
		b.playBattle();
		
		
		CallableStatement cst3,cst4,cst5,cst6,cst7,cst8,cst9,cst10,cst11,cst12,cst13,cst14,cst15;
		BufferedReader entrada;
		int id;
		Connection cn;
		cn = null;
		id = 0;
		int id_batalla = 1;
        
        try {
            // Carga el driver de oracle
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            
            // Conecta con la base de datos orcl con el usuario system y la contrase�a password
            cn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.40.2:1521:orcl", "alumnoMIX4", "alumnoMIX4");
            //cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "P@ssw0rd");
           
            
            // Llamada al procedimiento almacenado
            cst4 = cn.prepareCall("{call insert_ships_in_planets (?,?,?,?,?,?,?)}");
            cst5 = cn.prepareCall("{call insert_ships_in_planets (?,?,?,?,?,?,?)}");
            cst6 = cn.prepareCall("{call insert_ships_in_planets (?,?,?,?,?,?,?)}");
            cst7 = cn.prepareCall("{call insert_ships_in_planets (?,?,?,?,?,?,?)}");
            cst11 = cn.prepareCall("{call insert_ships_in_planets (?,?,?,?,?,?,?)}");
            cst12 = cn.prepareCall("{call insert_ships_in_planets (?,?,?,?,?,?,?)}");
            cst13 = cn.prepareCall("{call insert_ships_in_planets (?,?,?,?,?,?,?)}");
            cst14 = cn.prepareCall("{call insert_ships_in_planets (?,?,?,?,?,?,?)}");
            cst8 = cn.prepareCall("{call insert_planets (?,?,?,?,?,?,?,?,?,?)}");
            cst9 = cn.prepareCall("{call insert_defenses_in_planets (?,?,?,?,?,?,?)}");
            cst10 = cn.prepareCall("{call insert_defenses_in_planets (?,?,?,?,?,?,?)}");
            cst15 = cn.prepareCall("{call insert_defenses_in_planets (?,?,?,?,?,?,?)}");
            do {
            	//cada ejecucion hacer commit para q se guarde bien
            	
            	cst4.setInt(1, 1);
            	cst4.registerOutParameter(2, java.sql.Types.INTEGER);
            	cst4.registerOutParameter(3, java.sql.Types.INTEGER);
            	cst4.registerOutParameter(4, java.sql.Types.INTEGER);
            	cst4.registerOutParameter(5, java.sql.Types.INTEGER);
            	cst4.registerOutParameter(6, java.sql.Types.INTEGER);
            	cst4.registerOutParameter(7, java.sql.Types.INTEGER);
            	cst4.setInt(1, id_batalla);
            	cst4.setInt(2, 1);
            	cst4.setInt(3, 1);
            	cst4.setInt(4, b.LightHunterMiosComienzo);
            	cst4.setInt(5, b.LightHunterMiosFinal);
            	cst4.setInt(6, 0);
            	cst4.setInt(7, 0);
            	cst4.execute();
            	
            	cst5.setInt(1, 2);
            	cst5.registerOutParameter(2, java.sql.Types.INTEGER);
            	cst5.registerOutParameter(3, java.sql.Types.INTEGER);
            	cst5.registerOutParameter(4, java.sql.Types.INTEGER);
            	cst5.registerOutParameter(5, java.sql.Types.INTEGER);
            	cst5.registerOutParameter(6, java.sql.Types.INTEGER);
            	cst5.registerOutParameter(7, java.sql.Types.INTEGER);
            	cst5.setInt(1, id_batalla);
            	cst5.setInt(2, 1);
            	cst5.setInt(3, 2);
            	cst5.setInt(4, b.HeavyHunterMiosComienzo);
            	cst5.setInt(5, b.HeavyHunterMiosFinal);
            	cst5.setInt(6, 0);
            	cst5.setInt(7, 0);
            	cst5.execute();
            	
            	cst6.setInt(1, 3);
            	cst6.registerOutParameter(2, java.sql.Types.INTEGER);
            	cst6.registerOutParameter(3, java.sql.Types.INTEGER);
            	cst6.registerOutParameter(4, java.sql.Types.INTEGER);
            	cst6.registerOutParameter(5, java.sql.Types.INTEGER);
            	cst6.registerOutParameter(6, java.sql.Types.INTEGER);
            	cst6.registerOutParameter(7, java.sql.Types.INTEGER);
            	cst6.setInt(1, id_batalla);
            	cst6.setInt(2, 1);
            	cst6.setInt(3, 3);
            	cst6.setInt(4, b.BattleShipMiosComienzo);
            	cst6.setInt(5, b.BattleShipMiosFinal);
            	cst6.setInt(6, 0);
            	cst6.setInt(7, 0);
            	cst6.execute();
            	
            	cst7.setInt(1, 4);
            	cst7.registerOutParameter(2, java.sql.Types.INTEGER);
            	cst7.registerOutParameter(3, java.sql.Types.INTEGER);
            	cst7.registerOutParameter(4, java.sql.Types.INTEGER);
            	cst7.registerOutParameter(5, java.sql.Types.INTEGER);
            	cst7.registerOutParameter(6, java.sql.Types.INTEGER);
            	cst7.registerOutParameter(7, java.sql.Types.INTEGER);
            	cst7.setInt(1, id_batalla);
            	cst7.setInt(2, 1);
            	cst7.setInt(3, 4);
            	cst7.setInt(4, b.ArmoredShipMiosComienzo);
            	cst7.setInt(5, b.ArmoredShipMiosFinal);
            	cst7.setInt(6, 0);
            	cst7.setInt(7, 0);
            	cst7.execute();
            	
            	cst11.setInt(1, 5);
            	cst11.registerOutParameter(2, java.sql.Types.INTEGER);
            	cst11.registerOutParameter(3, java.sql.Types.INTEGER);
            	cst11.registerOutParameter(4, java.sql.Types.INTEGER);
            	cst11.registerOutParameter(5, java.sql.Types.INTEGER);
            	cst11.registerOutParameter(6, java.sql.Types.INTEGER);
            	cst11.registerOutParameter(7, java.sql.Types.INTEGER);
            	cst11.setInt(1, id_batalla);
            	cst11.setInt(2, 2);
            	cst11.setInt(3, 1);
            	cst11.setInt(4, b.LightHuntersEnemigoComienzo);
            	cst11.setInt(5, b.LightHuntersEnemigoFinal);
            	cst11.setInt(6, 0);
            	cst11.setInt(7, 0);
            	cst11.execute();
            	
            	cst12.setInt(1, 6);
            	cst12.registerOutParameter(2, java.sql.Types.INTEGER);
            	cst12.registerOutParameter(3, java.sql.Types.INTEGER);
            	cst12.registerOutParameter(4, java.sql.Types.INTEGER);
            	cst12.registerOutParameter(5, java.sql.Types.INTEGER);
            	cst12.registerOutParameter(6, java.sql.Types.INTEGER);
            	cst12.registerOutParameter(7, java.sql.Types.INTEGER);
            	cst12.setInt(1, id_batalla);
            	cst12.setInt(2, 2);
            	cst12.setInt(3, 2);
            	cst12.setInt(4, b.HeavyHuntersEnemigoComienzo);
            	cst12.setInt(5, b.HeavyHuntersEnemigoFinal);
            	cst12.setInt(6, 0);
            	cst12.setInt(7, 0);
            	cst12.execute();
            	
            	cst13.setInt(1, 7);
            	cst13.registerOutParameter(2, java.sql.Types.INTEGER);
            	cst13.registerOutParameter(3, java.sql.Types.INTEGER);
            	cst13.registerOutParameter(4, java.sql.Types.INTEGER);
            	cst13.registerOutParameter(5, java.sql.Types.INTEGER);
            	cst13.registerOutParameter(6, java.sql.Types.INTEGER);
            	cst13.registerOutParameter(7, java.sql.Types.INTEGER);
            	cst13.setInt(1, id_batalla);
            	cst13.setInt(2, 2);
            	cst13.setInt(3, 3);
            	cst13.setInt(4, b.BattleShipEnemigoComienzo);
            	cst13.setInt(5, b.BattleShipEnemigoFinal);
            	cst13.setInt(6, 0);
            	cst13.setInt(7, 0);
            	cst13.execute();
            	
            	cst14.setInt(1, 8);
            	cst14.registerOutParameter(2, java.sql.Types.INTEGER);
            	cst14.registerOutParameter(3, java.sql.Types.INTEGER);
            	cst14.registerOutParameter(4, java.sql.Types.INTEGER);
            	cst14.registerOutParameter(5, java.sql.Types.INTEGER);
            	cst14.registerOutParameter(6, java.sql.Types.INTEGER);
            	cst14.registerOutParameter(7, java.sql.Types.INTEGER);
            	cst14.setInt(1, id_batalla);
            	cst14.setInt(2, 2);
            	cst14.setInt(3, 4);
            	cst14.setInt(4, b.ArmoredShipEnemigoComienzo);
            	cst14.setInt(5, b.ArmoredShipEnemigoFinal);
            	cst14.setInt(6, 0);
            	cst14.setInt(7, 0);
            	cst14.execute();
            	
            	cst9.setInt(1, 1);
            	cst9.registerOutParameter(2, java.sql.Types.INTEGER);
            	cst9.registerOutParameter(3, java.sql.Types.INTEGER);
            	cst9.registerOutParameter(4, java.sql.Types.INTEGER);
            	cst9.registerOutParameter(5, java.sql.Types.INTEGER);
            	cst9.registerOutParameter(6, java.sql.Types.INTEGER);
            	cst9.registerOutParameter(7, java.sql.Types.INTEGER);
            	cst9.setInt(1, id_batalla);
            	cst9.setInt(2, 1);
            	cst9.setInt(3, 1);
            	cst9.setInt(4, b.MissileLauncherMiosComienzo);
            	cst9.setInt(5, b.MissileLauncherMiosFinal);
            	cst9.setInt(6, 0);
            	cst9.setInt(7, 0);
            	cst9.execute();
            	
            	cst10.setInt(1, 2);
            	cst10.registerOutParameter(2, java.sql.Types.INTEGER);
            	cst10.registerOutParameter(3, java.sql.Types.INTEGER);
            	cst10.registerOutParameter(4, java.sql.Types.INTEGER);
            	cst10.registerOutParameter(5, java.sql.Types.INTEGER);
            	cst10.registerOutParameter(6, java.sql.Types.INTEGER);
            	cst10.registerOutParameter(7, java.sql.Types.INTEGER);
            	cst10.setInt(1, id_batalla);
            	cst10.setInt(2, 1);
            	cst10.setInt(3, 2);
            	cst10.setInt(4, b.IonCannonMiosComienzo);
            	cst10.setInt(5, b.IonCannonMiosFinal);
            	cst10.setInt(6, 0);
            	cst10.setInt(7, 0);
            	cst10.execute();
            	
            	cst15.setInt(1, 3);
            	cst15.registerOutParameter(2, java.sql.Types.INTEGER);
            	cst15.registerOutParameter(3, java.sql.Types.INTEGER);
            	cst15.registerOutParameter(4, java.sql.Types.INTEGER);
            	cst15.registerOutParameter(5, java.sql.Types.INTEGER);
            	cst15.registerOutParameter(6, java.sql.Types.INTEGER);
            	cst15.registerOutParameter(7, java.sql.Types.INTEGER);
            	cst15.setInt(1, id_batalla);
            	cst15.setInt(2, 1);
            	cst15.setInt(3, 3);
            	cst15.setInt(4, b.PlasmaCannonMiosComienzo);
            	cst15.setInt(5, b.PlasmaCannonMiosFinal);
            	cst15.setInt(6, 0);
            	cst15.setInt(7, 0);
            	cst15.execute();
            	
            	
                cst8.setInt(1, 2);
                cst8.registerOutParameter(2, java.sql.Types.CHAR);
                cst8.registerOutParameter(3, java.sql.Types.INTEGER);
                cst8.registerOutParameter(4, java.sql.Types.INTEGER);
                cst8.registerOutParameter(5, java.sql.Types.INTEGER);
                cst8.registerOutParameter(6, java.sql.Types.INTEGER);
                cst8.registerOutParameter(7, java.sql.Types.INTEGER);
                cst8.registerOutParameter(8, java.sql.Types.INTEGER);
                cst8.registerOutParameter(9, java.sql.Types.INTEGER);
                cst8.registerOutParameter(10, java.sql.Types.INTEGER);
                cst8.setInt(1, 1);
                cst8.setString(2, "MyPlanet");
                System.out.println(miPlaneta.getTechnologyAtack());
                cst8.setInt(3, miPlaneta.getTechnologyAtack());
                cst8.setInt(4, miPlaneta.getTechnologyDefense());
                cst8.setInt(5, miPlaneta.getUpgradeAttackTechnologyDeuteriumCost());
                cst8.setInt(6, 0);
                cst8.setInt(7, miPlaneta.getUpgradeDefenseTechnologyDeuteriumCost());
                cst8.setInt(8, miPlaneta.getMetal());
                cst8.setInt(9, miPlaneta.getDeuterium());
                cst8.setInt(10, 1);
                cst8.execute();
                
                System.out.println("Datos insertados correctamente");
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
	private ArrayList<MilitaryUnit>[] enemyArmy;
	
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
//		enemyArmy[0].add(new LightHunter());
//		enemyArmy[1].add(new HeavyHunter());
//		enemyArmy[2].add(new BattleShip());
//		enemyArmy[3].add(new ArmoredShip());
//		enemyArmy[0].add(new LightHunter());
//		enemyArmy[1].add(new HeavyHunter());
//		enemyArmy[2].add(new BattleShip());
//		enemyArmy[3].add(new ArmoredShip());
//		enemyArmy[0].add(new LightHunter());
//		enemyArmy[1].add(new HeavyHunter());
//		enemyArmy[2].add(new BattleShip());
//		enemyArmy[3].add(new ArmoredShip());
//		enemyArmy[0].add(new LightHunter());
//		enemyArmy[1].add(new HeavyHunter());
//		enemyArmy[2].add(new BattleShip());
//		enemyArmy[3].add(new ArmoredShip());
		planetArmy[0].add(new LightHunter());
		planetArmy[1].add(new HeavyHunter());
		planetArmy[2].add(new BattleShip());
		planetArmy[3].add(new ArmoredShip());
		planetArmy[4].add(new MissileLauncher());
		planetArmy[0].add(new LightHunter());
		planetArmy[0].add(new LightHunter());
		planetArmy[1].add(new HeavyHunter());
		planetArmy[1].add(new HeavyHunter());
		planetArmy[1].add(new HeavyHunter());
		planetArmy[2].add(new BattleShip());
		planetArmy[2].add(new BattleShip());
		planetArmy[3].add(new ArmoredShip());
		planetArmy[3].add(new ArmoredShip());
		planetArmy[4].add(new MissileLauncher());
		planetArmy[4].add(new MissileLauncher());
		
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
	
	
	
	public void playBattle() {
		
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
							if (!eliminado) {
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
							if (!eliminado) {
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
							if (!eliminado) {
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
							if (!eliminado) {
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
							if (!eliminado) {
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
							if (!eliminado) {
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
							if (!eliminado) {
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
//						if (probabilidadRecursosEnemigo <= Variables.CHANCE_GENERATNG_WASTE_LIGTHHUNTER) {
//							int residuosMetal = defensorContrario.getMetalCost()*Variables.PERCENTATGE_WASTE/100;
//							int residuoDeuterio = defensorContrario.getDeuteriumCost()*Variables.PERCENTATGE_WASTE/100;
//							ResiduosTotalMetal += residuosMetal;
//							ResiduosTotalDeuterium += residuoDeuterio;
//						}
						if (enemyArmy[0].size() > 0) {
							boolean eliminado = enemyArmy[0].remove(defensorContrario);
							if (!eliminado) {
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
//						if (probabilidadRecursosEnemigo <= Variables.CHANCE_GENERATNG_WASTE_HEAVYHUNTER) {
//							int residuosMetal = defensorContrario.getMetalCost()*Variables.PERCENTATGE_WASTE/100;
//							int residuoDeuterio = defensorContrario.getDeuteriumCost()*Variables.PERCENTATGE_WASTE/100;
//							ResiduosTotalMetal += residuosMetal;
//							ResiduosTotalDeuterium += residuoDeuterio;
//						}
						if (enemyArmy[1].size() > 0) {
							boolean eliminado = enemyArmy[1].remove(defensorContrario);
							if (!eliminado) {
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
//						if (probabilidadRecursosEnemigo <= Variables.CHANCE_GENERATNG_WASTE_BATTLESHIP) {
//							int residuosMetal = defensorContrario.getMetalCost()*Variables.PERCENTATGE_WASTE/100;
//							int residuoDeuterio = defensorContrario.getDeuteriumCost()*Variables.PERCENTATGE_WASTE/100;
//							ResiduosTotalMetal += residuosMetal;
//							ResiduosTotalDeuterium += residuoDeuterio;
//						}
						if (enemyArmy[2].size() > 0) {
							boolean eliminado = enemyArmy[2].remove(defensorContrario);
							if (!eliminado) {
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
//						if (probabilidadRecursosEnemigo <= Variables.CHANCE_GENERATNG_WASTE_ARMOREDSHIP) {
//							int residuosMetal = defensorContrario.getMetalCost()*Variables.PERCENTATGE_WASTE/100;
//							int residuoDeuterio = defensorContrario.getDeuteriumCost()*Variables.PERCENTATGE_WASTE/100;
//							ResiduosTotalMetal += residuosMetal;
//							ResiduosTotalDeuterium += residuoDeuterio;
//						}
						if (enemyArmy[3].size() > 0) {
							boolean eliminado = enemyArmy[3].remove(defensorContrario);
							if (!eliminado) {
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
				
				break;
			}
			
			
			
		
		}
//		System.out.println("Mi ejercito");
//		System.out.println("Lighthunters prinicpio = "+ LightHunterMiosComienzo + " Lighthunters final = " + LightHunterMiosFinal);
//		System.out.println("HeavyHunters prinicpio = "+ HeavyHunterMiosComienzo + " HeavyHunters final = " + HeavyHunterMiosFinal);
//		System.out.println("BattleShip prinicpio = "+ BattleShipMiosComienzo + " BattleShip final = " + BattleShipMiosFinal );
//		System.out.println("ArmoredShip prinicpio = "+ ArmoredShipMiosComienzo + " ArmoredShip final = " + ArmoredShipMiosFinal );
//		System.out.println("MissileLauncher prinicpio = "+ MissileLauncherMiosComienzo + " MissileLauncher final = " + MissileLauncherMiosFinal );
//		System.out.println("IonCannon prinicpio = "+ IonCannonMiosComienzo + " IonCannon final = " + IonCannonMiosFinal );
//		System.out.println("PlasmaCannon prinicpio = "+ PlasmaCannonMiosComienzo + " PlasmaCannon final = " + PlasmaCannonMiosFinal );
//		System.out.println("");
//		System.out.println("Ejercito atacante");
//		System.out.println("Lighthunters prinicpio = "+ LightHuntersEnemigoComienzo + " Lighthunters final = " + LightHuntersEnemigoFinal);
//		System.out.println("HeavyHunters prinicpio = "+ HeavyHuntersEnemigoComienzo + " HeavyHunters final = " + HeavyHuntersEnemigoFinal);
//		System.out.println("BattleShip prinicpio = "+ BattleShipEnemigoComienzo + " BattleShip final = " + BattleShipEnemigoFinal );
//		System.out.println("ArmoredShip prinicpio = "+ ArmoredShipEnemigoComienzo + " ArmoredShip final = " + ArmoredShipEnemigoFinal );
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
	
	public String battleReport() {
		VariablesBBDDShips Lighthunters = new VariablesBBDDShips(1);
		VariablesBBDDShips HeavyHunters = new VariablesBBDDShips(2);
		VariablesBBDDShips Battleship = new VariablesBBDDShips(3);
		VariablesBBDDShips Armoredship = new VariablesBBDDShips(4);
		VariablesBBDDDefenses MissileLauncher = new VariablesBBDDDefenses(1);
		VariablesBBDDDefenses IonCannon = new VariablesBBDDDefenses(2);
		VariablesBBDDDefenses PlasmaCannon = new VariablesBBDDDefenses(3);
		int metalPlaneta = (LightHunterMiosComienzo*Lighthunters.getCosteMetal() + HeavyHunterMiosComienzo*HeavyHunters.getCosteMetal() + BattleShipMiosComienzo*Battleship.getCosteMetal() + ArmoredShipMiosComienzo*Armoredship.getCosteMetal() +
				MissileLauncherMiosComienzo*MissileLauncher.getCosteMetal() + IonCannonMiosComienzo*IonCannon.getCosteMetal()+ PlasmaCannonMiosComienzo*PlasmaCannon.getCosteMetal());
		int metalEnemigo = (LightHuntersEnemigoComienzo*Lighthunters.getCosteMetal()+
				HeavyHuntersEnemigoComienzo*HeavyHunters.getCosteMetal() + BattleShipEnemigoComienzo*Battleship.getCosteMetal() + ArmoredShipEnemigoComienzo*Armoredship.getCosteMetal());
		int deuteriumPlaneta = (LightHunterMiosComienzo*Lighthunters.getCosteDeuterium() + HeavyHunterMiosComienzo*HeavyHunters.getCosteDeuterium() + BattleShipMiosComienzo*Battleship.getCosteDeuterium() + ArmoredShipMiosComienzo*Armoredship.getCosteDeuterium() +
				MissileLauncherMiosComienzo*MissileLauncher.getCosteDeuterium() + IonCannonMiosComienzo*IonCannon.getCosteDeuterium()+ PlasmaCannonMiosComienzo*PlasmaCannon.getCosteDeuterium());
		int deuteriumEnemigo = (LightHuntersEnemigoComienzo*Lighthunters.getCosteDeuterium()+
				HeavyHuntersEnemigoComienzo*HeavyHunters.getCosteDeuterium() + BattleShipEnemigoComienzo*Battleship.getCosteDeuterium() + ArmoredShipEnemigoComienzo*Armoredship.getCosteDeuterium());
		int metalPerdidoPlaneta = (LightHunterMiosFinal*Lighthunters.getCosteMetal() + HeavyHunterMiosFinal*HeavyHunters.getCosteMetal() + BattleShipMiosFinal*Battleship.getCosteMetal() + ArmoredShipMiosFinal*Armoredship.getCosteMetal() +
				MissileLauncherMiosFinal*MissileLauncher.getCosteMetal() + IonCannonMiosFinal*IonCannon.getCosteMetal()+ PlasmaCannonMiosFinal*PlasmaCannon.getCosteMetal());
		int metalPerdidoEnemigo = (LightHuntersEnemigoFinal*Lighthunters.getCosteMetal()+
				HeavyHuntersEnemigoFinal*HeavyHunters.getCosteMetal() + BattleShipEnemigoFinal*Battleship.getCosteMetal() + ArmoredShipMiosFinal*Armoredship.getCosteMetal());
		int deuteriumPerdidoPlaneta = (LightHunterMiosFinal*Lighthunters.getCosteDeuterium() + HeavyHunterMiosFinal*HeavyHunters.getCosteDeuterium() + BattleShipMiosFinal*Battleship.getCosteDeuterium() + ArmoredShipMiosFinal*Armoredship.getCosteDeuterium() +
				MissileLauncherMiosFinal*MissileLauncher.getCosteDeuterium() + IonCannonMiosFinal*IonCannon.getCosteDeuterium()+ PlasmaCannonMiosFinal*PlasmaCannon.getCosteDeuterium());
		int deuteriumPerdidoEnemigo = (LightHuntersEnemigoFinal*Lighthunters.getCosteDeuterium()+
				HeavyHuntersEnemigoFinal*HeavyHunters.getCosteDeuterium() + BattleShipEnemigoFinal*Battleship.getCosteDeuterium() + ArmoredShipEnemigoFinal*Armoredship.getCosteDeuterium());
		int weightedPlaneta = (metalPerdidoPlaneta) + (deuteriumPerdidoPlaneta)*5;
		int weightedEnemigo = (metalPerdidoEnemigo) + (deuteriumPerdidoEnemigo)*5;
		String cadena = "<html>BATTLE STATISTICS<br><br>"
				+ "Army Planet Units Drops Initial Army Enemy Units Drops<br>"
				+ "LightHunter "+LightHunterMiosComienzo + " "+ LightHunterMiosFinal + " Light Hunter" + LightHuntersEnemigoComienzo + LightHuntersEnemigoFinal + "<br>"
						+ "Heavy Hunter "+ HeavyHunterMiosComienzo + " "+ HeavyHunterMiosFinal + " Heavy Hunter "+HeavyHuntersEnemigoComienzo + " "+HeavyHuntersEnemigoFinal + "<br>"
								+ "Battle Ship "+BattleShipMiosComienzo + " "+BattleShipMiosFinal + " Battle Ship "+BattleShipEnemigoComienzo + " "+BattleShipEnemigoFinal + "<br>"
										+ "Armored Ship "+ArmoredShipMiosComienzo+" "+ArmoredShipMiosFinal + " Armored Ship "+ArmoredShipEnemigoComienzo + " "+ArmoredShipEnemigoFinal + "<br>"
												+ "Missile Launcher "+MissileLauncherMiosComienzo + " "+MissileLauncherMiosFinal+"<br>"
														+ "Ion Cannon "+ IonCannonMiosComienzo + " "+IonCannonMiosFinal+"<br>"
																+ "Plasma Cannon "+PlasmaCannonMiosComienzo + " "+PlasmaCannonMiosFinal + "<br>"
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