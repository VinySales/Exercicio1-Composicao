package entities;

import java.util.ArrayList;
import java.util.List;

import entities.enums.NivelTrabalhador;

public class Trabalhador {
	private String nome;
	private NivelTrabalhador nivel;
	private Double salarioBase;
	
	private Departamento departamento;
	private List<HoraContrato> contratos = new ArrayList<HoraContrato>();
	
	public Trabalhador() {
	}

	public Trabalhador(String nome, NivelTrabalhador nivel, Double salarioBase, Departamento departamento) {
		this.nome = nome;
		this.nivel = nivel;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NivelTrabalhador getNivel() {
		return nivel;
	}

	public void setNivel(NivelTrabalhador nivel) {
		this.nivel = nivel;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<HoraContrato> getContratos() {
		return contratos;
	}

	public void adicionarContrato(HoraContrato contrato) {
		contratos.add(contrato);
	}
	
	public void removerContrato(HoraContrato contrato) {
		contratos.remove(contrato);
	}
	
	public double renda(int ano, int mes) {
		double renda = this.salarioBase;
		
		for (HoraContrato horaContrato : contratos) {
			int hc_ano = horaContrato.getData().getYear();
			int hc_mes = horaContrato.getData().getMonthValue();
			
			if (ano ==  hc_ano && mes == hc_mes) {
				renda += horaContrato.valorTotal();
			}
		}
		
		return renda;
	}
}
