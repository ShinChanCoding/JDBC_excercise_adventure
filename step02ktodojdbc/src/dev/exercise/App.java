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
				"�� ��Ұ� �ź�ο��� �ڼ��� �� �ӿ���, ����� �߰����� ���������.\\n�� ���� ��� ������� �̰ܳ���, ���ָ� ���ϱ� ���� ����� �˰� �ִ� ������ ����̾���. \\n������ ���� �ұ��� ��ܷ��� �׸� �ȳ��ϸ�, ���� ������ ����� �������� ������ ���������� ������ ���̴�.");
		System.out.println("���� ���� �� ���ָ� ���ϱ� ���� ���⸦ �����ϰڽ��ϴ�.");
		System.out.println("\n");
		while (a != 7) {
			if(success == 1) {
				System.out.println("�����մϴ�");
				break;
			}
			System.out.println("��翩 ������ �����Ͻðڽ��ϱ�?(1.������ ���� ���� 2.���� ��ȸ 3.������ ������ 4.������ �Ǹ� 5.���ݷ� �� �ݾ� ��ȸ 6.���� ���� 7.����)");
			a = sc.nextInt();
			switch (a) {
			case 1:
				controller.saveItem();
				break;
			case 2:
				System.out.println("1.���� ��ü ��ȸ 2.���� 1���� ��ȸ");
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
				System.out.printf("�ݾ��� %d�Դϴ�.\n", totalMoney);
				totalPower = controller.allPower();
				break;
			case 6:
				success = controller.savePrincess(totalMoney, totalPower);
				break;
			case 7:
				System.out.println("�����մϴ�");
				break;
			default:
				break;
			}

		}

	}
}
