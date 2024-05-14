package jmybatis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		DBUtil my = new DBUtil();
		my.init();

		ArrayList<UserDTO> listID = my.loginID();
		ArrayList<UserDTO> listPW = my.loginPW();

		Scanner sc = new Scanner(System.in);
		System.out.println("아이디 입력");
		String id = sc.next();
		System.out.println("비밀번호 입력");
		String pw = sc.next();

		int ok = 0;
		int idok = 0;

		for (int i = 0; i < listID.size(); i++) {
			if (id.equals(listID.get(i))) {
				if (pw.equals(listPW.get(i))) {
					ok = 2;
					break;
				} else {
					ok = 1;
				}
			} else {
				idok = 1;
			}
		}
		if (ok == 2) {
			System.out.println("로그인 성공");
		} else if (ok == 1) {
			System.out.println("비밀번호 오류");
		} else if (idok == 1) {
			System.out.println("존재 하지 않는 아이디 입니다.");
		}

		
		  while (ok==2) { ArrayList<UserDTO> list = my.getUser();
		  
		  System.out.println("[1]삽입 [2]전체조회 [3]수정 [4]삭제 [5]종료"); int choice = sc.nextInt();
		  
		  if (choice==1) {
		  
		  System.out.print("아이디 입력 : "); String user_id = sc.next();
		  System.out.print("비밀번호 입력 : "); String user_pw = sc.next();
		  System.out.print("이름 입력 : "); String name = sc.next();
		  System.out.print("전화번호 입력 (예시:010-1111-1111) : "); String phone = sc.next();
		  System.out.print("등급 입력 : "); String grade = sc.next();
		  System.out.print("나이 입력 : "); int age = sc.nextInt();
		  
		  my.insertUser(user_id, user_pw, name, phone, grade, age); }
		  
		  else if (choice == 2) { System.out.println("전체조회합니다.");
		  
		  System.out.println(list);
		  
		  } else if (choice == 3) { System.out.print("변경할 이름 입력 : "); String name =
		  sc.next(); System.out.print("아이디 입력 : "); String user_id = sc.next();
		  my.updataUser(name, user_id);
		  
		  } else if (choice == 4) { System.out.println("지우고 싶은 아이디 입력 :"); String
		  user_id = sc.next(); my.deleteUser(user_id); } 
		  else if(choice == 5) { System.out.println("종료합니다.");
			  break;
		  }
		  
		  else {
		  System.out.println("잘못된 입력 입니다"); 
		   }
		  
		 }
		System.out.println("Hi");

	}// main

}
