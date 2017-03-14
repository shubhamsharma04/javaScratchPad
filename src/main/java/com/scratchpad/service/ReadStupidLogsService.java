package com.scratchpad.service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

@Service
public class ReadStupidLogsService {

	public void getInconsisLogs() {
		File file = new File("/media/opensam/Acad/UB/Spring2017Courses/DS/PA2B/sys37");
		List<String> list = new ArrayList<String>();
		try {
			list = FileUtils.readLines(file, StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		int size = list.size();
		for (int i = 0; i < size - 5; i++) {
			String str = list.get(i);
			if (str.startsWith("Messages retrieved from emulator")) {
				int count = 0;
				Set<String> set = new HashSet<String>();
				
				for (int j = 0; j < 5; j++) {
					String str1 = list.get(i+j).split("(-){1}[0-9]{4}(: ){1}")[1];
					set.add(str1);
				}
				
				if(set.size()>2){
					for (int j = 0; j < 5; j++) {
						System.out.println(list.get(i+j));
					}
					System.out.println("###################");	
				}
				i=i+5;
			}
		}
	}

}
