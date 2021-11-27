package menu;

public class Menu {
    // 이름
    private String name;

    // 이미지 경로
    private String imageUrl;

    // 가격
    private int price;

    public Menu() {
    }

    public Menu(String name, String imageUrl, int price) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + "," + imageUrl + "," + price + "\n";
    }
}
