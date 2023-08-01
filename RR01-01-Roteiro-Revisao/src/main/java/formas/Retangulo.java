package formas;

public class Retangulo implements Formas {

  private double base;
  private double altura;

  public Retangulo(double base, double altura) {
    this.base = base;
    this.altura = altura;
  }

  public double area() { return base * altura; }
}
