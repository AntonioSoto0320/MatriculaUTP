package web;

import domain.Docentes;
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
@FacesConverter(value = "docenteConverter", managed = true)
public class DocenteConverter implements Converter<Docentes> {

    @Inject
    private DocenteBean docenteService;

    @Override
    public Docentes getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null && value.trim().length() > 0) {
            try {
                return docenteService.getDocentesAsMap().get(Integer.parseInt(value));
            } catch (NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid country."));
            }
        } else {
            return null;
        }
    }


    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Docentes value) {
        if (value != null) {
            return String.valueOf(value.getIdDocentes());
        } else {
            return null;
        }
    }

}
