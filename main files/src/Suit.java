import java.util.ArrayList;
import java.util.Random;

public class Suit {
	SuitWeapons suitweaps=new SuitWeapons();
	Jarvis jarvis=new Jarvis();
	Random rand=new Random();
	int mark;
	int x,y; 
	int power;
	String armor;
	String suitup;
	boolean isReady;
	ArrayList<SuitWeapons> weaponSuits=new ArrayList<SuitWeapons>();
	
	
	
	public Suit(int mark,int x,int y,String armor,String suitup,boolean isReady,ArrayList<SuitWeapons> weaponSuits) {
		this.mark=mark;
		this.x=x;
		this.y=y;
		this.armor=armor;
		this.suitup=suitup;
		this.isReady=isReady;
		this.weaponSuits=weaponSuits;
		this.power=0;
		for(SuitWeapons weaponn : weaponSuits) {
			this.power+=weaponn.weaponPower;
		}
	}
	public Suit() {
		
	}
	
	
	public ArrayList<Suit> createSuits(ArrayList<Suit> suit,int Mark ,int n,int weaponCount){
		
		for(int i=0;i<n;i++) {
			Suit newsuit=new Suit(Mark + i, i, i, "Tungsten", "Nanotech",rand.nextBoolean(), suitweaps.CreateWeapons(new ArrayList<SuitWeapons>(), weaponCount));
			suit.add(newsuit);
		}
		
		return suit;
	}
	
	
	
	
	public ArrayList<Suit> findNonReadySuits(ArrayList<Suit> input,ArrayList<Suit> nonReadyInput){
		if(!nonReadyInput.isEmpty()) {
			nonReadyInput.clear();
		}
		for(Suit suit:input) {
			if(!suit.isReady) {
				nonReadyInput.add(suit);
			}
		}             
		return nonReadyInput;
	}
	
	
	public ArrayList<Suit> findReadySuits(ArrayList<Suit> suits,ArrayList<Suit> ReadySuits,ArrayList<Suit> DeploySuits){
		boolean found=false;
		if(!ReadySuits.isEmpty()) {
			ReadySuits.clear();
		}
		
		for(Suit suit:suits) {
			if(suit.isReady) {
				if(!DeploySuits.isEmpty()) {
					for(Suit DeploySuit : DeploySuits) {
						if(suit.mark == DeploySuit.mark) {
							found=true;
							break;
						}
					}
					if(!found) {
						ReadySuits.add(suit);
						found=false;
					}
				}else {
					ReadySuits.add(suit);
				}	
			}
			
		}
		return ReadySuits;
	}
	
