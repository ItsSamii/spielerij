package nl.intractief.spielerij.dart;

import static org.junit.jupiter.api.DynamicTest.stream;

import java.util.ArrayList;
import java.util.List;

record DartScore(int score, ScoreType type) {
    static final int BULLSEYE_POINTS = 25;
    static final List<DartScore> ALL = allPossibleScoresWithOneDart();
    static final List<DartScore> TOTAL = allPossibleScoresWithThreeDart();

    static List<DartScore> allPossibleScoresWithOneDart() {
        List<DartScore> result = new ArrayList<>();
        for(int i=1;i<=20;i++) {
            result.add(new DartScore(i, ScoreType.SINGLE));
            result.add(new DartScore(i, ScoreType.DOUBLE));
            result.add(new DartScore(i, ScoreType.TRIPLE));
        }

        result.add(new DartScore(BULLSEYE_POINTS, ScoreType.SINGLE));
        result.add(new DartScore(BULLSEYE_POINTS, ScoreType.DOUBLE));
        return result;
    }

    static List<DartScore> allPossibleScoresWithThreeDart() {
        var scores = DartScore.allPossibleScoresWithOneDart();
        List<DartScore> totalResult = new ArrayList<>();
        for(int i = 0; i < ALL.size(); i++) {
            for(int j = 0; j < ALL.size(); i++) {
                //FIXME: the sum of the values cant be calculated as the values arent of type int
                //var addedscore = scores.get(i) + scores.get(j);
                var stringScore = scores.get(i).toString();
                var intScore = Integer.parseInt(stringScore);
                totalResult.add(scores.get(i));
            }
        }
        return totalResult;
        
    }

    int berekenScore() {
        return score() * type().multiplier();
    }
}