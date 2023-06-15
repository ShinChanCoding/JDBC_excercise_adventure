package dev.exercise.view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import dev.exercise.model.Adventure;

public class AdventureView {
	// 1. ���� ��ȸ ����� ������
	public void findBag(List<Adventure> items) {
		for (Adventure item : items) {
			System.out.println(String.format("%d ��° �������� %s�Դϴ�.���Դ� %d�̰� ������ %d�Դϴ�.", item.getId(), item.getItem(),
					item.getItem_weight(), item.getItem_price()));
			LocalDateTime localDateTime = item.getInput_time();
			System.out.println("�������� �ֿ� �ð��� ");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd E HH:mm");
			System.out.println(localDateTime.format(formatter));
			System.out.println("�Դϴ�.");
			DateTimeFormatter.ofPattern("�������� �ֿ� �ð��� yyyy�� MM�� dd�� HH�� mm�� ss���Դϴ�.");
//            System.out.println(date.format(formatter));
			System.out.println();
		}
	}

	public void findItemById(Adventure item) {
		System.out.println(String.format("%d ��° �������� %s�Դϴ�.���Դ� %d�̰� ������ %d�Դϴ�.", item.getId(), item.getItem(),
		item.getItem_weight(), item.getItem_price()));
		LocalDateTime localDateTime = item.getInput_time();
		System.out.println("�������� �ֿ� �ð��� ");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd E HH:mm");
		System.out.println(localDateTime.format(formatter));
		System.out.println("�Դϴ�.");
//         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("�������� �ֿ� �ð��� yyyy�� MM�� dd�� HH�� mm�� ss���Դϴ�.");
//         System.out.println(date.format(formatter));
		System.out.println();

//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("�������� �ֿ� �ð��� yyyy�� MM�� dd�� HH�� mm�� ss���Դϴ�.");
//        System.out.println(date.format(formatter));
//        System.out.println();
	}

	public void addItem() {
		System.out.println("�������� �߰� �Ǿ����ϴ�.");
	}

	public void errorPage(Exception error) {
		System.out.println("������ �߻��Ͽ����ϴ�." + error.getMessage());
	}

	public void deleteItem(int affectedRows) {
		System.out.println(affectedRows + "���� ������(row)�� �����Ǿ����ϴ�. ");
	}
}
