package fct0.utils;

public enum Direction {
	UP(-1, 0, Orientation.N), 
	DOWN(1, 0, Orientation.S), 
	LEFT(0, -1, Orientation.W), 
	RIGHT(0, 1, Orientation.E);
	
	public int x;
	public int y;
	public Orientation o;
	
	private Direction(int x, int y, Orientation o) {
		this.x = x;
		this.y = y;
		this.o = o;
	}
}
