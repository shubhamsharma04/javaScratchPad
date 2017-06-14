package com.scratchpad.service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import com.ibm.watson.developer_cloud.personality_insights.v3.PersonalityInsights;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.Trait;

@Service
public class Watson {
	
	public void doPersonality() throws IOException{
		PersonalityInsights service = new PersonalityInsights("2016-10-19");
		service.setUsernameAndPassword("", "");
		String text=null;
		try {
			text = FileUtils.readFileToString(new File(""), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}	
		com.ibm.watson.developer_cloud.personality_insights.v3.model.Profile profile = service.getProfile(text).execute();
		try {
			FileUtils.write(new File(""), profile.toString(), StandardCharsets.UTF_8, false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<String> headers = new ArrayList<String>();
		List<Double> values = new ArrayList<Double>();
		
		List<Trait> peronality =  profile.getPersonality();
		for(Trait t : peronality){
			headers.add(t.getName());
			values.add(t.getPercentile());
		}
		
		List<Trait> needs = profile.getNeeds();
		for(Trait t : needs){
			headers.add(t.getName());
			values.add(t.getPercentile());
		}
		
		List<Trait> vals = profile.getValues();
		for(Trait t : vals){
			headers.add(t.getName());
			values.add(t.getPercentile());
		}
		FileUtils.writeLines(new File(""),("utf-8"), headers, true);
		FileUtils.writeLines(new File(""),("utf-8"), values, true);
	}

}
