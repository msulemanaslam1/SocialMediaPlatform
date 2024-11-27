package SocialMediaPlatform;

import Model.Database;
import View.Comments;
import View.CustomView;
import View.Welcome;

public class Main {
    public static void main(String[] args) {
         new Welcome(new Database());
//        new CustomView();
    }
}