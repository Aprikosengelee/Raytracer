package MathLib;

import java.util.Objects;

public class Mat3x3 {

    private double m11;
    private double m12;
    private double m13;

    private double m21;
    private double m22;
    private double m23;

    private double m31;
    private double m32;
    private double m33;

    /**
     * constructing the 3x3 matrix with giving each parameter walking top left hand corner, top right hand corner to bottom left hand corner, bottom right hand corner.
     * @param m11
     * @param m12
     * @param m13
     * @param m21
     * @param m22
     * @param m23
     * @param m31
     * @param m32
     * @param m33
     */
    public Mat3x3(double m11, double m12, double m13, double m21, double m22, double m23, double m31, double m32, double m33) {
        this.m11 = m11;
        this.m12 = m12;
        this.m13 = m13;
        this.m21 = m21;
        this.m22 = m22;
        this.m23 = m23;
        this.m31 = m31;
        this.m32 = m32;
        this.m33 = m33;
    }

    /**
     * constructing the 3x3 matrix with giving 3 vertical 3-term-vectors
     * @param v1
     * @param v2
     * @param v3
     */
    public Mat3x3 (Vector3 v1, Vector3 v2, Vector3 v3){
        this.m11 = v1.getVX();
        this.m12 = v2.getVX();
        this.m13 = v3.getVX();
        this.m21 = v1.getVY();
        this.m22 = v2.getVY();
        this.m23 = v3.getVY();
        this.m31 = v1.getVZ();
        this.m32 = v2.getVZ();
        this.m33 = v3.getVZ();
    }

    /**
     * addition of 2 3x3 matrix
     * @param m added matrix
     * @return new matrix from addition
     */
    public Mat3x3 add(Mat3x3 m){
        Mat3x3 matNew = new Mat3x3(
                this.m11 + m.m11, this.m12 + m.m12, this.m13 + m.m13,
                this.m21 + m.m21, this.m22 + m.m22, this.m23 + m.m23,
                this.m31 + m.m31, this.m32 + m.m32, this.m33 + m.m33);
        return matNew;
    }

    /**
     * normal multiplication of 2 3x3 matrix
     * @param m - matrix for multiplication
     * @return new 3x3 matrix from multiplication
     */
    public Mat3x3 mMul(Mat3x3 m){
        Mat3x3 matNew = new Mat3x3(
                (this.m11 * m.m11) + (this.m12 * m.m21) + (this.m13 * m.m31), (this.m11 * m.m12) + (this.m12 * m.m22) + (this.m13 * m.m32), (this.m11 * m.m13) + (this.m12 * m.m23) + (this.m13 * m.m33),
                (this.m21 * m.m11) + (this.m22 * m.m21) + (this.m23 * m.m31), (this.m21 * m.m12) + (this.m22 * m.m22) + (this.m23 * m.m32), (this.m21 * m.m13) + (this.m22 * m.m23) + (this.m13 * m.m33),
                (this.m31 * m.m11) + (this.m32 * m.m21) + (this.m33 * m.m31), (this.m31 * m.m12) + (this.m32 * m.m22) + (this.m33 * m.m32), (this.m31 * m.m13) + (this.m32 * m.m23) + (this.m33 * m.m33)
        );
        return matNew;
    }

    /**
     * multiplication between a 3x3 matrix and a 3-term-vector
     * @param v - vector for multiplciation
     * @return new vector from multiplication
     */
    public Vector3 vMul (Vector3 v){
        Vector3 vNew = new Vector3(
                (this.m11 * v.getVX()) + (this.m12 * v.getVY()) + (this.m13 * v.getVZ()),
                (this.m21 * v.getVX()) + (this.m22 * v.getVY()) + (this.m23 * v.getVZ()),
                (this.m31 * v.getVX()) + (this.m32 * v.getVY()) + (this.m33 * v.getVZ())
        );
        return vNew;
    }

    /**
     * calculating the determinant of a 3x3 Matrix
     * @return determinant
     */
    public double det (){
        double determinant = (this.m11 * this.m22 * this.m33) + (this.m12 * this.m23 * this.m31) + (this.m13 * this.m21 * this.m32) - (this.m31 * this.m22 * this.m13) - (this.m32 * this.m23 * this.m11) - (this.m33 * this.m21 * this.m12);
        return determinant;
    }
    public double getM11() {
        return m11;
    }

    public void setM11(double m11) {
        this.m11 = m11;
    }

    public double getM12() {
        return m12;
    }

    public void setM12(double m12) {
        this.m12 = m12;
    }

    public double getM13() {
        return m13;
    }

    public void setM13(double m13) {
        this.m13 = m13;
    }

    public double getM21() {
        return m21;
    }

    public void setM21(double m21) {
        this.m21 = m21;
    }

    public double getM22() {
        return m22;
    }

    public void setM22(double m22) {
        this.m22 = m22;
    }

    public double getM23() {
        return m23;
    }

    public void setM23(double m23) {
        this.m23 = m23;
    }

    public double getM31() {
        return m31;
    }

    public void setM31(double m31) {
        this.m31 = m31;
    }

    public double getM32() {
        return m32;
    }

    public void setM32(double m32) {
        this.m32 = m32;
    }

    public double getM33() {
        return m33;
    }

    public void setM33(double m33) {
        this.m33 = m33;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mat3x3 mat3x3 = (Mat3x3) o;
        return Double.compare(mat3x3.m11, m11) == 0 &&
                Double.compare(mat3x3.m12, m12) == 0 &&
                Double.compare(mat3x3.m13, m13) == 0 &&
                Double.compare(mat3x3.m21, m21) == 0 &&
                Double.compare(mat3x3.m22, m22) == 0 &&
                Double.compare(mat3x3.m23, m23) == 0 &&
                Double.compare(mat3x3.m31, m31) == 0 &&
                Double.compare(mat3x3.m32, m32) == 0 &&
                Double.compare(mat3x3.m33, m33) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(m11, m12, m13, m21, m22, m23, m31, m32, m33);
    }
}
