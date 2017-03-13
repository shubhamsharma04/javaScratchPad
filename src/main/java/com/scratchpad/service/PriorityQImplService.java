package com.scratchpad.service;

import java.util.Arrays;
import java.util.PriorityQueue;

import org.springframework.stereotype.Service;

import com.scratchpad.dataformat.MsgObject;

@Service
public class PriorityQImplService {

	public void process() {
		
		MsgObject a = new MsgObject();
		long id = System.nanoTime();
		a.setMsg("a");
		a.setAgreedId(2);
		a.setpId(2);
		
		MsgObject b = new MsgObject();
		b.setMsg("b");
		b.setAgreedId(3);
		b.setpId(3);
		
		MsgObject c = new MsgObject();
		c.setMsg("c");
		c.setAgreedId(3);
		c.setpId(2);
		
		PriorityQueue<MsgObject> backQ = new PriorityQueue<MsgObject>();
		backQ.add(a);
		backQ.add(a);
		backQ.add(b);
		backQ.add(c);
		/*int size = backQ.size();
		MsgObject[] m =(MsgObject[]) backQ.toArray();
		Arrays.sort(m);
		for(int i= 0;i<size;i++){
			m[i].getMsg();
		}*/
		
		System.out.println(backQ.remove(a));
		System.out.println(backQ.remove(a));
		
		/*while(backQ.peek()!=null){
			MsgObject msgObject = backQ.remove();
			System.out.println(msgObject.getMsg());
			//backQ.
		}*/
	}

	
}
