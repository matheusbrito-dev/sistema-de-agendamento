package br.com.srcsoftware.agenda.moduloagenda.agenda.view;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import br.com.srcsoftware.agenda.moduloagenda.agenda.controller.AgendaFACADE;
import br.com.srcsoftware.agenda.moduloagenda.agenda.model.AgendaPO;
import br.com.srcsoftware.manager.exceptions.BackendException;
import br.com.srcsoftware.manager.utilidades.Messages;

public class AgendaAction extends DispatchAction{
	
	public ActionForward abrirTela( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {
		//Aplicando Especialização de ActionForm para Agenda Form
		AgendaForm meuForm = (AgendaForm) form;

		meuForm.limparTela();

		return filtrar( mapping, meuForm, request, response );
	}

	public ActionForward filtrar( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {
		try {
			//Aplicando Especialização de ActionForm para Agenda Form
			AgendaForm meuForm = (AgendaForm) form;

			List< AgendaPO > encontrados;

			AgendaFACADE facade = new AgendaFACADE();
			encontrados = facade.filtrar( meuForm.getAgenda() );

			meuForm.getAgendas().clear();
			meuForm.getAgendas().addAll( encontrados );

		} catch ( BackendException e ) {
			e.printStackTrace();
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return mapping.findForward( "agendaView" );
	}

	public ActionForward limpar( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {
		return abrirTela( mapping, form, request, response );
	}

	public ActionForward inserir( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {
		try {
			//Aplicando Especialização de ActionForm para Agenda Form
			AgendaForm meuForm = (AgendaForm) form;

			AgendaFACADE facade = new AgendaFACADE();
			facade.inserir( meuForm.getAgenda() );

			meuForm.limparTela();

			this.addMessages( request, Messages.createMessages( "sucesso" ) );

		} catch ( BackendException e ) {
			e.printStackTrace();
			this.addErrors( request, Messages.createMessagesErrors( "erro", e.getMessage() ) );
		} catch ( Exception e ) {
			e.printStackTrace();
			this.addErrors( request, Messages.createMessagesErrors( "erro", "Erro desconhecido, " + e.getMessage() ) );
		}
		return filtrar( mapping, form, request, response );
	}

	public ActionForward alterar( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {
		try {
			//Aplicando Especialização de ActionForm para Agenda Form
			AgendaForm meuForm = (AgendaForm) form;

			AgendaFACADE facade = new AgendaFACADE();
			facade.alterar( meuForm.getAgenda() );

			meuForm.limparTela();

			this.addMessages( request, Messages.createMessages( "sucesso" ) );

		} catch ( BackendException e ) {
			e.printStackTrace();
			this.addErrors( request, Messages.createMessagesErrors( "erro", e.getMessage() ) );
		} catch ( Exception e ) {
			e.printStackTrace();
			this.addErrors( request, Messages.createMessagesErrors( "erro", "Erro desconhecido, " + e.getMessage() ) );
		}
		return filtrar( mapping, form, request, response );
	}

	public ActionForward excluir( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {
		try {
			//Aplicando Especialização de ActionForm para Agenda Form
			AgendaForm meuForm = (AgendaForm) form;

			AgendaFACADE facade = new AgendaFACADE();
			facade.excluir( meuForm.getAgenda() );

			meuForm.limparTela();

			this.addMessages( request, Messages.createMessages( "sucesso" ) );

		} catch ( BackendException e ) {
			e.printStackTrace();
			this.addErrors( request, Messages.createMessagesErrors( "erro", e.getMessage() ) );
		} catch ( Exception e ) {
			e.printStackTrace();
			this.addErrors( request, Messages.createMessagesErrors( "erro", "Erro desconhecido, " + e.getMessage() ) );
		}
		return filtrar( mapping, form, request, response );
	}

	public ActionForward selecionar( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {
		try {
			//Aplicando Especialização de ActionForm para Agenda Form
			AgendaForm meuForm = (AgendaForm) form;

			AgendaPO encontrado;

			AgendaFACADE facade = new AgendaFACADE();
			encontrado = (AgendaPO) facade.filtrarPorId( meuForm.getIdSelecionar() );

			meuForm.setAgenda( encontrado );

		} catch ( BackendException e ) {
			e.printStackTrace();
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return mapping.findForward( "agendaView" );
	}

}
