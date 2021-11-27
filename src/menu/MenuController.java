package menu;

import constant.Value;
import util.FileUtil;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * @author Jiwon Koo
 * @date 2021-11-28
 */
public class MenuController {
    /**
     * 메뉴 목록을 조회하는 메서드
     *
     * @return ArrayList<Menu>
     * @throws Exception exception
     */
    public ArrayList<Menu> readMenuList() throws Exception {
        ArrayList<Menu> menuList;
        try {
            // 파일에서 읽은 내용 Menu 객체로 변환 후 리스트에 저장
            menuList = getMenuListByStringArrayList(FileUtil.read(Value.MENU_FILE_NAME));
        } catch (FileNotFoundException fileNotFoundException) {
            menuList = null;
            System.out.println("저장된 메뉴가 없습니다.");
        }

        return menuList;
    }

    /**
     * 메뉴를 파일에 저장하는 메서드
     *
     * @param menu Menu
     * @return ArrayList<Menu>
     * @throws Exception exception
     */
    public ArrayList<Menu> saveMenu(Menu menu) throws Exception {
        // 파일에 메뉴 저장
        FileUtil.save(Value.MENU_FILE_NAME, menu.toString());
        // 저장한 결과가 담긴 파일 읽기
        ArrayList<Menu> menuList = getMenuListByStringArrayList(FileUtil.read(Value.MENU_FILE_NAME));
        return menuList;
    }

    /**
     * 문자열 리스트를 Menu 객체로 변환 후 리스트에 저장해 반환하는 메서드
     *
     * @param stringArrayList ArrayList<String>
     * @return ArrayList<Menu>
     */
    public ArrayList<Menu> getMenuListByStringArrayList(ArrayList<String> stringArrayList) {
        ArrayList<Menu> menuList = new ArrayList<>();

        // 파일에서 읽은 내용 Menu 객체로 변환 후 리스트에 저장
        stringArrayList.forEach(content -> {
            String[] contentArray = content.split(",");
            Menu menu = new Menu(contentArray[0], contentArray[1], Integer.parseInt(contentArray[2]));
            menuList.add(menu);
        });

        return menuList;
    }
}
