import java.util.HashMap;

class DetectSquares {

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + getEnclosingInstance().hashCode();
            result = prime * result + x;
            result = prime * result + y;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Point other = (Point) obj;
            if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
                return false;
            if (x != other.x)
                return false;
            if (y != other.y)
                return false;
            return true;
        }

        private DetectSquares getEnclosingInstance() {
            return DetectSquares.this;
        }

        @Override
        public String toString() {
            return "Point [x=" + x + ", y=" + y + "]";
        }

    }

    HashMap<Point, Integer> map;

    public DetectSquares() {
        map = new HashMap();
    }

    public void add(int[] point) {
        Point p = new Point(point[0], point[1]);
        int count = map.getOrDefault(p, 0) + 1;
        map.put(p, count);
    }

    public int count(int[] point) {
        int x = point[0];
        int y = point[1];
        int count = 0;
        for (int i = 0; i < x; i++) {
            if (map.containsKey(new Point(i, y)) &&
                    map.containsKey(new Point(x, y - i)) &&
                    map.containsKey(new Point(x - i, y - i))) {
                int max = Integer.MIN_VALUE;
                int left = map.get(new Point(i, y));
                int down = map.get(new Point(x, y - i));
                int diagonal = map.get(new Point(x - i, y - i));
                max = Math.max(left, down);
                max = Math.max(max, diagonal);
                count += max;
            }
        }

        return count;

    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */