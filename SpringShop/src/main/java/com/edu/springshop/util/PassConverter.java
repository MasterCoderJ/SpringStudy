package com.edu.springshop.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.edu.springshop.exception.HashException;

//평문을 해쉬값으로 변경(이떄 개발자는 알고림즘을 선택할 수잇음)
public class PassConverter {
	
	public static String convertHash(String text) throws HashException{

		StringBuilder sb= new StringBuilder();

		try {
			MessageDigest digest= MessageDigest.getInstance("SHA-256");
			
			//일반 스트링 쪼개기
			byte[] hash= digest.digest(text.getBytes("UTF-8"));
			
			
			for(int i=0; i<hash.length; i++) {
				String hex= Integer.toHexString(0xff&hash[i]); //반환 공식 암기!, 16진수 문자열이 만들어짐
				if(hex.length()==1)sb.append("0"); //1자리수는 2자리로
					sb.append(hex);
			}
//			System.out.println(sb.toString().length());
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new HashException("암호화에 실패하였습니다",e);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new HashException("암호화에 실패하였습니다",e);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String hash=convertHash("minzino");
		System.out.println(hash);
	}

}
