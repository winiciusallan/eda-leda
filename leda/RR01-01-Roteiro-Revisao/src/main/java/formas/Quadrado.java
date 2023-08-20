package formas;

public class Quadrado implements Formas {

  private double lado;

  public Quadrado(double lado) {
    this.lado = lado;
  } 

  public double getLado() { return lado; }

  public double area() { return lado * lado; }
}
