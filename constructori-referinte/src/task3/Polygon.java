package task3;

public class Polygon {
	private Point[] points;
	
	public Polygon(int n) {
		points = new Point[n];
	}
	
	public Polygon(float[] vector) {
		this((vector.length)/2);
		for (int i = 0; i < (vector.length)/2; i++) {
			points[i] = new Point(vector[i*2], vector[i*2 + 1]);
		}
	}
	
	public void showPolygon(int n) {
		for (int i = 0; i < n; i++) {
			System.out.println(points[i]);
		}
	}
}
