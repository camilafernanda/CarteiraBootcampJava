package br.com.alura.carteira.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.carteira.modelo.TipoTransacao;
import br.com.alura.carteira.modelo.Transacao;

@SuppressWarnings("serial")
@WebServlet("/transacoes")
public class TransacoesServlet extends HttpServlet{
	
	private List<Transacao> transacoes = new ArrayList<>();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setAttribute("transacoes", transacoes);
		
		req.getRequestDispatcher("WEB-INF/jsp/transacoes.jsp").forward(req, res);;
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		try {
			String ticker = req.getParameter("ticker");
			LocalDate data = LocalDate.parse(req.getParameter("data"), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			BigDecimal preco = new BigDecimal(req.getParameter("preco").replace(",", "."));
			int quantidade = Integer.parseInt(req.getParameter("quantidade"));
			TipoTransacao tipo = TipoTransacao.valueOf(req.getParameter("tipo"));
			
			Transacao t1 = new Transacao(
					ticker, 
					preco, 
					quantidade, 
					data, 
					tipo);
			
			transacoes.add(t1);
			
			res.sendRedirect("transacoes");
		} catch (Exception e) {
			res.sendRedirect("transacoes?erro=campo invalido");
		}
	}
}

// Anotações:
// List -> banco de dados em memória (simulação)
// JSTL -> tags java para html
// Tudo que esta na pasta webapp eh acessivel, exceto a pasta WEB-INF
// Deve colocar o arquivo jsp na WEB-INF para que o usuario n acesse, pois
// Ela nao apresenta os comando do Servlet.java

// Só pode ter um únio método service dentro da classe
// Deve converter todas as strings do getParameter para cada tipo 