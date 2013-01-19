package component;

import java.util.ArrayList;
import java.util.List;

import utils.Utils;

import consts.Consts;

public class Matrix4D {

	private List<Point4D> objList = new ArrayList<Point4D>();

	public Matrix4D() {

		objList.add(new Point4D(1.0, 0.0, 0.0, 0.0));
		objList.add(new Point4D(0.0, 1.0, 0.0, 0.0));
		objList.add(new Point4D(0.0, 0.0, 1.0, 0.0));
		objList.add(new Point4D(0.0, 0.0, 0.0, 1.0));

	}

	public Matrix4D(Integer intType) {

		switch(intType) {

		case Consts.View.INT_FRONT:
			objList.add(new Point4D(1.0, 0.0, 0.0, 0.0));
			objList.add(new Point4D(0.0, 1.0, 0.0, 0.0));
			objList.add(new Point4D(0.0, 0.0, 0.0, 0.0));
			objList.add(new Point4D(0.0, 0.0, 0.0, 1.0));
			break;

		case Consts.View.INT_SIDE:
			objList.add(new Point4D(0.0, 0.0, 0.0, 0.0));
			objList.add(new Point4D(0.0, 1.0, 0.0, 0.0));
			objList.add(new Point4D(0.0, 0.0, 1.0, 0.0));
			objList.add(new Point4D(0.0, 0.0, 0.0, 1.0));
			break;

		case Consts.View.INT_TOP:
			objList.add(new Point4D(1.0, 0.0, 0.0, 0.0));
			objList.add(new Point4D(0.0, 0.0, 0.0, 0.0));
			objList.add(new Point4D(0.0, 0.0, 1.0, 0.0));
			objList.add(new Point4D(0.0, 0.0, 0.0, 1.0));
			break;

		}

	}

	public Matrix4D(Integer intType, Double dblValue) {

		Double dblDegree = 0.0;
		Double v11, v13, v31, v33 = 0.0;
		Double v21, v22, v12, v32, v23 = 0.0;

		switch(intType) {

		case Consts.View.INT_X_ROT:

			dblDegree = dblValue;

			v22 = Math.cos(Utils.getRadian(dblDegree));
			v32 = Math.sin(Utils.getRadian(dblDegree)) * -1.0;
			v23 = Math.sin(Utils.getRadian(dblDegree));
			v33 = Math.cos(Utils.getRadian(dblDegree));

			objList.add(new Point4D(1.0, 0.0, 0.0, 0.0));
			objList.add(new Point4D(0.0, v22, v32, 0.0));
			objList.add(new Point4D(0.0, v23, v33, 0.0));
			objList.add(new Point4D(0.0, 0.0, 0.0, 1.0));

			break;

		case Consts.View.INT_Y_ROT:

			dblDegree = dblValue;

			v11 = Math.cos(Utils.getRadian(dblDegree));
			v13 = Math.sin(Utils.getRadian(dblDegree));
			v31 = Math.sin(Utils.getRadian(dblDegree)) * -1.0;
			v33 = Math.cos(Utils.getRadian(dblDegree));

			objList.add(new Point4D(v11, 0.0, v13, 0.0));
			objList.add(new Point4D(0.0, 1.0, 0.0, 0.0));
			objList.add(new Point4D(v31, 0.0, v33, 0.0));
			objList.add(new Point4D(0.0, 0.0, 0.0, 1.0));

			break;

		case Consts.View.INT_Z_ROT:

			dblDegree = dblValue;

			v11 = Math.cos(Utils.getRadian(dblDegree));
			v21 = Math.sin(Utils.getRadian(dblDegree));
			v12 = Math.sin(Utils.getRadian(dblDegree)) * -1.0;
			v22 = Math.cos(Utils.getRadian(dblDegree));

			objList.add(new Point4D(v11, v21, 0.0, 0.0));
			objList.add(new Point4D(v12, v22, 0.0, 0.0));
			objList.add(new Point4D(0.0, 0.0, 1.0, 0.0));
			objList.add(new Point4D(0.0, 0.0, 0.0, 1.0));

			break;

		case Consts.View.INT_PERSPECTIVE:

			Double dblDistance = dblValue;

			Double v34 = 1.0 / dblDistance;

			objList.add(new Point4D(1.0, 0.0, 0.0, 0.0));
			objList.add(new Point4D(0.0, 1.0, 0.0, 0.0));
			objList.add(new Point4D(0.0, 0.0, 0.0, 0.0));
			objList.add(new Point4D(0.0, 0.0, v34, 1.0));

			break;
		}

	}

	public Point4D multiply(Point4D objArgPoint) {

		double x
			= objArgPoint.getX() * objList.get(0).getX()
			+ objArgPoint.getY() * objList.get(0).getY()
			+ objArgPoint.getZ() * objList.get(0).getZ()
			+ objArgPoint.getW() * objList.get(0).getW();

		double y
			= objArgPoint.getX() * objList.get(1).getX()
			+ objArgPoint.getY() * objList.get(1).getY()
			+ objArgPoint.getZ() * objList.get(1).getZ()
			+ objArgPoint.getW() * objList.get(1).getW();

		double z
			= objArgPoint.getX() * objList.get(2).getX()
			+ objArgPoint.getY() * objList.get(2).getY()
			+ objArgPoint.getZ() * objList.get(2).getZ()
			+ objArgPoint.getW() * objList.get(2).getW();

		double w
			= objArgPoint.getX() * objList.get(3).getX()
			+ objArgPoint.getY() * objList.get(3).getY()
			+ objArgPoint.getZ() * objList.get(3).getZ()
			+ objArgPoint.getW() * objList.get(3).getW();

		Point4D objPoint = new Point4D(x, y, z, w);

		return objPoint;

	}

	public Matrix4D(Point4D objPoint0, Point4D objPoint1, Point4D objPoint2, Point4D objPoint3) {

		objList.add(objPoint0);
		objList.add(objPoint1);
		objList.add(objPoint2);
		objList.add(objPoint3);

	}

	public Matrix4D multiply(Matrix4D objArgMatrix) {

		Point4D objPoint0 = objArgMatrix.multiply(objList.get(0));
		Point4D objPoint1 = objArgMatrix.multiply(objList.get(1));
		Point4D objPoint2 = objArgMatrix.multiply(objList.get(2));
		Point4D objPoint3 = objArgMatrix.multiply(objList.get(3));

		return new Matrix4D(objPoint0, objPoint1, objPoint2, objPoint3);

	}

}
