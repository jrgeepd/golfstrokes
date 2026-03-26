package golfstroke;

public class Player {

    private final String initials;
    private Byte handicap;
    private short score;
    private short points;

    Player(String initials, Byte handicap) {
        this.initials = initials;
        this.handicap = handicap;
    }

    String getInitials() {
        return this.initials;
    }

    void setScore(int score) {
        this.score = (short) score;
    }

    Short getScore() {
        return this.score;
    }

    void setPoints(int points) {
        this.points = (short) points;
    }

    Short getPoints() {
        return this.points;
    }

    @Override
    public String toString() {
        return "\n" + this.initials + "\s--->"
                + "\sH'cap:\s" + this.handicap
                + "\tStrokes:\s" + this.getScore()
                + "\tStableford points:\s" + this.getPoints();
    }
}
