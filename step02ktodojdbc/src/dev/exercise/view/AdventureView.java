package dev.exercise.view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import dev.exercise.model.Adventure;

public class AdventureView {
	// 1. 가방 조회 결과를 포매팅
	public void findBag(List<Adventure> items) {
		for (Adventure item : items) {
			System.out.println(String.format("%d 번째 아이템은 %s입니다.무게는 %d이고 가격은 %d입니다.", item.getId(), item.getItem(),
					item.getItem_weight(), item.getItem_price()));
			LocalDateTime localDateTime = item.getInput_time();
			System.out.println("아이템을 주운 시간은 ");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd E HH:mm");
			System.out.println(localDateTime.format(formatter));
			System.out.println("입니다.");
			DateTimeFormatter.ofPattern("아이템을 주운 시간은 yyyy년 MM월 dd일 HH시 mm분 ss초입니다.");
//            System.out.println(date.format(formatter));
			System.out.println();
		}
	}

	public void findItemById(Adventure item) {
		System.out.println(String.format("%d 번째 아이템은 %s입니다.무게는 %d이고 가격은 %d입니다.", item.getId(), item.getItem(),
		item.getItem_weight(), item.getItem_price()));
		LocalDateTime localDateTime = item.getInput_time();
		System.out.println("아이템을 주운 시간은 ");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd E HH:mm");
		System.out.println(localDateTime.format(formatter));
		System.out.println("입니다.");
//         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("아이템을 주운 시간은 yyyy년 MM월 dd일 HH시 mm분 ss초입니다.");
//         System.out.println(date.format(formatter));
		System.out.println();

//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("아이템을 주운 시간은 yyyy년 MM월 dd일 HH시 mm분 ss초입니다.");
//        System.out.println(date.format(formatter));
//        System.out.println();
	}

	public void addItem() {
		System.out.println("아이템이 추가 되었습니다.");
	}

	public void errorPage(Exception error) {
		System.out.println("문제가 발생하였습니다." + error.getMessage());
	}

	public void deleteItem(int affectedRows) {
		System.out.println(affectedRows + "개의 아이템(row)이 삭제되었습니다. ");
	}
}
