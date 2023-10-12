import java.util.HashMap;

public class Weapon {
	
	String weaponName;
	int weaponPower;
	
	
	public Weapon() {
	
		
	}
	
	public Weapon(String weaponName) {
		this.weaponName=weaponName;
		
		for(int i=0;i<All.weaponNames_E.length;i++) {
			if(this.weaponName==All.weaponNames_E[i]) {
				this.weaponPower=(int) Math.pow(10, All.weaponPowers_E[i]);
				break;
			}
		}
	}
	
}
