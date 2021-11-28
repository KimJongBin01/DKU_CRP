package Login;

import java.io.*;
import java.util.ArrayList;

public class Login {
    private static ArrayList<member> memberArray;
    public Login(){
        memberArray = new ArrayList<>();
    }

    public void readMemberFile(String filePath){
        BufferedReader br;
        try(FileInputStream filereader = new FileInputStream(filePath)) {
            br = new BufferedReader(new InputStreamReader(filereader,"UTF-8"));
            String line = "";
            String[] tmp;
            member member = null;

            // 멤버 객체 static 리스트에 담기
            while((line = br.readLine()) != null) {
                tmp = line.split(",");
                String name = tmp[0];
                String admin = tmp[1];
                String  Id = tmp[2];
                String pw = tmp[3];
                member = new member(name, admin, Id, pw);
                memberArray.add(member);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public member login(String Id, String pw){
        for(member mem : memberArray){
            if(mem.getId().equals(Id)){
                if(mem.getPassword().equals(pw)){
                    System.out.println(mem.getGrade()+": " + mem.getName()+"님 로그인");
                    return mem;
                }
            }
        }
        return null;

    }

    public static void main(String[] args) {
        Login lg = new Login();
        lg.readMemberFile("C:\\Users\\user\\Documents\\programing W2\\JavaSwing_study\\src\\Swing_myStudy\\회원관리.txt");

        lg.login("kjb1234", "2345");
        lg.login("kjw3241", "6985");
        lg.login("khh3456", "0087");
        lg.login("ksi0989", "1124");
        lg.login("kbj8765", "2387");
        lg.login("kbqwe65", "2qw7");

    }
}
