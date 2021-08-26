package com.aim.app.ipscan.services;

import java.io.IOException;
import java.net.SocketException;

import org.springframework.stereotype.Service;

@Service
public interface IpScanService {

	void whois() throws SocketException, IOException;
}
