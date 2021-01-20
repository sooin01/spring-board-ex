package com.my.app.common.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.my.app.common.model.ObjectMixIn;
import com.my.app.common.model.ObjectPropertyFilter;
import com.my.app.common.model.UserInfo;

public class JsonUtil {

	public SimpleFilterProvider getFilterProvider() {
		SimpleFilterProvider filterProvider = new SimpleFilterProvider();
		return filterProvider.addFilter("objectMixIn", new ObjectPropertyFilter());
	}

	public String getString(Object value) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setFilterProvider(getFilterProvider());
		mapper.addMixIn(Object.class, ObjectMixIn.class);
		return mapper.writeValueAsString(value);
	}

	public static void main(String[] args) throws Exception {
		UserInfo userInfo = new UserInfo();
		userInfo.setId(UUID.randomUUID().toString());
		userInfo.setName("TEST");
		userInfo.setCreateDate(new Date());
		userInfo.setUpdateDate(new Date());

		Map<String, Object> result = new HashMap<>();
		result.put("result", userInfo);

		long start = System.currentTimeMillis();

		List<Thread> threadList = new ArrayList<>();
		final JsonUtil jsonUtil = new JsonUtil();
		final List<String> exceptionList = new ArrayList<>();

		for (int i = 0; i < 100; i++) {
			final int index = i;

			Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						String s = jsonUtil.getString(result);
						// System.out.println(s);
					} catch (Exception e) {
						// System.out.println(index + ": " + e.toString());
						exceptionList.add(index + ": " + e.toString());
					}
				}
			});

			threadList.add(t);
			t.start();
		}

		for (Thread t : threadList) {
			t.join();
		}

		for (String s : exceptionList) {
			System.out.println(s);
		}

		long end = System.currentTimeMillis();

		System.out.println(end - start);
	}

}
