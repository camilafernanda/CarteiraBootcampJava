package br.com.alura.carteira.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.carteira.modelo.TipoTransacao;
import br.com.alura.carteira.modelo.Transacao;

@WebServlet("/transacoes")
public class TransacoesServlet extends HttpServlet{
	
	private List<Transacao> transacoes = new ArrayList<>();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Transacao t1 = new Transacao(
				"ITSA4", 
				new BigDecimal("12.7"), 
				200, 
				LocalDate.now(), 
				TipoTransacao.VENDA);
		
		Transacao t2 = new Transacao(
				"BBSE3", 
				new BigDecimal("23.5"), 
				200, 
				LocalDate.now(), 
				TipoTransacao.COMPRA);
		
		transacoes.add(t1);
		transacoes.add(t2);
		
		req.setAttribute("transacoes", transacoes);
		
		req.getRequestDispatcher("WEB-INF/jsp/transacoes.jsp").forward(req, res);;
	}

}

// Anotações:
// List -> banco de dados em memória (simulação)
// JSTL -> tags java para html
// Tudo que esta na pasta webapp eh acessivel, exceto a pasta WEB-INF
// Deve colocar o arquivo jsp na WEB-INF para que o usuario n acesse, pois
// Ela n]ao apresenta os comando do Servlet.java