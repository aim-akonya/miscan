/**
 * 
 */
package com.aim.app.ipscan.services;

import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;

import org.apache.commons.net.whois.WhoisClient;
import org.springframework.stereotype.Service;

/**
 * @author aim
 *
 */

@Service
public class IpScanServiceImpl implements IpScanService {

	private WhoisClient whois;

	public IpScanServiceImpl() {
		whois = new WhoisClient();
	}

	@Override
	public void whois()
			throws SocketException, IOException{
		whois.connect(WhoisClient.DEFAULT_HOST);
		whois.query("");
		whois.disconnect();
	}

}
