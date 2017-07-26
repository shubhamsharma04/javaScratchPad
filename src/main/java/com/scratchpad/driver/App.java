package com.scratchpad.driver;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensam.ft.AddTwoLinkedList;
import com.opensam.ft.GBalanceString;
import com.opensam.ft.ListNode;

public class App {
	 
	final static Logger logger = Logger.getLogger(App.class);

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
		int [] input = new int[]{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9};
		ListNode first = new ListNode(9);
		ListNode iter = first;
		for(int i : input){
			ListNode currNode = new ListNode(9);
			iter.next = currNode;
			iter = currNode;
		}
		ListNode second = new ListNode(1);
		AddTwoLinkedList addTwoLinkedList = new AddTwoLinkedList();
		ListNode result = addTwoLinkedList.addTwoNumbers(first, second);
		while(result!=null){
			System.out.print(result.val+"  ");
			result = result.next;
		}

	}
}
