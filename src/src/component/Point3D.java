package component;

import consts.Consts;
import utils.Utils;

public class Point3D {

	private Double x = 0.0;

	private Double y = 0.0;

	private Double z = 0.0;

	public Point3D(Double x, Double y, Double z) {
		this.x = x;
		this.y = y;
		this.z = z;
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

	public Double getZ() {
		return z;
	}

	public void setZ(Double z) {
		this.z = z;
	}

	public String toString() {
		return this.x + ", " + this.y + ", " + this.z;
	}

	public Boolean equals(Point3D objPoint) {

		if (Utils.isClose(this.getX(), objPoint.getX(), 1.0)) {
			if (Utils.isClose(this.getY(), objPoint.getY(), 1.0)) {
				if (Utils.isClose(this.getZ(), objPoint.getZ(), 1.0)) {
					return true;
				}
			}
		}

		return false;

	}

	public static Point3D getFrom4D(Point4D objPoint) {

		return new Point3D(
				objPoint.getX(),
				objPoint.getY(),
				objPoint.getZ());

	}

	public static Point3D getFrom2D(Point2D objPoint) {

		return new Point3D(
				objPoint.getX(),
				objPoint.getY(),
				1.0);

	}

	public static Point3D getProjectedPoint3D(Integer intViewType, Point3D objPoint) {

		Point3D objReturnPoint = new Point3D(0.0, 0.0, 0.0);

		switch(intViewType) {

			case Consts.View.INT_FRONT:
				objReturnPoint =
					new Point3D(
						objPoint.getX(),
						objPoint.getY(),
						objPoint.getZ());
				break;

			case Consts.View.INT_SIDE:
				objReturnPoint =
					new Point3D(
						objPoint.getZ(),
						objPoint.getY(),
						objPoint.getX());
				break;

			case Consts.View.INT_TOP:
				objReturnPoint =
					new Point3D(
						objPoint.getX(),
						objPoint.getZ(),
						objPoint.getY());
				break;

		}

		return objReturnPoint;

	}

	public static Point3D getProjectedPoint3D2(Integer intViewType, Point3D objPoint) {

		Point3D objReturnPoint = new Point3D(0.0, 0.0, 0.0);

		switch(intViewType) {

			case Consts.View.INT_FRONT:
				objReturnPoint =
					new Point3D(
						objPoint.getX(),
						objPoint.getY(),
						1.0);
				break;

			case Consts.View.INT_SIDE:
				objReturnPoint =
					new Point3D(
						objPoint.getZ(),
						objPoint.getY(),
						1.0);
				break;

			case Consts.View.INT_TOP:
				objReturnPoint =
					new Point3D(
						objPoint.getX(),
						objPoint.getZ(),
						1.0);
				break;

		}

		return objReturnPoint;

	}

	public static Point3D getPoint3DFrom2D(Integer intViewType, Point2D objPoint) {

		Point3D objReturnPoint = new Point3D(0.0, 0.0, 0.0);

		switch(intViewType) {

			case Consts.View.INT_FRONT:
				objReturnPoint =
					new Point3D(
						objPoint.getX(),
						objPoint.getY(),
						0.0);
				break;

			case Consts.View.INT_SIDE:
				objReturnPoint =
					new Point3D(
						0.0,
						objPoint.getY(),
						objPoint.getX());
				break;

			case Consts.View.INT_TOP:
				objReturnPoint =
					new Point3D(
						objPoint.getX(),
						0.0,
						objPoint.getY());
				break;

		}

		return objReturnPoint;

	}

	public Point3D getClone() {

		return new Point3D(this.x, this.y, this.z);

	}

}
