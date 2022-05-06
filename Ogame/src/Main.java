import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
	
	private Integer Iker;
	
	public static void main(String[] args) {
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int id = -1;
        Connection cn = null;

        try {
            // Carga el driver de oracle
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            
            // Conecta con la base de datos orcl con el usuario system y la contrase�a password
            cn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.40.2:1521:orcl", "alumnoMIX4", "alumnoMIX4");
            
            // Llamada al procedimiento almacenado
            CallableStatement cst = cn.prepareCall("{call GET_SHIP (?,?,?,?,?,?,?,?,?,?)}");

            do {
                System.out.println("\nIntroduce el ID de la nave:");
                try {
                    id = Integer.parseInt(entrada.readLine());
                } catch (IOException ex) {
                    System.out.println("Error...");
                }
                
               

            
                // Se obtienen la salida del procedimineto almacenado
                Integer P_ID = cst.getInt(1);
                String P_NAME = cst.getString(2);
                Integer P_METAL_COST = cst.getInt(3);
                Integer P_CRYSTAL_COST = cst.getInt(4);
                Integer P_DEUTERIUM_COST = cst.getInt(5);
                Integer P_INITIALARMOR = cst.getInt(6);
                Integer P_ARMOR = cst.getInt(7);
                Integer P_BASEDAMAGE = cst.getInt(8);
                Integer P_SPEED = cst.getInt(9);
                Integer P_GENERATE_WASTINGS = cst.getInt(10);
                System.out.println("P_ID: "+P_ID);
                System.out.println("P_NAME: " + P_NAME);
                System.out.println("P_METAL_COST: " + P_METAL_COST);
                System.out.println("P_CRYSTAL_COST: " + P_CRYSTAL_COST);
                System.out.println("P_DEUTERIUM_COST: " + P_DEUTERIUM_COST);
                System.out.println("P_INITIALARMOR: " + P_INITIALARMOR);
                System.out.println("P_ARMOR: " + P_ARMOR);
                System.out.println("P_BASEDAMAGE: " + P_BASEDAMAGE);
                System.out.println("P_SPEED: " + P_SPEED);
                System.out.println("P_GENERATE_WASTINGS: " + P_GENERATE_WASTINGS);
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

}
class Planet {
	
	private int technologyDefense;
	private int technologyAtack;
	private int metal = 10000;
	private int deuterium = 10000;
	private int upgradeDefenseTechnologyDeuteriumCost;
	private int upgradeAttackTechnologyDeuteriumCost;
	private ArrayList<MilitaryUnit>[] army;

	private int costeDefensa;
	private int costeAtaque;
	
	public Planet() {
		super();
		army = new ArrayList[7];
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
		 // Parametro 1 del procedimiento almacenado
//      cst.setInt(1, id);
//      
//      // Definimos los tipos de los parametros de salida del procedimiento almacenado
//      cst.registerOutParameter(2, java.sql.Types.VARCHAR);
//      cst.registerOutParameter(3, java.sql.Types.INTEGER);
//      cst.registerOutParameter(4, java.sql.Types.INTEGER);
//      cst.registerOutParameter(5, java.sql.Types.INTEGER);
//      cst.registerOutParameter(6, java.sql.Types.INTEGER);
//      cst.registerOutParameter(7, java.sql.Types.INTEGER);
//      cst.registerOutParameter(8, java.sql.Types.INTEGER);
//      cst.registerOutParameter(9, java.sql.Types.INTEGER);
//      cst.registerOutParameter(10, java.sql.Types.INTEGER);
//      
//      // Ejecuta el procedimiento almacenado
//      cst.execute();
		int costeMetal = 3000;
		//int costeMetal = cst.getInt(3);
		int costeDeuterium = 50;
		int count = 0;

		int armor_plus = Variables.ARMOR_LIGTHHUNTER + (getTechnologyDefense()*Variables.PLUS_ARMOR_LIGTHHUNTER_BY_TECHNOLOGY)*Variables.ARMOR_LIGTHHUNTER/100;
		int damage_plus = Variables.BASE_DAMAGE_LIGTHHUNTER + (getTechnologyAtack()*Variables.PLUS_ATTACK_LIGTHHUNTER_BY_TECHNOLOGY)*Variables.BASE_DAMAGE_LIGTHHUNTER/100;
		
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
				System.out.println("Se han creado " + count + " lazamisiles.");
				throw new ResourceException("No se han podido crear mas lanzamisiles.");
			}
		}
		System.out.println("Se han creado " + count + " lazamisiles.");
		
	}
	
	public void newHeavyHunter(int n) throws ResourceException{
		army[1] = new ArrayList<>();
		int costeMetal = 6500;
		int costeDeuterium = 50;
		int count = 0;
		int armor_plus = Variables.ARMOR_HEAVYHUNTER + (getTechnologyDefense()*Variables.PLUS_ARMOR_HEAVYHUNTER_BY_TECHNOLOGY)*Variables.ARMOR_HEAVYHUNTER/100;
		int damage_plus = Variables.BASE_DAMAGE_HEAVYHUNTER + (getTechnologyAtack()*Variables.PLUS_ATTACK_HEAVYHUNTER_BY_TECHNOLOGY)*Variables.BASE_DAMAGE_HEAVYHUNTER/100;
		
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
		int costeMetal = 45000;
		int costeDeuterium = 7000;
		int count = 0;
		int armor_plus = Variables.ARMOR_BATTLESHIP + (getTechnologyDefense()*Variables.PLUS_ARMOR_BATTLESHIP_BY_TECHNOLOGY)*Variables.ARMOR_BATTLESHIP/100;
		int damage_plus = Variables.BASE_DAMAGE_BATTLESHIP + (getTechnologyAtack()*Variables.PLUS_ATTACK_BATTLESHIP_BY_TECHNOLOGY)*Variables.BASE_DAMAGE_BATTLESHIP/100;
		
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
		int costeMetal = 30000;
		int costeDeuterium = 15000;
		int count = 0;
		int armor_plus = Variables.ARMOR_ARMOREDSHIP + (getTechnologyDefense()*Variables.PLUS_ARMOR_ARMOREDSHIP_BY_TECHNOLOGY)*Variables.ARMOR_ARMOREDSHIP/100;
		int damage_plus = Variables.BASE_DAMAGE_ARMOREDSHIP + (getTechnologyAtack()*Variables.PLUS_ATTACK_ARMOREDSHIP_BY_TECHNOLOGY)*Variables.BASE_DAMAGE_ARMOREDSHIP/100;
		
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
		int costeMetal = 2000;
		int costeDeuterium = 0;
		int count = 0;
		int armor_plus = Variables.ARMOR_MISSILELAUNCHER + (getTechnologyDefense()*Variables.PLUS_ARMOR_MISSILELAUNCHER_BY_TECHNOLOGY)*Variables.ARMOR_MISSILELAUNCHER/100;
		int damage_plus = Variables.BASE_DAMAGE_MISSILELAUNCHER + (getTechnologyAtack()*Variables.PLUS_ATTACK_MISSILELAUNCHER_BY_TECHNOLOGY)*Variables.BASE_DAMAGE_MISSILELAUNCHER/100;
		
		while (count < n) {
			if (getMetal() >= costeMetal && getDeuterium() >= costeDeuterium) {
				if (getTechnologyDefense() < 1) {
					army[4].add(new MissileLauncher(Variables.ARMOR_MISSILELAUNCHER,Variables.BASE_DAMAGE_MISSILELAUNCHER));
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
		int costeMetal = 4000;
		int costeDeuterium = 500;
		int count = 0;
		int armor_plus = Variables.ARMOR_IONCANNON + (getTechnologyDefense()*Variables.PLUS_ARMOR_IONCANNON_BY_TECHNOLOGY)*Variables.ARMOR_IONCANNON/100;
		int damage_plus = Variables.BASE_DAMAGE_IONCANNON + (getTechnologyAtack()*Variables.PLUS_ATTACK_IONCANNON_BY_TECHNOLOGY)*Variables.BASE_DAMAGE_IONCANNON/100;
		
		while (count < n) {
			if (getMetal() >= costeMetal && getDeuterium() >= costeDeuterium) {
				if (getTechnologyDefense() < 1) {
					army[5].add(new IonCannon(Variables.ARMOR_IONCANNON,Variables.BASE_DAMAGE_IONCANNON));
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
		int costeMetal = 50000;
		int costeDeuterium = 5000;
		int count = 0;
		int armor_plus = Variables.ARMOR_PLASMACANNON + (getTechnologyDefense()*Variables.PLUS_ARMOR_PLASMACANNON_BY_TECHNOLOGY)*Variables.ARMOR_PLASMACANNON/100;
		int damage_plus = Variables.BASE_DAMAGE_PLASMACANNON + (getTechnologyAtack()*Variables.PLUS_ATTACK_PLASMACANNON_BY_TECHNOLOGY)*Variables.BASE_DAMAGE_PLASMACANNON/100;
		
		while (count < n) {
			if (getMetal() >= costeMetal && getDeuterium() >= costeDeuterium) {
				if (getTechnologyDefense() < 1) {
					army[6].add(new PlasmaCannon(Variables.ARMOR_PLASMACANNON,Variables.BASE_DAMAGE_PLASMACANNON));
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
		setArmor(Variables.ARMOR_LIGTHHUNTER);
		setBaseDamage(Variables.BASE_DAMAGE_LIGTHHUNTER);
		setInitialArmor(Variables.ARMOR_LIGTHHUNTER);
	}

	public int attack() {
		return 80;
	}

	public void tekeDamage(int receivedDamage) {
		setArmor(getActualArmor()-receivedDamage);
	}

	public int getActualArmor() {
		return getArmor();
	}

	public int getMetalCost() {
		return 3000;
	}

	public int getDeuteriumCost() {
		return 50;
	}

	public int getChanceGeneratinWaste() {
		return 45;
	}

	public int getChanceAttackAgain() {
		return 3;
	}

	public void resetArmor() {
		setArmor(getInitialArmor());
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
		setArmor(Variables.ARMOR_HEAVYHUNTER);
		setBaseDamage(Variables.BASE_DAMAGE_HEAVYHUNTER);
		setInitialArmor(Variables.ARMOR_HEAVYHUNTER);
	}
	
	//si tecnlogia es 0 blindaje y lo otro normal.
	//si tecnologia es mas grande de 0 con el plus.
	
	public int attack() {
		return 150;
	}

	public void tekeDamage(int receivedDamage) {
		setArmor(getActualArmor()-receivedDamage);
	}

	public int getActualArmor() {
		return getArmor();
	}

	public int getMetalCost() {
		return 6500;
	}

	public int getDeuteriumCost() {
		return 50;
	}

	public int getChanceGeneratinWaste() {
		return 55;
	}

	public int getChanceAttackAgain() {
		return 7;
	}

	public void resetArmor() {
		setArmor(getInitialArmor());
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
		setArmor(Variables.ARMOR_BATTLESHIP);
		setBaseDamage(Variables.BASE_DAMAGE_HEAVYHUNTER);
		setInitialArmor(Variables.ARMOR_BATTLESHIP);
	}

	@Override
	public int attack() {
		return 1000;
	}

	@Override
	public void tekeDamage(int receivedDamage) {
		setArmor(getActualArmor()-receivedDamage);
		
	}

	@Override
	public int getActualArmor() {
		return getArmor();
	}

	@Override
	public int getMetalCost() {
		// TODO Auto-generated method stub
		return 45000;
	}

	@Override
	public int getDeuteriumCost() {
		// TODO Auto-generated method stub
		return 7000;
	}

	@Override
	public int getChanceGeneratinWaste() {
		// TODO Auto-generated method stub
		return 70;
	}

	@Override
	public int getChanceAttackAgain() {
		// TODO Auto-generated method stub
		return 45;
	}

	@Override
	public void resetArmor() {
		setArmor(getInitialArmor());
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
		setArmor(Variables.ARMOR_ARMOREDSHIP);
		setBaseDamage(Variables.BASE_DAMAGE_ARMOREDSHIP);
		setInitialArmor(Variables.ARMOR_ARMOREDSHIP);
	}

	@Override
	public int attack() {
		// TODO Auto-generated method stub
		return 8000;
	}

	@Override
	public void tekeDamage(int receivedDamage) {
		// TODO Auto-generated method stub
		setArmor(getActualArmor()-receivedDamage);
		
	}

	@Override
	public int getActualArmor() {
		// TODO Auto-generated method stub
		return getArmor();
	}

	@Override
	public int getMetalCost() {
		// TODO Auto-generated method stub
		return 30000;
	}

	@Override
	public int getDeuteriumCost() {
		// TODO Auto-generated method stub
		return 15000;
	}

	@Override
	public int getChanceGeneratinWaste() {
		// TODO Auto-generated method stub
		return 85;
	}

	@Override
	public int getChanceAttackAgain() {
		// TODO Auto-generated method stub
		return 70;
	}

	@Override
	public void resetArmor() {
		setArmor(getInitialArmor());
		
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

	@Override
	public int attack() {
		// TODO Auto-generated method stub
		return 80;
	}

	@Override
	public void tekeDamage(int receivedDamage) {
		setArmor(getActualArmor()-receivedDamage);
		
	}

	@Override
	public int getActualArmor() {
		// TODO Auto-generated method stub
		return getArmor();
	}

	@Override
	public int getMetalCost() {
		// TODO Auto-generated method stub
		return 2000;
	}

	@Override
	public int getDeuteriumCost() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getChanceGeneratinWaste() {
		// TODO Auto-generated method stub
		return 45;
	}

	@Override
	public int getChanceAttackAgain() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public void resetArmor() {
		setArmor(getInitialArmor());
		
	}

}

class IonCannon extends Defense{

	
	public IonCannon(int armor, int baseDamage) {
		super();
		setArmor(armor);
		setBaseDamage(baseDamage);
		setInitialArmor(armor);
	}

	@Override
	public int attack() {
		// TODO Auto-generated method stub
		return 250;
	}

	@Override
	public void tekeDamage(int receivedDamage) {
		setArmor(getActualArmor()-receivedDamage);
	}

	@Override
	public int getActualArmor() {
		// TODO Auto-generated method stub
		return getArmor();
	}

	@Override
	public int getMetalCost() {
		// TODO Auto-generated method stub
		return 4000;
	}

	@Override
	public int getDeuteriumCost() {
		// TODO Auto-generated method stub
		return 500;
	}

	@Override
	public int getChanceGeneratinWaste() {
		// TODO Auto-generated method stub
		return 55;
	}

	@Override
	public int getChanceAttackAgain() {
		// TODO Auto-generated method stub
		return 12;
	}

	@Override
	public void resetArmor() {
		setArmor(getInitialArmor());
	}
	
}
class PlasmaCannon extends Defense{

	public PlasmaCannon(int armor, int baseDamage) {
		super();
		setArmor(armor);
		setBaseDamage(baseDamage);
		setInitialArmor(armor);
	}

	@Override
	public int attack() {
		// TODO Auto-generated method stub
		return 2000;
	}

	@Override
	public void tekeDamage(int receivedDamage) {
		setArmor(getActualArmor()-receivedDamage);
		
	}

	@Override
	public int getActualArmor() {
		// TODO Auto-generated method stub
		return getArmor();
	}

	@Override
	public int getMetalCost() {
		// TODO Auto-generated method stub
		return 50000;
	}

	@Override
	public int getDeuteriumCost() {
		// TODO Auto-generated method stub
		return 5000;
	}

	@Override
	public int getChanceGeneratinWaste() {
		// TODO Auto-generated method stub
		return 65;
	}

	@Override
	public int getChanceAttackAgain() {
		// TODO Auto-generated method stub
		return 30;
	}

	@Override
	public void resetArmor() {
		setArmor(getInitialArmor());
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









