public class Bst {

    private Node root;

    public Bst() {}
    
    public Bst(Node root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void add(int v) {

        if (isEmpty()) { // Se estiver vazio ainda não temos um nó raiz, então adicionamos.
            this.root = new Node(v);
        } else {
            Node aux = this.root; // Ponteiro começa do nó raiz.

            while (aux != null) {

                if (v < aux.v) { // Se o valor do novo node for menor que o aux (deve ser inserido à esquerda).
                    if (aux.left == null) { // Se o nó à esquerda for null, deve ser inserido como uma folha.
                        Node newNode = new Node(v);
                        aux.left = newNode;
                        newNode.parent = aux;
                        return;
                    }

                    aux = aux.left; // Caso não seja null, vai caminhando pra esquerda e faz outras verificaçoes.
                } 

                if (v > aux.v) {
                    if (aux.right == null) {
                        Node newNode = new Node(v);
                        aux.right = newNode;
                        newNode.parent = aux;
                        return;
                    }

                    aux = aux.right;
                }
            }
        }
    }

    // O(h) onde h é a altura da árvore, já que o elemento terá que ser adicionado como folha.  
    public void recursiveAdd(int v) {
        if (isEmpty()) {
            this.root = new Node(v);
        } else {
            recursiveAdd(v, this.root);
        }
    }

    private void recursiveAdd(int v, Node current) {

        Node newNode = new Node(v);
        if (v < current.v) {
            if (current.left == null) {
                current.left = newNode;
                newNode.parent = current;
                return;
            }

            recursiveAdd(v, current.left);
        }

        if (v > current.v) {
            if (current.right == null) {
                current.right = newNode;
                newNode.parent = current;
                return;
            }

            recursiveAdd(v, current.right);
        }
    }

    // O(h) já que no seu pior caso terá que percorrer todos os ramos da árvore.
    public Node search(int v) {
        if (isEmpty()) return null;

        Node current = this.root;
        while (current != null) {
            if (current.v == v) return current;

            if (v < current.v) current = current.left;

            if (v > current.v) current = current.right;
        }

        return null;
    }

    
    public Node recursiveSearch(int v) {
        return recursiveSearch(v, this.root);
    }

    private Node recursiveSearch(int v, Node current) {

        if (current == null) {
            return null;
        }

        if (v == current.v) {
            return current;
        }

        if (v < current.v) {
            return recursiveSearch(v, current.left);
        } else {
            return recursiveSearch(v, current.right);
        }
    }

    public Node max() {
        Node current = this.root;

        while (current != null) {
            current = current.right;
        }

        return current;
    }

    public Node recursiveMax() {
        return recursiveMax(this.root);
    }

    public Node recursiveMax(Node current) {
        if (current == null) return null;

        if (current.right == null) return current;

        return recursiveMax(current.right);
    }

    public Node min() {
        if (isEmpty()) return null;

        Node current = this.root;

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    public Node recursiveMin() {
        return recursiveMin(this.root);
    }

    private Node recursiveMin(Node current) {
        if (current == null) return null;

        if (current.left == null) return current;

        return recursiveMin(current.left);
    }

    public int height() {
        return height(this.root);
    }

    private int height(Node current) {
        if (current == null) return -1;

        return 1 + Math.max(height(current.right), height(current.left));
    }

    public int somaFolha() {
        if (isEmpty()) return 0;

        return somaFolha(this.root);
    }

    private int somaFolha(Node node) {
        if (node.isLeaf()) return node.v;

        return somaFolha(node.left) + somaFolha(node.right);
    }

}

class Node {
    int v;
    Node left;
    Node right;
    Node parent;

    public Node(int v) {
        this.v = v;
        this.left = null;
        this.right = null;
    }

    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }
}
