package br.com.srcsoftware.agenda.moduloagenda.agenda.controller.testabackend;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.srcsoftware.agenda.moduloagenda.agenda.controller.AgendaFACADE;
import br.com.srcsoftware.agenda.moduloagenda.agenda.model.AgendaPO;
import br.com.srcsoftware.manager.exceptions.BackendException;

public class TestaBackEnd {
	
	public static void main( String[ ] args ) {
	
	try {

		/** Criando uma Agenda */
		AgendaPO po = new AgendaPO();
		po.setNomeServico("Jardinagem");
		po.setNomeCliente("Luane");
		po.setNomeExecutor("Pedro e José");
		po.setId(new Long("2"));
		po.setHora("14 horas");
		po.setDataHoraCadrastro(LocalDateTime.now());
		po.setDataToString("31/02/2018");
		
		

		/** Inserir */
		new AgendaFACADE().inserir( po );

		/** Filtrando todos para ver se inseriu */
		List encontrados = new AgendaFACADE().filtrar( null );
		System.out.println( encontrados );

		/** Filtrando por ID para alterar */
		AgendaPO encontrado = (AgendaPO) new AgendaFACADE().filtrarPorId( "2" );

		/** Alterando o Agenda encontrada */
		encontrado.setNomeExecutor( "Pedro Jardineiro Alterado" );
		new AgendaFACADE().alterar( encontrado );
		

		/** Filtrando por ID para verificar alteração e excluir */
		encontrado = (AgendaPO) new AgendaFACADE().filtrarPorId( "2" );

		/** Excluindo */
		new AgendaFACADE().excluir( encontrado );

		/** Filtrando todos para ver se excluiu */
		encontrados = new AgendaFACADE().filtrar( null );
		System.out.println( encontrados );
	} catch ( BackendException e ) {
		e.printStackTrace();
		JOptionPane.showMessageDialog( null, e.getMessage() );
	} catch ( Exception e ) {
		e.printStackTrace();
		JOptionPane.showMessageDialog( null, e.getMessage() );
	}

	}
}
