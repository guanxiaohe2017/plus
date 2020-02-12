package com.mybatis.plus.utils;
 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.LinkedList;
import java.util.Queue;
 
public class test {
	public static Queue<String> queue = new LinkedList<String>();
 
	/***
	 * 获取网页内容
	 * 
	 * @param url
	 *            网址
	 * @return 网页源码
	 */
	public String SendGet(String url) {
		// 定义一个字符串用来存储网页内容
		String result = "";
		// 定义一个缓冲字符输入流
		BufferedReader in = null;
		try {
			// 将string转成url对象
			URL realUrl = new URL(url);
			// 初始化一个链接到那个url的连接
			URLConnection connection = realUrl.openConnection();
			// 开始实际的连接
			connection.connect();
			// 初始化 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
 
			// 用来临时存储抓取到的每一行的数据
			String line = "";
			while ((line = in.readLine()) != null) {
				// 遍历抓取到的每一行并将其存储到result里面
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
 
	/***
	 * 用正则表达式的方法来提取下载页面1。
	 * 
	 * @param targetStr
	 *            待匹配的字符串
	 * @param patternStr
	 *            正则表达式
	 */
	public void RegexString(String targetStr, String patternStr) {
		// 定义一个样式模板，此中使用正则表达式，括号中是要抓的内容
		// 相当于埋好了陷阱匹配的地方就会掉下去
		Pattern pattern = Pattern.compile(patternStr);
		// 定义一个matcher用来做匹配
		Matcher matcher = pattern.matcher(targetStr);
		while (matcher.find()) {
			queue.offer("http://www.bzmfxz.com" + matcher.group(1) + ".html");
			// offer和put区别 参见http://www.cnblogs.com/end/archive/2012/10/25/2738493.html
		}
	}
 
	/***
	 * 通过中间页面查找到最终下载地址
	 * 
	 * @param targetStr
	 *            待匹配的字符串
	 * @param patternStr
	 *            正则表达式
	 * @return 返回值需要处理，并不完整
	 */
	public String getDownUrl(String targetStr, String patternStr) {
		// 定义一个样式模板，使用正则表达式，正则表达式括号中是要抓的内容
		Pattern pattern = Pattern.compile(patternStr);
		// 定义一个matcher用来做匹配
		Matcher matcher = pattern.matcher(targetStr);
		while (matcher.find()) {
			return matcher.group(1);
		}
		return null;
	}
 
	/***
	 * 根据网址下载网络文件到硬盘，来源记不清了。
	 * 
	 * @param path
	 *            文件保存路径
	 * @param url
	 *            文件下载地址
	 */
	public void download(String path, String url) {
		File file = null;
		FileOutputStream fos = null;
		String downloadName = url.substring(url.lastIndexOf("/") + 1);
		HttpURLConnection httpCon = null;
		URLConnection con = null;
		URL urlObj = null;
		InputStream in = null;
		byte[] size = new byte[1024];
		int num = 0;
		try {
			file = new File(path + downloadName);
			if (!file.exists()) {
				file.createNewFile();
 
				fos = new FileOutputStream(file);
				if (url.startsWith("http")) {
					urlObj = new URL(url);
					con = urlObj.openConnection();
					httpCon = (HttpURLConnection) con;
					in = httpCon.getInputStream();
					while ((num = in.read(size)) != -1) {
						for (int i = 0; i < num; i++)
							fos.write(size[i]);
					}
				}
			} else {
 
			}
		} catch (Exception e) {
			System.out.println(url);
		} catch (Throwable t) {
			System.out.println(url);
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// return;
			}
		}
	}
 
	public static void main(String[] args) {
		test t = new test();
		int index = 0;
		for (int i = 1; i <= 166; i++) {
			// 定义即将访问的链接
			String url = "http://www.bzmfxz.com/biaozhun/Soft/SJDZBZ/List_" + i + ".html";
			// 访问链接并获取页面内容
			String result = t.SendGet(url);
			int beginIndex = result.indexOf("<div class=\"childclasslist_box\">");
			int endIndex = result.indexOf("子栏目列表信息列表结束");
			result = result.substring(beginIndex, endIndex);// 删除没用的前后文
			t.RegexString(result, "<a href=\\\"(.*?).html");// ?表示尽可能少的匹配，即“懒惰匹配”，参见http://www.jb51.net/tools/zhengze.html
			
			while (!queue.isEmpty()) {
				String downMidUrl = queue.poll();
				String midContext = t.SendGet(downMidUrl);
				int beginIndexMid = midContext.indexOf("软件标题");
				int endIndexMid = midContext.indexOf("进入下载页面");
				midContext = midContext.substring(beginIndexMid, endIndexMid);// 删除没用的前后文
				String downUrl = t.getDownUrl(midContext, "window.open\\(\\'(.*?)\\'");
				// System.out.println(downUrl);//
				String downContext = t.SendGet("http://www.bzmfxz.com" + downUrl);
				String downfilePath = t.getDownUrl(downContext, "href=\"http(.*?)\"");
				// System.out.println("http:" + downfilePath);
				System.out.println(++index);
				t.download("C:\\Users\\fengj\\Desktop\\down\\", "http" + downfilePath);
			}
		}
	}
}