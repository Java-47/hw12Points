package telran.point.dao;

import java.util.Arrays;
import java.util.Comparator;

import telran.point.comparators.PointComparator;
import telran.point.model.Point;

public class PointsSpace {
	Point[] points;
	Point relPoint;
	Comparator<Point> comparator;

	public PointsSpace(Point[] points, Point relPoint) {
		this.points = Arrays.copyOf(points, points.length);
		this.relPoint = relPoint;
		comparator = new PointComparator(this.relPoint);
		Arrays.sort(this.points, comparator);
	}

	public Point[] getPoints() {
		return points;
	}

	public void addPoint(Point point) {

		int indexOfNewPoint = -Arrays.binarySearch(this.points, point, comparator) - 1;

		if (indexOfNewPoint < 0) {
			indexOfNewPoint = -indexOfNewPoint - 1;
		}

		Point[] newArrayPoints = new Point[this.points.length + 1];

		System.arraycopy(this.points, 0, newArrayPoints, 0, indexOfNewPoint);
		newArrayPoints[indexOfNewPoint] = point;
		System.arraycopy(this.points, indexOfNewPoint, newArrayPoints, indexOfNewPoint + 1,
				this.points.length - indexOfNewPoint);
		
		this.points = newArrayPoints;
		//printArray(this.points);

	}

	public void printArray(Point[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

	}
}
