package cell;

import java.awt.*;

/** This class represents the cell. */
public class Cell {
  private boolean alive = false; // if the cell is alive

  /** Set the cell death. */
  public void die() {
    alive = false;
  }

  /** Regenerate the cell. */
  public void reborn() {
    alive = true;
  }

  /**
   * Determine if the cell is alive.
   *
   * @return determine if the cell is alive or not as boolean
   */
  public boolean isAlive() {
    return alive;
  }

  /**
   * Draw the cell.
   *
   * @param g the given graphic
   * @param x x-coordinate
   * @param y y-coordinate
   * @param size length of the cell(rectangle)
   */
  public void draw(Graphics g, int x, int y, int size) {
    g.drawRect(x, y, size, size); // draw the cell(rect)
    if (alive) { // if the cell is alive, then fill the rectangle
      g.fillRect(x, y, size, size);
    }
  }
}
