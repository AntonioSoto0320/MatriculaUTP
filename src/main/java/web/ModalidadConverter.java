package web;

import domain.Docentes;
import domain.Modalidad;
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
@FacesConverter(value = "modalidadConverter", managed = true)
public class ModalidadConverter implements Converter<Modalidad> {

    @Inject
    private ModalidadBean modalidadService;

    @Override
    public Modalidad getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null && value.trim().length() > 0) {
            try {
                return modalidadService.getModalidadesAsMap().get(Integer.parseInt(value));
            } catch (NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Elige una modalidad"));
            }
        } else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Modalidad value) {
        if (value != null) {
            return String.valueOf(value.getIdModalidad());
        } else {
            return null;
        }
    }

}
