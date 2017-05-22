package com.scratchpad.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.io.FileUtils;
import org.apache.commons.math3.util.Combinations;
import org.paukov.combinatorics.Factory;
import org.paukov.combinatorics.Generator;
import org.paukov.combinatorics.ICombinatoricsVector;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scratchpad.dataformat.Hashtag;
import com.scratchpad.dataformat.MsgVO;
import com.scratchpad.dataformat.NNStat;
import com.scratchpad.dataformat.WatsonTraits;
import com.scratchpad.dataformat.WatsonTraitsWrapper;

import twitter4j.JSONArray;
import twitter4j.JSONException;
import twitter4j.JSONObject;

@Service
public class ServiceImpl {

	public void sortStats() throws IOException {
		List<String> statsAsString = FileUtils.readLines(new File("statsfull.json"), StandardCharsets.UTF_8);
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

	public void arrayHop() {
		int input[] = new int[] { 0, 0, 0 };

		int size = input.length;
		int[] hopCountArr = new int[size];
		int[] pathArr = new int[size];
		for (int i = 1; i < size; i++) {
			hopCountArr[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < size - 1; i++) {
			int numOfHops = hopCountArr[i] + 1;
			int hopCapacity = input[i];
			for (int j = 1; j <= hopCapacity && i + j < size; j++) {
				if (numOfHops < hopCountArr[i + j]) {
					hopCountArr[i + j] = numOfHops;
					pathArr[i + j] = i;
				}
			}
		}
		int pathIndex = size - 1;
		StringBuilder result = new StringBuilder();
		result.append("out");
		result.append(",");
		result.append(pathIndex);
		while (pathIndex != 0) {
			result.append(",");
			result.append(pathArr[pathIndex]);
			pathIndex = pathArr[pathIndex];
		}
		System.out.println(result.reverse().toString());
	}

	public void breakString() {
		String str = "NC43-EB2;49.21716;-122.667252;49.216757;-122.666235";
		// Will break str to "NC43-EB2" and "49.21716" "-122.667252" "49.216757"
		// "-122.666235"
		String[] allValues = str.split(";", -1);
		String[] nameValuePair = allValues[0].split("-");
		// substring selects only the specified portion of string
		String name = nameValuePair[0].substring(1, 4);

		// Since "49.21716" is of type String, we may need it to parse it to
		// data type double if we want to do operations like numeric operations
		double c1 = 0d;
		try {
			c1 = Double.parseDouble(allValues[1]);
		} catch (NumberFormatException e) {
			// TODO: Take corrective measures or simply log the error
		}
	}

	public void exceptionTest() {
		int numOfAvds = 5;
		for (int i = 0; i < numOfAvds; i++) {

			try {
				System.out.println("i : " + i);
				if (i == 2) {
					throw new Exception();
				}
			} catch (Exception e) {
				e.printStackTrace();

			}
		}

	}

	public void genHash(String input) throws NoSuchAlgorithmException {
		MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
		byte[] sha1Hash = sha1.digest(input.getBytes());
		Formatter formatter = new Formatter();
		for (byte b : sha1Hash) {
			formatter.format("%02x", b);
		}
		System.out.println("input : " + input + " hash : " + formatter.toString());
	}

	public void truePalin() {
		String input = "a35%`94bA";
		input = input.replaceAll("[^a-zA-Z]", "");
		input = input.toLowerCase();
		input = "  ";
		System.out.println(new StringBuilder(input).reverse().toString().equals(input));
		// System.out.println(input);
	}

	public void sortedList() {
		// Scanner sc = new Scanner(System.in);
		// String input = sc.nextLine();
		String[] lengths = new String[] { "3", "2" };
		String _1 = "1 2 4";
		String _2 = "4 5";
		int firstLength = Integer.parseInt(lengths[0]);
		int secondLength = Integer.parseInt(lengths[1]);
		List<Integer> firstList = new ArrayList<Integer>();
		List<Integer> secondList = new ArrayList<Integer>();
		String[] firstInput = _1.split(" ");
		for (int i = 0; i < firstLength; i++) {
			firstList.add(Integer.parseInt(firstInput[i]));
		}
		String[] secondInput = _2.split(" ");
		for (int i = 0; i < secondLength; i++) {
			secondList.add(Integer.parseInt(secondInput[i]));
		}

		List<Integer> output = new ArrayList<Integer>();
		output.addAll(firstList);
		output.addAll(secondList);
		Collections.sort(output, Collections.reverseOrder());
		for (Integer i : output) {
			System.out.println(i);
		}
	}

	public void combinations() {
		long currTime = System.currentTimeMillis();
		System.out.println("here");
		int l = 5;
		List<Integer> useLess = new ArrayList<Integer>();
		for (int i = 0; i < l; i++) {
			useLess.add(i);
		}
		/*
		 * Iterator<List<Integer>> iter3 =
		 * Generator.combination(useLess).simple(3-1).iterator();
		 * 
		 * while (iter3.hasNext()) { List<Integer> it = iter3.next(); for(int i
		 * : it){ System.out.print(i+" "); } System.out.println(); }
		 */

		// Iterator<int[]> iter2 = new Combinations(200, 2).iterator();
		ICombinatoricsVector<Integer> initialVector = Factory.createVector(useLess);
		Generator<Integer> gen = Factory.createSimpleCombinationGenerator(initialVector, 1);
		Iterator<ICombinatoricsVector<Integer>> iter4 = gen.iterator();
		while (iter4.hasNext()) {
			ICombinatoricsVector<Integer> li = iter4.next();
			for (int i = 0; i < li.getSize(); i++) {
				System.out.print(useLess.get(li.getValue(i)) + " ");
			}
			System.out.println();
		}
		System.out.println("done");
		Collection<File> files = FileUtils.listFiles(new File("/home/opensam/Programs/stuff/lab4data/latin"), null,
				false);
		for (File file : files) {
			List<String> lines = new ArrayList<String>();
			try {
				lines = FileUtils.readLines(file, StandardCharsets.UTF_8);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (String line : lines) {

				String[] tokens = line.split(">");
				if (tokens.length != 2) {
					return;
				}
				String left = tokens[0].substring(1);
				// System.out.println("Location : " + left);
				String right = tokens[1].trim();
				tokens = right.split(" ");
				int position = 0;
				int tokenLength = tokens.length;
				Map<String, String> map = new HashMap<String, String>();
				Map<String, Integer> tokenMapper = new HashMap<String, Integer>();
				int nGram = 2;
				if (tokenLength >= nGram) {
					for (int j = 0; j < tokenLength - nGram + 1; j++) {
						String w = new String(tokens[j].replaceAll("[^a-zA-Z]", ""));
						if (w.length() > 0) {
							position = j;
							String token = "";

							/*
							 * try { token = right.replaceFirst(w, "").trim(); }
							 * catch (Exception e) {
							 * System.out.println("tokens[j] : " + tokens[j] +
							 * " right : " + right); }
							 */
							/*
							 * if (token.length() > 0) { map.put(w, token); //
							 * System.out.println(w+" : "+token); } right =
							 * token;
							 */
						}
					}
				}
				Map<String, List<String>> outputMap = new HashMap<String, List<String>>();
				for (Entry<String, String> entry : map.entrySet()) {
					String key = entry.getKey();
					String value = entry.getValue();
					String[] in = value.split(" ");
					int length = in.length;
					Map<String, Integer> tMap = new HashMap<String, Integer>();
					if (length > 0) {
						for (String s : in) {
							s = s.replaceAll("[^a-zA-Z]", "");
							if (tMap.containsKey(s)) {
								tMap.put(s, tMap.get(s) + 1);
							} else {
								tMap.put(s, 1);
							}
						}
						Map<String, Integer> trMap = new TreeMap<String, Integer>();
						for (Entry<String, Integer> en : tMap.entrySet()) {
							trMap.put(en.getKey(), en.getValue());
						}

						List<String> words = new ArrayList<String>();
						List<Integer> counts = new ArrayList<Integer>();

						for (Entry<String, Integer> en : trMap.entrySet()) {
							words.add(en.getKey());
							counts.add(en.getValue());
						}

						length = words.size();
						// int nGram = 2;
						if (length >= nGram - 1) {
							Iterator<int[]> iter = new Combinations(length, nGram - 1).iterator();
							int count = 0;
							while (iter.hasNext()) {
								int[] it = iter.next();
								StringBuilder str = new StringBuilder();
								int min = Integer.MAX_VALUE;
								for (int i = 0; i < it.length; i++) {
									String word = words.get(it[i]);
									int cot = counts.get(it[i]);
									if (cot < min) {
										min = cot;
									}
									str.append(word).append("  ");
								}
								if (str.length() > 0) {
									str.deleteCharAt(str.length() - 1);
								}
								String gram = str.toString();
								if (map.containsKey(gram)) {
									List<String> pos = outputMap.get(gram);
									pos.add("");
								} else {
									List<String> newPos = new ArrayList<String>();
									newPos.add("");
									outputMap.put(gram, newPos);
								}
								// System.out.println(key + " : " +
								// str.toString());
								count++;
							}
							// System.out.println("length : " + length + " count
							// : " +
							// count);
						}
					}
				}

			}
		}
		System.out.println("Time taken : " + (System.currentTimeMillis() - currTime) + "ms");
	}

	public void watsonJsonApiReader() throws IOException {
		String watsonApiStr = "";
		try {
			watsonApiStr = FileUtils.readFileToString(
					new File("/media/opensam/Acad/UB/Spring2017Courses/706/final/BJP4India_Personality"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		JSONObject object = null;
		try {
			object = new JSONObject(watsonApiStr);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		ArrayList<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		try {
			do {
				dataList = getData(object.getJSONObject("tree").getJSONArray("children"), dataList,
						object.getJSONObject("tree"));
			} while (object.getJSONObject("tree").getJSONArray("children").length() > 0);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		List<WatsonTraits> traits = new ArrayList<WatsonTraits>();
		WatsonTraitsWrapper traitsWrapper = new WatsonTraitsWrapper();
		String fileName = "csv/BJP4India_Personality_csv";
		FileWriter fileWriter  = new FileWriter(fileName);
		CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator("\n");
		CSVPrinter csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);
		List<String> headers = new ArrayList<String>();
		List<Double> values = new ArrayList<Double>();
		for (Map<String, Object> watObj : dataList) {
			for (Entry<String, Object> entry : watObj.entrySet()) {/*
				System.out.println("key : " + entry.getKey());
				System.out.println("value : " + entry.getValue());
			*/
			headers.add(entry.getKey());
			values.add((double)entry.getValue());
			WatsonTraits watsonTraits = new WatsonTraits(entry.getKey(),(double) entry.getValue());	
			traits.add(watsonTraits);
			}
		}
		
		csvFilePrinter.printRecord(headers);
		csvFilePrinter.printRecord(values);
		traitsWrapper.setPersonalityTraits(traits);
		System.out.println(traitsWrapper.getAsJson(traitsWrapper));

	}

	private ArrayList<Map<String, Object>> getData(JSONArray ja, ArrayList<Map<String, Object>> container,
			JSONObject previousObj) {
		try {
			for (int i = 0; i < ja.length(); i++) {
				JSONObject object = ja.getJSONObject(i);
				if (object.has("name") && object.has("id") && object.has("percentage")
						&& object.has("sampling_error")) {
					Map<String, Object> map = new HashMap<String, Object>();
					//map.put("name", object.get("name"));
					//map.put("id", object.get("id"));
					map.put(object.get("id").toString(), object.get("percentage"));
					//map.put("percentage", object.get("percentage"));
					//map.put("sampling_error", object.get("sampling_error"));
					if (!container.contains(map))
						container.add(map);
				}
				if (object.has("children"))
					if (object.getJSONArray("children").length() > 0)
						return getData(object.getJSONArray("children"), container, object);
			}
			previousObj.put("children", new JSONArray());
		} catch (JSONException e) {
		}
		return container;
	}

	public void testMsgPQ() {
		Map<String, PriorityQueue<MsgVO>> map = new HashMap<String, PriorityQueue<MsgVO>>();
		PriorityQueue<MsgVO> p = map.get("123");
		if (p == null) {
			p = new PriorityQueue<MsgVO>();
		}
		MsgVO value = p.peek();
		Map<String, MsgVO> result = new HashMap<String, MsgVO>();
		result.put("123", value);
		String key1 = "key1";
		String key2 = "key2";
		String msg1 = "msg1";
		String msg2 = "msg2";
		String[] messages = new String[] { msg1, msg2 };
		String[] keys = new String[] { key1, key2 };
		for (String key : keys) {
			for (String msg : messages) {
				MsgVO msgVO = new MsgVO(msg);
				PriorityQueue<MsgVO> pq = null;
				if (map.containsKey(key)) {
					pq = map.get(key);
					msgVO.setVersion(pq.peek().getVersion() + 1);
					pq.add(msgVO);
				} else {
					pq = new PriorityQueue<MsgVO>();
					msgVO.setVersion(1);
				}
				pq.add(msgVO);
				map.put(key, pq);
			}
		}
		for (Entry<String, PriorityQueue<MsgVO>> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue().peek().toString());
		}
		try {
			genHash("KBkOLEvbQR0XZEWY6XRr4hgkXNIlmrqL");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void cartesianProduct() {

		Set<String> first = new HashSet<String>();
		first.add("cat");
		first.add("sat");
		Set<String> second = new HashSet<String>();
		second.add("on");
		second.add("the");
		Set<String> third = new HashSet<String>();
		third.add("roof");
		List<Set<String>> l = new ArrayList<Set<String>>();
		// l.add(first);
		l.add(second);
		// l.add(third);
		Set<List<String>> s = com.google.common.collect.Sets.cartesianProduct(l);
		for (List<String> lis : s) {
			for (String str : lis) {
				System.out.print(str + " ");
			}
			System.out.println();
		}
		DateFormat df = new SimpleDateFormat("E MMM dd HH:mm:ss zzz yyyy", Locale.US);
		DateFormat to = new SimpleDateFormat("YYYY-MM-DD");
		to.setTimeZone(TimeZone.getTimeZone("GMT"));
		Calendar cal = Calendar.getInstance();
		try {
			Date date = df.parse("Sat Mar 11 23:59:59 EST 2017");
			cal.setTime(date);
			System.out.println("date is : " + date.toString());
			StringBuilder str = new StringBuilder();
			str.append("2017-");
			str.append("0" + cal.get(Calendar.MONTH)).append("-");
			str.append(cal.get(Calendar.DAY_OF_MONTH));
			System.out.println(str.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String t = "quae,civitate,metuo,cic. quinct. 1 0";
		String[] tokens = t.split(",");
		int length = tokens.length;
		String payLoad = tokens[length - 1];
		String key = t.substring(0,t.length() - payLoad.length() - 1);
		System.out.println(key);
	}

	public void covertDate() {
		File inputFile = new File("/home/opensam/Programs/input/TermProject/output/lm_drive/hashtag/polls_2.json");
		List<String> list = null;
		DateFormat df = new SimpleDateFormat("E MMM dd HH:mm:ss zzz yyyy", Locale.US);
		Calendar cal = Calendar.getInstance();
		try {
			list = FileUtils.readLines(inputFile, StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		ObjectMapper mapper = new ObjectMapper();
		for (String tweet : list) {
			Hashtag hashtag = null;
			try {
				hashtag = mapper.readValue(tweet, Hashtag.class);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
			Date date = null;
			try {
				date = df.parse(hashtag.getDateStr());
				cal.setTime(date);
			} catch (ParseException e) {
				e.printStackTrace();
				return;
			}
			StringBuilder str = new StringBuilder();
			str.append("2017-");
			int month = cal.get(Calendar.MONTH)+1;
			str.append("0" + (month)).append("-");
			int day = cal.get(Calendar.DAY_OF_MONTH);
			if(day<10){
				str.append("0");
			}
			str.append(day);
			hashtag.setDateStr(str.toString());
			try {
				FileUtils.write(new File(inputFile.getAbsolutePath()+"_d"), hashtag.getAsJson(hashtag)+"\n", StandardCharsets.UTF_8, true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
		}

	}

}
