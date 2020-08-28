package csw.scala.test

import java.io.File
import org.apache.commons.io.FileUtils

object Test extends App {
    val basePath = "F:\\udap-core\\udap-portal\\"
    val mList = List(
        "udap-portal-ml-domain",
        "udap-portal-ml-mapper",
        "udap-portal-ml-service",
        "udap-portal-ml-service-interface",
        "udap-portal-ml-web")

    val copyTo = new File("F:\\tmp\\core\\")
    mList.foreach(m=>{
        val file = new File(s"$basePath$m\\target")
        file.listFiles().filter(_.isFile).foreach(f=>FileUtils.copyFile(f,  new File(s"F:\\tmp\\core\\${f.getName}")))
    })


//
}



