import java.util.ArrayList;
import java.util.Random;

public class SuitWeapons {
	
	Random rand=new Random();

	
	String weaponName;
	int weaponPower;
	int weaponAmount;
	
	
	
	public SuitWeapons(String weaponName) {
		this.weaponName=weaponName;
		for(int j=0;j<All.weaponNames.length;j++) {		
			if(weaponName==All.weaponNames[j]) {
				this.weaponPower=(int)Math.pow(10, All.weaponPowers[j]);
				this.weaponAmount=All.weaponAmounts[j];
			}
		}
	}
	public SuitWeapons() {
		
	}
	
	public ArrayList<SuitWeapons> createWeapons(ArrayList<SuitWeapons> input,int n){
		Jarvis jarvis=new Jarvis();
		String in;
		
		for(int i=0;i<n;i++) {
			System.out.print("Which Weapon:");
			in=jarvis.InputString();
			for(int j=0;j<All.weaponNames.length;j++) {		
				if(in==All.weaponNames[j]) {
					SuitWeapons weapons=new SuitWeapons(All.weaponNames[j]);
						input.add(weapons);
				}
			}
		}
		return input;
	}
	
	public ArrayList<SuitWeapons> CreateWeapons(ArrayList<SuitWeapons> weaponSuits,int n){
		int j;
		int stop=0;
		for(int i=0;i<n;i++) {
			String in=All.weaponNames[rand.nextInt(All.weaponNames.length)];
			j=0;
			for(SuitWeapons weaps : weaponSuits) {
				if(weaps.weaponName!=in) {
					j++;
				}else {
					stop++;
					if(stop<=3) {
						i--;
					}else {
						stop=0  ;
					}
					break;
				}
				
				
			}
			if(j==weaponSuits.size()) {
				SuitWeapons weaponss=new SuitWeapons(in);
				weaponSuits.add(weaponss);		
			}
		}
		return weaponSuits;
	}
	
	public void displaySuitWeaponsSpecs(SuitWeapons[] input) {
		if(input!=null) {
			for(SuitWeapons weaps :input) {
				System.out.println(weaps.weaponName + "  " + weaps.weaponPower + "  " + weaps.weaponAmount);
			}
		}
	}
	
	
}
