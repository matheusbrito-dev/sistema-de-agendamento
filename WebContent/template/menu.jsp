<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<div class="navbar-default sidebar" role="navigation">
	<div class="sidebar-nav navbar-collapse">
		<ul class="nav" id="side-menu">
			
			<li>
				<a href="index.html">
					<i class="fa fa-dashboard fa-fw"></i>
					Home
				</a>
			</li>
			<li>
				<a href="#">
					<i class="fa fa-bar-chart-o fa-fw"></i>
					Charts
					<span class="fa arrow"></span>
				</a>
				<ul class="nav nav-second-level">
					<li>
						<a href="flot.html">Flot Charts</a>
					</li>
					<li>
						<a href="morris.html">Morris.js Charts</a>
					</li>
				</ul>
				<!-- /.nav-second-level -->
			</li>
			<li>
				<a href="${rootWeb}/agendaAction.do?method=abrirTela">
					<i class="fa fa-archive fa-fw"></i>
					Agendamento
				</a>
			</li>
			
			
		</ul>
	</div>
	<!-- /.sidebar-collapse -->
</div>
<!-- /.navbar-static-side -->