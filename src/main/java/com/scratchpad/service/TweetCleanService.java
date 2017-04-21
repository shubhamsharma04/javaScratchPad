package com.scratchpad.service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TweetCleanService {

	@Value("${format.tweet.repository.location}")
	private String tweetRepo;

	@Value("${format.tweet.output.location}")
	private String formattedTweetOutputLocation;

	@Value("${format.emoticons.file.location}")
	private String emoticonsFile;

	@Value("${format.kaomojis.file.location}")
	private String kaomojisFile;
	
	public void formatTweets() throws IOException {
	

		List<String> allEmoticons = FileUtils.readLines(new File(emoticonsFile), StandardCharsets.UTF_8);
		List<String> allKaomojis = FileUtils.readLines(new File(kaomojisFile), StandardCharsets.UTF_8);

		Collection<File> allFiles = FileUtils.listFiles(new File(tweetRepo), null, false);
		for (File tweetFile : allFiles) {
			File outputFile = new File(formattedTweetOutputLocation + tweetFile.getName());
			FileUtils.write(outputFile, "", StandardCharsets.UTF_8, false);

			List<String> allTweets = FileUtils.readLines(tweetFile, StandardCharsets.UTF_8);
			List<String> outputTweets = new ArrayList<String>();
			for (String tweet : allTweets) {
				
				for (String emoticon : allEmoticons) {
					if (tweet.contains(emoticon)) {
						if (emoticon.contains(")")) {
							tweet = tweet.replaceAll(emoticon.replaceAll("\\)", "\\\\)"), "");
						} else if (emoticon.contains("}")) {
							tweet = tweet.replaceAll(emoticon.replaceAll("\\}", "\\\\}"), "");
						}

						else if (emoticon.contains("(")) {
							tweet = tweet.replaceAll(emoticon.replaceAll("\\(", "\\\\("), "");
						} else if (emoticon.contains("{")) {
							tweet = tweet.replaceAll(emoticon.replaceAll("\\{", "\\\\{"), "");
						} else if (emoticon.contains("[")) {
							tweet = tweet.replaceAll(emoticon.replaceAll("\\[", "\\\\["), "");
						} else if (emoticon.contains("]")) {
							tweet = tweet.replaceAll(emoticon.replaceAll("\\]", "\\\\]"), "");
						}

						else {
							tweet = tweet.replaceAll(emoticon, "");
						}

					}
				}

				for (String kaomoji : allKaomojis) {
					if (tweet.contains(kaomoji)) {
						if (kaomoji.contains("(") && kaomoji.contains("")) {
							String repKaomoji = kaomoji.replaceAll("\\)", "\\\\)");
							repKaomoji = repKaomoji.replaceAll("\\(", "\\\\(");
							tweet = tweet.replaceAll(repKaomoji, "");
						} else if (kaomoji.contains(")")) {
							try {
								tweet = tweet.replaceAll(kaomoji.replaceAll("\\)", "\\\\)"), "");
							} catch (Exception e) {
								e.printStackTrace();
								/*logger.error(e);
								logger.debug(input);
								logger.debug("Kaomoji : " + kaomoji);
								logger.debug("Replaced Kaomoji : " + kaomoji.replaceAll("\\)", "\\\\)"));*/
							}
						} else if (kaomoji.contains("}")) {
							tweet = tweet.replaceAll(kaomoji.replaceAll("\\}", "\\\\}"), "");
						} else if (kaomoji.contains("(")) {
							tweet = tweet.replaceAll(kaomoji.replaceAll("\\(", "\\\\("), "");
						} else if (kaomoji.contains("{")) {
							tweet = tweet.replaceAll(kaomoji.replaceAll("\\{", "\\\\{"), "");
						} else if (kaomoji.contains("[")) {
							tweet = tweet.replaceAll(kaomoji.replaceAll("\\[", "\\\\["), "");
						} else if (kaomoji.contains("]")) {
							tweet = tweet.replaceAll(kaomoji.replaceAll("\\]", "\\\\]"), "");
						} else {
							tweet = tweet.replaceAll(kaomoji, "");
						}
					}
				}
				
				tweet = tweet.replaceAll("[^a-zA-Z\\s]", "");
				tweet = tweet.replaceAll("\\s{2,}", " ");
				outputTweets.add(tweet);
				
				
			}
			
			FileUtils.writeLines(outputFile, outputTweets, false);
			
			

		}
	}

}
