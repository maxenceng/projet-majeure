package fct0.utils;

/**
 * Enumération définissant la direction prise par le robot,
 * provoquant un changement des coordonnées et de l'orientation.
 * @author
 *
 */
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
