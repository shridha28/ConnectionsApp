package com.myproject.connections.test.passwordcontroller;

import javax.mail.internet.MimeMessage;

import org.junit.rules.ExternalResource;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.ServerSetup;

public class SmtpServerRule extends ExternalResource {
	private GreenMail smtpServer;
	private int port;

	public SmtpServerRule(int port) {
		this.port = port;
	}

	@Override
	protected void before() throws Throwable {
		super.before();
		smtpServer = new GreenMail(new ServerSetup(port, "127.0.0.1", "smtp"));
		smtpServer.start();
	}

	public MimeMessage[] getMessages() {
		return smtpServer.getReceivedMessages();
	}

	@Override
	protected void after() {
		super.after();
		smtpServer.stop();
	}

}
