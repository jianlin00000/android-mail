package mail.jack.mailtest;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.jack.emaillibrary.mail.MailInfo;
import com.jack.emaillibrary.mail.SendMailUtil;

import java.io.File;

import javax.mail.MessagingException;

public class MainActivity extends AppCompatActivity {

    private EditText sendAddEt, mailAuthCode,
            sendServer, sendPortNumber, toAddEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendAddEt = (EditText) findViewById(R.id.sendAddEt);
        mailAuthCode = (EditText) findViewById(R.id.mailAuthCode);
        sendServer = (EditText) findViewById(R.id.sendServer);
        sendPortNumber = (EditText) findViewById(R.id.sendPortNumber);
        toAddEt = (EditText) findViewById(R.id.toAddEt);

    }


    private MailInfo getMailInfo(String subject,String content){
        MailInfo mailInfo = new MailInfo();
        mailInfo.setMailServerHost(sendServer.getText().toString().trim());//发送方邮箱服务器
        mailInfo.setMailServerPort(sendPortNumber.getText().toString().trim());//发送方邮箱端口号
        mailInfo.setValidate(true);
        mailInfo.setUserName(sendAddEt.getText().toString().trim()); // 发送者邮箱地址
        mailInfo.setPassword(mailAuthCode.getText().toString().trim());// 发送者邮箱授权码
        mailInfo.setFromAddress(sendAddEt.getText().toString().trim()); // 发送者邮箱
        mailInfo.setToAddress(toAddEt.getText().toString()); // 接收者邮箱
        mailInfo.setSubject(subject); // 邮件主题
        mailInfo.setContent(content); // 邮件文本
        return mailInfo;
    }


    public void senTextMail(View view) {
        MailInfo mailInfo = getMailInfo("测试", "哈哈");
        try {
            SendMailUtil.send(mailInfo);
            Toast.makeText(MainActivity.this, "邮件已发送", Toast.LENGTH_SHORT).show();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void sendFileMail(View view) {
        String path = Environment.getExternalStorageDirectory() + File.separator + "test.ts";
        File file = new File(path);
        try {
            SendMailUtil.send(file, getMailInfo("测试", "文件测试"));
            Toast.makeText(MainActivity.this, "邮件已发送", Toast.LENGTH_SHORT).show();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
