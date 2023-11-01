package problems;

import adt.bt.BTNode;

public class BTOperationsImpl<T> implements BTOperations<T> {

    
    public boolean isSymmetric(BTNode<T> bt){
        return isSymetric(bt.getLeft(), bt.getRight());
    }

    private boolean isSymetric(BTNode<T> current, BTNode<T> mirror) {
        boolean result = true;
        
        if (!(current.isEmpty() && mirror.isEmpty())) {
            result = current.equals(mirror) && 
        isSymetric(current.getLeft(), mirror.getRight()) &&
        isSymetric(current.getRight(), mirror.getLeft()); 
        }
        
        return result;
        }

    public boolean isSimilar(BTNode<T> node11, BTNode<T> node2){
        boolean result = true;

        if(!(node11.isEmpty() && node2.isEmpty())) {
            if ((!node11.isEmpty() && node2.isEmpty()) || node11.isEmpty() && !node2.isEmpty()) {
                result = false;
            } else {
                result = isSimilar(node11.getLeft(), node2.getLeft()) &&
                        isSimilar(node11.getRight(), node2.getRight());
            }
        }

        return result;
    }
}
