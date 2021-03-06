package com.holiday.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.jfinal.core.Controller;

public class IndexController extends Controller{
	public void index(){
		
	}

	public void getData(){
		String httpUrl="http://www.easybots.cn/api/holiday.php?m=201801";
		BufferedReader reader = null;
		String result = null;
		StringBuffer sbf = new StringBuffer();
		try {
			URL url = new URL(httpUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			InputStream is = connection.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String strRead = null;
			while ((strRead = reader.readLine()) != null) {
				sbf.append(strRead);
				sbf.append("\n");
			}
			reader.close();
			result = sbf.toString();
			Map<String, Object> map = JSON.parseObject(result);
			System.out.println("结果集："+map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
