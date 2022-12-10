package telran.point.comparators;

import java.util.Comparator;

import telran.point.model.Point;

public class PointComparator implements Comparator<Point> {
	Point relPoint;

	public PointComparator(Point relPoint) {
		this.relPoint = relPoint;
	}

	@Override
	public int compare(Point o1, Point o2) {
		double distance1 = Math.pow(this.relPoint.getX() - o1.getX(), 2)
				+ Math.pow(this.relPoint.getY() - o1.getY(), 2);
		double distance2 = Math.pow(this.relPoint.getX() - o2.getX(), 2)
				+ Math.pow(this.relPoint.getY() - o2.getY(), 2);
		return (int) (distance1 - distance2);
	}

}
