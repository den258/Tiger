package component;

import java.util.ArrayList;
import java.util.List;

import utils.Utils;
import consts.Consts;

public class Model3D {

	private List<Point3D> objList = new ArrayList<Point3D>();

	public List<Point3D> getObjList() {
		return objList;
	}

	public void setObjList(List<Point3D> objListOfPoint3D) {
		this.objList = objListOfPoint3D;
	}

	public void add(Point3D objPoint3D) {

		objList.add(objPoint3D);

	}

	public List<Point3D> getOverPoints(Integer intViewType, Point3D objOveredPoint) {

		List<Point3D> objReturnPoints = new ArrayList<Point3D>();

		for (Point3D objPoint : objList) {

			switch (intViewType) {

				case Consts.View.INT_FRONT:

					if (Utils.isClose(objOveredPoint.getX(), objPoint.getX(), 5.0)) {
						if (Utils.isClose(objOveredPoint.getY(), objPoint.getY(), 5.0)) {
							objReturnPoints.add(objPoint);
						}
					}

				case Consts.View.INT_TOP:

					if (Utils.isClose(objOveredPoint.getX(), objPoint.getX(), 5.0)) {
						if (Utils.isClose(objOveredPoint.getY(), objPoint.getZ(), 5.0)) {
							objReturnPoints.add(objPoint);
						}
					}

				case Consts.View.INT_SIDE:

					if (Utils.isClose(objOveredPoint.getX(), objPoint.getZ(), 5.0)) {
						if (Utils.isClose(objOveredPoint.getY(), objPoint.getY(), 5.0)) {
							objReturnPoints.add(objPoint);
						}
					}

			}

		}

		return objReturnPoints;

	}

	public Model3D getClone() {

		Model3D objModel = new Model3D();
		List<Point3D> objList = new ArrayList<Point3D>();

		for (Point3D objPoint : this.objList) {
			objList.add(objPoint.getClone());
		}

		objModel.setObjList(objList);

		return objModel;

	}
}
