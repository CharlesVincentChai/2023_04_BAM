package bam;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bam_util.Util;

public class Main {
	public static void main(String[] args) {
		System.out.println("== 프로그램 시작 ==");

		Scanner sc = new Scanner(System.in);

		int num = 0;
		List<Article> articles = new ArrayList<>();
		while (true) {
			System.out.printf("명령어) ");
			String cmd = sc.nextLine();
			if (cmd.equals("article write")) {
				
				String regDate = null;
				regDate = Util.getDateStr();
				System.out.printf("제목 : ");
				String title = sc.nextLine();
				System.out.printf("내용 :");
				String body = sc.nextLine();
				num++;
				System.out.printf("%d번 글이 생성되었습니다.\n", num);
				Article article = new Article(num, regDate ,title, body);
				articles.add(article);

			} else if (cmd.equals("exit")) {
				break;
			} else if (cmd.equals("article list")) {
				System.out.println("번호	|	제목	|	작성일	");
				for (int i = num - 1; i >= 0; i--) {
					int id = articles.get(i).num;
					String title = articles.get(i).title;
					String date = articles.get(i).regDate;

					System.out.printf("%d	|	%s	|	%s	\n", id, title, date);
				} 
			}else if (cmd.startsWith("article detail ")) {
				
				String[] cmdBits = cmd.split(" ");
				
				int id = Integer.parseInt(cmdBits[2]);
				
				
				Article foundArticle = null;
				
				for ( Article article : articles ) {
					if (article.num ==id) {
						foundArticle=article;
						break;
					}
				}
				
				if (foundArticle == null) {
					System.out.println("일치하는 번호가 없습니다.");
				}
					System.out.printf("번호 : %d\n", foundArticle.num);
					System.out.printf("작성일 : %s\n", foundArticle.regDate);
					System.out.printf("제목 : %s\n", foundArticle.title);
					System.out.printf("내용 : %s\n", foundArticle.body);
					
				}
		 else{ 
			System.out.println("존재하지 않는 명령어 입니다.");
		}
	}
		

		sc.close();

		System.out.println("== 프로그램 끝 ==");
	}
}

class Article {
	int num;
	String regDate;
	String title;
	String body;
	

	Article(int num, String regDate, String title, String body) {
		this.regDate = regDate;
		this.num = num;
		this.title = title;
		this.body = body;
	}
}


