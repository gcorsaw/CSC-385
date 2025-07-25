package maze;

import java.util.Stack;

/**
 * Notes:
 * 
 * The start and end position are contained within the maze object. Use the
 * getStart() and getEnd() methods.
 * 
 * @author Brian Rogers
 *
 */
public class MazeSolver {
	/**
	 * You need to implement this method
	 * 
	 * @param maze: The maze to be solved.
	 * @return An array of Position which stores a solution to the maze. If a
	 *         solution is not found a null value should be returned.
	 */
	public static Position[] solve(Maze maze) {
		// get start position
		Position startPosition = maze.getStart();
		Position finishPosition = maze.getEnd();
		// create a stack to push positions
		Stack<Position> stackPosition = new Stack<>();
		// push start position onto the stack
		maze.setAt(startPosition, 'V');
		stackPosition.push(startPosition);

		Position current = new Position(startPosition.getRow(), startPosition.getColumn());

		while (!current.equals(finishPosition)) {
			
			Position top = getTop(current);
			
			if (makeMove(maze, top)) {
				stackPosition.push(top);
				current = top;
				continue;
			}
			
			Position bottom = getBottom(current);

			if (makeMove(maze, bottom)) {
				stackPosition.push(bottom);
				current = bottom;
				continue;
			}

			Position left = getLeft(current);

			if (makeMove(maze, left)) {
				stackPosition.push(left);
				current = left;
				continue;
			}

			Position right = getRight(current);

			if (makeMove(maze, right)) {
				stackPosition.push(right);
				current = right;
				continue;
			}
			
			if (stackPosition.peek().equals(startPosition)) {
				break;
			}
			
			stackPosition.pop();
			current = stackPosition.peek();
		}
		
		if (current.equals(finishPosition)) {
			return stackPosition.toArray(new Position[stackPosition.size()]);
		} else {
			return new Position[0];
		}

	}

	private static Position getTop(Position current) {
		int currentRow = current.getRow();
		int currentColumn = current.getColumn();
		int newRow = currentRow - 1;
		int newColumn = currentColumn;
		Position newPosition = new Position(newRow, newColumn);
		return newPosition;

	}

	private static Position getBottom(Position current) {
		int currentRow = current.getRow();
		int currentColumn = current.getColumn();
		int newRow = currentRow + 1;
		int newColumn = currentColumn;
		Position newPosition = new Position(newRow, newColumn);
		return newPosition;
	}

	private static Position getLeft(Position current) {
		int currentRow = current.getRow();
		int currentColumn = current.getColumn();
		int newRow = currentRow;
		int newColumn = currentColumn - 1;
		Position newPosition = new Position(newRow, newColumn);
		return newPosition;
	}

	private static Position getRight(Position current) {
		int newRow = current.getRow();
		int newColumn = current.getColumn() + 1;
		return new Position(newRow, newColumn);
	}

	private static boolean makeMove(Maze maze, Position position) {
		if (maze.validPosition(position)) {
			char value = maze.getAt(position);
			if (value == 'V' || value == 'X') {
				return false;
			} else {
				maze.setAt(position, 'V');
				return true;
			}
		}
		return false;
	}
}