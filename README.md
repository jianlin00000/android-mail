# MailTest
Android开发-在Android应用里实现自动发送邮件的功能

___

#### 依赖

项目下的build.gradle下添加：

```css
allprojects {
		repositories {
			maven { url 'https://jitpack.io' }
		}
	}
```

app下的build.gradle添加：

```css
	dependencies {
	        implementation 'com.github.jianlin00000:MailTest-master:Tag'
	}
```



___



#### #混淆

```
-keep class javax.mail.**{*;}
-keep class javax.mail.internet.{*;}
-keep class com.sun.activation.registries.{****;}
-keep class javax.activation.**{*;}
-keep class myjava.awt.datatransfer.**{*;}
-keep class org.apache.harmony.**{*;}
-keep class com.sun.mail.**{*;}
```

