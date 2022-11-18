/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author anton
 */
@WebFilter("/UsuarioAutorizacion")
public class UsuarioAutorizacion implements Filter {

    private ServletContext context;
    private String rol;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
        this.context.log("AuthenticationFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        //String uri = req.getRequestURI();

        HttpSession s = req.getSession();
       // UsuarioBean usuarioBean = (UsuarioBean) req.getSession().getAttribute("usuarioBean");

         this.rol = (String) s.getAttribute("rol");
        // System.out.println("rol:" + this.rol);
        System.out.println("rol: " + this.rol);

        if (this.rol != null) {
            
//            switch (rol) {
//                case "Gestor Academico":
//                    resp.sendRedirect(
//                            req.getContextPath() + "/roles/gestorAcademico/pag_incio.xhtml");
//                    break;
//
//                case "Docente":
//                    resp.sendRedirect(
//                            req.getContextPath() + "/hola.xhtml");
//                    break;
//                default:
//                    System.out.println("redirigio");
//                    resp.sendRedirect(req.getContextPath());
//
//            }
            
            if (!this.rol.isEmpty()) {
                
                chain.doFilter(req, resp);
            } else {
                System.out.println("redirigio");
                resp.sendRedirect(req.getContextPath());
            }

        } else {
            System.out.println("redirigio");
            resp.sendRedirect(
                    req.getContextPath());
        }

    }

    @Override
    public void destroy() {
    }

}
