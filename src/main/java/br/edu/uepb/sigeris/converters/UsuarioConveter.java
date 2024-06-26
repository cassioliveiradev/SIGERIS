package br.edu.uepb.sigeris.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.edu.uepb.sigeris.exceptions.SIGERISException;
import br.edu.uepb.sigeris.model.Usuario;
import br.edu.uepb.sigeris.services.UsuarioService;
import br.edu.uepb.sigeris.util.cdi.CDIServiceLocator;

/**
 *
 * @author cassio
 */
@FacesConverter(forClass = Usuario.class)
public class UsuarioConveter implements Converter {

    private final UsuarioService usuarioService;

    public UsuarioConveter() throws SIGERISException {
        this.usuarioService = CDIServiceLocator.getBean(UsuarioService.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        Usuario objectToReturn = null;

        if (value != null) {
            objectToReturn = this.usuarioService.porId(Long.valueOf(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Long code = ((Usuario) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }
}