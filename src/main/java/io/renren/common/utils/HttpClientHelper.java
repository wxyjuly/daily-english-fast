package io.renren.common.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;
import com.mchange.lang.StringUtils;

/**
 *
 * @project 自助终端
 * @package com.cnpc.cdz.order.util
 * @file HttpClientHelper.java 创建时间:2018年9月23日下午2:14:35
 * @title 标题（要求能简洁地表达出类的功能和职责）
 * @description 描述（简要描述类的职责、实现方式、使用注意事项等）
 * @copyright Copyright (c) 2018 中石油天然气股份有限公司规划总院
 * @company 中石油天然气股份有限公司规划总院
 * @module 模块: 发送http请求帮助类
 * @author   作者
 * @reviewer 审核人
 * @version 1.0
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 *
 */
public class HttpClientHelper {
	/**
	 * @name 使用CloseableHttpClient发送post请求，xml内容
	 * @description 相关说明
	 * @time 创建时间:2018年9月19日上午9:13:24
	 * @param url
	 *            地址
	 * @param xml
	 *            xml内容
	 * @return
	 * @author 作者
	 * @history 修订历史（历次修订内容、修订人、修订时间等）
	 */
	public static String sendPost2Xml(String url, String xml) {
		String responseBody = "";
		try {
			final CloseableHttpClient httpclient = HttpClients.createDefault();
			final RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(10000)
					.setConnectionRequestTimeout(10000).setSocketTimeout(10000).build(); // 设置超时
			System.out.println(xml);
			final HttpPost httpPost = new HttpPost(url);
			httpPost.addHeader("Content-Type", "text/xml;charset=UTF-8");
			final StringEntity stringEntity = new StringEntity(xml, "UTF-8");
			stringEntity.setContentEncoding("UTF-8");
			httpPost.setEntity(stringEntity);
			httpPost.setConfig(requestConfig);
			System.out.println("Executing request " + httpPost.getRequestLine());
			final CloseableHttpResponse response = httpclient.execute(httpPost);
			// 获取响应码
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == 200) {
				final InputStream is = response.getEntity().getContent();
				final BufferedReader reader = new BufferedReader(new InputStreamReader(is));
				final StringBuffer buffer = new StringBuffer();
				String temp;
				while ((temp = reader.readLine()) != null) {
					buffer.append(temp);
				}
				responseBody = URLDecoder.decode(buffer.toString(), "UTF-8");
				System.out.println("请求成功,请求返回内容为: " + responseBody);
			} else {
				responseBody = "{statusCode:" + statusCode + "}";
				// 输出
				System.out.println("请求失败,错误码为: " + statusCode);
			}
			// 关闭response和client
			response.close();
			httpclient.close();

		} catch (Exception e) {
			System.out.println(e);
			responseBody = "{message:\"" + e.getMessage() + "\"}";
		}
		return responseBody;
	}
	
	/**
	 *@name  调用webservices服务
	 *@description 相关说明
	 *@time    创建时间:2018年10月11日下午6:33:41
	 *@param url
	 *@param xml
	 *@param contentType
	 *@param soapAction
	 *@return
	 *@author   作者
	 *@history 修订历史（历次修订内容、修订人、修订时间等）
	 */
	public static String sendSoapPost(String url, String xml,
			String contentType, String soapAction) {
		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy-bj1.petrochina", 8080));
		String urlString = url;
		HttpURLConnection httpConn = null;
		OutputStream out = null;
		String returnXml = "";
		try {
			httpConn = (HttpURLConnection) new URL(urlString).openConnection();
			httpConn.setRequestProperty("Content-Type", contentType);
			if (null != soapAction) {
				httpConn.setRequestProperty("SOAPAction", soapAction);
			}
			httpConn.setRequestMethod("POST");
			httpConn.setDoOutput(true);
			httpConn.setConnectTimeout(5000);
			httpConn.setReadTimeout(5000);
			httpConn.setDoInput(true);
			httpConn.connect();
			out = httpConn.getOutputStream(); // 获取输出流对象
			httpConn.getOutputStream().write(xml.getBytes("UTF-8")); // 将要提交服务器的SOAP请求字符流写入输出流
			out.flush();
			out.close();
			int code = httpConn.getResponseCode(); // 用来获取服务器响应状态
			String tempString = null;
			StringBuffer sb1 = new StringBuffer();
			if (code == HttpURLConnection.HTTP_OK) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "UTF-8"));
				while ((tempString = reader.readLine()) != null) {
					sb1.append(tempString);
				}
				if (null != reader) {
					reader.close();
				}
			} else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(httpConn.getErrorStream(), "UTF-8"));
				// 一次读入一行，直到读入null为文件结束
				while ((tempString = reader.readLine()) != null) {
					sb1.append(tempString);
				}
				if (null != reader) {
					reader.close();
				}
			}
			// 响应报文
			returnXml = sb1.toString();
		} catch (Exception e) {
			e.printStackTrace();
			final String errorMsg = e.getMessage();
			returnXml= "{code :\"900\",message:{\"中转访问第三方url:"+url+" 出错："+errorMsg+"}}";
		}
		return returnXml;
	}
	
	/**
	 * @name 使用CloseableHttpClient发送post请求，xml内容获取entity
	 * @description 相关说明
	 * @time 创建时间:2018年9月19日上午9:13:24
	 * @param url
	 *            地址
	 * @param xml
	 *            xml内容
	 * @return
	 * @author 作者
	 * @history 修订历史（历次修订内容、修订人、修订时间等）
	 */
	public static HttpEntity getSendPost2Xml4Entity(String url, String xml) {
		HttpEntity entity = null;
		try {
			final CloseableHttpClient httpclient = HttpClients.createDefault();
			RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(3000)
					.setConnectionRequestTimeout(3000).setSocketTimeout(3000).build(); // 设置超时
			System.out.println(xml);
			final HttpPost httpPost = new HttpPost(url);
			httpPost.addHeader("Content-Type", "text/xml;charset=UTF-8");
			final StringEntity stringEntity = new StringEntity(xml, "UTF-8");
			stringEntity.setContentEncoding("UTF-8");
			httpPost.setEntity(stringEntity);
			httpPost.setConfig(requestConfig);
			System.out.println("Executing request " + httpPost.getRequestLine());
			final CloseableHttpResponse response = httpclient.execute(httpPost);
			// 获取响应码
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == 200) {
				// 获取数据
				entity = response.getEntity();
				// 输出
				System.out.println("请求成功,请求返回内容为: " + EntityUtils.toString(entity, "utf-8"));
			} else {

				// 输出
				System.out.println("请求失败,错误码为: " + statusCode);
			}
			// 关闭response和client
			response.close();
			httpclient.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return entity;
	}

	/**
	 * @name 使用CloseableHttpClient发送post请求，Form内容
	 * @description 调用第三方人脸进行初始化操作
	 * @time 创建时间:2018年9月19日上午10:27:23
	 * @throws Exception
	 * @author 作者
	 * @history 修订历史（历次修订内容、修订人、修订时间等）
	 */
	public static JSONObject sendPost2Form(String url, Map<String, Object> valueMap) throws Exception {
		// 实例化http客户端
		final HttpClient httpClient = new DefaultHttpClient();
		JSONObject retOb = null;
		// 实例化post提交方式
		final HttpPost post = new HttpPost(url);
		try {
			// 实例化参数对象
			final MultipartEntity params = new MultipartEntity();
			final File file = (File) valueMap.get("image");
			final String xml = (String) valueMap.get("xml");
			final String data= (String)valueMap.get("data");
			final String imageId = (String) valueMap.get("imageId");
			if (file != null) {
				// 文件参数内容
				final FileBody fileBody = new FileBody(file);
				// 添加文件参数
				params.addPart("image", fileBody);
			}
			if (xml != null && !"".equals(xml)) {
				params.addPart("xml", new StringBody(xml));
			}
			if (data != null && !"".equals(data)) {
				params.addPart("data", new StringBody(data));
			}
			if (imageId != null && !"".equals(imageId)) {
				params.addPart("imageId", new StringBody(imageId));
			}
			// 将参数加入post请求体中
			post.setEntity(params);
			// 执行post请求并得到返回对象 [ 到这一步我们的请求就开始了 ]
			final HttpResponse resp = httpClient.execute(post);

			// 解析返回请求结果
			final String returnStr = EntityUtils.toString(resp.getEntity(), "utf-8");
			System.out.println("请求成功,请求返回内容为: " + returnStr);
			retOb = JSONObject.parseObject(returnStr);
			// InputStream is = entity.getContent();
			// BufferedReader reader = new BufferedReader(new
			// InputStreamReader(is));
			// StringBuffer buffer = new StringBuffer();
			// String temp;
			// while ((temp = reader.readLine()) != null) {
			// buffer.append(temp);
			// }
			// System.out.println(buffer);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return retOb;
	}
	/**
	 *@name   使用CloseableHttpClient发送post请求，Form内容
	 *@description 调用第三方人脸进行初始化操作
	 *@time    创建时间:2018年9月19日上午10:27:23
	 *@throws Exception
	 *@author   作者
	 *@history 修订历史（历次修订内容、修订人、修订时间等）
	 */
	public static HttpEntity sendPost2Form22(String url, Map<String, Object> valueMap) throws Exception {
		// 创建一个httpclient对象
		CloseableHttpClient client = HttpClients.createDefault();
		File imageFile = (File) valueMap.get("image");
		String imageId = null;
		if (valueMap.get("imageId") != null) {
			imageId = (String) valueMap.get("imageId");
		}

		// 创建一个post对象
		HttpPost post = new HttpPost(url);
		
		MultipartEntity multipartEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE,
				"----------ThIs_Is_tHe_bouNdaRY_$", Charset.defaultCharset());
		if(imageId!=null){
			multipartEntity.addPart("imageId", new StringBody(imageId, Charset.forName("UTF-8")));
		}
		multipartEntity.addPart("image", new FileBody(imageFile, "image/png"));

		// 设置请求的内容
		post.setEntity(multipartEntity);

		// 设置请求的报文头部的编码
		post.setHeader(new BasicHeader("Content-Type",
				"multipart/form-data; boundary=----------ThIs_Is_tHe_bouNdaRY_$;charset=utf-8"));

		// 设置期望服务端返回的编码
		// post.setHeader(new BasicHeader("Accept",
		// "text/plain;charset=utf-8"));

		// 执行post请求
		CloseableHttpResponse response = client.execute(post);

		// 获取响应码
		int statusCode = response.getStatusLine().getStatusCode();
//		ResultRegister register = null;
		if (statusCode == 200) {

			// 获取数据
			String resStr = EntityUtils.toString(response.getEntity());
//			ObjectMapper mapper = new ObjectMapper();
//			register = mapper.readValue(response.getEntity().getContent(), ResultRegister.class);

			// 输出
			System.out.println("请求成功,请求返回内容为: " + resStr);
		} else {

			// 输出
			System.out.println("请求失败,错误码为: " + statusCode);
		}

		// 关闭response和client
		response.close();
		client.close();
		return response.getEntity();
	}

	/**
	 * @Description:使用HttpURLConnection发送post请求
	 * @author:liuyc
	 * @time:2016年5月17日 下午3:26:07
	 */
	public static String sendPost(String urlParam, Map<String, Object> params, String charset) {
		StringBuffer resultBuffer = null;
		// 构建请求参数
		StringBuffer sbParams = new StringBuffer();
		if (params != null && params.size() > 0) {
			for (Entry<String, Object> e : params.entrySet()) {
				sbParams.append(e.getKey());
				sbParams.append("=");
				sbParams.append(e.getValue());
				sbParams.append("&");
			}
		}
		HttpURLConnection con = null;
		OutputStreamWriter osw = null;
		BufferedReader br = null;
		// 发送请求
		try {
			URL url = new URL(urlParam);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setDoOutput(true);
			con.setDoInput(true);
			con.setUseCaches(false);
			con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			if (sbParams != null && sbParams.length() > 0) {
				osw = new OutputStreamWriter(con.getOutputStream(), charset);
				osw.write(sbParams.substring(0, sbParams.length() - 1));
				osw.flush();
			}
			// 读取返回内容
			resultBuffer = new StringBuffer();
			int contentLength = Integer.parseInt(con.getHeaderField("Content-Length"));
			if (contentLength > 0) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream(), charset));
				String temp;
				while ((temp = br.readLine()) != null) {
					resultBuffer.append(temp);
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (osw != null) {
				try {
					osw.close();
				} catch (IOException e) {
					osw = null;
					throw new RuntimeException(e);
				} finally {
					if (con != null) {
						con.disconnect();
						con = null;
					}
				}
			}
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					br = null;
					throw new RuntimeException(e);
				} finally {
					if (con != null) {
						con.disconnect();
						con = null;
					}
				}
			}
		}

		return resultBuffer.toString();
	}

	/**
	 * @Description:使用URLConnection发送post
	 * @author:liuyc
	 * @time:2016年5月17日 下午3:26:52
	 */
	public static String sendPost2(String urlParam, Map<String, Object> params, String charset) {
		StringBuffer resultBuffer = null;
		// 构建请求参数
		StringBuffer sbParams = new StringBuffer();
		if (params != null && params.size() > 0) {
			for (Entry<String, Object> e : params.entrySet()) {
				sbParams.append(e.getKey());
				sbParams.append("=");
				sbParams.append(e.getValue());
				sbParams.append("&");
			}
		}
		URLConnection con = null;
		OutputStreamWriter osw = null;
		BufferedReader br = null;
		try {
			URL realUrl = new URL(urlParam);
			// 打开和URL之间的连接
			con = realUrl.openConnection();
			// 设置通用的请求属性
			con.setRequestProperty("accept", "*/*");
			con.setRequestProperty("connection", "Keep-Alive");
			con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			con.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 发送POST请求必须设置如下两行
			con.setDoOutput(true);
			con.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			osw = new OutputStreamWriter(con.getOutputStream(), charset);
			if (sbParams != null && sbParams.length() > 0) {
				// 发送请求参数
				osw.write(sbParams.substring(0, sbParams.length() - 1));
				// flush输出流的缓冲
				osw.flush();
			}
			// 定义BufferedReader输入流来读取URL的响应
			resultBuffer = new StringBuffer();
			int contentLength = Integer.parseInt(con.getHeaderField("Content-Length"));
			if (contentLength > 0) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream(), charset));
				String temp;
				while ((temp = br.readLine()) != null) {
					resultBuffer.append(temp);
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (osw != null) {
				try {
					osw.close();
				} catch (IOException e) {
					osw = null;
					throw new RuntimeException(e);
				}
			}
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					br = null;
					throw new RuntimeException(e);
				}
			}
		}
		return resultBuffer.toString();
	}

	/**
	 * @Description:发送get请求保存下载文件
	 * @author:liuyc
	 * @time:2016年5月17日 下午3:27:29
	 */
	public static void sendGetAndSaveFile(String urlParam, Map<String, Object> params, String fileSavePath) {
		// 构建请求参数
		StringBuffer sbParams = new StringBuffer();
		if (params != null && params.size() > 0) {
			for (Entry<String, Object> entry : params.entrySet()) {
				sbParams.append(entry.getKey());
				sbParams.append("=");
				sbParams.append(entry.getValue());
				sbParams.append("&");
			}
		}
		HttpURLConnection con = null;
		BufferedReader br = null;
		FileOutputStream os = null;
		try {
			URL url = null;
			if (sbParams != null && sbParams.length() > 0) {
				url = new URL(urlParam + "?" + sbParams.substring(0, sbParams.length() - 1));
			} else {
				url = new URL(urlParam);
			}
			con = (HttpURLConnection) url.openConnection();
			con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			con.connect();
			InputStream is = con.getInputStream();
			os = new FileOutputStream(fileSavePath);
			byte buf[] = new byte[1024];
			int count = 0;
			while ((count = is.read(buf)) != -1) {
				os.write(buf, 0, count);
			}
			os.flush();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					os = null;
					throw new RuntimeException(e);
				} finally {
					if (con != null) {
						con.disconnect();
						con = null;
					}
				}
			}
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					br = null;
					throw new RuntimeException(e);
				} finally {
					if (con != null) {
						con.disconnect();
						con = null;
					}
				}
			}
		}
	}

	/**
	 * @Description:使用HttpURLConnection发送get请求
	 * @author:liuyc
	 * @throws UnsupportedEncodingException 
	 * @time:2016年5月17日 下午3:27:29
	 */
	public static String sendGet(String urlParam, Map<String, Object> params, String charset) throws UnsupportedEncodingException {
		StringBuffer resultBuffer = null;
		// 构建请求参数
		final StringBuffer sbParams = new StringBuffer();
		if (params != null && params.size() > 0) {
			for (Entry<String, Object> entry : params.entrySet()) {
				sbParams.append(entry.getKey());
				sbParams.append("=");
				final String encodeData = URLEncoder.encode(entry.getValue().toString(), "UTF-8");
				sbParams.append(encodeData);
				sbParams.append("&");
			}
		}
		HttpURLConnection con = null;
		BufferedReader br = null;
		try {
			URL url = null;
			if (sbParams != null && sbParams.length() > 0) {
				url = new URL(urlParam + "?" + sbParams.substring(0, sbParams.length() - 1));
			} else {
				url = new URL(urlParam);
			}
			con = (HttpURLConnection) url.openConnection();
			con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			con.connect();
			resultBuffer = new StringBuffer();
			br = new BufferedReader(new InputStreamReader(con.getInputStream(), charset));
			String temp;
			while ((temp = br.readLine()) != null) {
				resultBuffer.append(temp);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					br = null;
					throw new RuntimeException(e);
				} finally {
					if (con != null) {
						con.disconnect();
						con = null;
					}
				}
			}
		}
		return resultBuffer.toString();
	}

	/**
	 * @Description:使用URLConnection发送get请求
	 * @author:liuyc
	 * @time:2016年5月17日 下午3:27:58
	 */
	public static String sendGet2(String urlParam, Map<String, Object> params, String charset) {
		StringBuffer resultBuffer = null;
		// 构建请求参数
		StringBuffer sbParams = new StringBuffer();
		if (params != null && params.size() > 0) {
			for (Entry<String, Object> entry : params.entrySet()) {
				sbParams.append(entry.getKey());
				sbParams.append("=");
				sbParams.append(entry.getValue());
				sbParams.append("&");
			}
		}
		BufferedReader br = null;
		try {
			URL url = null;
			if (sbParams != null && sbParams.length() > 0) {
				url = new URL(urlParam + "?" + sbParams.substring(0, sbParams.length() - 1));
			} else {
				url = new URL(urlParam);
			}
			URLConnection con = url.openConnection();
			// 设置请求属性
			con.setRequestProperty("accept", "*/*");
			con.setRequestProperty("connection", "Keep-Alive");
			con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			con.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 建立连接
			con.connect();
			resultBuffer = new StringBuffer();
			br = new BufferedReader(new InputStreamReader(con.getInputStream(), charset));
			String temp;
			while ((temp = br.readLine()) != null) {
				resultBuffer.append(temp);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					br = null;
					throw new RuntimeException(e);
				}
			}
		}
		return resultBuffer.toString();
	}

	/**
	 * @Description:使用HttpClient发送post请求
	 * @author:liuyc
	 * @time:2016年5月17日 下午3:28:23
	 */
	public static String httpClientPost(String urlParam, Map<String, Object> params, String charset) {
		StringBuffer resultBuffer = null;
		HttpClient client = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(urlParam);
		// 构建请求参数
		List<NameValuePair> list = new ArrayList<NameValuePair>();
		Iterator<Entry<String, Object>> iterator = params.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, Object> elem = iterator.next();
			list.add(new BasicNameValuePair(elem.getKey(), String.valueOf(elem.getValue())));
		}
		BufferedReader br = null;
		try {
			if (list.size() > 0) {
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, charset);
				httpPost.setEntity(entity);
			}
			HttpResponse response = client.execute(httpPost);
			// 读取服务器响应数据
			resultBuffer = new StringBuffer();
			br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String temp;
			while ((temp = br.readLine()) != null) {
				resultBuffer.append(temp);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					br = null;
					throw new RuntimeException(e);
				}
			}
		}
		return resultBuffer.toString();
	}

	/**
	 * @Description:使用HttpClient发送get请求
	 * @author:liuyc
	 * @time:2016年5月17日 下午3:28:56
	 */
	public static String httpClientGet(String urlParam, Map<String, Object> params, String charset) {
		StringBuffer resultBuffer = null;
		HttpClient client = new DefaultHttpClient();
		BufferedReader br = null;
		// 构建请求参数
		StringBuffer sbParams = new StringBuffer();
		if (params != null && params.size() > 0) {
			for (Entry<String, Object> entry : params.entrySet()) {
				sbParams.append(entry.getKey());
				sbParams.append("=");
				try {
					sbParams.append(URLEncoder.encode(String.valueOf(entry.getValue()), charset));
				} catch (UnsupportedEncodingException e) {
					throw new RuntimeException(e);
				}
				sbParams.append("&");
			}
		}
		if (sbParams != null && sbParams.length() > 0) {
			urlParam = urlParam + "?" + sbParams.substring(0, sbParams.length() - 1);
		}
		HttpGet httpGet = new HttpGet(urlParam);
		try {
			HttpResponse response = client.execute(httpGet);
			// 读取服务器响应数据
			br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String temp;
			resultBuffer = new StringBuffer();
			while ((temp = br.readLine()) != null) {
				resultBuffer.append(temp);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					br = null;
					throw new RuntimeException(e);
				}
			}
		}
		return resultBuffer.toString();
	}

	/**
	 * @Description:使用socket发送post请求
	 * @author:liuyc
	 * @time:2016年5月18日 上午9:26:22
	 */
	public static String sendSocketPost(String urlParam, Map<String, Object> params, String charset) {
		String result = "";
		// 构建请求参数
		StringBuffer sbParams = new StringBuffer();
		if (params != null && params.size() > 0) {
			for (Entry<String, Object> entry : params.entrySet()) {
				sbParams.append(entry.getKey());
				sbParams.append("=");
				sbParams.append(entry.getValue());
				sbParams.append("&");
			}
		}
		Socket socket = null;
		OutputStreamWriter osw = null;
		InputStream is = null;
		try {
			URL url = new URL(urlParam);
			String host = url.getHost();
			int port = url.getPort();
			if (-1 == port) {
				port = 80;
			}
			String path = url.getPath();
			socket = new Socket(host, port);
			StringBuffer sb = new StringBuffer();
			sb.append("POST " + path + " HTTP/1.1\r\n");
			sb.append("Host: " + host + "\r\n");
			sb.append("Connection: Keep-Alive\r\n");
			sb.append("Content-Type: application/x-www-form-urlencoded; charset=utf-8 \r\n");
			sb.append("Content-Length: ").append(sb.toString().getBytes().length).append("\r\n");
			// 这里一个回车换行，表示消息头写完，不然服务器会继续等待
			sb.append("\r\n");
			if (sbParams != null && sbParams.length() > 0) {
				sb.append(sbParams.substring(0, sbParams.length() - 1));
			}
			osw = new OutputStreamWriter(socket.getOutputStream());
			osw.write(sb.toString());
			osw.flush();
			is = socket.getInputStream();
			String line = null;
			// 服务器响应体数据长度
			int contentLength = 0;
			// 读取http响应头部信息
			do {
				line = readLine(is, 0, charset);
				if (line.startsWith("Content-Length")) {
					// 拿到响应体内容长度
					contentLength = Integer.parseInt(line.split(":")[1].trim());
				}
				// 如果遇到了一个单独的回车换行，则表示请求头结束
			} while (!line.equals("\r\n"));
			// 读取出响应体数据（就是你要的数据）
			result = readLine(is, contentLength, charset);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (osw != null) {
				try {
					osw.close();
				} catch (IOException e) {
					osw = null;
					throw new RuntimeException(e);
				} finally {
					if (socket != null) {
						try {
							socket.close();
						} catch (IOException e) {
							socket = null;
							throw new RuntimeException(e);
						}
					}
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					is = null;
					throw new RuntimeException(e);
				} finally {
					if (socket != null) {
						try {
							socket.close();
						} catch (IOException e) {
							socket = null;
							throw new RuntimeException(e);
						}
					}
				}
			}
		}
		return result;
	}

	/**
	 * @Description:使用socket发送get请求
	 * @author:liuyc
	 * @time:2016年5月18日 上午9:27:18
	 */
	public static String sendSocketGet(String urlParam, Map<String, Object> params, String charset) {
		String result = "";
		// 构建请求参数
		StringBuffer sbParams = new StringBuffer();
		if (params != null && params.size() > 0) {
			for (Entry<String, Object> entry : params.entrySet()) {
				sbParams.append(entry.getKey());
				sbParams.append("=");
				sbParams.append(entry.getValue());
				sbParams.append("&");
			}
		}
		Socket socket = null;
		OutputStreamWriter osw = null;
		InputStream is = null;
		try {
			URL url = new URL(urlParam);
			String host = url.getHost();
			int port = url.getPort();
			if (-1 == port) {
				port = 80;
			}
			String path = url.getPath();
			socket = new Socket(host, port);
			StringBuffer sb = new StringBuffer();
			sb.append("GET " + path + " HTTP/1.1\r\n");
			sb.append("Host: " + host + "\r\n");
			sb.append("Connection: Keep-Alive\r\n");
			sb.append("Content-Type: application/x-www-form-urlencoded; charset=utf-8 \r\n");
			sb.append("Content-Length: ").append(sb.toString().getBytes().length).append("\r\n");
			// 这里一个回车换行，表示消息头写完，不然服务器会继续等待
			sb.append("\r\n");
			if (sbParams != null && sbParams.length() > 0) {
				sb.append(sbParams.substring(0, sbParams.length() - 1));
			}
			osw = new OutputStreamWriter(socket.getOutputStream());
			osw.write(sb.toString());
			osw.flush();
			is = socket.getInputStream();
			String line = null;
			// 服务器响应体数据长度
			int contentLength = 0;
			// 读取http响应头部信息
			do {
				line = readLine(is, 0, charset);
				if (line.startsWith("Content-Length")) {
					// 拿到响应体内容长度
					contentLength = Integer.parseInt(line.split(":")[1].trim());
				}
				// 如果遇到了一个单独的回车换行，则表示请求头结束
			} while (!line.equals("\r\n"));
			// 读取出响应体数据（就是你要的数据）
			result = readLine(is, contentLength, charset);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (osw != null) {
				try {
					osw.close();
				} catch (IOException e) {
					osw = null;
					throw new RuntimeException(e);
				} finally {
					if (socket != null) {
						try {
							socket.close();
						} catch (IOException e) {
							socket = null;
							throw new RuntimeException(e);
						}
					}
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					is = null;
					throw new RuntimeException(e);
				} finally {
					if (socket != null) {
						try {
							socket.close();
						} catch (IOException e) {
							socket = null;
							throw new RuntimeException(e);
						}
					}
				}
			}
		}
		return result;
	}

	/**
	 * @Description:读取一行数据，contentLe内容长度为0时，读取响应头信息，不为0时读正文
	 * @time:2016年5月17日 下午6:11:07
	 */
	private static String readLine(InputStream is, int contentLength, String charset) throws IOException {
		List<Byte> lineByte = new ArrayList<Byte>();
		byte tempByte;
		int cumsum = 0;
		if (contentLength != 0) {
			do {
				tempByte = (byte) is.read();
				lineByte.add(Byte.valueOf(tempByte));
				cumsum++;
			} while (cumsum < contentLength);// cumsum等于contentLength表示已读完
		} else {
			do {
				tempByte = (byte) is.read();
				lineByte.add(Byte.valueOf(tempByte));
			} while (tempByte != 10);// 换行符的ascii码值为10
		}

		byte[] resutlBytes = new byte[lineByte.size()];
		for (int i = 0; i < lineByte.size(); i++) {
			resutlBytes[i] = (lineByte.get(i)).byteValue();
		}
		return new String(resutlBytes, charset);
	}
	
	
	/***
	 * create @2019.04.04
	 * Https相关请求
	 * @return
	 */
	public static CloseableHttpClient getHttpClient() {
        try {
            SSLContextBuilder builder = new SSLContextBuilder();
            builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
            //不进行主机名验证
            SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(builder.build(),
                    NoopHostnameVerifier.INSTANCE);
            Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory> create()
                    .register("http", new PlainConnectionSocketFactory())
                    .register("https", sslConnectionSocketFactory)
                    .build();

            PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(registry);
            cm.setMaxTotal(100);
            CloseableHttpClient httpclient = HttpClients.custom()
                    .setSSLSocketFactory(sslConnectionSocketFactory)
                    .setDefaultCookieStore(new BasicCookieStore())
                    .setConnectionManager(cm).build();
            return httpclient;
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        return HttpClients.createDefault();
    }
	
	public static String get(String uri, Map<String, Object> params, Map<String, String> headers) throws IOException {
        HttpClient client = getHttpClient();
        return get(client, uri, params, headers);
    }

    public static String get(HttpClient client, String uri, Map<String, Object> params, Map<String, String> headers) throws IOException {
        String result = "";
        String fullUrl = buildUrlWithParams(uri, params);
        HttpGet httpGet = new HttpGet(fullUrl);

        if (headers != null) {
            for (Entry<String, String> entry : headers.entrySet()) {
                httpGet.addHeader(entry.getKey(), entry.getValue());
            }
        }
        HttpResponse httpResponse = client.execute(httpGet);
        InputStream input = httpResponse.getEntity().getContent();
        if (null != input) {
            try {
                result = IOUtils.toString(input, "UTF-8");
            } catch (IOException e) {
                throw e;
            } finally {
                IOUtils.closeQuietly(input);
            }
        }
        return result;
    }


    private static String buildUrlWithParams(String uri, Map<String, Object> params) throws UnsupportedEncodingException {
        StringBuilder urlBuilder = new StringBuilder(uri);
        if (null != params && !params.isEmpty()) {
            if (!uri.contains("?")) {
                urlBuilder.append("?");
            }
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                String valueStr = null == value ? "" : value.toString();
                if (!urlBuilder.toString().endsWith("?")) {
                    urlBuilder.append("&");
                }
                urlBuilder.append(key).append("=").append(URLEncoder.encode(valueStr, "utf-8"));
            }
        }
        String fullUrl = urlBuilder.toString();
        return fullUrl;
    }
    
    
    public static void main(String[] args) throws IOException {
    	
    	Map<String, Object> params = new HashMap<>();
            String url = "https://downsub.com/";
            
            String transWebURL="https://downsub.com/?url=";
            
            String youtuebSrcURL = "https://www.youtube.com/watch?v=-m8DH51ushk";
            params.put("url", youtuebSrcURL);
            
            String result = get(url, params, null);
            System.err.println(result);
	}
	

}
