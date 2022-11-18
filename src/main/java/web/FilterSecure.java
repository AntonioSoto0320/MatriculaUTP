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


@WebFilter(description = "Filtra el acesso",urlPatterns = {"/javax.faces/*"})
public class FilterSecure implements Filter {

    private ServletContext context;

    public static final String LOGIN_PAGE = "/inicio.xhtml?faces-redirect=true";

    @Override
    public void doFilter(ServletRequest servletRequest,
            ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest
                = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse
                = (HttpServletResponse) servletResponse;

        HttpSession httpSession = httpServletRequest.getSession();

        String requestPath = httpServletRequest.getPathInfo();

        String rol = (String) httpSession.getAttribute("rol");

        // managed bean name is exactly the session attribute name
//        UsuarioBean usuarioBean = (UsuarioBean) httpServletRequest
//                .getSession().getAttribute("usuarioBean");
        if (rol != null) {

            switch (rol) {
                case "Gestor Academico":
                    httpServletResponse.sendRedirect(
                            httpServletRequest.getContextPath() + "/pag_incio.xhtml?faces-redirect=true");
                    break;

                case "Docente":
                    httpServletResponse.sendRedirect(
                            httpServletRequest.getContextPath() + "/docente.xhtml?faces-redirect=true");
                    break;
                default:
                    httpServletResponse.sendRedirect(
                            httpServletRequest.getContextPath() + "/inicio.xhtml?faces-redirect=true");

            }
        } else {
            httpServletResponse.sendRedirect(
                    httpServletRequest.getContextPath() + "/inicio.xhtml?faces-redirect=true");
        }

    }

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        this.context = fConfig.getServletContext();
        this.context.log("AuthenticationFilter initialized");
    }

    @Override
    public void destroy() {
        // close resources
    }

}
