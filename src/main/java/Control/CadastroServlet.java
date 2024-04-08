package Control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Produto;

@WebServlet(urlPatterns={"/CadastroServlet","/insert"})
public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CadastroServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		PrintWriter out = response.getWriter();
		String action = request.getServletPath();
		Produto p = new Produto();;
		
		// verificar requisiçao
		if(action.equals("/insert")) {
			p.setDescricao(request.getParameter("descricao"));
			p.setCategoria(request.getParameter("categoria"));
			String precoStr = request.getParameter("preco");
			Double preco = Double.parseDouble(precoStr);
			p.setPreco(preco);
			
			System.out.println(p.getDescricao());
			System.out.println(p.getCategoria());
			System.out.println(p.getPreco());
			
			
		}else{
			System.out.println("ERROR");
		}
		
		out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Resultado do Cadastro</title>");
        out.println("<link rel ='stylesheet' href ='style.css' ");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Dados Cadastrados com Sucesso:</h2>");
        out.println("<ul>");
        out.println("<li>Descricao " + p.getDescricao() + "</li>");
        out.println("<li>Categoria: " + p.getCategoria() + "</li>");
        out.println("<li>Preço: R$" + p.getPreco() + "</li>");
        out.println("</ul>");
        out.println("<p>Os dados foram cadastrados com sucesso!</p>");
        out.println("<a href='index.html' >Voltar ao Home</a>");
        out.println("</body>");
        out.println("</html>");
	}

}
