package produto;

// <T extends Type> permite que T assuma qualquer tipo que seja subclasse de "Type"
public interface RepositorioProduto<T extends Produto> {

  public T procurar(int codigo);

  public boolean existe(int codigo);

  public void inserir(T produto);

  public void atualizar(T produto);

  public void remover(int codigo);
}
