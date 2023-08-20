package formas;

public class Circulo implements Formas {

  public double raio;
  
  public Circulo(double raio) {
    this.raio = raio;
  }

  public double area() { return Math.PI * (raio * raio); }
}
