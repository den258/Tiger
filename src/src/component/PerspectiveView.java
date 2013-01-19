package component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import consts.Consts;

public class PerspectiveView extends JPanel implements MouseListener, MouseMotionListener {

	/**
	 *
	 */
	private static final long serialVersionUID = -253919554529677776L;

	private Integer intViewType = 0;
	private JFrame objFrame = new JFrame();
	private Integer intStartX = 0;
	private Integer intStartY = 0;
	private Model3D objModel = new Model3D();
	private Matrix4D objMatrix = new Matrix4D();

	/**
	 *
	 */
	public Model3D getObjModel() {
		return objModel;
	}

	/**
	 *
	 */
	public void setObjModel(Model3D objModel) {
		this.objModel = objModel.getClone();
	}

	@Override
	public void paint(Graphics g) {

		g.setColor(new Color(255, 255, 255));
		g.fillRect(0, 0, getWidth(), getHeight());

		Matrix4D objMatrix = new Matrix4D(Consts.View.INT_PERSPECTIVE, 100.0);

		this.objMatrix.multiply(objMatrix);

		Point3D objSavedPoint = null;

		Integer intMoveX = (this.getWidth() / 2);
		Integer intMoveY = (this.getHeight() / 2);

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

		System.out.println();

		for (Point3D obj3DPoint : objModel.getObjList()) {

			Point3D objPoint =
					Point3D.getProjectedPoint3D2(
							Consts.View.INT_FRONT,
							Point3D.getFrom4D(
									this.objMatrix.multiply(
											Point4D.getFrom3D(obj3DPoint))));

			objPoint = objMatrix3.multiply(objPoint);

			System.out.println(objPoint.getX() + ", " + objPoint.getY());

			if (objSavedPoint != null) {

				g.drawLine(
						objPoint.getX().intValue(),
						objPoint.getY().intValue(),
						objSavedPoint.getX().intValue(),
						objSavedPoint.getY().intValue());

			}

			objSavedPoint = objPoint;

		}

	}

	/**
	 *
	 */
	public PerspectiveView(Integer intArgViewType, JFrame objArgFrame) {

		this.addMouseListener(this);
		this.addMouseMotionListener(this);

		this.intViewType = intArgViewType;
		this.objFrame = objArgFrame;

	}

	public void mouseDragged(MouseEvent e) {

		Integer intDX = intStartX - e.getX();
		Integer intDY = intStartY - e.getY();

		Matrix4D objMatrixX = new Matrix4D(Consts.View.INT_Y_ROT, intDX.doubleValue());
		Matrix4D objMatrixY = new Matrix4D(Consts.View.INT_X_ROT, intDY.doubleValue());

		this.objMatrix = objMatrixX.multiply(objMatrixY);

		repaint();

	}

	public void mouseMoved(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void mouseClicked(MouseEvent e) {

		intStartX = e.getX();
		intStartY = e.getY();

		repaint();

	}

	public void mousePressed(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void mouseReleased(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void mouseEntered(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void mouseExited(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
