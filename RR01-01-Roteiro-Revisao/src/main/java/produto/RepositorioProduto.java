package produto;

public interface RepositorioProduto {

  public int procurarPorIndice(int codigo);

  public Produto procurar(int codigo);

  public boolean existe(int codigo);

  public void inserir(Produto produto);

  public void atualizar(Produto produto);

  public void remover(int codigo);
}
