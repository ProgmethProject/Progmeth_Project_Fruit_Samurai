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
	static{
		loadResource();
	}
	
	private static void loadResource() {
		cross = new Image[2];
		cross[0] = new Image(ClassLoader.getSystemResource("black_cross.png").toString());
		cross[1] = new Image(ClassLoader.getSystemResource("red_cross.png").toString());
		fruit = new Image[11];
		fruit[0] = new Image(ClassLoader.getSystemResource("apple.png").toString());
		fruit[1] = new Image(ClassLoader.getSystemResource("banana.png").toString());
		fruit[2] = new Image(ClassLoader.getSystemResource("blackberr.png").toString());
		fruit[3] = new Image(ClassLoader.getSystemResource("fig.png").toString());
		fruit[4] = new Image(ClassLoader.getSystemResource("grapes.png").toString());
		fruit[5] = new Image(ClassLoader.getSystemResource("mango.png").toString());
		fruit[6] = new Image(ClassLoader.getSystemResource("orange.png").toString());
		fruit[7] = new Image(ClassLoader.getSystemResource("peach.png").toString());
		fruit[8] = new Image(ClassLoader.getSystemResource("pineapple.png").toString());
		fruit[9] = new Image(ClassLoader.getSystemResource("raspberry.png").toString());
		fruit[10] = new Image(ClassLoader.getSystemResource("strawberry.png").toString());
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
		Collections.sort(entities,comparator);
		maxZ = entities.get(entities.size() - 2).getZ();
	}

	public List<IRenderable> getEntities() {
		return entities;
	}

	public int getMaxZ() {
		return maxZ;
	}	
	
}
