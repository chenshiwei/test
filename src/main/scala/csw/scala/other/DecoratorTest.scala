package csw.scala.other

/**
  * 抽象界面构件类
  * Created by ctao on 2015/8/16.
  */
trait Component {
    def display(): Unit
}

/**
  * 窗口具体构件类
  */
class Window extends Component {
    override def display(): Unit = println("显示窗口")
}

/**
  * 文本框具体构件类
  */
class TextBox extends Component {
    override def display(): Unit = println("显示文本框")
}

/**
  * 列表具体构件类
  */
class ListBox extends Component {
    override def display(): Unit = println("显示列表框")
}

/**
  * 构件装饰样例类
  *
  * @param component 抽象构件
  */
case class ComponentDecorator(component: Component) extends Component {
    /**
      * 复写display方法，调用抽象构建的方法
      */
    override def display(): Unit = component.display()
}

/**
  * 滚动条装饰类
  *
  * @param component 抽象构件
  */
class ScrollBarDecorator(component: Component) extends ComponentDecorator(component) {

    /**
      * 复写父类方法，在复写的方法中调用自己的独有方法
      */
    override def display(): Unit = {
        scrollBar()
        super.display()
    }

    /**
      * 自己独有方法
      */
    def scrollBar(): Unit = println("为构件增加滚动条")
}

/**
  * 黑色边框装饰类
  *
  * @param component 抽象构件
  */
class BlackBorderDecorator(component: Component) extends ComponentDecorator(component) {

    override def display(): Unit = {
        blackBorder()
        super.display()
    }

    def blackBorder(): Unit = println("为构件增加黑色边框")
}

/**
  * 测试客户端
  * Created by ctao on 2015/8/16.
  */
object DecoratorTest extends App {
    /**
      * 窗口
      */
    val component: Component = new Window
    /**
      * 滚动条来装饰窗口
      */
    val componentSB: Component = new ScrollBarDecorator(component)
    /**
      * 黑色边框装饰滚动条装饰类
      */
    val componentBB: Component = new BlackBorderDecorator(componentSB)
    componentBB.display()
}