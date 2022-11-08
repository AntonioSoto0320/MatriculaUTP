package web;

import domain.Cursos;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author anton
 */
@Named
@FacesConverter(value = "cursoConverter", managed = true)
public class CursoConverter implements Converter<Cursos> {

    @Inject
    private CursoBean cursoService;

    @Override
    public Cursos getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null && value.trim().length() > 0) {
            try {
                return cursoService.getCursosAsMap().get(Integer.parseInt(value));
            } catch (NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid country."));
            }
        } else {
            return null;
        }
    }


    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Cursos value) {
        if (value != null) {
            return String.valueOf(value.getIdCursos());
        } else {
            return null;
        }
    }

}
