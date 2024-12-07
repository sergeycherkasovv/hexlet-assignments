package exercise;

// BEGIN
public class Segment {
    private Point beginPoint;
    private Point endPoint;

    Segment(Point begin, Point end) {
        this.beginPoint = begin;
        this.endPoint = end;
    }

    public Point getBeginPoint() {
        return beginPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public Point getMidPoint() {
        var midBegin = (beginPoint.getX() + endPoint.getX())  / 2;
        var midEnd = (beginPoint.getY() + endPoint.getY()) / 2;

        return new Point(midBegin, midEnd);
    }
}
// END
