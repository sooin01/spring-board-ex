//package com.my.app.common.config;
//
//import javax.net.ssl.SSLContext;
//
//import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
//import org.apache.http.conn.ssl.TrustAllStrategy;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
//import org.apache.http.ssl.SSLContexts;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
//import org.springframework.web.client.RestTemplate;
//
//@Configuration
//public class RestConfig {
//
//	@Bean
//	public RestTemplate restTemplate() throws Exception {
//		RestTemplate restTemplate = new RestTemplate();
//		restTemplate.setRequestFactory(requestFactory());
//		return restTemplate;
//	}
//
//	@Bean
//	public CloseableHttpClient httpClient() throws Exception {
//		SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(new TrustAllStrategy()).build();
//		SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext);
//
//		return HttpClients.custom().setSSLSocketFactory(sslConnectionSocketFactory)
//				.setConnectionManager(connectionManager()).setMaxConnPerRoute(10).setMaxConnTotal(100).build();
//	}
//
//	@Bean
//	public HttpComponentsClientHttpRequestFactory requestFactory() throws Exception {
//		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
//		requestFactory.setHttpClient(httpClient());
//		return requestFactory;
//	}
//
//	@Bean
//	public PoolingHttpClientConnectionManager connectionManager() {
//		PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
//		connectionManager.setMaxTotal(100);
//		return connectionManager;
//	}
//
//}
