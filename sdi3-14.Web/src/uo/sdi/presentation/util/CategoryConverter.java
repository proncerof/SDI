package uo.sdi.presentation.util;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import uo.sdi.infrastructure.Factories;
import uo.sdi.model.Category;

@FacesConverter("CategoryConverter")
public class CategoryConverter implements Converter {

	List<Category> categories = Factories.persistence.getCategoryDao()
			.findAll();

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if(arg2.equals(""))
			return null;
		
		Long id = Long.parseLong(arg2);
		for(Category c : categories)
			if(c.getId().equals (id))
				return c;
		
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if(arg2 != null)
			return ((Category) arg2).getId().toString();
		return "";
	}

}
