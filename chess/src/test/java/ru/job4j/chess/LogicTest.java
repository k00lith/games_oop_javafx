package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class LogicTest {

    @Ignore
    @Test
    public void moveCorrect() throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.H6);
        assertThat(logic.findBy(Cell.H6), is(0));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenImpossible() throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.H4);
    }

    @Test(expected = OccupiedCellException.class)
    public void whenOccupied() throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        BishopBlack bb1 = new BishopBlack(Cell.G5);
        BishopBlack bb2 = new BishopBlack(Cell.C1);
        logic.add(bb1);
        logic.add(bb2);
        logic.move(Cell.C1, Cell.H6);
    }

    @Test(expected = FigureNotFoundException.class)
    public void whenFigureNotFound() throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.move(Cell.C1, Cell.H6);
    }
}
