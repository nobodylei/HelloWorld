package cn.tedu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;

import cn.tedu.util.CheckUtil;
import cn.tedu.util.MessageUtil;

public class WeChatServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		
		PrintWriter out = response.getWriter();
		//验证消息来自服务器
		if(CheckUtil.checksignature(signature, timestamp, nonce)) {
			out.print(echostr);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
		response.setContentType("text/xml;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		try {
			Map<String,String> map = MessageUtil.xmlToMap(request);
			String toUserName = map.get("ToUserName");
			String fromUserName = map.get("FromUserName");
			String msgType = map.get("MsgType");
			String content = map.get("Content");
			
			System.out.println(map);
			
			String message = null;
			if (MessageUtil.MESSAGE_TEXT.equals(msgType)) {
				if ("1".equals(content)) {
message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.firstMenu());
				}else if ("2".equals(content)) {
					message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.secondMenu());
				}else if("?".equals(content) || "？".equals(content)) {
					message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.menuText());
				}else{
					message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.turingMessage(content));
				}
				
				System.out.println(message);
			} else if (MessageUtil.MESSAGE_EVENT.equals(msgType)) {
				String eventType = map.get("Event");
				if (MessageUtil.MESSAGE_SUBSCRIBE.equals(eventType)) {
					message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.menuText());
				}
			} else {
				message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.turingMessage(""));
			}
			
			out.print(message);
		} catch (DocumentException e) {
			e.printStackTrace();
		}finally{
			out.close();
      }
	};
}

