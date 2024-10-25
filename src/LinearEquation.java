public class LinearEquation {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double distance() {
        return roundToHundredth(Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2)));
    }

    public double slope() {
        return roundToHundredth((double) (y2-y1) / (x2-x1));
    }

    public String slopeFraction() {
        String slope = "";
        int gcf = 1;
        int dy = y2-y1;
        int dx = x2-x1;
        if (dy < 0 ^ dx < 0) {
            slope += "-";
        }
        dy = Math.abs(dy);
        dx = Math.abs(dx);

        if (dy % dx == 0) {
            if (dy != dx) {
                slope += dy / dx;
            }
        } else {
            for (int i = 1; i <= dx; i++) {
                if (dx % i == 0 && dy % i == 0) {
                    gcf = i;
                }
            }
            slope += (dy/gcf) + "/" + (dx/gcf);
        }
        return slope;
    }

    public double yIntercept() {
        return roundToHundredth(y1 - (slope() * x1));
    }

    public String equation() {
        String equation = "y = ";
        if (slope() == 0) {
            equation += yIntercept();
        } else {
            equation += slopeFraction() + "x";
            if (yIntercept() > 0) {
                equation += " + " + yIntercept();
            } else if (yIntercept() < 0) {
                equation += " - " + Math.abs(yIntercept());
            }
        }
        return equation;
    }

    public String coordinateForX(double x) {
        double y = roundToHundredth(slope() * x + yIntercept());
        return "(" + x + ", " + y + ")";
    }

    public String lineInfo() {
        String info = "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")";
        info += "\nThe equation of the line between these points is: " + equation();
        info += "\nThe y-intercept of this line is: " + yIntercept();
        info += "\nThe slope of this line is: " + slope();
        info += "\nThe distance between these points is: " + distance();
        return info;
    }

    private double roundToHundredth(double toRound) {
        return Math.round(toRound * 100) / 100.0;
    }
}
