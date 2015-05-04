package cn.edu.zafu;

import java.util.ArrayList;
import java.util.List;

import cn.edu.zafu.model.Screen;
import cn.edu.zafu.util.Generator;

/**
 * @author lizhangqu
 * @description
 * @date
 */
public class Main {
	public static void main(String[] args) {
		new Main().bulid();
	}

	public void bulid() {
		Generator generator = new Generator(320, 480);
		List<Screen> screens = new ArrayList<Screen>();
		Screen screen = null;

		screen = new Screen(320, 400);
		screens.add(screen);
		screen = new Screen(320, 480);
		screens.add(screen);
		screen = new Screen(480, 800);
		screens.add(screen);
		screen = new Screen(480, 854);
		screens.add(screen);
		screen = new Screen(540, 960);
		screens.add(screen);
		screen = new Screen(600, 1024);
		screens.add(screen);
		screen = new Screen(720, 1184);
		screens.add(screen);
		screen = new Screen(720, 1196);
		screens.add(screen);
		screen = new Screen(720, 1280);
		screens.add(screen);
		screen = new Screen(768, 1024);
		screens.add(screen);
		screen = new Screen(768, 1280);
		screens.add(screen);
		screen = new Screen(800, 1280);
		screens.add(screen);
		screen = new Screen(1080, 1812);
		screens.add(screen);
		screen = new Screen(1080, 1920);
		screens.add(screen);
		screen = new Screen(1200, 1920);
		screens.add(screen);
		screen = new Screen(1440, 2560);
		screens.add(screen);
		screen = new Screen(2048, 1536);
		screens.add(screen);
		screen = new Screen(2560, 1600);
		screens.add(screen);
		int size = screens.size();
		for (int i = 0; i < size; i++) {
			String portrait = generator.generateXml(screens.get(i));
			generator.write2File(screens.get(i).getDir(true), portrait);
			
			String landscape = generator.generateXmlLandscape(screens.get(i));
			generator.write2File(screens.get(i).getDir(false), landscape);
			
			System.out.println("create file "+i+" success");

		}
		System.out.println("success");
	}

}
