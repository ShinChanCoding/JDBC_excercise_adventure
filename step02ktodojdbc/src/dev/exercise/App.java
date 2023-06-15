package dev.exercise;

import java.util.Scanner;

import dev.exercise.controller.AdventureController;

public class App {

	public static void main(String[] args) {
		AdventureController controller = new AdventureController();
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = 0;
		System.out.println(
				"그 어둠과 신비로움이 뒤섞인 숲 속에서, 용사의 발걸음이 울려퍼진다.\\n그 용사는 모든 어려움을 이겨내고, 공주를 구하기 위한 비법을 알고 있는 유일한 희망이었다. \\n영웅의 용기와 불굴의 결단력이 그를 안내하며, 그의 여정은 모험과 위험으로 가득한 대장정으로 펼쳐질 것이다.");
		System.out.println("모험을 시작하겠습니다.");
		System.out.println("\n");
		while (a != 6) {
			System.out.println("모험을 계속하시겠습니까?(1.모험 계속 진행 2.가방 조회 3.가방 털기 4.물건 판매 6.종료)");
			a = sc.nextInt();
			switch (a) {
			case 1:
				controller.saveItem();
				break;
			case 2:
				controller.findBag();
				break;
			case 3:
				controller.deleteItem();
				break;
			default:
				break;
			}

		}

	}
}
