package DataStructures.Tree;

public class RedBlackTree {

    /**
     * Красный цвет
     */
    private static final boolean RED = false;

    /**
     * Черный цвет
     */
    private static final boolean BLACK = true;

    /**
     * Корень дерева
     */
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

    /**
     * Метод интерфейса для вставки узла в дерево
     *
     * @param id    номер узла, часть данных
     * @param value значение узла, часть данных
     */

    public void insert(int id, String value) {

        Node newNode = new Node(id, value);

        // Если дерево пустое, вставляем новый узел
        if (root == null)
            root = newNode;
        else {
            // Стандартный механизм поиска узла для присоединения
            Node current = root;
            Node parent = null;
            boolean leftChild = false;
            while (current != null) {
                parent = current;
                if (id < current.id) {
                    current = current.left;
                    leftChild = true;
                } else {
                    current = current.right;
                    leftChild = false;
                }
            }

            if (leftChild) {
                parent.left = newNode;
            } else {
                parent.right = newNode;
            }

            newNode.parent = parent;

            // Восстанавливаем сбалансированность дерева
            fixAfterInsertion(newNode);

        }
    }

    private void rotateLeft(Node /* поворачиваемый узел */ p) {

        // Правый потомок P
        Node right = p.right;

        // Правым потомком P становится левый потомок правого потомка P
        p.right = right.left;

        // Поскольку p.right = right.left, родитель right.left = p
        if (right.left != null)
            right.left.parent = p;


        // Right становится корнем поддерева, его новый родитель - старый родитель бывшего корня P
        right.parent = p.parent;

        // Если у поворачиваемого узла нет родителя, то корень - его правый потомок
        if (p.parent == null)
            root = right;

            // Если P - левый потомок своего родителя
        else if (p.parent.left == p)
            // Новый левый потомок родителя P - Right
            p.parent.left = right;
        else
            // Иначе новый правый потомок родителя P - Right
            p.parent.right = right;

        // Новый правый потомок Right - P
        right.left = p;

        // Из этого следует, что Right - родитель P
        p.parent = right;
    }

    private void rotateRight(Node /* поворачиваемый узел */ p) {

        // Левый потомок P
        Node left = p.left;

        // Левым потомком P становится правый потомок левого потомка P
        p.left = left.right;

        // Поскольку p.left = left.right, родитель left.right = p
        if (left.right != null)
            left.right.parent = p;

        // Left становится корнем поддерева, его новый родитель - старый родитель бывшего корня P
        left.parent = p.parent;

        // Если у поворачиваемого узла нет родителя, то корень - его левый потомок
        if (p.parent == null)
            root = left;

            // Если P - правый потомок своего родителя
        else if (p.parent.right == p)
            // Новый правый потомок родителя P -  Left
            p.parent.right = left;
        else
            // Иначе новый левый потомок родителя P - Left
            p.parent.left = left;

        // Новый правый потомок Left - P
        left.right = p;

        // Из этого следует, что Left - родитель P
        p.parent = left;

    }

    /**
     * Метод для восстановления красно-черных свойств после вставки
     *
     * @param x Текущий узел
     */

