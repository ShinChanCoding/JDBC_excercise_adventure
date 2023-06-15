package dev.exercise.view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import dev.exercise.model.Adventure;

public class AdventureView {
	// 1. ���� ��ȸ ����� ������
	public void findBag(List<Adventure> items) {
		for (Adventure item : items) {
			System.out.println(String.format("%d �� �������� %s�Դϴ�.���Դ� %d�̰� ������ %d�̸� ���ݷ� %d�Դϴ�.", item.getId(), item.getItem(),
			item.getItem_weight(), item.getItem_price(), item.getItem_power()));
			
			LocalDateTime localDateTime = item.getInput_time();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd E HH:mm");
			System.out.println("�������� �߰��� �ð��� " + localDateTime.format(formatter) + "�Դϴ�.");
			System.out.println();
		}
	}

	public void findItemById(Adventure item) {
		System.out.println(String.format("%d �� �������� %s�Դϴ�.���Դ� %d�̰� ������ %d�̸� ���ݷ��� %d�Դϴ�.", item.getId(), item.getItem(),
		item.getItem_weight(), item.getItem_price(), item.getItem_power()));
		
		LocalDateTime localDateTime = item.getInput_time();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd E HH:mm");
		System.out.println("�������� �߰��� �ð��� " + localDateTime.format(formatter) + "�Դϴ�.");
		System.out.println();
	}

	public void addItem() {
		System.out.println("�������� �߰� �Ǿ����ϴ�.");
	}
	public void sellItem() {
		System.out.println("�������� �Ǹ� �Ǿ����ϴ�.");
	}
	public void errorPage(Exception error) {
		System.out.println("������ �߻��Ͽ����ϴ�." + error.getMessage());
	}

	public void deleteItem(int affectedRows) {
		System.out.println(affectedRows + "���� ������(row)�� �����Ǿ����ϴ�. ");
	}

	public void allPower(int success) {
		// TODO Auto-generated method stub
		System.out.printf("��� power�� %d�Դϴ�\n",success);
	}

	public void savePrincess() {
		System.out.println("�̾�ȣ!!! ���ָ� ���ߴ�!!!!!");
	}
}
