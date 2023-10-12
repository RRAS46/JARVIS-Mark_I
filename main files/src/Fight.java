

public class Fight {
	String[] data=new String[120];
	int[] newPattern=new int[data.length];
	int[] output=new int[data.length];
	
	
	public Fight(int n) {
		this.data=new String[n];
	}
	
	public Fight() {
		
	}
	
	public int[] createFightPattern(String[] data) {
		int[] loc=new int[data.length];
		for(int i=0;i<data.length;i++) {
			for(int j=0;j<All.types.length;j++) {
				if(data[i]==All.types[j]) {
					loc[i]=j;
					break;
				}
			}
		}
		return loc;
	}
	
	public int[] analyzeFightPattern(int[] loc,int n) {
		int[] curr=new int[n];
		int[] patterns=new int[loc.length];
		int pos=0;
		int currpos=0;
		boolean found=false;
		for(int i=0;i<n;i++) {
			curr[i]=loc[i];
		}
		for(int i=n;i<loc.length;i++) {
				for(int h=0;h<n;h++) {
					if(i<loc.length - (n-1)) {
						if(loc[i + currpos]==curr[currpos]) { 
							currpos++;
						}else {
							break;
						}	
					
				}
				
			}
			if(currpos==n) {
				patterns[pos]=i;	
				pos++;
				i+=n;
			}
			currpos=0;
		}
		return patterns;
	}
	
}
