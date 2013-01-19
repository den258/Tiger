package component;

import java.util.ArrayList;
import java.util.List;

import utils.Utils;
import consts.Consts;

public class Matrix3D {

	private List<Point3D> objList = new ArrayList<Point3D>();

	public Matrix3D(Integer intType, Integer intDegree) {

		switch(intType) {

			case Consts.Matrix.INT_ROTATION_2D:
				objList.add(
						new Point3D(
								Math.cos(Utils.getRadian(intDegree)),
								Math.sin(Utils.getRadian(intDegree)) * -1,
								0.0));
				objList.add(
						new Point3D(
								Math.sin(Utils.getRadian(intDegree)),
								Math.cos(Utils.getRadian(intDegree)),
								0.0));
				objList.add(
						new Point3D(
								0.0,
								0.0,
								1.0));
				break;

		}

	}

	public Matrix3D(Integer intType, Integer intMoveX, Integer intMoveY) {

		switch(intType) {

			case Consts.Matrix.INT_MOVE_2D:
				objList.add(
						new Point3D(
								1.0,
								0.0,
								intMoveX.doubleValue()));
				objList.add(
						new Point3D(
								0.0,
								1.0,
								intMoveY.doubleValue()));
				objList.add(
						new Point3D(
								0.0,
								0.0,
								1.0));
				break;

		}

	}

	public Matrix3D(Integer intType) {

		switch(intType) {

			case Consts.Matrix.INT_REVERSE_Y:
				objList.add(
						new Point3D(
								1.0,
								0.0,
								0.0));
				objList.add(
						new Point3D(
								0.0,
								1.0 * -1.0,
								0.0));
				objList.add(
						new Point3D(
								0.0,
								0.0,
								1.0));
				break;

		}

	}

	public Matrix3D(Point3D objPoint0, Point3D objPoint1, Point3D objPoint2) {

		objList.add(objPoint0);
		objList.add(objPoint1);
		objList.add(objPoint2);

	}

	public Point3D multiply(Point3D objArgPoint) {

//		System.out.println(objArgPoint);

		double x
			= objArgPoint.getX() * objList.get(0).getX()
			+ objArgPoint.getY() * objList.get(0).getY()
			+ objArgPoint.getZ() * objList.get(0).getZ();

		double y
			= objArgPoint.getX() * objList.get(1).getX()
			+ objArgPoint.getY() * objList.get(1).getY()
			+ objArgPoint.getZ() * objList.get(1).getZ();

		double z
			= objArgPoint.getX() * objList.get(2).getX()
			+ objArgPoint.getY() * objList.get(2).getY()
			+ objArgPoint.getZ() * objList.get(2).getZ();

		Point3D objPoint = new Point3D(x, y, z);

//		System.out.println(objPoint);

		return objPoint;

	}

	public Matrix3D multiply(Matrix3D objArgMatrix) {

		Point3D objPoint0 = objArgMatrix.multiply(objList.get(0));
		Point3D objPoint1 = objArgMatrix.multiply(objList.get(1));
		Point3D objPoint2 = objArgMatrix.multiply(objList.get(2));

		return new Matrix3D(objPoint0, objPoint1, objPoint2);

	}

	public String toString() {
		return
				objList.get(0).getX() + ", " + objList.get(0).getY() + ", " + objList.get(0).getZ() + "\n" +
				objList.get(1).getX() + ", " + objList.get(1).getY() + ", " + objList.get(1).getZ() + "\n" +
				objList.get(2).getX() + ", " + objList.get(2).getY() + ", " + objList.get(2).getZ();

	}

}
