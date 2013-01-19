package component;

import consts.Consts;

public class Point2D {

	private Double x = 0.0;

	private Double y = 0.0;

	public Point2D(Double x, Double y) {
		this.x = x;
		this.y = y;
	}

	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}

	public static Point2D getPoint2DFrom3D(Integer intViewType, Point3D objPoint) {

		Point2D objReturnPoint = new Point2D(0.0, 0.0);

		switch(intViewType) {

			case Consts.View.INT_FRONT:
				objReturnPoint =
					new Point2D(
						objPoint.getX(),
						objPoint.getY());
				break;

			case Consts.View.INT_SIDE:
				objReturnPoint =
					new Point2D(
						objPoint.getZ(),
						objPoint.getY());
				break;

			case Consts.View.INT_TOP:
				objReturnPoint =
					new Point2D(
						objPoint.getX(),
						objPoint.getZ());
				break;

		}

		return objReturnPoint;

	}

	public static Point2D getProjectedPoint3D(Point3D objPoint) {

		return new Point2D(
				objPoint.getX(),
				objPoint.getY());

	}

}
