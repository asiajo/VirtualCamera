package virtualCamera;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * 
 * The panel with cubes - main panel.
 * 
 * 
 */
public class CameraField extends JPanel {

	private static final long serialVersionUID = 1L; // default

	Cube cube1 = new Cube(-3, 9, 14, 2, 2, 2);
	Cube cube2 = new Cube(0, 8, 14, 2, 3, 2);
	Cube cube3 = new Cube(-3, 7, 11, 2, 4, 2);
	Cube cube4 = new Cube(0, 6, 11, 2, 5, 2);
	Cube cube5 = new Cube(-3, 5, 8, 2, 6, 2);
	Cube cube6 = new Cube(0, 4, 8, 2, 7, 2);
	Cube cube7 = new Cube(3, 3, 14, 2, 8, 2);
	Cube cube8 = new Cube(3, 2, 11, 2, 9, 2);
	Cube cube9 = new Cube(3, 1, 8, 2, 10, 2);

	public ArrayList<Cube> getCubes() {
		ArrayList<Cube> cubes = new ArrayList<Cube>();
		cubes.add(cube1);
		cubes.add(cube2);
		cubes.add(cube3);
		cubes.add(cube4);
		cubes.add(cube5);
		cubes.add(cube6);
		cubes.add(cube7);
		cubes.add(cube8);
		cubes.add(cube9);
		return cubes;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Variables.width, Variables.width);
		g.translate(Variables.width / 2, Variables.width / 4);
		g.setColor(Color.WHITE);
		drawCubes(g, getCubes());
	}

	public void drawCubes(Graphics g, ArrayList<Cube> cubes) {

		for (Cube cube : cubes) {
			g.drawLine(cube.getXFlattened()[0], cube.getYFlattened()[0], cube.getXFlattened()[1],
					cube.getYFlattened()[1]);
			g.drawLine(cube.getXFlattened()[0], cube.getYFlattened()[0], cube.getXFlattened()[3],
					cube.getYFlattened()[3]);
			g.drawLine(cube.getXFlattened()[1], cube.getYFlattened()[1], cube.getXFlattened()[2],
					cube.getYFlattened()[2]);
			g.drawLine(cube.getXFlattened()[2], cube.getYFlattened()[2], cube.getXFlattened()[3],
					cube.getYFlattened()[3]);
			g.drawLine(cube.getXFlattened()[0], cube.getYFlattened()[0], cube.getXFlattened()[5],
					cube.getYFlattened()[5]);
			g.drawLine(cube.getXFlattened()[1], cube.getYFlattened()[1], cube.getXFlattened()[6],
					cube.getYFlattened()[6]);
			g.drawLine(cube.getXFlattened()[2], cube.getYFlattened()[2], cube.getXFlattened()[7],
					cube.getYFlattened()[7]);
			g.drawLine(cube.getXFlattened()[3], cube.getYFlattened()[3], cube.getXFlattened()[4],
					cube.getYFlattened()[4]);
			g.drawLine(cube.getXFlattened()[4], cube.getYFlattened()[4], cube.getXFlattened()[5],
					cube.getYFlattened()[5]);
			g.drawLine(cube.getXFlattened()[5], cube.getYFlattened()[5], cube.getXFlattened()[6],
					cube.getYFlattened()[6]);
			g.drawLine(cube.getXFlattened()[4], cube.getYFlattened()[4], cube.getXFlattened()[7],
					cube.getYFlattened()[7]);
			g.drawLine(cube.getXFlattened()[6], cube.getYFlattened()[6], cube.getXFlattened()[7],
					cube.getYFlattened()[7]);
		}
	}

}