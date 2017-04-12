package com.scratchpad.service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import twitter4j.FilterQuery;
import twitter4j.JSONObject;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.RateLimitStatus;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.auth.OAuth2Token;
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
    
    
    /*private static void  writetweet(String s){
        writer2.println(s);
    }
    
    private static void writeJson(String s){
        writer.println(s);
    } 
    */
    
    private static int countUp(){
        writer2.println(TwitterStreaming.tweetText);
        writer.println(TwitterStreaming.tweetJSON);
        count=count+1;
        return count;
    }
    
    
    

    public static void main(String args[]) throws FileNotFoundException, UnsupportedEncodingException {
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        //configurationBuilder.setApplicationOnlyAuthEnabled(true);
        
        /*OAuth2Token Token = null;
       
            ConfigurationBuilder cb=new ConfigurationBuilder();
            cb.setApplicationOnlyAuthEnabled(true);
            cb.setOAuthConsumerKey("###############");
            cb.setOAuthConsumerSecret("################################");
        try{
            Token = new TwitterFactory(cb.build()).getInstance().getOAuth2Token();
        }catch(Exception e){
            e.printStackTrace();
        } */
        
        configurationBuilder.setDebugEnabled(true)
                .setOAuthConsumerKey("")
                .setOAuthConsumerSecret("")
                .setOAuthAccessToken("")
                .setOAuthAccessTokenSecret("");
     
      
        
        
        
        
        TwitterStream twitterStream = new TwitterStreamFactory(configurationBuilder.build()).getInstance();
          
         
        TwitterStreaming.writer  = new PrintWriter("FF8Json.txt", "UTF-8"); 
        //writer.flush();
        TwitterStreaming.writer2  =new PrintWriter("FF8.txt", "UTF-8");
        
       TwitterStreaming.count=0;
     
        //writer.println("hello :)");
        //writer2.println("Check 123");
        
        StatusListener listener;
        listener = new StatusListener() {
            @Override
            public void onStatus(Status status) {
                
                TwitterStreaming.writer.println(DataObjectFactory.getRawJSON(status));
                TwitterStreaming.writer2.println(status.getLang()+" - "+status.getText());
                TwitterStreaming.count++;
                System.out.println("Count - "+TwitterStreaming.count);
                
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
              
              
              TwitterStreaming.writer.close();
              TwitterStreaming.writer2.close();
}
}