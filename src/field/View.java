package field;

import cell.Cell;

import javax.swing.*;
import java.awt.*;

/** This class represents the cell-machine view, which extends JPanel. */
public class View extends JPanel {
  private static final long serialVersionUID = -5258995676212660595L;
  private static final int GRID_SIZE = 16; // size of one grid
  private Field theField;

  /**
   * Constructor.
   *
   * @param field the given field
   */
  public View(Field field) {
    theField = field;
  }

  /**
   * The main method is only used to test the view, and it's not used in the CellMachine main class.
   *
   * @param args N/A
   */
  public static void main(String[] args) {
    Field field = new Field(10, 10);
    for (int row = 0; row < field.getHeight(); row++) {
      for (int col = 0; col < field.getWidth(); col++) {
        field.place(row, col, new Cell());
      }
    }
    //    View view = new View(field);
    //    JFrame frame = new JFrame();
    //    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //    frame.setResizable(false);
    //    frame.setTitle("Cells");
    //    frame.add(view);
    //    frame.pack();
    //    frame.setVisible(true);
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);
    for (int row = 0; row < theField.getHeight(); row++) {
      for (int col = 0; col < theField.getWidth(); col++) {
        Cell cell = theField.get(row, col);
        if (cell != null) {
          // if there exists a cell here(alive/death), then draw a grid in this position.
          cell.draw(g, col * GRID_SIZE, row * GRID_SIZE, GRID_SIZE);
        }
      }
    }
  }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension(theField.getWidth() * GRID_SIZE + 1, theField.getHeight() * GRID_SIZE + 1);
  }
}
