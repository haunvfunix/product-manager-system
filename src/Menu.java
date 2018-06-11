import java.util.Scanner;

public class Menu {
	static MainTree mt = new MainTree();
	
	public static void main(String[] args) {
		

	    menu();
		int choice = 0;
		while (choice != 8) {

			Scanner sc = new Scanner(System.in);
			try {
				choice = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Nhap sai nhap lai");

			} finally {
				if (choice == 1) {
					insert();
					menu();
				} else if (choice == 2) {
					mt.traverseInOrder(mt.root);

				} else if (choice == 3) {
					mt.traverseLevelOrder();
					menu();

				} else if (choice == 4) {
					System.out.println("Nhap code can tim");
					String code = sc.nextLine();
					NodeTree node = mt.Search(code);
					if(node != null) {
						System.out.printf("| %-8s |%-10s|%-8s|%-8s|%-5s|\n ","pCode","Name","Quantity","Saled","Price");
						System.out.printf("| %-8s |%-10s|%-8d|%-8d|%.2f| \n",
								            node.pro.getBcode(),node.pro.getProdName(),
								            node.pro.getQuantity(),node.pro.getSaled(),
								            node.pro.getPrice());
					}else {
						System.out.println("Khong thay gia tri can tim");
					}
					menu();
				} else if (choice == 5) {
					
					System.out.println("Nhap code can xoa");
					String code = sc.nextLine();
					NodeTree node = mt.Search(code);
					mt.delete(node.pro.getSaled());

					menu();

				} else if (choice == 6) {
					mt.arrNode(mt.root);
					NodeTree node = mt.balancedBST(mt.arr2, 0, mt.arr2.size()-1);
					mt.preOrder(node);
					menu();
				} else if (choice == 7) {
					System.out.println("So san pham la:"+" "+mt.soNode(mt.root)); 
					menu();
				} else if (choice == 8) {

					System.out.println("END");
				}
			}
		}
		

	}

	public static void menu() {
		System.out.println(" _____________________________MENU_________________________________");
		System.out.println("|_____________1.Input & insert data________________________________|");
		System.out.println("|_____________2.In-order traverse__________________________________|");
		System.out.println("|_____________3.Breadth-first traverse_____________________________|");
		System.out.println("|_____________4.Search by pcode____________________________________|");
		System.out.println("|_____________5.Delete by pcode____________________________________|");
		System.out.println("|_____________6.Simply balancing___________________________________|");
		System.out.println("|_____________7.Count number of products___________________________|");
		System.out.println("|_____________8.EXIT_______________________________________________|");
	}

	public static Products inputData(Products product) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập pcode");
		boolean bool = false;
		boolean boolCode = true;
		while (bool == false) {
			String bCode = sc.nextLine();

			if(mt.root == null) {
				product.setBcode(bCode);
				bool = true;
			
			}else if(mt.Search(bCode) != null) {
				System.out.println("Ma da trung");
			}else {	
				product.setBcode(bCode);
				bool = true;
			}

		}
		System.out.println("Nhập tên sản phẩm");
		String pname = sc.nextLine();
		product.setProdName(pname);
		System.out.println("Nhập quantity");
		boolean boolQuantity = false;
		while (boolQuantity == false) {
			try {

				int quantity = Integer.parseInt(sc.nextLine());
				product.setQuantity(quantity);
				boolQuantity = true;

			} catch (NumberFormatException e) {
				System.out.println("Gia tri sai,nhập lại");
			}
		}
		System.out.println("Nhập saled");

		boolean boolsaled = false;
		while (boolsaled == false) {
			try {

				int saled = Integer.parseInt(sc.nextLine());
				if (saled < product.getQuantity()) {
					product.setSaled(saled);
					boolsaled = true;
				} else {
					System.out.println("Gia tri Saled phai nho hon Quantity");
				}
			} catch (NumberFormatException e) {
				System.out.println("Gia tri sai,nhập lại");
			}
		}

		System.out.println("Nhap gia san pham");
		int price = sc.nextInt();
		product.setPrice(price);
		return product;
	}

	public static void insert() {
		Products pro = new Products();
		inputData(pro);
		mt.add(pro);
	}
}
