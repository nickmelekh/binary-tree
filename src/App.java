public class App {
    public static void main(String[] args) {
        double[] array = new double[] {6, 8, 5, 8, 2, 9, 7, 4, 10, 3, 1};
        Tree tree = new Tree(array.length);

        for (int i = 0; i < array.length; i++) {
            tree.insertNode(array[i]);
        }
        tree.printTree();
    }
}
