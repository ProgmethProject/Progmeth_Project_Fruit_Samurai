
public interface IRenderable extends Comparable<IRenderable> {
	int getZ();

	boolean isVisible();

	void draw();
}
