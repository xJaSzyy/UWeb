//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val tree = BinaryTree()

    //вставка
    tree.insert(5)
    tree.insert(3)
    tree.insert(1)
    tree.insert(34)
    tree.insert(9)
    tree.insert(7)
    tree.insert(11)

    //обход
    tree.traversal()
    println()

    //удаление + повторный обход
    tree.delete(7)
    tree.traversal()
    println()

    //поиск
    println(tree.search(1)?.value) //элемент будет найден т.к. существует
    println(tree.search(99)) //элемент не будет найден
}