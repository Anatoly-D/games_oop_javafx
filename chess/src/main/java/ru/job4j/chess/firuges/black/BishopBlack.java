package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static java.lang.Math.abs;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        if (!isDiagonal(source, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not move by diagonal from %s to %s", source, dest)
            );
        }
        int size = abs(dest.getY() - source.getY());
        Cell[] steps = new Cell[size];
        int deltaX = dest.getX() > source.getX() ? 1 : -1;
        int deltaY = dest.getY() > source.getY() ? 1 : -1;
        for (int index = 0; index < size; index++) {
            steps[index] = Cell.findBy(source.getX() + (index + 1) * deltaX, source.getY() + (index + 1) * deltaY);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return abs(dest.getX() - source.getX()) == abs(dest.getY() - source.getY()) ? true : false ;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
