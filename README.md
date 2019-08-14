
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
	        implementation 'com.github.jianlin00000:android-mail:1.0.1'
	}
```

------



#### 使用

```
 MailInfo mailInfo = new MailInfo();
 mailInfo.setMailServerHost("xxx");//发送方邮箱服务器
 mailInfo.setMailServerPort("xxx");//发送方邮箱端口号
 mailInfo.setValidate(true);
 mailInfo.setPassword("xxx");// 发送者邮箱授权码
 mailInfo.setFromAddress("xxx"); // 发送者邮箱
 mailInfo.setUserName("xxx"); // 发送者昵称
 mailInfo.setToAddress("xxx"); // 接收者邮箱
 mailInfo.setSubject("xxx"); // 邮件主题
 mailInfo.setContent("xxx"); // 邮件文本
 MailSender sms = new MailSender();
 
 //1.发送普通文本文件
 sms.sendTextMail(mailInfo);
 
 //2.发送带附件邮件
 File file = new File(filePath);
 sms.sendFileMail(mailInfo, file);
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

