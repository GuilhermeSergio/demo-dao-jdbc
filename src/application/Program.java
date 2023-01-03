package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: Seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println("\n=== TEST 1: Seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		list.forEach(System.out::println);
		
		System.out.println("\n=== TEST 3: Seller findAll ===");
		list = sellerDao.findAll();
		list.forEach(System.out::println);
		
		System.out.println("\n=== TEST 4: Seller insert ===");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.print("Numero do ID inserido: " + newSeller.getId());
		
		System.out.println("\n=== TEST 5: Seller update ===");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.print("Update completo");
		
		System.out.println("\n=== TEST 6: Seller delete ===");
		System.out.print("Entre com um ID para teste para deletar: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Deletado com sucesso");
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("\n=== TEST 1: Department incluse ===");
		System.out.print("Entre com um nome de departamento para ser incluso: ");
		String departmentStr = sc.next();
		Department departmentObj = new Department(null, departmentStr);
		departmentDao.insert(departmentObj);
		System.out.print("Numero do ID inserido: " + departmentObj.getId());
		
		System.out.println("\n=== TEST 2: Department update ===");
		System.out.print("Entre com ID de um departamento para ser atualizado: ");
		int idDep = sc.nextInt();
		Department updateDep= departmentDao.findById(idDep);
		System.out.print("Entre com nome departamento para ser atualizado: ");
		String nomeDep = sc.next();
		updateDep.setName(nomeDep);
		departmentDao.update(updateDep);
		System.out.print("Update completo");
		
		System.out.println("\n=== TEST 3: Department deleteById ===");
		System.out.print("Entre com ID de um departamento para ser deletado: ");
		int idDepDel = sc.nextInt();
		departmentDao.deleteById(idDepDel);
		System.out.println("Delete completo");
		
		System.out.println("\n=== TEST 4: Department findAll ===");
		List<Department> listDep = new ArrayList<>();
		listDep = departmentDao.findAll();
		listDep.forEach(System.out::println);
		
		sc.close();
	}

}
