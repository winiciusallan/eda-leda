package produto;

public class RepositorioProdutoArray<T extends Produto> implements RepositorioProduto<T> { 

  private T[] produtos;
  int index;

  public RepositorioProdutoArray(int tamanho) {
    index = -1;
    produtos = (T[]) new Object[tamanho];
  }   

  public int procurarPorIndice(int codigo) {
    for (int i = 0; i < produtos.length; i++) {
      if (produtos[i].getCodigo() == codigo) { return i; }
    }
    return -1;
  }

  @Override
  public T procurar(int codigo) {
    int i = procurarPorIndice(codigo);
    return i != -1 ? produtos[i] : null;
  }

  @Override
  public boolean existe(int codigo) {
    return procurar(codigo) != null;
  }

  @Override
  public void inserir(T produto) {
    produtos[++index] = produto; 
  }

  @Override
  public void remover(int codigo) {
    int i = procurarPorIndice(codigo);
    produtos[i] = produtos[index];
    produtos[index] = null;
    index--;
  }

  @Override
  public void atualizar(T produto) {
    int i = procurarPorIndice(produto.getCodigo());
    produtos[i] = produto;
  }
}
