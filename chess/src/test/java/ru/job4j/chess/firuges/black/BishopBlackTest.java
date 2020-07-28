package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void whenPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        assertThat(bishopBlack.position(), is(Cell.F8));
    }

    @Test
    public void whenCopy() {
        Figure bishopBlack = new BishopBlack(Cell.F8);
        assertThat(bishopBlack.copy(Cell.F8).position(), is(Cell.F8));
    }

    @Test
    public void whenWay() throws ImpossibleMoveException {
        Cell[] expectedWay = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};

        Figure bishop = new BishopBlack(Cell.C1);
        Cell[] actualWay = bishop.way(Cell.C1, Cell.G5);
        assertThat(actualWay, is(expectedWay));
    }
}