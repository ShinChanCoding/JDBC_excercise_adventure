package dev.exercise;

import java.util.Scanner;

import dev.exercise.controller.AdventureController;

public class App {

	public static void main(String[] args) {
		AdventureController controller = new AdventureController();
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = 0;
		int totalMoney = 0;
		int totalPower = 0;
		int success = 0;
		System.out.println(
				"그 어둠과 신비로움이 뒤섞인 숲 속에서, 용사의 발걸음이 울려퍼진다.\\n그 용사는 모든 어려움을 이겨내고, 공주를 구하기 위한 비법을 알고 있는 유일한 희망이었다. \\n영웅의 용기와 불굴의 결단력이 그를 안내하며, 그의 여정은 모험과 위험으로 가득한 대장정으로 펼쳐질 것이다.");
		System.out.println("모험 시작 전 공주를 구하기 위한 무기를 제작하겠습니다.");
		System.out.println("\n");
		while (a != 7) {
			if(success == 1) {
				System.out.println("종료합니다");
				break;
			}
			System.out.println("용사여 무엇을 진행하시겠습니까?(1.아이템 제작 진행 2.가방 조회 3.아이템 버리기 4.아이템 판매 5.공격력 및 금액 조회 6.모험 시작 7.종료)");
			a = sc.nextInt();
			switch (a) {
			case 1:
				controller.saveItem();
				break;
			case 2:
				System.out.println("1.무기 전체 조회 2.무기 1개만 조회");
				int b = sc.nextInt();
				if(b == 1) {
					controller.findBag();
				}else {
					controller.findItemById();;
				}
				break;
			case 3:
				controller.deleteItem();
				break;
			case 4:
				totalMoney += controller.sellItem();
				break;
			case 5:
				System.out.printf("금액은 %d입니다.\n", totalMoney);
				totalPower = controller.allPower();
				break;
			case 6:
				success = controller.savePrincess(totalMoney, totalPower);
				break;
			case 7:
				System.out.println("종료합니다");
				break;
			default:
				break;
			}

		}

	}
}
