package net.ip;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class InetSocketAddressDemo01 {

	public static void main(String[] args) throws UnknownHostException {
//		InetAddress addr = InetAddress.getLocalHost();
		InetSocketAddress isa = new InetSocketAddress("dhcp-mcfad-4146.eduroam.cornell.edu",999);
		System.out.println(isa.getHostName());
		System.out.println(isa.getPort());
		InetAddress addr = isa.getAddress();
		
		
	}

}
