package csw.scala.other

/**
  * Created by doctorq on 2017/6/30.
  * http://blog.csdn.net/chinabhlt/article/details/47420391
  * 二叉树查找
  */
object BinaryTreeSearch extends App {
    //先序,根节点->左子树->右子树
    def perOrder(node: BinaryTreeNode): Unit = {

        println(node.value)

        if (node.left.isDefined) {
            //      println(s"根节点:${node.value},左子节点:${node.left.get.value}")
            perOrder(node.left.get)
        }

        if (node.right.isDefined) {
            //      println(s"根节点:${node.value},右子节点:${node.right.get.value}")
            perOrder(node.right.get)
        }

    }

    //中序,左子树->根节点->右子树
    def inOrder(node: BinaryTreeNode): Unit = {

        if (node.left.isDefined) {
            //      println(s"根节点:${node.value},左子节点:${node.left.get.value}")
            perOrder(node.left.get)
        }

        println(node.value)

        if (node.right.isDefined) {
            //      println(s"根节点:${node.value},右子节点:${node.right.get.value}")
            perOrder(node.right.get)
        }

    }

    //后序:左子树->右子树->根节点
    def postOrder(node: BinaryTreeNode): Unit = {
        if (node.left.isDefined) {
            //      println(s"根节点:${node.value},左子节点:${node.left.get.value}")
            perOrder(node.left.get)
        }


        if (node.right.isDefined) {
            //      println(s"根节点:${node.value},右子节点:${node.right.get.value}")
            perOrder(node.right.get)
        }

        println(node.value)

    }

    //层序:按深度遍历，从根节点所在的层开始
    def sequence(node: BinaryTreeNode): Unit = {

    }

    /**
      * 从二叉树中查找指定值的节点并返回
      * 递归的方式
      *
      * @param node  根节点
      * @param value 节点
      */
    def searchNode(node: BinaryTreeNode, value: Int): Option[BinaryTreeNode] = {

        if (value == node.value) return Some(node) else if (value < node.value && node.left.isDefined) {
            return searchNode(node.left.get, value)
        } else if (value > node.value && node.right.isDefined) {
            return searchNode(node.right.get, value)
        }
        None
    }

    var rootNode = new BinaryTreeNode(15)
    val list = List(1, 4, 5, 2, 3, 8, 54, 23, 21, 43, 10, 13).sorted

    list.foreach(item => {
        rootNode.buildTree(new BinaryTreeNode(item))
    })

    println("先序")

    perOrder(rootNode)

    println("中序")

    inOrder(rootNode)

    println("后序")

    postOrder(rootNode)

    val result1 = searchNode(rootNode, 1)

    result1 match {
        case None => println("未发现")
        case node => node.get.printNode()
    }

}

class BinaryTreeNode(val value: Int) {
    var left: Option[BinaryTreeNode] = None
    var right: Option[BinaryTreeNode] = None

    def buildTree(node: BinaryTreeNode): Unit = {
        if (node.value < value) {
            //左子树
            if (left.isEmpty) {
                left = Some(node)
            } else {
                left.get.buildTree(node)
            }
        } else {
            //右子树
            if (right.isEmpty) {
                right = Some(node)
            } else {
                right.get.buildTree(node)
            }
        }
    }

    def printNode(): Unit = {
        println(s"$value")
    }
}