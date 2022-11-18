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

    private String rol;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        HttpSession s = req.getSession();

        this.rol = (String) s.getAttribute("rol");
        System.out.println("rol: " + this.rol);

        if (this.rol != null) {
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
