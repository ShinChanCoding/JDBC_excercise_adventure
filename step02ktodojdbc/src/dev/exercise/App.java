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
				"�� ��Ұ� �ź�ο��� �ڼ��� �� �ӿ���, ����� �߰����� ���������.\\n�� ���� ��� ������� �̰ܳ���, ���ָ� ���ϱ� ���� ����� �˰� �ִ� ������ ����̾���. \\n������ ���� �ұ��� ��ܷ��� �׸� �ȳ��ϸ�, ���� ������ ����� �������� ������ ���������� ������ ���̴�.");
		System.out.println("������ �����ϰڽ��ϴ�.");
		System.out.println("\n");
		while (a != 6) {
			System.out.println("������ ����Ͻðڽ��ϱ�?(1.���� ��� ���� 2.���� ��ȸ 3.���� �б� 4.���� �Ǹ� 6.����)");
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
