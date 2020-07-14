package br.com.srcsoftware.agenda.moduloagenda.agenda.view;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import br.com.srcsoftware.agenda.moduloagenda.agenda.model.AgendaPO;


public class AgendaForm extends ActionForm{
	
	private String idSelecionar;
	private AgendaPO agenda;
	private ArrayList< AgendaPO > agendas;

	/** SINGLETON */
	public AgendaPO getAgenda() {
		if ( agenda == null ) {
			agenda = new AgendaPO();

		}
		return agenda;
	}

	public void setAgenda( AgendaPO agenda ) {
		this.agenda = agenda;
	}

	public ArrayList< AgendaPO > getAgendas() {
		if ( agendas == null ) {
			agendas = new ArrayList< AgendaPO >();

		}
		return agendas;
	}

	public void setAgendas( ArrayList< AgendaPO > agendas ) {
		this.agendas = agendas;
	}

	public String getIdSelecionar() {
		return idSelecionar;
	}

	public void setIdSelecionar( String idSelecionar ) {
		this.idSelecionar = idSelecionar;
	}

	public void limparTela() {
		setIdSelecionar( null );
		setAgenda( null );
		getAgendas().clear();
	}


}