	public ArrayList<Suit>   deploysuits(ArrayList<Suit> ReadySuits,ArrayList<Suit> deploy,int n){
		
		
		if(n>ReadySuits.size()) {
			n=ReadySuits.size();
		}
		
		int[] choose=new int[n];
		for(int i=0;i<ReadySuits.size();i++) {
			System.out.print(ReadySuits.get(i).mark + "   ");
		}
		System.out.println();
		for(int i=0;i<ReadySuits.size();i++) {
			System.out.print(ReadySuits.get(i).power + "   ");
		}
		System.out.println();
		for(int i=0;i<ReadySuits.size();i++) {
			System.out.print(ReadySuits.get(i).x + "   ");
		}
		System.out.println();
		for(int i=0;i<ReadySuits.size();i++) {
			System.out.print(ReadySuits.get(i).y + "   ");
		}
		System.out.println();
		for(int i=0;i<ReadySuits.size();i++) {
			System.out.print(ReadySuits.get(i).armor + "   ");
		}
		System.out.println("\n");
		
		
		
		
		if(n<ReadySuits.size()) {
			System.out.println("Suits Ready Count:" + ReadySuits.size());
			System.out.print("Which Suits:");
			int checkSuit;
			boolean checkFound=false;
			for(int i=0;i<n;i++) {
				checkSuit=jarvis.InputNumeric();
				for(int j=0;j<ReadySuits.size();j++) {
					if(checkSuit==ReadySuits.get(j).mark) {
						checkFound=true;
						break;
					}
				}
				if(checkFound) {
					choose[i]=checkSuit;
				}else {
					i--;
					System.out.println("Not Ready Suit With Mark" + checkSuit);
				}
				checkFound=false;
			}
		}else if(n>=ReadySuits.size()){
			for(int i=0;i<n;i++) {
				choose[i]=i+1;
			}
		}
		for(int i=0;i<ReadySuits.size();i++) {
			for(int j=0;j<n;j++) {
				if(ReadySuits.get(i).mark==choose[j]) {
					deploy.add(ReadySuits.get(i));
					ReadySuits.remove(i);
				}
			}
		}
		return deploy;
	}
	
	
	public ArrayList<Suit> editSuit(ArrayList<Suit> input,ArrayList<Suit> suitReadyIn,ArrayList<Suit> suitNonReadyIn,ArrayList<Suit> suitOnMission,int position,int loc){
		String[] newSpecs=new String[3];
		int[] newSpecs1=new int[4];
		int find=0;
		boolean currIsReady=false;
		boolean ArmorFound=false;
		boolean SuitupFound=false;
		boolean positionFound=false;
		boolean readySuitFound=false;
		boolean onAMission=false;
		boolean noSuitFound=false;
		
		if(!input.isEmpty()) {
			positionFound=true;
			if(position>loc) {
				System.out.println("No Suit With Mark:" + position);
				position=loc;
				System.out.println("Latest Version Of Suit With Mark:" + position);
			}
		}else if(input.contains(position)) {
			positionFound=true;
		}else if(input.isEmpty()) {
			noSuitFound=true;
		}
		
		for(int i=0;i<suitOnMission.size();i++) {
			if(position==suitOnMission.get(i).mark) {
				onAMission=true;
				break;
			}
		}
		
		
		if(!noSuitFound) {
			if(!onAMission) {
				if(!positionFound ) {
					System.out.println("No Suit With Mark:" + position);
				}else {
					position--;
					System.out.print("\nMark:" + input.get(position).mark);
					//newSpecs1[0]=InputNumeric();
					System.out.print("\nPower:" + input.get(position).power);
					/*System.out.print("\nNew Power:");
					newSpecs1[1]=jarvis.InputNumeric();
					if(newSpecs1[1]==-1) {
						newSpecs1[1]=input.get(position).power;
					}*/
					System.out.print("\nX:" + input.get(position).x);
					//newSpecs1[2]=InputNumeric();
					System.out.print("\nY:" + input.get(position).y);
					//newSpecs1[3]=InputNumeric();
					while(!ArmorFound) {
						System.out.print("\nCurrent Armor:" + input.get(position).armor);
						System.out.print("\nNew Armor:"); 
						newSpecs[0]=jarvis.InputString();
						for(int i=0;i<All.ArmorTypes.length;i++) {
							if(newSpecs[0].matches(All.ArmorTypes[i])) {
								ArmorFound=true;
							}else if(newSpecs[0].matches("Same") || newSpecs[0].matches("same")) {
								newSpecs[0]=input.get(position).armor;
								ArmorFound=true;
							}
						}
						if(!ArmorFound) {
							System.out.print("No Valid Index");
						}
					}
					while(!SuitupFound) {
						System.out.print("\nCurrent Suit-Up Type:" + input.get(position).suitup);
						System.out.print("\nNew Suit-Up Type:"); 
						newSpecs[1]=jarvis.InputString();
						for(int i=0;i<All.SuitupTypes.length;i++) {
							if(newSpecs[1].matches(All.SuitupTypes[i])) {
								SuitupFound=true;
							}else if(newSpecs[1].matches("Same") || newSpecs[1].matches("same")) {
								newSpecs[1]=input.get(position).suitup;
								SuitupFound=true;
							}
						}
						if(!SuitupFound) {
							System.out.print("No Valid Index");
						}
					}
					while(!currIsReady) {
						System.out.println("\nSuit Done:" + input.get(position).isReady);
						if(input.get(position).isReady) {
							currIsReady=true;
							break;
						}
						System.out.print("\nIs Suit Ready:");
						newSpecs[2]=jarvis.InputString();
						
						if(newSpecs[2].matches("Yes") || newSpecs[2].matches("yes")) {
							currIsReady=true;
							
						}else if(newSpecs[2].matches("No") || newSpecs[2].matches("no")) {
							currIsReady=false;
							break;
						}else {
							System.out.println("No Valid Index");
						}
						
					}
					
					//loc++;
					Suit Suit=new Suit();
					if(!onAMission) {
						input.set(position, Suit);
						if(Suit.isReady) {
							suitReadyIn.add(Suit);
						}
					}
					for(int i=0;i<suitNonReadyIn.size();i++) {
						if(input.get(position).mark==suitNonReadyIn.get(i).mark) {
							suitNonReadyIn.remove(i);
							break;
						}
					}
				}
			}else {
				System.out.println("\nOn A Mission Suit With Mark:" + position);
			}
		}else {
			System.out.println("\nThere Are No Suits");
		}
		
			
		return input;
		
	}
	
	
	
	
	public void displaySuitSpecs(ArrayList<Suit> suits) {
		if(!suits.isEmpty()) {
			for(Suit suit : suits) {
				System.out.println("\n\n-----------------------");
				System.out.println("...IronMan Suit...");
				System.out.println("Mark:"  + suit.mark);
				System.out.println("Power:" + suit.power);
				System.out.println("X:" + suit.x);
				System.out.println("Y:" + suit.y);
				System.out.println("Armor:"  + suit.armor);
				System.out.println("Suit-Up:"  + suit.suitup);
				System.out.println("Suit Condition:" + suit.isReady);
				System.out.println("___Weapons___");
				for(SuitWeapons weaps: suit.weaponSuits) {
					System.out.println("["+weaps.weaponName + " | " + weaps.weaponPower + " | " + weaps.weaponAmount + "]");
				}
			}
		}else {
			System.out.println("No Suit");
		}
		
	}
}