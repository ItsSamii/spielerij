package nl.intractief.spielerij.dart;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DartScoreTest {

    @CsvSource({
            "1,SINGLE,1",
            "20,TRIPLE,60",
            "19,TRIPLE,57",
            "10,DOUBLE,20",
            "10,SINGLE,10"
    })
    @ParameterizedTest
    void berekenScore(int score, ScoreType type, int berekend) {
        DartScore dart = new DartScore(score,type);

        assertEquals(berekend,dart.berekenScore());
    }

    @Test
    void alleDartScoresMet1Pijl() {
        var scores = DartScore.allPossibleScoresWithOneDart();

        // FIXME: produce complete list; include doubles; triples and bullseye
        assertEquals(62,scores.size());

        assertEquals(1335,scores.stream().mapToInt(DartScore::berekenScore).sum());
    }

    @Test
    void alleDartScoresMet3Pijlen() {
        var scores = DartScore.allPossibleScoresWithOneDart();
        //FIXME: bereken alle mogelijke scores met 3 pijlen, misschien een DartTurn record of pojo?

        //FIXME: onbekend hoeveel
        assertEquals(1337,scores.size());
        assertEquals(13371337,scores.stream().mapToInt(DartScore::berekenScore).sum());
    }


    @ParameterizedTest
    @CsvSource({
            "5,10",
            "10,9",
            "96,1337"
    })
    void mogelijkeFinishesVanaf(int startScore,int mogelijkeFinishes) {
        //FIXME: hoeveel mogelijke finishes zijn er vanaf start score

        //FIXME: verzin (of filter) alle mogelijke scores vanaf start score

        List<DartScore> darts = List.of();//ntb
    }
}
