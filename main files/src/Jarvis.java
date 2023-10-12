import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Jarvis {
	private static final String[] weaponNames = null;
	Random rand=new Random();
	ArrayList<Enemy> enemies=new ArrayList<Enemy>();
	ArrayList<Enemy> sortEnemies=new ArrayList<Enemy>();
	ArrayList<Suit> suits=new ArrayList<Suit>();
	ArrayList<Suit> NonReadySuits=new ArrayList<Suit>();
	ArrayList<Suit> ReadySuits=new ArrayList<Suit>();
	ArrayList<Suit> DeploySuits=new ArrayList<Suit>();
		
	
	
	boolean ok=true;
	
	String[] data=new String[200];
	int[] newPattern=new int[data.length];
	int[] output=new int[data.length];
	
	
	public Jarvis() {
		
	}
	
	public int InputNumeric() {
		Scanner in=new Scanner(System.in);
		
		int val=in.nextInt();
		
		return val;
	}
	
	public String InputString() {
		Scanner in=new Scanner(System.in);
		
		String val=in.nextLine();
		
		return val;
	}
	
	
	
	
	public static void main(String[] args) {
		Jarvis jarvis=new Jarvis();
		Enemy enemy2=new Enemy();
		Weapon weap=new Weapon();
		Fight pattern=new Fight();
		Suit suit=new Suit();
		SuitWeapons suitweap=new SuitWeapons();
		
		
		
		int x=1;
		int y=1;
		int idss=1;
		int Marks = 0;
		
		for(int i=0;i<7;i++) {
			System.out.print("What Do You Want:");
			String input=jarvis.InputString();
			if(input.matches("Fight Pattern") || input.matches("fight pattern")) {
				System.out.print("How Many Of Types:");
				int typeCount=jarvis.InputNumeric();
				System.out.print("How Many Of Pattern Count:");
				int patternCount=jarvis.InputNumeric();
				for(int j=0;j<jarvis.data.length;j++) {
					jarvis.data[j]=All.types[(int) (jarvis.rand.nextInt(typeCount>All.types.length?All.types.length:typeCount))];
				}
				//System.out.println(Arrays.toString(jarvis.data));
				System.out.println(Arrays.toString(jarvis.newPattern=pattern.createFightPattern(jarvis.data)));
				
				jarvis.output=pattern.analyzeFightPattern(jarvis.newPattern,patternCount>jarvis.data.length/2 ?jarvis.data.length/2 :patternCount);
				for(int j=0;j<jarvis.output.length;j++) {
					if(jarvis.output[j]!=0) {
						System.out.println("Pattern Found At->" + jarvis.output[j]);
					}else if(jarvis.output[0]==0){
						System.out.println("No Pattern Found");
						break;
					}
				}
			}else if(input.matches("Find Enemies") || input.matches("find enemies")) {
				System.out.print("How Many:");
				int enemiesCount=jarvis.InputNumeric();
				for(int j=0;j<enemiesCount;j++) {
					Enemy enemy=new Enemy(idss++, x++ , y++, jarvis.rand.nextInt() % 100 + 100, jarvis.rand.nextInt() % 50 + 50, jarvis.rand.nextBoolean(),new Weapon(All.weaponNames_E[jarvis.rand.nextInt(5)]));
					if(enemy.isThreat) {	
						jarvis.enemies.add(enemy);
					}
				}
				enemy2.sortEnemy(jarvis.enemies, jarvis.sortEnemies);
				
				enemy2.displaySpecs(jarvis.enemies);
				System.out.println("\n\n######################################\n######################################\nSorted Enemies\n######################################");
				enemy2.displaySpecs(jarvis.sortEnemies);
			}else if(input.matches("Destruction") || input.matches("destruction")) {
				int[] curr=new int[5];
				System.out.print("Height:");
				curr[0]=jarvis.InputNumeric();
				System.out.print("Length:");
				curr[1]=jarvis.InputNumeric();
				System.out.print("Width:");
				curr[2]=jarvis.InputNumeric();
				System.out.print("Velocity:");
				curr[3]=jarvis.InputNumeric();
				System.out.print("Distance:");
				curr[4]=jarvis.InputNumeric();
				
				Destruction destruct=new Destruction(curr[0], curr[1], curr[2], curr[3], curr[4]);
				System.out.println("Potential Destruction:" + destruct.potentialDestruct);
			}else if(input.matches("Suit") || input.matches("suit")) {
				boolean back=false;
				while(!back) {
					if(!jarvis.suits.isEmpty()) {
						for(int f=0;f<4;f++) {
							System.out.println(f + 1 + ")" + All.SuitMenu[f]);
						}
						System.out.print("Choose:");
						String suitInput=jarvis.InputString();
						if(suitInput.matches("New Suit") || suitInput.matches("new suit")) {
							Marks=jarvis.suits.size() + 1;
							System.out.print("How Many Suits:");
							int suitCount=jarvis.InputNumeric();
							System.out.print("How Many Weapons:");
							int weaponCount=jarvis.InputNumeric();
							suit.createSuits(jarvis.suits, Marks,suitCount,weaponCount<All.weaponNames.length?weaponCount:All.weaponNames.length);
							suit.findNonReadySuits(jarvis.suits,jarvis.NonReadySuits);
							suit.findReadySuits(jarvis.suits, jarvis.ReadySuits, jarvis.DeploySuits);
						}else if(suitInput.matches("Deploy Suit") || suitInput.matches("deploy suit")) {
							System.out.println("Suits Ready Count:" + jarvis.ReadySuits.size());
							System.out.print("How Many Suits To Deploy:");
							int deploySuitCount=jarvis.InputNumeric();
							suit.deploysuits(jarvis.ReadySuits,jarvis.DeploySuits, deploySuitCount);
						}else if(suitInput.matches("Suit Specs") || suitInput.matches("suit specs")) {
							suit.displaySuitSpecs(jarvis.suits);
							System.out.println("#########################################\n#########################################\nNon Ready Suits\n#########################################");
							suit.displaySuitSpecs(jarvis.NonReadySuits);
							System.out.println("#########################################\n#########################################\nReady Suits\n#########################################");
							suit.displaySuitSpecs(jarvis.ReadySuits);
							System.out.println("#########################################\n#########################################\nOn-Mission Suits\n#########################################");
							suit.displaySuitSpecs(jarvis.DeploySuits);
						}else if(suitInput.matches("Suit Specs") || suitInput.matches("suit specs")) {
							System.out.print("Which Suit:");
							int posSuit=jarvis.InputNumeric();
							suit.editSuit(jarvis.suits, jarvis.ReadySuits, jarvis.NonReadySuits, jarvis.DeploySuits, posSuit, Marks);
						}else if(suitInput.matches("Back") || suitInput.matches("back")) {
							System.out.println("Go to Menu");
							break;
						}else {
							System.out.println("No Valid Index");
						}
					}else {
						System.out.println("1)" + All.SuitMenu[0]);
						Marks=jarvis.suits.size() + 1;
						System.out.print("How Many Suits:");
						int suitCount=jarvis.InputNumeric();
						System.out.print("How Many Weapons:");
						int weaponCount=jarvis.InputNumeric();
						suit.createSuits(jarvis.suits, Marks,suitCount,weaponCount<All.weaponNames.length?weaponCount:All.weaponNames.length);
						suit.findNonReadySuits(jarvis.suits,jarvis.NonReadySuits);
						suit.findReadySuits(jarvis.suits, jarvis.ReadySuits, jarvis.DeploySuits);
					}
					System.out.println("\n/////////////////////////////////////////////\n/////////////////////////////////////////////");
				}
				
			}else {
				System.out.println("No Valid Index");
			}
		}
	}
}
