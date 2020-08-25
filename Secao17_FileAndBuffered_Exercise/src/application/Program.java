package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Product;

public class Program {

	public static void main(String[] args) {		
		
		List<Product> list = new ArrayList<>();
		
		String path = "E:\\Java\\Curso Java_Udemy\\Docs\\Secao17\\itensVendidos.csv";
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line = br.readLine();
			
			while (line != null) {
				String aux[] = line.split(",");
				String name = aux[0];
				double price = Double.parseDouble(aux[1]);
				int quantity = Integer.parseInt(aux[2]);
				
				list.add(new Product(name, price, quantity));				
				
				line = br.readLine();
			}			
		}
		catch (IOException e) {
			System.out.println("Error while throwing exception on BufferedReader: " + e.getMessage());
		}
		
		String writePath = "E:\\Java\\Curso Java_Udemy\\Docs\\Secao17\\out";
		
		new File(writePath).mkdir();		
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(writePath + "\\summary.csv", true))){
			for (Product a: list) {
				bw.write(a.getName() + "," + String.format("%.2f", a.finalPrice()));
				bw.newLine();
			}
		}
		
		catch (IOException e) {
			System.out.println("Error while throwing exception on BufferedWriter: " + e.getMessage());
		}
	}
}