    private void fixAfterInsertion(Node x) {

        // Только что Текущий узел - красный. Перекрашиваем
        x.color = RED;

        // Пока не дошли до корня или цвет родительского узла - красный (т.е может быть конфликт RED-RED)
        while (x != null && x != root && x.parent.color == RED) {

            /*

            Рассматриваем два симметричных случая: родитель присоединяемого узла
            может быть левым либо правым потомком своего родителя

            */


            // Первый случай - родитель присоединяемого узла - левый потомок своего родителя

            if (parentOf(x) == leftOf(parentOf(parentOf(x)))) {

                // Дядя текущего узла. Поскольку родитель - левый потомок, дядя - правый потомок дедушки
                Node y = rightOf(parentOf(parentOf(x)));

                // Если дядя - красный, просто выполняем обмен цветов
                if (colorOf(y) == RED) {

                    // Родитель (брат дяди) - черный
                    setColor(parentOf(x), BLACK);

                    // Дядя - черный
                    setColor(y, BLACK);

                    // Дедушка - красный
                    setColor(parentOf(parentOf(x)), RED);

                    // Применяем эту же функцию к деду - его родитель может оказаться красным (конфликт RED - RED)
                    x = parentOf(parentOf(x));
                } else {

                    // Дядя - черный

                    // Если X - правый потомок, делаем левый поворот на родителе
                    if (x == rightOf(parentOf(x))) {
                        // Левый поворот на родителе
                        x = parentOf(x);
                        rotateLeft(x);

                        /*

                        Родитель и правый лист обменялись местами. Текущий узел
                        занял место родителя, родитель стал левым потомком текущего
                        узла. Уровень узла, на который  указывает x, не изменился -
                        до поворота он был первым из трех (новый узел - родитель - дядя),
                        теперь родитель - это x, а новый узел и родитель обменялись местами,
                        т.е родитель (х) встал на тот же первый уровень. Мы по-прежнему имеем
                        черного деда, черного правого дядю, красного левого сына деда и
                        красного левого внука деда (раньше он был родителем, после поворота
                        стал сыном своего бывшего сына).

                        */
                    }

                    // Выполняем обмен цветов. Х указывает на внука даже после поворота.

                    // Родитель X - был красным -> стал черным
                    setColor(parentOf(x), BLACK);

                    // Дедушка X - был черным -> стал красным
                    setColor(parentOf(parentOf(x)), RED);

                    /*

                    Осуществляем правый поворот по дедушке. Бывший дедушка сдвигается вправо и вниз,
                    его место занимает уже черный родитель.

                     */
                    rotateRight(parentOf(parentOf(x)));

                    /*

                    Родитель X был перекрашен в черный цвет. В результате
                    правого поворота родительская связь между P и X
                    не нарушилась (при правом повороте от P отсоединяется
                    только правый потомок). В результате поворота родитель
                    X остается черным, условие x.parent.color == RED - ложно,
                    цикл завершается.

                    */


                }
            } else {

                // Второй случай - родитель присоединяемого узла - правый потомок своего родителя

                // Дядя текущего узла. Поскольку родитель - правый потомок, дядя - левый потомок дедушки
                Node y = leftOf(parentOf(parentOf(x)));

                // Если дядя - красный, просто выполняем обмен цветов
                if (colorOf(y) == RED) {

                    // Родитель (брат дяди) - черный
                    setColor(parentOf(x), BLACK);

                    // Дядя - черный
                    setColor(y, BLACK);

                    // Дедушка - красный
                    setColor(parentOf(parentOf(x)), RED);

                    // Применяем эту же функцию к деду - его родитель может оказаться красным (конфликт RED - RED)
                    x = parentOf(parentOf(x));
                } else {

                    // Дядя - черный

                    // Если X - левый потомок, делаем правый поворот на родителе
                    if (x == leftOf(parentOf(x))) {
                        // Правый поворот на родителе
                        x = parentOf(x);
                        rotateRight(x);

                        /*

                        Родитель и левый лист обменялись местами. Текущий узел
                        занял место родителя, родитель стал правым потомком текущего
                        узла. Уровень узла, на который указывает x, не изменился -
                        до поворота он был первым из трех (новый узел - родитель - дядя),
                        теперь родитель - это x, а новый узел и родитель обменялись местами,
                        т.е родитель (х) встал на тот же первый уровень. Мы по-прежнему имеем
                        черного деда, черного левого дядю, красного правого сына деда и
                        красного правого внука деда (раньше он был родителем, после поворота
                        стал сыном своего бывшего сына).

                        */
                    }

                    // Выполняем обмен цветов. Х указывает на внука даже после поворота.


                    // Родитель X - был красным -> стал черным
                    setColor(parentOf(x), BLACK);

                    // Дедушка X - был черным -> стал красным
                    setColor(parentOf(parentOf(x)), RED);


                     /*

                    Осуществляем левый поворот по дедушке. Бывший дедушка сдвигается влево и вниз,
                    его место занимает уже черный родитель.

                     */

                    rotateLeft(parentOf(parentOf(x)));

                    /*

                    Родитель X был перекрашен в черный цвет. В результате
                    левого поворота родительская связь между P и X
                    не нарушилась (при левом повороте от P отсоединяется
                    только левый потомок). В результате поворота родитель
                    X остается черным, условие x.parent.color == RED - ложно,
                    цикл завершается.

                    */

                }
            }
        }

        // Корень - всегда черный, восстанавливаем цвет
        root.color = BLACK;
    }



    // Утилитные методы

    /**
     * Цвет узла. Если узел - null, по свойствам
     * красно-черного дерева он считается черным.
     *
     * @param p узел, для которого определяется цвет
     * @return цвет узла
     */

    private static boolean colorOf(Node p) {
        return (p == null ? BLACK : p.color);
    }

    /**
     * Родитель узла. Если передается корневой узел,
     * возвращается null
     *
     * @param p узел, для которого определяется родитель
     * @return родитель узла
     */

    private static Node parentOf(Node p) {
        return (p == null ? null : p.parent);
    }

    /**
     * Перекрашивает узел, если он существует
     *
     * @param p узел
     * @param c цвет
     */
    private static void setColor(Node p, boolean c) {
        if (p != null)
            p.color = c;
    }

    /**
     * Возвращает левого потомка узла, если он существует
     *
     * @param p узел
     * @return левый потомок узла
     */

    private static Node leftOf(Node p) {
        return (p == null) ? null : p.left;
    }

    /**
     * Возвращает правого потомка узла, если он существует
     *
     * @param p узел
     * @return правый потомок узла
     */

    private static Node rightOf(Node p) {
        return (p == null) ? null : p.right;
    }


    static class Node {

        Node(int id, String value) {
            this.id = id;
            this.value = value;
        }

        // Данные, хранящиеся в узле

        int id;
        String value;

        /**
         * Левый потомок
         */
        Node left;

        /**
         * Правый потомок
         */
        Node right;

        /**
         * Родитель
         */
        Node parent;

        /**
         * Цвет узла
         */

        boolean color = BLACK;

        public String getValue() {
            return value;
        }

        public int getId() {
            return id;
        }
    }



}
