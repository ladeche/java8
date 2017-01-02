package test.interfaces;

import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class MouseMotionExample {

	public static void main(String[] args) {
		
		// Le code est le même dans les deux cas mais plus besoin
		// dans le cas 2 de classe abstraite; une simple interface suffit.
		
		// Cas 1 : Classe abstraite
		JFrame frame = new JFrame();

		frame.addMouseMotionListener(new MouseMotionAdapter()
		{
			public void mouseMoved(MouseEvent e) {
				System.out.println(e.getX());
			}
		});
		frame.setTitle("MouseMotionAdapter");
		frame.setBounds(100, 100, 500, 300);
		frame.setVisible(true);
		
		// Cas 2 : Interface
        JFrame frame2 = new JFrame();

        frame2.addMouseMotionListener(
                     new MouseMotionAdapterInterface() {
             public void mouseMoved(MouseEvent e) {
                 System.out.println(e.getX());
             }
         });
         frame2.setTitle("MouseMotionAdapterInterface");
         frame2.setBounds(100, 100, 500, 300);
         frame2.setVisible(true);
	}

}
