package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.sun.xml.internal.ws.api.model.wsdl.editable.EditableWSDLService;

import javafx.scene.image.Image;

public class RenderableHolder {
	public static RenderableHolder instance = new RenderableHolder();

	private List<IRenderable> entities;
	private int maxZ;
	private Comparator<IRenderable> comparator;
	private static Image background;
	private static Image[] cross;
	private static Image[] fruit;

	private RenderableHolder() {
		entities = new ArrayList<>();
		maxZ = 0;
		comparator = (IRenderable x, IRenderable y) -> {
			if (x.getZ() > y.getZ())
				return 1;
			else if (x.getZ() == y.getZ())
				return 0;
			else
				return -1;
		};
	}

	static {
		loadResource();
	}

	private static void loadResource() {
		cross = new Image[2];
		cross[0] = new Image(ClassLoader.getSystemResource("image/black_cross.png").toString(),50,50,false,true);
		cross[1] = new Image(ClassLoader.getSystemResource("image/red_cross.png").toString(),50,50,false,true);
		fruit = new Image[11];
		fruit[0] = new Image(ClassLoader.getSystemResource("image/apple.png").toString(), 50, 50, false, true);
		fruit[1] = new Image(ClassLoader.getSystemResource("image/banana.png").toString(), 50, 50, false, true);
		fruit[2] = new Image(ClassLoader.getSystemResource("image/blackberry.png").toString(), 50, 50, false, true);
		fruit[3] = new Image(ClassLoader.getSystemResource("image/fig.png").toString(), 50, 50, false, true);
		fruit[4] = new Image(ClassLoader.getSystemResource("image/grapes.png").toString(), 50, 50, false, true);
		fruit[5] = new Image(ClassLoader.getSystemResource("image/mango.png").toString(), 50, 50, false, true);
		fruit[6] = new Image(ClassLoader.getSystemResource("image/orange.png").toString(), 50, 50, false, true);
		fruit[7] = new Image(ClassLoader.getSystemResource("image/peach.png").toString(), 50, 50, false, true);
		fruit[8] = new Image(ClassLoader.getSystemResource("image/pineapple.png").toString(), 50, 50, false, true);
		fruit[9] = new Image(ClassLoader.getSystemResource("image/raspberry.png").toString(), 50, 50, false, true);
		fruit[10] = new Image(ClassLoader.getSystemResource("image/strawberry.png").toString(), 50, 50, false, true);
	}

	public void addEntity(IRenderable renderable) {
		entities.add(renderable);
		sortEntity();
	}

	public void removeEntity(IRenderable renderable) {
		entities.remove(renderable);
		sortEntity();
	}

	public void removeEntity(int index) {
		entities.remove(index);
		sortEntity();
	}

	public void sortEntity() {
		Collections.sort(entities, comparator);
		maxZ = entities.get(entities.size() - 2).getZ();
	}

	public List<IRenderable> getEntities() {
		return entities;
	}

	public int getMaxZ() {
		return maxZ;
	}

}
