package dev.exercise.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import dev.exercise.dao.AdventureDAO;
import dev.exercise.model.Adventure;
import dev.exercise.view.AdventureView;

public class AdventureController {
	private final AdventureView view;
	private final AdventureDAO dao;
	// 전체 Todo 조회
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
	public AdventureController() {
		view = new AdventureView();
		dao = new AdventureDAO();
	}
	
	public void findBag() {
		List<Adventure> items = dao.findBag();
		if(items != null && items.size() != 0) {
			view.findBag(items);
		}else {
			Exception errorObject = new Exception("아이템이 존재하지 않습니다.");
			view.errorPage(errorObject);
		}
	}
	
	public void findItemById() {
		try {
			System.out.print("id: ");
			int id = Integer.parseInt(bf.readLine());
			Adventure item = dao.findItemById(id);
			view.findItemById(item);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void saveItem() {
		try {
			
			System.out.print("id: ");
			int id = Integer.parseInt(bf.readLine());
			System.out.print("아이템 이름(String): ");
	        String name =bf.readLine();
	        System.out.print("아이템 무게(int): ");
	        int weight = Integer.parseInt(bf.readLine());
	        System.out.print("아이템 가격(int): ");
	        int price = Integer.parseInt(bf.readLine());
			
	        int item = dao.saveItem(id, name, weight, price);
			if(item != 0) {
				view.addItem();
			}else {
				Exception errorObject = new Exception("아이템 저장에 실패했습니다.");
				view.errorPage(errorObject);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void deleteItem() {
		try {
			System.out.print("삭제할 아이템의 id: ");
			int id = Integer.parseInt(bf.readLine());
			int success = dao.deleteItem(id);
			if(success == 1) {
				view.deleteItem(success);
			}else {
				Exception errorObject = new Exception("아이템이 삭제되지 않았습니다.");
				view.errorPage(errorObject);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public int sellItem() {
		int money = 0;
		try {
			System.out.print("판매할 아이템의 id: ");
			int id = Integer.parseInt(bf.readLine());
			int[] success = dao.sellItem(id);
			if(success[1] == 1) {
				view.sellItem();
				money += success[0];
			}else {
				Exception errorObject = new Exception("아이템이 판매되지 않았습니다.");
				view.errorPage(errorObject);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return money;
	}
	public int allPower() {
			int success = dao.allPower();
			if(success != 0) {
				view.allPower(success);
			}else {
				Exception errorObject = new Exception("파워가 조회되지 않았습니다.");
				view.errorPage(errorObject);
			}
			return success;
	}

	public int savePrincess(int totalMoney, int totalPower) {
		int result = dao.savePrincess(totalMoney, totalPower);
		if(result == 1) {
			view.savePrincess();
		}else {
			Exception errorObject = new Exception("공주를 구하기엔 아직 당신은 부족하다....");
			view.errorPage(errorObject);
		}
		return result;
	}
}
