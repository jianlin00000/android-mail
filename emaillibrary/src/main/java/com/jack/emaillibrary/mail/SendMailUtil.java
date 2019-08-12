package com.jack.emaillibrary.mail;

import java.io.File;

import javax.mail.MessagingException;

public class SendMailUtil {

    /**
     * 发送附件邮件
     * @param file
     * @param mailInfo
     * @return
     * @throws MessagingException
     */
    public static boolean send(final File file, MailInfo mailInfo) throws MessagingException {
        MailSender sms = new MailSender();
        return sms.sendFileMail(mailInfo, file);
    }

    /**
     * 注：耗时操作需在子线程执行
     * @param mailInfo
     * @throws MessagingException
     */
    public static boolean send(MailInfo mailInfo) throws MessagingException {

        MailSender sms = new MailSender();
        return sms.sendTextMail(mailInfo);
    }

}
