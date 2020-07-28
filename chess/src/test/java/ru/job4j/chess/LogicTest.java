package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class LogicTest {

    @Test
    public void whenMoveIsFree() throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        logic.add(bishopBlack);
        logic.move(Cell.C1, Cell.H6);
        System.out.println(bishopBlack.position());
    }

    @Test (expected = OccupiedCellException.class)
    public void whenMoveNotFree() throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new BishopBlack(Cell.E3));
        logic.move(Cell.C1, Cell.H6);
    }

    @Test (expected = ImpossibleMoveException.class)
    public void whenMoveNotDiagonal() throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.H7);
    }

    @Test (expected = FigureNotFoundException.class)
    public void whenFigureNotFound() throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.move(Cell.C1, Cell.H7);
    }
}