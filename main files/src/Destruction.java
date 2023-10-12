
public class Destruction {
	
	int height;
	int length;
	int width;
	int velocity;
	int dist;
	int potentialDestruct;
	
	public Destruction(int height,int length,int width,int velocity,int dist) {
		this.height=height;
		this.length=length;
		this.width=width;
		this.velocity=velocity;
		this.dist=dist;
		potentialDestruct=(length * width * height) * All.g + velocity * dist;
	}
	
	public Destruction() {
		
	}
	
	
}
