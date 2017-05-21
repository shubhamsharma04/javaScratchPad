package com.scratchpad.service;

import org.springframework.stereotype.Service;

@Service
public class ServiceForSmallTasks {

	public void convertHexToInt() {
		/*
		 * String [] input = new
		 * String[]{"F9BF","6996","F81F","F99E","EBD7","9669","9FF6","9FF9",
		 * "BDBD"}; for(String in : input){
		 * //System.out.println(Integer.parseInt(in,16)); } ArrayList<Test>
		 * temporalRow = new ArrayList<Test>(); temporalRow.clear(); Test t =
		 * new Test(); t.i = 5; temporalRow.add(t);
		 * //System.out.println(temporalRow.get(0).i); t.i = 6;
		 * //System.out.println(temporalRow.get(0).i); String digitsWithOutComma
		 * = "1000"; StringBuilder str = new StringBuilder(digitsWithOutComma);
		 * str.setCharAt(1, ','); Queue<String> q = new
		 * ArrayBlockingQueue<String>(100);
		 * 
		 * Scanner in = new Scanner(System.in); String any = in.nextLine();
		 * char[] cArray = any.toCharArray(); List<String> output = new
		 * ArrayList<String>(); for(int i=0; i<cArray.length; i++){ if(cArray[i]
		 * >= 'a'){ // Strore a,b,c,d,e
		 * output.add(String.valueOf(10+(cArray[i]-'a'))); } else {
		 * output.add(String.valueOf(cArray[i])); } } for(String s : output){
		 * System.out.println(s); }
		 */

		/*
		 * String inputStr =
		 * "<verg. aen. 1.51>	nimborum in patriam, loca feta furentibus austris,"
		 * ; String [] input = inputStr.split(">"); String left =
		 * input[0].substring(1); String right = input[1].trim();
		 * System.out.println(left+"  :"+right); String docId = ""; int para =
		 * 0; int line = 0; input = left.split("\\."); int length =
		 * input.length; StringBuilder str = new StringBuilder(); for(int
		 * i=0;i<length-2;i++){ str.append(input[i].trim()).append(" "); } docId
		 * = str.toString().trim(); para =
		 * Integer.parseInt(input[length-2].trim()); line =
		 * Integer.parseInt(input[length-1].trim());
		 * System.out.println("docId : "+docId+" para : "+para+" line : "+line);
		 * input = right.split(" "); for(String s : input){ s =
		 * s.replaceAll("[^a-zA-Z]", ""); System.out.println(s); }
		 */

		String line = "<ambrose. ap_david_altera. 1> Fortasse plerosque psalmi titulus offenderit, quem audistis legi, quod uenit ad eum Nathan propheta, cum intrauit ad Betsabee. simul etiam non mediocre scrupulum mouere potuit inperitis euangelii lectio, quae decursa est, in quo aduertistis adulteram Christo oblatam eandemque sine damnatione dimissam. nam profecto si quis ea auribus accipiat otiosis, incentiuum erroris incurrit, cum legit sancti uiri adulterium et adulterae absolutionem, humano propemodum diuinoque lapsus exemplo, quod et homo putauerit adulterium esse faciendum et deus censuerit adulterium non esse damnandum. lubrica igitur ad lapsum uia uel ueniae uel concupiscentiae.";
		String[] input = line.split(">");
		if (input.length == 2) {
			String left = input[0].substring(1);
			String right = input[1].trim();
			input = left.split("\\.");
			int lengthMeta = input.length;
			if (lengthMeta == 3 || lengthMeta == 4) {
				int chapNo = 0;
				int lineNum = 0;
				String author = input[0];
				String docName = input[1];
				if (lengthMeta == 4) {
					try {
						chapNo = Integer.parseInt(input[2].trim());
					} catch (NumberFormatException e) {
						e.printStackTrace();
					}
				}
				try {
					lineNum = Integer.parseInt(input[lengthMeta - 1].trim());
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}

			}
		}
	}
}
class Test {
	public int i;
}