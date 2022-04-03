public class App {
    public static void main(String[] args) {
        double[] array = new double[] {50.0, 85.0, 43.4, 84.1, 84.2, 21.3, 21.1, 1.0, 21.9, 87.0, 67.7};
        Tree tree = new Tree(array.length);

        for (int i = 0; i < array.length; i++) {
            tree.insertNode(array[i]);
        }
        tree.printTree();

        System.out.println(tree.getParentNode(tree.findByValue(1.0)).getValue());
    }
}
