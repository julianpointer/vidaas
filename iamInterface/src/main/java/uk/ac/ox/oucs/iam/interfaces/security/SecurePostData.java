package uk.ac.ox.oucs.iam.interfaces.security;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


/**
 * Helper class contains a list of a POST message that has been sent to the web server 
 * and the status of the message's verification
 * 
 * @author oucs0153
 *
 */
public class SecurePostData {
	private boolean messageHasBeenVerified = false;
	private boolean messageTimedOut = false;
	private boolean badSig = false;
	private boolean noPrivateKey = false;
	private String originatorHost = null;
	private List<String> postParms = new ArrayList<String>();
	private static String token_title_message = "Printing data for SecurePostData";
	private static String token_verified = "Verified:";
	private static String token_timeout = "Timeout:";
	private static String token_bad_sig = "Bad sig:";
	private static String token_no_key = "No key:";
	private static String token_originator_host = "Originator Host:";
	
		
	protected void printData(PrintWriter out) {
		out.println(token_title_message);
		out.println(token_verified + messageHasBeenVerified);
		out.println(token_timeout + messageTimedOut);
		out.println(token_bad_sig + badSig);
		out.println(token_no_key + noPrivateKey);
		out.println(token_originator_host + originatorHost);
		for (String s : postParms) {
			out.println(s);
		}
	}
	
	
	
	/**
	 * This method will look at the supplied data string and parse it into a list of SecurePostData objects that
	 * can then be easily queried. 
	 * @param dataString The new line separated data stream that required parsing
	 * @return A list of SecurePostData objects
	 */
	public static List<SecurePostData> getObjectFromString(String dataString) {
		if ( (dataString == null) || (dataString.length() == 0) ) {
			return null;
		}
		
		SecurePostData spd = null;
		List<SecurePostData> spdList = new ArrayList<SecurePostData>();

		for (String s : dataString.split("\n")) {
			if (s.equals(token_title_message)) {
				if (spd != null) {
					spdList.add(spd);
				}
				spd = new SecurePostData();
			}
			else if (s.startsWith(token_verified)) {
				spd.setMessageHasBeenVerified(s.substring(token_verified.length()).equals("true"));
			}
			else if (s.startsWith(token_timeout)) {
				spd.setMessageTimedOut(s.substring(token_timeout.length()).equals("true"));
			}
			else if (s.startsWith(token_bad_sig)) {
				spd.setBadSig(s.substring(token_bad_sig.length()).equals("true"));
			}
			else if (s.startsWith(token_no_key)) {
				spd.setNoPrivateKey(s.substring(token_no_key.length()).equals("true"));
			}
			else if (s.startsWith(token_originator_host)) {
				spd.setOriginatorHost(s.substring(token_originator_host.length()));
			}
			else {
				if (spd != null) {
					spd.addPostParm(s);
				}
			}
		}
		
		if (spd != null) {
			spdList.add(spd);
		}
		
		return spdList;
	}
	
	
	public void setMessageHasBeenVerified(boolean messageHasBeenVerified) {
		this.messageHasBeenVerified = messageHasBeenVerified;
	}
	public void addPostParm(String postParm) {
		postParms.add(postParm);
	}
	public void setMessageTimedOut(boolean messageTimedOut) {
		this.messageTimedOut = messageTimedOut;
	}
	public void setBadSig(boolean badSig) {
		this.badSig = badSig;
	}
	public void setNoPrivateKey(boolean noPrivateKey) {
		this.noPrivateKey = noPrivateKey;
	}


	public boolean isMessageHasBeenVerified() {
		return messageHasBeenVerified;
	}


	public boolean isMessageTimedOut() {
		return messageTimedOut;
	}


	public boolean isBadSig() {
		return badSig;
	}


	public boolean isNoPrivateKey() {
		return noPrivateKey;
	}


	public void setPostParms(List<String> postParms) {
		this.postParms = postParms;
	}
	
	public List<String> getPostParms() {
		return postParms;
	}

	public String getOriginatorHost() {
		return originatorHost;
	}

	public void setOriginatorHost(String originatorHost) {
		this.originatorHost = originatorHost;
	}
}
