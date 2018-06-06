/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author RawMa
 */
package Controller.Veiculo;

import bean.Veiculo;
import dao.VeiculoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="ControleVeiculo", urlPatterns={"/ControleVeiculo"})
public class ControleVeiculo extends HttpServlet {

   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
       PrintWriter out = response.getWriter();

       /* REFERENCIAS PARA O ADMINLTE */
       
       String acao = request.getParameter("acao");
     if("salvar".equals(acao)) {
     salvar(request, response);
   } else if ("consultar".equals(acao)) {
     consultar(request, response);
   } else if ("remover".equals(acao)) {
     remover(request, response);
   } else if ("consultarTodos".equals(acao)) {
       consultarTodos(request, response);
   } else if ("alterar".equals(acao)) {
       alterar(request, response);
   }
       else if ("efetuarAlterar".equals(acao)) {
       efetuarAlterar(request, response);
   }
       /**/
   }
private void consultarTodos(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
     response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();

      try {

          VeiculoDAO vdao = new VeiculoDAO();
          List<Veiculo> carros = vdao.consultarTodos();

          out.println("<html>");
          out.println(" <head>");
          out.println(" <title>CarRaws Veículos - Listagem de Veículos</title>");
          out.println(" </head>");
          out.println(" <body>");
          out.println(" <form action='ControleVeiculo' method='post'");
          out.println(" <table width=\"80%\" border=\"1\" bgcolor=\"blue\" align=\"center\">");
          out.println(" <tr>");
          out.println(" <td align=\"center\"><font size=\"10\" color=\"white\">CarRaws Veículos</font></td>");
          out.println(" </tr>");
          out.println(" <tr>");
          out.println(" <td align=\"center\" bgcolor=\"black\"><font size=\"4\" color=\"white\"> Veículos Cadastrados </font></td>");
          out.println(" </tr>");
          out.println(" </table>");
          out.println(" <table width='100%' border='1'");
          out.println(" <tr>");
          out.println(" <th>Ano</th>");
          out.println(" <th>Cor</th>");
          out.println(" <th>Categoria</th>");
          out.println(" <th>Modelo</th>");
          out.println(" <th>Placa</th>");
          out.println(" <th>Disponivel</th>");
          out.println(" <th colspan='3'>Opções</th>");
          out.println(" </tr>");
          for(Veiculo v : carros){
              out.println(" <tr onMouseover=\"this.bgColor='#EEEEEE'\"onMouseout=\"this.bgColor='#FFFFFF'\">");
              out.println(" <td align='center'>" + v.getAno() + "</td>");
              out.println(" <td align='center'>" + v.getCor() + "</td>");
              out.println(" <td align='center'>" + v.getFk_categoria() + "</td>");
              out.println(" <td align='center'>" + v.getModelo() + "</td>");
              out.println(" <td align='center'>" + v.getPlaca() + "</td>");
              out.println(" <td align='center'>" + v.getDisponivel() + "</td>");
//              out.println(" <td align='center'>" + v.getPreco()+ "</td>");
              out.println(" <td align=\"center\"><input type='submit' name='alterar' value='Alterar' onclick=\"this.form.action='ControleVeiculo?acao=alterar&id="+ v.getPlaca() +"'\"></td>");
              out.println(" <td align=\"center\"><input type='submit' name='remover' value='Remover' onclick=\"this.form.action='ControleVeiculo?acao=remover&id="+ v.getPlaca() +"'\"></td>");
              out.println(" </tr>");
          }
          out.println(" <table border='0'>");
          out.println(" <tr>");
          out.println(" <td align='right'>");
          out.println(" <a href='AdminLTE.jsp'>Menu Principal</a>"); /*referenciar o Menu Principal do AminLTE*/
          out.println(" </td>");
          out.println(" <td align='left'>");
          out.println(" <a href='AdminLTE.jsp'>Cadastro de Veículo</a>"); /*Referenciar a Página de Cadastro de Veículo*/
          out.println(" </td>");
          out.println(" </tr>");
          out.println(" </table>");
          out.println(" </form>");
          out.println(" </body>");
          out.println(" </html>");
       }
      catch(Exception ex){
          ex.printStackTrace();
      }
      finally {
           out.close();
       }
   }

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {
   } 

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {
       processRequest(request, response);
   }

   @Override
   public String getServletInfo() {
       return "Short description";
   }

    private void salvar(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void consultar(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void remover(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void alterar(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void efetuarAlterar(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}