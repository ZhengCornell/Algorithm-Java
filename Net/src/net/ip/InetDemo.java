package net.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetDemo {

	public static void main(String[] args) throws UnknownHostException {
	InetAddress addr = InetAddress.getLocalHost();
	System.out.println(addr.getHostAddress());
	System.out.println(addr.getHostName());
	System.out.println(addr.toString());
//	InetAddress addr = InetAddress.getByName("www.google.com");
//	System.out.println(addr.getHostAddress());
//	System.out.println(addr.getHostName());
//	InetAddress addr = InetAddress.getByName("172.217.10.4");
//	System.out.println(addr.getHostAddress());
//	System.out.println(addr.getHostName());
	}

}
