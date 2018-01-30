package cn.tedu.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;

import cn.tedu.po.TextMessage;
import net.sf.json.JSONObject;

public class MessageUtil {
	public static final String MESSAGE_TEXT = "text";
	public static final String MESSAGE_IMAGE = "image";
	public static final String MESSAGE_VOICE = "voice";
	public static final String MESSAGE_VIDEO = "video";
	public static final String MESSAGE_LINK = "link";
	public static final String MESSAGE_LOCATION = "location";
	public static final String MESSAGE_EVENT = "event";
	public static final String MESSAGE_SUBSCRIBE = "subscribe";
	public static final String MESSAGE_UNSUBSCRIBE = "unsubscribe";
	public static final String MESSAGE_CLICK = "CLICK";
	public static final String MESSAGE_VIEW = "VIEW";



	/**
	 * xml转为map集合
	 * @param request
	 * @return
	 * @throws DocumentException
	 * @throws IOException
	 */
	public static Map<String,String> xmlToMap(HttpServletRequest request) throws DocumentException, IOException {
		Map<String,String> map = new HashMap<String,String>();
SAXReader reader = new SAXReader();

		InputStream in = request.getInputStream();
		Document doc = reader.read(in);

		Element root = doc.getRootElement();
		List<Element> list = root.elements();

		for (Element e:list) {
			map.put(e.getName(), e.getText());
		}
		in.close();
		return map;
	}
	/**
	 * 将文本消息对象转换为XML
	 * @param textMessage
	 * @return
	 */
	public static String textMessageToXml(TextMessage textMessage) {
XStream xstream = new XStream();
		xstream.alias("xml",textMessage.getClass());
		return xstream.toXML(textMessage);
	}


	public static String initText(String toUserName,String fromUserName,String content) {
		TextMessage text = new TextMessage();
		text.setFromUserName(toUserName);
		text.setToUserName(fromUserName);
		text.setMsgType(MESSAGE_TEXT);
		text.setCreateTime(new Date().getTime());
		text.setContent(content);
		//System.out.println(message);
		return textMessageToXml(text);
	}
	/**
	 * 主菜单
	 * @return
*/
	public static String menuText() {
		StringBuffer sb = new StringBuffer();
		sb.append("感谢关注\n");
		sb.append("1.行路难\n");
		sb.append("2.将进酒\n\n");
		sb.append("回复？调出此菜单");
		return sb.toString();
	}

	public static String firstMenu() {
		StringBuffer sb = new StringBuffer();
		sb.append("\t\t行路难\n"
				+"\t\t\t\t李白\n"
				+"金樽清酒斗十千，\n玉盘珍羞直万钱。\n"
				+"停杯投箸不能食，\n拔剑四顾心茫然。\n"
				+"欲渡黄河冰塞川，\n将登太行雪满山。\n"
				+"闲来垂钓碧溪上，\n忽复乘舟梦日边。\n"
				+"行路难！行路难！\n多岐路，今安在？\n"
				+"长风破浪会有时，\n直挂云帆济沧海。");
		return sb.toString();
	}

	public static String secondMenu() {
		StringBuffer sb = new StringBuffer();		sb.append("\t\t将进酒\n"
				+"\t\t\t\t李白\n"
				+"君不见黄河之水天上来，\n奔流到海不复回。\n"
				+"君不见高堂明镜悲白发，\n朝如青丝暮成雪。\n"
				+"人生得意须尽欢，\n莫使金樽空对月。\n"
				+"天生我材必有用，\n千金散尽还复来。\n"
				+"烹羊宰牛且为乐，\n会须一饮三百杯。\n"
				+"岑夫子，丹邱生，\n将进酒，杯莫停。\n"
				+"与君歌一曲，\n请君为我倾耳听。\n"
				+"钟鼓馔玉不足贵，\n但愿长醉不愿醒。\n"
				+"古来圣贤皆寂寞，\n惟有饮者留其名。\n"
				+"陈王昔时宴平乐，\n斗酒十千恣欢谑。\n"
				+"主人何为言少钱，\n径须沽取对君酌。\n"
				+"五花马，千金裘。\n"
				+"呼儿将出换美酒，\n与尔同销万古愁。\n");
return sb.toString();
	}

	public static String turingMessage(String content) {
		
		
		
		URL url = null;
		HttpURLConnection connection = null;
		BufferedReader reader = null;
		StringBuffer message = null;
		
		//服务地址
		try {
			String key = "bdae886baa234e17bdba421783d178d";
			String info = URLEncoder.encode(content, "utf-8");
			String userid = "12013";
			url = new URL("http://www.tuling123.com/openapi/api?key=" + key + "&info=" + info +"&userid="+userid+";");
			
			connection = (HttpURLConnection)url.openConnection();
			connection.connect();
			/*connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			out = new OutputStreamWriter(connection.getOutputStream(),"utf-8");
			System.out.println(json);
			out.write("");
			out.flush();*/
			
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
			message = new StringBuffer();
			String line = "";
			while ((line = reader.readLine()) != null) {
				message.append(line);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
}finally{
			try {
				reader.close();
				//断开连接
				connection.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (message.toString() == null) {
			return "What Fuck??";
		}
		
		JSONObject json = JSONObject.fromObject(message.toString());
		return json.getString("text");
	}















}
