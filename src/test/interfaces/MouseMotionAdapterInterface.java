package test.interfaces;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public interface MouseMotionAdapterInterface extends MouseMotionListener {
	public default void mouseDragged(MouseEvent e) { };
	public default void mouseMoved(MouseEvent e) { };
}