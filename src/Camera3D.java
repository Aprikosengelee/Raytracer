import MathLib.Vector3;

import java.util.Objects;

public class Camera3D {

    //The eye is in the middle of the screen, so to get the left/right side we have to split our screen
    // into half and go with *(-1) for the left or just taking it how it is for the right side.
    private int left = -Rendering.WIDTH/2;
    private int right = Rendering.WIDTH/2;
    //Same goes for the top and bottom part.
    private int top = Rendering.HEIGHT/2;
    private int bottom = -Rendering.HEIGHT/2;

    //Vector 90° above us
    private Vector3 UP = new Vector3(0, 1, 0);
    //Exact position of camera's "eye". Negative position because we want to look at the base.
    private Vector3 EYE = new Vector3(0 , 0, -1);
    //The direction we are look at. in this case, to the coordination base
    private Vector3 Z = new Vector3();

    //normalized, "looking back" vector with the amount of 1
    private Vector3 W = EYE.sub(Z).normalize();
    //To get U, we need the 90° Vector between UP and W, and because of the fact, that we want it to be a direction, again, we normalize it.
    private Vector3 U = UP.crossed(W).normalize();
    //different to the UP-vector, this one is exactly ON our camera and goes UP into the sky in a 90° angle from W and U.
    private Vector3 V = W.crossed(U).normalize();

    //PI/4 = 90° and /2 because we have a symmetrical view.
    private double distance = top/Math.tan(Math.PI/4)/2;
    //Vector from W to d but reversed. (looking in the exact other direction)
    private Vector3 W_d_reversed= W.mul(distance * (-1));

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getBottom() {
        return bottom;
    }

    public void setBottom(int bottom) {
        this.bottom = bottom;
    }

    public Vector3 getUP() {
        return UP;
    }

    public void setUP(Vector3 UP) {
        this.UP = UP;
    }

    public Vector3 getEYE() {
        return EYE;
    }

    public void setEYE(Vector3 EYE) {
        this.EYE = EYE;
    }

    public Vector3 getZ() {
        return Z;
    }

    public void setZ(Vector3 z) {
        Z = z;
    }

    public Vector3 getW() {
        return W;
    }

    public void setW(Vector3 w) {
        W = w;
    }

    public Vector3 getU() {
        return U;
    }

    public void setU(Vector3 u) {
        U = u;
    }

    public Vector3 getV() {
        return V;
    }

    public void setV(Vector3 v) {
        V = v;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Vector3 getW_d_reversed() {
        return W_d_reversed;
    }

    public void setW_d_reversed(Vector3 w_d_reversed) {
        W_d_reversed = w_d_reversed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Camera3D camera3D = (Camera3D) o;
        return left == camera3D.left &&
                right == camera3D.right &&
                top == camera3D.top &&
                bottom == camera3D.bottom &&
                Double.compare(camera3D.distance, distance) == 0 &&
                Objects.equals(UP, camera3D.UP) &&
                Objects.equals(EYE, camera3D.EYE) &&
                Objects.equals(Z, camera3D.Z) &&
                Objects.equals(W, camera3D.W) &&
                Objects.equals(U, camera3D.U) &&
                Objects.equals(V, camera3D.V) &&
                Objects.equals(W_d_reversed, camera3D.W_d_reversed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right, top, bottom, UP, EYE, Z, W, U, V, distance, W_d_reversed);
    }

    @Override
    public String toString() {
        return "Camera3D{" +
                "left=" + left +
                ", right=" + right +
                ", top=" + top +
                ", bottom=" + bottom +
                ", UP=" + UP +
                ", EYE=" + EYE +
                ", Z=" + Z +
                ", W=" + W +
                ", U=" + U +
                ", V=" + V +
                ", distance=" + distance +
                ", W_d_reversed=" + W_d_reversed +
                '}';
    }
}
