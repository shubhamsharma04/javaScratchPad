package com.scratchpad.service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scratchpad.dataformat.NNStat;

@Service
public class ServiceImpl {

	public void sortStats() throws IOException {
		List<String> statsAsString = FileUtils.readLines(new File("statsfull.json"),
				StandardCharsets.UTF_8);
		List<NNStat> stats = new ArrayList<NNStat>();
		ObjectMapper mapper = new ObjectMapper();
		for (String stat : statsAsString) {
			NNStat nnStat = mapper.readValue(stat, NNStat.class);
			stats.add(nnStat);
		}
		Collections.sort(stats);
		for (NNStat stat : stats) {
			System.out.println(stat.getAsJson(stat));
		}
	}

}
