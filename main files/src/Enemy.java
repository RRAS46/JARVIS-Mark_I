import java.util.ArrayList;
import java.util.Scanner;

public class Enemy {
	int ids;
	int power;
	int x,y;
	int height;
	int mass;
	
	boolean isThreat;
	Weapon weapon=new Weapon();
	
	
	public Enemy() {
		
	}
	
	public Enemy(int ids,int power,int x,int y,Weapon weapon) {
		this.ids=ids;
		this.power=power;
		this.x=x;
		this.y=y;
		this.weapon=weapon;
	}
	
	public Enemy(int ids,int x,int y,int height,int mass,boolean isThreat,Weapon weapon) {
		this.ids=ids;
		this.x=x;
		this.y=y;
		this.height=height;
		this.mass=mass;
		this.isThreat=isThreat;
		
		if(isThreat) {
			this.weapon=weapon;
			this.power=height * mass + weapon.weaponPower + (int) Math.pow(10, 1);
		}else {
			this.weapon=new Weapon(null);
			this.power=0;//height * mass + weapon.weaponPower + (int) Math.pow(10, 0);
		}
		
	}
	
	/*public ArrayList<Enemy> createEnemies(ArrayList<Enemy> enemies,int n){
		int i;
		if(enemies.isEmpty()) {
			i=1;
		}else{
			i=enemies.get(enemies.size() - 1).ids + 1;
		}
		
		Enemy enemy1=new Enemy(i,power, 3 * x, 3 * y);
		enemies.add(enemy1);
		
		for( int j=i;j<n + i;j++) {
			
			Enemy enemy=new Enemy(j + 1, 3 * ++x, 3 * ++y, rand.nextInt() % 100 + 100, rand.nextInt() % 100 + 100,rand.nextBoolean());
			enemies.add(enemy);
		
		}
		return enemies;
	}*/
	
	public ArrayList<Enemy> sortEnemy(ArrayList<Enemy> input,ArrayList<Enemy> current) {
		if(!current.isEmpty()) {
			current.removeAll(current);
		}
		for(Enemy in : input) {
			current.add(in);
		}
		Enemy temp;
		
		for(int i=0;i<current.size() - 1;i++) {
			for(int j=0;j<current.size() - 1 - i;j++) {
				if(current.get(j).power > current.get(j + 1).power) {
					temp=current.get(j);
					current.set(j, current.get(j + 1));
					current.set(j + 1, temp);
					
				}
			}
		}
		return current;
	}
	public Enemy removeEnemy(ArrayList<Enemy> input,boolean ok) {
		int i=0;
		Enemy temp;
		System.out.print("Eliminate:");
		Scanner in=new Scanner(System.in);
		String val=in.nextLine();
		if(val.matches("Yes") || val.matches("yes")) {
			if(!input.isEmpty()) {
				temp=input.get(i);
				input.remove(i);
				power+=temp.power;
				i++; 
				return temp;
			}else {
				System.out.println("There Are No Threats");
				ok=false;
			}
		}if(val.matches("No") || val.matches("no")) {
			System.out.println("No Elimination");
			ok=false;
		}else if(!val.matches("No") && !val.matches("no") && !val.matches("Yes") && !val.matches("yes")){
			System.out.println("No Valid Index");
		}
		return null;
	}
	
	public void displaySpecs(ArrayList<Enemy> input) {
		for(Enemy ene : input) {
			System.out.println("\n#############################\n#############################");
			System.out.println("Enemy Specs");
			System.out.println("ID->" + ene.ids);
			System.out.println("Power->" + ene.power);
			System.out.println("X->" + ene.x);
			System.out.println("Y->" + ene.y);
			System.out.println("Is Threat->" + ene.isThreat);
			System.out.println("Weapon Name->" + ene.weapon.weaponName);
			System.out.println("Weapon Power->" + ene.weapon.weaponPower);
		
		}
	}
	
	
}
