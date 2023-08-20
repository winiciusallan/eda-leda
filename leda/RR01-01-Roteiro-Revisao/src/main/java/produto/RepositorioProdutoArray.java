package produto;

public class RepositorioProdutoArray implements RepositorioProduto { 

  private Produto[] produtos;
  int index;

  public RepositorioProdutoArray(int tamanho) {
    index = -1;
    produtos = new Produto[tamanho];
  }   

  public int procurarPorIndice(int codigo) {
    for (int i = 0; i < produtos.length; i++) {
      if (produtos[i].getCodigo() == codigo) { return i; }
    }
    return -1;
  }

  public Produto procurar(int codigo) {
    int i = procurarPorIndice(codigo);
    return i != -1 ? produtos[i] : null;
  }

  public boolean existe(int codigo) {
    return procurar(codigo) != null;
  }

  public void inserir(Produto produto) {
    produtos[++index] = produto; 
  }

  public void remover(int codigo) {
    int i = procurarPorIndice(codigo);
    produtos[i] = produtos[index];
    produtos[index] = null;
    index--;
  }

  public void atualizar(Produto produto) {
    int i = procurarPorIndice(produto.getCodigo());
    produtos[i] = produto;
  }
}
