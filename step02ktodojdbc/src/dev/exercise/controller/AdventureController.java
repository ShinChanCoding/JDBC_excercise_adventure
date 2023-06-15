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
	// ��ü Todo ��ȸ
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //����
	public AdventureController() {
		view = new AdventureView();
		dao = new AdventureDAO();
	}
	
	public void findBag() {
		List<Adventure> items = dao.findBag();
		if(items != null && items.size() != 0) {
			view.findBag(items);
		}else {
			Exception errorObject = new Exception("�������� �������� �ʽ��ϴ�.");
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
			System.out.print("������ �̸�(String): ");
	        String name =bf.readLine();
	        System.out.print("������ ����(int): ");
	        int weight = Integer.parseInt(bf.readLine());
	        System.out.print("������ ����(int): ");
	        int price = Integer.parseInt(bf.readLine());
			
	        int item = dao.saveItem(id, name, weight, price);
			if(item != 0) {
				view.addItem();
			}else {
				Exception errorObject = new Exception("������ ���忡 �����߽��ϴ�.");
				view.errorPage(errorObject);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void deleteItem() {
		try {
			System.out.print("������ �������� id: ");
			int id = Integer.parseInt(bf.readLine());
			int success = dao.deleteItem(id);
			if(success == 1) {
				view.deleteItem(success);
			}else {
				Exception errorObject = new Exception("�������� �������� �ʾҽ��ϴ�.");
				view.errorPage(errorObject);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public int sellItem() {
		int money = 0;
		try {
			System.out.print("�Ǹ��� �������� id: ");
			int id = Integer.parseInt(bf.readLine());
			int[] success = dao.sellItem(id);
			if(success[1] == 1) {
				view.sellItem();
				money += success[0];
			}else {
				Exception errorObject = new Exception("�������� �Ǹŵ��� �ʾҽ��ϴ�.");
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
				Exception errorObject = new Exception("�Ŀ��� ��ȸ���� �ʾҽ��ϴ�.");
				view.errorPage(errorObject);
			}
			return success;
	}

	public int savePrincess(int totalMoney, int totalPower) {
		int result = dao.savePrincess(totalMoney, totalPower);
		if(result == 1) {
			view.savePrincess();
		}else {
			Exception errorObject = new Exception("���ָ� ���ϱ⿣ ���� ����� �����ϴ�....");
			view.errorPage(errorObject);
		}
		return result;
	}
}
