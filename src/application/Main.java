package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entities.Departamento;
import entities.HoraContrato;
import entities.Trabalhador;
import entities.enums.NivelTrabalhador;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("MM/yyyy");
		
		System.out.print("Entre com o Departamento: ");
		String departamento = scan.next();
		
		System.out.println("Dados do Trabalhador");
		System.out.print("Nome: ");
		String nomeTrabalhador = scan.next();
		
		System.out.print("Nível Trabalhador: ");
		String nivelTrabalhador = scan.next();
		
		System.out.print("Salário Base: ");
		double salarioBase = scan.nextDouble();
		
		System.out.println("--------------");
		
		Trabalhador trabalhador = new Trabalhador(nomeTrabalhador, NivelTrabalhador.valueOf(nivelTrabalhador), salarioBase, new Departamento(departamento));
		
		System.out.print("Quantos contratos para " + trabalhador.getNome() + "?: ");
		int quantidadeContratos = scan.nextInt();
		
		for (int i = 0; i < quantidadeContratos; i++) {
			System.out.println("Dados contrato #" + (i + 1));
			System.out.print("Data (DD/MM/AAAA): ");
			LocalDate data = LocalDate.parse(scan.next(), fmt1);
			
			System.out.print("Valor por hora: ");
			double valorPorHora = scan.nextDouble();
			
			System.out.print("Duração (horas): ");
			int horas = scan.nextInt();
			
			HoraContrato contrato = new HoraContrato(data, valorPorHora, horas);
			trabalhador.adicionarContrato(contrato);
			System.out.println("");
		}
		
		System.out.print("Informe o mês e ano para calcular a renda (MM/AAAA): ");
		String[] parts = scan.next().split("/");
		int mes = Integer.parseInt(parts[0]);
		int ano = Integer.parseInt(parts[1]);
		
		System.out.println("Nome: " + trabalhador.getNome());
		System.out.println("Depatamento: " + trabalhador.getDepartamento().getName());
		System.out.println("Renda para " + mes + "/" + ano + ": " + trabalhador.renda(ano, mes));
		
		scan.close();
	}

}
