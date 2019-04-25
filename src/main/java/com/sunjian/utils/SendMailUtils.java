package com.sunjian.utils;

import com.sunjian.config.Constants;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

/**
 * 发送邮件类
 * @author sunjian
 *
 */
public class SendMailUtils {

	private MimeMessage message;//一封邮件对象
	private Session session;//邮件会话对象
	private Transport transport;//火箭对象
	
	private Properties props = new Properties();
	
	public SendMailUtils(){
		//获取配置信息
		props.setProperty("mail.transport.protocol", Constants.senderProtocol);//设置发送使用的协议
		props.setProperty("mail.host", Constants.senderServerAddress);//设置发送服务器的地址
		props.setProperty("mail.smtp.auth", Constants.senderAuth);//请求身份验证
		props.setProperty("mail.smtp.port", "25");//发件服务器SSL端口
		
		this.session = Session.getDefaultInstance(props);
		this.session.setDebug(Constants.isDebug);//调试模式
		this.message = new MimeMessage(session);//代表一封邮件
	}
	
	/**
	 * 发送邮件方法
	 * @param subject 主题
	 * @param sendContent 正文
	 * @param toUser 收件人
	 * @param ccUser 抄送人
	 * @param bccUser 密送人
	 * @param attachmentPath 附件路径(如果多个放在一个文件夹下指定这个文件夹；如果一个指定这个文件)
	 */
	@SuppressWarnings("static-access")
	public void doSendEmail(String subject,String sendContent,String toUser,String ccUser,String bccUser,String attachmentPath){
		try{
			//发件人
			message.setFrom(new InternetAddress(Constants.senderFrom));
			
			//收件人（可以多个）
			if (null != toUser && !toUser.isEmpty()) {//如果收件人不为空并且不是0
				message.setRecipients(Message.RecipientType.TO, new InternetAddress().parse(toUser));
			}
			
			//抄送人（可以多个）
			if (null != ccUser && !ccUser.isEmpty()) {
				message.setRecipients(Message.RecipientType.CC, new InternetAddress().parse(ccUser));
			}
			
			//密送人（可以多个）
			if (null != bccUser && !bccUser.isEmpty()) {
				message.setRecipients(Message.RecipientType.BCC, new InternetAddress().parse(bccUser));
			}
			
			//发送日期
			message.setSentDate(new Date());
			
			//邮件主题
			message.setSubject(subject);
			
			/*向复杂型邮件中添加各个部分内容，包括文本和附件（组装）*/
			Multipart multipart = new MimeMultipart();
			
			//添加邮件正文
			BodyPart contentPart = new MimeBodyPart();//正文对象
			contentPart.setContent(sendContent,Constants.bodytype);
			multipart.addBodyPart(contentPart);
			
			//添加附件
			BodyPart attachmentBodyPart = null;//附件对象
			File fil = new File(attachmentPath);
			if (fil.exists()) {
				if (fil.isDirectory()) {
					if (fil.listFiles().length > 0) {
						File[] files = fil.listFiles();
						for(File file:files){
							attachmentBodyPart = new MimeBodyPart();
							
							DataSource source = new FileDataSource(file);//读取附件
							attachmentBodyPart.setDataHandler(new DataHandler(source));//将读取的附件添加到附件对象中
							attachmentBodyPart.setFileName(MimeUtility.encodeText(file.getName()));
						}
					}else {
						System.out.println("大哥，附件目录是空的啊！！！");
						return;
					}
				}else if (fil.isFile()) {
					if ((new FileInputStream(fil).available()) > 0) {//判断文件内容是否为空
						attachmentBodyPart = new MimeBodyPart();
						
						DataSource source = new FileDataSource(fil);//读取附件
						attachmentBodyPart.setDataHandler(new DataHandler(source));//将读取的附件添加到附件对象中
						attachmentBodyPart.setFileName(MimeUtility.encodeText(fil.getName()));
						
					}else {
						System.out.println("大哥，你整个空文件干哈啊！！！");
						return;
					}
				}
				multipart.addBodyPart(attachmentBodyPart);//添加附件到multipart对象中
			}else {
				System.out.println("大哥，附件目录不存在啊！！！");
				return;
			}
			//将multipart对象添加到邮件中
			message.setContent(multipart);
			//保存邮件
			message.saveChanges();
			
			//smtp验证
			transport = session.getTransport();//得到火箭
			transport.connect(Constants.senderUsername, Constants.senderPassword);//验证连接
			
			//发送邮件
			transport.sendMessage(message, message.getAllRecipients());
			//System.out.println("邮件发送完成了......");
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if (transport != null) {
				try {
					transport.close();
				} catch (MessagingException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void sendMails() {
		new SendMailUtils()
		.doSendEmail(Constants.subject,
				Constants.mainBody,
				Constants.recipientTo,
				Constants.recipientCC,
				Constants.recipientBCC,
				Constants.attachmentPath
		);
	}
	
	public static void main(String[] args) {
		SendMailUtils.sendMails();
	}
}

