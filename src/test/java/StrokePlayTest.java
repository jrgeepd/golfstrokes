import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StrokePlayTest {

    private ScoreCard scoreCard;
    private Course course;
    private StrokePlay strokePlay;
    private Player playerA;
    private Player playerB;

    @BeforeEach
    void setUp() {
        // Inicializar objetos necesarios
        scoreCard = new ScoreCard();
        course = new Course();
        strokePlay = new StrokePlay();

        // Crear jugadores
        playerA = new Player("PA", (byte)5);
        playerB = new Player("PB", (byte)10);

        // Añadir jugadores a la scoreCard
        scoreCard.setPlayerA(playerA);
        scoreCard.setPlayerB(playerB);

        // Crear recorridos de ejemplo (71 y 73 golpes)
        Byte[] coursePlayerA = {
            4, 4, 3, 4, 4, 4, 3, 4, 5,  // Out nine: 35
            4, 4, 3, 4, 4, 4, 4, 4, 5   // In nine: 36
        }; // Total: 71

        Byte[] coursePlayerB = {
            4, 4, 4, 4, 4, 4, 3, 4, 5,  // Out nine: 36
            4, 4, 4, 4, 4, 4, 4, 4, 5   // In nine: 37
        }; // Total: 73

        // Añadir recorridos al course
        course.addPlayerCourse(playerA, coursePlayerA);
        course.addPlayerCourse(playerB, coursePlayerB);

        // Establecer el course en la scoreCard
        scoreCard.setPlayersCourse(course);
    }

    @Test
    void testScoring() {
        // si jugamos stroke play
        strokePlay.scoring(scoreCard);
        assertEquals((short) 71, playerA.getScore());
        assertEquals((short) 73, playerB.getScore());
    }
}
