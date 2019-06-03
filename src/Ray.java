import MathLib.Vector3;

import java.util.Objects;

public class Ray {

    private Vector3 ORIGIN;
    private Vector3 DIRECTION;

    public Ray(Vector3 ORIGIN, Vector3 DIRECTION) {
        this.ORIGIN = ORIGIN;
        this.DIRECTION = DIRECTION;
    }

    /**
     * calculating the Ray for the distance t
     * @param t - distance
     * @return ray
     */
    public Vector3 getRay (double t){
        return new Vector3(ORIGIN.add(DIRECTION).mul(t));
    }

    /**
     * need to be overwritten in the methods.
     * @param t calculated variable and supposed on in which class it will be used. (I guess, not sure yet)
     * @return true or false, supposed on if there is a hit or not
     */
    public boolean hit (double t){
        return false;
    }

    public Vector3 getORIGIN() {
        return ORIGIN;
    }

    public void setORIGIN(Vector3 ORIGIN) {
        this.ORIGIN = ORIGIN;
    }

    public Vector3 getDIRECTION() {
        return DIRECTION;
    }

    public void setDIRECTION(Vector3 DIRECTION) {
        this.DIRECTION = DIRECTION;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ray ray = (Ray) o;
        return Objects.equals(ORIGIN, ray.ORIGIN) &&
                Objects.equals(DIRECTION, ray.DIRECTION);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ORIGIN, DIRECTION);
    }

    @Override
    public String toString() {
        return "Ray{" +
                "ORIGIN=" + ORIGIN +
                ", DIRECTION=" + DIRECTION +
                '}';
    }
}
