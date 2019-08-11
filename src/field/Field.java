package field;

import cell.Cell;

import java.util.ArrayList;

/** The class represents the field of the cell-machine as a 2D array of cell. */
public class Field {
  private int width;
  private int height;
  private Cell[][] field;

  /**
   * Constructor.
   *
   * @param width the width of the field
   * @param height the height of the field
   */
  public Field(int width, int height) {
    this.width = width;
    this.height = height;
    field = new Cell[height][width];
  }

  /**
   * Get the width of the field.
   *
   * @return
   */
  public int getWidth() {
    return width;
  }

  /**
   * Get the height of the field.
   *
   * @return
   */
  public int getHeight() {
    return height;
  }

  /**
   * Put the given cell into the given position.
   *
   * @param row the given x-coordinate
   * @param col the given y-coordinate
   * @param o the given cell
   * @return the previous cell exists in the given position
   */
  public Cell place(int row, int col, Cell o) { // 往对应行列号里放入细胞
    Cell ret = field[row][col];
    field[row][col] = o;
    return ret;
  }

  /**
   * Get the cell at the given position.
   *
   * @param row the given x-coordinate
   * @param col the given y-coordinate
   * @return the cell at the given position
   */
  public Cell get(int row, int col) {
    return field[row][col];
  }

  /**
   * Put all neighbours of the cell in the given position in the array of cell.
   *
   * @param row the given x-coordinate
   * @param col the given y-coordinate
   * @return all neighbours of the cell in the given position as an Array of cells
   */
  public Cell[] getNeighbour(int row, int col) {
    ArrayList<Cell> list = new ArrayList<Cell>();
    for (int i = -1; i < 2; i++) {
      for (int j = -1; j < 2; j++) {
        int r = row + i;
        int c = col + j;
        if (r > -1 && r < height && c > -1 && c < width && !(r == row && c == col)) {
          list.add(field[r][c]);
        }
      }
    }
    return list.toArray(new Cell[list.size()]);
  }

  /** Clean all cells. */
  public void clear() {
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        field[i][j] = null;
      }
    }
  }
}
