public class CircleCollider implements Collidable {
    private int centerX;
    private int centerY;
    private int radius;

    public CircleCollider(int centerX, int centerY, int radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Poluprečnik mora biti veći od nule.");
        }
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public int getRadius() {
        return radius;
    }

    private static int clamp(int value, int min, int max) {
        if (value < min) {
            return min;
        }
        if (value > max) {
            return max;
        }
        return value;
    }

    @Override
    public boolean intersects(Collidable other) {
        if (other instanceof CircleCollider) {
            CircleCollider c = (CircleCollider) other;
            int dx = this.centerX - c.centerX;
            int dy = this.centerY - c.centerY;
            int sumR = this.radius + c.radius;
            return dx * dx + dy * dy <= sumR * sumR;
        } else if (other instanceof RectangleCollider) {
            RectangleCollider r = (RectangleCollider) other;
            int closestX = clamp(centerX, r.getX(), r.getX() + r.getWidth());
            int closestY = clamp(centerY, r.getY(), r.getY() + r.getHeight());
            int dx = centerX - closestX;
            int dy = centerY - closestY;
            return dx * dx + dy * dy <= radius * radius;
        } else {
            throw new IllegalArgumentException("Nepodržan tip kolajdera.");
        }
    }

    @Override
    public String toString() {
        return "CircleCollider[cx=" + centerX + ", cy=" + centerY + ", r=" + radius + "]";
    }
}

