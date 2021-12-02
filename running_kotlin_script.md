### Running Kotlin Script 

- Android 12 부터 Intent filter 를 사용하는 Activity 에 대해서 AndroidManifest.xml 파일에 `<activity exported=true />` 와 같이 명시하게 되었음 
- 하지만 다른 디펜던시에서 에러 메시지가 나오면 어떤 태그에서 에러가 발생하는지 알 수 없음 
- StackOverflow 에서 누군가 만들어둔 스크립트를 참고하여 돌려보고자 함 
- Kotlin 에서 스크립트를 돌리려면 다음과 같다. 



```shell
# first of all, install kotlin compiler 
brew install kotlin 

# write a script 
vi sample_script.kts 

####

import java.io.File

// Get the passed in path, i.e. "-d some/path" or use the current path.
val path = if (args.contains("-d")) args[1 + args.indexOf("-d")]
           else "."

val folders = File(path).listFiles { file -> file.isDirectory() }
folders?.forEach { folder -> println(folder) }

####

# save the file and run 
kotlinc -script sample_script.kts -- -d <path to folder> 
```

> 위 샘플을 참고하여 온라인에서 찾은 스크립트를 돌려본다 



#### Source code for `mscript.kts` 

```kotlin
import org.w3c.dom.Document
import org.w3c.dom.NodeList
import java.io.File
import javax.xml.parsers.DocumentBuilderFactory

println("Starting script ... ")
val xlmFile: File = File(args[0])
val xmlDoc: Document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xlmFile)

fun processElements(elementType: String){
    val elements = xmlDoc.getElementsByTagName(elementType)
    for (i in 0 until elements.length) {
        val element = elements.item(i)
        val elementName = element.attributes.getNamedItem("android:name")
        val elementExported = element.attributes.getNamedItem("android:exported")
        val childs = element.childNodes
        if(childs.length>0){
            for (j in 0 until childs.length) {
                val childNode = childs.item(j)
                if(childNode.nodeName=="intent-filter")
                    println("${elementExported?.nodeValue?.let{"✓"}?:"X"} <$elementType> ${elementName.nodeValue}")
            }
        }

    }
}

println("Root Node:" + xmlDoc.documentElement.nodeName)
processElements("activity")
processElements("service")
processElements("receiver")
println("finished!")	
```



#### Result 

```shell
gahee.han@gaheehanui-iMac gopax-android % kotlinc -script mscript.kts /Users/gahee.han/gopax-android/app/src/main/AndroidManifest.xml
Starting script ... 
Root Node:manifest
✓ <activity> .ui.scene.splash.SplashActivity
✓ <activity> .ui.scene.splash.SplashActivity
✓ <activity> .ui.scene.splash.SplashActivity
✓ <activity> .ui.scene.splash.SplashActivity
✓ <activity> .ui.scene.splash.SplashActivity
✓ <activity> .ui.scene.splash.SplashActivity
✓ <activity> .ui.scene.signup.SignUpActivity
✓ <service> .utils.firebase.FcmMessagingService
finished!

```

