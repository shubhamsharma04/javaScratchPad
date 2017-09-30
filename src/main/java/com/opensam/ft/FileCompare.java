package com.opensam.ft;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.io.FileUtils;

public class FileCompare {

	public static void main(String[] args) throws IOException {
		Set<String> pl= new HashSet<String>(FileUtils.readLines(new File("//home//opensam//PL.txt"), StandardCharsets.UTF_8));
		Set<String> sh = new HashSet<String>(FileUtils.readLines(new File("//home//opensam//SH.txt"), StandardCharsets.UTF_8));
		System.out.println(pl.size());
		System.out.println(sh.size());
		for(String str : pl){
			if(!sh.contains(str)){
				System.out.println(str);
			}
		}
		
		System.out.println("###########");
		for(String str : sh){
			if(!pl.contains(str)){
				System.out.println(str);
			}
		}
	}

}
