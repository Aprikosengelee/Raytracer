package MathLib;

import java.util.Objects;

public class Vector3 {

    private double VX;
    private double VY;
    private double VZ;

    /**
     * constructing a vector with 3 given coordinates
     * @param VX - x coordinate
     * @param VY - y coordinate
     * @param VZ - z coordinate
     */
    public Vector3(double VX, double VY, double VZ) {
        this.VX = VX;
        this.VY = VY;
        this.VZ = VZ;
    }

    /**
     * constructing a vector with a given vector
     * @param v given vector
     */
    public Vector3 (Vector3 v){
        this.VX = v.VX;
        this.VY = v.VY;
        this.VZ = v.VZ;
    }

    /**
     * constructing an "empty" vector, where each coordinate is 0
     */
    public Vector3 (){
        this.VX = 0;
        this.VY = 0;
        this.VZ = 0;
    }

    /**
     * addition of 2 3-term-vectors
     * @param v - vector which gets added
     * @return new vector from addition
     */
    public Vector3 add(Vector3 v){
        return new Vector3(this.VX + v.VX, this.VY + v.VY, this.VZ + v.VZ);
    }

    /**
     * subtraction of 2 3-term-vectors
     * @param v - vector which gets subtracted
     * @return new vector from subtraction
     */
    public Vector3 sub(Vector3 v){
        return new Vector3(this.VX - v.VX, this.VY - v.VY, this.VZ - v.VZ);
    }

    /**
     * multiplication of 2 3-term-vectors
     * @param v - vector, which gets multiplicated
     * @return scalar from multiplication
     */
    public double mul(Vector3 v){
        return (this.VX * v.VX) + (this.VY * v.VY) + (this.VZ * v.VZ);
    }

    /**
     * scalar-multiplaction of a 3-term-vector and a scalar
     * @param s - vector which gets scalar multiplicated
     * @return vectorNew - new vector from SCALAR multiplication
     */
    public Vector3 mul(double s){
        return new Vector3(this.VX * s, this.VY * s, this.VZ * s);
    }

    /**
     * gets the amount of a 3-term-vector
     * @return amount of the vector
     */
    public double amount(){
        return Math.sqrt(Math.pow(this.VX,2) + Math.pow(this.VY,2) + Math.pow(this.VZ,2));
    }

    /**
     * normalizes the given vector
     * @return normalized vector
     */
    public Vector3 normalize() {
        if (this.amount() == 0){
            return new Vector3();
        } else {
            return new Vector3(this.mul(1/this.amount()));
        }
    }

    /**
     * cross multiplication of 2 3-term-vectors for example u and v.
     * @param v second given vector
     * @return new vector which stand with 90° on top of the other 2 vectors.
     */
    public Vector3 crossed(Vector3 v){
        return new Vector3(
                (this.VY * v.VZ) - (this.VZ * v.VY),
                (this.VZ * v.VX) - (this.VX * v.VZ),
                (this.VX * v.VY) - (this.VY * v.VX)
        );
    }

    public double getVX() {
        return VX;
    }

    public void setVX(double VX) {
        this.VX = VX;
    }

    public double getVY() {
        return VY;
    }

    public void setVY(double VY) {
        this.VY = VY;
    }

    public double getVZ() {
        return VZ;
    }

    public void setVZ(double VZ) {
        this.VZ = VZ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector3 vector3 = (Vector3) o;
        return Double.compare(vector3.VX, VX) == 0 &&
                Double.compare(vector3.VY, VY) == 0 &&
                Double.compare(vector3.VZ, VZ) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(VX, VY, VZ);
    }

    @Override
    public String toString() {
        return "Vector3{" +
                "VX=" + VX +
                ", VY=" + VY +
                ", VZ=" + VZ +
                '}';
    }
}
