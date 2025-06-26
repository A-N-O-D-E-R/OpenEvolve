package bio.anode.ale.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import bio.anode.ale.core.component.Component;
import bio.anode.ale.core.component.fluidic.Chamber;
import bio.anode.ale.core.component.fluidic.valve.SolenoidValve;
import bio.anode.ale.core.specifications.Model;
import bio.anode.ale.core.specifications.Supplier;

public class TestModelRegistry {

        private static Supplier testSupplier = new Supplier();
        private static List<Model> models;
    
        static {
            models = new LinkedList<>();    
            models.add(new Model(UUID.randomUUID(), "undefined",null, null, Component.class,null));
            models.add(new Model(UUID.randomUUID(), "Chambre test", "chambreRef",testSupplier , Chamber.class, null));
            models.add(new Model(UUID.randomUUID(), "Valve test","Ref.78191",testSupplier, SolenoidValve.class,null));
            models = Collections.unmodifiableList(models);
        }


    private static Map<Class<? extends Component>, List<Model>> modelCache = new HashMap<>();

	public static List<Model> getModelList(Class<? extends Component> composantClass) {
		if (composantClass == null) {
			return models;
		}

		List<Model> result = modelCache.get(composantClass);

		if (result == null) {

			result = new LinkedList<>();

			for (Model model : models) {
				if (model.getComponantClass().isAssignableFrom(composantClass)) {
					result.add(model);
				}
			}

			modelCache.put(composantClass, result);
		}

		return result;
	}

	public static List<Model> getStrictModelList(Class<? extends Component> composantClass) {
		if (composantClass == null) {
			return new LinkedList<>(models);
		}

		List<Model> result = new LinkedList<>();

		for (Model model : models) {
			if (model.getComponantClass().equals(composantClass)) {
				result.add(model);
			}
		}

		return result;
	}

	public static Model getDefaultModel(Class<? extends Component> composantClass) {
		List<Model> models = TestModelRegistry.getStrictModelList(composantClass);

		if (models.size() > 0) {
			return models.get(0);
		}

		models = TestModelRegistry.getModelList(composantClass);
		return models.get(models.size() > 1 ? 1 : 0);
	}

	public static Model getModelById(UUID id) {
		for (Model model : models) {
			if (model.getId().equals(id)) {
				return model;
			}
		}

		return null;
	}

	public static Model getModelByName(String name) {
		for (Model model : models) {
			if (model.getName().equals(name)) {
				return model;
			}
		}

		return null;
	}
}