package br.com.srcsoftware.agenda.moduloagenda.agenda.controller;

import java.util.List;

import br.com.srcsoftware.agenda.moduloagenda.agenda.model.AgendaSERVICE;
import br.com.srcsoftware.manager.abstracts.AbstractPO;
import br.com.srcsoftware.manager.exceptions.BackendException;
import br.com.srcsoftware.manager.interfaces.Crud;

public class AgendaFACADE implements Crud {
	
	/** Garante a aplicação da associação entre o CONTROLLER e o SERVICE */
	private final AgendaSERVICE SERVICE;

	public AgendaFACADE(){
		SERVICE = new AgendaSERVICE();
	}

	@Override
	public void inserir( AbstractPO po ) throws BackendException {
		System.out.println( "FACADE: inserindo" );
		SERVICE.inserir( po );

	}

	@Override
	public void alterar( AbstractPO po ) throws BackendException {
		System.out.println( "FACADE: alterando" );
		SERVICE.alterar( po );

	}

	@Override
	public void excluir( AbstractPO po ) throws BackendException {
		System.out.println( "FACADE: excluindo" );
		SERVICE.excluir( po );

	}

	@Override
	public List filtrar( AbstractPO po ) throws BackendException {
		System.out.println( "FACADE: filtrando" );
		return SERVICE.filtrar( po );
	}

	@Override
	public AbstractPO filtrarPorId( String id ) throws BackendException {
		System.out.println( "FACADE: filtrando por id" );
		return SERVICE.filtrarPorId( id );
	}

}
