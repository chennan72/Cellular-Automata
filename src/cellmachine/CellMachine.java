package cellmachine;

import cell.Cell;
import field.Field;
import field.View;

import javax.swing.*;

/** Main class for cell-machine. */
public class CellMachine {

  /**
   * Main method for running the GUI cell-machine.
   *
   * @param args N/A
   */
  public static void main(String[] args) {
    Field field = new Field(30, 30);
    for (int row = 0; row < field.getHeight(); row++) { // put cell in the cell-panel
      for (int col = 0; col < field.getWidth(); col++) {
        field.place(row, col, new Cell());
      }
    }
    for (int row = 0; row < field.getHeight(); row++) {
      for (int col = 0; col < field.getWidth(); col++) {
        Cell cell = field.get(row, col); // get the cell
        if (Math.random() < 0.2) { // the ratio of the reborn of the cell is 20%
          cell.reborn();
        }
      }
    }

    // ����
    View view = new View(field);
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // quit after clicking on "close"
    frame.setResizable(false); // user CANNOT rest the size
    frame.setTitle("Cells"); // window title
    frame.add(view); // add view to the frame
    frame.pack();
    frame.setVisible(true); // display

    for (int i = 0; i < 1000; i++) { // for-loop 1000 times
      for (int row = 0; row < field.getHeight(); row++) {
        for (int col = 0; col < field.getWidth(); col++) {
          Cell cell = field.get(row, col);
          Cell[] neighbour = field.getNeighbour(row, col); // get all neighbours
          int numOfLive = 0;
          for (Cell c : neighbour) { // compute the number of alive cells
            if (c.isAlive()) {
              numOfLive++;
            }
          }
          System.out.print("[" + row + "][" + col + "]:");
          System.out.print(cell.isAlive() ? "live" : "dead");
          System.out.print(":" + numOfLive + "-->");
          if (cell.isAlive()) { // make the cell "death"
            if (numOfLive < 2 || numOfLive > 3) {
              cell.die();
              System.out.print("die");
            }
          } else if (numOfLive == 3) {
            // cell regeneration
            cell.reborn();
            System.out.print("reborn");
          }
          System.out.println();
        }
      }
      System.out.println("UPDATE");
      frame.repaint(); // refresh
      try {
        Thread.sleep(100); // after refreshing, sleep 0.2s
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
