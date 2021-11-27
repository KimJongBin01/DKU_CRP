import menu.Menu;
import menu.MenuController;

import java.util.ArrayList;

/**
 * 테스트 클래스
 */
public class Test {
    public static void main(String[] args) {
        MenuController menuController = new MenuController();
        Menu menu = new Menu("바나나우유", "aa", 1100);
        try {
            // 1. 메뉴 조회
            ArrayList<Menu> menuList = menuController.readMenuList();

            // 2. 메뉴 저장
            ArrayList<Menu> savedMenuList = menuController.saveMenu(menu);

            savedMenuList.forEach(m -> System.out.print(m.toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
