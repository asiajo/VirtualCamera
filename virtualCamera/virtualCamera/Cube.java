package virtualCamera;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

/**
 * A class responsible for cubes creation - shape visible in the field.
 *
 */
public class Cube {
	private double[] xValues;
	private double[] yValues;
	private double[] zValues;
	private int[] xFlattened;
	private int[] yFlattened;
	int zoom;

	public Cube(double x, double y, double z, double width, double height, double depth) {

		this.zoom = 500;
		this.xValues = new double[8];
		this.yValues = new double[8];
		this.zValues = new double[8];
		this.xFlattened = new int[8];
		this.yFlattened = new int[8];

		this.xValues[0] = x;
		this.yValues[0] = y;
		this.zValues[0] = z;

		this.xValues[1] = x;
		this.yValues[1] = y + height;
		this.zValues[1] = z;

		this.xValues[2] = x + width;
		this.yValues[2] = y + height;
		this.zValues[2] = z;

		this.xValues[3] = x + width;
		this.yValues[3] = y;
		this.zValues[3] = z;

		this.xValues[4] = x + width;
		this.yValues[4] = y;
		this.zValues[4] = z + depth;

		this.xValues[5] = x;
		this.yValues[5] = y;
		this.zValues[5] = z + depth;

		this.xValues[6] = x;
		this.yValues[6] = y + height;
		this.zValues[6] = z + depth;

		this.xValues[7] = x + width;
		this.yValues[7] = y + height;
		this.zValues[7] = z + depth;
		flatten();
	}

	public void flatten() {
		for (int i = 0; i < 8; i++) {
			if (this.zValues[i] == 0)
				this.zValues[i] = 0.01;
			this.xFlattened[i] = (int) ((this.xValues[i] * this.zoom) / this.zValues[i]);
			this.yFlattened[i] = (int) ((this.yValues[i] * this.zoom) / this.zValues[i]);
		}
	}

	
	// -------------- MOVEMENT FUNCTIONS --------------------
	public void zoomMinus() {
		this.zoom = this.zoom + 10;
		flatten();
	}

	public void zoomPlus() {
		this.zoom = this.zoom - 10;
		flatten();
	}

	public void goRight() {
		for (int i = 0; i < 8; i++)
			this.xValues[i] = this.xValues[i] + 1;
		flatten();
	}

	public void goLeft() {
		for (int i = 0; i < 8; i++)
			this.xValues[i] = this.xValues[i] - 1;
		flatten();
	}

	public void goUp() {
		for (int i = 0; i < 8; i++)
			this.yValues[i] = this.yValues[i] - 1;
		flatten();
	}

	public void goDown() {
		for (int i = 0; i < 8; i++)
			this.yValues[i] = this.yValues[i] + 1;
		flatten();
	}

	public void goBack() {
		for (int i = 0; i < 8; i++) {
			this.zValues[i] = this.zValues[i] - 1;
		}
		flatten();
	}

	public void goForward() {
		for (int i = 0; i < 8; i++) {
			this.zValues[i] = this.zValues[i] + 1;
		}
		flatten();
	}

	public void rotYRight() {
		double fi = Math.PI / 9;
		for (int i = 0; i < 8; i++) {
			this.xValues[i] = (this.xValues[i] * Math.cos(fi)) + (this.zValues[i] * Math.sin(fi));
			this.zValues[i] = (this.xValues[i] * Math.sin(fi) * (-1)) + (this.zValues[i] * Math.cos(fi));
		}
		flatten();
	}

	public void rotYLeft() {
		double fi = (Math.PI * 2) - Math.PI / 9;
		for (int i = 0; i < 8; i++) {
			this.xValues[i] = (this.xValues[i] * cos(fi) + this.zValues[i] * sin(fi));
			this.zValues[i] = (this.xValues[i] * sin(fi) * (-1) + this.zValues[i] * cos(fi));
		}
		flatten();
	}

	public void rotZLeft() {
		double fi = Math.PI / 9;
		for (int i = 0; i < 8; i++) {
			this.xValues[i] = (this.xValues[i] * cos(fi) - this.yValues[i] * sin(fi));
			this.yValues[i] = (this.xValues[i] * sin(fi) + this.yValues[i] * cos(fi));
		}
		flatten();
	}

	public void rotZRight() {
		double fi = (Math.PI * 2) - Math.PI / 9;
		for (int i = 0; i < 8; i++) {
			this.xValues[i] = (this.xValues[i] * cos(fi) - this.yValues[i] * sin(fi));
			this.yValues[i] = (this.xValues[i] * sin(fi) + this.yValues[i] * cos(fi));
		}
		flatten();
	}

	public void rotXUp() {
		double fi = Math.PI / 9;
		for (int i = 0; i < 8; i++) {
			this.yValues[i] = (this.yValues[i] * cos(fi) - this.zValues[i] * sin(fi));
			this.zValues[i] = (this.yValues[i] * sin(fi) + this.zValues[i] * cos(fi));
		}
		flatten();
	}

	public void rotXDown() {
		double fi = (Math.PI * 2) - Math.PI / 9;
		for (int i = 0; i < 8; i++) {
			this.yValues[i] = (this.yValues[i] * cos(fi) - this.zValues[i] * sin(fi));
			this.zValues[i] = (this.yValues[i] * sin(fi) + this.zValues[i] * cos(fi));
		}
		flatten();
	}

	public int[] getXFlattened() {
		return xFlattened;
	}

	public int[] getYFlattened() {
		return yFlattened;
	}
}
