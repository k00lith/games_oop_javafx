package ru.job4j.chess.firuges.black;

import junit.framework.TestCase;
import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class BishopBlackTest {

    @Test
    public void testPosition() {
        BishopBlack bb = new BishopBlack(Cell.A1);
        bb.position();
        assertThat(bb.position(), is(Cell.A1));
    }

    @Test
    public void testCopy() {
        BishopBlack bb = new BishopBlack(Cell.A1);
        assertThat(bb.copy(Cell.D4).position(), is(Cell.D4));
    }

    @Test
    public void testWay() throws ImpossibleMoveException {
        BishopBlack bb = new BishopBlack(Cell.C1);
        Cell[] steps = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        //assertThat(steps, is(bb.way(Cell.G5)));
        assertThat((bb.way(Cell.G5)), is(steps));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenNotDiagonal() throws ImpossibleMoveException {
        BishopBlack bb = new BishopBlack(Cell.C1);
        bb.way(Cell.G6);
    }
}