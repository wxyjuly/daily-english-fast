package io.renren;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.renren.common.utils.HttpClientHelper;

/**
 * reference
 * https://www.jianshu.com/p/5b516bbca657
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HttpClientTest {
	
    String transWebURL="https://downsub.com/?url=";
   
    String youtuebSrcURL = "https://www.youtube.com/watch?v=-m8DH51ushk";
    		
    @Test
    public void test(){
        String urlParam = transWebURL+youtuebSrcURL;
        System.err.println(urlParam);
        System.out.println(ToStringBuilder.reflectionToString(urlParam));

        Map<String, Object> params = new HashMap<>();
        String charset = "utf-8";

        String result = null;
        try {
//            log.debug(":::::"
//                    + "请求地址(App url):{},请求参数(params):{}", urlParam, params);
            result = HttpClientHelper.sendGet(urlParam, params, charset);
            System.out.println(result);
//            log.debug("::::"
//                    + "请求地址(App url):{},请求参数(params):{},返回报文(result):\n{}", urlParam, params, result);
        } catch (Exception e) {
//            log.error("请求解析异常：：：：App url:{}, params:{},result:{}-> 异常堆栈：{}",
//                    urlParam, params, result, e);
        	System.err.println(e);
        }
        
    }

    public static void main(String[] args) {
		new HttpClientTest().test();
	}
}
