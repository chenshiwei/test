package csw.scala.other

object RegexTest {
  def findWords(content: String): List[String] =
    ("hello".r findAllIn content).toList

  def main(args: Array[String]) {
    val a1 = "hello, i am LEGOTIME ,my blog site is http://blog.csdn.net/legotime,hello everyone!!  ?"

    //---------------------------匹配单个字符串--------------------------------------------
    /**
      * 匹配单个字符
      *  findAllIn　　：全部匹配出来
      *  findFirstIn　　：　匹配第一个
      */
    val p1 = """hello""".r //"hello".r  ,也可以
    //val dateP1 = """(\d\d\d\d)-(\d\d)-(\d\d)""".r
    println(p1 findAllIn a1 toList) //List(hello, hello)
    println(p1 findFirstIn a1 toList) //List(hello)

    /**
      * 匹配任意字符串
      *   .   :英文中的句号，可以匹配任意一个单个的字符,可以使用n个 点  来匹配n个字符,同时可以出现在不同位置
      */

    val p2 = ".g.".r
    println(p2 findAllIn a1 toList) //List(og , og., ego)
    println(p2 findFirstIn a1 toList) //List(og )

    /**
      * 匹配特殊字符
      *   \   :转意字符  ，前面加這个 表示有特殊的含义
      */

    val p3 = """.g\.""".r
    println(p3 findAllIn a1 toList) //List(og.)

    val p4 = """/""".r
    println(p4 findAllIn a1 toList) //List(/, /, /)

    //---------------------------匹配一组字符串--------------------------------------------
    val a2 = "<div id=\"yui3-css-stamp\" style=\"position: absolute !important; visibility: hidden !important\" class=\"\"></div>" +
      "body, Div, dl, dt, dd, ul, ol, li, h1, h2, h3, h4, h5, h6, pre, code, form, fieldset, legend, input, textarea, p, blockquote, th, td"
    val p5 = """.i.""".r
    println(p5 findAllIn a2 toList) //List(div,  id, ui3, sit, !im, vis, bil, hid, !im, div, Div, li,, fie,  in)

    /**
      * 匹配多个字符串中的某一些
      *   []    : 把需要匹配的字符放到中括号里面,注意是区分大小写
      */
    val p6 = """[bd]i.""".r
    println(p6 findAllIn a2 toList) //List(div, bil, div)

    /**
      * 匹配一个范围中的某一些
      *   -   ： 连接符（-）左边是起始，右边是结束。特别注意 右边必须大于左边
      *
      *   [0-9]:匹配从0到9的数字    等价于  \d
      *   [a-z]:匹配从a到z的字符
      *   [A-Z]:匹配从A到Z的字符
      *   [A-z]:匹配从A到z的字符、符号等（内部还有其他一些出字母的符号）
      *   [0-9A-Za-z]:匹配数字和字符
      */
    val p7 = """.h[0-3]""".r
    println(p7 findAllIn a2 toList) //List( h1,  h2,  h3)

    /**
      * 用非（^）匹配一些不要的字符
      *   ^    :元字符  表示非
      */

    val p8 = """.h[^0-2]""".r
    println(p8 findAllIn a2 toList) //List( hi,  h3,  h4,  h5,  h6, th,)

    //---------------------------使用元字符简写--------------------------------------------

    /**
      * [0-9]:匹配从0到9的数字     等价于  \d
      * [^0-9]:匹配非从0到9的数字    等价于  \D
      * [a-zA-Z0-9_]:匹配数字、字符和下划线（_）        等价于   \w
      * [^a-zA-Z0-9_]:匹配非数字、字符和下划线（_）        等价于   \W (大写)
      *
      */
    val p9 = """.h\d""".r
    println(p9 findAllIn a2 toList) //List( h1,  h2,  h3,  h4,  h5,  h6)
    val p10 = """.h\D""".r
    println(p10 findAllIn a2 toList) //List( hi, th,)
    val p11 = """.h\w""".r
    println(p11 findAllIn a2 toList) //List( hi,  h1,  h2,  h3,  h4,  h5,  h6)
    val p12 = """.h\W""".r
    println(p12 findAllIn a2 toList) //List(th,)

    //---------------------------重复匹配--------------------------------------------
    /**
      * 有的时候，我们可以用  +   来进行最少一个的多次重复匹配,
      */
    val a3 = "p123,156p78,14w89ew10,pw156  ?+"

    val p13 = """\d""".r
    println(p13 findAllIn a3 toList) //List(1, 2, 3, 1, 5, 6, 7, 8, 1, 4, 8, 9, 1, 0, 1, 5, 6)
    //使用  +  来进行 多次重复匹配
    val p14 = """\d+""".r
    println(p14 findAllIn a3 toList) //List(123, 156, 78, 14, 89, 10, 156)
    val p15 = """\d+[a-z]""".r
    println(p15 findAllIn a3 toList) //List(156p, 14w, 89e)
    val p16 = """\d+[a-z]+""".r
    println(p16 findAllIn a3 toList) //List(156p, 14w, 89ew)

    /**
      *  有时候我们希望匹配到 0次的情况，那么 + 就达不到要求，
      *  我们可以使用   *    来进行匹配 0次或多次，就是 比 + 多一个  0 次的范围
      */
    val p17 = """\d*[a-z]+""".r
    println(p17 findAllIn a3 toList) //List(p, 156p, 14w, 89ew, pw)

    /**
      *  ？  ：匹配0个或1个
      */
    val p18 = """\d?[a-z]+""".r
    println(p18 findAllIn a3 toList) //List(p, 6p, 4w, 9ew, pw)

    /**
      * {n}  : 匹配指定个数 n
      */

    val p19 = """\d{2}[a-z]+""".r
    println(p19 findAllIn a3 toList) //List(56p, 14w, 89ew)

    /**
      * {m,n}  : 匹配指定的一个范围   m到n 个   包含 m,n
      */
    val p20 = """\d{0,1}[a-z]+""".r
    println(p20 findAllIn a3 toList) //List(p, 6p, 4w, 9ew, pw)

    //---------------------------位置匹配--------------------------------------------
    val a4 = "The cat scattered his food all over the room"

    val p21 = """cat""".r
    println(p21 findAllIn a4 toList) //List(cat, cat)

    /**
      *  \b  :用来匹配一个单词开始或者结束
      *  \B  :不匹配一个单词边界
      */

    val p22 = """\bcat\b""".r
    println(p22 findAllIn a4 toList) //List(cat)

    val p23 = """cat\b""".r
    println(p23 findAllIn a4 toList) //List(cat)
    val p24 = """\bcat""".r
    println(p24 findAllIn a4 toList) //List(cat)

    //---------------------------子表达式--------------------------------------------

    /**
      * ()  ：内部的内容就作为一个子式  常与  （）{n}一起使用
      */
    val a5 = "my Ip is 192.168.58.10"

    val p25 = """(\d{1,3}\.){3}\d{1,3}""".r
    println(p25 findAllIn a5 toList) //List(192.168.58.10)

    val a6 = """{"i":"d9258f5e-d481-a539-b86d-b905aa494b8e","m":[{"country":"-","time_type":"1min","app_version":"3.4.2","operation_type":"click","city":"-","isp":"-","browser_type":"-","error_count":1,"button_path":"","platform":"android","manufacturer":"OnePlus","button_selector":"[\"[1]android.widget.FrameLayout[0,63,1080,1920]\",\"[0]android.widget.LinearLayout[0,63,1080,1920]\",\"[1]android.widget.LinearLayout[0,181,1080,1920]\",\"[0]android.support.v4.app.NoSaveStateFrameLayout[0,181,1080,1589]\",\"[0]android.widget.RelativeLayout[0,181,1080,1589]\",\"[0]android.widget.ScrollView[0,181,1080,1589]\",\"[0]android.widget.LinearLayout[0,181,1080,1589]\",\"[0]android.widget.LinearLayout[0,181,1080,307]\",\"[0]android.widget.Button[26,181,137,307]\"]","display_type":"view","user_type":"0","province":"-","error_type":"ANR","model":"ONEPLUS A3000","browser_version":"-","app_id":"3tje6dAbODbuE0n6UfB3gyvlKXdHe8Tp","error_message":"ANR Input dispatching timed out (Waiting to send non-key event because the touched window has not finished processing certain input events that were delivered to it over 500.0ms ago.  Wait queue length: 10.  Wait queue head age: 5565.2ms.)","os_version":"-","button_target_path":"","error_stack":"","agent_type":"android","user_id":"00000000-29ed-3439-a465-37f800000000","os_type":"-","data_timestamp":1507528080000,"page_path":"","button_text":"anr","network_type":"wifi"}],"r":{"env_info_id":"37ad7579-6faa-d5c2-0427-310d765a10da","user_id":"00000000-29ed-3439-a465-37f800000000","operation_info_id":"3fd13513-850c-1a37-0bbd-e0ec647c349a","session_id":"59db0db12d0e0e206c4e9f26","app_id":"3tje6dAbODbuE0n6UfB3gyvlKXdHe8Tp"},"t":"error"}"""
    val p26 = """15\d{11}""".r

    println(p26 findAllIn a6 toList)
    def f = (json: String) => {
      var result = json
      """15\d{11}""".r.findAllIn(json).toArray.map(time => (time, (time.toLong + 100000).toString))
        .foreach(pair => result = result.replace(pair._1, pair._2))
      result
    }
print(f(a6))
  }
}