package virtualCamera;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 * 
 * A class responsible for displaying and controlling elements. Bottom panel
 * with buttons is placed here and butoons and keyboard logic.
 * 
 */
public class WindowVC extends JFrame {
	private static final long serialVersionUID = 1L; // default
	CameraField cameraField = new CameraField();
	int buttonWidth;
	int buttonHeight;

	public WindowVC() {
		buttonWidth = (int) (Variables.width / 7.25);
		buttonHeight = (Variables.height - Variables.width) / 2;
		buttonsPanel();
	}

	private void buttonsPanel() {

		// Buttons Images
		Image goLeft = null;
		Image goLeftBig = null;
		Image goRight = null;
		Image goRightBig = null;
		Image goDown = null;
		Image goDownBig = null;
		Image goUp = null;
		Image goUpBig = null;
		Image goFwd = null;
		Image goFwdBig = null;
		Image goBack = null;
		Image goBackBig = null;
		Image rotLeft = null;
		Image rotLeftBig = null;
		Image rotLeftZ = null;
		Image rotLeftZBig = null;
		Image rotRight = null;
		Image rotRightBig = null;
		Image rotRightZ = null;
		Image rotRightZBig = null;
		Image xDown = null;
		Image xDownBig = null;
		Image xUp = null;
		Image xUpBig = null;
		Image zoomIn = null;
		Image zoomInBig = null;
		Image zoomOut = null;
		Image zoomOutBig = null;
		// Window icon
		Image camera = null;

		try {
			goLeftBig = ImageIO.read(getClass().getResource("resources/buttons/goLeft.jpg"));
			goRightBig = ImageIO.read(getClass().getResource("resources/buttons/goRight.jpg"));
			goDownBig = ImageIO.read(getClass().getResource("resources/buttons/goDown.jpg"));
			goUpBig = ImageIO.read(getClass().getResource("resources/buttons/goUp.jpg"));
			goFwdBig = ImageIO.read(getClass().getResource("resources/buttons/goFwd.jpg"));
			goBackBig = ImageIO.read(getClass().getResource("resources/buttons/goBack.jpg"));
			rotLeftBig = ImageIO.read(getClass().getResource("resources/buttons/rotLeft.jpg"));
			rotLeftZBig = ImageIO.read(getClass().getResource("resources/buttons/rotLeftZ.jpg"));
			rotRightBig = ImageIO.read(getClass().getResource("resources/buttons/rotRight.jpg"));
			rotRightZBig = ImageIO.read(getClass().getResource("resources/buttons/rotRightZ.jpg"));
			xDownBig = ImageIO.read(getClass().getResource("resources/buttons/xDown.jpg"));
			xUpBig = ImageIO.read(getClass().getResource("resources/buttons/xUp.jpg"));
			zoomInBig = ImageIO.read(getClass().getResource("resources/buttons/zoomIn.jpg"));
			zoomOutBig = ImageIO.read(getClass().getResource("resources/buttons/zoomOut.jpg"));
			camera = ImageIO.read(getClass().getResource("resources/camera.png"));

		} catch (Exception ex) {
			System.out.println(ex);
		}

		// Adapting the size of images
		goLeft = goLeftBig.getScaledInstance(buttonWidth, buttonHeight, java.awt.Image.SCALE_SMOOTH);
		goRight = goRightBig.getScaledInstance(buttonWidth, buttonHeight, java.awt.Image.SCALE_SMOOTH);
		goDown = goDownBig.getScaledInstance(buttonWidth, buttonHeight, java.awt.Image.SCALE_SMOOTH);
		goUp = goUpBig.getScaledInstance(buttonWidth, buttonHeight, java.awt.Image.SCALE_SMOOTH);
		goFwd = goFwdBig.getScaledInstance(buttonWidth, buttonHeight, java.awt.Image.SCALE_SMOOTH);
		goBack = goBackBig.getScaledInstance(buttonWidth, buttonHeight, java.awt.Image.SCALE_SMOOTH);
		rotLeft = rotLeftBig.getScaledInstance(buttonWidth, buttonHeight, java.awt.Image.SCALE_SMOOTH);
		rotLeftZ = rotLeftZBig.getScaledInstance(buttonWidth, buttonHeight, java.awt.Image.SCALE_SMOOTH);
		rotRight = rotRightBig.getScaledInstance(buttonWidth, buttonHeight, java.awt.Image.SCALE_SMOOTH);
		rotRightZ = rotRightZBig.getScaledInstance(buttonWidth, buttonHeight, java.awt.Image.SCALE_SMOOTH);
		xDown = xDownBig.getScaledInstance(buttonWidth, buttonHeight, java.awt.Image.SCALE_SMOOTH);
		xUp = xUpBig.getScaledInstance(buttonWidth, buttonHeight, java.awt.Image.SCALE_SMOOTH);
		zoomIn = zoomInBig.getScaledInstance(buttonWidth, buttonHeight, java.awt.Image.SCALE_SMOOTH);
		zoomOut = zoomOutBig.getScaledInstance(buttonWidth, buttonHeight, java.awt.Image.SCALE_SMOOTH);

		// Creating buttons and applying images
		JButton forwardButton = new JButton();
		forwardButton.setIcon(new ImageIcon(goFwd));
		JButton backButton = new JButton();
		backButton.setIcon(new ImageIcon(goBack));
		JButton leftButton = new JButton();
		leftButton.setIcon(new ImageIcon(goLeft));
		JButton rightButton = new JButton();
		rightButton.setIcon(new ImageIcon(goRight));
		JButton upButton = new JButton();
		upButton.setIcon(new ImageIcon(goUp));
		JButton downButton = new JButton();
		downButton.setIcon(new ImageIcon(goDown));
		JButton rotateYRightButton = new JButton();
		rotateYRightButton.setIcon(new ImageIcon(rotRight));
		JButton rotateYLeftButton = new JButton();
		rotateYLeftButton.setIcon(new ImageIcon(rotLeft));
		JButton rotateZLeftButton = new JButton();
		rotateZLeftButton.setIcon(new ImageIcon(rotLeftZ));
		JButton rotateZRightButton = new JButton();
		rotateZRightButton.setIcon(new ImageIcon(rotRightZ));
		JButton rotateXUpButton = new JButton();
		rotateXUpButton.setIcon(new ImageIcon(xUp));
		JButton rotateXDownButton = new JButton();
		rotateXDownButton.setIcon(new ImageIcon(xDown));
		JButton zoomInButton = new JButton();
		zoomInButton.setIcon(new ImageIcon(zoomIn));
		JButton zoomOutButton = new JButton();
		zoomOutButton.setIcon(new ImageIcon(zoomOut));

		// Panel with buttons
		JPanel buttonsPanel = new JPanel();
		ArrayList<JButton> buttons = new ArrayList<JButton>();

		buttons.add(rotateXUpButton);
		buttons.add(rotateZLeftButton);
		buttons.add(upButton);
		buttons.add(forwardButton);
		buttons.add(downButton);
		buttons.add(rotateZRightButton);
		buttons.add(rotateXDownButton);

		buttons.add(zoomOutButton);
		buttons.add(rotateYLeftButton);
		buttons.add(leftButton);
		buttons.add(backButton);
		buttons.add(rightButton);
		buttons.add(rotateYRightButton);
		buttons.add(zoomInButton);

		buttonsPanel.setPreferredSize(new Dimension(Variables.width, Variables.height - Variables.width));
		buttonsPanel.setBackground(Color.BLACK);

		for (int i = 0; i < buttons.size(); i++) {
			buttonsPanel.add(buttons.get(i));
			buttons.get(i).setPreferredSize(new Dimension(buttonWidth, buttonHeight));
		}

		// ----------------BUTTONS ACTION --------------------
		rightButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goRight();
				cameraField.grabFocus();
			}
		});
		leftButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goLeft();
				cameraField.grabFocus();
			}
		});
		upButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goUp();
				cameraField.grabFocus();
			}
		});
		downButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goDown();
				cameraField.grabFocus();
			}
		});
		forwardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goForward();
				cameraField.grabFocus();
			}
		});
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goBack();
				cameraField.grabFocus();
			}
		});
		rotateYRightButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rotateYRight();
				cameraField.grabFocus();
			}
		});
		rotateYLeftButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rotateYLeft();
				cameraField.grabFocus();
			}
		});
		zoomInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zoomIn();
				cameraField.grabFocus();
			}
		});
		zoomOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zoomOut();
				cameraField.grabFocus();
			}
		});
		rotateZLeftButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rotateZLeft();
				cameraField.grabFocus();
			}
		});
		rotateZRightButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rotateZRight();
				cameraField.grabFocus();
			}
		});
		rotateXUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rotateXUp();
				cameraField.grabFocus();
			}
		});
		rotateXDownButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rotateXDown();
				cameraField.grabFocus();
			}
		});

		// ----------------KEYBOARD ACTION --------------------
		setKeyBinding("UP", new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				goForward();
			}
		});
		setKeyBinding("DOWN", new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				goBack();
			}
		});
		setKeyBinding("LEFT", new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				goLeft();
			}
		});
		setKeyBinding("RIGHT", new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				goRight();
			}
		});
		setKeyBinding("alt DOWN", new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				goDown();
			}
		});
		setKeyBinding("alt UP", new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				goUp();
			}
		});
		setKeyBinding("control LEFT", new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				rotateYRight();
			}
		});
		setKeyBinding("control RIGHT", new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				rotateYLeft();
			}
		});
		setKeyBinding("alt LEFT", new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				rotateZRight();
			}
		});
		setKeyBinding("alt RIGHT", new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				rotateZLeft();
			}
		});
		setKeyBinding("control UP", new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				rotateXDown();
			}
		});
		setKeyBinding("control DOWN", new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				rotateXUp();
			}
		});
		setKeyBinding("control RIGHT", new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				rotateYLeft();
			}
		});
		setKeyBinding("control RIGHT", new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				rotateYLeft();
			}
		});
		setKeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, 0), new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				zoomIn();
			}
		});
		setKeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, 0), new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				zoomOut();
			}
		});

		// setting the window
		add(cameraField);
		cameraField.repaint();
		add(buttonsPanel, BorderLayout.SOUTH);

		setTitle("Virtual Camera");
		setSize(Variables.width, Variables.height);
		setIconImage(camera);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	// ------------------ ACTIONS ---------------------
	private void goRight() {
		ArrayList<Cube> cubes = cameraField.getCubes();
		for (int i = 0; i < cubes.size(); i++)
			cubes.get(i).goLeft();
		cameraField.repaint();
	}

	private void goLeft() {
		ArrayList<Cube> cubes = cameraField.getCubes();
		for (int i = 0; i < cubes.size(); i++)
			cubes.get(i).goRight();
		cameraField.repaint();
	}

	private void goUp() {
		ArrayList<Cube> cubes = cameraField.getCubes();
		for (int i = 0; i < cubes.size(); i++)
			cubes.get(i).goDown();
		cameraField.repaint();
	}

	private void goDown() {
		ArrayList<Cube> cubes = cameraField.getCubes();
		for (int i = 0; i < cubes.size(); i++)
			cubes.get(i).goUp();
		cameraField.repaint();
	}

	private void goForward() {
		ArrayList<Cube> cubes = cameraField.getCubes();
		for (int i = 0; i < cubes.size(); i++)
			cubes.get(i).goBack();
		cameraField.repaint();
	}

	private void goBack() {
		ArrayList<Cube> cubes = cameraField.getCubes();
		for (int i = 0; i < cubes.size(); i++)
			cubes.get(i).goForward();
		cameraField.repaint();
	}

	private void rotateYRight() {
		ArrayList<Cube> cubes = cameraField.getCubes();
		for (int i = 0; i < cubes.size(); i++)
			cubes.get(i).rotYLeft();
		cameraField.repaint();
	}

	private void rotateYLeft() {
		ArrayList<Cube> cubes = cameraField.getCubes();
		for (int i = 0; i < cubes.size(); i++)
			cubes.get(i).rotYRight();
		cameraField.repaint();
	}

	private void rotateZLeft() {
		ArrayList<Cube> cubes = cameraField.getCubes();
		for (int i = 0; i < cubes.size(); i++)
			cubes.get(i).rotZRight();
		cameraField.repaint();
	}

	private void rotateZRight() {
		ArrayList<Cube> cubes = cameraField.getCubes();
		for (int i = 0; i < cubes.size(); i++)
			cubes.get(i).rotZLeft();
		cameraField.repaint();
	}

	private void rotateXUp() {
		ArrayList<Cube> cubes = cameraField.getCubes();
		for (int i = 0; i < cubes.size(); i++)
			cubes.get(i).rotXDown();
		cameraField.repaint();
	}

	private void rotateXDown() {
		ArrayList<Cube> cubes = cameraField.getCubes();
		for (int i = 0; i < cubes.size(); i++)
			cubes.get(i).rotXUp();
		cameraField.repaint();
	}

	private void zoomIn() {
		ArrayList<Cube> cubes = cameraField.getCubes();
		for (int i = 0; i < cubes.size(); i++)
			cubes.get(i).zoomMinus();
		cameraField.repaint();
	}

	private void zoomOut() {
		ArrayList<Cube> cubes = cameraField.getCubes();
		for (int i = 0; i < cubes.size(); i++)
			cubes.get(i).zoomPlus();
		cameraField.repaint();
	}

	private void setKeyBinding(String keyString, AbstractAction action) {
		cameraField.getInputMap().put(KeyStroke.getKeyStroke(keyString), keyString);
		cameraField.getActionMap().put(keyString, action);
	}

	private void setKeyBinding(KeyStroke keyStroke, AbstractAction action) {
		cameraField.getInputMap().put(keyStroke, (String) (keyStroke + ""));
		cameraField.getActionMap().put((String) (keyStroke + ""), action);
	}

}
