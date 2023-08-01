package formas;

public class Triangulo implements Formas {
    
    private double base;
    private double altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double getBase() { return base; }

    public double getAltura() { return altura; }

    public double area() {
        return (base * altura) / 2;
    }
}
