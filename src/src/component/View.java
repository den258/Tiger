package component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import utils.Utils;
import consts.Consts;

public class View extends JPanel implements MouseListener, MouseMotionListener {

	/**
	 *
	 */
	private static final long serialVersionUID = 4443797922384408331L;

	/**
	 * Private Fields
	 */
	private List<Point2D> objPointList = new ArrayList<Point2D>();
	private Integer intViewType = 0;
	private Model3D objModel3D = new Model3D();
	private List<Point3D> objOverPoints = new ArrayList<Point3D>();
	private JFrame objFrame = new JFrame();

	public Model3D getObjModel3D() {
		return objModel3D;
	}

	public void setObjModel3D(Model3D objModel) {
		this.objModel3D = objModel;
	}

	/**
	 *
	 */
	public View(Integer intArgViewType, JFrame objArgFrame) {
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.intViewType = intArgViewType;
		this.objFrame = objArgFrame;
	}

	/**
	 *
	 */
	@Override
	public void paint(Graphics g) {

		g.setColor(new Color(255, 255, 255));
		g.fillRect(0, 0, getWidth(), getHeight());

		Integer intMoveX = (this.getWidth() / 2);
		Integer intMoveY = (this.getHeight() / 2);

		g.setColor(new Color(0, 0, 0));
		g.drawLine(intMoveX, intMoveY, intMoveX + 50, intMoveY);
		g.drawLine(intMoveX, intMoveY, intMoveX, intMoveY - 50);

		Matrix3D objMatrix1 =
				new Matrix3D(
						Consts.Matrix.INT_MOVE_2D,
						intMoveX,
						intMoveY);

		Matrix3D objMatrix2 =
				new Matrix3D(
						Consts.Matrix.INT_REVERSE_Y);

		Matrix3D objMatrix3 = objMatrix1.multiply(objMatrix2);

		g.setColor(new Color(0, 0, 0));

		Point2D objStartPoint = null;

		Integer intIndex = 0;

		for (Point3D objPoint : objModel3D.getObjList()) {

			Point2D objEndPoint =
					Point2D.getProjectedPoint3D(
							objMatrix3.multiply(
									Point3D.getProjectedPoint3D2(
											intViewType,
											objPoint)));

			g.setColor(new Color(0, 0, 0));

			for (Point3D objOverPoint : objOverPoints) {

				if (objOverPoint.equals(objPoint)) {
					g.setColor(new Color(255, 0, 0));
				}

			}

			if (objStartPoint == null) {

				g.drawRect(
						objEndPoint.getX().intValue() - 5,
						objEndPoint.getY().intValue() - 5,
						10, 10);

			} else {

				g.drawRect(
						objStartPoint.getX().intValue() - 5,
						objStartPoint.getY().intValue() - 5,
						10, 10);

				g.setColor(new Color(0, 0, 0));

				g.drawLine(
						objStartPoint.getX().intValue(),
						objStartPoint.getY().intValue(),
						objEndPoint.getX().intValue(),
						objEndPoint.getY().intValue());

			}

			objStartPoint = objEndPoint;

			intIndex++;

		}

		if (objStartPoint != null) {

			g.drawRect(
					objStartPoint.getX().intValue() - 5,
					objStartPoint.getY().intValue() - 5,
					10, 10);

		}

	}

	public void mouseClicked(MouseEvent e) {

		objModel3D.add(
				getCilckedPoint3D(
						intViewType,
						e.getX(),
						e.getY(),
						this.getWidth() / 2,
						this.getHeight() / 2));

		repaint();

	}

	public void mouseEntered(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void mouseExited(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void mousePressed(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void mouseReleased(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void ClearLine() {
		objPointList.clear();
	}

	public void mouseDragged(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void mouseMoved(MouseEvent e) {

		objOverPoints = objModel3D.getOverPoints(
				intViewType,
				getCilckedPoint3D(
						intViewType,
						e.getX(),
						e.getY(),
						this.getWidth() / 2,
						this.getHeight() / 2));

		System.out.println("objOverPoints.size");
		System.out.println(objOverPoints.size());

		repaint();

	}

	private Point3D getCilckedPoint3D(Integer intViewType, Integer intX, Integer intY, Integer intMoveX, Integer intMoveY) {

		Matrix3D objMatrix1 =
				new Matrix3D(
						Consts.Matrix.INT_MOVE_2D,
						intMoveX * -1,
						intMoveY);

		Matrix3D objMatrix2 =
				new Matrix3D(
						Consts.Matrix.INT_REVERSE_Y);

		Matrix3D objMatrix3 = objMatrix1.multiply(objMatrix2);

		Point3D objPoint =
				Point3D.getFrom2D(
					new Point2D(
							(double)intX,
							(double)intY));

		return
				Point3D.getProjectedPoint3D(
						intViewType,
						objMatrix3.multiply(
								objPoint));

	}

}
