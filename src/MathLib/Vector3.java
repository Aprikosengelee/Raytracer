package MathLib;

import java.util.Objects;

public class Vector3 {

    private double VX;
    private double VY;
    private double VZ;

    /**
     * Will be used for upcoming operations with 3-term-vectors
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
     * addition of 2 3-term-vectors
     * @param v - vector which gets added
     * @return new vector from addition
     */
    public Vector3 add(Vector3 v){
        Vector3 vectorNew = new Vector3(this.VX + v.VX, this.VY + v.VY, this.VZ + v.VZ);
        return vectorNew;
    }

    /**
     * multiplication of 2 3-term-vectors
     * @param v - vector, which gets multiplicated
     * @return scalar from multiplication
     */
    public double scalar(Vector3 v){
        double vScalar = (this.VX * v.VX) + (this.VY * v.VY) + (this.VZ * v.VZ);
        return vScalar;
    }

    /**
     * scalar-multiplaction of a 3-term-vector and a scalar
     * @param s - vector which gets scalar multiplicated
     * @return vectorNew - new vector from SCALAR multiplication
     */
    public Vector3 mul(int s){
        Vector3 vectorNew = new Vector3(this.VX * s, this.VY * s, this.VZ * s);
        return vectorNew;
    }

    /**
     * gets the amount of a 3-term-vector
     * @return amount of the vector
     */
    public double amount(){
        double amount = Math.sqrt(Math.pow(this.VX,2) + Math.pow(this.VY,2) + Math.pow(this.VZ,2));
        return amount;
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
