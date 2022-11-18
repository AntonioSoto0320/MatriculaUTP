/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;
import login.SessionUtils;

/**
 *
 * @author anton
 */
public class LifeCycleListener implements PhaseListener {

    private static final long serialVersionUID = 1L;

    @Override
    public void afterPhase(PhaseEvent event) {
        FacesContext fc = event.getFacesContext();

        String paginaActual = fc.getViewRoot().getViewId();

        boolean esLogin = (paginaActual.lastIndexOf("index.xhtml") > -1);

        HttpSession session = SessionUtils.getSession();
        

        if (esLogin) {
            String redireccion = "";

            if (session.getAttribute("rol").equals("Gestor Academico")) {
                redireccion = "/webapp/pag_inicio.xhtml";
                try {
                FacesContext.getCurrentInstance().getExternalContext().redirect(redireccion);

            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
            }
            

        }
    }

    @Override
    public void beforePhase(PhaseEvent pe) {

    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }

}
