package com.scratchpad.service;

import java.io.File;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.json.DataObjectFactory;

/**
 *
 * @author Adhik
 */
public class TwitterStreaming{
    
    private static int count;
    private static PrintWriter writer;  
    private static PrintWriter writer2;
    private static String tweetText;
    private static String tweetJSON;
    
  
    
    private static int countUp(){
        writer2.println(TwitterStreaming.tweetText);
        writer.println(TwitterStreaming.tweetJSON);
        count=count+1;
        return count;
    }
    
    
    

    public static void main(String args[]) throws FileNotFoundException, UnsupportedEncodingException {
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.setDebugEnabled(true)
                .setOAuthConsumerKey("")
                .setOAuthConsumerSecret("")
                .setOAuthAccessToken("")
                .setOAuthAccessTokenSecret("")
                .setJSONStoreEnabled(true);
     
      
        
        
        File file = new File("FF8Json.txt");
        file = new File("FF8.txt");
        TwitterStream twitterStream = new TwitterStreamFactory(configurationBuilder.build()).getInstance();
          
       TwitterStreaming.count=0;
     
        StatusListener listener;
        listener = new StatusListener() {
        	@Override
            public void onStatus(Status status) {
            	try {
					TwitterStreaming.writer  = new PrintWriter("FF8Json.txt", "UTF-8");
					TwitterStreaming.writer2  =new PrintWriter("FF8.txt", "UTF-8");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				} 
                //writer.flush();
                
            	
                
                TwitterStreaming.writer.println(DataObjectFactory.getRawJSON(status));
                TwitterStreaming.writer2.println(status.getLang()+" - "+status.getText());
                TwitterStreaming.count++;
                System.out.println("Count - "+TwitterStreaming.count);
                TwitterStreaming.writer.close();
                TwitterStreaming.writer2.close();
                
                
                //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void onDeletionNotice(StatusDeletionNotice sdn) {
                System.out.println("Status deletion notice"); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void onTrackLimitationNotice(int i) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
            @Override
            public void onScrubGeo(long l, long l1) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void onStallWarning(StallWarning sw) {
                System.out.println("Stall warning"); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void onException(Exception e) {
                System.out.println("Exception occured:" + e.getMessage());
                e.printStackTrace();//To change body of generated methods, choose Tools | Templates.
            }
        };
        FilterQuery qry = new FilterQuery();
              String[] keywords = {"#FastAndFurious8","#FF8","#FastandFurious"};

              qry.track(keywords);

              twitterStream.addListener(listener);
              twitterStream.filter(qry);
              
              
              System.out.println("here");
              
            //  TwitterStreaming.writer.close();
              //TwitterStreaming.writer2.close();
              System.out.println("here2");
}
}