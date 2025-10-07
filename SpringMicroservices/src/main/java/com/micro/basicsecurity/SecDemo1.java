package com.micro.basicsecurity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;

public class SecDemo1 {
	public static void main(String args[]) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA");
			String s1 = "we are learning java";

			byte[] array = s1.getBytes();

			md.update(array);

			FileOutputStream fos = new FileOutputStream("demo1test");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(s1);
			oos.writeObject(md.digest());
			
			System.out.println("digest ready");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void checkDigest() {
		try {
			FileInputStream fis = new FileInputStream("demo1test");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Object ob1 = ois.readObject();
			String s1 = (String) ob1;
			System.out.println("The value..:" + s1);
			
			// Now I need to check whether the data is not corrupted in transition
			Object ob2 = ois.readObject();
			byte[] array1 = (byte[]) ob2;
			
			MessageDigest md = MessageDigest.getInstance("SHA");
			md.update(s1.getBytes());

			if (MessageDigest.isEqual(md.digest(), array1)) {
				System.out.println("valid");
			} 
			else {
				System.out.println("corrupted");
			}

		} 
		catch (Exception e1) {
			System.out.println("" + e1);
		}

	}
}