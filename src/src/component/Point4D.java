package component;

public class Point4D {

	private Double x = 0.0;

	private Double y = 0.0;

	private Double z = 0.0;

	private Double w = 0.0;

	public Point4D(Double x, Double y, Double z, Double w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
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

	public Double getW() {
		return w;
	}

	public void setW(Double w) {
		this.w = w;
	}

	public static Point4D getFrom3D(Point3D objPoint) {

		return new Point4D(
				objPoint.getX(),
				objPoint.getY(),
				objPoint.getZ(),
				0.0);

	}

}
