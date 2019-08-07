package DataStructures.Tree;

public class BinaryTree {

    private Node root;

    public Node find(int key) {

        Node current = root;

        // Пока ключ не найден либо текущее поддерево не пустое
        while (current != null && current.id != key) {
            // Если ключ меньше узла
            if (key < current.id) {
                // Узел может находиться только в левом поддереве, переходим к левому потомку
                current = current.left;
            } else {
                // Иначе узел может находиться только в правом дереве, переходим к правому потомку
                current = current.right;
            }
        }
        return current;
    }

    public void insert(int id, String data) {
        Node newNode = new Node(id, data);

        // Если дерево пустое, вставляем новый узел
        if (root == null)
            root = newNode;
        else {
            Node current = root;
            Node parent;
            while (current != null) {
                parent = current;
                if (id < current.id) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                    }
                }
            }
        }
    }


    /**
     * Максимальная высота дерева
     *
     * @return высоту дерева
     */

    public int height() {
        return height(this.root);
    }

    /**
     * Максимальная высота дерева
     *
     * @param root текущий узел
     * @return высоту двоичного дерева
     */

    private int height(Node root) {
        // Базовое ограничение
        return root == null ? 0 :
                // Максимальная из высот левого и правого поддерева (начиная с корня)
                Math.max(height(root.left),
                        height(root.right)) + 1;
        // Прибавляем 1 - текущий узел
    }


    public void traverseInOrder() {
        inOrder(root);
    }

    public void traversePreOrder() {
        preOrder(root);
    }

    public void traversePostOrder() {
        postOrder(root);
    }

    public Node min() {
        Node current, last;
        current = root;
        last = current;
        while (current != null) {
            last = current;
            current = current.left;
        }
        return last;
    }

    public Node max() {
        Node current, last;
        current = root;
        last = current;
        while (current != null) {
            last = current;
            current = current.right;
        }
        return last;
    }

    private void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.id);
            inOrder(root.right);
        }
    }

    private void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.value);
        }
    }

    private void preOrder(Node root) {
        if (root != null) {
            System.out.println(root.value);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public boolean delete(int key) {

        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        // Ищем удаляемый узел


        while (current.id != key) {
            parent = current;
            if (key < current.id) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }

            if (current == null) {
                return false;
            }


        }


        // Случай 1 - узел не имеет потомков

        if (current.left == null && current.right == null) {
            // Если удаляется корень, то дерево деформируется
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }

        // Случай 2 - узел имеет 1 потомка. Вырезаем узел, соединяя его потомков с родителями.

        // Случай 2.1 - узел не имеет правого потомка, т.е работаем с левым
        else if (current.right == null) {
            // Если текущий узел - корневой, то корневым становится его левое поддерево
            if (current == root)
                root = current.left;

                // Удаляем узел между потомком и родителем: скрепляем потомка с родителем

                // Если удаляемый узел - левый для своего родителя
            else if (isLeftChild)
                // Левый узел для родительского - потомок текущего
                parent.left = current.left;
            else
                // Если удаляемый узел - правый для своего родителя, теперь правый для родителя - левый потомок текущего
                parent.right = current.left;

            // Случай 2.2 - узел не имеет левого потомка, т.е работаем с правымь
        } else if (current.left == null) {

            // Если текущий узел - корневой, то корневым становится его правое поддерево
            if (current == root)
                root = current.right;

                // Если удаляемый узел - левый для своего родителя
            else if (isLeftChild)
                // Левый узел для родительского - теперь правый потомок текущего (т.к левого нет)
                parent.left = current.right;
            else
                // Если удаляемый узел - правый для своего родителя, теперь правый для родителя - правый потомок текущего
                parent.right = current.right;
        } else {

            // Случай 3: у удаляемого узла два потомка. Заменяем удаляемый узел его преемником.

            // Ищем преемника
            Node successor = getSuccessor(current);

            // Если удаляется корень, то он просто заменяется на преемника
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                //
                parent.left = successor;
            } else {
                parent.right = successor;
            }

            // Чтобы не потерять левого потомка удаляемого узла, перемещаем его в левого потомка преемника
            successor.left = current.left;
        }


        return true;
    }

    /**
     * Поиск преемника для заданного узла
     *
     * @param node узел, для которого нужно найти преемника
     * @return преемник узла
     */

    private Node getSuccessor(Node node) {
        Node successorParent = node; // Родитель преемника
        Node successor = node; // Преемник
        Node current = node.right; // Текущий узел для итерации, для начала - правый потомок удаляемого

        // Ищем преемника
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.left;
        }

        // Если преемник - не правый узел для удаляемого
        if (successor != node.right) {
            // У преемника может быть правый узел, его делаем левым для родителя преемника
            successorParent.left = successor.right;
            // Переносим правого потомка удаляемого узла на место правого потомка преемника.
            successor.right = node.right;
        }
        return successor;
    }

    static class Node {

        private int id;
        String value;
        Node left;
        Node right;

        Node(int id, String value) {
            this.id = id;
            this.value = value;
        }

        public int getId() {
            return id;
        }

        public String getValue() {
            return value;
        }
    }

}
